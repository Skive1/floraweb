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
    private int ProductID;
    private int StoreId;
    private String ProductName;
    private String ProductType;
    private String ProductCondition;
    private String ProductDetail;
    private int ProductPrice;
    private int ProductQuantity;
    private String ImageURL;

    public ProductDTO(int ProductId, int StoreId, String ProductName, String ProductType, String ProductCondition, String ProductDetail, int ProductPrice, int ProductQuantity, String ImageURL) {
        this.ProductID = ProductId;
        this.StoreId = StoreId;
        this.ProductName = ProductName;
        this.ProductType = ProductType;
        this.ProductCondition = ProductCondition;
        this.ProductDetail = ProductDetail;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
        this.ImageURL = ImageURL;
    }

    public ProductDTO() {
    }

    public int getProductId() {
        return ProductID;
    }

    public void setProductId(int ProductId) {
        this.ProductID = ProductId;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int StoreId) {
        this.StoreId = StoreId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }

    public String getProductCondition() {
        return ProductCondition;
    }

    public void setProductCondition(String ProductCondition) {
        this.ProductCondition = ProductCondition;
    }

    public String getProductDetail() {
        return ProductDetail;
    }

    public void setProductDetail(String ProductDetail) {
        this.ProductDetail = ProductDetail;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(int ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int ProductQuantity) {
        this.ProductQuantity = ProductQuantity;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }
    
    
}
