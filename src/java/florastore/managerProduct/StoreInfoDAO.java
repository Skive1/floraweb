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
public class StoreInfoDAO implements Serializable {

    private ArrayList<StoreInfoDTO> listInfo;

    public ArrayList<StoreInfoDTO> getListInfo() {
        return listInfo;
    }

    public void loadStoreInfo(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT StoreID, StoreName "
                        + "FROM FlowerStore "
                        + "WHERE AccountUsername = ?";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("StoreID");
                    String name = rs.getString("StoreName");
                    StoreInfoDTO dto = new StoreInfoDTO(id, name);
                    if (this.listInfo == null) {
                        listInfo = new ArrayList<>();
                    }//end if list is empty
                    listInfo.add(dto);
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
