/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.delivery;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class DeliveryDTO implements Serializable {
    
    private String username;
    private int staffId;
    private String phone;

    public DeliveryDTO() {
    }

    public DeliveryDTO(String username, int staffId, String phone) {
        this.username = username;
        this.staffId = staffId;
        this.phone = phone;
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
    
    

}
