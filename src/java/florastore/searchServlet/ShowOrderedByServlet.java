/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchServlet;

import florastore.searchProduct.ProductDAO;
import florastore.searchProduct.ProductDTO;
import florastore.utils.MyAppConstants;
import florastore.searchProduct.ServiceLayer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ShowOrderedByServlet", urlPatterns = {"/ShowOrderedByServlet"})
public class ShowOrderedByServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.SUCCESS);

        String txtOrderBy = request.getParameter("txtOrderBy");

        String paramPriceFrom = request.getParameter("txtPriceFrom");
        String paramPriceTo = request.getParameter("txtPriceTo");

        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");

        int pageSize = 0;
        int page = 0;                                                           //học phương thức sao chép nông
        int[] range = null;
        int[] categories = null;

        HttpSession session = request.getSession();
        String oldOrderBy = (String) session.getAttribute("oldOrderBy");
        String searchErrorExist = (String) session.getAttribute("errorExist");
        String checkPageActive = (String) session.getAttribute("oldCurrentPage");

        List<ProductDTO> totalProduct = (List<ProductDTO>) session.getAttribute("productOrdered");       //SORT + cải tiến search price sau khi search Type
        List<ProductDTO> divideResult = new ArrayList<>(totalProduct);
        try {
            ProductDAO dao = new ProductDAO();
            ServiceLayer service = new ServiceLayer();
            pageIsActive = service.checkPagination(pageIsActive, goBack, goForward);                    //lấy trang mới nhất

            if (checkPageActive != null && searchErrorExist != null) {
                pageIsActive = checkPageActive;
                session.removeAttribute("oldOrderBy");
            }

            session.removeAttribute("oldCurrentPage");
            session.setAttribute("oldCurrentPage", pageIsActive);

            if (oldOrderBy != null && txtOrderBy == null) {                          //lấy type cũ khi user chuyển trang hoặc search lỗi
                txtOrderBy = oldOrderBy;
            }

            session.removeAttribute("PriceFrom");
            session.removeAttribute("PriceTo");

            if (searchErrorExist != null) {
                session.removeAttribute("errorExist");
            } else {
                session.removeAttribute("PriceFrom");
                session.removeAttribute("PriceTo");
                if (session.getAttribute("searchPriceLastActive") != null) {
                    session.setAttribute("PriceFrom", session.getAttribute("PriceFromSave"));
                    session.setAttribute("PriceTo", session.getAttribute("PriceToSave"));
                }
                if (session.getAttribute("searchColorLastActive") != null) {
                    session.setAttribute("currentColor", session.getAttribute("currentColor"));
                }
            }

            session.removeAttribute("oldOrderBy");
            session.setAttribute("oldOrderBy", txtOrderBy);                       //dùng để search lại giá trị cũ - sửa thành giá trị getCategories

            if ("default".equals(txtOrderBy)) {                                 //hiện tại là default thì chuyển sang ascending
                session.removeAttribute("txtOrderBy");                          //collection tác động trực tiếp cả attribute
                session.setAttribute("txtOrderBy", "ascending");
                service.sortInOrder(divideResult, true);
            } else if ("ascending".equals(txtOrderBy)) {
                session.removeAttribute("txtOrderBy");
                session.setAttribute("txtOrderBy", "descending");
                service.sortInOrder(divideResult, false);
            } else {
                session.removeAttribute("txtOrderBy");
                session.setAttribute("txtOrderBy", "default");
//                divideResult = totalProduct;
            }

            request.setAttribute("requestColor", service.chooseColor(totalProduct));

//            request.removeAttribute("currentColor");
//            request.setAttribute("currentColor", getColor);
            pageSize = service.getPage(divideResult.size());                    //làm thanh << 1 2 3 4 >>
            if (pageSize == 0) {
                pageSize = 1;
            }
            session.removeAttribute("pageSize");
            session.setAttribute("pageSize", pageSize);

            page = service.getPage(page, pageIsActive, goBack, goForward);
            range = service.getPageRange(page);

            List<ProductDTO> productList = service.getNine(divideResult, range);
            dao.searchTotalProduct("", true);                                   //giữ cho categories luôn cập nhật sản phẩm mới
            List<ProductDTO> categoryUpdate = dao.getTotalProduct();

            request.setAttribute("requestNewProduct", service.getNewProduct(categoryUpdate));

            request.setAttribute("requestResultList", productList);                   //12 sản phẩm đã vào attribute result chuẩn bị được show

            session.removeAttribute("currentPage");
            if (pageIsActive == null) {
                session.setAttribute("currentPage", 1);                   //sau khi search hoặc nhấn Shop thì button trang 1 sẽ sáng
            } else {
                session.setAttribute("currentPage", page);        //trường hợp chuyển từ trang 1 sang trang khác thì button sáng theo số được nhấn
            }
            session.removeAttribute("search");
            session.removeAttribute("searchExtend");
            session.removeAttribute("searchForType");
            session.removeAttribute("searchForColor");
            session.setAttribute("showOrderBy", "showOrderBy active");
        } catch (SQLException ex) {
            log("ViewProfileServlet _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewProfileServlet _ Naming " + ex.getMessage());
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
