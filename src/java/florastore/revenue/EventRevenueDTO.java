/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.revenue;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author acer
 */
public class EventRevenueDTO implements Serializable{
    private Date oderDate;
    private String eId;
    private String name;
    private double price;
    private int sold;
    private double total;

    public EventRevenueDTO() {
    }

    public EventRevenueDTO(double total) {
        this.total = total;
    }
    
    public EventRevenueDTO(Date oderDate, String eId, String name, double price, int sold, double total) {
        this.oderDate = oderDate;
        this.eId = eId;
        this.name = name;
        this.price = price;
        this.sold = sold;
        this.total = total;
    }

    /**
     * @return the oderDate
     */
    public Date getOderDate() {
        return oderDate;
    }

    /**
     * @param oderDate the oderDate to set
     */
    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    /**
     * @return the eId
     */
    public String geteId() {
        return eId;
    }

    /**
     * @param eId the eId to set
     */
    public void seteId(String eId) {
        this.eId = eId;
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
