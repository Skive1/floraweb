/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.filter;

import florastore.account.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebFilter(filterName = "DispatcherFilter", urlPatterns = {"/*"})
public class DispatcherFilter implements Filter {

    private static final boolean DEBUG = true;
    private FilterConfig filterConfig = null;

    private final List<String> admin;
    private final List<String> seller;
    private final List<String> delivery;

    public DispatcherFilter() {
        //Admin
        admin = new ArrayList<>();
        admin.add("monthlyBoard");
        admin.add("monthlyRevenue");
        admin.add("monthlyEvent");
        admin.add("weeklyBoard");
        admin.add("weeklyRevenue");
        admin.add("monthlyEventRevenue");
        admin.add("weeklyProductBoard");
        admin.add("weeklyProduct");
        admin.add("manageAccount");
        admin.add("update");
        admin.add("delete");
        admin.add("viewEvent");
        //Seller
        seller = new ArrayList<>();
        seller.add("showEventId");
        seller.add("monthlyEventSell");
        seller.add("viewSellerEvent");
        seller.add("viewOrderAction");
        seller.add("viewDeliveredAction");
        seller.add("viewFeedbacks");
        seller.add("sellerDashboard");
        seller.add("sellerManageEventPage");
        seller.add("deliveredList");
        seller.add("orderList");
        seller.add("addEventPage");
        seller.add("addEventProductPage");
        seller.add("ViewOrderServlet");
        seller.add("addEventAction");
        seller.add("viewSellerEventProduct");
        seller.add("updateEventProduct");
        seller.add("eventCategory");
        seller.add("addEventProductAction");
        //Delivery
        delivery = new ArrayList<>();
        delivery.add("deliveryIncome");
        delivery.add("delivererOrders");
        delivery.add("delivererGetOrder");
        delivery.add("viewOrdersForDelivery");
        delivery.add("markAsDone");
        delivery.add("deliveryBoard");
        delivery.add("delivererOrdersPage");
        delivery.add("viewOrdersForDeliveryPage");
        delivery.add("deliveryInformationPage");
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String url;
        try {
            //get site map
            ServletContext context = request.getServletContext();
            Properties siteMap
                    = (Properties) context.getAttribute("SITE_MAP");
            //get resource name
//            int lastIndex = uri.lastIndexOf("/");
            String resource = uri.replace("/FloraRewind/", "");
            //get site mapping
            url = siteMap.getProperty(resource);
            HttpSession session = req.getSession(false);
            AccountDTO user = (session != null) ? (AccountDTO) session.getAttribute("USER") : null;
            String role = (user != null) ? user.getRole() : null;
            if (url != null) {
                if (role != null) {
                    if (admin.contains(resource) && !"Admin".equals(role)) {
                        res.sendRedirect("error404");
                    } else if (seller.contains(resource) && !"Seller".equals(role)) {
                        res.sendRedirect("error404");
                    } else if (delivery.contains(resource) && !"Delivery".equals(role)) {
                        res.sendRedirect("error404");
                    } else {
                        RequestDispatcher rd = req.getRequestDispatcher("/" + url);
                        rd.forward(request, response);
                    }
                } else if (!admin.contains(resource) && !seller.contains(resource) && !delivery.contains(resource)) {
                    RequestDispatcher rd = req.getRequestDispatcher("/" + url);
                    rd.forward(request, response);
                } else {
                    res.sendRedirect("error404");
                }
            } else {
                chain.doFilter(request, response);
            }
        } catch (IOException | ServletException t) {
            log(t.getMessage());
        }
    }

    /**
     * Return the filter configuration object for this filter.
     *
     * @return
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (DEBUG) {
                log("DispatcherFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("DispatcherFilter()");
        }
        StringBuffer sb = new StringBuffer("DispatcherFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    /**
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (IOException ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
