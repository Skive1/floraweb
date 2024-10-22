/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.flowerProducts;
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
public class FlowerProductsDAO implements Serializable {

    private List<FlowerProductsDTO> trending;

    public List<FlowerProductsDTO> getBestSellers() {
        return trending;
    }

    public void getBestSeller()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select TOP 8 ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "From FlowerProducts "
                        + "ORDER BY ProductId";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    //set data to DTO properties
                    FlowerProductsDTO dto
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
                    if (this.trending == null) {
                        this.trending = new ArrayList<>();
                    }//book is unavailable
                    this.trending.add(dto);
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
    }

    private List<FlowerProductsDTO> newest;

    public List<FlowerProductsDTO> getNewArrivals() {
        return newest;
    }

    public void getNewArrival()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select TOP 5 ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "From FlowerProducts "
                        + "ORDER BY ProductId DESC";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    //set data to DTO properties
                    FlowerProductsDTO dto
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
                    if (this.newest == null) {
                        this.newest = new ArrayList<>();
                    }//book is unavailable
                    this.newest.add(dto);
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
    }

    public FlowerProductsDTO getFlowerDetail(int id)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FlowerProductsDTO dto = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "From FlowerProducts "
                        + "Where ProductId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    //set data to DTO properties
                    dto
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
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
        return dto;
    }

    public FlowerProductsDTO getCheapestFlower()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FlowerProductsDTO dto = null;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select TOP 1 ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "From FlowerProducts "
                        + "ORDER BY ProductPrice ASC";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    //set data to DTO properties
                    dto
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
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
        return dto;
    }

    public FlowerProductsDTO getProductById(int id)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FlowerProductsDTO product = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "SELECT ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "FROM FlowerProducts "
                        + "WHERE productId = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                if (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    product
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
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
        return product;
    }
    // Example method to get all products

    public List<FlowerProductsDTO> getAllProducts()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FlowerProductsDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "FROM FlowerProducts";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    FlowerProductsDTO product
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
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

    public List<FlowerProductsDTO> getProductsByType(String type)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FlowerProductsDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "FROM FlowerProducts "
                        + "Where ProductType = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, type);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    FlowerProductsDTO product
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
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

    public List<FlowerProductsCategoryDTO> getProductsTypeAndQuantity()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FlowerProductsCategoryDTO> categories = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT Top 5 ProductType, COUNT(ProductType) as Quantity "
                        + "FROM FlowerProducts "
                        + "GROUP BY ProductType "
                        + "ORDER BY Quantity DESC";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String productType = rs.getString("ProductType");
                    int productTypeQuantity = rs.getInt("Quantity");
                    FlowerProductsCategoryDTO category
                            = new FlowerProductsCategoryDTO(productType, productTypeQuantity);
                    categories.add(category);
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
        return categories;
    }

    private List<FlowerProductsDTO> related;

    public List<FlowerProductsDTO> getRelatedProducts() {
        return related;
    }

    public List<FlowerProductsDTO> getRelatedProduct(int id, String type)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FlowerProductsDTO> products = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT TOP 5 ProductId, FlowerStoreStoreID, ProductName, ProductType, ProductCondition, ProductDetail, ProductPrice, ProductQuantity, Img "
                        + "FROM FlowerProducts "
                        + "Where ProductType = ? "
                        + "AND ProductId <> ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, type);
                stm.setInt(2, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    int productId = rs.getInt("ProductId");
                    int storeId = rs.getInt("FlowerStoreStoreID");
                    String productName = rs.getString("ProductName");
                    String productType = rs.getString("ProductType");
                    String productCondition = rs.getString("ProductCondition");
                    String productDetail = rs.getString("ProductDetail");
                    double productPrice = rs.getDouble("ProductPrice");
                    int productQuantity = rs.getInt("ProductQuantity");
                    String imageURL = rs.getString("Img");
                    FlowerProductsDTO dto
                            = new FlowerProductsDTO(productId, storeId, productName, productType, productCondition, productDetail, productPrice, productQuantity, imageURL);
                    if (this.related == null) {
                        this.related = new ArrayList<>();
                    }//related is unavailable
                    this.related.add(dto);
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
    
    public int getProductQuantityByName(String productName)
            throws SQLException, NamingException {
        
        int quantity = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT ProductQuantity "
                        + "FROM FlowerProducts "
                        + "Where ProductName = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, productName);
                
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    
                    quantity  = rs.getInt("ProductQuantity");
                    
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
        return quantity;
    }
}
