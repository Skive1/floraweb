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
public class CategoryDAO implements Serializable {

    private ArrayList<CategoryDTO> listCategory;

    public ArrayList<CategoryDTO> getListCategory() {
        return listCategory;
    }

    public void loadListProductCategory() throws SQLException , NamingException
    {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select CategoryId, CategoryName "
                        + "From Category";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("CategoryId");
                    String category = rs.getString("CategoryName");
                    CategoryDTO dto = new CategoryDTO(id, category);
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
