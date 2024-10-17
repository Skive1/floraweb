/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.flowerStore;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class FlowerStoreDTO implements Serializable {

    private String ownerUsername;
    private int storeId;
    private String storeName;
    private String storePhone;
    private String storeStreet;
    private String storeCity;
    private String img;

    public FlowerStoreDTO(String ownerUsername, int storeId, String storeName, String storePhone, String storeStreet, String storeCity, String img) {
        this.ownerUsername = ownerUsername;
        this.storeId = storeId;
        this.storeName = storeName;
        this.storePhone = storePhone;
        this.storeStreet = storeStreet;
        this.storeCity = storeCity;
        this.img = img;
    }

    /**
     * @return the ownerUsername
     */
    public String getOwnerUsername() {
        return ownerUsername;
    }

    /**
     * @param ownerUsername the ownerUsername to set
     */
    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    /**
     * @return the storeId
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * @param storeId the storeId to set
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * @return the storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @param storeName the storeName to set
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * @return the storePhone
     */
    public String getStorePhone() {
        return storePhone;
    }

    /**
     * @param storePhone the storePhone to set
     */
    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    /**
     * @return the storeStreet
     */
    public String getStoreStreet() {
        return storeStreet;
    }

    /**
     * @param storeStreet the storeStreet to set
     */
    public void setStoreStreet(String storeStreet) {
        this.storeStreet = storeStreet;
    }

    /**
     * @return the storeCity
     */
    public String getStoreCity() {
        return storeCity;
    }

    /**
     * @param storeCity the storeCity to set
     */
    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

}
