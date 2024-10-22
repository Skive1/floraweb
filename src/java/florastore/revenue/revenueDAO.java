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
public class revenueDAO implements Serializable {

    private ArrayList<revenueDTO> list;

    public ArrayList<revenueDTO> getMonthList() {
        return list;
    }

    public void loadAmountByMonth(int month, int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT Top 5 Cast(o.OrderDate as DATE) as OrderDate,fp.ProductId, fp.ProductName, od.UnitPrice, SUM(od.Quantity) as Sold, SUM(od.Total) as TotalAmount "
                        + "FROM FlowerProducts fp "
                        + "JOIN OrderDetail od ON fp.ProductId = od.FlowerProductsID "
                        + "JOIN [Order] o ON od.OrderOrderId = o.OrderId "
                        + "WHERE Month(OrderDate) = ? and year(OrderDate)= ? "
                        + "GROUP BY fp.ProductName, fp.ProductId, od.UnitPrice, OrderDate "
                        + "ORDER BY OrderDate asc";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, month);
                stm.setInt(2, year);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    Date orderDate = rs.getDate("OrderDate");
                    int productId = rs.getInt("ProductId");
                    String productName = rs.getString("ProductName");
                    double unitPrice = rs.getDouble("UnitPrice");
                    int sold = rs.getInt("Sold");
                    float total = rs.getFloat("TotalAmount");
                    revenueDTO items = new revenueDTO(orderDate, productId, productName, unitPrice, sold, total);
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

    public double totalMoneyMonth(int month, int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT TOP 5 "
                        + "CAST(o.OrderDate AS DATE) AS OrderDate, "
                        + "fp.ProductId, "
                        + "fp.ProductName, "
                        + "od.UnitPrice, "
                        + "SUM(od.Quantity) AS Sold, "
                        + "SUM(od.Total) AS TotalAmount "
                        + "FROM FlowerProducts fp "
                        + "INNER JOIN OrderDetail od ON fp.ProductId = od.FlowerProductsID "
                        + "INNER JOIN [Order] o ON od.OrderOrderId = o.OrderId "
                        + "WHERE MONTH(OrderDate) = ? and YEAR(OrderDate) = ? "
                        + "GROUP BY fp.ProductId, fp.ProductName, od.UnitPrice, OrderDate "
                        + "ORDER BY SUM(od.Total) DESC;";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, month);
                stm.setInt(2, year);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    return rs.getDouble(1);
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
        return 0;
    }

    public List<revenueDTO> getSalesByMonthAndYear(int month, int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT Top 5 Cast(o.OrderDate as DATE) as OrderDate,fp.ProductId, fp.ProductName, od.UnitPrice, SUM(od.Quantity) as Sold, SUM(od.Total) as TotalAmount "
                        + "FROM FlowerProducts fp "
                        + "JOIN OrderDetail od ON fp.ProductId = od.FlowerProductsID "
                        + "JOIN [Order] o ON od.OrderOrderId = o.OrderId "
                        + "WHERE Month(OrderDate) = ? and year(OrderDate)= ? "
                        + "GROUP BY fp.ProductName, fp.ProductId, od.UnitPrice, OrderDate "
                        + "ORDER BY OrderDate asc";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, month);
                stm.setInt(2, year);
                //3. Excute Query
                rs = stm.executeQuery();
                List<revenueDTO> salesList = new ArrayList<>();
                while (rs.next()) {
                    revenueDTO sale = new revenueDTO(rs.getDate("OrderDate"),
                            rs.getInt("ProductId"),
                            rs.getString("ProductName"),
                            rs.getDouble("UnitPrice"),
                            rs.getInt("Sold"),
                            rs.getFloat("TotalAmount"));
                    salesList.add(sale);
                } //end while loop

                return salesList;
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
        return null;
    }

   
}
