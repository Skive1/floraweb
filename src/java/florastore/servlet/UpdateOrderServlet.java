/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.event.EventDAO;
import florastore.event.EventOrderDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateOrderServlet", urlPatterns = {"/UpdateOrderServlet"})
public class UpdateOrderServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.ViewEventOrderFeatures.VIEW_ORDER_LIST);

        String orderIdStr = request.getParameter("eventOrderId");
        String action = request.getParameter("action");

        int orderId = Integer.parseInt(orderIdStr);

        String username = request.getParameter("accountUsername");
        String deliveryOpt = request.getParameter("deliveryOpt");
        
        LocalDateTime now = LocalDateTime.now();
        Timestamp deliveryDate = Timestamp.valueOf(now);
        
        
        String pageParam = request.getParameter("page"); // Get the current page number from the request  
        int currentPage = pageParam != null ? Integer.parseInt(pageParam) : 1; // Default to page 1 if not provided

        try {
            EventDAO dao = new EventDAO();
            if ("confirm".equals(action) && "Delivery".equals(deliveryOpt)) {
                dao.confirm(orderId); // Call the confirm method
            } else if ("confirm".equals(action) && "Pick Up".equals(deliveryOpt)) {
                dao.confirm2(orderId); // Call the confirm method
                //insert ngày giao
                dao.insertDeliveryDate(orderId, deliveryDate);
                //udpate trạng thái thanh toán thành true
                dao.updatePaymentStatus(orderId);
            } else if ("cancel".equals(action)) {
                dao.cancelOrder(orderId); // Call the cancel method
            }
            
            // Get total number of remaining orders for the current page after the update
            List<EventOrderDTO> orders = dao.getOrders(username);
            int totalOrders = orders.size();
            int pageSize = 6; // Same as in your ViewOrderServlet

            // If no orders left on the current page, go to the previous page
            if (currentPage > 1 && (currentPage - 1) * pageSize >= totalOrders) {
                currentPage--; // Go to previous page if current page is now empty
            }

            
            url = url + "?accountUsername=" + URLEncoder.encode(username, "UTF-8") + "&page=" + currentPage;
        } catch (SQLException ex) {
            log("UpdateOrderServlet _SQL_" + ex.getMessage());
        } catch (NamingException ex) {
            log("UpdateOrderServlet _Naming_" + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
