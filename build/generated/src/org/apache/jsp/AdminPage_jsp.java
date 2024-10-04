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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link\r\n");
      out.write("    href=\"https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css\"\r\n");
      out.write("    rel=\"stylesheet\"\r\n");
      out.write("/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("    <title>Admin</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <style>\r\n");
      out.write("        root {\r\n");
      out.write("    --main-bg-color: #414e66;\r\n");
      out.write("    --sub-bg-color: #f2f7fb;\r\n");
      out.write("    --top-height: 70px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("* {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    color: unset;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".row-grid {\r\n");
      out.write("    display: grid;\r\n");
      out.write("    justify-content: space-between;\r\n");
      out.write("}\r\n");
      out.write("/* main của admin */\r\n");
      out.write(".admin .row-grid {\r\n");
      out.write("    grid-template-columns: 20% 80%;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("/* \r\n");
      out.write("sidebar\r\n");
      out.write("*/\r\n");
      out.write(".admin-sidebar-top {\r\n");
      out.write("    width: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".admin-sidebar {\r\n");
      out.write("    height:100vh;\r\n");
      out.write("    background-color: #414e66;\r\n");
      out.write("}\r\n");
      out.write(".admin-sidebar-top img {\r\n");
      out.write("    width: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* content */\r\n");
      out.write(".admin-content {\r\n");
      out.write("background-color: #f2f7fb;\r\n");
      out.write("}\r\n");
      out.write("    </style>\r\n");
      out.write("    <section class=\"admin\">\r\n");
      out.write("        <div class=\"row-grid\">\r\n");
      out.write("            <div class=\"admin-sidebar\">\r\n");
      out.write("                <div class=\"admin-sidebar-top\">\r\n");
      out.write("                    <img src=\"\" alt=\"\"> Ảnh logo\r\n");
      out.write("    \r\n");
      out.write("                </div> \r\n");
      out.write("                <div class=\"admin-sidebar-content\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <i class=\"ri-dashboard-fill\"></i>\r\n");
      out.write("                            <a href=\"\">Dashboard</a>                   \r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <i class=\"ri-dashboard-fill\"></i>\r\n");
      out.write("                                <a href=\"\">Event list</a>                   \r\n");
      out.write("                            </li>    \r\n");
      out.write("                        <li>\r\n");
      out.write("                            <i class=\"ri-dashboard-fill\"></i>\r\n");
      out.write("                            <a href=\"\">Order list</a>                   \r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"admin-content\">\r\n");
      out.write("                    Đấy là admin content\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("</body>\r\n");
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
