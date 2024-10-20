/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDAO;
import florastore.account.AccountDTO;
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
@WebServlet(name = "ManageAccountServlet", urlPatterns = {"/ManageAccountServlet"})
public class ManageAccountServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.ManageAccountFeatures.ERROR_PAGE);
        
        //1. Get page of list
        String indexPage = request.getParameter("page");
        if (indexPage == null) {
            indexPage = "1";
        }
        int page = Integer.parseInt(indexPage);
        //1.1 Ger user session and role = admin
        HttpSession session = request.getSession(false);
        AccountDTO user = (AccountDTO) session.getAttribute("USER");
        String role = null;
        if(user != null){
            role = user.getRole();
        } else {
            role = "Guest";
        }
        try {
            //2. Call DAO/Models
            AccountDAO dao = new AccountDAO();
            //2.1 Get total account
            int count = dao.adminGetTotalAccount();
            //2.2 OFFSET 5 entities
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
            // Process result
            List<AccountDTO> accountList = dao.getAllAccount(page);
            if (accountList != null && role.equals("Admin")) {
                url = (String) siteMap.get(MyAppConstants.ManageAccountFeatures.MANAGE_ACCOUNT_PAGE);
                request.setAttribute("END_PAGE", endPage);
                request.setAttribute("TOTAL_ACCOUNT", count);
                request.setAttribute("TAG", page);
                request.setAttribute("ACCOUNT_LIST", accountList);
                request.setAttribute("ACCOUNT_PER_PAGE", accountList.size());
            }
        } catch (SQLException ex) {
            log("ManageAccountServlet _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
            log("ManageAccountServlet _ Naming " + ex.getMessage());
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
