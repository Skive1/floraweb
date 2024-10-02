/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchServlet;

import florastore.searchProduct.ProductDAO;
import florastore.searchProduct.ProductDTO;
import florastore.utils.MyAppConstants;
import florastore.utils.ServiceLayer;
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
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.SUCCESS);

        String searchValue = request.getParameter("txtSearchValue");
        String navbar = request.getParameter("navbarShop");

        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");
        
        String paramPriceFrom = request.getParameter("txtPriceFrom");
        String paramPriceTo = request.getParameter("txtPriceTo");
        
        int pageSize = 0;
        int page = 0;
        int[] range = null;
        int[] categories = null;

        double list = 0;

        HttpSession session = request.getSession();
        String lastSearchValue = (String) session.getAttribute("LASTSEARCH");
        String searchErrorExist = (String) session.getAttribute("ErrorToExtend");
        
        String checkPageActive = (String) session.getAttribute("checkPageActive");
        String checkNavbar = (String) session.getAttribute("checkNavbar");
        String checkSearch = (String) session.getAttribute("checkSearch");

        try {                                                                   //nhớ tối ưu hóa như cách create error và chech Note
            ProductDAO dao = new ProductDAO();
            ServiceLayer service = new ServiceLayer();
            pageIsActive = service.checkPagination(pageIsActive, goBack, goForward);

            if (checkPageActive != null) {
                pageIsActive = checkPageActive;
                session.removeAttribute("checkPageActive");
            }
            if (checkNavbar != null) {
                navbar = checkNavbar;
                session.removeAttribute("checkNavbar");
            }
            if (checkSearch != null) {
                searchValue = checkSearch;
                session.removeAttribute("checkSearch");
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
                session.removeAttribute("LASTSEARCH");                          //xóa attribute để không bị nhảy sai
                dao.searchTotalProduct(searchValue, true);               //get total product founded
                
            } else if (searchValue != null) {             //user search → show 9 sản phẩm đầu tiên được tìm thấy
                session.removeAttribute("LASTSEARCH");                          //xóa attribute ghi lại cái mới (ghi nhiều lần mà ko xóa sẽ gây quá tải)
                session.setAttribute("LASTSEARCH", searchValue);                //ghi attribute lastSearch với chuỗi lấy được từ search bar
                dao.searchTotalProduct(searchValue, false);
                
            }
            
            if (searchErrorExist != null) {
                session.removeAttribute("ErrorToExtend");
                session.setAttribute("PriceFrom", paramPriceFrom);              //show error input
                session.setAttribute("PriceTo", paramPriceTo);
            } else {
                session.removeAttribute("PriceFrom");
                session.removeAttribute("PriceTo");
            }
            
            List<ProductDTO> totalProduct = dao.getTotalProduct();              //lấy tổng sản phẩm trong kho
            list = totalProduct.size();

            pageSize = service.getPage(list);                                   //thanh chuyển trang << 1 2 3 4 >>
            if (pageSize == 0) {
                pageSize = 1;
            }
            session.removeAttribute("PAGE_SIZE");
            session.setAttribute("PAGE_SIZE", pageSize);                 //gán size để làm button trang 1 → 9
            //show 9 sản phẩm đầu tiên
            page = service.getPage(page, pageIsActive, goBack, goForward);
            range = service.getPageRange(page);                                 //lấy phạm vi sản phẩm để show

            List<ProductDTO> productList = service.getNine(totalProduct, range);               //đã lấy được 9 sản phẩm để show trang chính
            request.removeAttribute("RESULT_LIST");
            request.setAttribute("RESULT_LIST", productList);                   //9 sản phẩm đã vào attribute result chuẩn bị được show
            session.removeAttribute("TOTAL_PRODUCT");
            session.setAttribute("TOTAL_PRODUCT", totalProduct);                //Dùng cho SearchEctendServlet

            categories = service.getCategories(totalProduct);                   //để gán số lượng cho categories dựa trên phân loại từ tổng sản phẩm tìm thấy
            session.removeAttribute("FRESHFLOWER");
            session.removeAttribute("POTTEDFLOWER");
            session.removeAttribute("DRYFLOWER");
            session.removeAttribute("OTHERFLOWER");

            session.setAttribute("FRESHFLOWER", categories[0]);
            session.setAttribute("POTTEDFLOWER", categories[1]);
            session.setAttribute("DRYFLOWER", categories[2]);
            session.setAttribute("OTHERFLOWER", categories[3]);

            session.removeAttribute("CURRENTPAGE");
            if (pageIsActive == null) {
                session.setAttribute("CURRENTPAGE", 1);                   //sau khi search hoặc nhấn Shop thì button trang 1 sẽ sáng
            } else {
                session.setAttribute("CURRENTPAGE", page);        //trường hợp chuyển từ trang 1 sang trang khác thì button sáng theo số được nhấn
            }

            //dao.searchTotalProduct("", true);                                   //giữ cho categories luôn cập nhật sản phẩm mới
            List<ProductDTO> newIncome = service.getNewProduct(totalProduct);
            request.removeAttribute("NEWPRODUCT");                              //giữ cho categories luôn cập nhật
            request.setAttribute("NEWPRODUCT", newIncome);

            session.removeAttribute("SearchExtend");                            //phân luồng để PageChanger chạy
            session.setAttribute("Search", "is active");
        } catch (SQLException ex) {
            log("SearchServlet _ SQL _ " + ex.getMessage());
        } catch (NamingException ex) {
            log("SearchServlet _ Naming _ " + ex.getMessage());
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
