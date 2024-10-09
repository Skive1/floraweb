/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.eventCart.EventCartBean;
import florastore.eventCart.EventCartItem;
import florastore.eventOrder.EventOrderDAO;
import florastore.eventOrder.EventOrderDTO;
import florastore.eventOrderDetail.EventOrderDetailDAO;
import florastore.eventOrderDetail.EventOrderDetailDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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
@WebServlet(name = "PlaceOrderServlet", urlPatterns = {"/PlaceOrderServlet"})
public class PlaceOrderServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.PlaceOrderFeatures.ERROR_PAGE);

        //1. Get User information
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("USERNAME");
        int eventId = 0;
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String shipping = request.getParameter("shipping");
        String payment = request.getParameter("payment");
        Timestamp deliveryDate = null;
        

        try {
            //2. Cust goes to his/her cart place
            HttpSession ECartSession = request.getSession(false);
            if (ECartSession != null) {
                //3. Cust takes his/her cart
                EventCartBean cart = (EventCartBean) ECartSession.getAttribute("ECART");
                if (cart != null) {
                    //4. Cust gets items
                    Map<String, List<EventCartItem>> items = cart.getItems();
                    if (items != null) {
                        for (Map.Entry<String, List<EventCartItem>> entry : items.entrySet()) {
                            double total = 0;
                            List<EventCartItem> itemList = entry.getValue();
                            //Get eventId of each Event
                            for(EventCartItem eventItem : itemList){
                                eventId = eventItem.getEventId();
                                break;
                            }
                            for(EventCartItem eventItem : itemList){
                                total = total + (eventItem.getQuantity() * eventItem.getUnitPrice());
                            }
                            EventOrderDTO orderInfo = new EventOrderDTO(username, eventId, fullname, phone, address, city, deliveryDate, shipping, payment, "To Do", total, false);
                            //Call DAO/Model   
                            EventOrderDAO EOrderDao = new EventOrderDAO();
                            //Saving order by each event
                            boolean resultOrder = EOrderDao.saveOrder(orderInfo);
                            int eventOrderId = 0;
                            //Get eventOrderId after insert order to database
                            if (resultOrder) {
                                eventOrderId = EOrderDao.getEventOrderId(orderInfo);
                            }
                            //Save order detail by each event
                            for (EventCartItem item : itemList) {
                                int quantity = item.getQuantity();
                                double unitPrice = item.getUnitPrice();
                                double totalPrice = quantity * unitPrice;
                                int eventProductId = item.getEpId();
                                double discount = 0;
                                EventOrderDetailDTO orderDetail = new EventOrderDetailDTO(quantity, unitPrice, discount, totalPrice, eventOrderId, eventProductId);
                                //Call DAO/Model
                                EventOrderDetailDAO EOrderDetailDao = new EventOrderDetailDAO();
                                EOrderDetailDao.saveOrderDetail(orderDetail);
                            }//saving item to order detail by each event
                        }//saving order info to order by each event
                        request.setAttribute("CUST_NAME", fullname);
                        request.setAttribute("CUST_PHONE", phone);
                        request.setAttribute("CUST_ADDRESS", address);
                        request.setAttribute("CUST_CITY", city);
                        request.setAttribute("SHIPPING", shipping);
                        request.setAttribute("CUST_PAYMENT", payment);
                        request.setAttribute("ORDER_ITEMS", cart);
                        url = (String) siteMap.get(MyAppConstants.PlaceOrderFeatures.BILL_PAGE);
                    }//items existed
                }//cart existed
                ECartSession.removeAttribute("ECART");
            }//cart place existed
        } catch (SQLException ex) {
            log("PlaceOrderServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("PlaceOrderServlet _Naming_ " + ex.getMessage());
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
