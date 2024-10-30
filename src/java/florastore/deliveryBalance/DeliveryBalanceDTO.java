/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.deliveryBalance;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class DeliveryBalanceDTO implements Serializable {

    private int deliveryStaffId;
    private int balanceId;
    private double balance;

    public DeliveryBalanceDTO() {
    }

    public DeliveryBalanceDTO(int deliveryStaffId, int balanceId, double balance) {
        this.deliveryStaffId = deliveryStaffId;
        this.balanceId = balanceId;
        this.balance = balance;
    }

    public DeliveryBalanceDTO(int deliveryStaffId, double balance) {
        this.deliveryStaffId = deliveryStaffId;
        this.balance = balance;
    }

    /**
     * @return the deliveryStaffId
     */
    public int getDeliveryStaffId() {
        return deliveryStaffId;
    }

    /**
     * @param deliveryStaffId the deliveryStaffId to set
     */
    public void setDeliveryStaffId(int deliveryStaffId) {
        this.deliveryStaffId = deliveryStaffId;
    }

    /**
     * @return the balanceId
     */
    public int getBalanceId() {
        return balanceId;
    }

    /**
     * @param balanceId the balanceId to set
     */
    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
