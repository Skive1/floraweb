package florastore.sellerManageOrder;

import florastore.deliveryOrder2.*;
import florastore.account.AccountDTO;
import florastore.deliveryBalance.DeliveryBalanceDAO;
import florastore.deliveryBalance.DeliveryBalanceDTO;
import florastore.searchProduct.ServiceLayer;
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
@WebServlet(name = "sellerViewOrdersServlet", urlPatterns = {"/sellerViewOrdersServlet"})
public class sellerViewOrdersServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        AccountDTO dto = null;
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SellerManageOrder.ERROR);
        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");
        String infoBack = request.getParameter("infoBack");
        String username = null;
        
        HttpSession session = request.getSession();
        String checkPageActive = (String) session.getAttribute("pageIsActive");
        int[] range = null;
        int page = 0, pageSize = 0;
        try {
            username = (String) session.getAttribute("USERNAME");
            dto = (AccountDTO) session.getAttribute("USER");
            if ("Seller".equals(dto.getRole())) {
                if (pageIsActive != null) {
                    pageIsActive = pageIsActive.trim();
                }
                if (goBack != null) {
                    goBack = goBack.trim();
                }
                if (goForward != null) {
                    goForward = goForward.trim();
                }
                //về lại trang N sau khi delivery nhận đơn tại trang N
                if (checkPageActive != null && infoBack != null) {
                    pageIsActive = checkPageActive;
                    session.removeAttribute("pageIsActive");
                }
                session.removeAttribute("pageIsActive");
                session.setAttribute("pageIsActive", pageIsActive);
                ServiceLayer service = new ServiceLayer();
                page = service.getPage(pageIsActive, goBack, goForward);            //trả về 1 ở lần đầu chạy, trả về n khi chạy lần 2
                range = service.getPageRange(page, 7);                                 //lấy phạm vi sản phẩm để show
                pageIsActive = service.checkPagination(pageIsActive, goBack, goForward);
                session.removeAttribute("currentPage");
                if (pageIsActive == null) {
                    session.setAttribute("currentPage", 1);                   //mặc định button 1
                } else {
                    session.setAttribute("currentPage", page);        //trường hợp chuyển từ trang 1 sang trang khác thì button sáng theo số được nhấn
                }
                
                DeliverDAO dao = new DeliverDAO();
                List<DeliverDTO> orderList = dao.sellerGetDeliveryOrder(username);                //lấy danh sách các đơn hàng để nhận giao
                if (!orderList.isEmpty()) {
                    List<DeliverDTO> deliveryList = service.getSeven(orderList, range);               //đã lấy được n sản phẩm để show trang chính
                    if (deliveryList.isEmpty()) {                                     //trường hợp delivery lấy order ở trang cuối mà trang đó chỉ có 1 order
                        range = service.getPageRange(1, 7);                         //trả về trang 1
                        session.setAttribute("currentPage", 1);
                        deliveryList = service.getSeven(orderList, range);
                    }
                    request.setAttribute("DELIVERY_LIST", deliveryList);
                }
                pageSize = service.getPage(orderList.size(), 7);                                   //thanh chuyển trang << 1 2 3 4 >>
                if (pageSize == 0) {
                    pageSize = 1;
                }
                session.removeAttribute("pageSize");
                session.setAttribute("pageSize", pageSize);                 //gán size để làm button trang 1 → n
                url = (String) siteMap.get(MyAppConstants.SellerManageOrder.ORDER_DELIVERING_INFO);
            }
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
