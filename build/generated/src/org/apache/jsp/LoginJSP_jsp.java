package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("        #notification {\r\n");
      out.write("            position: absolute; /* Định vị cố định */\r\n");
      out.write("            top: 38%;\r\n");
      out.write("            left: 50%;\r\n");
      out.write("            transform: translate(-50%, -50%); /* Di chuyển về giữa */\r\n");
      out.write("            background-color: #ffffff;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("            padding-top: 18px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            color: red;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>Sign In | Buy and sell on the website</title>\r\n");
      out.write("        <!-- Style CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/style.css\">\r\n");
      out.write("        <!-- Demo CSS (No need to include it into your project) -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/demo.css\">\r\n");
      out.write("        <!--        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"icon\" href=\"img/flora-favicon.png\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header class=\"cd__intro\">\r\n");
      out.write("            <a href=\"home\">\r\n");
      out.write("                <img src=\"img/floralogo.png\" alt=\"Home Page\" width=\"360px\">\r\n");
      out.write("            </a> \r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <main class=\"cd__main\">\r\n");
      out.write("            <section class=\"py-3 py-md-5 py-xl-8\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row content\">\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <div class=\"mb-5\">\r\n");
      out.write("                                <h2 class=\"display-5 fw-bold text-center\">Sign in</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row justify-content-center\">\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <div class=\"mb-5 text-center\">\r\n");
      out.write("\r\n");
      out.write("                                ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row justify-content-center\">\r\n");
      out.write("                        <div class=\"col-12 col-lg-10 col-xl-8\">\r\n");
      out.write("                            <div class=\"row gy-5 justify-content-center\">\r\n");
      out.write("                                <div class=\"col-12 col-lg-5\">\r\n");
      out.write("                                    <form action=\"loginAction\" method=\"POST\">\r\n");
      out.write("                                        <div class=\"row gy-3 overflow-hidden\">\r\n");
      out.write("                                            <div class=\"col-12\">\r\n");
      out.write("                                                <div class=\"form-floating mb-3\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"txtUsername\" value=\"\" class=\"form-control\" id=\"username\" placeholder=\"Username\" required/>\r\n");
      out.write("                                                    <label for=\"username\" class=\"form-label\">Username</label>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-12\">\r\n");
      out.write("                                                <div class=\"form-floating mb-3\">\r\n");
      out.write("                                                    <input type=\"password\" id=\"myPassword\" name=\"txtPassword\" value=\"\" class=\"form-control\">\r\n");
      out.write("                                                        <i class=\"fa fa-eye\" onclick=\"togglePassword()\"></i>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-12\">\r\n");
      out.write("                                                <div class=\"row justify-content-between\">\r\n");
      out.write("                                                    <div class=\"col-6\">\r\n");
      out.write("                                                        <div class=\"form-check\">\r\n");
      out.write("                                                            <input type=\"checkbox\" name=\"checkbox\" class=\"form-check-input\" id=\"checkbox\">\r\n");
      out.write("                                                            <label class=\"form-check-label\" for=\"checkbox\">Remember Me</label>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <div class=\"col-6\">\r\n");
      out.write("                                                        <div class=\"text-end\">\r\n");
      out.write("                                                            <a href=\"forgotPassword\" class=\"link-secondary text-decoration-none\">Forgot password?</a>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-12\">\r\n");
      out.write("                                                <div class=\"d-grid\">          \r\n");
      out.write("                                                    <input type=\"submit\" class=\"btn btn-class\" value=\"Login\" name=\"btAction\" />\r\n");
      out.write("                                                    <br/>\r\n");
      out.write("                                                    <a class=\"btn btn-class\" href=\"registerPage\">Or Sign Up</a>                                           \r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-12 col-lg-2 d-flex align-items-center justify-content-center gap-3 flex-lg-column\">\r\n");
      out.write("                                    <div class=\"bg-dark h-100 d-none d-lg-block\" style=\"width: 1px; background-color: rgba(0, 0, 0, 0.1);\"></div>\r\n");
      out.write("                                    <div class=\"bg-dark w-100 d-lg-none\" style=\"height: 1px; background-color: rgba(0, 0, 0, 0.1);\"></div>\r\n");
      out.write("                                    <div>or</div>\r\n");
      out.write("                                    <div class=\"bg-dark h-100 d-none d-lg-block\" style=\"width: 1px; background-color: rgba(0, 0, 0, 0.1);\"></div>\r\n");
      out.write("                                    <div class=\"bg-dark w-100 d-lg-none\" style=\"height: 1px; background-color: rgba(0, 0, 0, 0.1);\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-12 col-lg-5 d-flex align-items-center\">\r\n");
      out.write("                                    <div class=\"d-flex gap-3 flex-column w-100 \">\r\n");
      out.write("                                        <a href=\"https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:8084/FloraRewind/loginAction&response_type=code&client_id=979532933754-dkafh4bakdj768m3nldv4fqt97e8acob.apps.googleusercontent.com&approval_prompt=force\" class=\"btn btn-lg btn-danger\">\r\n");
      out.write("                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-google\" viewBox=\"0 0 16 16\">\r\n");
      out.write("                                            <path d=\"M15.545 6.558a9.42 9.42 0 0 1 .139 1.626c0 2.434-.87 4.492-2.384 5.885h.002C11.978 15.292 10.158 16 8 16A8 8 0 1 1 8 0a7.689 7.689 0 0 1 5.352 2.082l-2.284 2.284A4.347 4.347 0 0 0 8 3.166c-2.087 0-3.86 1.408-4.492 3.304a4.792 4.792 0 0 0 0 3.063h.003c.635 1.893 2.405 3.301 4.492 3.301 1.078 0 2.004-.276 2.722-.764h-.003a3.702 3.702 0 0 0 1.599-2.431H8v-3.08h7.545z\" />\r\n");
      out.write("                                            </svg>\r\n");
      out.write("                                            <span class=\"ms-2 fs-6\">Sign in with Google</span>\r\n");
      out.write("                                        </a>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>                 \r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("        </main>\r\n");
      out.write("\r\n");
      out.write("        <!-- Script JS -->\r\n");
      out.write("        <script src=\"js/javascript.js\"></script>\r\n");
      out.write("        <!--$%analytics%$-->\r\n");
      out.write("    </body>\r\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("error");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.LOGIN_ERROR}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty error.loginErr}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("   \r\n");
        out.write("                                    <div id=\"notification\" style=\"background-color: rgb(245, 229, 229)\">\r\n");
        out.write("                                        <p>\r\n");
        out.write("                                            ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error.loginErr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                        </p>\r\n");
        out.write("                                    </div>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
