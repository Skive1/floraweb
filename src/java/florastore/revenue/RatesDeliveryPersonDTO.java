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


public class RatesDeliveryPersonDTO implements Serializable{


    private int totalRateStar;
    private int totalRecords;
    private double rating;
    public RatesDeliveryPersonDTO() {
    }

    public RatesDeliveryPersonDTO(int totalRateStar, int totalRecords, double rating) {
        this.totalRateStar = totalRateStar;
        this.totalRecords = totalRecords;
        this.rating = rating;
    }

    public RatesDeliveryPersonDTO(int totalRateStar, int totalRecords) {
        this.totalRateStar = totalRateStar;
        this.totalRecords = totalRecords;
    }
    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
    /**
     * @return the totalRateStar
     */
    public int getTotalRateStar() {
        return totalRateStar;
    }

    /**
     * @param totalRateStar the totalRateStar to set
     */
    public void setTotalRateStar(int totalRateStar) {
        this.totalRateStar = totalRateStar;
    }

    /**
     * @return the totalRecords
     */
    public int getTotalRecords() {
        return totalRecords;
    }

    /**
     * @param totalRecords the totalRecords to set
     */
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
    

   
}
