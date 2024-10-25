/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventCart;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class EventCartItem implements Serializable {

    private int epId;
    private int eventId;
    private String eventName;
    private String epName;
    private String img;
    private int quantity;
    private double unitPrice;
    private int stockQuantity;

    public EventCartItem(int epId, int eventId, String eventName, String epName, String img, int quantity, double unitPrice, int stockQuantity) {
        this.epId = epId;
        this.eventId = eventId;
        this.eventName = eventName;
        this.epName = epName;
        this.img = img;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    /**
     * @return the eventId
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the epName
     */
    public String getEpName() {
        return epName;
    }

    /**
     * @param epName the epName to set
     */
    public void setEpName(String epName) {
        this.epName = epName;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
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
     * @return the stockQuantity
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * @param stockQuantity the stockQuantity to set
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * @return the epId
     */
    public int getEpId() {
        return epId;
    }

    /**
     * @param epId the epId to set
     */
    public void setEpId(int epId) {
        this.epId = epId;
    }

}
