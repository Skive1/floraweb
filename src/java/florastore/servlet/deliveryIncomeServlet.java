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
            if (dto != null) {
                DeliveryRevenueDAO dao = new DeliveryRevenueDAO();
                String id = dao.loadIdByUserName(username);

                dao.loadTotalRevenueByYear(id, year);
                ArrayList<DeliveryRevenueDTO> listYear = dao.getlistTotal();
                request.setAttribute("month1", listYear.get(0));
                request.setAttribute("month2", listYear.get(1));
                request.setAttribute("month3", listYear.get(2));
                request.setAttribute("month4", listYear.get(3));
                request.setAttribute("month5", listYear.get(4));
                request.setAttribute("month6", listYear.get(5));
                request.setAttribute("month7", listYear.get(6));
                request.setAttribute("month8", listYear.get(7));
                request.setAttribute("month9", listYear.get(8));
                request.setAttribute("month10", listYear.get(9));
                request.setAttribute("month11", listYear.get(10));
                request.setAttribute("month12", listYear.get(11));
                request.setAttribute("allMonth", listYear);
                
                dao.loadTotalOrderByYear(id, year);
                ArrayList<DeliveryRevenueDTO> listOrder = dao.getlistOrder();
                request.setAttribute("listOrder", listOrder);
                request.setAttribute("curYear",year);        
                
                RatesDeliveryPersonDAO rateDao = new RatesDeliveryPersonDAO();
//                rateDao.rateStarById(id);
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
