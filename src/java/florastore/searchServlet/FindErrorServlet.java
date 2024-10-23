/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchServlet;

import florastore.searchProduct.SearchCreateError;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Properties;
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
@WebServlet(name = "FindErrorServlet", urlPatterns = {"/FindErrorServlet"})
public class FindErrorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.ERROR);

        HttpSession session = request.getSession();

        String paramPriceFrom = request.getParameter("txtPriceFrom");
        String paramPriceTo = request.getParameter("txtPriceTo");
        int priceFrom = 0;
        int priceTo = 0;

        boolean foundError = false;                                             //cờ dò lỗi
        try {
            SearchCreateError errors = new SearchCreateError();
            if (paramPriceFrom.trim().isEmpty() && !paramPriceTo.trim().isEmpty()
                    || !paramPriceFrom.trim().isEmpty() && paramPriceTo.trim().isEmpty()) {         //empty 1 bên
                foundError = true;
                errors.setPriceEmpty("Bạn phải nhập số vào cả hai ô này!");
            } else if (!paramPriceFrom.trim().matches("\\d+") || !paramPriceTo.trim().matches("\\d+")) {        //not number
                foundError = true;
                errors.setPriceInvalid("Bạn chỉ có thể nhập số từ 0 đến 9 vào hai ô này!");
            } else if (new BigInteger(paramPriceFrom).compareTo(new BigInteger("100000000")) > 0
                    || new BigInteger(paramPriceTo).compareTo(new BigInteger("100000000")) > 0) {
                foundError = true;
                errors.setPriceInvalid("Giá tiền quá lớn, hãy thử với giá tiền nhỏ hơn.");
            }
            if (!foundError) {                                                  //not empty and only number input
                priceFrom = Integer.parseInt(paramPriceFrom);
                priceTo = Integer.parseInt(paramPriceTo);
                if (priceFrom > priceTo) {                                               //From > To (Ex: 20 <= x <= 10)
                    foundError = true;
                    errors.setPriceRangeError("Please input a valid range!");
                }
            }
            if (paramPriceFrom.trim().isEmpty() && paramPriceTo.trim().isEmpty()) {     //nếu empty 2 bên là user search color
                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_COLOR);  //txtColor không thể null vì default luôn là tìm toàn bộ
            } else if (foundError) {                                                //tìm ra lỗi thì trả về trang cũ
                request.setAttribute("PRICE_ERROR", errors);
                url = (String) siteMap.get(MyAppConstants.SearchFeature.PAGE_CONTROL);
            } else if (!foundError) {                                               //price range valid
                url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_PRICE_RANGE);    //sau khi search price xong sẽ chuyển sang search color
            }                                                                                   //nếu user chỉ search price thì dù có qua search color cũng 
            //không bị sai data vì txtColor là tìm toàn bộ
            session.removeAttribute("PriceFrom");
            session.removeAttribute("PriceTo");
            session.setAttribute("PriceFrom", paramPriceFrom);
            session.setAttribute("PriceTo", paramPriceTo);
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
