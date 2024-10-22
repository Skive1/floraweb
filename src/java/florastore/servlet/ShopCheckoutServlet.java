/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.cart.CartBean;
import florastore.cart.CartItem;
import florastore.flowerProducts.FlowerProductsDAO;
import florastore.managerProduct.FlowerProductDAO;
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
@WebServlet(name = "ShopCheckoutServlet", urlPatterns = {"/ShopCheckoutServlet"})
public class ShopCheckoutServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.ShopCheckoutFeatures.CART_PAGE);
        String totalAmount = request.getParameter("totalShop");
        double total = Double.parseDouble(totalAmount);
        boolean result = true;

        try {
            //1.Cust goes to his/her carts place
            HttpSession session = request.getSession(false);
            if (session != null) {
                //2.Cust takes his/her cart
                CartBean cart = (CartBean) session.getAttribute("CART");
                if (cart != null) {
                    //3. Cust gets items
                    Map<String, List<CartItem>> items = cart.getItems();
                    if (items != null) {
                        for (Map.Entry<String, List<CartItem>> entry : items.entrySet()) {
                            List<CartItem> itemList = entry.getValue();
                            for (CartItem item : itemList) {
                                FlowerProductsDAO dao = new FlowerProductsDAO();
                                int stock = dao.getProductQuantityById(item.getProductId());
                                if (item.getQuantity() > stock) {
                                    result = false;
                                    request.setAttribute("ERROR_QUANTITY", "Trong giỏ hàng đang có sản phẩm vượt quá số lượng kho");
                                    break;
                                }
                            }
                        }
                        if (result) {
                            url = (String) siteMap.get(MyAppConstants.ShopCheckoutFeatures.CHECKOUT);
                            request.setAttribute("TOTAL_AMOUNT", total);
                        }
                    }//items existed
                }//cart existed
            }//cart place existed
            else if (session == null) {
                url = (String) siteMap.get(MyAppConstants.ShopCheckoutFeatures.ERROR_PAGE);
            }
        } catch (SQLException ex) {
            log("ShopCheckoutServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ShopCheckoutServlet _Naming_ " + ex.getMessage());
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
