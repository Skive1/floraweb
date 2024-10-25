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
import java.util.ArrayList;
import java.util.List;
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
            if (con != null) {
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

    public List<PurchasedOrderDetailDTO> getOrderInfoByOrderId(int id)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<PurchasedOrderDetailDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT ep.EPName, ep.Img, eod.UnitPrice, eod.Quantity, eod.Total "
                        + "From EventOrderDetail eod "
                        + "join EventProduct ep on eod.EventProductID = ep.EPId "
                        + "WHERE eod.EventOrderId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String productName = rs.getString("EPName");
                    String img = rs.getString("Img");
                    double unitPrice = rs.getDouble("UnitPrice");
                    int quantity = rs.getInt("Quantity");
                    double total = rs.getDouble("Total");
                    PurchasedOrderDetailDTO product
                            = new PurchasedOrderDetailDTO(productName, img, unitPrice, quantity, total);
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
}
