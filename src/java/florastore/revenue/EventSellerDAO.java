/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.revenue;

import florastore.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author acer
 */
public class EventSellerDAO implements Serializable {

    private ArrayList<EventSellerDTO> listEventId;

    public ArrayList<EventSellerDTO> getListEventId() {
        return listEventId;
    }

    private ArrayList<EventSellerRevenueDTO> list;
    public ArrayList<EventSellerRevenueDTO> getListEventRevenue() {
        return list;
    }

    public void loadTop5AmountByMonth(int month, int year, String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select TOP 5 Month(Cast(eo.OrderDate as DATE)) as [Month],ep.EPId, ep.EPName, eod.UnitPrice, SUM(eod.Quantity) as Sold, SUM(eod.Total) as TotalAmount "
                        + "From EventProduct ep "
                        + "join EventOrderDetail eod on ep.EPId = eod.EventProductID "
                        + "join EventOrder eo on eod.EventOrderId = eo.EventOrderId "
                        + "WHERE eo.Status = N'Đã giao' And Month(OrderDate) = ? And Year(OrderDate) = ? And EventEventId = ? "
                        + "GROUP BY ep.EPName, ep.EPId, eod.UnitPrice, Month(Cast(eo.OrderDate as DATE)) "
                        + "ORDER BY Sold desc";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, month);
                stm.setInt(2, year);
                stm.setString(3, id);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    String monthly = rs.getString("Month");
                    String productName = rs.getString("EPName");
                    double unitPrice = rs.getDouble("UnitPrice");
                    int sold = rs.getInt("Sold");
                    float total = rs.getFloat("TotalAmount");
                    EventSellerRevenueDTO items = new EventSellerRevenueDTO(monthly, productName, unitPrice, sold, unitPrice);
                    if (this.list == null) {
                        list = new ArrayList<>();
                    }//end if list is empty
                    list.add(items);
                } //end while loop
            } //end if connection is success

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void loadListEventIdByUsername(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT EventId, EventName "
                        + "FROM Event "
                        + "WHERE AccountUsername = ?";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("EventId");
                    String name = rs.getString("EventName");
                    EventSellerDTO items = new EventSellerDTO(id, name);
                    if (this.listEventId == null) {
                        listEventId = new ArrayList<>();
                    }//end if list is empty
                    listEventId.add(items);
                } //end while loop
            } //end if connection is success
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Integer> getListEventIdBySeller(String username) throws SQLException, NamingException {
        List<Integer> eventIds = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT EventId FROM Event WHERE AccountUsername = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "username");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int eventId = rs.getInt("EventId");
                    eventIds.add(eventId);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return eventIds;
    }

}
