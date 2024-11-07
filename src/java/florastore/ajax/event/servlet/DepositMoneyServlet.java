/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.ajax.event.servlet;

import florastore.deliveryOrder2.DeliverDAO;
import florastore.account.AccountDTO;
import florastore.deliveryBalance.DeliveryBalanceDAO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
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
@WebServlet(name = "depositMoney", urlPatterns = {"/depositMoney"})
public class DepositMoneyServlet extends HttpServlet {

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

        String amountStr = (request.getParameter("amount") != null) ? request.getParameter("amount") : null;
        double amount = (amountStr != null) ? Double.parseDouble(amountStr) : 0;
        double currentBalance = 0;
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                AccountDTO user = (session.getAttribute("USER") != null) ? (AccountDTO) session.getAttribute("USER") : null;
                String role = (user != null) ? user.getRole() : null;
                if ("Delivery".equals(role) && amountStr != null) {
                    String username = (String) session.getAttribute("USERNAME");
                    DeliverDAO dao = new DeliverDAO();
                    int staffId = dao.getDeliveryStaffId(username);
                    DeliveryBalanceDAO eWallet = new DeliveryBalanceDAO();
                    currentBalance = eWallet.getCurrentBalance(staffId);
                    boolean result = eWallet.depositMoney(staffId, amount);
                    if (result) {
                        session.setAttribute("Staff_Balance", currentBalance + amount);
                        response.setContentType("application/json");
                        PrintWriter out = response.getWriter();
                        out.print("{\"success\": true, \"message\": \"Nạp tiền thành công!\", \"newBalance\": " + (currentBalance + amount) + "}");
                        out.flush();
                    } else {
                        // Nếu không cập nhật được số dư
                        response.setContentType("application/json");
                        PrintWriter out = response.getWriter();
                        out.print("{\"success\": false, \"message\": \"Nạp tiền thất bại.\"}");
                        out.flush();
                    }
                } else {
                    response.sendRedirect(MyAppConstants.DepositFeatures.ERROR);
                }
            }
        } catch (SQLException ex) {
            log("depositMoney _SQL_ " + ex.getMessage());
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"success\": false, \"message\": \"Có lỗi xảy ra: " + ex.getMessage() + "\"}");
            out.flush();
        } catch (NamingException ex) {
            log("depositMoney _Naming_ " + ex.getMessage());
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"success\": false, \"message\": \"Có lỗi xảy ra: " + ex.getMessage() + "\"}");
            out.flush();
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
