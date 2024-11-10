/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.manageEvent2.TotalPriceDTO;
import florastore.account.AccountDTO;
import florastore.event.EventDAO;
import florastore.event.EventDTO;
import florastore.event.EventOrderDTO;
import florastore.event.EventOrderDetailDTO;
import florastore.eventProduct.EventProductDTO;
import florastore.searchProduct.ServiceLayer;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
 * @author Admin
 */
@WebServlet(name = "SellerEventManageServlet", urlPatterns = {"/SellerEventManageServlet"})
public class SellerEventManageServlet extends HttpServlet {

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

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SellerManagementFeatures.RESTRICT);

        HttpSession session = request.getSession(false);
        String account = null;
        AccountDTO dto = null;

        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");
        String infoBack = request.getParameter("infoBack");
        List<TotalPriceDTO> totalPrint = new ArrayList<>();
        String checkPageActive = (String) session.getAttribute("pageIsActive");
        int[] range = null;
        int page = 0, pageSize = 0;
        DecimalFormat df = new DecimalFormat("#,###.##");

        try {
            if (session != null) {
                account = (String) session.getAttribute("USERNAME");
                dto = (AccountDTO) session.getAttribute("USER");
                if ("Seller".equals(dto.getRole())) {
                    url = (String) siteMap.get(MyAppConstants.SellerManagementFeatures.EVENT_LIST);

                    if (pageIsActive != null) {
                        pageIsActive = pageIsActive.trim();
                    }
                    if (goBack != null) {
                        goBack = goBack.trim();
                    }
                    if (goForward != null) {
                        goForward = goForward.trim();
                    }
                    if (checkPageActive != null && infoBack != null) {                  //về trang cũ sau khi delivery xem thông tin
                        pageIsActive = checkPageActive;
                        session.removeAttribute("pageIsActive");
                    }
                    session.removeAttribute("pageIsActive");
                    session.setAttribute("pageIsActive", pageIsActive);
                    ServiceLayer service = new ServiceLayer();
                    pageIsActive = service.checkPagination(pageIsActive, goBack, goForward); //kiểm tra user có nhấn thanh chuyển trang ko
                    page = service.getPage(pageIsActive, goBack, goForward);            //trả về 1 ở lần đầu chạy, trả về n khi chạy lần 2
                    range = service.getPageRange(page, 7);                                 //lấy phạm vi sản phẩm để show
                    session.removeAttribute("currentPage");
                    if (pageIsActive == null) {
                        session.setAttribute("currentPage", 1);                   //mặc định button 1
                    } else {
                        session.setAttribute("currentPage", page);        //trường hợp chuyển từ trang 1 sang trang khác thì button sáng theo số được nhấn
                    }

                    EventDAO dao = new EventDAO();
                    List<EventDTO> events = dao.getEventByAccount(account);

                    // Get the products for the current page
                    List<EventDTO> eventsForPage = service.getSevenEvent(events, range);
                    if (eventsForPage.isEmpty()) {                                     //trường hợp delivery lấy order ở trang cuối mà trang đó chỉ có 1 order
                        range = service.getPageRange(1, 7);                         //trả về trang 1
                        session.setAttribute("currentPage", 1);
                        eventsForPage = service.getSevenEvent(events, range);
                    }

                    // Map to store order details for each order
                    Map<Integer, List<EventProductDTO>> allEventProducts = new HashMap<>();
                    for (int i = 0; i < events.size(); i++) {
                        List<EventProductDTO> products = dao.getAvailableEventFlower(events.get(i).getEventId());
                        allEventProducts.put(events.get(i).getEventId(), products);
                    }

                    session.setAttribute("PRODUCTS", allEventProducts);
                    session.setAttribute("EVENTS", eventsForPage);

                    pageSize = service.getPage(events.size(), 7);                                   //thanh chuyển trang << 1 2 3 4 >>

                    if (pageSize == 0) {
                        pageSize = 1;
                    }
                    session.removeAttribute("pageSize");
                    session.setAttribute("pageSize", pageSize);
                }
            } else if (session == null) {
                url = MyAppConstants.SellerManagementFeatures.SESSION_PAGE;
                response.sendRedirect(url);
            }
        } catch (SQLException ex) {
            log("SellerEventManageServlet _SQL_" + ex.getMessage());
        } catch (NamingException ex) {
            log("SellerEventManageServlet _Naming_" + ex.getMessage());
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
