/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventProduct;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class EventProductDTO implements Serializable {

    private int eventEventId;
    private int eventProductId;
    private int eventId;
    private String eventProductName;
    private String eventProductType;
    private String eventProductCondition;
    private String eventProductDetail;
    private String eventProductImg;
    private int eventProductQuantity;
    private double eventProductPrice;
    private int isDel;

    public EventProductDTO() {
    }

    public EventProductDTO(String eventProductCondition) {
        this.eventProductCondition = eventProductCondition;
    }

    public EventProductDTO(int eventEventId, int eventProductId, String eventProductName, String eventProductType, String eventProductCondition, String eventProductDetail, String eventProductImg, int eventProductQuantity, double eventProductPrice) {
        this.eventEventId = eventEventId;
        this.eventProductId = eventProductId;
        this.eventProductName = eventProductName;
        this.eventProductType = eventProductType;
        this.eventProductCondition = eventProductCondition;
        this.eventProductDetail = eventProductDetail;
        this.eventProductImg = eventProductImg;
        this.eventProductQuantity = eventProductQuantity;
        this.eventProductPrice = eventProductPrice;
    }

    public EventProductDTO(int eventProductId, String eventProductName, String eventProductType, String eventProductCondition, String eventProductDetail, String eventProductImg, int eventProductQuantity, double eventProductPrice) {
        this.eventProductId = eventProductId;
        this.eventProductName = eventProductName;
        this.eventProductType = eventProductType;
        this.eventProductCondition = eventProductCondition;
        this.eventProductDetail = eventProductDetail;
        this.eventProductImg = eventProductImg;
        this.eventProductQuantity = eventProductQuantity;
        this.eventProductPrice = eventProductPrice;
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

    /**
     * @return the eventProductName
     */
    public String getEventProductName() {
        return eventProductName;
    }

    /**
     * @param eventProductName the eventProductName to set
     */
    public void setEventProductName(String eventProductName) {
        this.eventProductName = eventProductName;
    }

    /**
     * @return the eventProductType
     */
    public String getEventProductType() {
        return eventProductType;
    }

    /**
     * @param eventProductType the eventProductType to set
     */
    public void setEventProductType(String eventProductType) {
        this.eventProductType = eventProductType;
    }

    /**
     * @return the eventProductCondition
     */
    public String getEventProductCondition() {
        return eventProductCondition;
    }

    /**
     * @param eventProductCondition the eventProductCondition to set
     */
    public void setEventProductCondition(String eventProductCondition) {
        this.eventProductCondition = eventProductCondition;
    }

    /**
     * @return the eventProductDetail
     */
    public String getEventProductDetail() {
        return eventProductDetail;
    }

    /**
     * @param eventProductDetail the eventProductDetail to set
     */
    public void setEventProductDetail(String eventProductDetail) {
        this.eventProductDetail = eventProductDetail;
    }

    /**
     * @return the eventProductImg
     */
    public String getEventProductImg() {
        return eventProductImg;
    }

    /**
     * @param eventProductImg the eventProductImg to set
     */
    public void setEventProductImg(String eventProductImg) {
        this.eventProductImg = eventProductImg;
    }

    /**
     * @return the eventProductQuantity
     */
    public int getEventProductQuantity() {
        return eventProductQuantity;
    }

    /**
     * @param eventProductQuantity the eventProductQuantity to set
     */
    public void setEventProductQuantity(int eventProductQuantity) {
        this.eventProductQuantity = eventProductQuantity;
    }

    /**
     * @return the eventProductPrice
     */
    public double getEventProductPrice() {
        return eventProductPrice;
    }

    /**
     * @param eventProductPrice the eventProductPrice to set
     */
    public void setEventProductPrice(double eventProductPrice) {
        this.eventProductPrice = eventProductPrice;
    }

    /**
     * @return the eventEventId
     */
    public int getEventEventId() {
        return eventEventId;
    }

    /**
     * @param eventEventId the eventEventId to set
     */
    public void setEventEventId(int eventEventId) {
        this.eventEventId = eventEventId;
    }

}
