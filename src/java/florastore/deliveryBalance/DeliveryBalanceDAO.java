/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.deliveryBalance;

import florastore.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class DeliveryBalanceDAO implements Serializable {

    public boolean createEWallet(int staffId)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "INSERT INTO DeliveryBalance ("
                        + "DeliveryStaffId, Balance"
                        + ") Values ("
                        + "?, ?"
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setInt(1, staffId);
                stm.setInt(2, 0);
                int affectedRows = stm.executeUpdate();
                if (affectedRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public DeliveryBalanceDTO getWalletInfo(int staffId)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DeliveryBalanceDTO wallet = new DeliveryBalanceDTO();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select BalanceId, Balance "
                        + "From DeliveryBalance "
                        + "Where DeliveryStaffId = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, staffId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int balanceId = rs.getInt("BalanceId");
                    double balance = rs.getDouble("Balance");
                    wallet = new DeliveryBalanceDTO(balanceId, balance);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return wallet;
    }

    public double getCurrentBalance(int staffId)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        double currentBalance = 0;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select Balance "
                        + "From DeliveryBalance "
                        + "Where DeliveryStaffId = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, staffId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    currentBalance = rs.getDouble("Balance");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return currentBalance;
    }

    public boolean depositMoney(int staffId, double amount)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "UPDATE DeliveryBalance "
                        + "SET Balance = Balance + ? "
                        + "Where DeliveryStaffId = ?";
                stm = con.prepareStatement(sql);
                stm.setDouble(1, amount);
                stm.setInt(2, staffId);
                int affectedRows = stm.executeUpdate();
                if (affectedRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean withDrawMoney(int staffId, double amount)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "UPDATE DeliveryBalance "
                        + "SET Balance = Balance - ? "
                        + "Where DeliveryStaffId = ?";
                stm = con.prepareStatement(sql);
                stm.setDouble(1, amount);
                stm.setInt(2, staffId);
                int affectedRows = stm.executeUpdate();
                if (affectedRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public String checkEWalletExisted(int staffId)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            //1. connect db
            con = DBHelper.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT CASE "
                        + "WHEN EXISTS (SELECT 1 FROM DeliveryBalance WHERE DeliveryStaffId = ?) "
                        + "THEN 'TRUE' "
                        + "ELSE 'FALSE' "
                        + "END AS CheckResult ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, staffId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("CheckResult");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
