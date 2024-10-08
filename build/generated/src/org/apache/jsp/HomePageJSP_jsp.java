package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HomePageJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_var_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_url_var_value.release();
    _jspx_tagPool_c_param_value_name_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>Flora Rewind | Buy and sell on the website</title>\r\n");
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
      out.write("        <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Template Stylesheet -->\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("        <!-- FavIcon -->\r\n");
      out.write("        <link rel=\"icon\" href=\"img/flora-favicon.png\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <!-- Spinner Start -->\r\n");
      out.write("        <div id=\"spinner\" class=\"show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <div class=\"spinner-grow text-third\" role=\"status\"></div>\r\n");
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
      out.write("                    <a href=\"home\" class=\"navbar-brand\"><img class=\"display-6\" src=\"img/floralogo.png\" alt=\"Flora Logo\" width=\"200\"></a>\r\n");
      out.write("                    <button class=\"navbar-toggler py-2 px-3\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\r\n");
      out.write("                        <span class=\"fa fa-bars text-third\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <div class=\"collapse navbar-collapse bg-white\" id=\"navbarCollapse\">\r\n");
      out.write("                        <div class=\"navbar-nav mx-auto\">\r\n");
      out.write("                            <a href=\"home\" class=\"nav-item nav-link active\">Home</a>\r\n");
      out.write("                            <a href=\"shoppingAction\" class=\"nav-item nav-link\">Shop</a>\r\n");
      out.write("                            <a href=\"event\" class=\"nav-item nav-link\">Event</a>\r\n");
      out.write("                            <div class=\"nav-item dropdown\">\r\n");
      out.write("                                <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">Pages</a>\r\n");
      out.write("                                <div class=\"dropdown-menu m-0 bg-secondary rounded-0\">\r\n");
      out.write("                                    <a href=\"cart.html\" class=\"dropdown-item\">Cart</a>\r\n");
      out.write("                                    <a href=\"chackout.html\" class=\"dropdown-item\">Checkout</a>\r\n");
      out.write("                                    <a href=\"testimonial.html\" class=\"dropdown-item\">Testimonial</a>\r\n");
      out.write("                                    <a href=\"404.html\" class=\"dropdown-item\">404 Page</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <a href=\"contactPage\" class=\"nav-item nav-link\">Contact</a>\r\n");
      out.write("                            <!--        Session Management  -->\r\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"d-flex align-items-center justify-content-center m-3 me-0\">\r\n");
      out.write("                            <button class=\"btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4\" data-bs-toggle=\"modal\" data-bs-target=\"#searchModal\">\r\n");
      out.write("                                <i class=\"fas fa-search text-third\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <a href=\"#\" class=\"position-relative me-4\">\r\n");
      out.write("                                <i class=\"fa fa-shopping-bag fa-2x\"></i>\r\n");
      out.write("                                <span class=\"position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1\" style=\"top: -5px; left: 15px; height: 20px; min-width: 20px;\">3</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            ");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Navbar End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Modal Search Start -->\r\n");
      out.write("        <div class=\"modal fade\" id=\"searchModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("            <div class=\"modal-dialog modal-fullscreen\">\r\n");
      out.write("                <div class=\"modal-content rounded-0\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Search by keyword</h5>\r\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body d-flex align-items-center\">\r\n");
      out.write("                        <div class=\"input-group w-75 mx-auto d-flex\">\r\n");
      out.write("                            <input type=\"search\" class=\"form-control p-3\" placeholder=\"keywords\" aria-describedby=\"search-icon-1\">\r\n");
      out.write("                            <span id=\"search-icon-1\" class=\"input-group-text p-3\"><i class=\"fa fa-search\"></i></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Modal Search End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Hero Start -->\r\n");
      out.write("        <div class=\"container-fluid py-5 mb-5 hero-header\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <div class=\"row g-5 align-items-center\">\r\n");
      out.write("                    <div class=\"col-md-12 col-lg-7\">\r\n");
      out.write("                        <h4 class=\"mb-3 text-secondary text-shadow display-3\">Flora Rewind Platform</h4>      \r\n");
      out.write("                        ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        ");
      if (_jspx_meth_c_if_6(_jspx_page_context))
        return;
      out.write("   \r\n");
      out.write("                        ");
      if (_jspx_meth_c_if_7(_jspx_page_context))
        return;
      out.write("                     \r\n");
      out.write("                        <div class=\"position-relative mx-auto\">\r\n");
      out.write("                            <input class=\"form-control border-2 border-secondary w-75 py-3 px-4 rounded-pill\" type=\"number\" placeholder=\"Search\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary border-2 border-secondary py-3 px-4 position-absolute rounded-pill text-white h-100\" style=\"top: 0; right: 25%;\">Submit Now</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-12 col-lg-5\">\r\n");
      out.write("                        <div id=\"carouselId\" class=\"carousel slide position-relative\" data-bs-ride=\"carousel\">\r\n");
      out.write("                            <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("                                <div class=\"carousel-item active rounded\">\r\n");
      out.write("                                    <img src=\"img/FloraDelivery.png\" class=\"img-fluid w-100 h-100 bg-secondary rounded\" alt=\"First slide\">\r\n");
      out.write("                                    <a href=\"#\" class=\"btn px-4 py-2 text-white rounded\">Delivery</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"carousel-item rounded\">\r\n");
      out.write("                                    <img src=\"img/service247.png\" class=\"img-fluid w-100 h-100 rounded\" alt=\"Second slide\">\r\n");
      out.write("                                    <a href=\"#\" class=\"btn px-4 py-2 text-white rounded\">CSKH 24/7</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselId\" data-bs-slide=\"prev\">\r\n");
      out.write("                                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                                <span class=\"visually-hidden\">Previous</span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselId\" data-bs-slide=\"next\">\r\n");
      out.write("                                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                                <span class=\"visually-hidden\">Next</span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Hero End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Featurs Section Start -->\r\n");
      out.write("        <div class=\"container-fluid featurs py-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <div class=\"row g-4\">\r\n");
      out.write("                    <div class=\"col-md-6 col-lg-3\">\r\n");
      out.write("                        <div class=\"featurs-item text-center rounded bg-light p-4\">\r\n");
      out.write("                            <div class=\"featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto\">\r\n");
      out.write("                                <i class=\"fas fa-car-side fa-3x text-white\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"featurs-content text-center\">\r\n");
      out.write("                                <h5>Free Shipping</h5>\r\n");
      out.write("                                <p class=\"mb-0\">Free on order over $300</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6 col-lg-3\">\r\n");
      out.write("                        <div class=\"featurs-item text-center rounded bg-light p-4\">\r\n");
      out.write("                            <div class=\"featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto\">\r\n");
      out.write("                                <i class=\"fas fa-user-shield fa-3x text-white\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"featurs-content text-center\">\r\n");
      out.write("                                <h5>Security Payment</h5>\r\n");
      out.write("                                <p class=\"mb-0\">100% security payment</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6 col-lg-3\">\r\n");
      out.write("                        <div class=\"featurs-item text-center rounded bg-light p-4\">\r\n");
      out.write("                            <div class=\"featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto\">\r\n");
      out.write("                                <i class=\"fas fa-exchange-alt fa-3x text-white\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"featurs-content text-center\">\r\n");
      out.write("                                <h5>30 Day Return</h5>\r\n");
      out.write("                                <p class=\"mb-0\">30 day money guarantee</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6 col-lg-3\">\r\n");
      out.write("                        <div class=\"featurs-item text-center rounded bg-light p-4\">\r\n");
      out.write("                            <div class=\"featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto\">\r\n");
      out.write("                                <i class=\"fa fa-phone-alt fa-3x text-white\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"featurs-content text-center\">\r\n");
      out.write("                                <h5>24/7 Support</h5>\r\n");
      out.write("                                <p class=\"mb-0\">Support every time fast</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Featurs Section End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Fruits Shop Start-->\r\n");
      out.write("        <div class=\"container-fluid fruite py-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <div class=\"tab-class text-center\">\r\n");
      out.write("                    <div class=\"row g-4\">\r\n");
      out.write("                        <div class=\"col-lg-4 text-start\">\r\n");
      out.write("                            <h1>Best Seller Flowers</h1>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"tab-content\">\r\n");
      out.write("                        <div id=\"tab-1\" class=\"tab-pane fade show p-0 active\">\r\n");
      out.write("                            <div class=\"row g-4\">\r\n");
      out.write("                                <div class=\"col-lg-12\">\r\n");
      out.write("                                    <div class=\"row g-4\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>      \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Fruits Shop End-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Featurs Start -->\r\n");
      out.write("        <div class=\"container-fluid service py-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <div class=\"row g-4 justify-content-center\">\r\n");
      out.write("                    <div class=\"col-md-6 col-lg-4\">\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div class=\"service-item bg-secondary rounded border border-secondary\">\r\n");
      out.write("                                <img src=\"img/eventwaste.png\" class=\"img-fluid rounded-top w-100\" alt=\"\">\r\n");
      out.write("                                <div class=\"px-5 rounded-bottom\">\r\n");
      out.write("                                    <div class=\" bg-primary text-center p-4 rounded\">\r\n");
      out.write("                                        <h5 class=\"text-white\">Event Waste</h5>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6 col-lg-4\">\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div class=\"service-item bg-dark rounded border border-dark\">\r\n");
      out.write("                                <img src=\"img/featur-2.jpg\" class=\"img-fluid rounded-top w-100\" alt=\"\">\r\n");
      out.write("                                <div class=\"px-4 rounded-bottom\">\r\n");
      out.write("                                    <div class=\"service-content bg-light text-center p-4 rounded\">\r\n");
      out.write("                                        <h5 class=\"text-third\">Tasty Fruits</h5>\r\n");
      out.write("                                        <h3 class=\"mb-0\">Free delivery</h3>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6 col-lg-4\">\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div class=\"service-item bg-primary rounded border border-primary\">\r\n");
      out.write("                                <img src=\"img/featur-3.jpg\" class=\"img-fluid rounded-top w-100\" alt=\"\">\r\n");
      out.write("                                <div class=\"px-4 rounded-bottom\">\r\n");
      out.write("                                    <div class=\"service-content bg-secondary text-center p-4 rounded\">\r\n");
      out.write("                                        <h5 class=\"text-white\">Exotic Vegitable</h5>\r\n");
      out.write("                                        <h3 class=\"mb-0\">Discount 30$</h3>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Featurs End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Vesitable Shop Start-->\r\n");
      out.write("        <div class=\"container-fluid vesitable py-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <h1 class=\"mb-0\">New Arrival Flowers</h1>\r\n");
      out.write("                <div class=\"owl-carousel vegetable-carousel justify-content-center\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Vesitable Shop End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Banner Section Start-->\r\n");
      out.write("        <div class=\"container-fluid banner bg-secondary my-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <div class=\"row g-4 align-items-center\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"py-4\">\r\n");
      out.write("                            <h1 class=\"display-2 text-white\">Cheapest Flower</h1>\r\n");
      out.write("                            <p class=\"fw-normal display-3 text-dark mb-4\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                            <p class=\"mb-4 text-dark display-6\">Type: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${urlRewriting}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"banner-btn btn border-2 border-white rounded-pill text-dark py-3 px-5\">BUY</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"position-relative\">\r\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.imageURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"img-fluid rounded\" alt=\"\" style=\"border-radius: 50%; width: 500px\">\r\n");
      out.write("                            <div class=\"d-flex align-items-center justify-content-center bg-white rounded-circle position-absolute\" style=\"width: 140px; height: 140px; top: 0; left: 0;\">\r\n");
      out.write("                                <h2 style=\"font-size: 30px;\">");
      if (_jspx_meth_fmt_formatNumber_2(_jspx_page_context))
        return;
      out.write("đ</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Banner Section End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Fact Start -->\r\n");
      out.write("        <div class=\"container-fluid py-5\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"bg-light p-5 rounded\">\r\n");
      out.write("                    <div class=\"row g-4 justify-content-center\">\r\n");
      out.write("                        <div class=\"col-md-6 col-lg-6 col-xl-3\">\r\n");
      out.write("                            <div class=\"counter bg-white rounded p-5\">\r\n");
      out.write("                                <i class=\"fa fa-users text-secondary\"></i>\r\n");
      out.write("                                <h4>satisfied customers</h4>\r\n");
      out.write("                                <h1>1963</h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-6 col-lg-6 col-xl-3\">\r\n");
      out.write("                            <div class=\"counter bg-white rounded p-5\">\r\n");
      out.write("                                <i class=\"fa fa-users text-secondary\"></i>\r\n");
      out.write("                                <h4>quality of service</h4>\r\n");
      out.write("                                <h1>99%</h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-6 col-lg-6 col-xl-3\">\r\n");
      out.write("                            <div class=\"counter bg-white rounded p-5\">\r\n");
      out.write("                                <i class=\"fa fa-users text-secondary\"></i>\r\n");
      out.write("                                <h4>quality certificates</h4>\r\n");
      out.write("                                <h1>33</h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-6 col-lg-6 col-xl-3\">\r\n");
      out.write("                            <div class=\"counter bg-white rounded p-5\">\r\n");
      out.write("                                <i class=\"fa fa-users text-secondary\"></i>\r\n");
      out.write("                                <h4>Available Products</h4>\r\n");
      out.write("                                <h1>789</h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Fact Start -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Tastimonial Start -->\r\n");
      out.write("        <div class=\"container-fluid testimonial py-5\">\r\n");
      out.write("            <div class=\"container py-5\">\r\n");
      out.write("                <div class=\"testimonial-header text-center\">\r\n");
      out.write("                    <h4 class=\"text-third\">Our Testimonial</h4>\r\n");
      out.write("                    <h1 class=\"display-5 mb-5 text-dark\">Our Client Saying!</h1>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"owl-carousel testimonial-carousel\">\r\n");
      out.write("                    <div class=\"testimonial-item img-border-radius bg-light rounded p-4\">\r\n");
      out.write("                        <div class=\"position-relative\">\r\n");
      out.write("                            <i class=\"fa fa-quote-right fa-2x text-secondary position-absolute\" style=\"bottom: 30px; right: 0;\"></i>\r\n");
      out.write("                            <div class=\"mb-4 pb-4 border-bottom border-secondary\">\r\n");
      out.write("                                <p class=\"mb-0\">Lorem Ipsum is simply dummy text of the printing Ipsum has been the industry's standard dummy text ever since the 1500s,\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"d-flex align-items-center flex-nowrap\">\r\n");
      out.write("                                <div class=\"bg-secondary rounded\">\r\n");
      out.write("                                    <img src=\"img/testimonial-1.jpg\" class=\"img-fluid rounded\" style=\"width: 100px; height: 100px;\" alt=\"\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"ms-4 d-block\">\r\n");
      out.write("                                    <h4 class=\"text-dark\">Client Name</h4>\r\n");
      out.write("                                    <p class=\"m-0 pb-3\">Profession</p>\r\n");
      out.write("                                    <div class=\"d-flex pe-5\">\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"testimonial-item img-border-radius bg-light rounded p-4\">\r\n");
      out.write("                        <div class=\"position-relative\">\r\n");
      out.write("                            <i class=\"fa fa-quote-right fa-2x text-secondary position-absolute\" style=\"bottom: 30px; right: 0;\"></i>\r\n");
      out.write("                            <div class=\"mb-4 pb-4 border-bottom border-secondary\">\r\n");
      out.write("                                <p class=\"mb-0\">Lorem Ipsum is simply dummy text of the printing Ipsum has been the industry's standard dummy text ever since the 1500s,\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"d-flex align-items-center flex-nowrap\">\r\n");
      out.write("                                <div class=\"bg-secondary rounded\">\r\n");
      out.write("                                    <img src=\"img/testimonial-1.jpg\" class=\"img-fluid rounded\" style=\"width: 100px; height: 100px;\" alt=\"\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"ms-4 d-block\">\r\n");
      out.write("                                    <h4 class=\"text-dark\">Client Name</h4>\r\n");
      out.write("                                    <p class=\"m-0 pb-3\">Profession</p>\r\n");
      out.write("                                    <div class=\"d-flex pe-5\">\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"testimonial-item img-border-radius bg-light rounded p-4\">\r\n");
      out.write("                        <div class=\"position-relative\">\r\n");
      out.write("                            <i class=\"fa fa-quote-right fa-2x text-secondary position-absolute\" style=\"bottom: 30px; right: 0;\"></i>\r\n");
      out.write("                            <div class=\"mb-4 pb-4 border-bottom border-secondary\">\r\n");
      out.write("                                <p class=\"mb-0\">Lorem Ipsum is simply dummy text of the printing Ipsum has been the industry's standard dummy text ever since the 1500s,\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"d-flex align-items-center flex-nowrap\">\r\n");
      out.write("                                <div class=\"bg-secondary rounded\">\r\n");
      out.write("                                    <img src=\"img/testimonial-1.jpg\" class=\"img-fluid rounded\" style=\"width: 100px; height: 100px;\" alt=\"\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"ms-4 d-block\">\r\n");
      out.write("                                    <h4 class=\"text-dark\">Client Name</h4>\r\n");
      out.write("                                    <p class=\"m-0 pb-3\">Profession</p>\r\n");
      out.write("                                    <div class=\"d-flex pe-5\">\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                        <i class=\"fas fa-star text-third\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Tastimonial End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer Start -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Footer End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Copyright Start -->\r\n");
      out.write("        <div class=\"container-fluid copyright bg-dark py-4\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-6 text-center text-md-start mb-3 mb-md-0\">\r\n");
      out.write("                        <span class=\"text-light\"><a href=\"#\"><i class=\"fas fa-copyright text-light me-2\"></i>Your Site Name</a>, All right reserved.</span>\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty sessionScope.USER}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <!--                Manager Session-->\r\n");
        out.write("                                ");
        if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                <!--                Delivery Session-->\r\n");
        out.write("                                ");
        if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                <!--                Seller Session-->\r\n");
        out.write("                                ");
        if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                            ");
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

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.role == 'Admin'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <a href=\"manageAccount\" class=\"nav-item nav-link\">Manage Account</a>\r\n");
        out.write("                                    <a href=\"monthlyRevenue\" class=\"nav-item nav-link\">DashBoard</a>\r\n");
        out.write("                                ");
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

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.role == 'Delivery'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <a href=\"#\" class=\"nav-item nav-link\">Delivery Order</a>\r\n");
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

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.role == 'Seller'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <a href=\"ProductManagementAction\" class=\"nav-item nav-link\">Manage Shop</a>\r\n");
        out.write("                                ");
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
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty sessionScope.USER}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <a href=\"loginPage\" class=\"my-auto\">\r\n");
        out.write("                                    <i class=\"fas fa-user fa-2x\"></i>\r\n");
        out.write("                                </a>\r\n");
        out.write("                            ");
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

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty sessionScope.USER}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <div class=\"nav-item dropdown\">\r\n");
        out.write("                                    <a href=\"#\" class=\"nav-link dropdown-toggle d-flex align-items-center\" data-bs-toggle=\"dropdown\">\r\n");
        out.write("                                        <img src=\"img/avatar.png\" alt=\"User Avatar\" class=\"rounded-circle\" width=\"60\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                    </a>\r\n");
        out.write("                                    <div class=\"dropdown-menu m-0 bg-secondary rounded-0\">\r\n");
        out.write("                                        <a href=\"viewProfileAction\" class=\"dropdown-item\">My Profile</a>\r\n");
        out.write("                                        <a href=\"#\" class=\"dropdown-item\">Purchase Order</a>\r\n");
        out.write("                                        <a href=\"logoutAction\" class=\"dropdown-item\">Logout</a>\r\n");
        out.write("                                    </div>\r\n");
        out.write("                                </div>                         \r\n");
        out.write("                            ");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("user");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.fullName}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent(null);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty user}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            <h1 class=\"mb-5 display-3 text-primary text-shadow\">Welcome to Flora</h1>\r\n");
        out.write("                        ");
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
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty user}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            <h1 class=\"mb-5 display-3 text-primary text-shadow\">Hi, ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</h1>\r\n");
        out.write("                            <h1 class=\"mb-5 display-3 text-primary text-shadow\">Welcome to Flora</h1>\r\n");
        out.write("                        ");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.BEST_SELLER}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("flower");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <div class=\"col-md-6 col-lg-4 col-xl-3\">\r\n");
          out.write("                                                <form action=\"cartAddItem\">\r\n");
          out.write("                                                    <div class=\"rounded position-relative fruite-item\">\r\n");
          out.write("                                                        <div class=\"fruite-img\">\r\n");
          out.write("                                                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.imageURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"img-fluid w-100 rounded-top\" alt=\"\">\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                        <div class=\"text-white bg-secondary px-3 py-1 rounded position-absolute\" style=\"top: 10px; left: 10px;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("                                                        <div class=\"p-4 border border-secondary border-top-0 rounded-bottom\">\r\n");
          out.write("                                                            ");
          if (_jspx_meth_c_url_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("                                                            <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${urlRewriting}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                                                <h4>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\r\n");
          out.write("                                                            </a>\r\n");
          out.write("                                                            <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productDetail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                                            <div class=\"d-flex justify-content-between flex-lg-wrap\">\r\n");
          out.write("                                                                <p class=\"text-dark fs-5 fw-bold mb-0\">\r\n");
          out.write("                                                                    ");
          if (_jspx_meth_fmt_formatNumber_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("đ\r\n");
          out.write("                                                                </p>\r\n");
          out.write("                                                                <button type=\"submit\" name=\"btAction\" value=\"Add to cart\" class=\"btn border border-secondary rounded-pill px-3 text-third\">\r\n");
          out.write("                                                                    <i class=\"fa fa-shopping-bag me-2 text-third\"></i> Add to cart\r\n");
          out.write("                                                                </button>\r\n");
          out.write("                                                            </div>\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                </form>\r\n");
          out.write("                                            </div>  \r\n");
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

  private boolean _jspx_meth_c_url_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_url_0.setVar("urlRewriting");
    _jspx_th_c_url_0.setValue("productDetail");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_push_body_count_c_forEach_0[0]++;
        _jspx_th_c_url_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                                                ");
        if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("                                                                ");
        if (_jspx_meth_c_param_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_c_url_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
        _jspx_push_body_count_c_forEach_0[0]--;
    }
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_0.setName("productId");
    _jspx_th_c_param_0.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }

  private boolean _jspx_meth_c_param_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_1 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_1.setPageContext(_jspx_page_context);
    _jspx_th_c_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_1.setName("productType");
    _jspx_th_c_param_1.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_1 = _jspx_th_c_param_1.doStartTag();
    if (_jspx_th_c_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productPrice}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatNumber_0.setType("number");
    _jspx_th_fmt_formatNumber_0.setGroupingUsed(true);
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_0);
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
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.NEW_ARRIVAL}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("flower");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        <form action=\"cartAddItem\">\r\n");
          out.write("                            <div class=\"border border-primary rounded position-relative vesitable-item\">\r\n");
          out.write("                                <div class=\"fruite-img\">\r\n");
          out.write("                                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.imageURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"img-fluid w-100 rounded-top\" alt=\"\">\r\n");
          out.write("                                </div>\r\n");
          out.write("                                <div class=\"text-white bg-primary px-3 py-1 rounded position-absolute\" style=\"top: 10px; right: 10px;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("                                <div class=\"p-4 rounded-bottom\">\r\n");
          out.write("                                    ");
          if (_jspx_meth_c_url_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("                                    <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${urlRewriting}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                        <h4>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\r\n");
          out.write("                                    </a>\r\n");
          out.write("                                    <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${productDetail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                    <div class=\"d-flex justify-content-between flex-lg-wrap\">\r\n");
          out.write("                                        <p class=\"text-dark fs-5 fw-bold mb-0\">\r\n");
          out.write("                                            ");
          if (_jspx_meth_fmt_formatNumber_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("đ\r\n");
          out.write("                                        </p>\r\n");
          out.write("                                        <button type=\"submit\" name=\"btAction\" value=\"Add to cart\" class=\"btn border border-secondary rounded-pill px-3 text-third\">\r\n");
          out.write("                                            <i class=\"fa fa-shopping-bag me-2 text-third\"></i> Add to cart\r\n");
          out.write("                                        </button>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                </div>\r\n");
          out.write("                            </div>\r\n");
          out.write("                        </form>\r\n");
          out.write("                    ");
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

  private boolean _jspx_meth_c_url_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_url_1.setVar("urlRewriting");
    _jspx_th_c_url_1.setValue("productDetail");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_push_body_count_c_forEach_1[0]++;
        _jspx_th_c_url_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                        ");
        if (_jspx_meth_c_param_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("                                        ");
        if (_jspx_meth_c_param_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_url_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
        _jspx_push_body_count_c_forEach_1[0]--;
    }
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_param_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_2 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_2.setPageContext(_jspx_page_context);
    _jspx_th_c_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_1);
    _jspx_th_c_param_2.setName("productId");
    _jspx_th_c_param_2.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_2 = _jspx_th_c_param_2.doStartTag();
    if (_jspx_th_c_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_2);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_2);
    return false;
  }

  private boolean _jspx_meth_c_param_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_3 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_3.setPageContext(_jspx_page_context);
    _jspx_th_c_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_1);
    _jspx_th_c_param_3.setName("productType");
    _jspx_th_c_param_3.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_3 = _jspx_th_c_param_3.doStartTag();
    if (_jspx_th_c_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_3);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_3);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_fmt_formatNumber_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productPrice}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatNumber_1.setType("number");
    _jspx_th_fmt_formatNumber_1.setGroupingUsed(true);
    int _jspx_eval_fmt_formatNumber_1 = _jspx_th_fmt_formatNumber_1.doStartTag();
    if (_jspx_th_fmt_formatNumber_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_1);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_1);
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
    _jspx_th_c_set_1.setVar("flower");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.CHEAPEST_FLOWER}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent(null);
    _jspx_th_c_url_2.setVar("urlRewriting");
    _jspx_th_c_url_2.setValue("productDetail");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_eval_c_url_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_param_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_param_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_url_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_param_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_4 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_4.setPageContext(_jspx_page_context);
    _jspx_th_c_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_2);
    _jspx_th_c_param_4.setName("productId");
    _jspx_th_c_param_4.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_4 = _jspx_th_c_param_4.doStartTag();
    if (_jspx_th_c_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_4);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_4);
    return false;
  }

  private boolean _jspx_meth_c_param_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_5 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_5.setPageContext(_jspx_page_context);
    _jspx_th_c_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_2);
    _jspx_th_c_param_5.setName("productType");
    _jspx_th_c_param_5.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_5 = _jspx_th_c_param_5.doStartTag();
    if (_jspx_th_c_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_5);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_5);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_2 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_2.setParent(null);
    _jspx_th_fmt_formatNumber_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flower.productPrice}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatNumber_2.setType("number");
    _jspx_th_fmt_formatNumber_2.setGroupingUsed(true);
    int _jspx_eval_fmt_formatNumber_2 = _jspx_th_fmt_formatNumber_2.doStartTag();
    if (_jspx_th_fmt_formatNumber_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_2);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_2);
    return false;
  }
}
