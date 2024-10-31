/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.sellerManageEvent;

import florastore.event.EventDAO;
import florastore.event.EventDTO;
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
 * @author ASUS
 */
@WebServlet(name = "sellerUpdateEventServlet", urlPatterns = {"/sellerUpdateEventServlet"})
public class sellerUpdateEventServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventIdStr = request.getParameter("eventID");
        int eventId = 0;

        HttpSession session = request.getSession();
        
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SellerManagementFeatures.ERROR_PAGE2);

        try {
            if (eventIdStr != null) {//user nhấn button chỉnh sửa một sự kiện trong danh sách sự kiện
                eventId = Integer.parseInt(eventIdStr);
            } else {//user nhấn button chỉnh sửa
                eventId = (int) session.getAttribute("eventID");
            }
            EventDAO dao = new EventDAO();
            EventDTO events = dao.getEventByID(eventId);
            if (events != null) {
                session.setAttribute("eventID", eventId);
                session.setAttribute("eventToManage", events);
                url = (String) siteMap.get(MyAppConstants.SellerManagementFeatures.MANAGE_EVENT_PAGE);
            }
        } catch (SQLException ex) {
            log("UpdateEventServlet _SQL_" + ex.getMessage());
        } catch (NamingException ex) {
            log("UpdateEventServlet _Naming_" + ex.getMessage());
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
