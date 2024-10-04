package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ShopPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>g PAGE</title>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("        <meta content=\"\" name=\"keywords\">\r\n");
      out.write("        <meta content=\"\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Google Web Fonts -->\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap\" rel=\"stylesheet\"> \r\n");
      out.write("\r\n");
      out.write("        <!-- Icon Font Stylesheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.15.4/css/all.css\"/>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Libraries Stylesheet -->\r\n");
      out.write("        <link href=\"lib/lightbox/css/lightbox.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Template Stylesheet -->\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <!-- Spinner Start -->\r\n");
      out.write("        <div id=\"spinner\" class=\"show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <div class=\"spinner-grow text-primary\" role=\"status\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Spinner End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Navbar start -->\r\n");
      out.write("        <div class=\"container-fluid fixed-top\">\r\n");
      out.write("            <div class=\"container topbar bg-primary d-none d-lg-block\">\r\n");
      out.write("                <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                    <div class=\"top-info ps-2\">\r\n");
      out.write("                        <small class=\"me-3\"><i class=\"fas fa-map-marker-alt me-2 text-secondary\"></i> <a href=\"#\" class=\"text-white\">123 Street, New York</a></small>\r\n");
      out.write("                        <small class=\"me-3\"><i class=\"fas fa-envelope me-2 text-secondary\"></i><a href=\"#\" class=\"text-white\">Email@Example.com</a></small>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"top-link pe-2\">\r\n");
      out.write("                        <a href=\"#\" class=\"text-white\"><small class=\"text-white mx-2\">Privacy Policy</small>/</a>\r\n");
      out.write("                        <a href=\"#\" class=\"text-white\"><small class=\"text-white mx-2\">Terms of Use</small>/</a>\r\n");
      out.write("                        <a href=\"#\" class=\"text-white\"><small class=\"text-white ms-2\">Sales and Refunds</small></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"container px-0\">\r\n");
      out.write("                <nav class=\"navbar navbar-light bg-white navbar-expand-xl\">\r\n");
      out.write("                    <a href=\"HomePageJSP.jsp\" class=\"navbar-brand\"><h1 class=\"text-primary display-6\">Fruitables</h1></a>\r\n");
      out.write("                    <button class=\"navbar-toggler py-2 px-3\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\r\n");
      out.write("                        <span class=\"fa fa-bars text-primary\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <div class=\"collapse navbar-collapse bg-white\" id=\"navbarCollapse\">\r\n");
      out.write("                        <div class=\"navbar-nav mx-auto\">\r\n");
      out.write("                            <a href=\"HomePageJSP.jsp\" class=\"nav-item nav-link\">Home</a>\r\n");
      out.write("                            <form id=\"searchForm\" action=\"SearchServlet\" method=\"POST\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"navbarShop\">\r\n");
      out.write("                                <a href=\"javascript:void(0);\" class=\"nav-item nav-link active\" onclick=\"document.getElementById('searchForm').submit();\">Shop</a>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <a href=\"shop-detail.html\" class=\"nav-item nav-link\">Shop Detail</a>\r\n");
      out.write("                            <div class=\"nav-item dropdown\">\r\n");
      out.write("                                <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">Pages</a>\r\n");
      out.write("                                <div class=\"dropdown-menu m-0 bg-secondary rounded-0\">\r\n");
      out.write("                                    <a href=\"cart.html\" class=\"dropdown-item\">Cart</a>\r\n");
      out.write("                                    <a href=\"chackout.html\" class=\"dropdown-item\">Checkout</a>\r\n");
      out.write("                                    <a href=\"testimonial.html\" class=\"dropdown-item\">Testimonial</a>\r\n");
      out.write("                                    <a href=\"404.html\" class=\"dropdown-item\">404 Page</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <a href=\"contact.html\" class=\"nav-item nav-link\">Contact</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"d-flex m-3 me-0\">\r\n");
      out.write("                            <button class=\"btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4\" data-bs-toggle=\"modal\" data-bs-target=\"#searchModal\"><i class=\"fas fa-search text-primary\"></i></button>\r\n");
      out.write("                            <a href=\"#\" class=\"position-relative me-4 my-auto\">\r\n");
      out.write("                                <i class=\"fa fa-shopping-bag fa-2x\"></i>\r\n");
      out.write("                                <span class=\"position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1\" style=\"top: -5px; left: 15px; height: 20px; min-width: 20px;\">3</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <a href=\"#\" class=\"my-auto\">\r\n");
      out.write("                                <i class=\"fas fa-user fa-2x\"></i>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Navbar End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Modal Search Start -->\r\n");
      out.write("        <form action=\"SearchServlet\" method=\"POST\">\r\n");
      out.write("            <div class=\"modal fade\" id=\"searchModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("                <div class=\"modal-dialog modal-fullscreen\">\r\n");
      out.write("                    <div class=\"modal-content rounded-0\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">Search by keyword</h5>\r\n");
      out.write("                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body d-flex align-items-center\">\r\n");
      out.write("                            <div class=\"input-group w-75 mx-auto d-flex\"> \r\n");
      out.write("                                <input type=\"search\" name=\"txtSearchValue\" value=\"\" \r\n");
      out.write("                                       class=\"form-control p-3\" placeholder=\"keywords\" aria-describedby=\"search-icon-1\">\r\n");
      out.write("                                <span id=\"search-icon-1\" class=\"input-group-text p-3\"><i class=\"fa fa-search\"></i></span>\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <!-- Modal Search End -->\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Single Page Header start -->\r\n");
      out.write("        <div class=\"container-fluid page-header py-5\">\r\n");
      out.write("            <h1 class=\"text-center text-white display-6\">Shop</h1>\r\n");
      out.write("            <ol class=\"breadcrumb justify-content-center mb-0\">\r\n");
      out.write("                <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\r\n");
      out.write("                <li class=\"breadcrumb-item\"><a href=\"#\">Pages</a></li>\r\n");
      out.write("                <li class=\"breadcrumb-item active text-white\">Shop</li>\r\n");
      out.write("            </ol>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Single Page Header End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Fruits Shop Start-->\r\n");
      out.write("        <div class=\"container-fluid fruite py-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <h1 class=\"mb-4\">Flower shop</h1>\r\n");
      out.write("                <div class=\"row g-4\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <div class=\"row g-4\">\r\n");
      out.write("                            <div class=\"col-xl-3\">\r\n");
      out.write("                                <form action=\"SearchServlet\" method=\"POST\">\r\n");
      out.write("                                    <div class=\"input-group w-100 mx-auto d-flex\">\r\n");
      out.write("                                        <input type=\"search\" name=\"txtSearchValue\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.lastSearch}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \r\n");
      out.write("                                               class=\"form-control p-3\" placeholder=\"keywords\" aria-describedby=\"search-icon-1\">\r\n");
      out.write("                                        <span id=\"search-icon-1\" class=\"input-group-text p-3\"><i class=\"fa fa-search\"></i></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-6\"></div>\r\n");
      out.write("                            <div class=\"col-xl-3\">\r\n");
      out.write("                                <div class=\"bg-light ps-3 py-3 rounded d-flex justify-content-between mb-4\">\r\n");
      out.write("                                    <label for=\"fruits\">Default Sorting (later):</label>\r\n");
      out.write("                                    <select id=\"fruits\" name=\"fruitlist\" class=\"border-0 form-select-sm bg-light me-3\" form=\"fruitform\">\r\n");
      out.write("                                        <option value=\"volvo\">Nothing</option>\r\n");
      out.write("                                        <option value=\"saab\">Popularity</option>\r\n");
      out.write("                                        <option value=\"opel\">Organic</option>\r\n");
      out.write("                                        <option value=\"audi\">Fantastic</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row g-4\">\r\n");
      out.write("                            <div class=\"col-lg-3\">\r\n");
      out.write("                                <div class=\"row g-4\">\r\n");
      out.write("                                    <div class=\"col-lg-12\">\r\n");
      out.write("                                        <div class=\"mb-3\">\r\n");
      out.write("                                            <h4>Categories</h4>\r\n");
      out.write("                                            <ul class=\"list-unstyled fruite-categorie\">\r\n");
      out.write("                                                <form id=\"categoriesForm\" action=\"SearchForTypeServlet\" method=\"POST\">\r\n");
      out.write("                                                    <li>\r\n");
      out.write("                                                        <div class=\"d-flex justify-content-between fruite-name\">\r\n");
      out.write("                                                            <input type=\"hidden\" id=\"categories\" name=\"categories\"/>\r\n");
      out.write("                                                            <a href=\"#\" onclick=\"document.getElementById('categories').value = 'Fresh Flower';\r\n");
      out.write("                                                                    document.getElementById('categoriesForm').submit();\"><i class=\"fas fa-apple-alt me-2\"></i>\r\n");
      out.write("                                                                Fresh Flower\r\n");
      out.write("                                                            </a>\r\n");
      out.write("                                                            <span>(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.freshFlower}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</span>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </li>\r\n");
      out.write("                                                    <li>\r\n");
      out.write("                                                        <div class=\"d-flex justify-content-between fruite-name\">\r\n");
      out.write("                                                            <input type=\"hidden\" id=\"categories\" name=\"categories\"/>\r\n");
      out.write("                                                            <a href=\"#\" onclick=\"document.getElementById('categories').value = 'Potted Plant';\r\n");
      out.write("                                                                    document.getElementById('categoriesForm').submit();\"><i class=\"fas fa-apple-alt me-2\"></i>\r\n");
      out.write("                                                                Potted Plant\r\n");
      out.write("                                                            </a>\r\n");
      out.write("                                                            <span>(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.pottedFlower}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</span>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </li>\r\n");
      out.write("                                                    <li>\r\n");
      out.write("                                                        <div class=\"d-flex justify-content-between fruite-name\">\r\n");
      out.write("                                                            <input type=\"hidden\" id=\"categories\" name=\"categories\"/>\r\n");
      out.write("                                                            <a href=\"#\" onclick=\"document.getElementById('categories').value = 'Dried Flower';\r\n");
      out.write("                                                                    document.getElementById('categoriesForm').submit();\"><i class=\"fas fa-apple-alt me-2\"></i>\r\n");
      out.write("                                                                Dried Flower\r\n");
      out.write("                                                            </a>\r\n");
      out.write("                                                            <span>(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.dryFlower}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</span>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </li>\r\n");
      out.write("                                                    <li>\r\n");
      out.write("                                                        <div class=\"d-flex justify-content-between fruite-name\">\r\n");
      out.write("                                                            <input type=\"hidden\" id=\"categories\" name=\"categories\"/>\r\n");
      out.write("                                                            <a href=\"#\" onclick=\"document.getElementById('categories').value = 'Other Flower';\r\n");
      out.write("                                                                    document.getElementById('categoriesForm').submit();\"><i class=\"fas fa-apple-alt me-2\"></i>\r\n");
      out.write("                                                                Other type\r\n");
      out.write("                                                            </a>\r\n");
      out.write("                                                            <span>(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.otherType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</span>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </li>\r\n");
      out.write("                                                </form>\r\n");
      out.write("                                            </ul>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-12\">\r\n");
      out.write("                                        <h4 class=\"mb-2\">Price</h4>\r\n");
      out.write("                                        <form id=\"searchRange\" action=\"FindErrorServlet\" method=\"POST\">\r\n");
      out.write("                                            <div class=\"d-flex align-items-center justify-content-between mb-3\">\r\n");
      out.write("                                                <input type=\"search\" name=\"txtPriceFrom\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.PriceFrom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \r\n");
      out.write("                                                       class=\"form-control p-3\" placeholder=\"From\" style=\"width: 125px\">\r\n");
      out.write("                                                <input type=\"search\" name=\"txtPriceTo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.PriceTo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \r\n");
      out.write("                                                       class=\"form-control p-3\" placeholder=\"To\" style=\"width: 125px\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            <div class=\"d-flex justify-content-center my-4\">\r\n");
      out.write("                                                <a href=\"#\" class=\"btn border border-secondary px-4 py-3 rounded-pill text-primary w-100\" \r\n");
      out.write("                                                   onclick=\"document.getElementById('searchRange').submit()\">Search</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-12\">\r\n");
      out.write("                                        <form id=\"searchColor\" action=\"SearchForColorServlet\" method=\"POST\">\r\n");
      out.write("                                            <select class=\"form-control\" name=\"txtColor\" id=\"searchColor\" >\r\n");
      out.write("                                                <option value=\"multi-color\" selected>Multi color</option>\r\n");
      out.write("                                                <option value=\"red\">Red</option>\r\n");
      out.write("                                                <option value=\"blue\">Blue</option>\r\n");
      out.write("                                                <option value=\"white \">White </option>\r\n");
      out.write("                                                <option value=\"orange\">Orange</option>\r\n");
      out.write("                                                <option value=\"magenta\">Magenta</option>\r\n");
      out.write("                                                <option value=\"yellow\">Yellow</option>\r\n");
      out.write("                                                <option value=\"pink\">Pink</option>\r\n");
      out.write("                                                <option value=\"purple \">Purple</option>\r\n");
      out.write("                                                <option value=\"brown\">Brown</option>\r\n");
      out.write("                                                <option value=\"green\">Green</option>\r\n");
      out.write("                                                <option value=\"black\">Black</option>\r\n");
      out.write("                                                <option value=\"other\">Other</option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                            <div class=\"d-flex justify-content-center my-4\">\r\n");
      out.write("                                                <a href=\"#\" class=\"btn border border-secondary px-4 py-3 rounded-pill text-primary w-100\" \r\n");
      out.write("                                                   onclick=\"document.getElementById('searchColor').submit()\">Search</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                                    <div class=\"col-lg-12\">\r\n");
      out.write("                                        <h4 class=\"mb-3\">Featured products</h4>\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                        <div class=\"d-flex justify-content-center my-4\">\r\n");
      out.write("                                            <a href=\"#\" class=\"btn border border-secondary px-4 py-3 rounded-pill text-primary w-100\">View More</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-12\">\r\n");
      out.write("                                        <div class=\"position-relative\">\r\n");
      out.write("                                            <img src=\"img/banner-fruits.jpg\" class=\"img-fluid w-100 rounded\" alt=\"\">\r\n");
      out.write("                                            <div class=\"position-absolute\" style=\"top: 50%; right: 10px; transform: translateY(-50%);\">\r\n");
      out.write("                                                <h3 class=\"text-secondary fw-bold\">Fresh <br> Fruits <br> Banner</h3>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-lg-9\">\r\n");
      out.write("                                <div class=\"row g-4 justify-content-center\">\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                                    <div class=\"col-12\" >\r\n");
      out.write("                                        <div class=\"pagination d-flex justify-content-center mt-5\">\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            <form id=\"paginationForm\" action=\"PageChangerServlet\" method=\"POST\">\r\n");
      out.write("                                                <input type=\"hidden\" id=\"pageNo\" name=\"pageNo\">\r\n");
      out.write("                                                ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_8(_jspx_page_context))
        return;
      out.write("  \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Fruits Shop End-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer Start -->\r\n");
      out.write("        <div class=\"container-fluid bg-dark text-white-50 footer pt-5 mt-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <div class=\"pb-4 mb-4\" style=\"border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;\">\r\n");
      out.write("                    <div class=\"row g-4\">\r\n");
      out.write("                        <div class=\"col-lg-3\">\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <h1 class=\"text-primary mb-0\">Fruitables</h1>\r\n");
      out.write("                                <p class=\"text-secondary mb-0\">Fresh products</p>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"position-relative mx-auto\">\r\n");
      out.write("                                <input class=\"form-control border-0 w-100 py-3 px-4 rounded-pill\" type=\"number\" placeholder=\"Your Email\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary border-0 border-secondary py-3 px-4 position-absolute rounded-pill text-white\" style=\"top: 0; right: 0;\">Subscribe Now</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-3\">\r\n");
      out.write("                            <div class=\"d-flex justify-content-end pt-3\">\r\n");
      out.write("                                <a class=\"btn  btn-outline-secondary me-2 btn-md-square rounded-circle\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\r\n");
      out.write("                                <a class=\"btn btn-outline-secondary me-2 btn-md-square rounded-circle\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\r\n");
      out.write("                                <a class=\"btn btn-outline-secondary me-2 btn-md-square rounded-circle\" href=\"\"><i class=\"fab fa-youtube\"></i></a>\r\n");
      out.write("                                <a class=\"btn btn-outline-secondary btn-md-square rounded-circle\" href=\"\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row g-5\">\r\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                        <div class=\"footer-item\">\r\n");
      out.write("                            <h4 class=\"text-light mb-3\">Why People Like us!</h4>\r\n");
      out.write("                            <p class=\"mb-4\">typesetting, remaining essentially unchanged. It was \r\n");
      out.write("                                popularised in the 1960s with the like Aldus PageMaker including of Lorem Ipsum.</p>\r\n");
      out.write("                            <a href=\"\" class=\"btn border-secondary py-2 px-4 rounded-pill text-primary\">Read More</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                        <div class=\"d-flex flex-column text-start footer-item\">\r\n");
      out.write("                            <h4 class=\"text-light mb-3\">Shop Info</h4>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">About Us</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Contact Us</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Privacy Policy</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Terms & Condition</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Return Policy</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">FAQs & Help</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                        <div class=\"d-flex flex-column text-start footer-item\">\r\n");
      out.write("                            <h4 class=\"text-light mb-3\">Account</h4>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">My Account</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Shop details</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Shopping Cart</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Wishlist</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">Order History</a>\r\n");
      out.write("                            <a class=\"btn-link\" href=\"\">International Orders</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                        <div class=\"footer-item\">\r\n");
      out.write("                            <h4 class=\"text-light mb-3\">Contact</h4>\r\n");
      out.write("                            <p>Address: 1429 Netus Rd, NY 48247</p>\r\n");
      out.write("                            <p>Email: Example@gmail.com</p>\r\n");
      out.write("                            <p>Phone: +0123 4567 8910</p>\r\n");
      out.write("                            <p>Payment Accepted</p>\r\n");
      out.write("                            <img src=\"img/payment.png\" class=\"img-fluid\" alt=\"\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Footer End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Copyright Start -->\r\n");
      out.write("        <div class=\"container-fluid copyright bg-dark py-4\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-6 text-center text-md-start mb-3 mb-md-0\">\r\n");
      out.write("                        <span class=\"text-light\"><a href=\"#\"><i class=\"fas fa-copyright text-light me-2\"></i>Your Site Name</a>, All right reserved.</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6 my-auto text-center text-md-end text-white\">\r\n");
      out.write("                        <!--/*** This template is free as long as you keep the below author?s credit link/attribution link/backlink. ***/-->\r\n");
      out.write("                        <!--/*** If you'd like to use the template without the below author?s credit link/attribution link/backlink, ***/-->\r\n");
      out.write("                        <!--/*** you can purchase the Credit Removal License from \"https://htmlcodex.com/credit-removal\". ***/-->\r\n");
      out.write("                        Designed By <a class=\"border-bottom\" href=\"https://htmlcodex.com\">HTML Codex</a> Distributed By <a class=\"border-bottom\" href=\"https://themewagon.com\">ThemeWagon</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Copyright End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Back to Top -->\r\n");
      out.write("        <a href=\"#\" class=\"btn btn-primary border-3 border-primary rounded-circle back-to-top\"><i class=\"fa fa-arrow-up\"></i></a>   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- JavaScript Libraries -->\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <script src=\"lib/easing/easing.min.js\"></script>\r\n");
      out.write("        <script src=\"lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("        <script src=\"lib/lightbox/js/lightbox.min.js\"></script>\r\n");
      out.write("        <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Template Javascript -->\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
    _jspx_th_c_set_0.setVar("errors");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.PRICE_ERROR}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty errors.priceEmpty}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                <font color=\"red\">\r\n");
        out.write("                                                ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errors.priceEmpty}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                                </font> <br/>\r\n");
        out.write("                                            ");
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty errors.priceInvalid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                <font color=\"red\">\r\n");
        out.write("                                                ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errors.priceInvalid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                                </font> <br/>\r\n");
        out.write("                                            ");
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

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty errors.priceRangeError}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                <font color=\"red\">\r\n");
        out.write("                                                ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errors.priceRangeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                                </font> <br/>\r\n");
        out.write("                                            ");
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

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("newIncome");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.requestNewProduct}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("dto");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${newIncome}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <div class=\"d-flex align-items-center justify-content-start\">\r\n");
          out.write("                                                <div class=\"rounded me-4\" style=\"width: 100px; height: 100px;\">\r\n");
          out.write("                                                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getImageURL()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"img-fluid rounded\" alt=\"\"\r\n");
          out.write("                                                         style=\"width: 100%; height: 100%; object-fit: cover;\">\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div>\r\n");
          out.write("                                                    <h6 class=\"mb-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getProductName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\r\n");
          out.write("                                                    <div class=\"d-flex mb-2\">\r\n");
          out.write("                                                        <i class=\"fa fa-star text-secondary\"></i>\r\n");
          out.write("                                                        <i class=\"fa fa-star text-secondary\"></i>\r\n");
          out.write("                                                        <i class=\"fa fa-star text-secondary\"></i>\r\n");
          out.write("                                                        <i class=\"fa fa-star text-secondary\"></i>\r\n");
          out.write("                                                        <i class=\"fa fa-star\"></i>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                    <div class=\"d-flex mb-2\">\r\n");
          out.write("                                                        <h5 class=\"fw-bold me-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getProductPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" vnd</h5>\r\n");
          out.write("                                                        <h5 class=\"text-danger text-decoration-line-through\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getProductPrice() + 50000}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" vnd</h5>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                        ");
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
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent(null);
    _jspx_th_c_set_2.setVar("result");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.requestResultList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("dto");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${result}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                        <div class=\"col-md-6 col-lg-6 col-xl-4\">\r\n");
          out.write("                                            <div class=\"rounded position-relative fruite-item\">\r\n");
          out.write("                                                <form action=\"ProductDetail.jsp\" method=\"POST\">\r\n");
          out.write("                                                    <input type=\"hidden\" name=\"productID\" value=\"\">\r\n");
          out.write("                                                    <div class=\"fruite-img\">\r\n");
          out.write("                                                        <button type=\"submit\" style=\"border: none; background: none; padding: 0;\">\r\n");
          out.write("                                                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getImageURL()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"img-fluid square-img rounded-top\" alt=\"\">\r\n");
          out.write("                                                        </button>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                    <div class=\"text-white bg-secondary px-3 py-1 rounded position-absolute\" style=\"top: 10px; left: 10px;\">New</div>\r\n");
          out.write("                                                    <div class=\"p-4 border border-secondary border-top-0 rounded-bottom\">\r\n");
          out.write("                                                        <h4 class=\"small-heading\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getProductName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\r\n");
          out.write("                                                        <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getProductDetail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                                        <div class=\"d-flex justify-content-between flex-lg-wrap\">\r\n");
          out.write("                                                            <p class=\"text-dark fs-5 fw-bold mb-0\" style=\"margin-right: 10px\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.getProductPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" vnd</p>\r\n");
          out.write("                                                            <button type=\"submit\" class=\"btn border border-secondary rounded-pill px-3 text-primary\">\r\n");
          out.write("                                                                <i class=\"fa fa-shopping-bag me-2 text-primary\"></i> Add to cart\r\n");
          out.write("                                                            </button>\r\n");
          out.write("                                                        </div> \r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                </form>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                    ");
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
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <form>\r\n");
        out.write("                                                    <a href=\"#\" class=\"rounded\" style=\"margin: 1; \r\n");
        out.write("                                                       background-color: gray; color: white; pointer-events: none; opacity: 0.6;\">\r\n");
        out.write("                                                        &laquo;\r\n");
        out.write("                                                    </a>\r\n");
        out.write("                                                </form>\r\n");
        out.write("                                            ");
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

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <form id=\"backForm\" action=\"PageChangerServlet\" method=\"POST\">\r\n");
        out.write("                                                    <input type=\"hidden\" id=\"pageBack\" name=\"pageBack\"/>\r\n");
        out.write("                                                    <a href=\"#\" class=\"rounded\" style=\"margin: 1\"\r\n");
        out.write("                                                       onclick=\"document.getElementById('pageBack').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                               document.getElementById('backForm').submit();\">\r\n");
        out.write("                                                        &laquo;\r\n");
        out.write("                                                    </a>\r\n");
        out.write("                                                </form>\r\n");
        out.write("                                            ");
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

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("i");
    _jspx_th_c_forEach_2.setBegin(1);
    _jspx_th_c_forEach_2.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.pageSize}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("                                                ");
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
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <a href=\"#\" class=\"active rounded\" \r\n");
        out.write("                                                           onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                   document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                   return false;\" style=\"margin: 0\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
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

  private boolean _jspx_meth_c_if_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <a href=\"#\" class=\"rounded\" \r\n");
        out.write("                                                           onclick=\"document.getElementById('pageNo').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                                   document.getElementById('paginationForm').submit();\r\n");
        out.write("                                                                   return false;\" style=\"margin: 0\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\r\n");
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

  private boolean _jspx_meth_c_if_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent(null);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage != sessionScope.pageSize}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <form id=\"forwardForm\" action=\"PageChangerServlet\" method=\"POST\">\r\n");
        out.write("                                                    <input type=\"hidden\" id=\"pageForward\" name=\"pageForward\"/>\r\n");
        out.write("                                                    <a href=\"#\" class=\"rounded\" style=\"margin: 1\"\r\n");
        out.write("                                                       onclick=\"document.getElementById('pageForward').value = '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("';\r\n");
        out.write("                                                               document.getElementById('forwardForm').submit();\">\r\n");
        out.write("                                                        &raquo;\r\n");
        out.write("                                                    </a>\r\n");
        out.write("                                                </form>\r\n");
        out.write("                                            ");
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

  private boolean _jspx_meth_c_if_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent(null);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentPage == sessionScope.pageSize}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                                                <form>\r\n");
        out.write("                                                    <a href=\"#\" class=\"rounded\" style=\"margin: 1; \r\n");
        out.write("                                                       background-color: gray; color: white; pointer-events: none; opacity: 0.6;\">\r\n");
        out.write("                                                        &raquo;\r\n");
        out.write("                                                    </a>\r\n");
        out.write("                                                </form>\r\n");
        out.write("                                            ");
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
}
