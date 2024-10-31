/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import florastore.event.EventAddNotification;
import florastore.event.EventDAO;
import florastore.event.EventDTO;
import florastore.utils.MyAppConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.NamingException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddEventServlet", urlPatterns = {"/addEventAction"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 5, // 5 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 15 // 15 MB
)
public class AddEventServlet extends HttpServlet {

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
        // Đường dẫn thư mục trong project để lưu ảnh
        Properties properties = new Properties();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/config.properties")) {
            properties.load(input);
        }
        String uploadPath = properties.getProperty("eventImg.path");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();  // Tạo thư mục nếu không tồn tại
        }

        // Lấy file từ form
        Part filePart = request.getPart("eventImg");
        if (filePart == null) {
            return;
        }

        String fileName = filePart.getSubmittedFileName();

        // Đường dẫn lưu file trong project
        String filePath = uploadPath + File.separator + fileName;

        String eventName = request.getParameter("eventName");
        String accountUsername = request.getParameter("accountUsername");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.AddEventFeatures.ADD_EVENT_PAGE);

        EventAddNotification success = new EventAddNotification();
        EventAddNotification error = new EventAddNotification();
        boolean errors = false;
        boolean flag = true;
        String errorMessage = null;
        HttpSession session = request.getSession();

        String update = request.getParameter("update") != null ? request.getParameter("update") : null;
        String eventDescriptionParam = request.getParameter("eventDescription");
        int lastCommaIndex = eventDescriptionParam.lastIndexOf(",");
//        String[] eventDescription = eventDescriptionParam.split("\\s*,\\s*");
        String eventLocation = eventDescriptionParam.substring(0, lastCommaIndex).trim().replaceAll("<.*?>", "");
//        String eventLocation = eventDescription[0].replaceAll("<.*?>", "");
//        String city = eventDescription[eventDescription.length - 1].replaceAll("<.*?>", "");
        String city = eventDescriptionParam.substring(lastCommaIndex + 1).trim().replaceAll("<.*?>", "");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        try {
            if (filePart.getSize() > 0 && filePart.getContentType().startsWith("image")) {
                filePart.write(filePath);
            }
            // Validate file format
            if (fileName.trim().isEmpty() && update != null) {
                flag = false;        //user không chọn ảnh mới thì lấy ảnh cũ (nếu là update event)
            } else if (fileName.trim().isEmpty()) {
                error.setUploadImgError("Hãy chọn ảnh!");
                errors = true;
            } else if (flag) {
                if (!fileName.endsWith(".png") || !"image/png".equals(filePart.getContentType())) {
                    error.setUploadImgError("Wrong file format. Please upload a PNG image.");
                    errors = true;
                } else if (fileName.contains("..")) {
                    error.setUploadImgError("File name must not have scpecial charaters");
                    errors = true;
                }
            }
            if (!errors) {
                if (eventDescriptionParam.trim().isEmpty()) {
                    errorMessage = "Vui lòng nhập địa điểm!";
                    request.setAttribute("Error", errorMessage);
                    errors = true;
                } else if (startDateStr.trim().isEmpty() || endDateStr.trim().isEmpty()) {
                    errorMessage = "Hãy chọn ngày bắt đầu và kết thúc sự kiện!";
                    request.setAttribute("Error", errorMessage);
                    errors = true;
                }
            }
            if (!errors) {
                // Convert the strings to Timestamp
                Timestamp startDate = Timestamp.valueOf(startDateStr.replace("T", " ") + ":00");
                Timestamp endDate = Timestamp.valueOf(endDateStr.replace("T", " ") + ":00");
                EventDAO dao = new EventDAO();

                if (update == null) {
                    EventDTO eDTO = new EventDTO(accountUsername, 0, eventName, eventLocation, city, startDate, endDate, fileName, true);
                    boolean result = dao.addEvent(eDTO);
                    if (result) {
                        success.setEventAddSuccess("Event added successfully!");
                        request.setAttribute("SUCCESS_MESSAGE", success);
                    }
                } else {
                    int eventID = (int) session.getAttribute("eventID");
                    EventDTO eDTO = null;
                    if (fileName.trim().isEmpty()) {//user không chọn ảnh mới khi update
                        update = update.substring(update.lastIndexOf("/") + 1);
                        eDTO = new EventDTO(accountUsername, 0, eventName, eventLocation, city, startDate, endDate, update, true);
                    } else {
                        eDTO = new EventDTO(accountUsername, 0, eventName, eventLocation, city, startDate, endDate, fileName, true);
                    }
                    boolean result = dao.updateEvent(eDTO, eventID);
                    if (result) {
                        success.setEventAddSuccess("Cập nhật sự kiện thành công!");
                        request.setAttribute("SUCCESS_MESSAGE", success);
                    }
                }
            }
            if (update != null) {
                url = (String) siteMap.get(MyAppConstants.SellerManagementFeatures.UPDATE_EVENT);
            }
        } catch (IOException ex) {
            log("AddEventServlet _ IO_ " + ex.getMessage());
            // Handle size limit exceptions thrown by @MultipartConfig
            error.setUploadImgError("File too large. Please upload a file smaller than 10 MB.");
            request.setAttribute("ERROR", error);
            errors = true;
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("AddEventServlet _ SQL " + msg);
            if (msg.contains("duplicate")) {
                error.setEventNameError(eventName + " is already existed in the system.");
                errors = true;
            }
        } catch (NamingException ex) {
            log("AddEventServlet _ Naming " + ex.getMessage());
        } finally {
            if (errors) {
                request.setAttribute("ERROR", error);
            }
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
