/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.event.EventDAO;
import florastore.eventProduct.EventProductDAO;
import florastore.eventProduct.EventProductDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
 * @author ADMIN
 */
@WebServlet(name = "EventFlowerCategoryServlet", urlPatterns = {"/EventFlowerCategoryServlet"})
public class EventFlowerCategoryServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");

        //1. Get parameter from browser
        String condition = request.getParameter("condition");
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.EventFeatures.DETAIL_PAGE);
        try {
            //Check cart place
            HttpSession session = request.getSession(false);
            if (session != null) {
                if (session.getAttribute("INSUFFICIENT") != null) {
                    request.setAttribute("INSUFFICIENT", "Số lượng sản phẩm này trong giỏ hàng vượt qua giới hạn!");
                    session.removeAttribute("INSUFFICIENT");
                }
            }
            //2. Call DAO/Models
            EventProductDAO dao = new EventProductDAO();
            EventDAO eDao = new EventDAO();
            String eventName = eDao.getEventNameByEventId(eventId);
            List<EventProductDTO> listFlowers = dao.getFlowerByCondition(eventId, condition);
            List<EventProductDTO> conditionCate = dao.getAllCondition(eventId);
            if (listFlowers != null) {
                // Paging
                int pageSize = 9; // Number of products per page
                String pageParam = request.getParameter("page"); // Get the current page number from the request
                int currentPage = pageParam != null ? Integer.parseInt(pageParam) : 1; // Default to page 1 if not provided
                int totalProducts = listFlowers.size();
                int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
                // Calculate the starting and ending indexes for the sublist of products to display
                int start = (currentPage - 1) * pageSize;
                int end = Math.min(start + pageSize, totalProducts);
                List<EventProductDTO> productsForPage = listFlowers.subList(start, end);

                request.setAttribute("CATEGORIES", condition);
                request.setAttribute("CATEGORY_CONDITION", conditionCate);
                request.setAttribute("PRODUCTS", productsForPage);
                request.setAttribute("currentPage", currentPage);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("FLOWER_LIST", listFlowers);
                request.setAttribute("EVENT_ID", eventId);
                request.setAttribute("EVENT_NAME", eventName);
            }
        } catch (SQLException ex) {
            log("EventFlowerCategoryServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("EventFlowerCategoryServlet _Naming_ " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
