/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.managerProduct.CategoryDAO;
import florastore.managerProduct.CategoryDTO;
import florastore.managerProduct.ManagerProductDAO;
import florastore.managerProduct.ManagerProductDTO;
import florastore.managerProduct.ProductTypeDAO;
import florastore.managerProduct.ProductTypeDTO;
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
@WebServlet(name = "ProductManagementServlet", urlPatterns = {"/ProductManagementServlet"})
public class ProductManagementServlet extends HttpServlet {

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
        String id = request.getParameter("storeInfo");
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int indexInt = Integer.parseInt(indexPage);

        try {

            if (id != null) {
                //2. Gọi method DAO
                ManagerProductDAO dao = new ManagerProductDAO();
                int count = dao.getTotalProduct();
                int endPage = count / 5;
                if (count % 5 != 0) {
                    endPage++;
                }
                //3. Lấy list sản phẩm theo sell id
                dao.loadListProductFromDbById(id, indexInt);
                ArrayList<ManagerProductDTO> list = dao.getListProduct();

                CategoryDAO catDao = new CategoryDAO();
                catDao.loadListProductCategory();
                ArrayList<CategoryDTO> listCat = catDao.getListCategory();
                //4. Lưu vào trong attribute
                request.setAttribute("listCate", listCat);
                request.setAttribute("storeId", id);
                request.setAttribute("listProduct", list);
                request.setAttribute("endP", endPage);
                url = (String) siteMap.get(MyAppConstants.ShowProductManager.STORE_PAGE);
            }

        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("ProductManagementServlet _ SQL: " + msg);
        } catch (NamingException ex) {
            String msg = ex.getMessage();
            log("ProductManagementServlet _ Naming: " + msg);
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
