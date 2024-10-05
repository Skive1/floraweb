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
import florastore.utils.MyAppConstants;

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

        String url = MyAppConstants.CartAddItemFeatures.SHOP_VIEW;

        try {
            //1.Cust goes to the cart place
            HttpSession session = request.getSession();
            //2.cust takes
            CartBean cart = (CartBean) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartBean();
            }
            // 3. Customer drops an item into the cart
            String imageURL = request.getParameter("imageURL");
            String productName = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("productPrice"));
            int stockQuantity = Integer.parseInt(request.getParameter("productQuantity"));
            String itemQuantityStr = request.getParameter("itemQuantity");
            int itemQuantity = (itemQuantityStr != null && !itemQuantityStr.isEmpty()) ? Integer.parseInt(itemQuantityStr) : 1;
            log("Product Name: " + productName + ", Price: " + price + ", Item Quantity: " + itemQuantity + ", Stock Quantity: " + stockQuantity);

            // Get the page that made the request
            String page = request.getParameter("page");
            // Forward to the correct page
            if (page != null && !page.isEmpty()) {
                if (page.equals("SHOP_VIEW")) {
                    url = MyAppConstants.CartAddItemFeatures.SHOP_VIEW;
                } else if (page.equals("DETAIL_PAGE")) {
                    if (itemQuantity > stockQuantity) {
                        url = MyAppConstants.CartAddItemFeatures.ERROR_PAGE;
                    } else {
                        url = MyAppConstants.CartAddItemFeatures.VIEW_CART_PAGE;
                    }
                }
            }

            // 4. Add item to cart
            cart.addItemToCart(imageURL, productName, itemQuantity, price, stockQuantity);
            session.setAttribute("CART", cart);

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
