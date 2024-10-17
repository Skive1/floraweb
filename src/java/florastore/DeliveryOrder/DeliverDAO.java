/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.DeliveryOrder;

import florastore.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class DeliverDAO {

    public List<DeliverDTO> getDeliveryOrder()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<DeliverDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select EventOrderId, Fullname, Phone, Street, City, DeliveryDate, DeliveryStaffId, Status, Amount, isPaid, Note "
                        + "From EventOrder ";
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int eventOrderId = rs.getInt("EventOrderId");
                    String fullname = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String street = rs.getString("Street");
                    String city = rs.getString("City");
                    Timestamp deliveryDate = rs.getTimestamp("DeliveryDate");
                    int deliveryStaffId = rs.getInt("DeliveryStaffId");
                    String status = rs.getString("Status");
                    double amount = rs.getDouble("Amount");
                    boolean isPaid = rs.getBoolean("isPaid");
                    String note = rs.getString("Note");
                    if ("Chờ giao".equals(status)) {
                        DeliverDTO product = new DeliverDTO(eventOrderId, fullname, phone, street,
                                city, deliveryDate, status, deliveryStaffId, amount, isPaid, note);
                        products.add(product);
                    }
                }//process each record in resultset  
            }//connection has been available 
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
        return products;
    }

    public List<DeliverDTO> getOrder(String getFullname)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<DeliverDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select StaffId From Delivery Where AccountUsername = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, getFullname);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int staffId = rs.getInt("StaffId");
                    sql = "Select EventOrderId, Fullname, Phone, Street, City, DeliveryDate, DeliveryStaffId, Status, Amount, isPaid, Note "
                            + "From EventOrder ";
                    stm = con.prepareStatement(sql);
                    //4. Execute Query
                    rs = stm.executeQuery();
                    //5. process result
                    while (rs.next()) {
                        //. map
                        //get data from Result Set
                        int eventOrderId = rs.getInt("EventOrderId");
                        String fullname = rs.getString("Fullname");
                        String phone = rs.getString("Phone");
                        String street = rs.getString("Street");
                        String city = rs.getString("City");
                        Timestamp deliveryDate = rs.getTimestamp("DeliveryDate");
                        int deliveryStaffId = rs.getInt("DeliveryStaffId");
                        String status = rs.getString("Status");
                        double amount = rs.getDouble("Amount");
                        boolean isPaid = rs.getBoolean("isPaid");
                        String note = rs.getString("Note");
                        if ("Chờ giao".equals(status) && deliveryStaffId == staffId) {
                            DeliverDTO product = new DeliverDTO(eventOrderId, fullname, phone, street,
                                    city, deliveryDate, status, deliveryStaffId, amount, isPaid, note);
                            products.add(product);
                        }
                    }//process each record in resultset  
                }
            }//connection has been available 
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
        return products;
    }

    public boolean markAsGet(int eventOrderID, int staffId) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stmSelect = null;
        PreparedStatement stmSelectId = null;
        PreparedStatement stmUpdate = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sqlSelectId = "Select DeliveryStaffId From EventOrder Where EventOrderId = ?";           //kiểm tra xem DeliveryStaffId có null ko
                stmSelectId = con.prepareStatement(sqlSelectId);
                stmSelectId.setInt(1, eventOrderID);
                rs = stmSelectId.executeQuery();
                if (rs.next()) {
                    int deliveryStaffId = rs.getInt("DeliveryStaffId");
                    if (deliveryStaffId == 0) {                                 //nếu null thì nhận đơn, không thì đã có người khác nhận
                        String sqlUpdate = "Update EventOrder Set DeliveryStaffId = ? Where EventOrderId = ?";
                        stmUpdate = con.prepareStatement(sqlUpdate);
                        stmUpdate.setInt(1, staffId);
                        stmUpdate.setInt(2, eventOrderID);
                        int affectedRow = stmUpdate.executeUpdate();
                        if (affectedRow > 0) {
                            return true;
                        }
                    }

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmSelect != null) {
                stmSelect.close();
            }
            if (stmUpdate != null) {
                stmUpdate.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean markAsDone(int eventOrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        String formattedDateTime = dateTime.format(formatter);
        
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sqlUpdate = "Update EventOrder Set Status = ?, DeliveryDate = ? Where EventOrderId = ?";
                stm = con.prepareStatement(sqlUpdate);
                stm.setString(1, "Đã giao");
                stm.setString(2, formattedDateTime);
                stm.setInt(3, eventOrderID);
                int affectedRow = stm.executeUpdate();

                if (affectedRow > 0) {
                    return true;
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
        return false;
    }

    public int getStaffId(String getFullname) throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select StaffId From Delivery Where AccountUsername = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, getFullname);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("StaffId");
                }//process each record in resultset  
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
        return 0;
    }

    public List<DeliverDTO> getOrderInfo(int eventOrderID)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<DeliverDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT eo.EventOrderId, eo.Fullname, eo.Phone, eo.Street, eo.City, eo.DeliveryDate, "
                        + "eo.DeliveryStaffId, eo.Status, eo.Amount, eo.isPaid, eo.Note, eod.UnitPrice, eod.Quantity, ep.EPName "
                        + "FROM EventOrder eo "
                        + "JOIN EventOrderDetail eod ON eo.EventOrderId = eod.EventOrderId "
                        + "JOIN EventProduct ep ON eod.EventProductID = ep.EPId "
                        + "WHERE eo.EventOrderId = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, eventOrderID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int eventOrderId = rs.getInt("EventOrderId");
                    String fullname = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String street = rs.getString("Street");
                    String city = rs.getString("City");
                    Timestamp deliveryDate = rs.getTimestamp("DeliveryDate");
                    int deliveryStaffId = rs.getInt("DeliveryStaffId");
                    String status = rs.getString("Status");
                    double amount = rs.getDouble("Amount");
                    boolean isPaid = rs.getBoolean("isPaid");
                    String note = rs.getString("Note");
                    double unitPrice = rs.getDouble("UnitPrice");
                    int quantity = rs.getInt("Quantity");
                    String productName = rs.getString("EPName");
                    DeliverDTO product = new DeliverDTO(eventOrderId, fullname, phone, street, city,
                            deliveryDate, status, deliveryStaffId, isPaid, note, unitPrice, amount, quantity, productName);
                    products.add(product);
                }
            }//connection has been available 
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
        return products;
    }

}
