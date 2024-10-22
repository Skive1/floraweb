/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.notifications;

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
public class NotificationsDAO implements Serializable {

    public List<NotificationsDTO> getUnreadNotifications(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<NotificationsDTO> notifications = new ArrayList<>();
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            //2. Create SQL String 
            String sql = "Select NotificationID, [message] "
                    + "From Notifications "
                    + "Where Username = ? AND isRead = 0 "
                    + "ORDER BY notificationDate DESC";
            //3. Create Statement Object
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            //4. Execute Query
            rs = stm.executeQuery();
            //5. process result
            while (rs.next()) {
                //. map
                //get data from Result Set
                int id = rs.getInt("NotificationID");
                String message = rs.getString("message");
                NotificationsDTO notification = new NotificationsDTO(id, message);
                notifications.add(notification);
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
        return notifications;
    }

    // Đánh dấu thông báo là đã đọc (nhiều thông báo cùng lúc)
    public void markAllAsRead(List<Integer> notificationIds)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            String sql = "UPDATE Notifications "
                    + "SET isRead = 1 "
                    + "WHERE NotificationID = ?";
            stm = con.prepareStatement(sql);
            for (int id : notificationIds) {
                stm.setInt(1, id);
                stm.addBatch();
            }
            stm.executeBatch();
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
}
