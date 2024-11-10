/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.eventFeedback.EventFeedbackDAO;
import florastore.eventFeedback.EventFeedbackDTO;
import florastore.eventOrder.EventOrderDAO;
import florastore.eventOrder.EventOrderDTO;
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
@WebServlet(name = "ViewPurchasedOrderServlet", urlPatterns = {"/ViewPurchasedOrderServlet"})
public class ViewPurchasedOrderServlet extends HttpServlet {

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

        
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.PurchasedOrderFeatures.PURCHASED_ORDER);
        //1. Get username
        String username = null;
        HttpSession session = request.getSession(false);
        if (session != null) {
            username = (String) session.getAttribute("USERNAME");
        }
        try {
            //2. Call DAO/Models
            EventOrderDAO dao = new EventOrderDAO();
            int numberofOrder = dao.countNumberOrder(username);
            EventFeedbackDAO feedback = new EventFeedbackDAO();
            List<EventOrderDTO> listPending = dao.getPendingOrder(username);
            List<EventOrderDTO> listConfirmed = dao.getConfirmedOrder(username);
            List<EventOrderDTO> listShipping = dao.getShippingOrder(username);
            List<EventOrderDTO> listReceived = dao.getReceivedOrder(username);
            List<EventOrderDTO> listCancelled = dao.getCancelledOrder(username);
            List<EventFeedbackDTO> listFeedback = feedback.checkList(username);
            //3. set list purchased order with each status
            session.setAttribute("NUMBER_ORDER", numberofOrder);
            request.setAttribute("LIST_CHECK_FEEDBACK", listFeedback);
            request.setAttribute("LIST_PENDING", listPending);
            request.setAttribute("LIST_CONFIRM", listConfirmed);
            request.setAttribute("LIST_SHIPPING", listShipping);
            request.setAttribute("LIST_RECEIVE", listReceived);
            request.setAttribute("LIST_CANCEL", listCancelled);
            
        } catch (SQLException ex) {
            log("ViewPurchasedOrderServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewPurchasedOrderServlet _Naming_ " + ex.getMessage());
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
