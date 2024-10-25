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
                    sql = "SELECT ProductId, FlowerStoreStoreId, ProductName, ProductType, ProductCondition, ProductDetail, "
                            + "ProductPrice, ProductQuantity, Img, CategoryCategoryId "
                            + "FROM FlowerProducts";
                    stm = con.prepareStatement(sql);
                } else {
                    sql = "SELECT ProductId, FLowerStoreStoreId, ProductName, ProductType, ProductCondition, ProductDetail, "
                            + "ProductPrice, ProductQuantity, Img, CategoryCategoryId "
                            + "FROM FlowerProducts WHERE ProductName LIKE ?";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, "%" + searchValue + "%");
                }
                rs = stm.executeQuery();
                while (rs.next()) {
                    //get data from result set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreId");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    int productPrice = rs.getInt("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    int categoryID = rs.getInt("CategoryCategoryId");
                    //set data to DTO properties
                    ProductDTO dto = new ProductDTO(productId, storeId, productName, productType, productCondition,
                            productDetail, productPrice, productQuantity, imageURL, categoryID);
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

    public List<ProductDTO> searchAllProduct() throws SQLException, NamingException {
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<ProductDTO> result = new ArrayList<>();
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                //String sql = "SELECT * FROM FlowerProducts WHERE ProductName LIKE ?";
                String sql = null;
                sql = "SELECT ProductId, FlowerStoreStoreId, ProductName, ProductType, ProductCondition, ProductDetail, "
                        + "ProductPrice, ProductQuantity, Img, CategoryCategoryId "
                        + "FROM FlowerProducts";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    //get data from result set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreId");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    int productPrice = rs.getInt("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    int categoryID = rs.getInt("CategoryCategoryId");
                    //set data to DTO properties
                    ProductDTO dto = new ProductDTO(productId, storeId, productName, productType, productCondition,
                            productDetail, productPrice, productQuantity, imageURL, categoryID);
                    result.add(dto);
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
        return result;
    }
}
