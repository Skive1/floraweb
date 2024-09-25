/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.flowerProducts;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class FlowerProductsDTO implements Serializable{
    private int productId;
    private int storeId;
    private String productName;
    private String productType;
    private String productCondition;
    private String productDetail;
    private double productPrice;
    private int productQuantity;
    private String imageURL;

    public FlowerProductsDTO() {
    }

    public FlowerProductsDTO(int productId, int storeId, String productName, String productType, String productCondition, String productDetail, double productPrice, int productQuantity, String imageURL) {
        this.productId = productId;
        this.storeId = storeId;
        this.productName = productName;
        this.productType = productType;
        this.productCondition = productCondition;
        this.productDetail = productDetail;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.imageURL = imageURL;
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the storeId
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * @param storeId the storeId to set
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the productCondition
     */
    public String getProductCondition() {
        return productCondition;
    }

    /**
     * @param productCondition the productCondition to set
     */
    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    /**
     * @return the productDetail
     */
    public String getProductDetail() {
        return productDetail;
    }

    /**
     * @param productDetail the productDetail to set
     */
    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    /**
     * @return the productPrice
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the productPrice to set
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the productQuantity
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * @param productQuantity the productQuantity to set
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * @return the imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @param imageURL the imageURL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    
}
