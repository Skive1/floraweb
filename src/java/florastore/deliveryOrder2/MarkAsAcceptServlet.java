/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.deliveryOrder2;

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

@WebServlet(name = "MarkAsAcceptServlet", urlPatterns = {"/MarkAsAcceptServlet"})
public class MarkAsAcceptServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.Delivery.ERROR_PAGE);

        HttpSession session = request.getSession();
        String getEventOrderID = request.getParameter("getEventOrderID").trim();
        String getEventOrderAmount = request.getParameter("getEventOrderAmount");
        String getFullName = (String) session.getAttribute("USERNAME");

        int eventOrderID = Integer.parseInt(getEventOrderID);
        int staffID = (int) session.getAttribute("Staff_ID");

        double staffBalance = (double) session.getAttribute("Staff_Balance");
        double eventOrderAmount = Double.parseDouble(getEventOrderAmount);
        double balance = staffBalance - eventOrderAmount;
        try {
            if (balance >= 0) {
                DeliverDAO dao = new DeliverDAO();
                boolean result = dao.markAsGet(eventOrderID, staffID);
                List<DeliverDTO> orderToDelivery = dao.getOrder(getFullName, staffID);          //lấy danh sách các đơn hàng để đi giao
                session.setAttribute("Total_Order", orderToDelivery.size());
                if (!result) {                                                      //đơn hàng đã bị người khác nhận
                    request.setAttribute("FoundError", "Đơn hàng đã được nhận bởi nhân viên khác!");
                } else {
                    dao.setDeliveryStaffBalance(staffID, balance);
                    session.removeAttribute("Staff_Balance");
                    session.setAttribute("Staff_Balance", balance);
                }
            } else {
                request.setAttribute("FoundError2", "Số dư trong tài khoản của bạn không đủ để nhận đơn hàng này!");
            }
            url = (String) siteMap.get(MyAppConstants.Delivery.SHIPPER_ORDER);
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
