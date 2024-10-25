/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.revenue;

import java.io.Serializable;

/**
 *
 * @author acer
 */
public class EventSellerDTO implements Serializable{
    private String evId;
    private String evName;

    public EventSellerDTO() {
    }

    public EventSellerDTO(String evId, String evName) {
        this.evId = evId;
        this.evName = evName;
    }

    /**
     * @return the evId
     */
    public String getEvId() {
        return evId;
    }

    /**
     * @param evId the evId to set
     */
    public void setEvId(String evId) {
        this.evId = evId;
    }

    /**
     * @return the evName
     */
    public String getEvName() {
        return evName;
    }

    /**
     * @param evName the evName to set
     */
    public void setEvName(String evName) {
        this.evName = evName;
    }
    
}
