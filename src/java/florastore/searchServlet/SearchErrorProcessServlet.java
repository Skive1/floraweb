/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchServlet;

import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.util.Properties;
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
@WebServlet(name = "SearchErrorProcessServlet", urlPatterns = {"/SearchErrorProcessServlet"})
public class SearchErrorProcessServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.ERROR);

        HttpSession session = request.getSession();
        try {                                                                   //sắp bị dỡ bỏ
            //search extend
//            session.setAttribute("errorExist", "exist");
//            System.out.println(request.getAttribute("PRICE_ERROR"));
//            if (session.getAttribute("search") != null) {
//                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH);
//            } else if (session.getAttribute("searchExtend") != null) {
//                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_EXTEND);
//            } else if (session.getAttribute("searchForType") != null) {
//                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_TYPE);
//            } else if (session.getAttribute("searchForColor") != null) {
//                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_COLOR);
//            }

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
