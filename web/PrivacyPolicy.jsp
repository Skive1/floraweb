<%-- 
    Document   : contactJSP
    Created on : Sep 22, 2024, 12:58:52 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Flora Rewind - Chính sách bảo mật</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <script src="https://kit.fontawesome.com/4cb3201524.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/snackbar.css">
        <link href="css/indicator.css" rel="stylesheet">
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <style>
            body {
                font-family: Arial, sans-serif;
                line-height: 1.8;
                margin: 0;
                padding: 0;
                background-color: #f8f9fa;
                color: #333;
            }

            .Privacy-Content {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                background-color: white;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                color: #007bff;
                border-bottom: 2px solid #007bff;
                padding-bottom: 10px;
                margin-bottom: 20px;
            }

            h3 {
                color: #0056b3;
                margin-top: 20px;
                margin-bottom: 10px;
            }

            p {
                margin: 15px 0;
                text-align: justify;
            }

            ul {
                margin-left: 20px;
                margin-bottom: 15px;
            }

            footer {
                text-align: center;
                padding: 10px;
                background-color: #007bff;
                color: white;
                position: relative;
                bottom: 0;
                width: 100%;
            }

            .copyright {
                background-color: #343a40;
                padding: 20px 0;
            }

            .copyright a {
                color: white;
                text-decoration: none;
            }

            .copyright a:hover {
                text-decoration: underline;
            }
        </style>
    </head>

    <body>

        <!-- Spinner Start -->
        <div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-third" role="status"></div>
        </div>
        <!-- Spinner End -->
        <div id="snackbar"></div>

        <!-- Navbar start -->
        <div class="container-fluid fixed-top">
            <div class="container topbar bg-primary d-none d-lg-block">
                <div class="d-flex justify-content-between">
                    <div class="top-info ps-2">
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="https://hcmuni.fpt.edu.vn/" class="text-white">FPT University, HCM</a></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">flora.flower.platform@gmail.com</a></small>
                    </div>
                    <div class="top-link pe-2">
                        <a href="privacyPage" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                        <a href="termsOfUse" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                        <a href="#" class="text-white"><small class="text-white ms-2">Sales and Refunds</small></a>
                    </div>
                </div>
            </div>
            <div class="container px-0">
                <nav class="navbar navbar-light bg-white navbar-expand-xl">
                    <a href="home" class="navbar-brand"><img class="display-6" src="img/floralogo.png" alt="Flora Logo" width="200"></a>
                    <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="fa fa-bars text-third"></span>
                    </button>
                    <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                        <div class="navbar-nav mx-auto">
                            <a href="home" class="nav-item nav-link ">Home</a>
                            <a href="shoppingAction" class="nav-item nav-link">Sản phẩm</a>
                            <a href="searchAction?navbarShop=1" class="nav-item nav-link">Shop</a>
                            <a href="event" class="nav-item nav-link">Event</a>
                            <a href="contactPage" class="nav-item nav-link active">Contact</a>
                            <!--        Session Management  -->
                            <c:if test="${not empty sessionScope.USER}">
                                <!--                Manager Session-->
                                <c:if test="${sessionScope.USER.role == 'Admin'}">
                                    <a href="monthlyBoard" class="nav-item nav-link">DashBoard</a>
                                </c:if>
                                <!--                Delivery Session-->
                                <c:if test="${sessionScope.USER.role == 'Delivery'}">
                                    <a href="delivererOrders" class="nav-item nav-link">Thông tin đơn hàng</a>
                                </c:if>
                                <!--                Seller Session-->
                                <c:if test="${sessionScope.USER.role == 'Seller'}">
                                    <a href="showStoreName" class="nav-item nav-link">Manage Shop</a>
                                    <a href="showEventId" class="nav-item nav-link">DashBoard</a>
                                </c:if>
                            </c:if>

                        </div>
                        <div class="d-flex align-items-center justify-content-center m-3 me-0">
                            <c:if test="${empty sessionScope.USER}">
                                <div style="position: relative">
                                    <div id="bell">
                                        <a href="loginPage">
                                            <button style="border: none; background-color:white; color: white; padding-top:10px; cursor: pointer;">
                                                <i class="fa-solid fa-2x fa-bell" style="color: #81c408"></i>
                                            </button>
                                        </a>   
                                    </div>
                                </div>
                                <a href="loginPage" class="position-relative" style="margin-right: 20px; margin-left: 12px;">
                                    <i class="fa fa-shopping-bag fa-2x"></i>
                                </a>
                                <a href="loginPage" class="my-auto">
                                    <i class="fas fa-user fa-2x"></i>
                                </a>
                            </c:if>
                            <c:if test="${not empty sessionScope.USER}">
                                <div style="position: relative">
                                    <div id="bell">
                                        <button id="notifyButton"style="border: none; background-color:white; color: white; padding-top:10px; cursor: pointer;">
                                            <i class="fa-solid fa-2x fa-bell" style="color: #81c408"></i>
                                            <span id="newProductIndicator" class="new-product-indicator" style="display: none;"></span>
                                        </button>
                                    </div>
                                    <div id="notificationBox" class="notification-box" style="display: none; position: absolute; background-color: white; border: 1px solid #ddd; padding: 10px; width: 300px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);">

                                    </div>
                                </div>

                                <div class="nav-item dropdown">
                                    <a href="#" class="position-relative me-0 nav-link dropdown-toggle d-flex align-items-center" style="padding-right: 0px">
                                        <i class="fa fa-shopping-bag fa-2x"></i>
                                        <c:if test="${sessionScope.PENDING_EITEMS != 0 || sessionScope.PENDING_ITEMS != 0}">
                                            <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: 4px; left: 39px; height: 10px; min-width: 10px;"></span>
                                        </c:if>
                                    </a>
                                    <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                        <a href="cartPage" class="dropdown-item">Cart</a>
                                        <c:if test="${sessionScope.PENDING_ITEMS != 0}">
                                            <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: 15px; left: 122px; height: 18px; min-width: 18px;">${sessionScope.PENDING_ITEMS}</span>
                                        </c:if>
                                        <a href="eventCart" class="dropdown-item">Event Cart</a>
                                        <c:if test="${sessionScope.PENDING_EITEMS != 0}">
                                            <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: 47px; left: 122px; height: 18px; min-width: 18px;">${sessionScope.PENDING_EITEMS}</span>
                                        </c:if>
                                    </div>
                                </div>

                                <div class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle d-flex align-items-center" data-bs-toggle="dropdown" style="padding-left: 8px; padding-right: 0px">
                                        <img src="img/avatar.png" alt="User Avatar" class="rounded-circle" width="60"><c:out value ="${sessionScope.USER.fullName}"/>
                                    </a>
                                    <jsp:include page="navUser.jsp"></jsp:include>
                                    </div>                         
                            </c:if>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Navbar End -->



        <!-- Modal Search Start -->
        <div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content rounded-0">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center">
                        <div class="input-group w-75 mx-auto d-flex">
                            <input type="search" class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                            <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Search End -->


        <!-- Single Page Header start -->
        <div class="container-fluid page-header py-5">
            <h1 class="text-center text-white display-6">Chính sách bảo mật</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="home">Home</a></li>
               
            </ol>
        </div>
        <!-- Single Page Header End -->


        <!-- Content Start -->
        <div class="Privacy-Content">
            <section>
                <h2 style="text-align:center">Chính Sách Bảo Mật</h2>
                <p>Với Flora Store, bảo mật thông tin cá nhân của bạn là ưu tiên hàng đầu của chúng tôi. Chính sách này mô tả cách chúng tôi thu thập, sử dụng, và bảo vệ thông tin cá nhân của bạn.</p>

                <h3>1. Thông Tin Chúng Tôi Thu Thập</h3>
                <p>Chúng tôi có thể thu thập thông tin cá nhân như:</p>
                <ul>
                    <li>Tên</li>
                    <li>Địa chỉ email</li>
                    <li>Số điện thoại</li>
                    <li>Thông tin thanh toán</li>
                    <li>Thông tin đặt hàng</li>
                </ul>

                <h3>2. Cách Chúng Tôi Sử Dụng Thông Tin</h3>
                <p>Thông tin cá nhân của bạn có thể được sử dụng để:</p>
                <ul>
                    <li>Xử lý đơn hàng và cung cấp dịch vụ</li>
                    <li>Gửi thông tin cập nhật về đơn hàng</li>
                    <li>Gửi bản tin qua email và thông báo khuyến mãi</li>
                    <li>Cải thiện dịch vụ và trải nghiệm khách hàng</li>
                </ul>

                <h3>3. Bảo Mật Thông Tin</h3>
                <p>Chúng tôi sử dụng các biện pháp bảo mật thích hợp để bảo vệ thông tin cá nhân của bạn khỏi việc truy cập, sử dụng hoặc tiết lộ trái phép. Thông tin của bạn được lưu trữ trên hệ thống bảo mật và chỉ có nhân viên được ủy quyền mới có quyền truy cập.</p>

                <h3>4. Chia Sẻ Thông Tin</h3>
                <p>Chúng tôi không bán, trao đổi hay cho thuê thông tin cá nhân của bạn cho bên thứ ba. Thông tin của bạn chỉ được chia sẻ với các bên liên quan cần thiết để xử lý đơn hàng hoặc cung cấp dịch vụ mà bạn đã yêu cầu.</p>

                <h3>5. Quyền Của Bạn</h3>
                <p>Bạn có quyền yêu cầu truy cập, chỉnh sửa hoặc xóa thông tin cá nhân của mình. Nếu bạn muốn thực hiện quyền này, vui lòng liên hệ với chúng tôi qua thông tin liên hệ dưới đây.</p>

                <h3>6. Liên Hệ</h3>
                <p>Nếu bạn có bất kỳ câu hỏi nào về chính sách bảo mật này, xin vui lòng liên hệ với chúng tôi qua email: <a href="mailto:flora.flower.platform@gmail.com">flora.flower.platform@gmail.com</a>.</p>
            </section>
        </div>
        <!-- Content End -->


        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
            <!-- Footer End -->

            <!-- Copyright Start -->
            <div class="container-fluid copyright bg-dark py-4">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                            <span class="text-light"><a href="#"><i class="fas fa-copyright text-light me-2"></i>Flora Store</a>, All right reserved.</span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Copyright End -->



            <!-- Back to Top -->
            <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   


            <!-- JavaScript Libraries -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/lightbox/js/lightbox.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>

            <!-- Template Javascript -->
        <c:if test="${not empty sessionScope.USER}">
            <script src="js/notification.js"></script>
        </c:if>
        <script src="js/main.js"></script>
        <script src="js/newProduct.js"></script>
    </body>

</html>
