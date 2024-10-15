/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.managerProduct;

import florastore.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author acer
 */
public class FlowerProductDAO implements Serializable {

    public boolean saveProduct(FlowerProductDTO dto, int storeId)
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
                String sql = "INSERT INTO FlowerProducts "
                        + "(FlowerStoreStoreID, ProductType, ProductName, ProductCondition, ProductDetail, Img, ProductQuantity, ProductPrice, CategoryCategoryId, IsDel) "
                        + "VALUES "
                        + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, storeId);
                stm.setString(2, dto.getType());
                stm.setString(3, dto.getName());
                stm.setString(4, dto.getCondition());
                stm.setString(5, dto.getDetail());
                stm.setString(6, dto.getImg());
                stm.setInt(7, dto.getQuantity());
                stm.setDouble(8, dto.getPrice());
                stm.setString(9, dto.getCateId());
                stm.setString(10, dto.getIsDel());
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
}
