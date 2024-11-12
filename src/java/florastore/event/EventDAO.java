/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.event;

import florastore.eventProduct.EventProductDTO;
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
public class EventDAO implements Serializable {

    public List<EventDTO> getAllEvent()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg, EventStatus "
                        + "FROM Event "
                        + "WHERE EventStatus = 1 "
                        + "ORDER BY StartDate";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventOwner = rs.getString("AccountUsername");
                    int eventId = rs.getInt("EventId");
                    String eventName = rs.getString("EventName");
                    String eventLocation = rs.getString("EventLocation");
                    String eventCity = rs.getString("EventCity");
                    Timestamp startDate = rs.getTimestamp("StartDate");
                    Timestamp endDate = rs.getTimestamp("EndDate");
                    String eventImg = rs.getString("EventImg");
                    boolean eventStatus = rs.getBoolean("EventStatus");
                    EventDTO event
                            = new EventDTO(eventOwner, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg);
                    events.add(event);
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
        return events;
    }

    public List<EventProductDTO> getEventFlower(int eventId)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventProductDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select ep.EPId, ep.EPName, ep.EPType, ep.EPCondition, ep.EPDetail, ep.Img, ep.EPQuantity, ep.EPPrice "
                        + "From EventProduct ep "
                        + "Join Event e on ep.EventEventId = e.EventId "
                        + "Where ep.EventEventId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, eventId);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int epId = rs.getInt("EPId");
                    String epName = rs.getString("EPName");
                    String epType = rs.getString("EPType");
                    String epCondition = rs.getString("EPCondition");
                    String epDetail = rs.getString("EPDetail");
                    String img = rs.getString("Img");
                    int epQuantity = rs.getInt("EPQuantity");
                    double epPrice = rs.getDouble("EPPrice");
                    EventProductDTO product
                            = new EventProductDTO(epId, epName, epType, epCondition, epDetail, img, epQuantity, epPrice);
                    products.add(product);
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

    public List<EventProductDTO> getEventFlower2(int eventId)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventProductDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select ep.EPId, ep.EPName, ep.EPType, ep.EPCondition, "
                        + "ep.EPDetail, ep.Img, ep.EPQuantity, ep.EPPrice, ep.EventEventId "
                        + "From EventProduct ep "
                        + "Join Event e on ep.EventEventId = e.EventId "
                        + "Where ep.EventEventId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, eventId);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int epId = rs.getInt("EPId");
                    String epName = rs.getString("EPName");
                    String epType = rs.getString("EPType");
                    String epCondition = rs.getString("EPCondition");
                    int eventEventId = rs.getInt("EventEventId");
                    String epDetail = rs.getString("EPDetail");
                    String img = rs.getString("Img");
                    int epQuantity = rs.getInt("EPQuantity");
                    double epPrice = rs.getDouble("EPPrice");
                    EventProductDTO product
                            = new EventProductDTO(eventEventId, eventEventId, epName, epType,
                                    epCondition, epDetail, epCondition, epQuantity, epPrice);
                    products.add(product);
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

    public String getEventNameByProductId(int productId)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select e.EventName "
                        + "From Event e "
                        + "join EventProduct ep "
                        + "on e.EventId = ep.EventEventId "
                        + "Where ep.EPId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, productId);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                if (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventName = rs.getString("EventName");
                    result = eventName;
                }//flower detail is loaded
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

    public String getEventNameByEventId(int eventId)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select EventName "
                        + "FROM Event "
                        + "WHERE EventId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, eventId);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                if (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventName = rs.getString("EventName");
                    result = eventName;
                }//flower detail is loaded
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

    public boolean closeEvent(String eventID) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Update Event Set EventStatus = 0 Where EventId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, eventID);
                int affectedRow = stm.executeUpdate();
                if (affectedRow > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return false;
    }

    public List<EventDTO> getAllEventExcept()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();
        EventDTO event = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg "
                        + "FROM Event "
                        + "WHERE EventStatus = 1 "
                        + "ORDER BY StartDate";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventOwner = rs.getString("AccountUsername");
                    int eventId = rs.getInt("EventId");
                    String eventName = rs.getString("EventName");
                    String eventLocation = rs.getString("EventLocation");
                    String eventCity = rs.getString("EventCity");
                    Timestamp startDate = rs.getTimestamp("StartDate");
                    Timestamp endDate = rs.getTimestamp("EndDate");
                    String eventImg = rs.getString("EventImg");
                    event = new EventDTO(eventOwner, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg);
                    events.add(event);

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
        return events;
    }

    public List<EventDTO> getComingEvent(Timestamp currentDate)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();
        EventDTO event = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg "
                        + "FROM Event "
                        + "WHERE EventStatus = 1 AND StartDate > ? "
                        + "ORDER BY StartDate";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, currentDate);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventOwner = rs.getString("AccountUsername");
                    int eventId = rs.getInt("EventId");
                    String eventName = rs.getString("EventName");
                    String eventLocation = rs.getString("EventLocation");
                    String eventCity = rs.getString("EventCity");
                    Timestamp startDate = rs.getTimestamp("StartDate");
                    Timestamp endDate = rs.getTimestamp("EndDate");
                    String eventImg = rs.getString("EventImg");
                    event = new EventDTO(eventOwner, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg);
                    events.add(event);
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
        return events;
    }

    public List<EventDTO> getInProgressEvent(Timestamp currentDate)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();
        EventDTO event = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg "
                        + "FROM Event "
                        + "WHERE EventStatus = 1 AND ? between StartDate and EndDate "
                        + "ORDER BY StartDate";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, currentDate);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventOwner = rs.getString("AccountUsername");
                    int eventId = rs.getInt("EventId");
                    String eventName = rs.getString("EventName");
                    String eventLocation = rs.getString("EventLocation");
                    String eventCity = rs.getString("EventCity");
                    Timestamp startDate = rs.getTimestamp("StartDate");
                    Timestamp endDate = rs.getTimestamp("EndDate");
                    String eventImg = rs.getString("EventImg");
                    event = new EventDTO(eventOwner, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg);
                    events.add(event);
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
        return events;
    }

    public List<EventDTO> getEndEvent(Timestamp currentDate)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();
        EventDTO event = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg "
                        + "FROM Event "
                        + "WHERE EventStatus = 1 AND EndDate < ? "
                        + "ORDER BY StartDate";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, currentDate);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventOwner = rs.getString("AccountUsername");
                    int eventId = rs.getInt("EventId");
                    String eventName = rs.getString("EventName");
                    String eventLocation = rs.getString("EventLocation");
                    String eventCity = rs.getString("EventCity");
                    Timestamp startDate = rs.getTimestamp("StartDate");
                    Timestamp endDate = rs.getTimestamp("EndDate");
                    String eventImg = rs.getString("EventImg");
                    event = new EventDTO(eventOwner, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg);
                    events.add(event);
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
        return events;
    }

    public List<EventDTO> getNewForNotification(Timestamp currentTime)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT TOP 5 AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg "
                        + "FROM Event "
                        + "WHERE StartDate > ? AND EventStatus = 1 "
                        + "ORDER BY StartDate DESC";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, currentTime);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventOwner = rs.getString("AccountUsername");
                    int eventId = rs.getInt("EventId");
                    String eventName = rs.getString("EventName");
                    String eventLocation = rs.getString("EventLocation");
                    String eventCity = rs.getString("EventCity");
                    Timestamp startDate = rs.getTimestamp("StartDate");
                    Timestamp endDate = rs.getTimestamp("EndDate");
                    String eventImg = rs.getString("EventImg");
                    EventDTO event = new EventDTO(eventOwner, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg);
                    events.add(event);

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
        return events;
    }

    public boolean addEvent(EventDTO dto)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Create SQL String with RETURN_GENERATED_KEYS to get eventId
                String sql = "INSERT INTO Event (AccountUsername, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg, EventStatus) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getEventOwner());
                stm.setString(2, dto.getEventName());
                stm.setString(3, dto.getEventLocation());
                stm.setString(4, dto.getEventCity());
                stm.setTimestamp(5, dto.getStartDate());
                stm.setTimestamp(6, dto.getEndDate());
                stm.setString(7, "imageEvent/" + dto.getEventImg());
                stm.setBoolean(8, dto.isEventStatus());
                // 4. Execute the update
                int affectedRows = stm.executeUpdate();

                // 5. Process result and retrieve generated eventId
                if (affectedRows > 0) {
                    result = true;
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
        return result;
    }

    public boolean updateEvent(EventDTO dto, int eventID)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Create SQL String with RETURN_GENERATED_KEYS to get eventId
                String sql = "UPDATE Event SET EventName = ?, EventLocation = ?, EventCity = ?, StartDate = ?, EndDate = ?, EventImg = ? "
                        + "WHERE EventId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getEventName());
                stm.setString(2, dto.getEventLocation());
                stm.setString(3, dto.getEventCity());
                stm.setTimestamp(4, dto.getStartDate());
                stm.setTimestamp(5, dto.getEndDate());
                stm.setString(6, "imageEvent/" + dto.getEventImg());
                stm.setInt(7, eventID);
                // 4. Execute the update
                int affectedRows = stm.executeUpdate();

                // 5. Process result and retrieve generated eventId
                if (affectedRows > 0) {
                    result = true;
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
        return result;
    }

    public List<EventCategoryDTO> getCategories()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventCategoryDTO> categories = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select CategoryId, CategoryName "
                        + "From Category";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int id = rs.getInt("CategoryId");
                    String name = rs.getString("CategoryName");
                    //set data to DTO properties
                    EventCategoryDTO dto
                            = new EventCategoryDTO(id, name);
                    categories.add(dto);
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
        return categories;
    }

    public boolean addEventProduct(EventProductDTO dto, int categoryId, int eventId)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Create SQL String with RETURN_GENERATED_KEYS to get eventId
                String sql = "INSERT INTO EventProduct (CategoryCategoryId, EventEventId, EPName, EPType, EPCondition, EPDetail, Img, EPQuantity, EPPrice) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoryId);
                stm.setInt(2, eventId);
                stm.setString(3, dto.getEventProductName());
                stm.setString(4, dto.getEventProductType());
                stm.setString(5, dto.getEventProductCondition());
                stm.setString(6, dto.getEventProductDetail());
                stm.setString(7, "imageEventProduct/" + dto.getEventProductImg());
                stm.setInt(8, dto.getEventProductQuantity());
                stm.setDouble(9, dto.getEventProductPrice());
                // 4. Execute the update
                int affectedRows = stm.executeUpdate();

                // 5. Process result and retrieve generated eventId
                if (affectedRows > 0) {
                    result = true;
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
        return result;
    }

    public List<EventOrderDTO> getOrders(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDTO> orders = new ArrayList<>();

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Create SQL String to get the next 5 orders with pagination
                String sql = "select eo.Fullname, eo.EventOrderId, eo.Phone,eo.Street, eo.Note, eo.Status, eo.OrderDate, eo.DeliveryOption, eo.isPaid, eo.City "
                        + "from EventOrder eo "
                        + "join Event e on eo.EventId = e.EventId "
                        + "where e.AccountUsername = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username); // Set the offset parameter

                // 4. Process result
                rs = stm.executeQuery(); // Execute the query
                while (rs.next()) {
                    String fullName = rs.getString("Fullname");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String phone = rs.getString("Phone");
                    String street = rs.getString("Street");
                    String note = rs.getString("Note");
                    String status = rs.getString("Status");
                    String city = rs.getString("City");
                    String deliveryOpt = rs.getString("DeliveryOption");
                    boolean isPaid = rs.getBoolean("isPaid");
                    Timestamp orderDate = rs.getTimestamp("OrderDate");
                    if ("Chờ giao".equals(status)) {
                        EventOrderDTO dto
                                = new EventOrderDTO(0, eventOrderId,
                                        fullName, phone, street, city,
                                        null, deliveryOpt, status,
                                        0, 0, isPaid, "", note, orderDate);
                        orders.add(dto);
                    }
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
        return orders;
    }

    public void confirm(int orderId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Write SQL string
                String sql = "UPDATE EventOrder SET Status = ? WHERE eventOrderId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "Chưa nhận");
                stm.setInt(2, orderId);
                // 4. Execute the update
                stm.executeUpdate(); // No need to check affected rows if we don't return a value
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void confirm2(int orderId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Write SQL string
                String sql = "UPDATE EventOrder SET Status = ? WHERE eventOrderId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "Đã giao");
                stm.setInt(2, orderId);
                // 4. Execute the update
                stm.executeUpdate(); // No need to check affected rows if we don't return a value
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void insertDeliveryDate(int orderId, Timestamp deliveryDate) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Write SQL string
                String sql = "UPDATE EventOrder SET DeliveryDate = ? WHERE eventOrderId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, deliveryDate);
                stm.setInt(2, orderId);
                // 4. Execute the update
                stm.executeUpdate(); // No need to check affected rows if we don't return a value
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void updatePaymentStatus(int orderId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Write SQL string
                String sql = "UPDATE EventOrder SET isPaid = ? WHERE eventOrderId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, true);
                stm.setInt(2, orderId);
                // 4. Execute the update
                stm.executeUpdate(); // No need to check affected rows if we don't return a value
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void cancelOrder(int orderId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Write SQL string
                String sql = "UPDATE EventOrder SET Status = ? WHERE eventOrderId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "Hủy");
                stm.setInt(2, orderId);
                // 4. Execute the update
                stm.executeUpdate(); // No need to check affected rows if we don't return a value
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<EventOrderDTO> getDeliveredOrder(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDTO> delivered = new ArrayList<>();

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Create SQL String to get the next 5 orders with pagination
                String sql = "select eo.Fullname, eo.EventOrderId, eo.Phone,eo.Street, eo.Note, eo.Status, eo.OrderDate, eo.DeliveryDate, eo.isPaid, eo.DeliveryOption "
                        + "from EventOrder eo "
                        + "join Event e on eo.EventId = e.EventId "
                        + "where e.AccountUsername = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                // 4. Process result
                rs = stm.executeQuery(); // Execute the query
                while (rs.next()) {
                    String fullName = rs.getString("Fullname");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String phone = rs.getString("Phone");
                    String street = rs.getString("Street");
                    String note = rs.getString("Note");
                    String status = rs.getString("Status");
                    boolean isPaid = rs.getBoolean("isPaid");
                    Timestamp orderDate = rs.getTimestamp("OrderDate");
                    Timestamp deliveryDate = rs.getTimestamp("DeliveryDate");
                    String deliveryOpt = rs.getString("DeliveryOption");
                    if ("Đã giao".equals(status)) {
                        EventOrderDTO dto
                                = new EventOrderDTO(0, eventOrderId,
                                        fullName, phone, street, "",
                                        deliveryDate, deliveryOpt, status,
                                        0, 0, isPaid, "", note, orderDate);
                        delivered.add(dto);
                    }
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
        return delivered;
    }

    public List<EventOrderDetailDTO> getOrderDetails(int eventOrderId)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventOrderDetailDTO> details = new ArrayList<>();

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Create SQL String to get the next 5 orders with pagination
                String sql = "select eod.Quantity, eod.UnitPrice, eod.Discount, eod.Total, ep.EPName "
                        + "from EventOrderDetail eod "
                        + "join EventProduct ep on eod.EventProductID = ep.EPId "
                        + "where EventOrderId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, eventOrderId);
                // 4. Process result
                rs = stm.executeQuery(); // Execute the query
                while (rs.next()) {
                    String productName = rs.getString("EPName");
                    int quantity = rs.getInt("Quantity");
                    double uPrice = rs.getDouble("UnitPrice");
                    double discount = rs.getDouble("Discount");
                    double total = rs.getDouble("Total");

                    EventOrderDetailDTO dto
                            = new EventOrderDetailDTO(quantity, uPrice, discount, total, eventOrderId, productName);
                    details.add(dto);
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
        return details;
    }

    public List<EventDTO> getEventByAccount(String accountUsername)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();
        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            String sql = "SELECT EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg, EventStatus "
                    + "FROM Event "
                    + "Where AccountUsername Like ?";
            //3. Create Statement Object
            stm = con.prepareStatement(sql);
            stm.setString(1, accountUsername);
            //4. Execute Query
            rs = stm.executeQuery();
            //5. process result
            while (rs.next()) {
                //. map
                //get data from Result Set
                int eventId = rs.getInt("EventId");
                String eventName = rs.getString("EventName");
                String eventLocation = rs.getString("EventLocation");
                String eventCity = rs.getString("EventCity");
                Timestamp startDate = rs.getTimestamp("StartDate");
                Timestamp endDate = rs.getTimestamp("EndDate");
                String eventImg = rs.getString("EventImg");
                boolean eventStatus = rs.getBoolean("EventStatus");
                EventDTO event
                        = new EventDTO(accountUsername, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg, eventStatus);
                events.add(event);
            }//process each record in resultset  
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
        return events;
    }

    public EventDTO getEventByID(int eventID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        EventDTO events = null;
        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            String sql = "SELECT EventName, EventLocation, EventCity, StartDate, EndDate, EventImg, EventStatus "
                    + "FROM Event "
                    + "Where EventId = ?";
            //3. Create Statement Object
            stm = con.prepareStatement(sql);
            stm.setInt(1, eventID);
            //4. Execute Query
            rs = stm.executeQuery();
            //5. process result
            while (rs.next()) {
                //. map
                //get data from Result Set
                int eventId = eventID;
                String eventName = rs.getString("EventName");
                String eventLocation = rs.getString("EventLocation");
                String eventCity = rs.getString("EventCity");
                Timestamp startDate = rs.getTimestamp("StartDate");
                Timestamp endDate = rs.getTimestamp("EndDate");
                String eventImg = rs.getString("EventImg");
                boolean eventStatus = rs.getBoolean("EventStatus");
                events = new EventDTO("", eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg, eventStatus);
            }//process each record in resultset  
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
        return events;
    }

    public void cancelEvent(int eventId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Write SQL string
                String sql = "UPDATE Event SET EventStatus = ? WHERE EventId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, false);
                stm.setInt(2, eventId);
                // 4. Execute the update
                stm.executeUpdate(); // No need to check affected rows if we don't return a value
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<EventProductDTO> getAvailableEventFlower(int eventId)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventProductDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select ep.EPId, ep.EPName, ep.EPType, ep.EPCondition, ep.EPDetail, ep.Img, ep.EPQuantity, ep.EPPrice "
                        + "From EventProduct ep "
                        + "Join Event e on ep.EventEventId = e.EventId "
                        + "Where ep.EventEventId = ? AND isDel = 0";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, eventId);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int epId = rs.getInt("EPId");
                    String epName = rs.getString("EPName");
                    String epType = rs.getString("EPType");
                    String epCondition = rs.getString("EPCondition");
                    String epDetail = rs.getString("EPDetail");
                    String img = rs.getString("Img");
                    int epQuantity = rs.getInt("EPQuantity");
                    double epPrice = rs.getDouble("EPPrice");
                    EventProductDTO product
                            = new EventProductDTO(eventId, epId, epName, epType, epCondition, epDetail, img, epQuantity, epPrice);
                    products.add(product);
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

    public void updateEPStatus(int epId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. Connect to DB
            con = DBHelper.getConnection();
            if (con != null) {
                // 2. Write SQL string
                String sql = "UPDATE EventProduct SET isDel = ? WHERE EPId = ?";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, 1);
                stm.setInt(2, epId);
                // 4. Execute the update
                stm.executeUpdate(); // No need to check affected rows if we don't return a value
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<EventDTO> searchEventsByKeyword(String keyword)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> events = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg, EventStatus "
                        + "FROM Event "
                        + "WHERE EventStatus = 1 AND EventName LIKE ? "
                        + "ORDER BY StartDate";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + keyword + "%");
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String eventOwner = rs.getString("AccountUsername");
                    int eventId = rs.getInt("EventId");
                    String eventName = rs.getString("EventName");
                    String eventLocation = rs.getString("EventLocation");
                    String eventCity = rs.getString("EventCity");
                    Timestamp startDate = rs.getTimestamp("StartDate");
                    Timestamp endDate = rs.getTimestamp("EndDate");
                    String eventImg = rs.getString("EventImg");
                    boolean eventStatus = rs.getBoolean("EventStatus");
                    EventDTO event
                            = new EventDTO(eventOwner, eventId, eventName, eventLocation, eventCity, startDate, endDate, eventImg);
                    events.add(event);
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
        return events;
    }
}
