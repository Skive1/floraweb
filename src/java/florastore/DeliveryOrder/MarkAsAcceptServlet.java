/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.DeliveryOrder;

import florastore.account.AccountDTO;
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

@WebServlet(name = "MarkAsAcceptServlet", urlPatterns = {"/MarkAsAcceptServlet"})
public class MarkAsAcceptServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.Delivery.ERROR_PAGE);

        HttpSession session = request.getSession();
        String eventOrderID = request.getParameter("getEventOrderID");
        int intEventOrderID = Integer.parseInt(eventOrderID);
        int staffId = (int) session.getAttribute("Staff_ID");
        
        try {
            DeliverDAO dao = new DeliverDAO();
            boolean result = dao.markAsGet(intEventOrderID, staffId);
            List<DeliverDTO> orderList = dao.getDeliveryOrder();
            session.setAttribute("Total_Order", orderList.size());
            if (result) {
                url = (String) siteMap.get(MyAppConstants.Delivery.SHIPPER_ORDER);
            } else {
                url = (String) siteMap.get(MyAppConstants.Delivery.SHIPPER_ORDER);
                request.setAttribute("FoundError", "active");
            }
        } catch (SQLException ex) {
            log("EventServlet _SQL_ " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("EventServlet Class Not Found " + ex.getMessage());
        } catch (NamingException ex) {
            log("EventServlet _Naming_ " + ex.getMessage());
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
