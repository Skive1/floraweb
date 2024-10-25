/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.eventFeedback.EventFeedbackDAO;
import florastore.eventFeedback.EventFeedbackDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ViewFeebacksServlet", urlPatterns = {"/ViewFeebacksServlet"})
public class ViewFeebacksServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.SellerViewEventFeedbackFeatures.VIEW_FEEDBACK);
        String username = null;
        //1. Get page of list
        String indexPage = request.getParameter("page");
        if (indexPage == null) {
            indexPage = "1";
        }
        int page = Integer.parseInt(indexPage);
        HttpSession session = request.getSession(false);
        if (session == null) {
            url = MyAppConstants.SellerViewEventFeedbackFeatures.SESSION_PAGE;
            response.sendRedirect(url);
        }
        try {
            if (session != null) {
                username = (String) session.getAttribute("USERNAME");
                AccountDTO userInfo = (AccountDTO) session.getAttribute("USER");
                if (!"Seller".equals(userInfo.getRole())) {
                    url = (String) siteMap.get(MyAppConstants.SellerViewEventFeedbackFeatures.ERROR_PAGE);
                } else if ("Seller".equals(userInfo.getRole())) {
                    //Call dao/model
                    EventFeedbackDAO dao = new EventFeedbackDAO();
                    List<EventFeedbackDTO> listAll = dao.getNumberOfFeedback(username);
                    int count = listAll.size();
                    int endPage = count / 10;
                    if (count % 10 != 0) {
                        endPage++;
                    }
                    List<EventFeedbackDTO> listFeeback = dao.getListFeedback(username, page);
                    request.setAttribute("FEEDBACK_LIST", listFeeback);
                    request.setAttribute("TOTAL_FEEDBACK", count);
                    request.setAttribute("END_PAGE", endPage);
                    request.setAttribute("FEEDBACK_PER_PAGE", listFeeback.size());
                }
            }
        } catch (SQLException ex) {
            log("ViewFeebacksServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewFeebacksServlet _Naming_ " + ex.getMessage());
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
