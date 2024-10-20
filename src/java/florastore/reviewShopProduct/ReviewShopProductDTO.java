/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.reviewShopProduct;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class ReviewShopProductDTO implements Serializable {

    private String username;
    private int reviewShopId;
    private String status;
    private int shopProductId;
    private Timestamp reviewDate;

    public ReviewShopProductDTO() {
    }

    public ReviewShopProductDTO(String username, int reviewShopId, String status, int shopProductId, Timestamp reviewDate) {
        this.username = username;
        this.reviewShopId = reviewShopId;
        this.status = status;
        this.shopProductId = shopProductId;
        this.reviewDate = reviewDate;
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
     * @return the reviewShopId
     */
    public int getReviewShopId() {
        return reviewShopId;
    }

    /**
     * @param reviewShopId the reviewShopId to set
     */
    public void setReviewShopId(int reviewShopId) {
        this.reviewShopId = reviewShopId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the shopProductId
     */
    public int getShopProductId() {
        return shopProductId;
    }

    /**
     * @param shopProductId the shopProductId to set
     */
    public void setShopProductId(int shopProductId) {
        this.shopProductId = shopProductId;
    }

    /**
     * @return the reviewDate
     */
    public Timestamp getReviewDate() {
        return reviewDate;
    }

    /**
     * @param reviewDate the reviewDate to set
     */
    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

}
