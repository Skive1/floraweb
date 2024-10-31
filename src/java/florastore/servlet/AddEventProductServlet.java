/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.account.AccountDTO;
import florastore.event.EventDAO;
import florastore.event.EventProductAddNotification;
import florastore.eventProduct.EventProductDTO;
import florastore.utils.MyAppConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddEventProductServlet", urlPatterns = {"/addEventProductAction"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 5, // 5 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 15 // 15 MB
)
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

        // Đường dẫn thư mục trong project để lưu ảnh
        Properties properties = new Properties();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/config.properties")) {
            properties.load(input);
        }
        String uploadPath = properties.getProperty("eventProductImg.path");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();  // Tạo thư mục nếu không tồn tại
        }

        // Getting form parameters
        String productName = request.getParameter("name");
        String quantityStr = request.getParameter("quantity");
        String priceStr = request.getParameter("epPrice");
        String discountStr = request.getParameter("discount");
        String detail = request.getParameter("detail");
        String condition = request.getParameter("condition");
        String type = request.getParameter("type");
        String categoryInfo = request.getParameter("ddlCategory");

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
        HttpSession session = request.getSession(false);

        try {
            if (session != null) {
                AccountDTO user = (session.getAttribute("USER") != null) ? (AccountDTO) session.getAttribute("USER") : null;
                String role = (user != null) ? user.getRole() : null;
                if ("Seller".equals(role)) {
                    // Lấy file từ form
                    Part filePart = request.getPart("flowerImg");
                    if (filePart == null) {
                        return;
                    }

                    String fileName = filePart.getSubmittedFileName();

                    // Đường dẫn lưu file trong project
                    String filePath = uploadPath + File.separator + fileName;
                    if (filePart.getSize() > 0 && filePart.getContentType().startsWith("image")) {
                        filePart.write(filePath);
                    }
                    if (discount == price || discount > price) {
                        error.setDiscountError("Discount must be lower than price");
                        bErr = true;
                    } else if (!fileName.endsWith(".png") || !"image/png".equals(filePart.getContentType())) {
                        error.setUploadImgError("Wrong file format. Please upload a PNG image.");
                        bErr = true;
                    } else if (fileName.contains("..")) {
                        error.setUploadImgError("File name must not have scpecial charaters");
                        bErr = true;
                    }

                    if (!bErr) {
                        request.setAttribute("ERROR", error);

                        // Create a new EventProduct object and save to the database (pseudo code)
                        EventProductDTO newProduct = new EventProductDTO(0, eventId, productName, type, condition, detail, fileName, quantity, price - discount);

                        // Assuming you have a DAO or service to add the product to the database
                        EventDAO dao = new EventDAO();
                        boolean isProductAdded = dao.addEventProduct(newProduct, categoryId, eventId);

                        if (isProductAdded) {
                            success.setEventProductAddSuccess("Product added successfully!!!");
                            request.setAttribute("SUCCESS", success);
                            request.setAttribute("EVENT_ID", eventId);
                        }
                    }
                } else {
                    url = MyAppConstants.AddEventProductFeatures.ERROR_PAGE;
                    response.sendRedirect(url);
                }
            }
        } catch (IOException ex) {
            log("AddEventProductServlet _IO_ " + ex.getMessage());
            // Handle size limit exceptions thrown by @MultipartConfig
            error.setUploadImgError("File too large. Please upload a file smaller than 10 MB.");
            request.setAttribute("ERROR", error);
            bErr = true;
        } catch (SQLException ex) {
            log("AddEventProductServlet _SQL_ " + ex.getMessage());
        } catch (NamingException ex) {
            log("AddEventProductServlet _Naming_ " + ex.getMessage());
        } finally {
            if (bErr) {
                request.setAttribute("ERROR", error);
            }
            if (!response.isCommitted()) {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
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
