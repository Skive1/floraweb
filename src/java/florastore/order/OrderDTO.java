/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.order;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class OrderDTO implements Serializable {

    private String username;
    private int storeId;
    private String fullname;
    private String phone;
    private String street;
    private String city;
    private Timestamp deliveryDate;
    private String deliveryOptions;
    private String paymentOptions;
    private String status;
    private double ammount;
    private boolean paid;
    private String note;

    public OrderDTO(String fullname, String phone, String street, String city, String deliveryOptions, String paymentOptions, String note) {
        this.fullname = fullname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.deliveryOptions = deliveryOptions;
        this.paymentOptions = paymentOptions;
        this.note = note;
    }

    public OrderDTO(String username, int storeId, String fullname, String phone, String street, String city, Timestamp deliveryDate, String deliveryOptions, String paymentOptions, String status, double ammount, boolean paid, String note) {
        this.username = username;
        this.storeId = storeId;
        this.fullname = fullname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.deliveryDate = deliveryDate;
        this.deliveryOptions = deliveryOptions;
        this.paymentOptions = paymentOptions;
        this.status = status;
        this.ammount = ammount;
        this.paid = paid;
        this.note = note;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the deliveryDate
     */
    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the deliveryOptions
     */
    public String getDeliveryOptions() {
        return deliveryOptions;
    }

    /**
     * @param deliveryOptions the deliveryOptions to set
     */
    public void setDeliveryOptions(String deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }

    /**
     * @return the paymentOptions
     */
    public String getPaymentOptions() {
        return paymentOptions;
    }

    /**
     * @param paymentOptions the paymentOptions to set
     */
    public void setPaymentOptions(String paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the ammount
     */
    public double getAmmount() {
        return ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    /**
     * @return the paid
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

}
