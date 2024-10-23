package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Delivery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_pattern_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatNumber_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
    _jspx_tagPool_fmt_formatNumber_value_pattern_nobody.release();
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
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css/admincss.css\"> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/_all-skins.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"icon\" href=\"img/flora-favicon.png\"/>\r\n");
      out.write("        <title>Delivery</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <section class=\"admin\">\r\n");
      out.write("            <div class=\"row-grid\">\r\n");
      out.write("                <div class=\"admin-sidebar\">\r\n");
      out.write("                    <div class=\"admin-sidebar-top\">\r\n");
      out.write("                        <img src=\"data:image/png;base64,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\" alt=\"\"> \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"admin-sidebar-content\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"\" style=\"color: white\"><i class=\"ri-file-list-line\"></i>Danh sách đơn hàng<i class=\"ri-add-circle-line\"></i></a>\r\n");
      out.write("                                <ul class=\"sub-menu\">\r\n");
      out.write("                                    <li><a class=\"ri-arrow-right-s-fill\" style=\"color: white\"\r\n");
      out.write("                                           href=\"delivererOrders\">Nhận đơn hàng mới</a></li>\r\n");
      out.write("                                    <li><a class=\"ri-arrow-right-s-fill\" style=\"color: white\"\r\n");
      out.write("                                           href=\"viewOrdersForDelivery\">Đơn hàng cần giao</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"admin-content\">\r\n");
      out.write("                    <div class=\"admin-content-top\">\r\n");
      out.write("                        <div class=\"admin-content-top-left\">\r\n");
      out.write("                            <ul class=\"flex-box\">\r\n");
      out.write("                            </ul>          \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"admin-content-top-right\">\r\n");
      out.write("                            <ul class=\"flex-box\">\r\n");
      out.write("                                <i>Số dư tài khoản: ");
      if (_jspx_meth_fmt_formatNumber_0(_jspx_page_context))
        return;
      out.write("</i>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"flex-box\">\r\n");
      out.write("                                    <img style=\"width: 50px;\" src=\"data:image/jpeg;base64,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\" alt=\"\">\r\n");
      out.write("                                    <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<i></i></p>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div> \r\n");
      out.write("                    <div class=\"admin-content-main\">\r\n");
      out.write("                        <div class=\"admin-content-main-title\">\r\n");
      out.write("                            <h1>Danh sách đơn hàng đã nhận:</h1>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"admin-content-main-content\">\r\n");
      out.write("                            <!-- Nội dung ở đây -->\r\n");
      out.write("                            <div class=\"admin-content-main-content-product-list\">\r\n");
      out.write("                                ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                ");
      if (_jspx_meth_c_if_35(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div> \r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/javascript.js\"></script>\r\n");
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

  private boolean _jspx_meth_fmt_formatNumber_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent(null);
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.Staff_Balance}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatNumber_0.setPattern("#,###");
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_pattern_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_pattern_nobody.reuse(_jspx_th_fmt_formatNumber_0);
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.Total_Order != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <i class=\"ri-notification-4-line\" number=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.Total_Order}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"></i>\r\n");
        out.write("                                    ");
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.Total_Order == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <i class=\"ri-notification-4-line\" number=\"0\"></i>\r\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("event");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.DELIVERY_LIST}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty event}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <table >\r\n");
        out.write("                                        <thead>\r\n");
        out.write("                                        <th>No</th>\r\n");
        out.write("                                        <th>Tên người mua</th>\r\n");
        out.write("                                        <th>Điện thoại</th>\r\n");
        out.write("                                        <th>Địa chỉ</th> \r\n");
        out.write("                                        <th>Ghi chú</th>\r\n");
        out.write("                                        <th>Chi tiết</th>\r\n");
        out.write("                                        <th>Trạng thái</th>\r\n");
        out.write("                                        <th>Tùy chỉnh</th>\r\n");
        out.write("                                        </thead>\r\n");
        out.write("                                        <tbody style=\"height: 100px;\">\r\n");
        out.write("                                            ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                        </tbody>\r\n");
        out.write("                                    </table>\r\n");
        out.write("                                    <div class=\"col-12\" >\r\n");
        out.write("                                        <div class=\"pagination d-flex justify-content-center mt-5\">\r\n");
        out.write("                                            ");
        if (_jspx_meth_c_if_14((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                            ");
        if (_jspx_meth_c_if_15((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                            <form id=\"paginationForm\" action=\"delivererOrders\" method=\"POST\">\r\n");
        out.write("                                                <input type=\"hidden\" id=\"pageNo\" name=\"pageNo\">\r\n");
        out.write("                                                ");
        if (_jspx_meth_c_if_16((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                ");
        if (_jspx_meth_c_if_19((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                            </form>\r\n");
        out.write("                                            ");
        if (_jspx_meth_c_if_33((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                            ");
        if (_jspx_meth_c_if_34((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("  \r\n");
        out.write("                                        </div>\r\n");
        out.write("                                    </div>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_forEach_0.setVar("eventOrder");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.DELIVERY_LIST}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("counter");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                <tr>\r\n");
          out.write("                                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.fullname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.street}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.city}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                    <td>\r\n");
          out.write("                                                        <a href=\"javascript:void(0);\" class=\"btn btn-primary\" style=\"color: black\"\r\n");
          out.write("                                                           onclick=\"toggleDetails(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(");\">Xem</a>\r\n");
          out.write("                                                    </td>\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write(" \r\n");
          out.write("                                                </tr>\r\n");
          out.write("                                                <tr id=\"details-");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"display:none;\">\r\n");
          out.write("                                                    <td colspan=\"8\">\r\n");
          out.write("                                                        <div>\r\n");
          out.write("                                                            <table>\r\n");
          out.write("                                                                <thead>\r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">No</th>\r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">Tên mặt hàng</th>\r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">Ngày đặt</th>\r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">Phân loại</th>\r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">Tình trạng</th>\r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">Hình thức thanh toán</th>\r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">Số lượng</th>        \r\n");
          out.write("                                                                <th style=\"background-color: #007bff; color: black\">Đơn giá</th>\r\n");
          out.write("                                                                </thead>\r\n");
          out.write("                                                                <tbody style=\"height: 100px;\">\r\n");
          out.write("                                                                    ");
          if (_jspx_meth_c_set_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                                    ");
          if (_jspx_meth_c_if_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write(" \r\n");
          out.write("                                                                    ");
          if (_jspx_meth_c_forEach_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                                </tbody>\r\n");
          out.write("                                                                ");
          if (_jspx_meth_c_if_13((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                            </table>\r\n");
          out.write("                                                            <script>\r\n");
          out.write("                                                                function toggleDetails(index) {\r\n");
          out.write("                                                                    var detailsRow = document.getElementById(\"details-\" + index);\r\n");
          out.write("                                                                    if (detailsRow.style.display === \"none\") {\r\n");
          out.write("                                                                        detailsRow.style.display = \"table-row\"; // Show the details row\r\n");
          out.write("                                                                    } else {\r\n");
          out.write("                                                                        detailsRow.style.display = \"none\"; // Hide the details row\r\n");
          out.write("                                                                    }\r\n");
          out.write("                                                                }\r\n");
          out.write("                                                            </script>\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                    </td>\r\n");
          out.write("                                                </tr>\r\n");
          out.write("                                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.note != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td style=\"color: #9f191f\">\r\n");
        out.write("                                                            ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.note}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                                        </td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.note == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td>\r\n");
        out.write("                                                            -\r\n");
        out.write("                                                        </td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.status == 'Chờ giao'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td style=\"color: orangered\">\r\n");
        out.write("                                                            Chờ giao\r\n");
        out.write("                                                        </td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.status == 'Đã giao'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td style=\"color: green\">\r\n");
        out.write("                                                            Đã giao\r\n");
        out.write("                                                        </td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.status == 'Chờ giao'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td>\r\n");
        out.write("                                                            <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" \r\n");
        out.write("                                                                    data-target=\"#exampleModal");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" style=\"background-color: green\">\r\n");
        out.write("                                                                Xác nhận\r\n");
        out.write("                                                            </button>\r\n");
        out.write("                                                            <div class=\"modal fade\" id=\"exampleModal");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" tabindex=\"-1\" role=\"dialog\" \r\n");
        out.write("                                                                 aria-labelledby=\"exampleModalLabel");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" aria-hidden=\"true\">\r\n");
        out.write("                                                                <div class=\"modal-dialog\" role=\"document\">\r\n");
        out.write("                                                                    <div class=\"modal-content\">\r\n");
        out.write("                                                                        <div class=\"modal-header\">\r\n");
        out.write("                                                                            <h5 class=\"modal-title\" id=\"exampleModalLabel");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Xác nhận đã giao đơn hàng</h5>\r\n");
        out.write("                                                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
        out.write("                                                                                <span aria-hidden=\"true\">&times;</span>\r\n");
        out.write("                                                                            </button>\r\n");
        out.write("                                                                        </div>\r\n");
        out.write("                                                                        <div class=\"modal-body\">\r\n");
        out.write("                                                                            Bạn xác nhận đã giao đơn hàng này?\r\n");
        out.write("                                                                        </div>\r\n");
        out.write("                                                                        <div class=\"modal-footer\">\r\n");
        out.write("                                                                            <form id=\"getOrder");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" action=\"markAsDone\" method=\"POST\">\r\n");
        out.write("                                                                                <input type=\"hidden\" id=\"getEventOrderID\" name=\"getEventOrderID\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.eventOrderId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"/>\r\n");
        out.write("                                                                                <input type=\"hidden\" id=\"getEventOrderAmount\" name=\"getEventOrderAmount\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.amount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"/>\r\n");
        out.write("                                                                                <input type=\"hidden\" id=\"infoBack\" name=\"infoBack\" value=\"1\"/>\r\n");
        out.write("                                                                                <a href=\"#\" class=\"btn btn-secondary\" style=\"background-color: green;\"\r\n");
        out.write("                                                                                   onclick=\"document.getElementById('getEventOrderID');\r\n");
        out.write("                                                                                           document.getElementById('getEventOrderAmount');\r\n");
        out.write("                                                                                           document.getElementById('infoBack');\r\n");
        out.write("                                                                                           document.getElementById('getOrder");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("').submit();\">\r\n");
        out.write("                                                                                    Có\r\n");
        out.write("                                                                                </a>\r\n");
        out.write("                                                                            </form>\r\n");
        out.write("                                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Không</button>          \r\n");
        out.write("                                                                        </div>\r\n");
        out.write("                                                                    </div>\r\n");
        out.write("                                                                </div>\r\n");
        out.write("                                                            </div>\r\n");
        out.write("                                                        </td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
    return false;
  }

  private boolean _jspx_meth_c_if_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.status == 'Đã giao'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td></td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
    return false;
  }

  private boolean _jspx_meth_c_set_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_1.setVar("deliveryList");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.DELIVERY_INFO_LIST}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_if_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_9.setPageContext(_jspx_page_context);
    _jspx_th_c_if_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty deliveryList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_9 = _jspx_th_c_if_9.doStartTag();
    if (_jspx_eval_c_if_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_set_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_9, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_9, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        out.write("                                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
    return false;
  }

  private boolean _jspx_meth_c_set_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_set_2.setVar("customCounter");
    _jspx_th_c_set_2.setValue(new String("1"));
    _jspx_th_c_set_2.setScope("page");
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_forEach_1.setVar("eventInfo");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.DELIVERY_INFO_LIST}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVarStatus("counter2");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                                            ");
          if (_jspx_meth_c_if_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("                                                                            ");
          if (_jspx_meth_c_if_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("                                                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_10.setPageContext(_jspx_page_context);
    _jspx_th_c_if_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.eventOrderId == eventInfo.eventOrderId}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_10 = _jspx_th_c_if_10.doStartTag();
    if (_jspx_eval_c_if_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                                <tr>\r\n");
        out.write("                                                                                    <td style=\"font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customCounter}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td>\r\n");
        out.write("                                                                                    <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventInfo.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td>\r\n");
        out.write("                                                                                    <td>");
        if (_jspx_meth_fmt_formatDate_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("</td>\r\n");
        out.write("                                                                                    <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventInfo.productType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td>\r\n");
        out.write("                                                                                    <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventInfo.productCondition}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td>\r\n");
        out.write("                                                                                    <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventInfo.paymentOptions}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td>\r\n");
        out.write("                                                                                    <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventInfo.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td> \r\n");
        out.write("                                                                                    <td>");
        if (_jspx_meth_fmt_formatNumber_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("</td>\r\n");
        out.write("                                                                                </tr>\r\n");
        out.write("                                                                                ");
        if (_jspx_meth_c_set_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("                                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventInfo.orderDate}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_0.setPattern("dd-MM-yyy");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_fmt_formatNumber_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventInfo.unitPrice}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatNumber_1.setPattern("#,###");
    int _jspx_eval_fmt_formatNumber_1 = _jspx_th_fmt_formatNumber_1.doStartTag();
    if (_jspx_th_fmt_formatNumber_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_pattern_nobody.reuse(_jspx_th_fmt_formatNumber_1);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_pattern_nobody.reuse(_jspx_th_fmt_formatNumber_1);
    return false;
  }

  private boolean _jspx_meth_c_set_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_set_3.setVar("customCounter");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customCounter + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_if_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_11.setPageContext(_jspx_page_context);
    _jspx_th_c_if_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventOrder.eventOrderId != eventInfo.eventOrderId}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_11 = _jspx_th_c_if_11.doStartTag();
    if (_jspx_eval_c_if_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                                ");
        if (_jspx_meth_c_set_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_11, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("                                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
    return false;
  }

  private boolean _jspx_meth_c_set_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_4.setPageContext(_jspx_page_context);
    _jspx_th_c_set_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_11);
    _jspx_th_c_set_4.setVar("customCounter");
    _jspx_th_c_set_4.setValue(new String("1"));
    int _jspx_eval_c_set_4 = _jspx_th_c_set_4.doStartTag();
    if (_jspx_th_c_set_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_2.setVar("total");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.TOTAL}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVarStatus("counter3");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                                        ");
          if (_jspx_meth_c_if_12((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("                                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_12 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_12.setPageContext(_jspx_page_context);
    _jspx_th_c_if_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventList.eventId == total.eventId}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_12 = _jspx_th_c_if_12.doStartTag();
    if (_jspx_eval_c_if_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                            <tr>\r\n");
        out.write("                                                                                <td colspan=\"5\"></td>\r\n");
        out.write("                                                                                <td style=\"font-weight: 700;\">Tổng giá:</td>\r\n");
        out.write("                                                                                <td style=\"font-weight: 700;\" >");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total.total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td> \r\n");
        out.write("                                                                            </tr>\r\n");
        out.write("                                                                        ");
        int evalDoAfterBody = _jspx_th_c_if_12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_12);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_12);
    return false;
  }

  private boolean _jspx_meth_c_if_13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_13 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_13.setPageContext(_jspx_page_context);
    _jspx_th_c_if_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_13.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty deliveryList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_13 = _jspx_th_c_if_13.doStartTag();
    if (_jspx_eval_c_if_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                    <a>Danh sách rỗng!</a>\r\n");
        out.write("                                                                ");
        int evalDoAfterBody = _jspx_th_c_if_13.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_13);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_13);
    return false;
  }

  private boolean _jspx_meth_c_if_14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_14 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_14.setPageContext(_jspx_page_context);
    _jspx_th_c_if_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_14.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_14 = _jspx_th_c_if_14.doStartTag();
    if (_jspx_eval_c_if_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; \r\n");
        out.write("                                                   background-color: gray; color: white; pointer-events: none; opacity: 0.6;\r\n");
        out.write("                                                   border-color: black; font-weight: bold\">\r\n");
        out.write("                                                    &laquo;\r\n");
        out.write("                                                </a>\r\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_14.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_14);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_14);
    return false;
  }

  private boolean _jspx_meth_c_if_15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_15 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_15.setPageContext(_jspx_page_context);
    _jspx_th_c_if_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_15.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_15 = _jspx_th_c_if_15.doStartTag();
    if (_jspx_eval_c_if_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <form id=\"backForm\" action=\"delivererOrders\" method=\"POST\">\r\n");
        out.write("                                                    <input type=\"hidden\" id=\"pageBack\" name=\"pageBack\"/>\r\n");
        out.write("                                                    <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; background-color: white; border-color: black; color: black; font-weight: bold\"\r\n");
        out.write("                                                       onclick=\"document.getElementById('pageBack').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                               document.getElementById('backForm').submit();\">\r\n");
        out.write("                                                        &laquo;\r\n");
        out.write("                                                    </a>\r\n");
        out.write("                                                </form>\r\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_15.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_15);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_15);
    return false;
  }

  private boolean _jspx_meth_c_if_16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_16 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_16.setPageContext(_jspx_page_context);
    _jspx_th_c_if_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_16.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.pageSize <= 5}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_16 = _jspx_th_c_if_16.doStartTag();
    if (_jspx_eval_c_if_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                    ");
        if (_jspx_meth_c_forEach_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_16, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_16.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_16);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_16);
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_16);
    _jspx_th_c_forEach_3.setVar("i");
    _jspx_th_c_forEach_3.setBegin(1);
    _jspx_th_c_forEach_3.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.pageSize}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                        ");
          if (_jspx_meth_c_if_17((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("                                                        ");
          if (_jspx_meth_c_if_18((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_17 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_17.setPageContext(_jspx_page_context);
    _jspx_th_c_if_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_17.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_17 = _jspx_th_c_if_17.doStartTag();
    if (_jspx_eval_c_if_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                            <a href=\"#\" class=\"active btn btn-secondary\" \r\n");
        out.write("                                                               onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                       document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                       return false;\" style=\"margin: 0; background-color: #000066; border-color: black; color: white;\r\n");
        out.write("                                                               font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                        ");
        int evalDoAfterBody = _jspx_th_c_if_17.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_17);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_17);
    return false;
  }

  private boolean _jspx_meth_c_if_18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_18 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_18.setPageContext(_jspx_page_context);
    _jspx_th_c_if_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_18.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_18 = _jspx_th_c_if_18.doStartTag();
    if (_jspx_eval_c_if_18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                            <a href=\"#\" class=\"btn btn-secondary\" \r\n");
        out.write("                                                               onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                       document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                       return false;\" style=\"margin: 0; background-color: white; border-color: black; color: black; \r\n");
        out.write("                                                               font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                        ");
        int evalDoAfterBody = _jspx_th_c_if_18.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_18);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_18);
    return false;
  }

  private boolean _jspx_meth_c_if_19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_19 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_19.setPageContext(_jspx_page_context);
    _jspx_th_c_if_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_19.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.pageSize >= 5}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_19 = _jspx_th_c_if_19.doStartTag();
    if (_jspx_eval_c_if_19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                    ");
        if (_jspx_meth_c_if_20((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_19, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                    ");
        if (_jspx_meth_c_if_23((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_19, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                    ");
        if (_jspx_meth_c_if_28((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_19, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_19.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_19);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_19);
    return false;
  }

  private boolean _jspx_meth_c_if_20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_19, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_20 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_20.setPageContext(_jspx_page_context);
    _jspx_th_c_if_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_19);
    _jspx_th_c_if_20.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == 1 || sessionScope.currentPage == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_20 = _jspx_th_c_if_20.doStartTag();
    if (_jspx_eval_c_if_20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        ");
        if (_jspx_meth_c_forEach_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_20, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                        <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; border-color: black; font-weight: bold;\r\n");
        out.write("                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;\">\r\n");
        out.write("                                                            ...\r\n");
        out.write("                                                        </a>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_20.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_20);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_20);
    return false;
  }

  private boolean _jspx_meth_c_forEach_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_20, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_4.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_20);
    _jspx_th_c_forEach_4.setVar("i");
    _jspx_th_c_forEach_4.setBegin(1);
    _jspx_th_c_forEach_4.setEnd(5);
    int[] _jspx_push_body_count_c_forEach_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_4 = _jspx_th_c_forEach_4.doStartTag();
      if (_jspx_eval_c_forEach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_21((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_4, _jspx_page_context, _jspx_push_body_count_c_forEach_4))
            return true;
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_22((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_4, _jspx_page_context, _jspx_push_body_count_c_forEach_4))
            return true;
          out.write("\r\n");
          out.write("                                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_4.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_4);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_21 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_21.setPageContext(_jspx_page_context);
    _jspx_th_c_if_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_4);
    _jspx_th_c_if_21.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_21 = _jspx_th_c_if_21.doStartTag();
    if (_jspx_eval_c_if_21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"active btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: #000066; border-color: black; color: white;\r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_21.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_21);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_21);
    return false;
  }

  private boolean _jspx_meth_c_if_22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_22 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_22.setPageContext(_jspx_page_context);
    _jspx_th_c_if_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_4);
    _jspx_th_c_if_22.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_22 = _jspx_th_c_if_22.doStartTag();
    if (_jspx_eval_c_if_22 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: white; border-color: black; color: black; \r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_22.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_22);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_22);
    return false;
  }

  private boolean _jspx_meth_c_if_23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_19, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_23 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_23.setPageContext(_jspx_page_context);
    _jspx_th_c_if_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_19);
    _jspx_th_c_if_23.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != 1 && sessionScope.currentPage != 2 &&\r\n                                                                  sessionScope.currentPage != (sessionScope.pageSize - 2) &&\r\n                                                                  sessionScope.currentPage != (sessionScope.pageSize - 1) &&\r\n                                                                  sessionScope.currentPage != sessionScope.pageSize}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_23 = _jspx_th_c_if_23.doStartTag();
    if (_jspx_eval_c_if_23 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        ");
        if (_jspx_meth_c_forEach_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_23, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                        <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; border-color: black; font-weight: bold;\r\n");
        out.write("                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;\">\r\n");
        out.write("                                                            ...\r\n");
        out.write("                                                        </a>\r\n");
        out.write("                                                        ");
        if (_jspx_meth_c_forEach_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_23, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                        <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; border-color: black; font-weight: bold;\r\n");
        out.write("                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;\">\r\n");
        out.write("                                                            ...\r\n");
        out.write("                                                        </a>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_23.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_23);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_23);
    return false;
  }

  private boolean _jspx_meth_c_forEach_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_23, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_5.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_23);
    _jspx_th_c_forEach_5.setVar("i");
    _jspx_th_c_forEach_5.setBegin(1);
    _jspx_th_c_forEach_5.setEnd(2);
    int[] _jspx_push_body_count_c_forEach_5 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_5 = _jspx_th_c_forEach_5.doStartTag();
      if (_jspx_eval_c_forEach_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_24((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_5, _jspx_page_context, _jspx_push_body_count_c_forEach_5))
            return true;
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_25((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_5, _jspx_page_context, _jspx_push_body_count_c_forEach_5))
            return true;
          out.write("\r\n");
          out.write("                                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_5.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_5);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_24(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_24 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_24.setPageContext(_jspx_page_context);
    _jspx_th_c_if_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_5);
    _jspx_th_c_if_24.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_24 = _jspx_th_c_if_24.doStartTag();
    if (_jspx_eval_c_if_24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"active btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: #000066; border-color: black; color: white;\r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_24.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_24);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_24);
    return false;
  }

  private boolean _jspx_meth_c_if_25(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_25 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_25.setPageContext(_jspx_page_context);
    _jspx_th_c_if_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_5);
    _jspx_th_c_if_25.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_25 = _jspx_th_c_if_25.doStartTag();
    if (_jspx_eval_c_if_25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: white; border-color: black; color: black; \r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_25.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_25);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_25);
    return false;
  }

  private boolean _jspx_meth_c_forEach_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_23, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_6 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_6.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_23);
    _jspx_th_c_forEach_6.setVar("i");
    _jspx_th_c_forEach_6.setBegin(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_6.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(sessionScope.currentPage + 2)}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    int[] _jspx_push_body_count_c_forEach_6 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_6 = _jspx_th_c_forEach_6.doStartTag();
      if (_jspx_eval_c_forEach_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_26((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_6, _jspx_page_context, _jspx_push_body_count_c_forEach_6))
            return true;
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_27((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_6, _jspx_page_context, _jspx_push_body_count_c_forEach_6))
            return true;
          out.write("\r\n");
          out.write("                                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_6.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_6);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_26(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_26 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_26.setPageContext(_jspx_page_context);
    _jspx_th_c_if_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_6);
    _jspx_th_c_if_26.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_26 = _jspx_th_c_if_26.doStartTag();
    if (_jspx_eval_c_if_26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"active btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: #000066; border-color: black; color: white;\r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_26.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_26);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_26);
    return false;
  }

  private boolean _jspx_meth_c_if_27(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_27 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_27.setPageContext(_jspx_page_context);
    _jspx_th_c_if_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_6);
    _jspx_th_c_if_27.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_27 = _jspx_th_c_if_27.doStartTag();
    if (_jspx_eval_c_if_27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: white; border-color: black; color: black; \r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_27.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_27);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_27);
    return false;
  }

  private boolean _jspx_meth_c_if_28(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_19, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_28 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_28.setPageContext(_jspx_page_context);
    _jspx_th_c_if_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_19);
    _jspx_th_c_if_28.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == (sessionScope.pageSize - 2) ||\r\n                                                                  sessionScope.currentPage == (sessionScope.pageSize - 1) ||\r\n                                                                  sessionScope.currentPage == sessionScope.pageSize}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_28 = _jspx_th_c_if_28.doStartTag();
    if (_jspx_eval_c_if_28 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        ");
        if (_jspx_meth_c_forEach_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_28, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                        <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; border-color: black; font-weight: bold;\r\n");
        out.write("                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;\">\r\n");
        out.write("                                                            ...\r\n");
        out.write("                                                        </a>\r\n");
        out.write("                                                        ");
        if (_jspx_meth_c_forEach_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_28, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_28.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_28);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_28);
    return false;
  }

  private boolean _jspx_meth_c_forEach_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_28, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_7 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_7.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_28);
    _jspx_th_c_forEach_7.setVar("i");
    _jspx_th_c_forEach_7.setBegin(1);
    _jspx_th_c_forEach_7.setEnd(2);
    int[] _jspx_push_body_count_c_forEach_7 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_7 = _jspx_th_c_forEach_7.doStartTag();
      if (_jspx_eval_c_forEach_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_29((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_7, _jspx_page_context, _jspx_push_body_count_c_forEach_7))
            return true;
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_30((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_7, _jspx_page_context, _jspx_push_body_count_c_forEach_7))
            return true;
          out.write("\r\n");
          out.write("                                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_7.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_7[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_7.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_7.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_7);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_29(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_29 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_29.setPageContext(_jspx_page_context);
    _jspx_th_c_if_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_7);
    _jspx_th_c_if_29.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_29 = _jspx_th_c_if_29.doStartTag();
    if (_jspx_eval_c_if_29 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"active btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: #000066; border-color: black; color: white;\r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_29.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_29);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_29);
    return false;
  }

  private boolean _jspx_meth_c_if_30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_30 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_30.setPageContext(_jspx_page_context);
    _jspx_th_c_if_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_7);
    _jspx_th_c_if_30.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_30 = _jspx_th_c_if_30.doStartTag();
    if (_jspx_eval_c_if_30 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: white; border-color: black; color: black; \r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_30.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_30);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_30);
    return false;
  }

  private boolean _jspx_meth_c_forEach_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_28, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_8 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_8.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_28);
    _jspx_th_c_forEach_8.setVar("i");
    _jspx_th_c_forEach_8.setBegin(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(sessionScope.pageSize - 2)}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_8.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.pageSize}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    int[] _jspx_push_body_count_c_forEach_8 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_8 = _jspx_th_c_forEach_8.doStartTag();
      if (_jspx_eval_c_forEach_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_31((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_8, _jspx_page_context, _jspx_push_body_count_c_forEach_8))
            return true;
          out.write("\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_if_32((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_8, _jspx_page_context, _jspx_push_body_count_c_forEach_8))
            return true;
          out.write("\r\n");
          out.write("                                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_8.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_8[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_8.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_8.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_8);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_8)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_31 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_31.setPageContext(_jspx_page_context);
    _jspx_th_c_if_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_8);
    _jspx_th_c_if_31.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_31 = _jspx_th_c_if_31.doStartTag();
    if (_jspx_eval_c_if_31 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"active btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: #000066; border-color: black; color: white;\r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_31.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_31);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_31);
    return false;
  }

  private boolean _jspx_meth_c_if_32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_8)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_32 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_32.setPageContext(_jspx_page_context);
    _jspx_th_c_if_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_8);
    _jspx_th_c_if_32.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_32 = _jspx_th_c_if_32.doStartTag();
    if (_jspx_eval_c_if_32 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                <a href=\"#\" class=\"btn btn-secondary\" \r\n");
        out.write("                                                                   onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                           document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                           return false;\" style=\"margin: 0; background-color: white; border-color: black; color: black; \r\n");
        out.write("                                                                   font-weight: bold\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_if_32.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_32);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_32);
    return false;
  }

  private boolean _jspx_meth_c_if_33(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_33 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_33.setPageContext(_jspx_page_context);
    _jspx_th_c_if_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_33.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != sessionScope.pageSize}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_33 = _jspx_th_c_if_33.doStartTag();
    if (_jspx_eval_c_if_33 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <form id=\"forwardForm\" action=\"delivererOrders\" method=\"POST\">\r\n");
        out.write("                                                    <input type=\"hidden\" id=\"pageForward\" name=\"pageForward\"/>\r\n");
        out.write("                                                    <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; background-color: white; border-color: black; color: black; font-weight: bold\"\r\n");
        out.write("                                                       onclick=\"document.getElementById('pageForward').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                               document.getElementById('forwardForm').submit();\">\r\n");
        out.write("                                                        &raquo;\r\n");
        out.write("                                                    </a>\r\n");
        out.write("                                                </form>\r\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_33.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_33);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_33);
    return false;
  }

  private boolean _jspx_meth_c_if_34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_34 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_34.setPageContext(_jspx_page_context);
    _jspx_th_c_if_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_34.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == sessionScope.pageSize}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_34 = _jspx_th_c_if_34.doStartTag();
    if (_jspx_eval_c_if_34 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <a href=\"#\" class=\"btn btn-secondary\" style=\"margin: 1; border-color: black; font-weight: bold;\r\n");
        out.write("                                                   background-color: gray; color: white; pointer-events: none; opacity: 0.6;\">\r\n");
        out.write("                                                    &raquo;\r\n");
        out.write("                                                </a>\r\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_34.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_34);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_34);
    return false;
  }

  private boolean _jspx_meth_c_if_35(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_35 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_35.setPageContext(_jspx_page_context);
    _jspx_th_c_if_35.setParent(null);
    _jspx_th_c_if_35.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty event}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_35 = _jspx_th_c_if_35.doStartTag();
    if (_jspx_eval_c_if_35 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <a style=\"color: red\">\r\n");
        out.write("                                        &#8194;&#8204;Hiện tại không có đơn hàng nào bạn đã nhận...&#32;\r\n");
        out.write("                                    </a>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_35.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_35);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_35);
    return false;
  }
}
