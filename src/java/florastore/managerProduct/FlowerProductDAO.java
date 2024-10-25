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
public class FlowerProductDAO implements Serializable {

    private ArrayList<FlowerProductDTO> product;

    public ArrayList<FlowerProductDTO> getProduct() {
        return product;
    }

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

    public FlowerProductDTO searchProductById(String productId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            // Get the database connection (replace with your connection logic)
            con = DBHelper.getConnection();

            if (con != null) {
                String sql = "SELECT ProductType, ProductName, ProductCondition, ProductDetail, Img, ProductQuantity, ProductPrice, CategoryCategoryId "
                        + "FROM FlowerProducts "
                        + "WHERE ProductId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, productId);
                rs = stm.executeQuery();

                if (rs.next()) {
                    FlowerProductDTO product = new FlowerProductDTO();
                    product.setType(rs.getString("ProductType"));
                    product.setName(rs.getString("ProductName"));
                    product.setCondition(rs.getString("ProductCondition"));
                    product.setDetail(rs.getString("ProductDetail"));
                    product.setImg(rs.getString("Img"));
                    product.setQuantity(rs.getInt("ProductQuantity"));
                    product.setPrice(rs.getDouble("ProductPrice"));
                    product.setCateId(rs.getString("CategoryCategoryId"));
                    product.setIsDel("0");
                    return product;
                }
            }
        } finally {
            // Close resources (replace with your resource management logic)
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

        return null; // Return null if product not found
    }

    public void loadProductById(String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT ProductType, ProductName, ProductCondition, ProductDetail, Img, ProductQuantity, ProductPrice, CategoryCategoryId "
                        + "FROM FlowerProducts "
                        + "WHERE ProductId = ?";
                //2. Create stm obj
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //3. Excute Query
                rs = stm.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("ProductType");
                    String name = rs.getString("ProductName");
                    String condition = rs.getString("ProductCondition");
                    String detail = rs.getString("ProductDetail");
                    String img = rs.getString("Img");
                    int quantity = rs.getInt("ProductQuantity");
                    double price = rs.getDouble("ProductPrice");
                    String cateId = rs.getString("CategoryCategoryId");
                    FlowerProductDTO items = new FlowerProductDTO(type, name, condition, detail, img, quantity, price, cateId, "0");
                    if (this.product == null) {
                        product = new ArrayList<>();
                    }//end if list is empty
                    product.add(items);
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

    public boolean updateProduct(String type, String name, String condition, String detail, String img, int quantity, double price, String cateId, String id)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. kết nối DB
            con = DBHelper.getConnection();
            if (con != null) {

            //2.Create SQL string
                String sql = "UPDATE FlowerProducts "
                        + "SET "
                        + "ProductType = ?, "
                        + "ProductName = ?, "
                        + "ProductCondition = ?, "
                        + "ProductDetail = ?, "
                        + "Img = ?, "
                        + "ProductQuantity = ?, "
                        + "ProductPrice = ?, "
                        + "CategoryCategoryId = ? "
                        + "WHERE ProductId = ?";
                //3.Create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, type);
                stm.setString(2, name);
                stm.setString(3, condition);
                stm.setString(4, detail);
                stm.setString(5, img);
                stm.setInt(6, quantity);
                stm.setDouble(7, price);
                stm.setString(8, cateId);
                stm.setString(9, id);
                //4. Execute
                int affectedRows = stm.executeUpdate();

                //5. process result
                if (affectedRows > 0) {
                    result = true; //nếu số dóng ảnh hưởng > 0 thì update được
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return result;
    }
}
