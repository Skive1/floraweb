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
}
