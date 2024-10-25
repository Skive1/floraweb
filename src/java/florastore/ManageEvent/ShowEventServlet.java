/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.ManageEvent;

import florastore.event.EventDAO;
import florastore.event.EventDTO;
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
 * @author ADMIN
 */
@WebServlet(name = "ShowEventServlet", urlPatterns = {"/ShowEventServlet"})
public class ShowEventServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.ManageEvent.ERROR_PAGE);

        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");
        String infoBack = request.getParameter("infoBack");

        HttpSession session = request.getSession();
        String checkPageActive = (String) session.getAttribute("pageIsActive");
        int[] range = null;
        int page = 0, pageSize = 0;
        try {
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
            //Call DAO/Model
            EventDAO dao = new EventDAO();
            List<EventDTO> events = dao.getAllEventExcept();
            //Process result
            if (!events.isEmpty()) {
                List<EventDTO> eventList = service.getSevenEvent(events, range);
                if (!eventList.isEmpty()) {
                    request.setAttribute("Event_List", eventList);
                    request.setAttribute("Total_Event", eventList.size());
                    url = (String) siteMap.get(MyAppConstants.ManageEvent.VIEW_EVENT_DETAIL);
                }
            }

            pageSize = service.getPage(events.size(), 7);                                   //thanh chuyển trang << 1 2 3 4 >>

            if (pageSize == 0) {
                pageSize = 1;
            }
            session.removeAttribute("pageSize");
            session.setAttribute("pageSize", pageSize);                 //gán size để làm button trang 1 → n
        } catch (SQLException ex) {
            log("EventServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("EventServlet _Naming_ " + ex.getMessage());
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
