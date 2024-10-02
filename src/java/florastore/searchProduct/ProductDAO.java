/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchProduct;

import florastore.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class ProductDAO {

    private List<ProductDTO> totalProduct;
    private List<ProductDTO> productSplit;

    public List<ProductDTO> getProductSplit() {
        return productSplit;
    }

    public List<ProductDTO> getTotalProduct() {
        return totalProduct;
    }

    public void searchTotalProduct(String searchValue, boolean searchAll) throws SQLException, NamingException {
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                //String sql = "SELECT * FROM FlowerProducts WHERE ProductName LIKE ?";
                String sql = null;
                if (searchAll == true) {
                    sql = "SELECT ProductId, StoreId, ProductName, ProductType, ProductCondition, ProductDetail, "
                            + "ProductPrice, ProductQuantity, ImageURL "
                            + "FROM FlowerProducts";
                    stm = con.prepareStatement(sql);
                } else {
                    sql = "SELECT ProductId, StoreId, ProductName, ProductType, ProductCondition, ProductDetail, "
                            + "ProductPrice, ProductQuantity, ImageURL "
                            + "FROM FlowerProducts WHERE ProductName LIKE ?";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, "%" + searchValue + "%");
                }
                rs = stm.executeQuery();
                while (rs.next()) {
                    //get data from result set
                    int ProductId = rs.getInt("ProductId");
                    int StoreId = rs.getInt("StoreId");
                    String ProductName = rs.getString("ProductName");
                    String ProductType = rs.getString("ProductType");
                    String ProductCondition = rs.getString("ProductCondition");
                    String ProductDetail = rs.getString("ProductDetail");
                    int ProductPrice = rs.getInt("ProductPrice");
                    int ProductQuantity = rs.getInt("ProductQuantity");
                    String ImageURL = rs.getString("ImageURL");
                    //set data to DTO properties
                    ProductDTO dto = new ProductDTO(ProductId, StoreId, ProductName, ProductType,
                            ProductCondition, ProductDetail, ProductPrice, ProductQuantity, ImageURL);
                    if (this.productSplit == null) {                                //add total
                        this.productSplit = new ArrayList<>();
                    }
                    if (this.totalProduct == null) {                                //add total
                        this.totalProduct = new ArrayList<>();
                    }
                    this.totalProduct.add(dto);                                 //lấy tổng danh sách trong kho
                    this.productSplit.add(dto);
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
    }
}
