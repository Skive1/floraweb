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
public class yearlyRevenueDTO implements Serializable{
    private int month;
    private float total;

    public yearlyRevenueDTO() {
    }

    public yearlyRevenueDTO(int month, float total) {
        this.month = month;
        this.total = total;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
}
