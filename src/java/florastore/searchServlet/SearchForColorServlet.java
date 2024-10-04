package florastore.searchServlet;

import florastore.searchProduct.ProductDAO;
import florastore.searchProduct.ProductDTO;
import florastore.utils.MyAppConstants;
import florastore.utils.ServiceLayer;
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
@WebServlet(name = "SearchForColorServlet", urlPatterns = {"/SearchForColorServlet"})
public class SearchForColorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.SUCCESS);

        String getColor = request.getParameter("txtColor");

        String paramPriceFrom = request.getParameter("txtPriceFrom");
        String paramPriceTo = request.getParameter("txtPriceTo");

        String pageIsActive = request.getParameter("pageNo");
        String goBack = request.getParameter("pageBack");
        String goForward = request.getParameter("pageForward");

        int pageSize = 0;
        int page = 0;
        int[] range = null;
        int[] categories = null;

        HttpSession session = request.getSession();
        String oldColor = (String) session.getAttribute("oldColor");
        String searchErrorExist = (String) session.getAttribute("errorExist");
        String checkPageActive = (String) session.getAttribute("oldCurrentPage");       //có bug ở RED

        List<ProductDTO> totalProduct = (List<ProductDTO>) session.getAttribute("totalProduct");       //SORT + cải tiến search price sau khi search Type
        List<ProductDTO> divideResult = new ArrayList<>();
        try {
            ProductDAO dao = new ProductDAO();
            ServiceLayer service = new ServiceLayer();
            pageIsActive = service.checkPagination(pageIsActive, goBack, goForward);                    //lấy trang mới nhất

            if (checkPageActive != null && searchErrorExist != null) {
                pageIsActive = checkPageActive;
                session.removeAttribute("oldColor");
            }

            session.removeAttribute("oldColor");
            session.setAttribute("oldColor", pageIsActive);

            if (oldColor != null && getColor == null) {                          //lấy type cũ khi user chuyển trang hoặc search lỗi
                getColor = oldColor;
            }

            session.removeAttribute("PriceFrom");
            session.removeAttribute("PriceTo");

            if (searchErrorExist != null) {
                session.removeAttribute("errorExist");
                session.setAttribute("PriceFrom", paramPriceFrom);              //show error input
                session.setAttribute("PriceTo", paramPriceTo);
            }
            session.removeAttribute("oldCategories");
            session.setAttribute("oldCategories", getColor);                       //dùng để search lại giá trị cũ - sửa thành giá trị getCategories

            //for (ProductDTO category : totalProduct) {
             if ("multi-color".equals(getColor)) {
                divideResult = service.getMultyColor(totalProduct);
            } else if ("other".equals(getColor)) {
                divideResult = service.getOtherColor(totalProduct);
            } else {
                divideResult = service.getSingleColor(totalProduct, getColor);                           //thực hiện add các sản phẩm có color = getColor
            }
            //}

            pageSize = service.getPage(divideResult.size());                    //làm thanh << 1 2 3 4 >>
            if (pageSize == 0) {
                pageSize = 1;
            }
            session.removeAttribute("pageSize");
            session.setAttribute("pageSize", pageSize);

            categories = service.getCategories(totalProduct);

            session.removeAttribute("freshFlower");
            session.removeAttribute("pottedFlower");
            session.removeAttribute("dryFlower");
            session.removeAttribute("otherType");

            session.setAttribute("freshFlower", categories[0]);
            session.setAttribute("pottedFlower", categories[1]);
            session.setAttribute("dryFlower", categories[2]);
            session.setAttribute("otherType", categories[3]);

            page = service.getPage(page, pageIsActive, goBack, goForward);
            range = service.getPageRange(page);

            List<ProductDTO> productList = service.getNine(divideResult, range);
            dao.searchTotalProduct("", true);                                   //giữ cho categories luôn cập nhật sản phẩm mới
            List<ProductDTO> categoryUpdate = dao.getTotalProduct();

            request.removeAttribute("requestNewProduct");
            request.setAttribute("requestNewProduct", service.getNewProduct(categoryUpdate));

            request.removeAttribute("requestResultList");
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
            session.setAttribute("searchForColor", "searchForColor active");

        } catch (SQLException ex) {
            Logger.getLogger(SearchForTypeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SearchForTypeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
