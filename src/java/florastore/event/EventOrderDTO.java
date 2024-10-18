/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.event;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class EventOrderDTO implements Serializable{
    private int eventId;
    private int eventOrderId;
    private String fullname;
    private String phone;
    private String street;
    private String city;
    private Timestamp deliveryDate;
    private String deliveryOption;
    private String status;
    private double amount;
    private int deliveryStaffId;
    private boolean isPaid;
    private String paymentOptions;
    private String note;

    public EventOrderDTO() {
    }

    public EventOrderDTO(int eventId, int eventOrderId, 
            String fullname, String phone, String street, String city, 
            Timestamp deliveryDate, String deliveryOption, String status, 
            double amount, int deliveryStaffId, boolean isPaid, String paymentOptions, String note) {
        this.eventId = eventId;
        this.eventOrderId = eventOrderId;
        this.fullname = fullname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.deliveryDate = deliveryDate;
        this.deliveryOption = deliveryOption;
        this.status = status;
        this.amount = amount;
        this.deliveryStaffId = deliveryStaffId;
        this.isPaid = isPaid;
        this.paymentOptions = paymentOptions;
        this.note = note;
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
     * @return the deliveryOption
     */
    public String getDeliveryOption() {
        return deliveryOption;
    }

    /**
     * @param deliveryOption the deliveryOption to set
     */
    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the deliveryStaffId
     */
    public int getDeliveryStaffId() {
        return deliveryStaffId;
    }

    /**
     * @param deliveryStaffId the deliveryStaffId to set
     */
    public void setDeliveryStaffId(int deliveryStaffId) {
        this.deliveryStaffId = deliveryStaffId;
    }

    /**
     * @return the isPaid
     */
    public boolean isIsPaid() {
        return isPaid;
    }

    /**
     * @param isPaid the isPaid to set
     */
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
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
    
