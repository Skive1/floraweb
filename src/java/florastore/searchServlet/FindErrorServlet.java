/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.searchServlet;

import florastore.searchProduct.ProductDAO;
import florastore.searchProduct.ProductDTO;
import florastore.searchProduct.SearchCreateError;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
        String url = (String) siteMap.get(MyAppConstants.SearchFeature.SEARCH_EXTEND);

        HttpSession session = request.getSession();
//        List<ProductDTO> totalProduct = (List<ProductDTO>) session.getAttribute("TOTAL_PRODUCT");

        String paramPriceFrom = request.getParameter("txtPriceFrom");
        String paramPriceTo = request.getParameter("txtPriceTo");

        int priceFrom = 0;
        int priceTo = 0;

        boolean foundError = false;                                             //cờ dò lỗi
        try {
            SearchCreateError errors = new SearchCreateError();
            if (paramPriceFrom.trim().isEmpty() || paramPriceTo.trim().isEmpty()) {         //empty
                foundError = true;
                errors.setPriceEmpty("You have to enter the valid number into both of this!");
            } else if (!paramPriceFrom.trim().matches("[0-9]+") || !paramPriceTo.trim().matches("[0-9]+")) {        //not number
                foundError = true;
                errors.setPriceInvalid("Only number are accepted!");
            }
            if (!foundError) {                                                  //not empty and only number input
                priceFrom = Integer.parseInt(paramPriceFrom);
                priceTo = Integer.parseInt(paramPriceTo);
                if (priceFrom > priceTo) {                                               //From > To (Ex: 20 <= x <= 10)
                    foundError = true;
                    errors.setPriceRangeError("Please input a valid range!");
                }
            }

            if (foundError) {                                               //tìm ra lỗi
                request.removeAttribute("PRICE_ERROR");
                request.setAttribute("PRICE_ERROR", errors);
                url = (String) siteMap.get(MyAppConstants.SearchFeature.ERROR);
            }

            session.removeAttribute("PriceFrom");
            session.removeAttribute("PriceTo");
            session.setAttribute("PriceFrom", paramPriceFrom);
            session.setAttribute("PriceTo", paramPriceTo);

//            session.removeAttribute("CURRENTPAGE");
            
            //find error here
        } finally {
            System.out.println("FindError switch");
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
