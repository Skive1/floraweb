/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import florastore.cart.CartBean;
import florastore.flowerStore.FlowerStoreDAO;
import florastore.utils.MyAppConstants;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CartAddItemServlet", urlPatterns = {"/CartAddItemServlet"})
public class CartAddItemServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.CartAddItemFeatures.SHOP_VIEW);

        try {
            //1.Cust goes to the cart place
            HttpSession session = request.getSession();
            //2.cust takes
            CartBean cart = (CartBean) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartBean();
            }
            // 3. Customer drops an item into the cart
            int productId = Integer.parseInt(request.getParameter("productId"));
            int storeId = Integer.parseInt(request.getParameter("storeId"));
            String imageURL = request.getParameter("imageURL");
            String productName = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("productPrice"));
            int stockQuantity = Integer.parseInt(request.getParameter("productQuantity"));
            String itemQuantityStr = request.getParameter("itemQuantity");
            int itemQuantity = (itemQuantityStr != null && !itemQuantityStr.isEmpty()) ? Integer.parseInt(itemQuantityStr) : 1;
//            log("Product Name: " + productName + ", Price: " + price + ", Item Quantity: " + itemQuantity + ", Stock Quantity: " + stockQuantity);

            //Get store name by productId
            FlowerStoreDAO dao = new FlowerStoreDAO();
            String storeName = dao.getStoreName(productId);

            // Get the page that made the request
            String page = request.getParameter("page");
            String pageIndex = request.getParameter("pageIndex");
            // Forward to the correct page
            if (page != null && !page.isEmpty()) {
                if (page.equals("shop")) {
                    url = ((String) MyAppConstants.CartAddItemFeatures.SHOP_VIEW) + "?page=" + pageIndex;
                } else if (page.equals("DETAIL_PAGE")) {
                    if (itemQuantity > stockQuantity) {
                        url = MyAppConstants.CartAddItemFeatures.ERROR_PAGE;
                    } else {
                        url = MyAppConstants.CartAddItemFeatures.VIEW_CART_PAGE;
                    }
                }
            }

            // 4. Add item to cart
            if (itemQuantity > 0 || itemQuantity <= stockQuantity) {
                cart.addItemToCart(productId, storeId, storeName, imageURL, productName, itemQuantity, price, stockQuantity);
                int pendingItems = cart.getUniqueItemCount();
                double total = cart.calculateTotal();
                session.setAttribute("PENDING_ITEMS", pendingItems);
                session.setAttribute("TOTAL", total);
                session.setAttribute("CART", cart);
            }

        } catch (SQLException ex) {
            log("CartAddItemServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("CartAddItemServlet _Naming_ " + ex.getMessage());
        } finally {
            //4.cust goes to shopping
            response.sendRedirect(url);
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
