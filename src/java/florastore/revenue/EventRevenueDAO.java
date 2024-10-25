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
public class EventRevenueDAO implements Serializable {

    private ArrayList<EventRevenueDTO> listWeeklyEvent;

    public ArrayList<EventRevenueDTO> getEventAmountByWeek() {
        return listWeeklyEvent;
    }

    private ArrayList<EventRevenueDTO> listMonthlyEvent;

    public ArrayList<EventRevenueDTO> getEventAmountByMonth() {
        return listMonthlyEvent;
    }

    private ArrayList<yearlyRevenueDTO> listEventOfYear;

    public ArrayList<yearlyRevenueDTO> getListYearEvent() {
        return listEventOfYear;
    }

    public void loadTotalEventOfAllMonthByYear(int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
//                String sql = "SELECT Month(Cast(eo.OrderDate as DATE)) AS [Month], "
//                        + "SUM(eod.Total) AS TotalRevenue "
//                        + "FROM EventProduct ep "
//                        + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
//                        + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
//                        + "WHERE eo.Status = 'Đã giao' AND YEAR(OrderDate) = ? "
//                        + "GROUP BY Month(Cast(eo.OrderDate as DATE))";
                String sql = "SELECT "
                        + "Month(Cast(eo.OrderDate as DATE)) AS [Month],"
                        + "SUM(eod.Quantity) AS TotalProductsSold, "
                        + "SUM(eod.Total) AS TotalRevenue "
                        + "FROM EventProduct ep "
                        + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
                        + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
                        + "WHERE eo.Status = N'Đã giao' AND YEAR(OrderDate) = ? "
                        + "GROUP BY Month(Cast(eo.OrderDate as DATE));";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, year);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    int allMonth = rs.getInt("Month");
                    int sold = rs.getInt("TotalProductsSold");
                    float total = rs.getFloat("TotalRevenue");
                    yearlyRevenueDTO items = new yearlyRevenueDTO(allMonth, total, sold);
                    if (this.listEventOfYear == null) {
                        listEventOfYear = new ArrayList<>();
                    }//end if list is empty
                    listEventOfYear.add(items);
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

    public void loadEventAmountByMonth(int month, int year) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT TOP 5 ep.EPId, ep.EPName, eod.UnitPrice, SUM(eod.Quantity) as Sold, SUM(eod.Total) as TotalAmount "
                        + "From EventProduct ep "
                        + "JOIN EventOrderDetail eod on ep.EPId = eod.EventProductID "
                        + "JOIN EventOrder eo on eod.EventOrderId = eo.EventOrderId "
                        + "WHERE eo.Status = N'Đã giao' And Month(OrderDate) = ? And Year(OrderDate) = ? "
                        + "GROUP BY ep.EPName, ep.EPId, eod.UnitPrice";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, month);
                stm.setInt(2, year);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productId = rs.getString("EPId");
                    String productName = rs.getString("EPName");
                    double unitPrice = rs.getDouble("UnitPrice");
                    int sold = rs.getInt("Sold");
                    float total = rs.getFloat("TotalAmount");
                    EventRevenueDTO items = new EventRevenueDTO(productId, productName, unitPrice, sold, unitPrice);
                    if (this.listMonthlyEvent == null) {
                        listMonthlyEvent = new ArrayList<>();
                    }//end if list is empty
                    listMonthlyEvent.add(items);
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

    public void loadEventTotalAmountOfWeek(int year, int month, int from, int to, int day) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "";
                if (from > to) {
                    sql = "SELECT Cast(eo.OrderDate AS DATE) AS OrderDate, ep.EPId, ep.EPName, eod.UnitPrice, SUM(eod.Quantity) AS Sold, SUM(eod.Total) AS TotalAmount "
                            + "FROM EventProduct ep "
                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
                            + "WHERE eo.Status = N'Đã giao' "
                            + "AND YEAR(eo.OrderDate) = ? "
                            + "AND ((DAY(eo.OrderDate) >= ? AND MONTH(eo.OrderDate) = ?) OR (DAY(eo.OrderDate) <= ? AND MONTH(eo.OrderDate) = ?)) AND DATEPART(dw,eo.OrderDate) = ? "
                            + "GROUP BY ep.EPName, ep.EPId, eod.UnitPrice, Cast(eo.OrderDate AS DATE) "
                            + "ORDER BY Sold DESC";
                } else {
                    sql = "SELECT Cast(eo.OrderDate AS DATE) AS OrderDate, "
                            + "ep.EPId, "
                            + "ep.EPName, "
                            + "eod.UnitPrice, "
                            + "SUM(eod.Quantity) AS Sold, "
                            + "SUM(eod.Total) AS TotalAmount "
                            + "FROM EventProduct ep "
                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
                            + "WHERE eo.Status = N'Đã giao' "
                            + "AND YEAR(eo.OrderDate) = ? "
                            + "AND MONTH(eo.OrderDate) = ? "
                            + "AND DAY(eo.OrderDate) BETWEEN ? AND ? AND DATEPART(dw,eo.OrderDate) = ? "
                            + "GROUP BY ep.EPName, ep.EPId, eod.UnitPrice, Cast(eo.OrderDate AS DATE) "
                            + "ORDER BY Sold DESC";
                }

                //2. Create stm obj
                stm = con.prepareStatement(sql);
                if (from > to) {
                    stm.setInt(1, year);
                    stm.setInt(2, from);
                    stm.setInt(3, (month));
                    stm.setInt(4, to);
                    stm.setInt(5, (month + 1));
                    stm.setInt(6, day);
                } else {
                    stm.setInt(1, year);
                    stm.setInt(2, month);
                    stm.setInt(3, from);
                    stm.setInt(4, to);
                    stm.setInt(5, day);
                }
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    Date date = rs.getDate("OrderDate");
                    String id = rs.getString("EPId");
                    String name = rs.getString("EPName");
                    double price = rs.getDouble("UnitPrice");
                    int sold = rs.getInt("Sold");
                    double total = rs.getDouble("TotalAmount");
                    EventRevenueDTO items = new EventRevenueDTO(date, id, name, price, sold, total);
                    if (this.listWeeklyEvent == null) {
                        listWeeklyEvent = new ArrayList<>();
                    }//end if list is empty
                    listWeeklyEvent.add(items);
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

