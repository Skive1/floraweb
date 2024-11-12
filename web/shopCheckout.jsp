<%-- 
    Document   : shopCheckout
    Created on : Oct 16, 2024, 2:10:13 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Check out | Buy and sell on the website</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <!-- Template Stylesheet -->
        <link href="css/editbutton.css" rel="stylesheet">
        <link href="css/indicator.css" rel="stylesheet">
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>

        <style>
            .red{
                color: red
            }
        </style>
        <script>
            window.onload = function () {
                const prevPage = sessionStorage.getItem('prevPage');
                const url = "http://localhost:8084/FloraRewind/shopCheckouts";
                if (performance.navigation.type === performance.navigation.TYPE_BACK_FORWARD) {
                    if (url.includes(prevPage)) {
                        window.location.href = "http://localhost:8084/FloraRewind/orderShop";
                    }
                }
            };
        </script>
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
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="mailto:flora.flower.platform@gmail.com" class="text-white">flora.flower.platform@gmail.com</a></small>
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
                            <a href="home" class="nav-item nav-link active">Home</a>
                            <a href="shoppingAction" class="nav-item nav-link">Products</a>
                            <a href="searchAction?navbarShop=1" class="nav-item nav-link">Shop</a>
                            <a href="event" class="nav-item nav-link">Event</a>
                            <a href="contactPage" class="nav-item nav-link">Contact</a>
                            <!--        Session Management  -->
                            <c:if test="${not empty sessionScope.USER}">
                                <!--                Manager Session-->
                                <c:if test="${sessionScope.USER.role == 'Admin'}">
                                    <a href="monthlyBoard" class="nav-item nav-link">DashBoard</a>
                                </c:if>
                                <!--                Delivery Session-->
                                <c:if test="${sessionScope.USER.role == 'Delivery'}">
                                    <a href="delivererOrders" class="nav-item nav-link">Delivery Management</a>
                                    <a href="deliveryIncome" class="nav-item nav-link">Revenue</a>
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
                                        <img src="img/avatar.png" alt="User Avatar" class="rounded-circle" width="60">${sessionScope.USER.fullName}
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
            <h1 class="text-center text-white display-6">Check Out</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="home">Home</a></li>
                <li class="breadcrumb-item"><a href="eventCart">Cart</a></li>
                <li class="breadcrumb-item active text-white">Check Out</li>
            </ol>
        </div>
        <!-- Single Page Header End -->


        <!-- Checkout Page Start -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <h1 class="mb-4">Checkout Information</h1>
                <form action="shopCheckouts" method="POST">
                    <div class="row g-5">
                        <div class="col-md-12 col-lg-6 col-xl-6">
                            <div class="form-item">
                                <label class="form-label my-3">Full name<sup class="red">*</sup></label>
                                <input type="text" name="fullname" value="${sessionScope.USER.fullName}" id="fullname" class="form-control"  pattern=".*\S+.*"  title="Không được phép có khoảng trắng" required="">
                            </div>
                            <div class="form-item">
                                <label class="form-label my-3">Phone<sup class="red">*</sup></label>
                                <input type="tel" name="phone" value="${sessionScope.USER.phone}" id="phone" class="form-control" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" required="">
                            </div>
                            <div class="form-item">
                                <label class="form-label my-3">Address <sup class="red">*</sup></label>
                                <input type="text" name="address" value="${sessionScope.USER.street}" id="address" class="form-control" pattern=".*\S+.*" title="Không được phép có khoảng trắng" required="">
                            </div>
                            <div class="form-item">
                                <label class="form-label my-3">City<sup class="red">*</sup></label>
                                <select class="form-control" name="city" id="city" style="background-color: #ffffff" required="">
                                    <option value=""  selected disabled>Select city</option>
                                    <option value="An Giang"
                                            <c:if test="${sessionScope.USER.city == 'An Giang'}">
                                                selected="selected"
                                            </c:if>>An Giang</option>
                                    <option value="Bà Rịa Vũng Tàu"
                                            <c:if test="${sessionScope.USER.city == 'Bà Rịa Vũng Tàu'}">
                                                selected="selected"
                                            </c:if>>Bà Rịa Vũng Tàu</option>
                                    <option value="Bắc Giang"
                                            <c:if test="${sessionScope.USER.city == 'Bắc Giang'}">
                                                selected="selected"
                                            </c:if>>Bắc Giang</option>
                                    <option value="Bắc Kạn"
                                            <c:if test="${sessionScope.USER.city == 'Bắc Kạn'}">
                                                selected="selected"
                                            </c:if>>Bắc Kạn</option>
                                    <option value="Bạc Liêu"
                                            <c:if test="${sessionScope.USER.city == 'Bạc Liêu'}">
                                                selected="selected"
                                            </c:if>>Bạc Liêu</option>
                                    <option value="Bắc Ninh"
                                            <c:if test="${sessionScope.USER.city == 'Bắc Ninh'}">
                                                selected="selected"
                                            </c:if>>Bắc Ninh</option>
                                    <option value="Bến Tre"
                                            <c:if test="${sessionScope.USER.city == 'Bến Tre'}">
                                                selected="selected"
                                            </c:if>>Bến Tre</option>
                                    <option value="Bình Định"
                                            <c:if test="${sessionScope.USER.city == 'Bình Định'}">
                                                selected="selected"
                                            </c:if>>Bình Định</option>
                                    <option value="Bình Dương"
                                            <c:if test="${sessionScope.USER.city == 'Bình Dương'}">
                                                selected="selected"
                                            </c:if>>Bình Dương</option>
                                    <option value="Bình Phước"
                                            <c:if test="${sessionScope.USER.city == 'Bình Phước'}">
                                                selected="selected"
                                            </c:if>>Bình Phước</option>
                                    <option value="Bình Thuận"
                                            <c:if test="${sessionScope.USER.city == 'Bình Thuận'}">
                                                selected="selected"
                                            </c:if>>Bình Thuận</option>
                                    <option value="Cà Mau"
                                            <c:if test="${sessionScope.USER.city == 'Cà Mau'}">
                                                selected="selected"
                                            </c:if>>Cà Mau</option>
                                    <option value="Cần Thơ"
                                            <c:if test="${sessionScope.USER.city == 'Cần Thơ'}">
                                                selected="selected"
                                            </c:if>>Cần Thơ</option>
                                    <option value="Cao Bằng"
                                            <c:if test="${sessionScope.USER.city == 'Cao Bằng'}">
                                                selected="selected"
                                            </c:if>>Cao Bằng</option>
                                    <option value="Đà Nẵng"
                                            <c:if test="${sessionScope.USER.city == 'Đà Nẵng'}">
                                                selected="selected"
                                            </c:if>>Đà Nẵng</option>
                                    <option value="Đắk Lắk"
                                            <c:if test="${sessionScope.USER.city == 'Đắk Lắk'}">
                                                selected="selected"
                                            </c:if>>Đắk Lắk</option>
                                    <option value="Đắk Nông"
                                            <c:if test="${sessionScope.USER.city == 'Đắk Nông'}">
                                                selected="selected"
                                            </c:if>>Đắk Nông</option>
                                    <option value="Điện Biên"
                                            <c:if test="${sessionScope.USER.city == 'Điện Biên'}">
                                                selected="selected"
                                            </c:if>>Điện Biên</option>
                                    <option value="Đồng Nai"
                                            <c:if test="${sessionScope.USER.city == 'Đồng Nai'}">
                                                selected="selected"
                                            </c:if>>Đồng Nai</option>
                                    <option value="Đồng Tháp"
                                            <c:if test="${sessionScope.USER.city == 'Đồng Tháp'}">
                                                selected="selected"
                                            </c:if>>Đồng Tháp</option>
                                    <option value="Gia Lai"
                                            <c:if test="${sessionScope.USER.city == 'Gia Lai'}">
                                                selected="selected"
                                            </c:if>>Gia Lai</option>
                                    <option value="Hà Giang"
                                            <c:if test="${sessionScope.USER.city == 'Hà Giang'}">
                                                selected="selected"
                                            </c:if>>Hà Giang</option>
                                    <option value="Hà Nam"
                                            <c:if test="${sessionScope.USER.city == 'Hà Nam'}">
                                                selected="selected"
                                            </c:if>>Hà Nam</option>
                                    <option value="Hà Nội"
                                            <c:if test="${sessionScope.USER.city == 'Hà Nội'}">
                                                selected="selected"
                                            </c:if>>Hà Nội</option>
                                    <option value="Hà Tĩnh"
                                            <c:if test="${sessionScope.USER.city == 'Hà Tĩnh'}">
                                                selected="selected"
                                            </c:if>>Hà Tĩnh</option>
                                    <option value="Hải Dương"
                                            <c:if test="${sessionScope.USER.city == 'Hải Dương'}">
                                                selected="selected"
                                            </c:if>>Hải Dương</option>
                                    <option value="Hải Phòng"
                                            <c:if test="${sessionScope.USER.city == 'Hải Phòng'}">
                                                selected="selected"
                                            </c:if>>Hải Phòng</option>
                                    <option value="Hậu Giang"
                                            <c:if test="${sessionScope.USER.city == 'Hậu Giang'}">
                                                selected="selected"
                                            </c:if>>Hậu Giang</option>
                                    <option value="Hồ Chí Minh"
                                            <c:if test="${sessionScope.USER.city == 'Hồ Chí Minh'}">
                                                selected="selected"
                                            </c:if>>Hồ Chí Minh</option>
                                    <option value="Hòa Bình"
                                            <c:if test="${sessionScope.USER.city == 'Hòa Bình'}">
                                                selected="selected"
                                            </c:if>>Hòa Bình</option>
                                    <option value="Hưng Yên"
                                            <c:if test="${sessionScope.USER.city == 'Hưng Yên'}">
                                                selected="selected"
                                            </c:if>>Hưng Yên</option>
                                    <option value="Khánh Hòa"
                                            <c:if test="${sessionScope.USER.city == 'Khánh Hòa'}">
                                                selected="selected"
                                            </c:if>>Khánh Hòa</option>
                                    <option value="Kiên Giang"
                                            <c:if test="${sessionScope.USER.city == 'Kiên Giang'}">
                                                selected="selected"
                                            </c:if>>Kiên Giang</option>
                                    <option value="Kon Tum"
                                            <c:if test="${sessionScope.USER.city == 'Kon Tum'}">
                                                selected="selected"
                                            </c:if>>Kon Tum</option>
                                    <option value="Lai Châu"
                                            <c:if test="${sessionScope.USER.city == 'Lai Châu'}">
                                                selected="selected"
                                            </c:if>>Lai Châu</option>
                                    <option value="Lâm Đồng"
                                            <c:if test="${sessionScope.USER.city == 'Lâm Đồng'}">
                                                selected="selected"
                                            </c:if>>Lâm Đồng</option>
                                    <option value="Lạng Sơn"
                                            <c:if test="${sessionScope.USER.city == 'Lạng Sơn'}">
                                                selected="selected"
                                            </c:if>>Lạng Sơn</option>
                                    <option value="Lào Cai"
                                            <c:if test="${sessionScope.USER.city == 'Lào Cai'}">
                                                selected="selected"
                                            </c:if>>Lào Cai</option>
                                    <option value="Long An"
                                            <c:if test="${sessionScope.USER.city == 'Long An'}">
                                                selected="selected"
                                            </c:if>>Long An</option>
                                    <option value="Nam Định"
                                            <c:if test="${sessionScope.USER.city == 'Nam Định'}">
                                                selected="selected"
                                            </c:if>>Nam Định</option>
                                    <option value="Nghệ An"
                                            <c:if test="${sessionScope.USER.city == 'Nghệ An'}">
                                                selected="selected"
                                            </c:if>>Nghệ An</option>
                                    <option value="Ninh Bình"
                                            <c:if test="${sessionScope.USER.city == 'Ninh Bình'}">
                                                selected="selected"
                                            </c:if>>Ninh Bình</option>
                                    <option value="Ninh Thuận"
                                            <c:if test="${sessionScope.USER.city == 'Ninh Thuận'}">
                                                selected="selected"
                                            </c:if>>Ninh Thuận</option>
                                    <option value="Phú Thọ"
                                            <c:if test="${sessionScope.USER.city == 'Phú Thọ'}">
                                                selected="selected"
                                            </c:if>>Phú Thọ</option>
                                    <option value="Phú Yên"
                                            <c:if test="${sessionScope.USER.city == 'Phú Yên'}">
                                                selected="selected"
                                            </c:if>>Phú Yên</option>
                                    <option value="Quảng Bình"
                                            <c:if test="${sessionScope.USER.city == 'Quảng Bình'}">
                                                selected="selected"
                                            </c:if>>Quảng Bình</option>
                                    <option value="Quảng Nam"
                                            <c:if test="${sessionScope.USER.city == 'Quảng Nam'}">
                                                selected="selected"
                                            </c:if>>Quảng Nam</option>
                                    <option value="Quảng Ngãi"
                                            <c:if test="${sessionScope.USER.city == 'Quảng Ngãi'}">
                                                selected="selected"
                                            </c:if>>Quảng Ngãi</option>
                                    <option value="Quảng Ninh"
                                            <c:if test="${sessionScope.USER.city == 'Quảng Ninh'}">
                                                selected="selected"
                                            </c:if>>Quảng Ninh</option>
                                    <option value="Quảng Trị"
                                            <c:if test="${sessionScope.USER.city == 'Quảng Trị'}">
                                                selected="selected"
                                            </c:if>>Quảng Trị</option>
                                    <option value="Sóc Trăng"
                                            <c:if test="${sessionScope.USER.city == 'Sóc Trăng'}">
                                                selected="selected"
                                            </c:if>>Sóc Trăng</option>
                                    <option value="Sơn La"
                                            <c:if test="${sessionScope.USER.city == 'Sơn La'}">
                                                selected="selected"
                                            </c:if>>Sơn La</option>
                                    <option value="Tây Ninh"
                                            <c:if test="${sessionScope.USER.city == 'Tây Ninh'}">
                                                selected="selected"
                                            </c:if>>Tây Ninh</option>
                                    <option value="Thái Bình"
                                            <c:if test="${sessionScope.USER.city == 'Thái Bình'}">
                                                selected="selected"
                                            </c:if>>Thái Bình</option>
                                    <option value="Thái Nguyên"
                                            <c:if test="${sessionScope.USER.city == 'Thái Nguyên'}">
                                                selected="selected"
                                            </c:if>>Thái Nguyên</option>
                                    <option value="Thanh Hóa"
                                            <c:if test="${sessionScope.USER.city == 'Thanh Hóa'}">
                                                selected="selected"
                                            </c:if>>Thanh Hóa</option>
                                    <option value="Thủ Đức"
                                            <c:if test="${sessionScope.USER.city == 'Thủ Đức'}">
                                                selected="selected"
                                            </c:if>>Thủ Đức</option>
                                    <option value="Thừa Thiên Huế"
                                            <c:if test="${sessionScope.USER.city == 'Thừa Thiên Huế'}">
                                                selected="selected"
                                            </c:if>>Thừa Thiên - Huế</option>
                                    <option value="Tiền Giang"
                                            <c:if test="${sessionScope.USER.city == 'Tiền Giang'}">
                                                selected="selected"
                                            </c:if>>Tiền Giang</option>
                                    <option value="Trà Vinh"
                                            <c:if test="${sessionScope.USER.city == 'Trà Vinh'}">
                                                selected="selected"
                                            </c:if>>Trà Vinh</option>
                                    <option value="Tuyên Quang"
                                            <c:if test="${sessionScope.USER.city == 'Tuyên Quang'}">
                                                selected="selected"
                                            </c:if>>Tuyên Quang</option>
                                    <option value="Vĩnh Long"
                                            <c:if test="${sessionScope.USER.city == 'Vĩnh Long'}">
                                                selected="selected"
                                            </c:if>>Vĩnh Long</option>
                                    <option value="Vĩnh Phúc"
                                            <c:if test="${sessionScope.USER.city == 'Vĩnh Phúc'}">
                                                selected="selected"
                                            </c:if>>Vĩnh Phúc</option>
                                    <option value="Yên Bái"
                                            <c:if test="${sessionScope.USER.city == 'Yên Bái'}">
                                                selected="selected"
                                            </c:if>>Yên Bái</option>
                                </select>
                            </div>

                            <hr>
                            <h3>Shipping method</h3>
                            <div class="form-item">
                                <label class="form-control radio-shipping" style="background-color: #ffffff">
                                    <input type="radio" name="shipping" value="Delivery" class="radio radio-inline" required="" checked="">
                                    Delivery to your door
                                </label>
                                <label class="form-control radio-shipping" style="background-color: #ffffff">
                                    <input type="radio" name="shipping" value="Pick Up" class="radio radio-inline" required="">
                                    Pick up at point of sale
                                </label>
                            </div>
                            <hr>
                            <h3>Payment method</h3>
                            <div class="form-item">
                                <label class="form-control radio-shipping" style="background-color: #ffffff">
                                    <input type="radio" name="payment" value="COD" class="radio radio-inline" required="" checked="">
                                    <i class="fa-solid fa-money-bill"></i> Cash on Delivery (COD)
                                </label>
                                <label class="form-control radio-shipping" style="background-color: #ffffff">
                                    <input type="radio" name="payment" value="ONLINE" class="radio radio-inline" required="">
                                    <i class="fa-solid fa-credit-card"></i> Online Payment (VN Pay)
                                </label>
                            </div>
                            <hr>
                            <label class="form-label my-3">Note</label>
                            <div class="form-item">
                                <textarea name="note" rows="4" cols="50" class="form-control"></textarea>
                            </div>
                        </div>
                        <c:set var="cart" value="${sessionScope.CART}"/>
                        <div class="col-md-12 col-lg-6 col-xl-6">
                            <div class="table-responsive">
                                <c:forEach var="entry" items="${cart.items}">
                                    <c:set var="storeId" value="${entry.key}"/>
                                    <c:set var="storeItems" value="${entry.value}"/>
                                    <h3>Shop: ${storeId}</h3>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Product</th>
                                                <th scope="col">Name</th>
                                                <th scope="col" style="text-align: center">Unit price</th>
                                                <th scope="col" style="text-align: center">Quantity</th>
                                                <th scope="col" style="text-align: center">Total amount</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="totalShop" value="0"/>
                                            <c:forEach var="item" items="${storeItems}" varStatus="counter">
                                                <c:set var="totalShop" value="${totalShop + (item.unitPrice * item.quantity)}"/>
                                                <tr>
                                                    <th scope="row">
                                                        <div class="d-flex align-items-center mt-2">
                                                            <img src="${item.imageURL}" class="img-fluid rounded-circle" style="width: 90px; height: 90px;" alt="">
                                                        </div>
                                                    </th>
                                                    <td class="py-5">${item.name}</td>
                                                    <td class="py-5"><fmt:formatNumber value="${item.unitPrice}" type="number" groupingUsed="true"/>đ</td>
                                                    <td class="py-5" style="text-align: center">${item.quantity}</td>
                                                    <td class="py-5" style="text-align: center"><fmt:formatNumber value="${item.quantity * item.unitPrice}" type="number" groupingUsed="true"/>đ</td>
                                                </tr>      
                                            </c:forEach>                                
                                            <tr>
                                                <th scope="row">
                                                </th>
                                                <td class="py-5">
                                                    <p class="mb-0 text-dark py-3">Total amount:</p>
                                                </td>
                                                <td class="py-5"></td>
                                                <td class="py-5"></td>
                                                <td class="py-5">
                                                    <div class="py-2 border-bottom border-top">
                                                        <p class="mb-0 text-dark" style="text-align: center"><fmt:formatNumber value="${totalShop}" type="number" groupingUsed="true"/>đ</p>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </c:forEach>
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th scope="row">
                                            </th>
                                            <td class="py-5">
                                                <p class="mb-0 text-dark py-3">Total cost of goods:</p>
                                            </td>
                                            <td class="py-5"></td>
                                            <td class="py-5"></td>
                                            <td class="py-5">
                                                <div class="py-2 border-bottom border-top">
                                                    <p class="mb-0 text-dark"  style="text-align: center"><fmt:formatNumber value="${requestScope.TOTAL_AMOUNT}" type="number" groupingUsed="true"/>đ</p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="row">
                                            </th>
                                            <td class="py-5">
                                                <p class="mb-0 text-dark py-3">Discount:</p>
                                            </td>
                                            <td class="py-5"></td>
                                            <td class="py-5"></td>
                                            <td class="py-5">
                                                <div class="py-2 border-bottom border-top">
                                                    <p class="mb-0 text-dark"  style="text-align: center">0%</p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="row">
                                            </th>
                                            <td class="py-5">
                                                <h3 class="mb-0 text-dark text-uppercase py-3">Total payment:</h3>
                                            </td>
                                            <td class="py-5"></td>
                                            <td class="py-5"></td>
                                            <td class="py-5">
                                                <div class="py-2 border-bottom border-top">
                                                    <h3 class="mb-0 text-dark"  style="text-align: center"><fmt:formatNumber value="${requestScope.TOTAL_AMOUNT}" type="number" groupingUsed="true"/>đ</h3>
                                                    <input type="hidden" name="totalamount" value="${requestScope.TOTAL_AMOUNT}"/>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row g-4 text-center align-items-center justify-content-center pt-4">
                                <button type="submit" class="btn border-secondary py-3 px-4 text-uppercase w-100 text-third">Place Order</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- Checkout Page End -->


        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->

        <!-- Copyright Start -->
        <div class="container-fluid copyright bg-dark py-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        <span class="text-light"><a href="#"><i class="fas fa-copyright text-light me-2"></i>Flora Rewind</a>, All right reserved.</span>
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
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="https://kit.fontawesome.com/4cb3201524.js" crossorigin="anonymous"></script>

        <!-- Template Javascript -->
        <script src="js/newProduct.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>
