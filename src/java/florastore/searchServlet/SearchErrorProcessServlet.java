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

        String checkSearch = (String) session.getAttribute("Search");
        String pageActive = (String) session.getAttribute("pageIsActive");
        String navbar = (String) session.getAttribute("navbar");
        String search = (String) session.getAttribute("searchValue");

        String checkSearchExtend = (String) session.getAttribute("SearchExtend");
        String pageExtendActive = (String) session.getAttribute("pageExtendIsActive");
        try {
            //search extend
            
            if (checkSearch != null) {
                session.setAttribute("ErrorToExtend", "exist");
                
                if (pageActive != null) {
                    session.setAttribute("checkPageActive", pageActive);
                    session.removeAttribute("pageIsActive");
                }
                if (navbar != null) {
                    session.setAttribute("checkNavbar", navbar);
                    session.removeAttribute("navbar");
                }
                if (search != null) {
                    session.setAttribute("checkSearch", search);
                    session.removeAttribute("searchValue");
                }
                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH);
            }
            if (checkSearchExtend != null) {
                session.setAttribute("ErrorToExtend", "exist");

                if (pageExtendActive != null) {
                    session.setAttribute("checkPageExtendActive", pageExtendActive);
                    session.removeAttribute("pageIsActive");
                }
                
                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_EXTEND);
            }
        } catch (StackOverflowError ex) {
            System.out.println("huhu");
        } finally {
            System.out.println("ErrorProcess finished");
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