//    public ArrayList<EventRevenueDTO> loadListEventTotalAmountOfWeek(int year, int month, int from, int to, int day) throws SQLException, NamingException {
//        ArrayList<EventRevenueDTO> listWeeklyEvent = new ArrayList<>();  // Initialize empty list
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//
//        try {
//            // 1. Get connection
//            con = DBHelper.getConnection();
//            if (con != null) {
//                String sql = "";
//                if (from > to) {
//                    sql = "SELECT Cast(eo.OrderDate AS DATE) AS OrderDate, ep.EPId, ep.EPName, eod.UnitPrice, SUM(eod.Quantity) AS Sold, SUM(eod.Total) AS TotalAmount "
//                            + "FROM EventProduct ep "
//                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
//                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
//                            + "WHERE eo.Status = 'Đã giao' "
//                            + "AND YEAR(eo.OrderDate) = ? "
//                            + "AND ((DAY(eo.OrderDate) >= ? AND MONTH(eo.OrderDate) = ?) OR (DAY(eo.OrderDate) <= ? AND MONTH(eo.OrderDate) = ?)) AND DATEPART(dw,eo.OrderDate) = ? "
//                            + "GROUP BY ep.EPName, ep.EPId, eod.UnitPrice, Cast(eo.OrderDate AS DATE) "
//                            + "ORDER BY Sold DESC";
//                } else {
//                    sql = "SELECT Cast(eo.OrderDate AS DATE) AS OrderDate, "
//                            + "ep.EPId, "
//                            + "ep.EPName, "
//                            + "eod.UnitPrice, "
//                            + "SUM(eod.Quantity) AS Sold, "
//                            + "SUM(eod.Total) AS TotalAmount "
//                            + "FROM EventProduct ep "
//                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
//                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
//                            + "WHERE eo.Status = 'Đã giao' "
//                            + "AND YEAR(eo.OrderDate) = ? "
//                            + "AND MONTH(eo.OrderDate) = ? "
//                            + "AND DAY(eo.OrderDate) BETWEEN ? AND ? AND DATEPART(dw,eo.OrderDate) = ? "
//                            + "GROUP BY ep.EPName, ep.EPId, eod.UnitPrice, Cast(eo.OrderDate AS DATE) "
//                            + "ORDER BY Sold DESC";
//                }
//
//                // 2. Create stm obj
//                stm = con.prepareStatement(sql);
//
//                // 3. Set parameters
//                if (from > to) {
//                    stm.setInt(1, year);
//                    stm.setInt(2, from);
//                    stm.setInt(3, month);
//                    stm.setInt(4, to);
//                    stm.setInt(5, month + 1);
//                    stm.setInt(6, day);
//                } else {
//                    stm.setInt(1, year);
//                    stm.setInt(2, month);
//                    stm.setInt(3, from);
//                    stm.setInt(4, to);
//                    stm.setInt(5, day);
//                }
//
//                // 4. Execute Query and populate list
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    Date date = rs.getDate("OrderDate");
//                    String id = rs.getString("EPId");
//                    String name = rs.getString("EPName");
//                    double price = rs.getDouble("UnitPrice");
//                    int sold = rs.getInt("Sold");
//                    double total = rs.getDouble("TotalAmount");
//                    EventRevenueDTO items = new EventRevenueDTO(date, id, name, price, sold, total);
//                    listWeeklyEvent.add(items);
//                }
//            }
//        } finally {
//            // Close resources
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//
//        return listWeeklyEvent;  // Return populated list
//    }
    public ArrayList<EventRevenueDTO> loadTotalAmount(int year, int month, int from, int to, int day) throws SQLException, NamingException {
        ArrayList<EventRevenueDTO> listWeeklyRevenueEvent = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            // 1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "";
                if (from > to) {
                    sql = "SELECT "
                            + "SUM(CASE WHEN DATEPART(weekday, eo.OrderDate) = ? THEN eod.Total ELSE 0 END) AS TotalRevenue "
                            + "FROM EventProduct ep "
                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
                            + "WHERE eo.Status = N'Đã giao' "
                            + "AND YEAR(eo.OrderDate) = ? "
                            + "AND ((MONTH(eo.OrderDate) >= ? AND DAY(eo.OrderDate) >= ?) "
                            + "OR (MONTH(eo.OrderDate) = ? AND DAY(eo.OrderDate) <= ?))";
                } else {
                    sql = "SELECT "
                            + "DATEPART(WEEKDAY, eo.OrderDate) AS DayOfWeek, "
                            + "SUM(eod.UnitPrice * eod.Quantity) AS TotalRevenue "
                            + "FROM EventProduct ep "
                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
                            + "WHERE eo.Status = 'Đã giao' "
                            + "AND YEAR(eo.OrderDate) = ? "
                            + "AND MONTH(eo.OrderDate) = ? "
                            + "AND DAY(eo.OrderDate) BETWEEN ? AND ? "
                            + "GROUP BY DATEPART(WEEKDAY, eo.OrderDate) "
                            + "HAVING DATEPART(WEEKDAY, eo.OrderDate) = ?";
                }

                // 2. Create stm obj
                stm = con.prepareStatement(sql);
                // 3. Set parameters
                if (from > to) {
                    stm.setInt(1, day);
                    stm.setInt(2, year);
                    stm.setInt(3, month);
                    stm.setInt(4, from);
                    stm.setInt(5, (month + 1));
                    stm.setInt(6, to);

                } else {
                    stm.setInt(1, year);
                    stm.setInt(2, month);
                    stm.setInt(3, from);
                    stm.setInt(4, to);
                    stm.setInt(5, day);
                }

                // 4. Execute Query and populate list
                rs = stm.executeQuery();
                while (rs.next()) {
//                    Date date = rs.getDate("OrderDate");
//                    String id = rs.getString("EPId");
//                    String name = rs.getString("EPName");
//                    double price = rs.getDouble("UnitPrice");
//                    int sold = rs.getInt("Sold");
                    double total = rs.getDouble("TotalRevenue");
                    EventRevenueDTO items = new EventRevenueDTO(total);
                    listWeeklyRevenueEvent.add(items);
                }
            }
        } finally {
            // Close resources
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
        return listWeeklyRevenueEvent;  // Return populated list
    }

    public double loadEventTotalAmount(int year, int month, int from, int to, int day) throws SQLException, NamingException {
        double totalRevenue = 0.0;  // Initialize total revenue to 0

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            // 1. Get connection
            con = DBHelper.getConnection();

            if (con != null) {
                String sql = "";
                if (from > to) {
                    // Case: Specific weekday across multiple months
                    sql = "SELECT "
                            + "SUM(CASE WHEN DATEPART(weekday, eo.OrderDate) = ? THEN eod.Total ELSE 0 END) AS TotalRevenue "
                            + "FROM EventProduct ep "
                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
                            + "WHERE eo.Status = N'Đã giao' "
                            + "AND YEAR(eo.OrderDate) = ? "
                            + "AND ((MONTH(eo.OrderDate) >= ? AND DAY(eo.OrderDate) >= ?) "
                            + "OR (MONTH(eo.OrderDate) = ? AND DAY(eo.OrderDate) <= ?))";
                } else {
                    // Case: Specific days within a month
                    sql = "SELECT "
                            + "DATEPART(WEEKDAY, eo.OrderDate) AS DayOfWeek, "
                            + "SUM(eod.UnitPrice * eod.Quantity) AS TotalRevenue\n"
                            + "FROM EventProduct ep\n"
                            + "JOIN EventOrderDetail eod ON ep.EPId = eod.EventProductID "
                            + "JOIN EventOrder eo ON eod.EventOrderId = eo.EventOrderId "
                            + "WHERE eo.Status = N'Đã giao' "
                            + "AND YEAR(eo.OrderDate) = ? "
                            + "AND MONTH(eo.OrderDate) = ? "
                            + "AND DAY(eo.OrderDate) BETWEEN ? AND ? "
                            + "GROUP BY DATEPART(WEEKDAY, eo.OrderDate) "
                            + "HAVING DATEPART(WEEKDAY, eo.OrderDate) = ?";
                }

                // 2. Create stm obj
                stm = con.prepareStatement(sql);

                // 3. Set parameters
                if (from > to) {
                    stm.setInt(1, day);
                    stm.setInt(2, year);
                    stm.setInt(3, month);
                    stm.setInt(4, from);
                    stm.setInt(5, (month + 1));
                    stm.setInt(6, to);
                } else {
                    stm.setInt(1, year);
                    stm.setInt(2, month);
                    stm.setInt(3, from);
                    stm.setInt(4, to);
                    stm.setInt(5, day);
                }

                // 4. Execute Query and retrieve total revenue
                rs = stm.executeQuery();
                if (rs.next()) {
                    totalRevenue = rs.getDouble("TotalRevenue");
                }
            }
        } finally {
            // Close resources
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

        return totalRevenue;
    }
}
