package florastore.ManageEvent;

import florastore.account.AccountDTO;
import florastore.event.EventDAO;
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
 * @author ASUS
 */
@WebServlet(name = "CloseEventServlet", urlPatterns = {"/CloseEventServlet"})
public class CloseEventServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        AccountDTO dto = null;
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.ManageEvent.ERROR_PAGE);
        HttpSession session = request.getSession();
        String EventID = request.getParameter("getEventID");

        try {
            dto = (AccountDTO) session.getAttribute("USER");
            if ("Admin".equals(dto.getRole())) {
                EventDAO dao = new EventDAO();
                boolean result = dao.closeEvent(EventID);
                if (result) {
                    url = (String) siteMap.get(MyAppConstants.ManageEvent.VIEW_EVENT);
                }
            }
        } catch (SQLException ex) {
            log("EventServlet _SQL_ " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("EventServlet Class Not Found " + ex.getMessage());
        } catch (NamingException ex) {
            log("EventServlet _Naming_ " + ex.getMessage());
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
