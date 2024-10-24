/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.ajax.event.servlet;

import florastore.eventOrderDetail.EventOrderDetailDAO;
import florastore.eventOrderDetail.PurchasedOrderDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "PurchasedOrderDetailServlet", urlPatterns = {"/PurchasedOrderDetailServlet"})
public class PurchasedOrderDetailServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        // Lấy orderId từ request
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        try (PrintWriter out = response.getWriter()) {
            EventOrderDetailDAO dao = new EventOrderDetailDAO();
            List<PurchasedOrderDetailDTO> listProduct = dao.getOrderInfoByOrderId(orderId);
            if (listProduct != null) {
                for (PurchasedOrderDetailDTO product : listProduct) {
                    String productRow = "<tr>"
                            + "<td style='text-align: center;'><img src=\"" + product.getProductImg() + "\" alt=\"" + product.getProductName() + "\" style=\"width: 75px; height: 75px; border-radius: 50%;\"></td>"
                            + "<td>" + product.getProductName() + "</td>"
                            + "<td style=\"text-align: center\">" + String.format("%,.0fđ", product.getUnitPrice()) + "</td>"
                            + "<td style=\"text-align: center\">" + product.getQuantity() + "</td>"
                            + "<td style=\"text-align: center\">" + String.format("%,.0fđ", product.getTotalAmount()) + "</td>"
                            + "</tr>";
                    out.println(productRow);
                }
            }
            out.flush();
        } catch (SQLException ex) {
            log("PurchasedOrderDetailServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("PurchasedOrderDetailServlet _Naming_ " + ex.getMessage());
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
