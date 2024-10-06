/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.eventCart.EventCartBean;
import florastore.eventCart.EventCartItem;
import florastore.eventProduct.EventProductDAO;
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
 * @author ADMIN
 */
@WebServlet(name = "UpdateEventCartServlet", urlPatterns = {"/UpdateEventCartServlet"})
public class UpdateEventCartServlet extends HttpServlet {

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

//        ServletContext context = request.getServletContext();
//        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = MyAppConstants.EventCartFeatures.VIEW_CART_PAGE;
        String action = request.getParameter("action");

        try {
            HttpSession ECartSession = request.getSession(false); // Use false to not create a new session if none exists;
            if (ECartSession != null) { // Proceed only if session exists
                EventCartBean cart = (EventCartBean) ECartSession.getAttribute("ECART");
                if (cart != null) {
                    Map<String, List<EventCartItem>> items = cart.getItems();
                    if (items != null) {
                        String removeBt = request.getParameter("removeButton");
                        if (removeBt != null) {
                            String key = request.getParameter("ekey");
                            String name = request.getParameter("ename");
                            cart.removeItemFromCart(key, name);
                        } else {
                            String productName = request.getParameter("eventProductName");
                            String eventName = request.getParameter("eventName");
                            String newQuantityStr = request.getParameter("quantity"); // Get the updated quantity from the form
                            List<EventCartItem> itemList = items.get(eventName);
                            if (itemList != null) {
                                for (EventCartItem item : itemList) {
                                    if (item.getEpName().equals(productName)) {
//                                        log("Received new quantity: " + newQuantityStr);
                                        EventProductDAO dao = new EventProductDAO();
                                        // Fetch the stock quantity from the database for this product
                                        int stockQuantity = dao.getProductQuantityByName(productName);

                                        if (newQuantityStr != null && !newQuantityStr.isEmpty() && !newQuantityStr.equals("NaN")) {

                                            int newQuantity = Integer.parseInt(newQuantityStr); // Parse the new quantity
//                                            log("Parsed new quantity: " + newQuantity);
                                            // Validate the quantity within stock limits
                                            if (newQuantity > 0 && newQuantity <= stockQuantity) {
                                                item.setQuantity(newQuantity); // Set the new quantity from the user input
                                            }
                                        } else {
                                            // Handle button actions only if quantity input is not provided

                                            if (action != null && !action.isEmpty()) {
//                                                log("Received action: " + action);
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
                        }
                    }
                    int pendingItems = cart.getUniqueItemCount();
                    double total = cart.calculateTotal();
                    ECartSession.setAttribute("ECART", cart);
                    ECartSession.setAttribute("ETOTAL", total);
                    ECartSession.setAttribute("PENDING_EITEMS", pendingItems);
                }
            }
        } catch (SQLException ex) {
            log("UpdateEventCartServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("UpdateEventCartServlet _Naming_ " + ex.getMessage());
        } catch (NumberFormatException ex) {
            log("UpdateEventCartServlet _NumberFormat_ " + ex.getMessage());
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
