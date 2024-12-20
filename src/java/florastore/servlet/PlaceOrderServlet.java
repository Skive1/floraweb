/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.decodeDataVNPay.DecodeData;
import florastore.eventCart.EventCartBean;
import florastore.eventCart.EventCartItem;
import florastore.eventOrder.EventOrderDAO;
import florastore.eventOrder.EventOrderDTO;
import florastore.eventOrderDetail.EventOrderDetailDAO;
import florastore.eventOrderDetail.EventOrderDetailDTO;
import florastore.eventProduct.EventProductDAO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
@WebServlet(name = "PlaceOrderServlet", urlPatterns = {"/PlaceOrderServlet"})
public class PlaceOrderServlet extends HttpServlet {

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
        String url = (String) siteMap.get(MyAppConstants.PlaceOrderFeatures.ORDER_PAGE);
        //1. Get User information
        HttpSession session = request.getSession(false);
        if (session == null) {
            url = MyAppConstants.PlaceOrderFeatures.ERROR_PAGE;
            response.sendRedirect(url);
            return;
        }
        String username = (String) session.getAttribute("USERNAME");
        AccountDTO validUser = (AccountDTO) session.getAttribute("USER");
        String emailTo = validUser.getEmail();
        EventOrderDTO temporaryInfo = (EventOrderDTO) session.getAttribute("TEMPORARY_INFO");
        List<Integer> EOIdList = new ArrayList<>();
        int eventId = 0;
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
        String responseCode = null;
        String vnp_OrderId = null;
        String encodedQuery = request.getParameter("data");
        if (encodedQuery != null) {
            DecodeData decode = new DecodeData();
            responseCode = decode.decodeResponse(encodedQuery, "response");
            vnp_OrderId = decode.decodeResponse(encodedQuery, "vnp_TxnRef");
        }
        EventOrderDTO newTemporaryInfo = new EventOrderDTO(fullname, phone, address, city, shipping, payment, note);
        session.setAttribute("TEMPORARY_INFO", newTemporaryInfo);
        String status = null;
        int numberOfUserOrder = 0;
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
            HttpSession ECartSession = request.getSession(false);
            if (ECartSession != null) {
                //3. Cust takes his/her cart
                EventCartBean cart = (EventCartBean) ECartSession.getAttribute("ECART");
                if (cart != null) {
                    //4. Cust gets items
                    Map<String, List<EventCartItem>> items = cart.getItems();
                    if (items != null) {
                        if ("ONLINE".equals(payment) && status == null) {//ONLINE PAYMENT PROCESS
                            double totalAmount = Double.parseDouble(request.getParameter("totalamount"));//ALL ORDER
                            url = (String) siteMap.get(MyAppConstants.PlaceOrderFeatures.ONLINE_PAYMENT)
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
                            htmlContent.append("<h2>Cảm ơn ").append(fullname).append(" đã mua hoa trên nền tảng chúng tôi (BUYING FROM EVENT)!</h2>");
                            htmlContent.append("<h4>Dưới đây là thông tin đặt hàng: </h4>");
                            htmlContent.append("<p>Số điện thoại: ").append(phone).append("</p>");
                            htmlContent.append("<p>Địa chỉ giao hàng: ").append(address).append(", ").append(city).append("</p>");
                            if ("Delivery".equals(shipping)) {
                                htmlContent.append("<p>Phương thức vận chuyển: Giao hàng bởi Flora Delivery</p>");
                            } else if ("Pick Up".equals(shipping)) {
                                htmlContent.append("<p>Phương thức vận chuyển: Lấy hàng tại sự kiện</p>");
                            }
                            if ("ONLINE".equals(payment)) {
                                htmlContent.append("<p>Phương thức thanh toán: Thanh toán online (VNPay)</p>");
                                htmlContent.append("<p style='font-weight: bold'>Mã hóa đơn: ").append(vnp_OrderId).append("</p>");
                            } else if ("COD".equals(payment)) {
                                htmlContent.append("<p>Phương thức thanh toán: Thanh toán khi nhận hàng</p>");
                            }
                            if ("Paid".equals(status)) {
                                htmlContent.append("<p>Tình trạng thanh toán: <span style='color: #00FF00; font-weight: bold'>Đã thanh toán</span></p>");
                            } else {
                                htmlContent.append("<p>Tình trạng thanh toán: <span style='color: red; font-weight: bold'>Chưa thanh toán</span></p>");
                            }
                            htmlContent.append("<h4>Tóm tắt chi tiết đơn hàng:</h4>");
                            // Build dynamic HTML content for the email
                            for (Map.Entry<String, List<EventCartItem>> entry : items.entrySet()) {//saving order info to order by each event
                                double total = 0;
                                //Get name of event
                                String listKey = entry.getKey();
                                //Get ordered items of event
                                List<EventCartItem> itemList = entry.getValue();
                                // Build dynamic HTML content for the email
                                htmlContent.append("<h4>Sự kiện: ").append(listKey).append("</h4>");
                                htmlContent.append("<table border='1' cellpadding='5' cellspacing='0'>");
                                htmlContent.append("<tr><th>Tên sản phẩm</th><th>Số lượng</th><th>Giá tiền</th></tr>");
                                // Build dynamic HTML content for the email
                                for (EventCartItem eventItem : itemList) {//Get eventId of each Event
                                    eventId = eventItem.getEventId();
                                    break;
                                }//Get eventId of each Event
                                for (EventCartItem eventItem : itemList) {//Get total amount of each event
                                    // Build dynamic HTML content for the email
                                    htmlContent.append("<tr>")
                                            .append("<td>").append(eventItem.getEpName()).append("</td>")
                                            .append("<td>").append(eventItem.getQuantity()).append("</td>")
                                            .append("<td>").append(df.format(eventItem.getUnitPrice() * eventItem.getQuantity())).append("vnđ</td>")
                                            .append("</tr>");
                                    // Build dynamic HTML content for the email
                                    total = total + (eventItem.getQuantity() * eventItem.getUnitPrice());
                                }//Get total amount of each event
                                // Build dynamic HTML content for the email
                                htmlContent.append("<tr><td><b>Total</b></td><td></td><td><b>").append(df.format(total)).append("vnđ</b></td></tr>");
                                htmlContent.append("</table>");
                                // Build dynamic HTML content for the email
                                if ("Paid".equals(status)) {//Update paymentStatus
                                    paymentStatus = true;
                                }//Update paymentStatus
                                EventOrderDTO orderInfo = new EventOrderDTO(username, eventId, fullname, phone, address, city, deliveryDate, shipping, payment, "Chờ giao", total, paymentStatus, note);
                                //Call DAO/Model   
                                EventOrderDAO EOrderDao = new EventOrderDAO();
                                //Saving order by each event
                                boolean resultOrder = EOrderDao.saveOrder(orderInfo);
                                numberOfUserOrder = EOrderDao.countNumberOrder(username);
                                int eventOrderId = 0;
                                if (resultOrder) {//Get eventOrderId after insert order to database
                                    eventOrderId = EOrderDao.getEventOrderId(orderInfo);
                                }//Get eventOrderId after insert order to database
                                //Save order detail by each event
                                for (EventCartItem item : itemList) {
                                    int quantity = item.getQuantity();
                                    double unitPrice = item.getUnitPrice();
                                    double totalPrice = quantity * unitPrice;
                                    int eventProductId = item.getEpId();
                                    double discount = 0;
                                    int newStockQuantity = item.getStockQuantity() - quantity;
                                    EventProductDAO dao = new EventProductDAO();
                                    //Update stock quantity
                                    dao.updateQuantityEventFlower(eventProductId, newStockQuantity);
                                    EventOrderDetailDTO orderDetail = new EventOrderDetailDTO(quantity, unitPrice, discount, totalPrice, eventOrderId, eventProductId);
                                    //Call DAO/Model to save INFO to EventOrder Table
                                    EventOrderDetailDAO EOrderDetailDao = new EventOrderDetailDAO();
                                    EOrderDetailDao.saveOrderDetail(orderDetail);
                                    EOIdList.add(eventOrderId);
                                }//saving item to order detail by each event
                            }//saving order info to order by each event
                            session.setAttribute("CUST_NAME", fullname);
                            session.setAttribute("CUST_PHONE", phone);
                            session.setAttribute("CUST_ADDRESS", address);
                            session.setAttribute("CUST_CITY", city);
                            session.setAttribute("SHIPPING", shipping);
                            session.setAttribute("CUST_PAYMENT", payment);
                            session.setAttribute("ORDER_ITEMS", cart);
                            session.setAttribute("EVENT_ORDER_ID_LIST", EOIdList);
                            session.setAttribute("PAYMENT_STATUS", paymentStatus);
                            session.setAttribute("NUMBER_ORDER", numberOfUserOrder);
                            url = (String) siteMap.get(MyAppConstants.PlaceOrderFeatures.BILL_PAGE);
                            // Build dynamic HTML content for the email
                            htmlContent.append("<p>Chúng tôi hy vọng bạn thích mua hàng của bạn. Nếu bạn có bất kỳ câu hỏi nào, vui lòng liên hệ với chúng tôi!</p>");
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
                session.removeAttribute("TEMPORARY_INFO");
                ECartSession.removeAttribute("ECART");
                ECartSession.setAttribute("PENDING_EITEMS", 0);
            }//cart place existed
        } catch (SQLException ex) {
            log("PlaceOrderServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("PlaceOrderServlet _Naming_ " + ex.getMessage());
        } catch (MessagingException ex) {
            log("ForgotPasswordServlet _ Messaging _ " + ex.getMessage());
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
