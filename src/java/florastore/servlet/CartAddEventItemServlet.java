/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.event.EventDAO;
import florastore.eventCart.EventCartBean;
import florastore.utils.MyAppConstants;
import java.io.IOException;
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
 * @author ADMIN
 */
@WebServlet(name = "CartAddEventItemServlet", urlPatterns = {"/CartAddEventItemServlet"})
public class CartAddEventItemServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.EventCartAddItemFeatures.EVENT_VIEW);

        try {
            //1.Cust goes to the cart place
            HttpSession ECartSession = request.getSession();
            //2.cust takes
            EventCartBean cart = (EventCartBean) ECartSession.getAttribute("ECART");
            if (cart == null) {
                cart = new EventCartBean();
            }
            // 3. Customer drops an item into the cart
            int productId = Integer.parseInt(request.getParameter("productId"));
            int eventId = Integer.parseInt(request.getParameter("eventId"));
            String imageURL = request.getParameter("imageURL");
            String productName = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("productPrice"));
            int stockQuantity = Integer.parseInt(request.getParameter("productQuantity"));
            String itemQuantityStr = request.getParameter("itemQuantity");
            int itemQuantity = (itemQuantityStr != null && !itemQuantityStr.isEmpty()) ? Integer.parseInt(itemQuantityStr) : 1;
//            log("Product Name: " + productName + ", Price: " + price + ", Item Quantity: " + itemQuantity + ", Stock Quantity: " + stockQuantity);

            //Get store name by productId
            EventDAO dao = new EventDAO();
            String eventName = dao.getEventNameByProductId(productId);

            // Get the page that made the request
            String page = request.getParameter("page");
            String pageIndex = request.getParameter("pageIndex");
            // Forward to the correct page
            if (page != null && !page.isEmpty()) {
                if (page.equals("eventDetail")) {
                    url = MyAppConstants.EventCartAddItemFeatures.EVENT_VIEW + "?eventId=" + eventId + "&page=" + pageIndex;
                } else if (page.equals("EProduct_detail")) {
                    if (itemQuantity > stockQuantity) {
                        url = MyAppConstants.EventCartAddItemFeatures.ERROR_PAGE;
                    } else {
                        url = MyAppConstants.EventCartAddItemFeatures.VIEW_ECART_PAGE;
                    }
                }
            }
            // 4. Add item to cart
            if (itemQuantity > 0 || itemQuantity <= stockQuantity) {
                boolean result = cart.addItemToCart(productId, eventId, eventName, imageURL, productName, itemQuantity, price, stockQuantity);
                if(result == false){
                    request.setAttribute("INSUFFICIENT", "Số lượng sản phẩm này trong giỏ hàng vượt qua giới hạn!");
                }
                int pendingItems = cart.getUniqueItemCount();
                double total = cart.calculateTotal();
                ECartSession.setAttribute("PENDING_EITEMS", pendingItems);
                ECartSession.setAttribute("ETOTAL", total);
                ECartSession.setAttribute("ECART", cart);
            }

        } catch (SQLException ex) {
            log("CartAddEventItemServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("CartAddEventItemServlet _Naming_ " + ex.getMessage());
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
