/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchProduct;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class ProductDTO implements Serializable{
    private int productID;
    private int storeId;
    private String productName;
    private String productType;
    private String productCondition;
    private String productDetail;
    private int productPrice;
    private int productQuantity;
    private String imageURL;
    private int categoryID;

    public ProductDTO(int productID, int storeId, String productName, String productType, String productCondition, String productDetail, int productPrice, int productQuantity, String imageURL, int categoryID) {
        this.productID = productID;
        this.storeId = storeId;
        this.productName = productName;
        this.productType = productType;
        this.productCondition = productCondition;
        this.productDetail = productDetail;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.imageURL = imageURL;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
    
}
