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
public class EventProductAddNotification implements Serializable {
    private String eventProductAddSuccess;
    private String discountError;
    private String uploadImgError;

    public String getEventProductAddSuccess() {
        return eventProductAddSuccess;
    }

    public void setEventProductAddSuccess(String eventProductAddSuccess) {
        this.eventProductAddSuccess = eventProductAddSuccess;
    }

    public String getDiscountError() {
        return discountError;
    }

    public void setDiscountError(String discountError) {
        this.discountError = discountError;
    }

    public String getUploadImgError() {
        return uploadImgError;
    }

    public void setUploadImgError(String uploadImgError) {
        this.uploadImgError = uploadImgError;
    }
    
    
}
