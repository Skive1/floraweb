/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.ajax.event.servlet;

import com.google.gson.Gson;
import florastore.event.EventDAO;
import florastore.event.EventDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SearchEventByKeyWordServlet", urlPatterns = {"/searchKeyWordEvent"})
public class SearchEventByKeyWordServlet extends HttpServlet {

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

        String keyword = request.getParameter("txt");
        PrintWriter out = response.getWriter();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            //Call DAO/Model
            EventDAO dao = new EventDAO();
            List<EventDTO> eventList = dao.searchEventsByKeyword(keyword);
            if (eventList != null && !eventList.isEmpty()) {
                for (EventDTO event : eventList) {
                    String formattedStartDate = sdf.format(event.getStartDate());
                    String formattedEndDate = sdf.format(event.getEndDate());
                    String eventDetail = "eventDetail?eventId=" + event.getEventId();
                    out.println("<a href='" + eventDetail + "'>");
                    out.println("<div class='col-md-12 col-lg-6 col-xl-12'>");
                    out.println("<div class='rounded position-relative fruite-item'>");
                    out.println("<div class='fruite-img'>");
                    out.println("<img src='" + event.getEventImg() + "' class='img-fluid w-100 rounded-top' alt='" + event.getEventName() + "'>");
                    out.println("</div>");
                    out.println("<div class='text-white bg-secondary px-3 py-1 rounded position-absolute' style='top: 10px; left: 10px;'>");
                    out.println("Owner: " + event.getEventOwner());
                    out.println("</div>");
                    out.println("<div class='p-4 border border-secondary border-top-0 rounded-bottom'>");
                    out.println("<h4>" + event.getEventName() + "</h4>");
                    out.println("<p>Địa điểm: " + event.getEventLocation() + ", " + event.getEventCity() + "</p>");
                    out.println("<div class='d-flex justify-content-between flex-lg-wrap'>");
                    out.println("<p class='text-dark fs-5 fw-bold mb-0'>");
                    out.println("Thời gian: " + formattedStartDate + " - " + formattedEndDate);
                    out.println("</p>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</a>");
                }
            } else {
                out.println("<h1 style='text-align: center'>Hiện tại không có event nào!!!</h1>");
            }
        } catch (SQLException ex) {
            log("SearchEventByKeyWordServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("SearchEventByKeyWordServlet _Naming_ " + ex.getMessage());
        } finally {
            out.close();
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
