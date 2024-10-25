/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.rateDelivery;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class RateDeliveryDTO implements Serializable {

    private int rateFeedbackId;
    private int rateStar;
    private int eventOrderId;
    private int staffId;

    public RateDeliveryDTO() {
    }

    public RateDeliveryDTO(int rateFeedbackId, int rateStar, int eventOrderId, int staffId) {
        this.rateFeedbackId = rateFeedbackId;
        this.rateStar = rateStar;
        this.eventOrderId = eventOrderId;
        this.staffId = staffId;
    }

    public RateDeliveryDTO(int rateStar, int eventOrderId, int staffId) {
        this.rateStar = rateStar;
        this.eventOrderId = eventOrderId;
        this.staffId = staffId;
    }

    /**
     * @return the rateFeedbackId
     */
    public int getRateFeedbackId() {
        return rateFeedbackId;
    }

    /**
     * @param rateFeedbackId the rateFeedbackId to set
     */
    public void setRateFeedbackId(int rateFeedbackId) {
        this.rateFeedbackId = rateFeedbackId;
    }

    /**
     * @return the rateStar
     */
    public int getRateStar() {
        return rateStar;
    }

    /**
     * @param rateStar the rateStar to set
     */
    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
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
     * @return the staffId
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * @param staffId the staffId to set
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

}
