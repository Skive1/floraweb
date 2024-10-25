/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventFeedback;

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
public class EventFeedbackDAO implements Serializable {

    public boolean createFeedback(int orderId, String username)
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
                String sql = "INSERT INTO EventFeedback ("
                        + "AccountUsername, Status, EventOrderId"
                        + ") Values ("
                        + "?, ?, ?"
                        + ")";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, "");
                stm.setInt(3, orderId);
                //4. Execute Query
                int affectedRows = stm.executeUpdate();
                //5. process result
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

    public boolean insertFeedback(int orderId, String feedback)
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
                String sql = "UPDATE EventFeedback "
                        + "SET [Status] = ? "
                        + "WHERE EventOrderId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, feedback);
                stm.setInt(2, orderId);
                //4. Execute Query
                int affectedRows = stm.executeUpdate();
                //5. process result
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

    public List<EventFeedbackDTO> checkList(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventFeedbackDTO> feedbacks = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select AccountUsername, Status, EventOrderId, FeedbackId "
                        + "From EventFeedback "
                        + "Where AccountUsername = ? ";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String review = rs.getString("Status");
                    int eventOrderId = rs.getInt("EventOrderId");
                    int feedbackId = rs.getInt("FeedbackId");

                    EventFeedbackDTO feedback
                            = new EventFeedbackDTO(username, review, eventOrderId, feedbackId);
                    feedbacks.add(feedback);
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
        return feedbacks;
    }

    public List<EventFeedbackDTO> getNumberOfFeedback(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventFeedbackDTO> feedbacks = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select efb.FeedbackId, efb.EventOrderId, eo.Fullname, efb.Status "
                        + "From EventFeedback efb "
                        + "join EventOrder eo on efb.EventOrderId = eo.EventOrderId "
                        + "join [Event] e on eo.EventId = e.EventId "
                        + "Where e.AccountUsername = ? "
                        + "Order by efb.EventOrderId";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int feedbackId = rs.getInt("FeedbackId");
                    String fullname = rs.getString("Fullname");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String feedbackComment = rs.getString("Status");

                    EventFeedbackDTO feedback
                            = new EventFeedbackDTO(username, feedbackComment, eventOrderId, feedbackId, fullname);
                    feedbacks.add(feedback);
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
        return feedbacks;
    }

    public List<EventFeedbackDTO> getListFeedback(String username, int page)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventFeedbackDTO> feedbacks = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select efb.FeedbackId, efb.EventOrderId, eo.Fullname, efb.Status "
                        + "From EventFeedback efb "
                        + "join EventOrder eo on efb.EventOrderId = eo.EventOrderId "
                        + "join [Event] e on eo.EventId = e.EventId " 
                        + "Where e.AccountUsername = ? "
                        + "Order by efb.EventOrderId "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setInt(2, (page - 1) * 10);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int feedbackId = rs.getInt("FeedbackId");
                    String fullname = rs.getString("Fullname");
                    int eventOrderId = rs.getInt("EventOrderId");
                    String feedbackComment = rs.getString("Status");

                    EventFeedbackDTO feedback
                            = new EventFeedbackDTO(username, feedbackComment, eventOrderId, feedbackId, fullname);
                    feedbacks.add(feedback);
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
        return feedbacks;
    }
}
