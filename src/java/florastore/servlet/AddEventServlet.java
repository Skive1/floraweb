/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.event.EventDAO;
import florastore.event.EventDTO;
import florastore.event.EventProductDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.naming.NamingException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddEventServlet", urlPatterns = {"/AddEventServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class AddEventServlet extends HttpServlet {

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

        String eventName = request.getParameter("eventName");
        String accountUsername = request.getParameter("accountUsername");

        String eventImg = request.getParameter("eventImgUrl");

        // event description
        String eventDescriptionParam = request.getParameter("eventDescription");
        if (eventDescriptionParam == null || eventDescriptionParam.trim().isEmpty()) {
            throw new ServletException("eventDescription is required.");
        }

        String[] eventDescription = eventDescriptionParam.split("\\s*,\\s*");
        String eventLocation = eventDescription[0].replaceAll("<.*?>", "");
        String city = eventDescription[1].replaceAll("<.*?>", "");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        // Convert the strings to Timestamp
        Timestamp startDate = Timestamp.valueOf(startDateStr.replace("T", " ") + ":00");
        Timestamp endDate = Timestamp.valueOf(endDateStr.replace("T", " ") + ":00");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.AddEventFeatures.ADD_EVENT_PAGE);

        try {
            
            EventDAO dao = new EventDAO();
            EventDTO eDTO = new EventDTO(accountUsername, 0, eventName, eventLocation, city, startDate, endDate, eventImg);
            
            boolean result = dao.addEvent(eDTO);
            
            if (result) {
                url = (String) siteMap.get(MyAppConstants.AddEventFeatures.ADD_EVENT_PAGE);
            }
        } catch (SQLException ex) {
            log("AddEventServlet _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
            log("AddEventServlet _ Naming " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }
    // Extract the file name from the Part

//    private String extractFileName(Part part) {
//        String contentDisposition = part.getHeader("content-disposition");
//        for (String cd : contentDisposition.split(";")) {
//            if (cd.trim().startsWith("filename")) {
//                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
//            }
//        }
//        return null;
//    }

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
