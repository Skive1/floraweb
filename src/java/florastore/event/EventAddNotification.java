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
public class EventAddNotification implements Serializable{
    private String eventNameError;
    private String eventAddSuccess;
    private String uploadImgError;

    public String getEventNameError() {
        return eventNameError;
    }

    public void setEventNameError(String eventNameError) {
        this.eventNameError = eventNameError;
    }

    public String getEventAddSuccess() {
        return eventAddSuccess;
    }

    public void setEventAddSuccess(String eventAddSuccess) {
        this.eventAddSuccess = eventAddSuccess;
    }

    public String getUploadImgError() {
        return uploadImgError;
    }

    public void setUploadImgError(String uploadImgError) {
        this.uploadImgError = uploadImgError;
    }
    
    
}


