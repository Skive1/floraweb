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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
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

        String url = MyAppConstants.CartFeatures.VIEW_CART_PAGE;
        String action = request.getParameter("action");

        try {
            HttpSession session = request.getSession(false); // Use false to not create a new session if none exists
            if (session != null) { // Proceed only if session exists
                CartBean cart = (CartBean) session.getAttribute("CART");
                if (cart != null) {
                    // Get the item index from the query string
                    String itemIndexStr = request.getParameter("itemIndex");
                    int itemIndex = Integer.parseInt(itemIndexStr);  // Convert it to int

                    FlowerProductsDAO dao = new FlowerProductsDAO();

                    CartItem item = (CartItem) cart.getItems().values().toArray()[itemIndex - 1];

                    if (item != null) {
                        String removeBt = request.getParameter("removeButton");
                        if (removeBt != null) {
                            cart.getItems().remove(item.getName());
                        } else {

                            String newQuantityStr = request.getParameter("quantity"); // Get the updated quantity from the form
                            log("Received new quantity: " + newQuantityStr);

                            // Fetch the stock quantity from the database for this product
                            int stockQuantity = dao.getProductQuantityByName(item.getName());

                            if (newQuantityStr != null && !newQuantityStr.isEmpty() && !newQuantityStr.equals("NaN")) {

                                int newQuantity = Integer.parseInt(newQuantityStr); // Parse the new quantity
                                log("Parsed new quantity: " + newQuantity);
                                // Validate the quantity within stock limits
                                if (newQuantity > 0 && newQuantity <= stockQuantity) {
                                    item.setQuantity(newQuantity); // Set the new quantity from the user input
                                } else {
                                    log("Invalid quantity: " + newQuantityStr);
                                    // Handle invalid quantity input (e.g., redirect to an error page)
                                }
                            } else {
                                // Handle button actions only if quantity input is not provided

                                if (action != null && !action.isEmpty()) {
                                    log("Received action: " + action);
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

                    session.setAttribute("CART", cart);
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
