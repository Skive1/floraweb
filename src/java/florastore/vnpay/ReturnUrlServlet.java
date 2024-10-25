/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.vnpay;

import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ReturnUrlServlet", urlPatterns = {"/ReturnUrlServlet"})
public class ReturnUrlServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = MyAppConstants.PlaceOrderFeatures.CHECKOUT_SUCCESS;
        // Nhận các thông tin phản hồi từ VNPay
        String vnp_ResponseCode = request.getParameter("vnp_ResponseCode");
        double totalAmount = Double.parseDouble(request.getParameter("vnp_Amount")) / 100;
        String vnp_TxnRef = request.getParameter("vnp_TxnRef");
        String total = String.valueOf(totalAmount);
        String query = "responseCode=00&totalamount=" + total + "&vnp_TxnRef=" + vnp_TxnRef + "&status=paid";
        String encodedQuery = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));
        // Kiểm tra mã phản hồi
        if ("00".equals(vnp_ResponseCode)) {
            // Thanh toán thành công, xử lý lưu đơn hàng
            // Chuyển hướng đến trang xác nhận đơn hàng
            response.sendRedirect(url + "?data=" + encodedQuery);
        } else {
            url = MyAppConstants.PlaceOrderFeatures.CHECKOUT_FAIL;
            // Thanh toán thất bại, chuyển hướng đến trang checkout
            response.sendRedirect(url + "?total=" + total);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
