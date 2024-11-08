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
import javax.naming.NamingException;

/**
 *
 * @author acer
 */
public class yearlyRevenueDAO implements Serializable {

    private ArrayList<yearlyRevenueDTO> getMonthList;

    public ArrayList<yearlyRevenueDTO> getAllMonthList() {
        return getMonthList;
    }

    public void loadTotalAmountOfAllMonthByYear(int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT MONTH(DeliveryDate) AS Month, SUM(TotalAmount) AS TotalAmountPerMonth "
                        + "FROM ( "
                        + "SELECT "
                        + "o.DeliveryDate, "
                        + "fp.ProductId, "
                        + "fp.ProductName, "
                        + "od.UnitPrice, "
                        + "SUM(od.Quantity) AS Sold, "
                        + "SUM(od.Total) AS TotalAmount "
                        + "FROM FlowerProducts fp "
                        + "INNER JOIN OrderDetail od ON fp.ProductId = od.FlowerProductsID "
                        + "INNER JOIN [Order] o ON od.OrderOrderId = o.OrderId "
                        + " WHERE YEAR(DeliveryDate) = ? "
                        + "GROUP BY fp.ProductId, fp.ProductName, od.UnitPrice, o.DeliveryDate "
                        + ") AS Subquery "
                        + "GROUP BY MONTH(DeliveryDate) "
                        + "ORDER BY MONTH(DeliveryDate) ASC";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, year);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    int allMonth = rs.getInt("Month");
                    float total = rs.getFloat("TotalAmountPerMonth");
                    yearlyRevenueDTO items = new yearlyRevenueDTO(allMonth, total);
                    if (this.getMonthList == null) {
                        getMonthList = new ArrayList<>();
                    }//end if list is empty
                    getMonthList.add(items);
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
