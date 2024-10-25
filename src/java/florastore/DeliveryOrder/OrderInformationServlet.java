/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.DeliveryOrder;

import florastore.ManageEvent.TotalPriceDTO;
import florastore.searchProduct.ServiceLayer;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
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

@WebServlet(name = "OrderInformationServlet", urlPatterns = {"/OrderInformationServlet"})
public class OrderInformationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.Delivery.ERROR_PAGE);

        HttpSession session = request.getSession();

        DecimalFormat df = new DecimalFormat("#,###.##");
        List<DeliverDTO> deliveryList = (List<DeliverDTO>) request.getAttribute("DELIVERY_LIST");
        List<DeliverDTO> productList = new ArrayList<>();
        List<TotalPriceDTO> totalPrint = new ArrayList<>();
        try {

            DeliverDAO dao = new DeliverDAO();

            if (deliveryList != null) {
                request.setAttribute("DELIVERY_LIST", deliveryList);
                for (int i = 0; i < deliveryList.size(); i++) {
                    List<DeliverDTO> flowerList = dao.getOrderInfo(deliveryList.get(i).getEventOrderId());
                    if (flowerList != null && !flowerList.isEmpty()) {
                        productList.addAll(flowerList);
                        double total = 0;
                        String totalOut;
                        for (DeliverDTO flowerPrice : flowerList) {
                            total += flowerPrice.getUnitPrice() * flowerPrice.getQuantity();
                        }
                        totalOut = df.format(total);
                        TotalPriceDTO result = new TotalPriceDTO(deliveryList.get(i).getEventOrderId(), totalOut);
                        totalPrint.add(result);
                    }
                }
                request.setAttribute("DELIVERY_INFO_LIST", productList);
                request.setAttribute("Total_Info_On_Page", productList.size());
                request.setAttribute("TOTAL", totalPrint);
            }
            if (session.getAttribute("viewOrders") != null) {
                url = (String) siteMap.get(MyAppConstants.Delivery.SHIPPER_ORDER_PAGE);
            } else if (session.getAttribute("viewOrdersForDelivery") != null) {
                url = (String) siteMap.get(MyAppConstants.Delivery.SHIPPER_DELIVERING_PAGE);
            }
        } catch (SQLException ex) {
            log("ViewOrderServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("ViewOrderServlet _Naming_ " + ex.getMessage());
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
