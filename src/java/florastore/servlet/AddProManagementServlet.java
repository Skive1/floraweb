/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.managerProduct.FlowerProductDAO;
import florastore.managerProduct.FlowerProductDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "AddProManagementServlet", urlPatterns = {"/AddProManagementServlet"})
public class AddProManagementServlet extends HttpServlet {

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
        //Get parameter
        String url = (String) siteMap.get(MyAppConstants.ShowProductManager.ERROR_PAGE);
        String id = request.getParameter("storeIdAdd");
        int storeId = Integer.parseInt(id);
        String name = request.getParameter("nameAdd");
        String type = request.getParameter("typeAdd");
        String condition = request.getParameter("conditionAdd");
        String detail = request.getParameter("detailAdd");
        String price = request.getParameter("priceAdd");
        double priceDouble = Double.parseDouble(price);
        String quantity = request.getParameter("quantityAdd");
        int quantityInt = Integer.parseInt(quantity);
        String img = request.getParameter("imageURLAdd");
        String categoryId = request.getParameter("categoryAdd");
        try  {
            //1. Add product information into dto
            FlowerProductDTO dto = new FlowerProductDTO(type, name, condition, detail, img, quantityInt, priceDouble, categoryId, "0");
            //2. Call dao
            FlowerProductDAO dao = new FlowerProductDAO();
            //3. Call method dao
            boolean result = dao.saveProduct(dto,storeId);
            if(result){
                url = "ProductManagementServlet?storeInfo=" + id + "&index=1";
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("AddProManagementServlet _ SQL: " + msg);
        } catch (NamingException ex) {
            String msg = ex.getMessage();
            log("AddProManagementServlet _ Naming: " + msg);
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
