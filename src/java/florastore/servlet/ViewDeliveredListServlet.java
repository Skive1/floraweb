/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.event.EventDAO;
import florastore.event.EventOrderDTO;
import florastore.event.EventOrderDetailDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ViewDeliveredListServlet", urlPatterns = {"/ViewDeliveredListServlet"})
public class ViewDeliveredListServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.ViewEventOrderFeatures.RESTRICT);

        HttpSession session = request.getSession(false);
        AccountDTO dto = null;
        String username = null;

        try {
            if (session != null) {
                username = (String) session.getAttribute("USERNAME");
                dto = (AccountDTO) session.getAttribute("USER");
                if ("Seller".equals(dto.getRole())) {
                    url = (String) siteMap.get(MyAppConstants.ViewEventOrderFeatures.DELIVERED_LIST_PAGE);
                    EventDAO dao = new EventDAO();
                    List<EventOrderDTO> delivered = dao.getDeliveredOrder(username);

                    // Paging
                    int pageSize = 10; // Number of orders per page
                    String pageParam = request.getParameter("page"); // Get the current page number from the request
                    int currentPage = pageParam != null ? Integer.parseInt(pageParam) : 1; // Default to page 1 if not provided
                    int totalOrders = delivered.size();
                    int totalPages = (int) Math.ceil((double) totalOrders / pageSize);

                    // Calculate the starting and ending indexes for the sublist of products to display
                    int start = (currentPage - 1) * pageSize;
                    int end = Math.min(start + pageSize, totalOrders);

                    // Get the products for the current page
                    List<EventOrderDTO> ordersForPage = delivered.subList(start, end);

                    //call method of order detail
                    // Map to store order details for each order
                    Map<Integer, List<EventOrderDetailDTO>> allOrderDetails = new HashMap<>();

                    for (EventOrderDTO order : delivered) {
                        // Call method to get the details for each order
                        List<EventOrderDetailDTO> details = dao.getOrderDetails(order.getEventOrderId());

                        // Store the details in the map with the eventOrderId as the key
                        allOrderDetails.put(order.getEventOrderId(), details);
                    }

                    session.setAttribute("DETAILS", allOrderDetails);
                    session.setAttribute("DELIVERED", ordersForPage);
                    request.setAttribute("currentPage", currentPage);
                    request.setAttribute("totalPages", totalPages);
                }
            } else if (session == null) {
                url = MyAppConstants.ViewEventOrderFeatures.SESSION_PAGE;
                response.sendRedirect(url);
            }
        } catch (SQLException ex) {
            log("ViewDeliveredListServlet_SQL_" + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewDeliveredListServlet_Naming_" + ex.getMessage());
        } finally {
            if (!response.isCommitted()) {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
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
