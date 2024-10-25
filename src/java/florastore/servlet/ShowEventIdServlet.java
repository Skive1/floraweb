/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.revenue.EventSellerDAO;
import florastore.revenue.EventSellerDTO;
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
@WebServlet(name = "ShowEventIdServlet", urlPatterns = {"/ShowEventIdServlet"})
public class ShowEventIdServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.ShowProductManager.ERROR_PAGE);
        HttpSession session = request.getSession(false);

        try {
            if (session != null) {
                AccountDTO dto = (AccountDTO) session.getAttribute("USER");
                String username = dto.getUsername();
                if ("Seller".equals(dto.getRole())) {
                    EventSellerDAO dao = new EventSellerDAO();
                    dao.loadListEventIdByUsername(username);
                    ArrayList<EventSellerDTO> listEventIds = dao.getListEventId();
                    session.setAttribute("ListEventId", listEventIds);
                    url = (String) siteMap.get(MyAppConstants.DashBoardFeatures.SELLER_DASHBOARD_PAGE);
                }
            } else if (session == null) {
                url = MyAppConstants.ShowProductManager.SESSION_PAGE;
                response.sendRedirect(url);
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("ShowEventIdServlet _ SQL: " + msg);
        } catch (NamingException ex) {
            String msg = ex.getMessage();
            log("ShowEventIdServlet _ Naming: " + msg);
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
