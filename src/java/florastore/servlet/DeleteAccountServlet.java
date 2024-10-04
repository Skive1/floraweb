/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

<<<<<<< HEAD:src/java/florastore/servlet/ProductManagementServlet.java
import florastore.account.AccountDTO;
import florastore.managerProduct.ManagerProductDAO;
import florastore.managerProduct.ManagerProductDTO;
import florastore.managerProduct.ProductTypeDAO;
import florastore.managerProduct.ProductTypeDTO;
=======
import florastore.account.AccountDAO;
>>>>>>> 80c4cd83e14e5cf8c35874667861b8bd8f26d5ca:src/java/florastore/servlet/DeleteAccountServlet.java
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
<<<<<<< HEAD:src/java/florastore/servlet/ProductManagementServlet.java
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> 80c4cd83e14e5cf8c35874667861b8bd8f26d5ca:src/java/florastore/servlet/DeleteAccountServlet.java
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
@WebServlet(name = "DeleteAccountServlet", urlPatterns = {"/DeleteAccountServlet"})
public class DeleteAccountServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.AdminDeleteFeatures.ERROR_PAGE);

        //1. Get account info and page 
        String username = request.getParameter("txtUsername");
        String page = request.getParameter("page");
        boolean result = false;

<<<<<<< HEAD:src/java/florastore/servlet/ProductManagementServlet.java
//        try {
//            HttpSession session = request.getSession(false);
//            if (session != null) {
//                //1. Lấy id từ session Scope
//                AccountDTO dto = (AccountDTO) session.getAttribute("USER");
//                String id = dto.getSaleId();
//                if (dto.getSaleId() != null) {
//                    //2. Gọi method DAO
//                    ManagerProductDAO dao = new ManagerProductDAO();
//                   
//                    int count = dao.getTotalProduct();
//                    int endPage = count / 5;
//                    if (count % 5 != 0) {
//                        endPage++;
//                    }
//                    //3. Lấy list sản phẩm theo sell id
//                    dao.loadListProductFromDbById(id, indexInt);
//                    ArrayList<ManagerProductDTO> list = dao.getListProduct();
//                    
//                    ProductTypeDAO typeDao = new ProductTypeDAO();
//                    typeDao.loadListProductType();
//                    ArrayList<ProductTypeDTO> listCategory = typeDao.getListCategory();
//                   
//                    //4. Lưu vào trong attribute
//                    request.setAttribute("listType", listCategory);
//                    request.setAttribute("listProduct", list);
//                    request.setAttribute("endP", endPage);
//                   
//                     url = (String) siteMap.get(MyAppConstants.ShowProductManager.STORE_PAGE);
//                }
//            }
//           
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (NamingException ex) {
//            ex.printStackTrace();
//        } finally {
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
//        }
=======
        try {
            //2. Call DAO/Models
            AccountDAO dao = new AccountDAO();
            result = dao.adminDeleteAccount(username);

            if (result) {
                //refresh by callling the previos function using URL Rewritring
                url = (String) siteMap.get(MyAppConstants.AdminDeleteFeatures.MANAGE_ACCOUNT_PAGE);
                url = url + "?page=" + page;
            }
        } catch (SQLException ex) {
            log("DeleteAccountServlet _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
            log("DeleteAccountServlet _ Naming " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
>>>>>>> 80c4cd83e14e5cf8c35874667861b8bd8f26d5ca:src/java/florastore/servlet/DeleteAccountServlet.java
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
