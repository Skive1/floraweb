/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.servlet;

import at.favre.lib.crypto.bcrypt.BCrypt;
import florastore.googleAccount.GoogleLogin;
import florastore.account.AccountLoginError;
import florastore.account.AccountDAO;
import florastore.account.AccountDTO;
import florastore.googleAccount.GoogleAccount;
import florastore.utils.MyAppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;
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
 * @author ADMIN
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstants.LoginFeatures.INVALID_PAGE);

        String code = request.getParameter("code");
        String authError = request.getParameter("error");
        int validAccount = 0;
        //1. Get user's information
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        AccountLoginError error = new AccountLoginError();
        boolean foundErr = false;

        log("LoginServlet _ Code: " + code);
        log("LoginServlet _ Error: " + authError);
        log("LoginServlet _ Username: " + username);
        log("LoginServlet _ Password: " + (password != null ? "********" : null)); // Mask password
        log("LoginServlet _ Initial URL: " + url);

        try {
            if (code != null) {
                if (authError == null) {
                    log("Google login code received: " + code);
                    GoogleLogin googleLogin = new GoogleLogin();
                    String accessToken = googleLogin.getToken(code);
                    GoogleAccount googleAccount = GoogleLogin.getUserInfo(accessToken);
                    String email = googleAccount.getEmail();
                    String saleId = null;
                    log("Google Account Email: " + email);

                    // Extract username from email
                    String newUsername = email.substring(0, email.indexOf("@"));
                    log("Extracted Username: " + newUsername);

                    AccountDAO dao = new AccountDAO();
                    AccountDTO authUser = dao.getAccountByGoogleAccount(email);
                    if (authUser == null) {
                        log("User not found. Creating new user.");
                        String virtualPassword = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
                        String hashPassword = BCrypt.withDefaults().hashToString(12, virtualPassword.toCharArray());
                        authUser = new AccountDTO(newUsername, hashPassword, newUsername, "Customer", email, "Hidden", "", "", "", saleId);
                        dao.createAccount(authUser); // Add user to the database
                    } else {
                        validAccount = authUser.getIsBanned();
                        log("User found: " + authUser.getUsername());
                        log("User found: " + authUser.getEmail());
                    }
                    if (validAccount == 0) {
                        url = (String) siteMap.get(MyAppConstants.LoginFeatures.HOME_PAGE);
                        HttpSession session = request.getSession(true);
                        session.setAttribute("USER", authUser);
                        session.setAttribute("USERNAME", authUser.getUsername());
                        session.setAttribute("PENDING_EITEMS", 0);
                        session.setAttribute("PENDING_ITEMS", 0);
                        session.setAttribute("LOGIN_SUCCESS", true);
                    } else {
                        url = (String) siteMap.get(MyAppConstants.LoginFeatures.INVALID_PAGE);
                        foundErr = true;
                        error.setLoginErr("Your account is banned");
                    }
                    if (foundErr) {
                        request.setAttribute("LOGIN_ERROR", error);
                    }
                } else {
                    log("OAuth Error: " + authError);
                    url = (String) siteMap.get(MyAppConstants.LoginFeatures.INVALID_PAGE);
                }
            } else {
                //2. Call DAO/Model
                AccountDAO dao = new AccountDAO();
                AccountDTO validUser = null;
                if (username.equals(username.trim()) && password.equals(password.trim())) {
                    String hashPassword = dao.getHashPassword(username) != null ? dao.getHashPassword(username) : null;
                    if (hashPassword != null) {
                        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashPassword);
                        if (result.verified) {
                            validUser = dao.getAccountByLogin(username, hashPassword);
                            //3. process result
                            if (validUser != null && validUser.getIsBanned() == 0) {//user login successful
                                url = MyAppConstants.LoginFeatures.HOME_PAGE;
                                //3.1 Create new session
                                HttpSession session = request.getSession(true);
                                session.setAttribute("USER", validUser);
                                session.setAttribute("USERNAME", username);
                                session.setAttribute("PASSWORD", password);
                                session.setAttribute("PENDING_EITEMS", 0);
                                session.setAttribute("PENDING_ITEMS", 0);
                                session.setAttribute("LOGIN_SUCCESS", true);
                                response.sendRedirect(url);
                            }//end if validAccount is not null
                            if (validUser != null && validUser.getIsBanned() == 1) {
                                foundErr = true;
                                error.setLoginErr("Tài khoản của bạn đã bị hạn chế");
                            }
                        } else {//Invalid at password
                            foundErr = true;
                            error.setLoginErr("Invalid username or password");
                        }//Invalid at password
                    } else {//Invalid at username
                        foundErr = true;
                        error.setLoginErr("Invalid username or password");
                    }//Invalid at username
                }
                if (validUser == null) {//user login failed
                    foundErr = true;
                    error.setLoginErr("Invalid username or password");
                }//end if validAccount is null
                if (foundErr) {//errors occur
                    request.setAttribute("LOGIN_ERROR", error);
                }//errors occur
            }
        } catch (SQLException ex) {
            log("LoginServlet _ SQL _ " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginServlet _ Naming _ " + ex.getMessage());
        } finally {
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
