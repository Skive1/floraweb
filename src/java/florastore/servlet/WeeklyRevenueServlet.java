/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.revenue.EventRevenueDAO;
import florastore.revenue.EventRevenueDTO;
import florastore.revenue.revenueDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
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
 * @author acer
 */
@WebServlet(name = "WeeklyRevenueServlet", urlPatterns = {"/WeeklyRevenueServlet"})
public class WeeklyRevenueServlet extends HttpServlet {

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
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.DashBoardFeatures.WEAKLY_PAGE);
        String year_raw = request.getParameter("year");
        String month_raw = request.getParameter("month");
        String from_raw = request.getParameter("from");
        String to_raw = request.getParameter("to");
        try {
            //Tìm ngày hiện tại của hệ thống
            LocalDate currentDate = LocalDate.now();
            //Tìm ngày thứ 2 của tuần hiện tại
            LocalDate startOfWeek = currentDate.with(DayOfWeek.MONDAY);
            //Tìm ngày chủ nhật
            LocalDate endOfWeek = startOfWeek.plusDays(6);
            int startDay = startOfWeek.getDayOfMonth();
            int endDay = endOfWeek.getDayOfMonth();
            int monthValue = startOfWeek.getMonthValue();

            int year = (year_raw == null ? 2024 : Integer.parseInt(year_raw));
            int month = (month_raw == null ? monthValue : Integer.parseInt(month_raw));
            int from = (from_raw == null ? startDay : Integer.parseInt(from_raw));
            int to = (to_raw == null ? endDay : Integer.parseInt(to_raw));

            EventRevenueDAO dao = new EventRevenueDAO();
            double monday = dao.loadEventTotalAmount(year, month, from, to, 2);
            double tuesday = dao.loadEventTotalAmount(year, month, from, to, 3);
            double wednesday = dao.loadEventTotalAmount(year, month, from, to, 4);
            double thursday = dao.loadEventTotalAmount(year, month, from, to, 5);
            double friday = dao.loadEventTotalAmount(year, month, from, to, 6);
            double saturday = dao.loadEventTotalAmount(year, month, from, to, 7);
            double sunday = dao.loadEventTotalAmount(year, month, from, to, 1);
            
            request.setAttribute("totalMoney2", monday);
            request.setAttribute("totalMoney3", tuesday);
            request.setAttribute("totalMoney4", wednesday);
            request.setAttribute("totalMoney5", thursday);
            request.setAttribute("totalMoney6", friday);
            request.setAttribute("totalMoney7", saturday);
            request.setAttribute("totalMoney1", sunday);
            request.setAttribute("year", year);
            
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("WeeklyRevenueServlet _ SQL: " + msg);
        } catch (NamingException ex) {
            String msg = ex.getMessage();
            log("WeeklyRevenueServlet _ SQL: " + msg);
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
