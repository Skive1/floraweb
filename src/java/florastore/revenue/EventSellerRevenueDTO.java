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
public class EventSellerRevenueDTO implements Serializable{
    private String month;
    private String name;
    private double price;
    private int sold;
    private double total;

    public EventSellerRevenueDTO() {
    }

    public EventSellerRevenueDTO(String month, String name, double price, int sold, double total) {
        this.month = month;
        this.name = name;
        this.price = price;
        this.sold = sold;
        this.total = total;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
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
