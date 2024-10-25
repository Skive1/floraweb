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
import javax.naming.NamingException;

/**
 *
 * @author acer
 */
public class RatesDeliveryPersonDAO implements Serializable {

    private ArrayList<RatesDeliveryPersonDTO> listRate;

    public ArrayList<RatesDeliveryPersonDTO> getListRate() {
        return listRate;
    }

    public void rateStarById(String id) throws SQLException, NamingException {
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
                        this.listRate = new ArrayList<>();
                    }//end if list is empty
                    this.listRate.add(items);
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

    public ArrayList<RatesDeliveryPersonDTO> getRateSummaryByStaffId(String staffId) throws SQLException, NamingException {
        ArrayList<RatesDeliveryPersonDTO> rateSummaryList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
            String sql = "SELECT SUM(RateStar) AS TotalRateStar, COUNT(*) AS TotalRecords "
                    + "FROM RateDelivery "
                    + "WHERE StaffId = ? "
                    + "GROUP BY StaffId";
            stm = con.prepareStatement(sql);
            stm.setString(1, staffId);
            rs = stm.executeQuery();

            while (rs.next()) {
                int totalRateStar = rs.getInt("TotalRateStar");
                int totalRecords = rs.getInt("TotalRecords");

                RatesDeliveryPersonDTO rateSummary = new RatesDeliveryPersonDTO(totalRateStar, totalRecords);
                rateSummaryList.add(rateSummary);
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

        return rateSummaryList;
    }

}
