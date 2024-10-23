/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventOrderDetail;

/**
 *
 * @author ADMIN
 */
public class PurchasedOrderDetailDTO {

    private String productName;
    private String productImg;
    private double unitPrice;
    private int quantity;
    private double totalAmount;

    public PurchasedOrderDetailDTO() {
    }

    public PurchasedOrderDetailDTO(String productName, String productImg, double unitPrice, int quantity, double totalAmount) {
        this.productName = productName;
        this.productImg = productImg;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
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
     * @return the productImg
     */
    public String getProductImg() {
        return productImg;
    }

    /**
     * @param productImg the productImg to set
     */
    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
