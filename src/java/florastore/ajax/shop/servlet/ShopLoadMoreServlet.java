/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.ajax.shop.servlet;

import florastore.reviewShopProduct.ReviewShopProductDAO;
import florastore.reviewShopProduct.ReviewShopProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ShopLoadMoreServlet", urlPatterns = {"/ShopLoadMoreServlet"})
public class ShopLoadMoreServlet extends HttpServlet {

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

        int page = Integer.parseInt(request.getParameter("page"));
        int productId = Integer.parseInt(request.getParameter("productId"));

        int commentsPerPage = 5; // Số bình luận mỗi trang
        int offset = (page - 1) * commentsPerPage;

        try {
            ReviewShopProductDAO reviewDAO = new ReviewShopProductDAO();
            List<ReviewShopProductDTO> commentList = reviewDAO.getCommentByProductId(productId, commentsPerPage, offset);
            PrintWriter out = response.getWriter();
            for (ReviewShopProductDTO comment : commentList) {
                String safeComment = StringEscapeUtils.escapeHtml4(comment.getStatus());
                out.println("<div class='d-flex'>");
                out.println("<img src='img/avatar.jpg' class='img-fluid rounded-circle p-3' style='width: 100px; height: 100px;' alt=''>");
                out.println("<div>");
                out.println("<p class='mb-2' style='font-size: 14px;'>");
                out.println(new java.text.SimpleDateFormat("dd/MM/yyyy - HH:mm").format(comment.getReviewDate()));
                out.println("</p>");
                out.println("<div class='d-flex justify-content-between'>");
                out.println("<h5>" + comment.getUsername() + "</h5>");
                out.println("</div>");
                out.println("<p>" + safeComment + "</p>");
                out.println("</div>");
                out.println("</div>");
            }
        } catch (SQLException ex) {
            log("LoadMoreCommentsServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoadMoreCommentsServlet _Naming_ " + ex.getMessage());
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
