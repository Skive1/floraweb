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
    private int sold;
    
    public yearlyRevenueDTO() {
    }

    public yearlyRevenueDTO(int month, float total) {
        this.month = month;
        this.total = total;
    }

    public yearlyRevenueDTO(int month, float total, int sold) {
        this.month = month;
        this.total = total;
        this.sold = sold;
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

    /**
     * @return the sold
     */
    public int getSold() {
        return sold;
    }

    /**
     * @param sold the sold to set
     */
    public void setSold(int sold) {
        this.sold = sold;
    }
    
}
