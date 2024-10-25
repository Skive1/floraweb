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
public class DeliveryRevenueDTO implements Serializable{
    private int year;
    private int month;
    private String staffId;
    private double total;

    public DeliveryRevenueDTO() {
    }
    
    public DeliveryRevenueDTO(int year, int month, double total) {
        this.year = year;
        this.month = month;
        this.total = total;
    }

    public DeliveryRevenueDTO(int year, int month, String staffId, double total) {
        this.year = year;
        this.month = month;
        this.staffId = staffId;
        this.total = total;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
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
     * @return the staffId
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * @param staffId the staffId to set
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }   
}
