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
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author acer
 */
public class ProductTypeDAO implements Serializable{
    private ArrayList<ProductTypeDTO> listCategory;

    public ArrayList<ProductTypeDTO> getListCategory() {
        return listCategory;
    }
     public void loadListProductType() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT CategoryID, CategoryName "
                        + "FROM Category";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
               

                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cateID = rs.getString("CategoryID");
                    String cateName = rs.getString("CategoryName");
                    ProductTypeDTO dto = new ProductTypeDTO(cateID, cateName);
                    if (this.listCategory == null) {
                        listCategory = new ArrayList<>();
                    }//end if list is empty
                    listCategory.add(dto);
                } //end while loop
            } //end if connection is success

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
