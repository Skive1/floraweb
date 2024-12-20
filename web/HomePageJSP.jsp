<%-- 
    Document   : HomePageJSP
    Created on : Sep 14, 2024, 12:49:07 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Flora Rewind | Buy and sell on the website</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <script src="https://kit.fontawesome.com/4cb3201524.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.14/dist/sweetalert2.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/snackbar.css">
        <link href="css/editbutton.css" rel="stylesheet">
        <link href="css/indicator.css" rel="stylesheet">
        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <style>
            .custom-text {
                color: #ffffff; 
                background-color: #6c757d; 
                padding: 10px 15px; 
                border-radius: 5px; 
                font-size: 1.2rem; 
                font-weight: 600; 
                text-align: center; 
            }

            .fruite-item {
                display: flex; 
                flex-direction: column; 
                height: auto; 
                border: 1px solid #ced4da; 
            }

            .fruite-img {
                height: 300px; 
                overflow: hidden; 
            }

            .fruite-img img {
                width: 100%; 
                height: 100%; 
                object-fit: cover; 
            }

            .product-description {
                flex-grow: 1; 
                display: flex; 
                flex-direction: column;
                justify-content: space-between;  
            }

            .product-description h4 {
                margin: 0;
            }

            .product-description p {
                margin: 0; 
                flex-grow: 1; 
                display: flex; 
                align-items: center; 
                justify-content: flex-start; 
                min-height: 60px; 
            }


            .product-description p {
                flex-grow: 1; 
                max-height: 100px; 
                overflow: hidden; 
                text-overflow: ellipsis; 
                white-space: nowrap; 
            }           
            .custom-orange-border {
                border: 2px solid orange; 
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
                            <span id="search-icon-1" class="input-group-text p-3"><i style="width: 30px" class="fa fa-search"></i></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Search End -->


        <!-- Hero Start -->
        <div class="container-fluid py-5 mb-5 hero-header">
            <div class="container py-5">
                <div class="row g-5 align-items-center">
                    <div class="col-md-12 col-lg-7">
                        <h4 class="mb-3 text-secondary text-shadow display-3">Flora Rewind Platform</h4>      
                        <c:set var="user" value="${sessionScope.USER.fullName}"/>
                        <c:if test="${empty user}">
                            <h1 class="mb-5 display-3 text-primary text-shadow">Welcome to Flora</h1>
                        </c:if>   
                        <c:if test="${not empty user}">
                            <h1 class="mb-5 display-3 text-primary text-shadow">Hi, <c:out value ="${sessionScope.USER.fullName}"/></h1>
                            <h1 class="mb-5 display-3 text-primary text-shadow">Welcome to Flora</h1>
                        </c:if>                     
                    </div>
                    <div class="col-md-12 col-lg-5">
                        <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active rounded">
                                    <img src="img/FloraDelivery.png" class="img-fluid w-100 h-100 bg-secondary rounded" alt="First slide">
                                    <a href="#" class="btn px-4 py-2 text-white rounded">Delivery</a>
                                </div>
                                <div class="carousel-item rounded">
                                    <img src="img/service247.png" class="img-fluid w-100 h-100 rounded" alt="Second slide">
                                    <a href="#" class="btn px-4 py-2 text-white rounded">CSKH 24/7</a>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->


        <!-- Featurs Section Start -->
        <div class="container-fluid featurs py-5">
            <div class="container py-5">
                <div class="row g-4">
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-car-side fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Free Shipping</h5>
                                <p class="mb-0">Free shipping for every order</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-user-shield fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Security Payment</h5>
                                <p class="mb-0">100% security payment</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-exchange-alt fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>30 Day Return</h5>
                                <p class="mb-0">30 day money guarantee</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fa fa-phone-alt fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>24/7 Support</h5>
                                <p class="mb-0">Support every time fast</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featurs Section End -->


        <!-- Fruits Shop Start-->
        <div class="container-fluid fruite py-5">
            <div class="container py-5">
                <div class="tab-class text-center">
                    <div class="row g-4" style="margin-bottom: 35px">
                        <div class="col-lg-4 text-start">
                            <h1>Best Seller Flowers:</h1>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane fade show p-0 active">
                            <div class="row g-4">
                                <div class="col-lg-12">
                                    <div class="row g-4">
                                        <c:forEach items="${requestScope.BEST_SELLER}" var="flower">
                                            <div class="col-md-6 col-lg-4 col-xl-3">
                                                <form action="cartAddItem">
                                                    <input type="hidden" name="page" value="DETAIL_PAGE">
                                                    <div class="rounded position-relative fruite-item">
                                                        <div class="fruite-img">
                                                            <img src="${flower.eventProductImg}" class="img-fluid w-100 rounded-top" alt="">
                                                        </div>
                                                        <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;"><c:out value ="${flower.eventProductType}"/></div>
                                                        <!--<div class="p-4 border border-secondary border-top-0 rounded-bottom">-->
                                                        <div class="p-4 custom-orange-border p-3 border-top-0 rounded-bottom">
                                                            <c:url var="urlRewriting" value="flowerDetail">
                                                                <c:param name="productId" value="${flower.eventProductId}"/>
                                                                <c:param name="eventId" value="${flower.eventEventId}"/>
                                                            </c:url>
                                                            <a href="${urlRewriting}">
                                                                <h4 style="height: 50px"><c:out value ="${flower.eventProductName}"/></h4>
                                                            </a>
                                                            <p style="height: 80px">${flower.eventProductDetail}</p>
                                                            <!-- Hidden inputs to pass product details to the servlet -->
                                                            <input type="hidden" name="productId" value="${flower.eventProductId}">
                                                            <input type="hidden" name="eventId" value="${flower.eventEventId}">
                                                            <input type="hidden" name="imageURL" value="${flower.eventProductImg}">
                                                            <input type="hidden" name="productName" value="${flower.eventProductName}">
                                                            <input type="hidden" name="productPrice" value="${flower.eventProductPrice}">
                                                            <input type="hidden" name="productQuantity" value="${flower.eventProductQuantity}">
                                                            <input type="hidden" name="itemQuantity" value="1">
                                                            <div class="d-flex justify-content-between flex-lg-wrap">
                                                                <p class="text-dark fs-5 fw-bold mb-0">
                                                                    <fmt:formatNumber value="${flower.eventProductPrice}" type="number" groupingUsed="true"/>đ
                                                                </p>
                                                                <a href="${urlRewriting}" class="btn border border-secondary rounded-pill px-3 text-third">
                                                                    <i class="fa fa-shopping-bag me-2 text-third"></i> View details
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>  
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>      
            </div>
        </div>
        <!-- Fruits Shop End-->


        <!-- Featurs Start -->
        <div class="container-fluid service py-5">
            <div class="container py-5">
                <div class="row g-4 justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="service-item bg-secondary rounded border border-secondary">
                            <img src="img/eventwaste.png" class="img-fluid rounded-top w-100" alt="">
                            <div class="px-5 rounded-bottom">

                            </div>
                        </div>

                    </div>
                    <div class="col-md-6 col-lg-4">

                        <div class="service-item bg-dark rounded border border-dark">
                            <img src="img/surplusFlower.png" class="img-fluid rounded-top w-100" alt="">
                            <div class="px-4 rounded-bottom">

                            </div>
                        </div>

                    </div>
                    <div class="col-md-6 col-lg-4">

                        <div class="service-item bg-secondary rounded border border-secondary">
                            <img src="img/trader.png" class="img-fluid rounded-top w-100" alt="">
                            <div class="px-5 rounded-bottom">

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- Featurs End -->


        <!-- Vesitable Shop Start-->
        <div class="container-fluid vesitable py-5">
            <div class="container py-5">
                <h1 class="mb-0">New Arrival Flowers:</h1>
                <div class="owl-carousel vegetable-carousel justify-content-center">
                    <c:forEach items="${requestScope.NEW_ARRIVAL}" var="flower">
                        <form action="cartAddItem">
                            <input type="hidden" name="page" value="DETAIL_PAGE">
                            <div class="border border-primary rounded position-relative vesitable-item">
                                <div class="fruite-img">
                                    <img src="${flower.eventProductImg}" class="img-fluid w-100 rounded-top" alt="">
                                </div>
                                <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style="top: 10px; right: 10px;"><c:out value ="${flower.eventProductType}"/></div>
                                <div class="p-4 rounded-bottom">
                                    <c:url var="urlRewriting" value="flowerDetail">
                                        <c:param name="productId" value="${flower.eventProductId}"/>
                                        <c:param name="eventId" value="${flower.eventEventId}"/>
                                    </c:url>
                                    <a href="${urlRewriting}">
                                        <h4><c:out value ="${flower.eventProductName}"/></h4>
                                    </a>
                                    <p style="height: 50px">${flower.eventProductDetail}</p>
                                    <!-- Hidden inputs to pass product details to the servlet -->
                                    <input type="hidden" name="productId" value="${flower.eventProductId}">
                                    <input type="hidden" name="eventId" value="${flower.eventEventId}">
                                    <input type="hidden" name="imageURL" value="${flower.eventProductImg}">
                                    <input type="hidden" name="productName" value="${flower.eventProductName}">
                                    <input type="hidden" name="productPrice" value="${flower.eventProductPrice}">
                                    <input type="hidden" name="productQuantity" value="${flower.eventProductQuantity}">
                                    <input type="hidden" name="itemQuantity" value="1">
                                    <div class="d-flex justify-content-between flex-lg-wrap">
                                        <p class="text-dark fs-5 fw-bold mb-0">
                                            <fmt:formatNumber value="${flower.eventProductPrice}" type="number" groupingUsed="true" />đ
                                        </p>
                                        <a href="${urlRewriting}" class="btn border border-secondary rounded-pill px-3 text-third">
                                            <i class="fa fa-shopping-bag me-2 text-third"></i> View details
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- Vesitable Shop End -->


        <!-- Banner Section Start-->
        <div class="container-fluid banner bg-secondary my-5">
            <div class="container py-5">
                <div class="row g-4 align-items-center">
                    <c:set var="flower" value="${requestScope.CHEAPEST_FLOWER}"/>
                    <div class="col-lg-6">
                        <div class="py-4">
                            <h1 class="display-2 text-white">Cheapest Flowers:</h1>
                            <p class="fw-normal display-3 text-dark mb-4"><c:out value ="${flower.eventProductName}"/></p>
                            <p class="mb-4 text-dark display-6">Type: <c:out value ="${flower.eventProductType}"/></p>
                            <c:url var="urlRewriting" value="flowerDetail">
                                <c:param name="productId" value="${flower.eventProductId}"/>
                                <c:param name="eventId" value="${flower.eventEventId}"/>
                            </c:url>
                            <a href="${urlRewriting}" class="banner-btn btn border-2 border-white rounded-pill text-dark py-3 px-5">View</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="position-relative">
                            <img src="${flower.eventProductImg}" class="img-fluid rounded" alt="" style="border-radius: 50%; width: 500px">
                            <div class="d-flex align-items-center justify-content-center bg-white rounded-circle position-absolute" style="width: 140px; height: 140px; top: 0; left: 0;">
                                <h2 style="font-size: 30px;"><fmt:formatNumber value="${flower.eventProductPrice}" type="number" groupingUsed="true" />đ</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Banner Section End -->

        <!-- Fact Start -->
        <div class="container-fluid py-5">
            <div class="container">
                <div class="bg-light p-5 rounded">
                    <div class="row g-4 justify-content-center">
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>satisfied customers</h4>
                                <h1>1963</h1>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>quality of service</h4>
                                <h1>99%</h1>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>quality certificates</h4>
                                <h1>33</h1>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>Available Flowers</h4>
                                <h1>789</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fact Start -->


        <!-- Tastimonial Start -->
        <div class="container-fluid testimonial py-5" id="aboutUs">
            <div class="container py-5">
                <div class="testimonial-header text-center">
                    <h4 class="text-third">Information</h4>
                    <h1 class="display-5 mb-5 text-dark">Development Team</h1>
                </div>
                <div class="owl-carousel testimonial-carousel">
                    <div class="testimonial-item img-border-radius bg-light rounded p-4">
                        <div class="position-relative">
                            <i class="fa fa-quote-right fa-2x text-secondary position-absolute" style="bottom: 30px; right: 0;"></i>
                            <div class="mb-4 pb-4 border-bottom border-secondary">
                                <p class="mb-0 custom-text">Back-End Developer
                                </p>
                            </div>
                            <div class="d-flex align-items-center flex-nowrap">
                                <div class="bg-secondary rounded">
                                    <img src="avatar/lgb.jpg" class="img-fluid rounded" style="width: 100px; height: 100px;" alt="">
                                </div>
                                <div class="ms-4 d-block">
                                    <h4 class="text-dark">Lữ Gia Bảo</h4>
                                    <p class="m-0 pb-3">SE182759</p>
                                    <div class="d-flex pe-5">
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="testimonial-item img-border-radius bg-light rounded p-4">
                        <div class="position-relative">
                            <i class="fa fa-quote-right fa-2x text-secondary position-absolute" style="bottom: 30px; right: 0;"></i>
                            <div class="mb-4 pb-4 border-bottom border-secondary">
                                <p class="mb-0 custom-text">Leader
                                </p>
                            </div>
                            <div class="d-flex align-items-center flex-nowrap">
                                <div class="bg-secondary rounded">
                                    <img src="avatar/pmt.jpg" class="img-fluid rounded" style="width: 100px; height: 100px;" alt="">
                                </div>
                                <div class="ms-4 d-block">
                                    <h4 class="text-dark">Phạm Minh Tuấn</h4>
                                    <p class="m-0 pb-3">SE182869</p>
                                    <div class="d-flex pe-5">
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="testimonial-item img-border-radius bg-light rounded p-4">
                        <div class="position-relative">
                            <i class="fa fa-quote-right fa-2x text-secondary position-absolute" style="bottom: 30px; right: 0;"></i>
                            <div class="mb-4 pb-4 border-bottom border-secondary">
                                <p class="mb-0 custom-text">Back-End Developer
                                </p>
                            </div>
                            <div class="d-flex align-items-center flex-nowrap">
                                <div class="bg-secondary rounded">
                                    <img src="avatar/nnt.jpg" class="img-fluid rounded" style="width: 100px; height: 100px;" alt="">
                                </div>
                                <div class="ms-4 d-block">
                                    <h4 class="text-dark">Nguyễn Ngọc Trai</h4>
                                    <p class="m-0 pb-3">SE182916</p>
                                    <div class="d-flex pe-5">
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="testimonial-item img-border-radius bg-light rounded p-4">
                        <div class="position-relative">
                            <i class="fa fa-quote-right fa-2x text-secondary position-absolute" style="bottom: 30px; right: 0;"></i>
                            <div class="mb-4 pb-4 border-bottom border-secondary">
                                <p class="mb-0 custom-text">Back-End Developer
                                </p>
                            </div>
                            <div class="d-flex align-items-center flex-nowrap">
                                <div class="bg-secondary rounded">
                                    <img src="avatar/hak.jpg" class="img-fluid rounded" style="width: 100px; height: 100px;" alt="">
                                </div>
                                <div class="ms-4 d-block">
                                    <h4 class="text-dark">Hà Anh Khang</h4>
                                    <p class="m-0 pb-3">SE182765</p>
                                    <div class="d-flex pe-5">
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                        <i class="fas fa-star text-third"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Tastimonial End -->


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
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.14/dist/sweetalert2.all.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/lightbox/js/lightbox.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>

            <!-- Template Javascript -->
        <c:if test="${requestScope.LOGIN_SUCCESS_ALERT == true}">
            <script>
                Swal.fire({
                    icon: 'success',
                    title: 'Login Successful!',
                    text: 'Welcome ${sessionScope.USER.fullName}!',
                    showConfirmButton: false,
                    timer: 1500
                });
                
                window.onload = function (){
                    const newURL = window.location.protocol + "//" + window.location.host + window.location.pathname;
                    window.history.replaceState({}, document.title, newURL);
                };
            </script>
        </c:if>
        <c:if test="${not empty sessionScope.USER}">
            <script src="js/notification.js"></script>
        </c:if>
        <script src="js/main.js"></script>
        <script src="js/newProduct.js"></script>
    </body>

</html>