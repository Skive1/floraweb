/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageEvent;

import florastore.event.EventDAO;
import florastore.event.EventProductDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
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

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ShowEventDetailServlet", urlPatterns = {"/ShowEventDetailServlet"})
public class ShowEventDetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //1. Get event id
        int eventId = Integer.parseInt(request.getParameter("getEventID").trim());
        String eventName = request.getParameter("getEventName");
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.ManageEvent.ERROR_PAGE);
        
        DecimalFormat df = new DecimalFormat("#,###.##");
        double total = 0;
        String totalOut;
        try {
            EventDAO dao = new EventDAO();
            List<EventProductDTO> flowerList = dao.getEventFlower(eventId);
            if (flowerList != null) {
                for (EventProductDTO flowerPrice : flowerList) {
                    total += flowerPrice.getEventProductPrice() * flowerPrice.getEventProductQuantity();
                }
                
                totalOut = df.format(total);
                url = (String) siteMap.get(MyAppConstants.ManageEvent.VIEW_EVENT_PAGE);
                request.setAttribute("FLOWER_LIST", flowerList);
                request.setAttribute("EVENT_ID", eventId);
                request.setAttribute("EVENT_NAME", eventName);
                request.setAttribute("TOTAL", totalOut);
            }
        } catch (SQLException ex) {
            log("EventDetailServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("EventDetailServlet _Naming_ " + ex.getMessage());
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
