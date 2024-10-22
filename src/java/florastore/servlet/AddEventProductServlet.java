/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.event.EventDAO;
import florastore.event.EventProductAddNotification;
import florastore.event.EventProductDTO;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddEventProductServlet", urlPatterns = {"/AddEventProductServlet"})
public class AddEventProductServlet extends HttpServlet {

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

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.AddEventProductFeatures.ADD_EVENT_PRODUCT_PAGE);

        // Getting form parameters
        String productName = request.getParameter("name");
        String quantityStr = request.getParameter("quantity");
        String priceStr = request.getParameter("epPrice");
        String discountStr = request.getParameter("discount");
        String detail = request.getParameter("detail");
        String condition = request.getParameter("condition");
        String type = request.getParameter("type");
        String categoryInfo = request.getParameter("ddlCategory");
        String imgUrl = request.getParameter("flowerImgUrl");

        log("category info" + categoryInfo);
        // Splitting category info to get categoryId and categoryName
        String[] categoryParts = categoryInfo.split("\\|");
        String categoryIdStr = categoryParts[0];
        int categoryId = Integer.parseInt(categoryIdStr);

        //event id
        int eventId = Integer.parseInt(request.getParameter("eventId"));

        // Converting numeric strings to proper types
        int quantity = Integer.parseInt(quantityStr);
        double price = Double.parseDouble(priceStr);
        double discount = Double.parseDouble(discountStr);

        EventProductAddNotification success = new EventProductAddNotification();
        EventProductAddNotification error = new EventProductAddNotification();
        boolean bErr = false;

        try {
            if (discount == price || discount > price) {
                error.setDiscountError("Discount must be lower than price");
                bErr = true;
            }

            if (bErr) {
                request.setAttribute("ERROR", error);
            } else {
                // Create a new EventProduct object and save to the database (pseudo code)
                EventProductDTO newProduct = new EventProductDTO(0, productName, type, condition, detail, imgUrl, quantity, price - discount);

                // Assuming you have a DAO or service to add the product to the database
                EventDAO dao = new EventDAO();
                boolean isProductAdded = dao.addEventProduct(newProduct, categoryId, eventId);

                if (isProductAdded) {
                    success.setEventProductAddSuccess("Product added successfully!!!");
                    request.setAttribute("SUCCESS", success);
                    request.setAttribute("EVENT_ID", eventId);
                }
            }
        } catch (SQLException ex) {
            log("AddEventProductServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("AddEventProductServlet _Naming_ " + ex.getMessage());
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
