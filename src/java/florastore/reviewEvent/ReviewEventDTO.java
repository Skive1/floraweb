/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.reviewEvent;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class ReviewEventDTO implements Serializable {

    private String username;
    private int reviewEventId;
    private String status;
    private int eventProductId;
    private Timestamp reviewDate;

    public ReviewEventDTO() {
    }

    public ReviewEventDTO(String username, int reviewEventId, String status, int eventProductId, Timestamp reviewDate) {
        this.username = username;
        this.reviewEventId = reviewEventId;
        this.status = status;
        this.eventProductId = eventProductId;
        this.reviewDate = reviewDate;
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
     * @return the reviewEventId
     */
    public int getReviewEventId() {
        return reviewEventId;
    }

    /**
     * @param reviewEventId the reviewEventId to set
     */
    public void setReviewEventId(int reviewEventId) {
        this.reviewEventId = reviewEventId;
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
     * @return the reviewDate
     */
    public Timestamp getReviewDate() {
        return reviewDate;
    }

    /**
     * @param reviewDate the reviewDate to set
     */
    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

}
