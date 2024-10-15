/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventProduct;

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
 * @author ADMIN
 */
public class EventProductDAO implements Serializable {

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

    public int getProductQuantityByName(String productName)
            throws SQLException, NamingException {

        int quantity = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT EPQuantity "
                        + "FROM EventProduct "
                        + "Where EPName = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, productName);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set

                    quantity = rs.getInt("EPQuantity");

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
        return quantity;
    }

    public boolean updateQuantityEventFlower(int epId, int newStockQuantity)
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
                String sql = "UPDATE EventProduct "
                        + "SET EPQuantity = ? "
                        + "Where EPId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, newStockQuantity);
                stm.setInt(2, epId);

                //4. Execute Query
                int affectedRows = stm.executeUpdate();
                //5. process result
                if (affectedRows > 0) {
                    result = true;
                }
            }//process each record in resultset  
        }//connection has been available 
        finally {
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
