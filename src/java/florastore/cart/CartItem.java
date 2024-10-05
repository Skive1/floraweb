/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.cart;

import java.io.Serializable;

/**
 *
 * @author HaiQuan
 */
public class CartItem implements Serializable{
    private String imageURL;
    private String name;
    private int quantity;
    private double unitPrice;
    private int stockQuantity; // Add stock quantity field

    // Constructor
    public CartItem(String imageURL, String name, int quantity, double unitPrice, int stockQuantity) {
        this.imageURL = imageURL;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity; // Initialize stock quantity
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    
}



    

    
