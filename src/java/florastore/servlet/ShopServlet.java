/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.flowerProducts.FlowerProductsDAO;
import florastore.flowerProducts.FlowerProductsDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author Admin
 */
@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.ShopFeatures.SHOP_PAGE);
        
        log("ShopServlet: Starting processRequest. Retrieving products...");
         
        try {
            FlowerProductsDAO dao = new FlowerProductsDAO();
            
            log("ShopServlet: Calling productDAO.getAllProducts()...");
            
            List<FlowerProductsDTO> products = dao.getAllProducts();
            
            // Paging
            int pageSize = 9; // Number of products per page
            String pageParam = request.getParameter("page"); // Get the current page number from the request
            int currentPage = pageParam != null ? Integer.parseInt(pageParam) : 1; // Default to page 1 if not provided
            int totalProducts = products.size();
            int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
            
            // Calculate the starting and ending indexes for the sublist of products to display
            int start = (currentPage - 1) * pageSize;
            int end = Math.min(start + pageSize, totalProducts);

            // Get the products for the current page
            List<FlowerProductsDTO> productsForPage = products.subList(start, end);
            
            //categories
            Map<String, Integer> categoriesMap = new HashMap<>();
            for (FlowerProductsDTO product : products) {
                String category = product.getProductType();
                categoriesMap.put(category, categoriesMap.getOrDefault(category, 0) + 1);
            }
            
//            if (products != null && !products.isEmpty()) {
//                log("ShopServlet: Successfully retrieved " + products.size() + " products.");
//                for (FlowerProductsDTO product : products) {
//                    log("ShopServlet: Product -> ID: " + product.getProductId() +
//                        ", Name: " + product.getProductName() +
//                        ", Price: " + product.getProductPrice());
//                }
//            } else {
//                log("ShopServlet: No products were retrieved from the database.");
//            }
            
            request.setAttribute("products", productsForPage);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("categories", categoriesMap);
            request.setAttribute("allProducts", totalProducts);
        }catch (SQLException ex){
            log("ShopServlet_SQL_" + ex.getMessage());
        } catch (NamingException ex){
            log("ShopServlet_Naming_" + ex.getMessage());
        } finally {
            log("ShopServlet: Forwarding request to JSP: " + url);
            
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
