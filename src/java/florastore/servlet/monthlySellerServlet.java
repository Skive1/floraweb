/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.revenue.EventSellerDAO;
import florastore.revenue.EventSellerRevenueDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author acer
 */
@WebServlet(name = "monthlySellerServlet", urlPatterns = {"/monthlySellerServlet"})
public class monthlySellerServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.DashBoardFeatures.ERROR_PAGE);
        String id = request.getParameter("eventInfo");
        String monthStr = request.getParameter("month");
        String yearStr = request.getParameter("year");
        int month;
        int year;
        if (monthStr == null || monthStr.isEmpty()) {
            month = 10;
        } else {
            month = Integer.parseInt(monthStr);
        }

        if (yearStr == null || yearStr.isEmpty()) {
            year = 2024;
        } else {
            year = Integer.parseInt(yearStr);
        }
        HttpSession session = request.getSession(false);
        AccountDTO dto = null;
        try {
            if (session != null) {
                dto = (AccountDTO) session.getAttribute("USER");
                if ("Seller".equals(dto.getRole())) {
                    EventSellerDAO dao = new EventSellerDAO();
                    dao.loadTop5AmountByMonth(month, year, id);
                    ArrayList<EventSellerRevenueDTO> list = dao.getListEventRevenue();
                    if (session.getAttribute("ListEventId") != null) {
                        url = (String) siteMap.get(MyAppConstants.DashBoardFeatures.SELLER_DASHBOARD_PAGE);
                        request.setAttribute("pro1", list.get(0));
                        request.setAttribute("pro2", list.get(1));
                        request.setAttribute("pro3", list.get(2));
                        request.setAttribute("pro4", list.get(3));
                        request.setAttribute("pro5", list.get(4));
                        request.setAttribute("MonthList", list);
                        request.setAttribute("curMonth", month);
                    } else {
                        url = (String) siteMap.get(MyAppConstants.DashBoardFeatures.ERROR_PAGE);
                    }
                }
            } else if (session == null) {
                url = MyAppConstants.DashBoardFeatures.SESSION_PAGE;
                response.sendRedirect(url);
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("MonthlySellerServlet _ SQL: " + msg);
        } catch (NamingException ex) {
            String msg = ex.getMessage();
            log("MonthlySellerServlet _ Naming: " + msg);
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
