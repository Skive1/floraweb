<%-- 
    Document   : purchasedOrder
    Created on : Oct 20, 2024, 8:50:57 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Đơn hàng | Buy and sell on the website</title>
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
        <link href="css/indicator.css" rel="stylesheet">
        <link rel="stylesheet" href="css/snackbar.css">
        <link rel="stylesheet" href="rateStar/ratecss.css">
        <link rel="stylesheet" href="alertPackage/alertCss.css">
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <style>
            .tab-pane{
                overflow-y: auto;
                max-height: 452px;

            }
            .tab-content{
                background-color: rgba(232, 233, 235, 0.3);
                margin-top: 0px;
                padding-top: 24px;
                padding-bottom: 24px;
                padding-left: 13px;
                padding-right: 13px;
                padding-bottom: 10px;
                min-height: 500px;
            }
            .button-nav{
                padding-right: 40px;
                padding-left: 40px;
            }
            .order-row{
                cursor: pointer;
            }
            .non-order{
                background-image: url(http://deo.shopeemobile.com/shopee/shopee-pcmall-live-sg/orderlist/5fafbb923393b712b964.png);
                background-position: 50%;
                background-repeat: no-repeat;
                background-size: contain;
                height: 100px;
                width: 100px

            }
            .background-img{
                display: flex;
                height: 400px;
                text-align: center;
                flex-direction: column;
                align-content: center;
                justify-content: center;
                align-items: center;
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
                        <a href="#" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                        <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
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
                            <a href="shoppingAction" class="nav-item nav-link">Sản phẩm</a>
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
            <h1 class="text-center text-white display-6">Đơn mua hàng của tôi</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="home">Home</a></li>
                <li class="breadcrumb-item active text-white">Đơn mua</li>
            </ol>
        </div>
        <!-- Single Page Header End -->


        <!-- Cart Page Start -->
        <div class="container-fluid py-5" style="background-color: ">
            <div class="container py-5">
                <nav>
                    <div class="nav nav-tabs justify-content-center">
                        <button class="nav-link border-white border-bottom-0 active button-nav" type="button" role="tab"
                                id="nav-pending-tab" data-bs-toggle="tab" data-bs-target="#nav-pending"
                                aria-controls="nav-pending" aria-selected="false">Đang chờ</button>
                        <button class="nav-link border-white border-bottom-0 button-nav" type="button" role="tab"
                                id="nav-verify-tab" data-bs-toggle="tab" data-bs-target="#nav-verify"
                                aria-controls="nav-verify" aria-selected="false">Đã xác nhận</button>
                        <button class="nav-link border-white border-bottom-0 button-nav" type="button" role="tab"
                                id="nav-ship-tab" data-bs-toggle="tab" data-bs-target="#nav-ship"
                                aria-controls="nav-ship" aria-selected="false">Chờ giao hàng</button>
                        <button class="nav-link border-white border-bottom-0 button-nav" type="button" role="tab"
                                id="nav-done-tab" data-bs-toggle="tab" data-bs-target="#nav-done"
                                aria-controls="nav-done" aria-selected="false">Đã giao</button>
                        <button class="nav-link border-white border-bottom-0 button-nav" type="button" role="tab"
                                id="nav-cancelled-tab" data-bs-toggle="tab" data-bs-target="#nav-cancelled"
                                aria-controls="nav-cancelled" aria-selected="false">Đã hủy</button>
                    </div>                   
                </nav>
                <div class="tab-content mb-5">
                    <div class="tab-pane active" id="nav-pending" role="tabpanel" aria-labelledby="nav-pending-tab">
                        <c:if test="${not empty requestScope.LIST_PENDING}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày đặt</th>
                                <th style="text-align: center">Hình thức thanh toán</th>
                                <th style="text-align: center">Hình thức vận chuyển</th>
                                <th style="text-align: center">Thanh toán</th>
                                <th style="text-align: center">Tổng tiền</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="pending" items="${requestScope.LIST_PENDING}">
                                        <tr class="order-row " data-order-id="${pending.eventOrderId}" 
                                            data-order-cust="${pending.fullname}" 
                                            data-cust-phone="${pending.phone}" 
                                            data-cust-street="${pending.street}"
                                            data-cust-city="${pending.city}"
                                            data-cust-note="${pending.note}"
                                            data-order-event="${pending.eventName}">
                                            <th scope="row">
                                                <div class="d-flex align-items-center justify-content-center mt-4">
                                                    <p class="">#ORD-${pending.eventOrderId}</p>
                                                </div>
                                            </th>
                                            <td>
                                                <p class="mb-4 mt-4" style="text-align: center"><fmt:formatDate value="${pending.orderDate}" pattern="dd/MM/yyyy"/></p>
                                            </td>
                                            <td>      
                                                <c:if test="${pending.paymentOptions == 'ONLINE'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chuyển khoản (VNPay)</p>
                                                </c:if>
                                                <c:if test="${pending.paymentOptions == 'COD'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Tiền mặt</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${pending.deliveryOptions == 'Delivery'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Giao hàng Flora</p>
                                                </c:if>
                                                <c:if test="${pending.deliveryOptions == 'Pick Up'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Lấy tại sự kiện</p>
                                                </c:if>
                                            </td>
                                            <td style="text-align: center">
                                                <c:if test="${pending.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: #00FF00; font-weight: bold">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${pending.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: red; font-weight: bold">Chưa thanh toán</p>
                                                </c:if>
                                                <button class="btn border-secondary rounded-pill px-4 py-3" style="text-align: center; color: red" onclick="cancelOrder(${pending.eventOrderId}, event)">Hủy đơn</button>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center; font-weight: bold"><fmt:formatNumber value="${pending.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_PENDING}">
                            <div class="background-img">
                                <div class="non-order"></div>
                                <h3 style="text-align: center">Chưa có đơn hàng</h3>
                            </div>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-verify" role="tabpanel" aria-labelledby="nav-verify-tab">
                        <c:if test="${not empty requestScope.LIST_CONFIRM}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày đặt</th>
                                <th style="text-align: center">Hình thức thanh toán</th>
                                <th style="text-align: center">Hình thức vận chuyển</th>
                                <th style="text-align: center">Thanh toán</th>
                                <th style="text-align: center">Tổng tiền</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="confirm" items="${requestScope.LIST_CONFIRM}">
                                        <tr class="order-row " data-order-id="${confirm.eventOrderId}" 
                                            data-order-cust="${confirm.fullname}" 
                                            data-cust-phone="${confirm.phone}" 
                                            data-cust-street="${confirm.street}"
                                            data-cust-city="${confirm.city}"
                                            data-cust-note="${confirm.note}"
                                            data-order-event="${confirm.eventName}">
                                            <th scope="row">
                                                <div class="d-flex align-items-center justify-content-center mt-4">
                                                    <p class="">#ORD-${confirm.eventOrderId}</p>
                                                </div>
                                            </th>
                                            <td>
                                                <p class="mb-4 mt-4" style="text-align: center"><fmt:formatDate value="${confirm.orderDate}" pattern="dd/MM/yyyy"/></p>
                                            </td>
                                            <td>      
                                                <c:if test="${confirm.paymentOptions == 'ONLINE'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chuyển khoản (VNPay)</p>
                                                </c:if>
                                                <c:if test="${confirm.paymentOptions == 'COD'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Tiền mặt</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${confirm.deliveryOptions == 'Delivery'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Giao hàng Flora</p>
                                                </c:if>
                                                <c:if test="${confirm.deliveryOptions == 'Pick Up'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Lấy tại sự kiện</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${confirm.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: #00FF00; font-weight: bold">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${confirm.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: red; font-weight: bold">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center; font-weight: bold"><fmt:formatNumber value="${confirm.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_CONFIRM}">
                            <div class="background-img">
                                <div class="non-order"></div>
                                <h3 style="text-align: center">Chưa có đơn hàng</h3>
                            </div>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-ship" role="tabpanel" aria-labelledby="nav-ship-tab">
                        <c:if test="${not empty requestScope.LIST_SHIPPING}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày đặt</th>
                                <th style="text-align: center">Hình thức thanh toán</th>
                                <th style="text-align: center">Hình thức vận chuyển</th>
                                <th style="text-align: center">Thanh toán</th>
                                <th style="text-align: center">Tổng tiền</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="shipping" items="${requestScope.LIST_SHIPPING}">
                                        <tr class="order-row " data-order-id="${shipping.eventOrderId}" 
                                            data-order-cust="${shipping.fullname}" 
                                            data-cust-phone="${shipping.phone}" 
                                            data-cust-street="${shipping.street}"
                                            data-cust-city="${shipping.city}"
                                            data-cust-note="${shipping.note}"
                                            data-order-event="${shipping.eventName}">
                                            <th scope="row">
                                                <div class="d-flex align-items-center justify-content-center mt-4">
                                                    <p class="">#ORD-${shipping.eventOrderId}</p>
                                                </div>
                                            </th>
                                            <td>
                                                <p class="mb-4 mt-4" style="text-align: center"><fmt:formatDate value="${shipping.orderDate}" pattern="dd/MM/yyyy"/></p>
                                            </td>
                                            <td>      
                                                <c:if test="${shipping.paymentOptions == 'ONLINE'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chuyển khoản (VNPay)</p>
                                                </c:if>
                                                <c:if test="${shipping.paymentOptions == 'COD'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Tiền mặt</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${shipping.deliveryOptions == 'Delivery'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Giao hàng Flora</p>
                                                </c:if>
                                                <c:if test="${shipping.deliveryOptions == 'Pick Up'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Lấy tại sự kiện</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${shipping.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: #00FF00; font-weight: bold">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${shipping.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: red; font-weight: bold">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center; font-weight: bold"><fmt:formatNumber value="${shipping.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_SHIPPING}">
                            <div class="background-img">
                                <div class="non-order"></div>
                                <h3 style="text-align: center">Chưa có đơn hàng</h3>
                            </div>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-done" role="tabpanel" aria-labelledby="nav-done-tab">
                        <c:if test="${not empty requestScope.LIST_RECEIVE}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày đặt</th>
                                <th style="text-align: center">Ngày nhận hàng</th>
                                <th style="text-align: center">Hình thức thanh toán</th>
                                <th style="text-align: center">Hình thức vận chuyển</th>
                                <th style="text-align: center">Thanh toán</th>
                                <th style="text-align: center">Tổng tiền</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="receive" items="${requestScope.LIST_RECEIVE}">
                                        <tr class="order-row " data-order-id="${receive.eventOrderId}" 
                                            data-order-cust="${receive.fullname}" 
                                            data-cust-phone="${receive.phone}" 
                                            data-cust-street="${receive.street}"
                                            data-cust-city="${receive.city}"
                                            data-cust-note="${receive.note}"
                                            data-order-event="${receive.eventName}">
                                            <th scope="row">
                                                <div class="d-flex align-items-center justify-content-center mt-4">
                                                    <p class="">#ORD-${receive.eventOrderId}</p>
                                                </div>
                                                <div class="d-flex align-items-center justify-content-center mt-4">

                                                </div>
                                            </th>
                                            <td>
                                                <p class="mb-4 mt-4" style="text-align: center"><fmt:formatDate value="${receive.orderDate}" pattern="dd/MM/yyyy"/></p>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4" style="text-align: center"><fmt:formatDate value="${receive.deliveryDate}" pattern="dd/MM/yyyy"/></p>
                                            </td>
                                            <td>      
                                                <c:if test="${receive.paymentOptions == 'ONLINE'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chuyển khoản (VNPay)</p>
                                                </c:if>
                                                <c:if test="${receive.paymentOptions == 'COD'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Tiền mặt</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${receive.deliveryOptions == 'Delivery'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Giao hàng Flora</p>
                                                </c:if>
                                                <c:if test="${receive.deliveryOptions == 'Pick Up'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Lấy tại sự kiện</p>
                                                </c:if>
                                            </td>
                                            <td style="text-align: center">
                                                <c:if test="${receive.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: #00FF00; font-weight: bold">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${receive.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: red; font-weight: bold">Chưa thanh toán</p>
                                                </c:if>
                                                <c:set var="result" value="NHANHANG"/> <!-- Khởi tạo với giá trị mặc định -->
                                                <c:forEach var="feedbacks" items="${requestScope.LIST_CHECK_FEEDBACK}">
                                                    <c:if test="${feedbacks.eventOrderId == receive.eventOrderId && feedbacks.feedback == ''}">
                                                        <c:set var="result" value="DANHGIA"/>
                                                    </c:if>
                                                    <c:if test="${feedbacks.eventOrderId == receive.eventOrderId && feedbacks.feedback != ''}">
                                                        <c:set var="result" value="DADANHGIA"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${result == 'NHANHANG'}">
                                                    <button id="myButton-${receive.eventOrderId}" onclick="handleButtonClick(${receive.eventOrderId},${receive.deliveryId}, event)" class="btn border-secondary rounded-pill px-4 py-3 text-third" style="text-align: center" type="button">Nhận hàng</button>
                                                </c:if>
                                                <c:if test="${result == 'DANHGIA'}">
                                                    <button id="myButton-${receive.eventOrderId}" class="btn border-secondary rounded-pill px-4 py-3 text-third" style="text-align: center" type="button"  onclick="openFeedbackModal(${receive.eventOrderId},${receive.deliveryId}, event)">Đánh giá</button>
                                                </c:if>
                                                <c:if test="${result == 'DADANHGIA'}">
                                                    <button class="btn border-secondary rounded-pill px-4 py-3 text-third" style="text-align: center" type="button" disabled="">Đã đánh giá</button>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center; font-weight: bold"><fmt:formatNumber value="${receive.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_RECEIVE}">
                            <div class="background-img">
                                <div class="non-order"></div>
                                <h3 style="text-align: center">Chưa có đơn hàng</h3>
                            </div>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-cancelled" role="tabpanel" aria-labelledby="nav-cancelled-tab">
                        <c:if test="${not empty requestScope.LIST_CANCEL}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày đặt</th>
                                <th style="text-align: center">Hình thức thanh toán</th>
                                <th style="text-align: center">Hình thức vận chuyển</th>
                                <th style="text-align: center">Thanh toán</th>
                                <th style="text-align: center">Tổng tiền</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="cancel" items="${requestScope.LIST_CANCEL}">
                                        <tr class="order-row " data-order-id="${cancel.eventOrderId}" 
                                            data-order-cust="${cancel.fullname}" 
                                            data-cust-phone="${cancel.phone}" 
                                            data-cust-street="${cancel.street}"
                                            data-cust-city="${cancel.city}"
                                            data-cust-note="${cancel.note}"
                                            data-order-event="${cancel.eventName}">
                                            <th scope="row">
                                                <div class="d-flex align-items-center justify-content-center mt-4">
                                                    <p class="">#ORD-${cancel.eventOrderId}</p>
                                                </div>
                                            </th>
                                            <td>
                                                <p class="mb-4 mt-4" style="text-align: center"><fmt:formatDate value="${cancel.orderDate}" pattern="dd/MM/yyyy"/></p>
                                            </td>
                                            <td>      
                                                <c:if test="${cancel.paymentOptions == 'ONLINE'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chuyển khoản (VNPay)</p>
                                                </c:if>
                                                <c:if test="${cancel.paymentOptions == 'COD'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Tiền mặt</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${cancel.deliveryOptions == 'Delivery'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Giao hàng Flora</p>
                                                </c:if>
                                                <c:if test="${cancel.deliveryOptions == 'Pick Up'}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Lấy tại sự kiện</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${cancel.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: #00FF00; font-weight: bold">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${cancel.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center; color: red; font-weight: bold">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center; font-weight: bold"><fmt:formatNumber value="${cancel.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_CANCEL}">
                            <div class="background-img">
                                <div class="non-order"></div>
                                <h3 style="text-align: center">Chưa có đơn hàng</h3>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart Page End -->


        <!-- Modal chi tiết đơn hàng -->
        <div class="modal fade" id="orderDetailModal" tabindex="-1" role="dialog" aria-labelledby="orderDetailModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="orderDetailModalLabel">Chi tiết đơn hàng</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Thông tin chung của đơn hàng -->
                        <div id="orderSummary">
                            <p>Mã đơn hàng: #ORD-<span id="modalOrderId"></span></p>
                            <p>Người đặt hàng: <span id="modalFullname"></span></p>
                            <p>Số điện thoại: <span id="modalPhone"></span></p>
                            <p>Địa chỉ giao hàng: <span id="modalStreet"></span></p>
                            <p>Thành phố: <span id="modalCity"></span></p>
                            <p>Ghi chú: <span id="modalNote"></span></p>
                        </div>
                        <hr>
                        <!-- Chi tiết sản phẩm của đơn hàng -->
                        <h3>Sự kiện: <span id="modalEventName"></span></h3>
                        <h5>Danh sách sản phẩm</h5>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th style="text-align: center">Hình ảnh</th>
                                    <th>Tên sản phẩm</th>
                                    <th style="text-align: center">Giá đơn vị</th>
                                    <th style="text-align: center">Số lượng</th>
                                    <th style="text-align: center">Tổng tiền</th>
                                </tr>
                            </thead>
                            <tbody id="modalProductList">
                                <!-- Dữ liệu sản phẩm sẽ được thêm vào đây -->
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Feedback -->
        <div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="feedbackModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="feedbackModalLabel">Gửi Feedback</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="feedbackForm">
                            <div class="form-group">
                                <label for="feedbackText">Nội dung Feedback</label>
                                <textarea class="form-control" id="feedbackText" rows="3" required></textarea>
                                <label for="rateFeedback">Đánh giá dịch vụ giao hàng</label>
                                <div class="stars" id="rateFeedback">
                                    <input class="star star-5" id="star-5" type="radio" name="star" value="5" />
                                    <label class="star star-5" for="star-5"></label>
                                    <input class="star star-4" id="star-4" type="radio" name="star" value="4" />
                                    <label class="star star-4" for="star-4"></label>
                                    <input class="star star-3" id="star-3" type="radio" name="star" value="3" />
                                    <label class="star star-3" for="star-3"></label>
                                    <input class="star star-2" id="star-2" type="radio" name="star" value="2" />
                                    <label class="star star-2" for="star-2"></label>
                                    <input class="star star-1" id="star-1" type="radio" name="star" value="1" />
                                    <label class="star star-1" for="star-1"></label>
                                </div>
                            </div>
                            <input type="hidden" id="feedbackOrderId"/>
                            <input type="hidden" id="deliveryId"/>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                        <button type="button" class="btn btn-primary" id="submitFeedback">Gửi Feedback</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->

        <!-- Copyright Start -->
        <div class="container-fluid copyright bg-dark py-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        <span class="text-light"><a href="#"><i class="fas fa-copyright text-light me-2"></i>Your Site Name</a>, All right reserved.</span>
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
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script>
                                                        $(document).ready(function () {
                                                            $("tr.order-row").click(function () {
                                                                var orderId = $(this).data('order-id');
                                                                var fulname = $(this).data('order-cust');
                                                                var phone = $(this).data('cust-phone');
                                                                var street = $(this).data('cust-street');
                                                                var city = $(this).data('cust-city');
                                                                var note = $(this).data('cust-note');
                                                                var eventName = $(this).data('order-event');
                                                                $("#modalOrderId").text(orderId);
                                                                $("#modalFullname").text(fulname);
                                                                $("#modalPhone").text(phone);
                                                                $("#modalStreet").text(street);
                                                                $("#modalCity").text(city);
                                                                $("#modalNote").text(note);
                                                                $("#modalEventName").text(eventName);
                                                                $.ajax({
                                                                    url: 'viewPurchasedOrderDetail',
                                                                    type: 'GET',
                                                                    data: {orderId: orderId},
                                                                    success: function (response) {
                                                                        $("#modalProductList").empty();
                                                                        $("#modalProductList").append(response);
                                                                        $('#orderDetailModal').modal('show');
                                                                    },
                                                                    error: function () {
                                                                        alert("Không thể lấy dữ liệu sản phẩm.");
                                                                    }
                                                                });
                                                            });
                                                        });
                                                        $(document).ready(function () {
                                                            $('#submitFeedback').click(function () {
                                                                var feedbackText = $('#feedbackText').val();
                                                                var orderId = $('#feedbackOrderId').val();
                                                                var deliveryId = $('#deliveryId').val();
                                                                var starRating = $('input[name="star"]:checked').val();
                                                                if (!starRating) {
                                                                    Swal.fire({
                                                                        icon: 'warning',
                                                                        title: 'Chưa chọn đánh giá',
                                                                        text: 'Vui lòng chọn số sao đánh giá!'
                                                                    });
                                                                    return;
                                                                }
                                                                if (feedbackText === "") {
                                                                    Swal.fire({
                                                                        icon: 'warning',
                                                                        title: 'Chưa đánh giá',
                                                                        text: 'Vui lòng hãy nhập vào ô đánh giá!'
                                                                    });
                                                                    return;
                                                                }
                                                                $.ajax({
                                                                    url: 'submitFeedback',
                                                                    type: 'POST',
                                                                    contentType: 'application/json',
                                                                    data: JSON.stringify({orderId: orderId, feedback: feedbackText, rating: starRating, staffId: deliveryId}),
                                                                    success: function (response) {
                                                                        if (response.success) {
                                                                            Swal.fire({
                                                                                icon: 'success',
                                                                                title: 'Đã gửi!',
                                                                                text: 'Feedback của bạn đã được gửi thành công!',
                                                                                showConfirmButton: false,
                                                                                timer: 1500
                                                                            });
                                                                            var button = document.getElementById('myButton-' + orderId);
                                                                            button.innerHTML = 'Đã đánh giá';
                                                                            button.onclick = null;
                                                                            button.disabled = true;
                                                                            $('#feedbackText').val('');
                                                                            $('input[name="star"]').prop('checked', false);
                                                                            $('#feedbackModal').modal('hide');
                                                                        } else {
                                                                            Swal.fire({
                                                                                icon: 'error',
                                                                                title: 'Lỗi',
                                                                                text: 'Có lỗi xảy ra, vui lòng thử lại!'
                                                                            });
                                                                        }
                                                                    },
                                                                    error: function () {
                                                                        Swal.fire({
                                                                            icon: 'error',
                                                                            title: 'Lỗi',
                                                                            text: 'Không thể gửi feedback.'
                                                                        });
                                                                    }
                                                                });
                                                            });
                                                        });
                                                        $('.close, .btn-secondary').click(function () {
                                                            $('#orderDetailModal').modal('hide');
                                                        });
                                                        $('.close, .btn-secondary').click(function () {
                                                            $('#feedbackModal').modal('hide');
                                                            $('#feedbackText').val('');
                                                            $('input[name="star"]').prop('checked', false);
                                                        });
        </script>
        <script>
            function handleButtonClick(orderId, deliveryId, event) {
                event.stopPropagation();
                event.preventDefault();
                fetch('feedbackCreate', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({orderId: orderId})
                })
                        .then(response => response.json())
                        .then(data => {
                            if (data.success) {
                                var button = document.getElementById('myButton-' + orderId);
                                button.innerHTML = 'Đánh giá';
                                button.onclick = function (e) {
                                    openFeedbackModal(orderId, deliveryId, e);
                                };
                            }
                        }
                        )
                        .catch((error) => {
                            console.error('Error:', error);
                        });
            }
            function openFeedbackModal(orderId, deliveryId, event) {
                event.stopPropagation();
                event.preventDefault();
                $('#feedbackOrderId').val(orderId);
                $('#deliveryId').val(deliveryId);
                $('#feedbackModal').modal('show');
            }
            function cancelOrder(eventOrderId, event) {
                event.stopPropagation();
                event.preventDefault();
                Swal.fire({
                    title: 'Bạn có chắc chắn muốn hủy đơn?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Hủy đơn',
                    cancelButtonText: 'Không'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            url: 'cancelUserOrder',
                            type: 'POST',
                            data: {eventOrderId: eventOrderId},
                            success: function (response) {
                                if (response.status === 'success') {
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Hủy đơn thành công!',
                                        showConfirmButton: false,
                                        timer: 1500
                                    }).then(() => {
                                        location.reload();
                                    });
                                } else {
                                    Swal.fire({
                                        icon: 'error',
                                        title: 'Có lỗi xảy ra',
                                        text: 'Không thể hủy đơn hàng, vui lòng thử lại.'
                                    });
                                }
                            },
                            error: function () {
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Có lỗi xảy ra',
                                    text: 'Không thể kết nối đến server, vui lòng thử lại sau.'
                                });
                            }
                        });
                    }
                });
            }
        </script>
        <!-- Template Javascript -->
        <script src="js/starRating.js"></script>
        <script src="js/notification.js"></script>
        <script src="alertPackage/alertJs.js"></script>
        <script src="js/main.js"></script>
        <script src="js/newProduct.js"></script>
    </body>
</html>
