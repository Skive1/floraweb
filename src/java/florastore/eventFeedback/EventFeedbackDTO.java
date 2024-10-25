/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventFeedback;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class EventFeedbackDTO implements Serializable {

    private String username;
    private String feedback;
    private int eventOrderId;
    private int feedbackId;
    private String fullname;

    public EventFeedbackDTO() {
    }

    public EventFeedbackDTO(String username, String feedback, int eventOrderId, int feedbackId) {
        this.username = username;
        this.feedback = feedback;
        this.eventOrderId = eventOrderId;
        this.feedbackId = feedbackId;
    }

    public EventFeedbackDTO(String username, String feedback, int eventOrderId, int feedbackId, String fullname) {
        this.username = username;
        this.feedback = feedback;
        this.eventOrderId = eventOrderId;
        this.feedbackId = feedbackId;
        this.fullname = fullname;
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
     * @return the feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
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
     * @return the feedbackId
     */
    public int getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId the feedbackId to set
     */
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
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

}
