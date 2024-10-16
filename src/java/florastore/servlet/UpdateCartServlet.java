/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.cart.CartBean;
import florastore.cart.CartItem;
import florastore.flowerProducts.FlowerProductsDAO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/UpdateCartServlet"})
public class UpdateCartServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String url = MyAppConstants.CartFeatures.VIEW_CART_PAGE;
        String action = request.getParameter("action");

        try {
            HttpSession cartSession = request.getSession(false); // Use false to not create a new session if none exists
            if (cartSession != null) { // Proceed only if session exists
                CartBean cart = (CartBean) cartSession.getAttribute("CART");
                if (cart != null) {
                    Map<String, List<CartItem>> items = cart.getItems();
                    if (items != null) {
                        String removeBt = request.getParameter("removeButton");
                        if (removeBt != null && "delete".equals(removeBt)) {
                            String key = (String) request.getParameter("key");
                            int id = Integer.parseInt(request.getParameter("Id"));
                            cart.removeItemFromCart(key, id);
                        } else if (action != null && !action.isEmpty()) {
                            int productId = Integer.parseInt(request.getParameter("productId"));
                            String storeName = request.getParameter("storeName");
                            List<CartItem> itemList = items.get(storeName);
                            if (itemList != null) {
                                for (CartItem item : itemList) {
                                    if (item.getProductId() == productId) {
//                                        log("Received new quantity: " + newQuantityStr);
                                        FlowerProductsDAO dao = new FlowerProductsDAO();
                                        // Fetch the stock quantity from the database for this product
                                        int stockQuantity = dao.getProductQuantityById(productId);
                                        int currentQuantity = item.getQuantity();
                                        if ("plus".equals(action)) {
                                            // Only increase if the current quantity is less than stock
                                            if (currentQuantity < stockQuantity) {
                                                item.setQuantity(currentQuantity + 1);
                                            }
                                        } else if ("minus".equals(action)) {
                                            // Decrease quantity, but remove item if it reaches 0
                                            if (currentQuantity > 1) {
                                                item.setQuantity(currentQuantity - 1);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    int pendingItems = cart.getUniqueItemCount();
                    double total = cart.calculateTotal();
                    cartSession.setAttribute("CART", cart);
                    cartSession.setAttribute("TOTAL", total);
                    cartSession.setAttribute("PENDING_ITEMS", pendingItems);
                }
            }
        } catch (SQLException ex) {
            log("UpdateCartServlet_SQL_" + ex.getMessage());
        } catch (NamingException ex) {
            log("UpdateCartServlet_Naming_" + ex.getMessage());
        } catch (NumberFormatException ex) {
            log("UpdateCartSerlet_NumberFormat_" + ex.getMessage());
        } finally {
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
