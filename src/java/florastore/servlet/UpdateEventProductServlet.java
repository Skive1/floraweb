/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.event.EventDAO;
import florastore.event.EventOrderDTO;
import florastore.event.EventProductDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
@WebServlet(name = "UpdateEventProductServlet", urlPatterns = {"/UpdateEventProductServlet"})
public class UpdateEventProductServlet extends HttpServlet {

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

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SellerManagementFeatures.VIEW_EVENT_PRODUCT);

        String epIdStr = request.getParameter("eventProductId");
        String action = request.getParameter("action");

        int epId = Integer.parseInt(epIdStr);

        String eventIdStr = request.getParameter("eventId");
        int eId = Integer.parseInt(eventIdStr);
        
        String pageParam = request.getParameter("page"); // Get the current page number from the request  
        int currentPage = pageParam != null ? Integer.parseInt(pageParam) : 1; // Default to page 1 if not provided

        try {
            EventDAO dao = new EventDAO();
            if (action != null) {
                dao.updateEPStatus(epId);
            }
            
            // Get total number of remaining orders for the current page after the update
            List<EventProductDTO> products = dao.getAvailableEventFlower(eId);
            int totalProducts = products.size();
            int pageSize = 5; // Same as in your ViewOrderServlet

            // If no orders left on the current page, go to the previous page
            if (currentPage > 1 && (currentPage - 1) * pageSize >= totalProducts) {
                currentPage--; // Go to previous page if current page is now empty
            }
            
            url = url + "?eventId=" + eId + "&page=" + currentPage;
        } catch (SQLException ex) {
            log("UpdateEventProductServlet _SQL_" + ex.getMessage());
        } catch (NamingException ex) {
            log("UpdateEventProductServlet _Naming_" + ex.getMessage());
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
