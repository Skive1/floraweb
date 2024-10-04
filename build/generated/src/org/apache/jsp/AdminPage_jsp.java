package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <link href=\"https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("  <link href=\"css/admincss.css\" rel=\"stylesheet\">\n");
      out.write("  <title>Admin</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <section class=\"admin\">\n");
      out.write("    <div class=\"row-grid\">\n");
      out.write("      <div class=\"admin-sidebar\">\n");
      out.write("        <div class=\"admin-sidebar-top\">\n");
      out.write("          <img src=\"\" alt=\"\"> Avatar\n");
      out.write("        </div>\n");
      out.write("        <div class=\"admin-sidebar-content\">\n");
      out.write("          <ul>\n");
      out.write("            <li>\n");
      out.write("              <a href=\"\"><i class=\"ri-dashboard-fill\"></i>Dashboard<i class=\"ri-add-circle-line\"></i></a>\n");
      out.write("              <ul class=\"sub-menu\">\n");
      out.write("                <li><a class=\"ri-arrow-right-s-fill\" href=\"\">Sản phẩm</a></li>\n");
      out.write("                <li><a class=\"ri-arrow-right-s-fill\" href=\"\">Event</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"\"><i class=\"ri-file-list-line\"></i>Manage<i class=\"ri-add-circle-line\"></i></a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                  <li><a class=\"ri-arrow-right-s-fill\" href=\"\">Account</a></li>\n");
      out.write("                  <li><a class=\"ri-arrow-right-s-fill\" href=\"\">Event</a></li>\n");
      out.write("                </ul>\n");
      out.write("              </li>\n");
      out.write("              <li>\n");
      out.write("                <a href=\"\"><i class=\"ri-file-list-line\"></i>Order<i class=\"ri-add-circle-line\"></i></a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                  <li><a class=\"ri-arrow-right-s-fill\" href=\"\">Danh sách đơn hàng</a></li>\n");
      out.write("                  <li><a class=\"ri-arrow-right-s-fill\" href=\"\">Quản lí đơn hàng</a></li>\n");
      out.write("                </ul>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"admin-content\">\n");
      out.write("        Đấy là admin content\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <script src=\"js/javascript.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
