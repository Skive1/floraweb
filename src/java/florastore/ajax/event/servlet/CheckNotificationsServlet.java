/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.ajax.event.servlet;

import com.google.gson.Gson;
import florastore.notifications.NotificationsDAO;
import florastore.notifications.NotificationsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.naming.NamingException;
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
@WebServlet(name = "CheckNotificationsServlet", urlPatterns = {"/CheckNotificationsServlet"})
public class CheckNotificationsServlet extends HttpServlet {

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
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("USERNAME");
        // Sử dụng Gson để chuyển đổi danh sách thông báo thành JSON
        Gson gson = new Gson();

        try (PrintWriter out = response.getWriter()) {
            // Lấy tất cả các thông báo chưa đọc
            NotificationsDAO notificationDAO = new NotificationsDAO();
            List<NotificationsDTO> notifications = notificationDAO.getUnreadNotifications(username);
            //Nếu có thông báo chưa đọc
            if (!notifications.isEmpty()) {
                List<Integer> notificationIds = notifications.stream().map(NotificationsDTO::getId).collect(Collectors.toList());
                // Đánh dấu là đã đọc sau khi lấy thông báo
                notificationDAO.markAllAsRead(notificationIds);
                // Gửi danh sách thông báo dưới dạng JSON
                String jsonResponse = gson.toJson(notifications);
                out.write(jsonResponse);
                log("Phản hồi JSON: " + jsonResponse); // Ghi log phản hồi
            } else {
                out.write("[]"); // Trả về mảng rỗng nếu không có thông báo
            }
            out.flush();
        } catch (SQLException ex) {
            log("CheckNotificationsServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("CheckNotificationsServlet _Naming_ " + ex.getMessage());
        } finally {

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
