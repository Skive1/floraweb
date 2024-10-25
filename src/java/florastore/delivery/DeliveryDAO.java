/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.delivery;

import florastore.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class DeliveryDAO implements Serializable {

    public boolean assignDelivery(String username, String phone)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "INSERT INTO Delivery ("
                        + "AccountUsername, Phone"
                        + ") Values ("
                        + "?, ?"
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, phone);
                int affectedRow = stm.executeUpdate();
                if (affectedRow > 0) {
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
