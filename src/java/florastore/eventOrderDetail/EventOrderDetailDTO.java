/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventOrderDetail;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class EventOrderDetailDTO implements Serializable{
    private int quantity;
    private double  unitPrice;
    private double discount;
    private double total;
    private int eventOrderId;
    private int eventProductId;

    public EventOrderDetailDTO(int quantity, double unitPrice, double discount, double total, int eventOrderId, int eventProductId) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.total = total;
        this.eventOrderId = eventOrderId;
        this.eventProductId = eventProductId;
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
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the eventOrderId
     */
    public int getEventOrderId() {
        return eventOrderId;
    }

    /**
     * @param eventOrderId the eventOrderId to set
     */
    public void setEventOrderId(int eventOrderId) {
        this.eventOrderId = eventOrderId;
    }

    /**
     * @return the eventProductId
     */
    public int getEventProductId() {
        return eventProductId;
    }

    /**
     * @param eventProductId the eventProductId to set
     */
    public void setEventProductId(int eventProductId) {
        this.eventProductId = eventProductId;
    }
    
    
}
