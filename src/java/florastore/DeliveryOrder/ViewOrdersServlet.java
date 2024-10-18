package florastore.DeliveryOrder;

import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
 * @author ASUS
 */
@WebServlet(name = "ViewOrdersServlet", urlPatterns = {"/ViewOrdersServlet"})
public class ViewOrdersServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //1. Get event id
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.Delivery.ERROR_PAGE);

        HttpSession session = request.getSession();
        String getFullName = (String) session.getAttribute("USERNAME");
        int staffID = 0;
        double staffBalance = 0;
        try {
            DeliverDAO dao = new DeliverDAO();
            if (session.getAttribute("Staff_ID") == null && session.getAttribute("Staff_Balance") == null) {                     
                staffID = dao.getDeliveryStaffId(getFullName);                  //staffID không có thì tạo session cho nó, những lần sau chỉ gần getAttribute
                session.setAttribute("Staff_ID", staffID);
                staffBalance = dao.getDeliveryStaffBalance(getFullName);
                session.setAttribute("Staff_Balance", staffBalance);
            } else {
                staffID = (int) session.getAttribute("Staff_ID");
                staffBalance = (double) session.getAttribute("Staff_Balance");
            }
            
            List<DeliverDTO> orderList = dao.getDeliveryOrder();                //lấy danh sách các đơn hàng để nhận giao
            List<DeliverDTO> orderToDelivery = dao.getOrder(getFullName, staffID);       //lấy danh sách các đơn hàng để đi giao
            if (orderList != null) {
                request.setAttribute("Total_Order", orderToDelivery.size());
                request.setAttribute("DELIVERY_LIST", orderList);
            }
            session.removeAttribute("viewOrdersForDelivery");
            session.setAttribute("viewOrders", "active");
            url = (String) siteMap.get(MyAppConstants.Delivery.SHIPPER_ORDER_PAGE);
        } catch (SQLException ex) {
            log("ViewOrderServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewOrderServlet _Naming_ " + ex.getMessage());
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
