/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventOrder;

import florastore.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class EventOrderDAO implements Serializable {

    public boolean saveOrder(EventOrderDTO order)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Insert Into EventOrder( "
                        + "AccountUsername, EventId, Fullname, Phone, Street, City, DeliveryDate, DeliveryOption, Status, Amount, isPaid, PaymentOptions, Note "
                        + ") Values( "
                        + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? "
                        + ")";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, order.getUsername());
                stm.setInt(2, order.getEventId());
                stm.setString(3, order.getFullname());
                stm.setString(4, order.getPhone());
                stm.setString(5, order.getStreet());
                stm.setString(6, order.getCity());
                stm.setNull(7, java.sql.Types.TIMESTAMP);
                stm.setString(8, order.getDeliveryOptions());
                stm.setString(9, order.getStatus());
                stm.setDouble(10, order.getAmmount());
                stm.setBoolean(11, order.isPaid());
                stm.setString(12, order.getPaymentOptions());
                stm.setString(13, order.getNote());
                //4. Execute Query
                int affectedRows = stm.executeUpdate();
                //5. process result
                if (affectedRows > 0) {
                    result = true;
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
        return result;
    }

    public int getEventOrderId(EventOrderDTO order)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select TOP 1 EventOrderId "
                        + "From EventOrder "
                        + "Where AccountUsername = ? "
                        + "AND EventId = ? "
                        + "AND Fullname = ? "
                        + "AND Phone = ? "
                        + "AND Street = ? "
                        + "AND City = ? "
                        + "AND Status = ? "
                        + "AND DeliveryOption = ? "
                        + "AND Amount = ? "
                        + "AND isPaid = ? "
                        + "AND PaymentOptions = ? "
                        + "AND Note = ? "
                        + "ORDER BY EventOrderId DESC";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, order.getUsername());
                stm.setInt(2, order.getEventId());
                stm.setString(3, order.getFullname());
                stm.setString(4, order.getPhone());
                stm.setString(5, order.getStreet());
                stm.setString(6, order.getCity());
                stm.setString(7, order.getStatus());
                stm.setString(8, order.getDeliveryOptions());
                stm.setDouble(9, order.getAmmount());
                stm.setBoolean(10, order.isPaid());
                stm.setString(11, order.getPaymentOptions());
                stm.setString(12, order.getNote());
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                if (rs.next()) {
                    result = rs.getInt("EventOrderId");
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
        return result;
    }

    public List<EventOrderDTO> getPendingOrder(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDTO> orders = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select eo.EventId, EventOrderId, Fullname, Phone, Street, City, OrderDate, DeliveryOption, PaymentOptions, Status, Amount, isPaid, Note, e.EventName "
                        + "From EventOrder eo "
                        + "JOIN [Event] e on e.EventId = eo.EventId "
                        + "Where Status = N'Chờ giao' AND eo.AccountUsername = ? "
                        + "Order by OrderDate desc";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int eventId = rs.getInt("EventId");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String fullname = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Street");
                    String city = rs.getString("City");
                    Timestamp orderDate = rs.getTimestamp("OrderDate");
                    String deliveryOption = rs.getString("DeliveryOption");
                    String paymentOption = rs.getString("PaymentOptions");
                    String status = rs.getString("Status");
                    double amount = rs.getDouble("Amount");
                    boolean isPaid = rs.getBoolean("isPaid");
                    String note = rs.getString("Note");
                    String eventName = rs.getString("EventName");
                    EventOrderDTO order
                            = new EventOrderDTO(username, eventId, eventName, eventOrderId, fullname, phone, address, city, orderDate, null, deliveryOption, paymentOption, status, amount, isPaid, note);
                    orders.add(order);
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
        return orders;
    }

    public List<EventOrderDTO> getConfirmedOrder(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDTO> orders = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select eo.EventId, EventOrderId, Fullname, Phone, Street, City, OrderDate, DeliveryOption, PaymentOptions, Status, Amount, isPaid, Note, e.EventName "
                        + "From EventOrder eo "
                        + "JOIN [Event] e on e.EventId = eo.EventId "
                        + "Where Status = N'Chưa nhận' AND eo.AccountUsername = ? AND eo.DeliveryStaffId IS NULL "
                        + "Order by OrderDate desc";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int eventId = rs.getInt("EventId");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String fullname = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Street");
                    String city = rs.getString("City");
                    Timestamp orderDate = rs.getTimestamp("OrderDate");
                    String deliveryOption = rs.getString("DeliveryOption");
                    String paymentOption = rs.getString("PaymentOptions");
                    String status = rs.getString("Status");
                    double amount = rs.getDouble("Amount");
                    boolean isPaid = rs.getBoolean("isPaid");
                    String note = rs.getString("Note");
                    String eventName = rs.getString("EventName");
                    EventOrderDTO order
                            = new EventOrderDTO(username, eventId, eventName, eventOrderId, fullname, phone, address, city, orderDate, null, deliveryOption, paymentOption, status, amount, isPaid, note);
                    orders.add(order);
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
        return orders;
    }

    public List<EventOrderDTO> getShippingOrder(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDTO> orders = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select eo.EventId, EventOrderId, Fullname, Phone, Street, City, OrderDate, DeliveryOption, PaymentOptions, Status, Amount, isPaid, Note, e.EventName "
                        + "From EventOrder eo "
                        + "JOIN [Event] e on e.EventId = eo.EventId "
                        + "Where Status = N'Chưa nhận' AND eo.DeliveryStaffId IS NOT NULL AND eo.AccountUsername = ? "
                        + "Order by OrderDate desc";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int eventId = rs.getInt("EventId");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String fullname = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Street");
                    String city = rs.getString("City");
                    Timestamp orderDate = rs.getTimestamp("OrderDate");
                    String deliveryOption = rs.getString("DeliveryOption");
                    String paymentOption = rs.getString("PaymentOptions");
                    String status = rs.getString("Status");
                    double amount = rs.getDouble("Amount");
                    boolean isPaid = rs.getBoolean("isPaid");
                    String note = rs.getString("Note");
                    String eventName = rs.getString("EventName");
                    EventOrderDTO order
                            = new EventOrderDTO(username, eventId, eventName, eventOrderId, fullname, phone, address, city, orderDate, null, deliveryOption, paymentOption, status, amount, isPaid, note);
                    orders.add(order);
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
        return orders;
    }

    public List<EventOrderDTO> getReceivedOrder(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDTO> orders = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select eo.EventId, EventOrderId, Fullname, Phone, Street, City, OrderDate, DeliveryDate, DeliveryOption, PaymentOptions, Status, Amount, isPaid, Note, e.EventName "
                        + "From EventOrder eo "
                        + "JOIN [Event] e on e.EventId = eo.EventId "
                        + "Where Status = N'Đã giao' AND eo.AccountUsername = ? "
                        + "Order by DeliveryDate desc";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int eventId = rs.getInt("EventId");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String fullname = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Street");
                    String city = rs.getString("City");
                    Timestamp orderDate = rs.getTimestamp("OrderDate");
                    Timestamp deliveryDate = rs.getTimestamp("DeliveryDate");
                    String deliveryOption = rs.getString("DeliveryOption");
                    String paymentOption = rs.getString("PaymentOptions");
                    String status = rs.getString("Status");
                    double amount = rs.getDouble("Amount");
                    boolean isPaid = rs.getBoolean("isPaid");
                    String note = rs.getString("Note");
                    String eventName = rs.getString("EventName");
                    EventOrderDTO order
                            = new EventOrderDTO(username, eventId, eventName, eventOrderId, fullname, phone, address, city, orderDate, deliveryDate, deliveryOption, paymentOption, status, amount, isPaid, note);
                    orders.add(order);
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
        return orders;
    }

    public List<EventOrderDTO> getCancelledOrder(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDTO> orders = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select eo.EventId, EventOrderId, Fullname, Phone, Street, City, OrderDate, DeliveryOption, PaymentOptions, Status, Amount, isPaid, Note, e.EventName "
                        + "From EventOrder eo "
                        + "JOIN [Event] e on e.EventId = eo.EventId "
                        + "Where Status = N'Hủy' AND eo.AccountUsername = ? "
                        + "Order by OrderDate desc";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int eventId = rs.getInt("EventId");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String fullname = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Street");
                    String city = rs.getString("City");
                    Timestamp orderDate = rs.getTimestamp("OrderDate");
                    String deliveryOption = rs.getString("DeliveryOption");
                    String paymentOption = rs.getString("PaymentOptions");
                    String status = rs.getString("Status");
                    double amount = rs.getDouble("Amount");
                    boolean isPaid = rs.getBoolean("isPaid");
                    String note = rs.getString("Note");
                    String eventName = rs.getString("EventName");
                    EventOrderDTO order
                            = new EventOrderDTO(username, eventId, eventName, eventOrderId, fullname, phone, address, city, orderDate, null, deliveryOption, paymentOption, status, amount, isPaid, note);
                    orders.add(order);
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
        return orders;
    }
}
