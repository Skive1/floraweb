/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.reviewEvent;

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
public class ReviewEventDAO implements Serializable {

    public boolean saveComment(String username, int productId, String status)
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
                String sql = "Insert Into ReviewEvent( "
                        + "AccountUsername, Status, EventProductEPId "
                        + ") Values( "
                        + "?, ?, ? "
                        + ")";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, status);
                stm.setInt(3, productId);
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

    public List<ReviewEventDTO> getCommentByProductId(int id, int limit, int offset)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ReviewEventDTO> dto = new ArrayList<>();
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select AccountUsername, ReviewEventId, Status, EventProductEPId, ReviewDate "
                        + "From ReviewEvent "
                        + "Where EventProductEPId = ? "
                        + "ORDER BY ReviewDate DESC "
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                stm.setInt(2, offset);
                stm.setInt(3, limit);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String username = rs.getString("AccountUsername");
                    int reviewId = rs.getInt("ReviewEventId");
                    String status = rs.getString("Status");
                    int productId = rs.getInt("EventProductEPId");
                    Timestamp reviewDate = rs.getTimestamp("ReviewDate");
                    //set data to DTO properties
                    ReviewEventDTO reviews
                            = new ReviewEventDTO(username, reviewId, status, productId, reviewDate);
                    dto.add(reviews);
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

}
