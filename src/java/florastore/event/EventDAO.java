/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.event;

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
                String sql = "SELECT AccountUsername, EventId, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg "
                        + "FROM Event "
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

    public EventProductDTO getFlowerDetail(int id)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        EventProductDTO dto = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select EventEventId, EPId, EPName, EPType, EPCondition, EPDetail, Img, EPQuantity, EPPrice "
                        + "From EventProduct "
                        + "Where EPId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int EPId = rs.getInt("EPId");
                    String EPName = rs.getString("EPName");
                    String EPType = rs.getString("EPType");
                    String EPCondition = rs.getString("EPCondition");
                    String EPDetail = rs.getString("EPDetail");
                    String Img = rs.getString("Img");
                    int EPQuantity = rs.getInt("EPQuantity");
                    double EPPrice = rs.getDouble("EPPrice");
                    //set data to DTO properties
                    dto
                            = new EventProductDTO(EPId, EPName, EPType, EPCondition, EPDetail, Img, EPQuantity, EPPrice);
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
        return dto;
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
                String sql = "INSERT INTO Event (AccountUsername, EventName, EventLocation, EventCity, StartDate, EndDate, EventImg) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?);";
                // 3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getEventOwner());
                stm.setString(2, dto.getEventName());
                stm.setString(3, dto.getEventLocation());
                stm.setString(4, dto.getEventCity());
                stm.setTimestamp(5, dto.getStartDate());
                stm.setTimestamp(6, dto.getEndDate());
                stm.setString(7, dto.getEventImg());
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
                stm.setString(7, dto.getEventProductImg());
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
}
