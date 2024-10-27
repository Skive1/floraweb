/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.account;

import florastore.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class AccountDAO implements Serializable {

    public String getHashPassword(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String password = null;
        try {
            //1. connect database
            con = DBHelper.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT Password "
                        + "FROM Account "
                        + "WHERE Username = ? "
                        + "COLLATE Latin1_General_BIN ";
                //3.Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4.Query Data 
                rs = stm.executeQuery();
                //5.Process Data
                if (rs.next()) {
                    password = rs.getString("Password");
                }//username and password are verified
            }//connection has been available
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
        return password;
    }

    public AccountDTO getAccountByLogin(String username, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO dto = null;
        try {
            //1. connect database
            con = DBHelper.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT Fullname, Role, Email, Gender, Phone, Street, City, Img, isBanned "
                        + "FROM Account "
                        + "WHERE Username = ? "
                        + "COLLATE Latin1_General_BIN "
                        + "AND Password = ? "
                        + "COLLATE Latin1_General_BIN";
                //3.Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.Query Data 
                rs = stm.executeQuery();
                //5.Process Data
                if (rs.next()) {
                    String fullName = rs.getString("FullName");
                    String role = rs.getString("Role");
                    String email = rs.getString("Email");
                    String gender = rs.getString("Gender");
                    String phone = rs.getString("Phone");
                    String street = rs.getString("Street");
                    String city = rs.getString("City");
                    String img = rs.getString("Img");
                    int isBanned = rs.getInt("isBanned");
                    dto = new AccountDTO(username, password, fullName, role, email, gender, phone, street, city, img, isBanned);
                }//username and password are verified
            }//connection has been available
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
        return dto;
    }

    public boolean createAccount(AccountDTO dto)
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
                String sql = "Insert Into Account("
                        + "Username, Password, Fullname, Role, Email, Gender, Phone, Street, City"
                        + ") Values("
                        + "?, ?, ?, ?, ?, ?, ?, ?, ?"
                        + ")";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullName());
                stm.setString(4, dto.getRole());
                stm.setString(5, dto.getEmail());
                stm.setString(6, dto.getGender());
                stm.setString(7, dto.getPhone());
                stm.setString(8, dto.getStreet());
                stm.setString(9, dto.getCity());
                //4. Execute Query
                int affectedRows = stm.executeUpdate();
                //5. process result
                if (affectedRows > 0) {
                    result = true;
                }
            }//connection has been available
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

    public AccountDTO getAccountByGoogleAccount(String email) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO user = null;

        try {
            // Establish connection
            conn = DBHelper.getConnection();
            if (conn != null) {
                // Prepare SQL statement for querying the Account table by email
                String sql = "SELECT Email, Username, Fullname, Role, Gender, Phone, Street, City, Img, isBanned "
                        + "FROM Account "
                        + "WHERE Email = ?";

                // Prepare statement with email
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);

                // Execute the query
                rs = stm.executeQuery();

                // If the user exists, initialize the UserProfileDTO
                if (rs.next()) {
                    String username = rs.getString("Username");
                    String fullname = rs.getString("Fullname");
                    String role = rs.getString("Role");
                    String gender = rs.getString("Gender");
                    String phone = rs.getString("Phone");
                    String street = rs.getString("Street");
                    String city = rs.getString("City");
                    String img = rs.getString("Img");
                    int isBanned = rs.getInt("isBanned");
                    user = new AccountDTO(username, "", fullname, role, email, gender, phone, street, city, img, isBanned);
                }
            }
        } finally {
            // Close connections
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return user;
    }

    public AccountDTO checkExistedUsername(String username)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String validEmail = null;
        AccountDTO dto = null;

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "SELECT Email "
                        + "FROM Account "
                        + "WHERE Username = ? "
                        + "COLLATE Latin1_General_BIN";

                //3.Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                if (rs.next()) {
                    validEmail = rs.getString("Email");
                    dto = new AccountDTO(username, "", "", "", validEmail, "", "", "", "", "");
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
        return dto;
    }

    public boolean resetPassword(String password, String email)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "UPDATE Account "
                        + "SET Password = ? "
                        + "WHERE Email = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, email);

                //4. Execute querry
                int affectedRows = stm.executeUpdate();

                //5. process result
                if (affectedRows > 0) {
                    result = true; //nếu số dóng ảnh hưởng > 0 thì update được
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return result;
    }

    public AccountDTO getUserInfo(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO dto = null;
        try {
            //1. connect database
            con = DBHelper.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT Fullname, Email, Gender, Phone, Street, City, Img "
                        + "FROM Account "
                        + "WHERE Username = ? "
                        + "COLLATE Latin1_General_BIN";
                //3.Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4.Query Data 
                rs = stm.executeQuery();
                //5.Process Data
                if (rs.next()) {
                    String fullName = rs.getString("FullName");
                    String email = rs.getString("Email");
                    String gender = rs.getString("Gender");
                    String phone = rs.getString("Phone");
                    String street = rs.getString("Street");
                    String city = rs.getString("City");
                    String img = rs.getString("Img");
                    dto = new AccountDTO(username, "", fullName, "", email, gender, phone, street, city, img);
                }//username and password are verified
            }//connection has been available
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
        return dto;
    }

    public boolean updateAccount(String username, String gender, String phone, String street, String city)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. kết nối DB
            con = DBHelper.getConnection();
            if (con != null) { //nếu kết nối DB được
//                //lấy UserID
//                String sqlID = "SELECT UserID "
//                        + "FROM Account "
//                        + "WHERE Fullname = ?";
//                stm = con.prepareStatement(sqlID);
//                stm.setString(1, fullname);
//                rs = stm.executeQuery();
//                if (rs.next()) {
//                    UserID = rs.getString("UserID");
//                }
//                String sql = "UPDATE UserDetail "
//                        + "SET Street=?, Phone=? "
//                        + "WHERE UserID = ?";
//              2. khởi tạo lệnh SQL
                String sql = "UPDATE Account "
                        + "SET Phone = ?, Street = ?, City = ?, Gender = ? "
                        + "WHERE Username = ? ";
                //3. khởi tạo statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, phone);
                stm.setString(2, street);
                stm.setString(3, city);
                stm.setString(4, gender);
                stm.setString(5, username);

                //4. Execute querry
                int affectedRows = stm.executeUpdate();

                //5. process result
                if (affectedRows > 0) {
                    result = true; //nếu số dóng ảnh hưởng > 0 thì update được
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return result;
    }

    public int adminGetTotalAccount()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int total = 0;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String 
                String sql = "Select count(Username) AS Total "
                        + "From Account "
                        + "WHERE isBanned = 0";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                if (rs.next()) {
                    total = rs.getInt("Total");
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
        return total;
    }

    public List<AccountDTO> getAllAccount(int index)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<AccountDTO> list = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelper.getConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT Username, Fullname, Gender, Role, Email, Phone, Street, City, Img, isBanned "
                        + "FROM Account "
                        + "ORDER BY Username "
                        + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setInt(1, (index - 1) * 5);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process result
                while (rs.next()) {
                    //. map
                    //get data from Result Set
                    String Username = rs.getString("Username");
                    String Fullname = rs.getString("Fullname");
                    String Gender = rs.getString("Gender");
                    String Role = rs.getString("Role");
                    String Email = rs.getString("Email");
                    String Phone = rs.getString("Phone");
                    String Street = rs.getString("Street");
                    String City = rs.getString("City");
                    String Img = rs.getString("Img");
                    int isBanned = rs.getInt("isBanned");
                    AccountDTO account
                            = new AccountDTO(Username, "", Fullname, Role, Email, Gender, Phone, Street, City, Img, isBanned);
                    list.add(account);
                }//process each record in resultset  
            }//connection has been available 
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
        return list;
    }

    public boolean adminDeleteAccount(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            //1. kết nối DB
            con = DBHelper.getConnection();
            if (con != null) { //nếu kết nối DB được
                //2. khởi tạo lệnh SQL
                String sql = "UPDATE ACCOUNT "
                        + "SET isBanned = 1 "
                        + "WHERE Username = ? "
                        + "COLLATE Latin1_General_BIN";
                //3. khởi tạo statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute querry
                int affectedRows = stm.executeUpdate();
                //5. process result
                if (affectedRows > 0) {
                    result = true; //nếu số dóng ảnh hưởng > 0 thì update được
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return result;
    }

    public boolean adminEditAccount(String username, String role)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            //1. kết nối DB
            con = DBHelper.getConnection();
            if (con != null) { //nếu kết nối DB được
                //2. khởi tạo lệnh SQL
                String sql = "UPDATE ACCOUNT "
                        + "SET Role = ? "
                        + "WHERE Username = ? "
                        + "COLLATE Latin1_General_BIN";
                //3. khởi tạo statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, role);
                stm.setString(2, username);
                //4. Execute querry
                int affectedRows = stm.executeUpdate();
                //5. process result
                if (affectedRows > 0) {
                    result = true; //nếu số dóng ảnh hưởng > 0 thì update được
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return result;
    }
}
