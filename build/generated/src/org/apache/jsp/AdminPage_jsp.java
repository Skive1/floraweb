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
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link\n");
      out.write("    href=\"https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css\"\n");
      out.write("    rel=\"stylesheet\"\n");
      out.write("/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <title>Admin</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <style>\n");
      out.write("        root {\n");
      out.write("    --main-bg-color: #414e66;\n");
      out.write("    --sub-bg-color: #f2f7fb;\n");
      out.write("    --top-height: 70px;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("* {\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("\n");
      out.write("}\n");
      out.write("a {\n");
      out.write("    text-decoration: none;\n");
      out.write("    color: unset;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".row-grid {\n");
      out.write("    display: grid;\n");
      out.write("    justify-content: space-between;\n");
      out.write("}\n");
      out.write("/* main của admin */\n");
      out.write(".admin .row-grid {\n");
      out.write("    grid-template-columns: 20% 80%;\n");
      out.write("\n");
      out.write("}\n");
      out.write("/* \n");
      out.write("sidebar\n");
      out.write("*/\n");
      out.write(".admin-sidebar-top {\n");
      out.write("    width: 100px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".admin-sidebar {\n");
      out.write("    height:100vh;\n");
      out.write("    background-color: #414e66;\n");
      out.write("}\n");
      out.write(".admin-sidebar-top img {\n");
      out.write("    width: 100px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* content */\n");
      out.write(".admin-content {\n");
      out.write("background-color: #f2f7fb;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("    <section class=\"admin\">\n");
      out.write("        <div class=\"row-grid\">\n");
      out.write("            <div class=\"admin-sidebar\">\n");
      out.write("                <div class=\"admin-sidebar-top\">\n");
      out.write("                    <img src=\"\" alt=\"\"> Avatar\n");
      out.write("    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"admin-sidebar-content\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("                            <i class=\"ri-dashboard-fill\"></i>\n");
      out.write("                            <a href=\"\">Dashboard</a>                   \n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"ri-dashboard-fill\"></i>\n");
      out.write("                                <a href=\"\">Event list</a>                   \n");
      out.write("                            </li>    \n");
      out.write("                        </li>\n");
      out.write("                            <i class=\"ri-dashboard-fill\"></i>\n");
      out.write("                            <a href=\"\">Order list</a>                   \n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"admin-content\">\n");
      out.write("                    Đấy là admin content\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
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
