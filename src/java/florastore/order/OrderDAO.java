/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.order;

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
public class OrderDAO implements Serializable {

    public boolean saveOrder(OrderDTO order)
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
                String sql = "Insert Into [Order]( "
                        + "AccountUsername, FlowerStoreStoreID, Fullname, Phone, Street, City, DeliveryDate, DeliveryOption, Status, Amount, isPaid, PaymentOptions, Note "
                        + ") Values( "
                        + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? "
                        + ")";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, order.getUsername());
                stm.setInt(2, order.getStoreId());
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
    
    public int getOrderId(OrderDTO order)
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
                String sql = "Select TOP 1 OrderId "
                        + "From [Order] "
                        + "Where AccountUsername = ? "
                        + "AND FlowerStoreStoreID = ? "
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
                        + "ORDER BY OrderId DESC";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, order.getUsername());
                stm.setInt(2, order.getStoreId());
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
                    result = rs.getInt("OrderId");
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
}
