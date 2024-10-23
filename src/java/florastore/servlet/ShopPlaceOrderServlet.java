/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.cart.CartBean;
import florastore.cart.CartItem;
import florastore.flowerProducts.FlowerProductsDAO;
import florastore.order.OrderDAO;
import florastore.order.OrderDTO;
import florastore.orderDetail.OrderDetailDAO;
import florastore.orderDetail.OrderDetailDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "ShopPlaceOrderServlet", urlPatterns = {"/ShopPlaceOrderServlet"})
public class ShopPlaceOrderServlet extends HttpServlet {

    private final String emailFrom = "flora.flower.platform@gmail.com";
    private final String AppCode = "vupk fyod yexz omxp";

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

        DecimalFormat df = new DecimalFormat("#,###");
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.ShopPlaceOrderFeatures.ORDER_PAGE);
        //1. Get User information
        HttpSession session = request.getSession(false);
        if (session == null) {
            url = MyAppConstants.ShopPlaceOrderFeatures.ERROR_PAGE;
            response.sendRedirect(url);
            return;
        }
        String username = (String) session.getAttribute("USERNAME");
        AccountDTO validUser = (AccountDTO) session.getAttribute("USER");
        String emailTo = validUser.getEmail();
        OrderDTO temporaryInfo = (OrderDTO) session.getAttribute("TEMPORARY_INFO_SHOP");
        int storeId = 0;
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String shipping = request.getParameter("shipping");
        String payment = request.getParameter("payment");
        String note = request.getParameter("note");
        if (temporaryInfo != null) {
            if (fullname == null) {
                fullname = temporaryInfo.getFullname();
            }
            if (phone == null) {
                phone = temporaryInfo.getPhone();
            }
            if (address == null) {
                address = temporaryInfo.getStreet();
            }
            if (city == null) {
                city = temporaryInfo.getCity();
            }
            if (shipping == null) {
                shipping = temporaryInfo.getDeliveryOptions();
            }
            if (payment == null) {
                payment = temporaryInfo.getPaymentOptions();
            }
            if (note == null) {
                note = temporaryInfo.getNote();
            }
        }
        String responseCode = request.getParameter("responseCode");
        OrderDTO newTemporaryInfo = new OrderDTO(fullname, phone, address, city, shipping, payment, note);
        session.setAttribute("TEMPORARY_INFO_SHOP", newTemporaryInfo);
        String status = null;
        boolean paymentStatus = false;
        Timestamp deliveryDate = null;
        if ("00".equals(responseCode)) {//Check responseCode after VNPay return
            status = "Paid";
        }//Check responseCode after VNPay return
        // Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session emailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, AppCode);// Put your email
            }
        });
        try {
            //2. Cust goes to his/her cart place
            HttpSession ShopSession = request.getSession(false);
            if (ShopSession != null) {
                //3. Cust takes his/her cart
                CartBean cart = (CartBean) ShopSession.getAttribute("CART");
                if (cart != null) {
                    //4. Cust gets items
                    Map<String, List<CartItem>> items = cart.getItems();
                    if (items != null) {
                        if ("ONLINE".equals(payment) && status == null) {//ONLINE PAYMENT PROCESS
                            double totalAmount = Double.parseDouble(request.getParameter("totalamount"));//ALL ORDER
                            url = (String) siteMap.get(MyAppConstants.ShopPlaceOrderFeatures.ONLINE_PAYMENT)
                                    + "?" + "totalamount=" + totalAmount
                                    + "&bankCode=VNPAY";
                            if (!response.isCommitted()) {
                                response.sendRedirect(url);
                                return;
                            }
                        }//ONLINE PAYMENT PROCESS
                        if ("COD".equals(payment) || "00".equals(responseCode)) {//COD PAYMENT PROCESS AND PAID ORDER PROCESS
                            // Build dynamic HTML content for the email
                            StringBuilder htmlContent = new StringBuilder();
                            htmlContent.append("<h2>Thank you for your order (BUYING FROM SHOP)!</h2>");
                            htmlContent.append("<p>Here is your order summary:</p>");
                            // Build dynamic HTML content for the email
                            for (Map.Entry<String, List<CartItem>> entry : items.entrySet()) {//saving order info to order by each shop
                                double total = 0;
                                //Get name of shop
                                String listKey = entry.getKey();
                                //Get ordered items of shop
                                List<CartItem> itemList = entry.getValue();
                                // Build dynamic HTML content for the email
                                htmlContent.append("<h4>Shop: ").append(listKey).append("</h4>");
                                htmlContent.append("<table border='1' cellpadding='5' cellspacing='0'>");
                                htmlContent.append("<tr><th>Tên sản phẩm</th><th>Số lượng</th><th>Giá tiền</th></tr>");
                                // Build dynamic HTML content for the email
                                for (CartItem storeItem : itemList) {//Get shopId of each shop
                                    storeId = storeItem.getStoreId();
                                    break;
                                }//Get shopId of each shop
                                for (CartItem storeItem : itemList) {//Get total amount of each shop
                                    // Build dynamic HTML content for the email
                                    htmlContent.append("<tr>")
                                            .append("<td>").append(storeItem.getName()).append("</td>")
                                            .append("<td>").append(storeItem.getQuantity()).append("</td>")
                                            .append("<td>").append(df.format(storeItem.getUnitPrice() * storeItem.getQuantity())).append("vnđ</td>")
                                            .append("</tr>");
                                    // Build dynamic HTML content for the email
                                    total = total + (storeItem.getQuantity() * storeItem.getUnitPrice());
                                }//Get total amount of each shop
                                // Build dynamic HTML content for the email
                                htmlContent.append("<tr><td><b>Total</b></td><td></td><td><b>").append(df.format(total)).append("vnđ</b></td></tr>");
                                htmlContent.append("</table>");
                                // Build dynamic HTML content for the email
                                if ("Paid".equals(status)) {//Update paymentStatus
                                    paymentStatus = true;
                                }//Update paymentStatus
                                OrderDTO orderInfo = new OrderDTO(username, storeId, fullname, phone, address, city, deliveryDate, shipping, payment, "Chờ giao", total, paymentStatus, note);
                                //Call DAO/Model   
                                OrderDAO OrderDao = new OrderDAO();
                                //Saving order by each shop
                                boolean resultOrder = OrderDao.saveOrder(orderInfo);
                                int OrderId = 0;
                                if (resultOrder) {//Get OrderId after insert order to database
                                    OrderId = OrderDao.getOrderId(orderInfo);
                                }//Get OrderId after insert order to database
                                //Save order detail by each shop
                                for (CartItem item : itemList) {
                                    int quantity = item.getQuantity();
                                    double unitPrice = item.getUnitPrice();
                                    double totalPrice = quantity * unitPrice;
                                    int productId = item.getProductId();
                                    double discount = 0;
                                    int newStockQuantity = item.getStockQuantity() - quantity;
                                    FlowerProductsDAO dao = new FlowerProductsDAO();
                                    //Update stock quantity
                                    dao.updateQuantityShopFlower(productId, newStockQuantity);
                                    OrderDetailDTO orderDetail = new OrderDetailDTO(quantity, unitPrice, discount, totalPrice, OrderId, productId);
                                    //Call DAO/Model to save INFO to Order Table
                                    OrderDetailDAO OrderDetailDao = new OrderDetailDAO();
                                    OrderDetailDao.saveOrderDetail(orderDetail);
                                }//saving item to order detail by each shop
                            }//saving order info to order by each shop
                            session.setAttribute("CUST_NAME_SHOP", fullname);
                            session.setAttribute("CUST_PHONE_SHOP", phone);
                            session.setAttribute("CUST_ADDRESS_SHOP", address);
                            session.setAttribute("CUST_CITY_SHOP", city);
                            session.setAttribute("SHIPPING_SHOP", shipping);
                            session.setAttribute("CUST_PAYMENT_SHOP", payment);
                            session.setAttribute("ORDER_ITEMS_SHOP", cart);
                            session.setAttribute("PAYMENT_STATUS_SHOP", paymentStatus);
                            url = (String) siteMap.get(MyAppConstants.ShopPlaceOrderFeatures.BILL_PAGE);
                            // Build dynamic HTML content for the email
                            htmlContent.append("<p>We hope you enjoy your purchase. If you have any questions, feel free to contact us!</p>");
                            // Build dynamic HTML content for the email
                            //Compose email                 
                            MimeMessage message = new MimeMessage(emailSession);
                            message.setFrom(new InternetAddress(emailFrom)); // Set sender's email
                            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo)); // Recipient's email
                            message.setSubject("Your Flora Rewind Order Confirmation");
                            message.setContent(htmlContent.toString(), "text/html; charset=UTF-8"); // Set email content
                            Transport.send(message); // Send email
                        }//COD PAYMENT PROCESS AND PAID ORDER PROCESS
                    }//items existed  
                }//cart existed
                session.removeAttribute("TEMPORARY_INFO_SHOP");
                ShopSession.removeAttribute("CART");
                ShopSession.setAttribute("PENDING_ITEMS", 0);
            }//cart place existed
        } catch (SQLException ex) {
            log("ShopPlaceOrderServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ShopPlaceOrderServlet _Naming_ " + ex.getMessage());
        } catch (MessagingException ex) {
            log("ShopPlaceOrderServlet _ Messaging _ " + ex.getMessage());
        } finally {
            if (!response.isCommitted()) {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
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
