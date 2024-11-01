/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.eventOrder.EventOrderDAO;
import florastore.eventProduct.EventProductDAO;
import florastore.eventProduct.EventProductDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
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
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.HomeFeatures.ERROR_PAGE);

        boolean loginSuccess = false;
        try {
            //1. Call DAO/Models
            EventProductDAO dao = new EventProductDAO();
            //1.1 Get best seller products
            List<EventProductDTO> bestSeller = dao.getBestSellers();
            //1.2 Get new arrival products
            List<EventProductDTO> newArrival = dao.getNewArrivals();
            //2. Process result
            EventProductDTO cheapestFlower = dao.getCheapestFlower();
            EventOrderDAO eDao = new EventOrderDAO();
            HttpSession session = request.getSession(false);
            if (session != null) {
                String username = (String) session.getAttribute("USERNAME");
                int numberofOrder = eDao.countNumberOrder(username);
                session.setAttribute("NUMBER_ORDER", numberofOrder);
                if (session.getAttribute("LOGIN_SUCCESS") != null) {
                    loginSuccess = (boolean) session.getAttribute("LOGIN_SUCCESS");
                    session.removeAttribute("LOGIN_SUCCESS");
                }
                request.setAttribute("LOGIN_SUCCESS_ALERT", loginSuccess);
            }
            if (bestSeller != null && newArrival != null) {//check flower list is available
                //3. To Home Page
                url = (String) siteMap.get(MyAppConstants.HomeFeatures.HOME_PAGE);
                request.setAttribute("BEST_SELLER", bestSeller);
                request.setAttribute("NEW_ARRIVAL", newArrival);
                request.setAttribute("CHEAPEST_FLOWER", cheapestFlower);
            }//check flower list is available
        } catch (SQLException ex) {
            log("StoreViewServlet _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
            log("StoreViewServlet _ Naming " + ex.getMessage());
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
