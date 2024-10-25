/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.ajax.event.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import florastore.eventFeedback.EventFeedbackDAO;
import florastore.rateDelivery.RateDeliveryDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "submitFeedbackServlet", urlPatterns = {"/submitFeedbackServlet"})
public class submitFeedbackServlet extends HttpServlet {

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
        // Thiết lập mã hóa cho request
        request.setCharacterEncoding("UTF-8");

        // Thiết lập mã hóa cho response
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Đọc dữ liệu JSON từ request
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        }
        // Sử dụng Gson để phân tích JSON
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonBuilder.toString(), JsonObject.class);
        int orderId = jsonObject.get("orderId").getAsInt();
        String feedback = jsonObject.get("feedback").getAsString();
        int starRating = jsonObject.get("rating").getAsInt();
        int deliveryId = jsonObject.get("staffId").getAsInt();

        try {
            EventFeedbackDAO dao = new EventFeedbackDAO();
            boolean result = dao.insertFeedback(orderId, feedback);
            RateDeliveryDAO rateDAO = new RateDeliveryDAO();
            boolean resultRate = rateDAO.ratingStar(starRating, orderId, deliveryId);
            if (result && resultRate) {
                // Phản hồi cho client
                response.getWriter().write("{\"success\": true}");
            }
        } catch (SQLException ex) {
            log("FeedbackCreateServlet _SQL _ " + ex.getMessage());
        } catch (NamingException ex) {
            log("FeedbackCreateServlet _Naming _ " + ex.getMessage());
        } finally {

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
