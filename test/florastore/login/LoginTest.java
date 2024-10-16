/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author ADMIN
 */
public class LoginTest {

    private static final String LOGIN_URL = "http://localhost:8084/FloraRewind/loginAction"; // Địa chỉ URL của LoginServlet

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
            {"admin", "123"},
            {"idoltuan", "123"},
            {"seller", "123"}
        };
    }
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws Exception {
        // Tạo kết nối
        URL url = new URL(LOGIN_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        // Gửi dữ liệu đăng nhập
        String postData = "txtUsername=" + username + "&txtPassword=" + password;
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = postData.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = connection.getResponseCode();
        Assert.assertEquals(responseCode, HttpURLConnection.HTTP_OK);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            Assert.assertTrue(response.toString().contains("Hi, ")); // Giả sử bạn có một thông báo này trong phản hồi
        }
    }
}
