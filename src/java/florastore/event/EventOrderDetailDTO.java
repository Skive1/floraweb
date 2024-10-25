/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.event;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class EventOrderDetailDTO implements Serializable {
    private int quantity;
    private double unitPrice;
    private double discount;
    private double total;
    private int eventOrderId;
    private String eventProductName;

    public EventOrderDetailDTO() {
    }

    public EventOrderDetailDTO(int quantity, double unitPrice, double discount, double total, int eventOrderId, String eventProductName) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.total = total;
        this.eventOrderId = eventOrderId;
        this.eventProductName = eventProductName;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEventOrderId() {
        return eventOrderId;
    }

    public void setEventOrderId(int eventOrderId) {
        this.eventOrderId = eventOrderId;
    }

    public String getEventProductName() {
        return eventProductName;
    }

    public void setEventProductName(String eventProductName) {
        this.eventProductName = eventProductName;
    }
    
    
}
