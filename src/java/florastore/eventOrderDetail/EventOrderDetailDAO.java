/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventOrderDetail;

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
public class EventOrderDetailDAO implements Serializable {

    public boolean saveOrderDetail(EventOrderDetailDTO orderDetail)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if(con != null){
                //2. Create SQL String 
                String sql = "Insert Into EventOrderDetail("
                        + "Quantity, UnitPrice, Discount, Total, EventOrderId, EventProductID"
                        + ") Values("
                        + "?, ?, ?, ?, ?, ?"
                        + ")";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, orderDetail.getQuantity());
                stm.setDouble(2, orderDetail.getUnitPrice());
                stm.setDouble(3, orderDetail.getDiscount());
                stm.setDouble(4, orderDetail.getTotal());
                stm.setInt(5, orderDetail.getEventOrderId());
                stm.setInt(6, orderDetail.getEventProductId());
                //4. Execute Query
                int affectedRows = stm.executeUpdate();
                //5. process result
                if (affectedRows > 0){
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
}
