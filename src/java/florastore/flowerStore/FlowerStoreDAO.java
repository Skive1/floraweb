/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.flowerStore;

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
public class FlowerStoreDAO implements Serializable{
    public String getStoreName(int productId)
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
                String sql = "Select fs.StoreName "
                        + "From FlowerStore fs "
                        + "join FlowerProducts fp "
                        + "on fs.StoreID = fp.FlowerStoreStoreID "
                        + "Where fp.ProductId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, productId);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                if(rs.next()){
                    //. map
                    //get data from Result Set
                    String storeName = rs.getString("StoreName");
                    result = storeName;
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
}
