/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.revenue.DeliveryRevenueDAO;
import florastore.revenue.DeliveryRevenueDTO;
import florastore.revenue.RatesDeliveryPersonDAO;
import florastore.revenue.RatesDeliveryPersonDTO;
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
@WebServlet(name = "deliveryIncomeServlet", urlPatterns = {"/deliveryIncomeServlet"})
public class deliveryIncomeServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.DashBoardFeatures.DELIVERY_DASHBOARD_PAGE);
        String yearStr = request.getParameter("year");
        int year;
        if (yearStr == null || yearStr.isEmpty()) {
            year = 2024;
        } else {
            year = Integer.parseInt(yearStr);
        }
        try {
            HttpSession session = request.getSession(false);
            AccountDTO dto = (AccountDTO) session.getAttribute("USER");
            String username = dto.getUsername();
            request.setAttribute("curYear", year);
            if (dto != null) {
                DeliveryRevenueDAO dao = new DeliveryRevenueDAO();
                String id = dao.loadIdByUserName(username);

                dao.loadTotalRevenueByYear(id, year);
                ArrayList<DeliveryRevenueDTO> listYear = dao.getlistTotal();
                if (listYear.size() > 0 && listYear.get(0) != null) {
                    request.setAttribute("month1", listYear.get(0));
                }
                if (listYear.size() > 1 && listYear.get(1) != null) {
                    request.setAttribute("month2", listYear.get(1));
                }
                if (listYear.size() > 2 && listYear.get(2) != null) {
                    request.setAttribute("month3", listYear.get(2));
                }
                if (listYear.size() > 3 && listYear.get(3) != null) {
                    request.setAttribute("month4", listYear.get(3));
                }
                if (listYear.size() > 4 && listYear.get(4) != null) {
                    request.setAttribute("month5", listYear.get(4));
                }
                if (listYear.size() > 5 && listYear.get(5) != null) {
                    request.setAttribute("month6", listYear.get(5));
                }
                if (listYear.size() > 6 && listYear.get(6) != null) {
                    request.setAttribute("month7", listYear.get(6));
                }
                if (listYear.size() > 7 && listYear.get(7) != null) {
                    request.setAttribute("month8", listYear.get(7));
                }
                if (listYear.size() > 8 && listYear.get(8) != null) {
                    request.setAttribute("month9", listYear.get(8));
                }
                if (listYear.size() > 9 && listYear.get(9) != null) {
                    request.setAttribute("month10", listYear.get(9));
                }
                if (listYear.size() > 10 && listYear.get(10) != null) {
                    request.setAttribute("month11", listYear.get(10));
                }
                if (listYear.size() > 11 && listYear.get(11) != null) {
                    request.setAttribute("month12", listYear.get(11));
                }
                request.setAttribute("allMonth", listYear);
                dao.loadTotalOrderByYear(id, year);
                ArrayList<DeliveryRevenueDTO> listOrder = dao.getlistOrder();
                request.setAttribute("listOrder", listOrder);

                RatesDeliveryPersonDAO rateDao = new RatesDeliveryPersonDAO();
                ArrayList<RatesDeliveryPersonDTO> listRate = rateDao.getRateSummaryByStaffId(id);
                request.setAttribute("listRating", listRate);
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("deliveryIncomeServlet _ SQL: " + msg);
        } catch (NamingException ex) {
            String msg = ex.getMessage();
            log("deliveryIncomeServlet _ Naming: " + msg);
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
