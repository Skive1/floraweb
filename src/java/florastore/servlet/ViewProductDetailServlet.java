/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.cart.CartBean;
import florastore.cart.CartItem;
import florastore.flowerProducts.FlowerProductsCategoryDTO;
import florastore.flowerProducts.FlowerProductsDAO;
import florastore.flowerProducts.FlowerProductsDTO;
import florastore.searchProduct.ProductDAO;
import florastore.searchProduct.ServiceLayer;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ViewProductDetailServlet", urlPatterns = {"/ViewProductDetailServlet"})
public class ViewProductDetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //1. Get id of flower
        int productId = Integer.parseInt(request.getParameter("productId"));
        String relatedType = request.getParameter("productType");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.ViewProductDetailFeatures.ERROR_PAGE);

        //initial quantity
        int itemQuantity = 1;
        try {
            //Check cart place
            HttpSession session = request.getSession(false);
            if (session != null) {
                if (session.getAttribute("INSUFFICIENTSHOP") != null) {
                    request.setAttribute("INSUFFICIENTSHOP", "Số lượng sản phẩm này trong giỏ hàng vượt qua giới hạn!");
                    session.removeAttribute("INSUFFICIENTSHOP");
                }
            }
            ServiceLayer service = new ServiceLayer();
            //2. Call DAO/Model
            FlowerProductsDAO dao = new FlowerProductsDAO();
            ProductDAO productDao = new ProductDAO();
            //2.1 Get flower detail
            FlowerProductsDTO flowerDetail = dao.getFlowerDetail(productId);
            //2.2 Get top categories
            List<FlowerProductsCategoryDTO> topCategories = dao.getProductsTypeAndQuantity();
            //2.3 Get related flowers
            dao.getRelatedProduct(productId, relatedType);
            //3. Process result
            List<FlowerProductsDTO> relatedProducts = dao.getRelatedProducts();

            if (flowerDetail != null) {//check flower in detail is available
                url = (String) siteMap.get(MyAppConstants.ViewProductDetailFeatures.DETAIL_PAGE);
                //4. Push to Product Detail
                request.setAttribute("PRODUCT_DETAIL", flowerDetail);
                request.setAttribute("CATEGORIES_TOP", topCategories);
                request.setAttribute("RELATED_PRODUCTS", relatedProducts);
                request.setAttribute("ITEM_QUANTITY", itemQuantity);
            }//check flower in detail is available
            request.setAttribute("requestNewProduct", service.getNewProduct(productDao.searchAllProduct()));
        } catch (SQLException ex) {
            log("ViewProductDetailServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewProductDetailServlet _Naming_ " + ex.getMessage());
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
