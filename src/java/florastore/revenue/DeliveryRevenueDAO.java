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
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author acer
 */
public class DeliveryRevenueDAO implements Serializable {

    private ArrayList<RatesDeliveryPersonDTO> listRate;

    public ArrayList<RatesDeliveryPersonDTO> getListRate() {
        return listRate;
    }

    private ArrayList<DeliveryRevenueDTO> listTotal;

    public ArrayList<DeliveryRevenueDTO> getlistTotal() {
        return listTotal;
    }
    private ArrayList<DeliveryRevenueDTO> listOrder;

    public ArrayList<DeliveryRevenueDTO> getlistOrder() {
        return listOrder;
    }

    public void countRatingStarById(String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT SUM(RateStar) AS TotalRateStar, COUNT(*) AS TotalRecords "
                        + "FROM RateDelivery "
                        + "WHERE StaffId = ? "
                        + "GROUP BY StaffId";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt("TotalRateStar");
                    int record = rs.getInt("TotalRecords");                  
                    RatesDeliveryPersonDTO items = new RatesDeliveryPersonDTO(total, record);
                    if (this.listRate == null) {
                        listRate = new ArrayList<>();
                    }//end if list is empty
                    listRate.add(items);
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

    public String loadIdByUserName(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String staffId = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT StaffId "
                        + "FROM Delivery "
                        + "WHERE AccountUsername = ?";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setString(1, username);

                //3. Excute Query
                rs = stm.executeQuery();
                if (rs.next()) {
                    staffId = rs.getString("StaffId");
                }
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
        return staffId;
    }

    public void loadTotalRevenueByYear(String id, int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT YEAR(DeliveryDate) AS Year, MONTH(DeliveryDate) AS Month, SUM(Amount) AS TotalRevenue "
                        + "FROM EventOrder "
                        + "WHERE DeliveryStaffId = ? AND Status = N'Đã giao' AND DeliveryOption = N'Delivery' AND YEAR(DeliveryDate) = ? "
                        + "GROUP BY YEAR(DeliveryDate), MONTH(DeliveryDate) "
                        + "ORDER BY Year, Month ASC";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                stm.setInt(2, year);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    int yearly = rs.getInt("Year");
                    int monthly = rs.getInt("Month");
                    double total = rs.getDouble("TotalRevenue");
                    DeliveryRevenueDTO items = new DeliveryRevenueDTO(year, monthly, total);
                    if (this.listTotal == null) {
                        listTotal = new ArrayList<>();
                    }//end if list is empty
                    listTotal.add(items);
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

    public void loadTotalOrderByYear(String id, int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT YEAR(DeliveryDate) AS Year, MONTH(DeliveryDate) AS Month, DeliveryStaffId, COUNT(*) AS TotalOrders "
                        + "FROM EventOrder "
                        + "WHERE DeliveryStaffId = ? AND Status = N'Đã giao' AND DeliveryOption = N'Delivery' AND YEAR(DeliveryDate) = ? "
                        + "GROUP BY YEAR(DeliveryDate), MONTH(DeliveryDate), DeliveryStaffId "
                        + "ORDER BY Year, Month";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                stm.setInt(2, year);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    int yearly = rs.getInt("Year");
                    int monthly = rs.getInt("Month");
                    String deliveryId = rs.getString("DeliveryStaffId");
                    double total = rs.getDouble("TotalOrders");
                    DeliveryRevenueDTO items = new DeliveryRevenueDTO(year, monthly, deliveryId, total);
                    if (this.listOrder == null) {
                        listOrder = new ArrayList<>();
                    }//end if list is empty
                    listOrder.add(items);
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
}
