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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SearchPriceRangeServlet", urlPatterns = {"/SearchPriceRangeServlet"})
public class SearchPriceRangeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_COLOR);

        String paramPriceFrom = request.getParameter("txtPriceFrom");
        String paramPriceTo = request.getParameter("txtPriceTo");

        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");

        int priceFrom = 0;
        int priceTo = 0;
        int pageSize = 0;
        int page = 0;
        int[] range = null;
        int[] categories = null;

        HttpSession session = request.getSession();
        String searchErrorExist = (String) session.getAttribute("errorExist");
        String checkPageActive = (String) session.getAttribute("pageIsActive");

        List<ProductDTO> totalProduct = (List<ProductDTO>) session.getAttribute("totalProduct");       //SORT
        List<ProductDTO> divideResult = new ArrayList<>();

        try {
//            if (request.getAttribute("txtColor") != null && paramPriceFrom.isEmpty()        //nếu ko có valueSearch và ko có lỗi
//                    && paramPriceTo.isEmpty() && searchErrorExist == null) {                //tức là 
                ProductDAO dao = new ProductDAO();
                ServiceLayer service = new ServiceLayer();
                pageIsActive = service.checkPagination(pageIsActive, goBack, goForward);

                if (checkPageActive != null && searchErrorExist != null) {
                    pageIsActive = checkPageActive;
                    session.removeAttribute("checkPageExtendActive");
                }

                session.removeAttribute("pageIsActive");
                session.setAttribute("pageIsActive", pageIsActive);

                if (pageIsActive == null && searchErrorExist == null) {
                    priceFrom = Integer.parseInt(paramPriceFrom);
                    priceTo = Integer.parseInt(paramPriceTo);
                } else {
                    priceFrom = (int) session.getAttribute("PriceFromSave");
                    priceTo = (int) session.getAttribute("PriceToSave");
                }
                session.removeAttribute("PriceFrom");
                session.removeAttribute("PriceTo");
                if (searchErrorExist != null) {
                    session.removeAttribute("errorExist");
                } else {
                    session.setAttribute("PriceFrom", priceFrom);                   //show latest correct input
                    session.setAttribute("PriceTo", priceTo);
                    session.removeAttribute("currentColor");
                }

                session.removeAttribute("PriceFromSave");
                session.removeAttribute("PriceToSave");
                session.setAttribute("PriceFromSave", priceFrom);                       //dùng để search lại giá trị cũ
                session.setAttribute("PriceToSave", priceTo);

                for (ProductDTO category : totalProduct) {
                    if (priceFrom <= category.getProductPrice() && category.getProductPrice() <= priceTo) {
                        divideResult.add(category);                             //thực hiện add các phần tử có giá từ A đến B
                    }
                }

                session.removeAttribute("productOrdered");
                session.setAttribute("productOrdered", divideResult);               //dùng để in theo giá giảm/tăng

                pageSize = service.getPage(divideResult.size(), 9);
                if (pageSize == 0) {
                    pageSize = 1;
                }
                session.removeAttribute("pageSize");
                session.setAttribute("pageSize", pageSize);

                categories = service.getCategories(divideResult);

                session.removeAttribute("allType");
                session.removeAttribute("freshFlower");
                session.removeAttribute("pottedFlower");
                session.removeAttribute("dryFlower");
                session.removeAttribute("otherType");

                session.setAttribute("allType", categories[0]);
                session.setAttribute("freshFlower", categories[1]);
                session.setAttribute("pottedFlower", categories[2]);
                session.setAttribute("dryFlower", categories[3]);
                session.setAttribute("otherType", categories[4]);

                session.removeAttribute("totalProductPrice");
                session.setAttribute("totalProductPrice", divideResult);

                page = service.getPage(pageIsActive, goBack, goForward);
                range = service.getPageRange(page, 9);

                List<ProductDTO> productList = service.getNine(divideResult, range);
                dao.searchTotalProduct("", true);                                   //giữ cho categories luôn cập nhật sản phẩm mới
                List<ProductDTO> categoryUpdate = dao.getTotalProduct();

                request.setAttribute("requestColor", service.chooseColor(totalProduct));

                request.setAttribute("requestNewProduct", service.getNewProduct(categoryUpdate));

                request.setAttribute("requestResultList", productList);                   //9 sản phẩm đã vào attribute result chuẩn bị được show

                session.removeAttribute("currentPage");
                if (pageIsActive == null) {
                    session.setAttribute("currentPage", 1);                   //sau khi search hoặc nhấn Shop thì button trang 1 sẽ sáng
                } else {
                    session.setAttribute("currentPage", page);        //trường hợp chuyển từ trang 1 sang trang khác thì button sáng theo số được nhấn
                }

                session.removeAttribute("txtOrderBy");
                session.setAttribute("txtOrderBy", "default");

                session.removeAttribute("search");
                session.removeAttribute("searchForType");
                session.removeAttribute("searchForColor");
                session.removeAttribute("showOrderBy");
                session.removeAttribute("searchColorLastActive");
                session.setAttribute("searchExtend", "searchExtend active");        //phân luồng cho pageController nếu user chuyển trang/nhập lỗi
                session.setAttribute("searchPriceLastActive", "search price last active");  //vẫn hiển thị price from/to nếu user dùng tính năng ordered by
//            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchPriceRangeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SearchPriceRangeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
