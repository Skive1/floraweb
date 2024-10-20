/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.eventProduct.EventProductDAO;
import florastore.eventProduct.EventProductDTO;
import florastore.reviewEvent.ReviewEventDAO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "EventFlowerDetailServlet", urlPatterns = {"/EventFlowerDetailServlet"})
public class EventFlowerDetailServlet extends HttpServlet {

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
        //1. Get id of flower
        int productId = Integer.parseInt(request.getParameter("productId"));
        int eventId = Integer.parseInt(request.getParameter("eventId"));

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.EventFlowerFeatures.ERROR_PAGE);

        try {
            //Check cart place
            HttpSession session = request.getSession(false);
            if (session != null) {
                if (session.getAttribute("INSUFFICIENT") != null) {
                    request.setAttribute("INSUFFICIENT", "Số lượng sản phẩm này trong giỏ hàng vượt qua giới hạn!");
                    session.removeAttribute("INSUFFICIENT");
                }
            }
            //2. Call DAO/Model
            EventProductDAO dao = new EventProductDAO();
            //2.1 Get flower detail
            EventProductDTO flowerDetail = dao.getFlowerDetail(productId);
            if (flowerDetail != null) {//check flower in detail is available
                url = (String) siteMap.get(MyAppConstants.EventFlowerFeatures.DETAIL_PAGE);
                //4. Push to Product Detail
                request.setAttribute("EPRODUCT_DETAIL", flowerDetail);
                request.setAttribute("EVENT_ID", eventId);
            }//check flower in detail is available
        } catch (SQLException ex) {
            log("ViewProductDetailServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewProductDetailServlet _Naming_ " + ex.getMessage());
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
