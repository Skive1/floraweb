/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.decodeDataVNPay;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author ADMIN
 */
public class DecodeData implements Serializable {

    public String decodeResponse(String encodedQuery, String type) {

        String result = null;
        // Giải mã chuỗi query
        String decodedQuery = new String(Base64.getDecoder().decode(encodedQuery), StandardCharsets.UTF_8);
        // Tách các tham số từ chuỗi query
        String[] params = decodedQuery.split("&");
        String responseCode = null;
        String totalAmount = null;
        String status = null;
        String vnpOrderId = null;

        // Duyệt qua các tham số và lấy giá trị
        for (String param : params) {
            String[] pair = param.split("=");
            if (pair[0].equals("responseCode")) {
                responseCode = pair[1];
            } else if (pair[0].equals("totalamount")) {
                totalAmount = pair[1];
            } else if (pair[0].equals("status")) {
                status = pair[1];
            } else if (pair[0].equals("vnp_TxnRef")) {
                vnpOrderId = pair[1];
            }
        }
        if (null != type) {
            switch (type) {
                case "response":
                    result = responseCode;
                    break;
                case "totalamount":
                    result = totalAmount;
                    break;
                case "vnp_TxnRef":
                    result = vnpOrderId;
                    break;
                case "status":
                    result = status;
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
