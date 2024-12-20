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
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.SUCCESS);

        String searchValue = request.getParameter("txtSearchValue");
        String navbar = request.getParameter("navbarShop");

        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");
        String lastSearchValue = null;
        
        String paramPriceFrom = request.getParameter("txtPriceFrom");
        String paramPriceTo = request.getParameter("txtPriceTo");

        int pageSize = 0;
        int page = 0;
        int[] range = null;
        int[] categories = null;

        double list = 0;
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("INSUFFICIENTSHOP") != null) {
                request.setAttribute("INSUFFICIENTSHOP", "Số lượng sản phẩm này trong giỏ hàng vượt qua giới hạn!");
                session.removeAttribute("INSUFFICIENTSHOP");
            }
        }
        if (session.getAttribute("lastSearch") != null) {
            lastSearchValue = (String) session.getAttribute("lastSearch");
        }
        
        String searchErrorExist = (String) session.getAttribute("errorExist");

        String checkPageActive = (String) session.getAttribute("pageIsActive");
        String checkNavbar = (String) session.getAttribute("navbar");
        String checkSearch = (String) session.getAttribute("searchValue");

        try {
            ProductDAO dao = new ProductDAO();
            ServiceLayer service = new ServiceLayer();
            //kiểm tra user có nhấn thanh chuyển trang ko
            pageIsActive = service.checkPagination(pageIsActive, goBack, goForward); 
            //3 hàm giúp định vị đúng trang cũ để trả về khi user nhập lỗi
            if (checkPageActive != null && searchErrorExist != null) {
                pageIsActive = checkPageActive;
                session.removeAttribute("pageIsActive");
            }
            if (checkNavbar != null && searchErrorExist != null) {
                navbar = checkNavbar;
                session.removeAttribute("navbar");
            }
            if (checkSearch != null && searchErrorExist != null) {
                searchValue = checkSearch;
                session.removeAttribute("searchValue");
            }

            session.removeAttribute("pageIsActive");
            session.setAttribute("pageIsActive", pageIsActive);
            session.removeAttribute("navbar");
            session.setAttribute("navbar", navbar);
            session.removeAttribute("searchValue");
            session.setAttribute("searchValue", searchValue);

            if (lastSearchValue != null && searchValue == null) {               //nếu lastSearch tồn tại thì gán vào search
                searchValue = lastSearchValue;
            }

            if (navbar != null || searchValue == null) {
                session.removeAttribute("lastSearch");                          //xóa attribute để không bị nhảy sai
                dao.searchTotalProduct("", true);               //get total product founded
            } else {             //user search → show 9 sản phẩm đầu tiên được tìm thấy
                session.removeAttribute("lastSearch");                          //xóa attribute ghi lại cái mới (ghi nhiều lần mà ko xóa sẽ gây quá tải)
                session.setAttribute("lastSearch", searchValue);                //ghi attribute lastSearch với chuỗi lấy được từ search bar
                dao.searchTotalProduct(searchValue, false);

            }

            if (searchErrorExist != null) {
                session.removeAttribute("errorExist");
            } else {
                session.removeAttribute("PriceFrom");
                session.removeAttribute("PriceTo");
                session.removeAttribute("currentColor");
            }

            List<ProductDTO> totalProduct = dao.getTotalProduct();              //lấy tổng sản phẩm tìm được trong kho
            list = totalProduct.size();

            pageSize = service.getPage(list, 9);                                   //thanh chuyển trang << 1 2 3 4 >>
            if (pageSize == 0) {
                pageSize = 1;
            }
            session.removeAttribute("pageSize");
            session.setAttribute("pageSize", pageSize);                 //gán size để làm button trang 1 → 9
            //show 9 sản phẩm đầu tiên
            page = service.getPage(pageIsActive, goBack, goForward);
            range = service.getPageRange(page, 9);                                 //lấy phạm vi sản phẩm để show

            List<ProductDTO> productList = service.getNine(totalProduct, range);               //đã lấy được 9 sản phẩm để show trang chính
            request.setAttribute("requestResultList", productList);                   //9 sản phẩm đã vào attribute result chuẩn bị được show

            session.removeAttribute("totalProduct");
            session.setAttribute("totalProduct", totalProduct);                //Dùng để search theo giá

            session.removeAttribute("productOrdered");
            session.setAttribute("productOrdered", totalProduct);               //dùng để in theo giá giảm/tăng

            categories = service.getCategories(totalProduct);                   //để gán số lượng cho categories dựa trên phân loại từ tổng sản phẩm tìm thấy

            session.removeAttribute("PriceFromSave");
            session.removeAttribute("PriceToSave");

            session.removeAttribute("allType");
            session.removeAttribute("freshFlower");
            session.removeAttribute("pottedFlower");
            session.removeAttribute("dryFlower");
            session.removeAttribute("otherType");

            request.setAttribute("requestColor", service.chooseColor(totalProduct));

            session.setAttribute("allType", categories[0]);
            session.setAttribute("freshFlower", categories[1]);
            session.setAttribute("pottedFlower", categories[2]);
            session.setAttribute("dryFlower", categories[3]);
            session.setAttribute("otherType", categories[4]);

            session.removeAttribute("currentPage");
            if (pageIsActive == null) {
                session.setAttribute("currentPage", 1);                   //sau khi search hoặc nhấn Shop thì button trang 1 sẽ sáng
            } else {
                session.setAttribute("currentPage", page);        //trường hợp chuyển từ trang 1 sang trang khác thì button sáng theo số được nhấn
            }
            
            request.setAttribute("requestNewProduct", service.getNewProduct(dao.searchAllProduct())); //giữ cho categories luôn cập nhật

            session.removeAttribute("txtOrderBy");
            session.setAttribute("txtOrderBy", "default");

            session.removeAttribute("searchExtend");                            //phân luồng để PageChanger chạy
            session.removeAttribute("searchForType");
            session.removeAttribute("searchForColor");
            session.removeAttribute("showOrderBy");
            session.removeAttribute("searchPriceLastActive");
            session.removeAttribute("searchColorLastActive");
            session.setAttribute("search", "search is active");
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
