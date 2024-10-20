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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">


        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
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
        </style>
    </head>

    <body>

        <!-- Spinner Start -->
        <div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-third" role="status"></div>
        </div>
        <!-- Spinner End -->


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
                            <a href="searchAction" class="nav-item nav-link">Shop</a>
                            <a href="event" class="nav-item nav-link">Event</a>
                            <a href="contactPage" class="nav-item nav-link">Contact</a>
                            <!--        Session Management  -->
                            <c:if test="${not empty sessionScope.USER}">
                                <!--                Manager Session-->
                                <c:if test="${sessionScope.USER.role == 'Admin'}">
                                    <a href="monthlyBoard" class="nav-item nav-link">DashBoard</a>
                                    <a href="viewEvent" class="nav-item nav-link">Manage System</a>
                                </c:if>
                                <!--                Delivery Session-->
                                <c:if test="${sessionScope.USER.role == 'Delivery'}">
                                    <a href="delivererOrders" class="nav-item nav-link">Thông tin đơn hàng</a>
                                </c:if>
                                <!--                Seller Session-->
                                <c:if test="${sessionScope.USER.role == 'Seller'}">
                                    <a href="showStoreName" class="nav-item nav-link">Manage Shop</a>
                                </c:if>
                            </c:if>

                        </div>
                        <div class="d-flex align-items-center justify-content-center m-3 me-0">
                            <button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4" data-bs-toggle="modal" data-bs-target="#searchModal">
                                <i class="fas fa-search text-third"></i>
                            </button>

                            <c:if test="${empty sessionScope.USER}">
                                <a href="loginPage" class="position-relative me-4">
                                    <i class="fa fa-shopping-bag fa-2x"></i>
                                </a>
                                <a href="loginPage" class="my-auto">
                                    <i class="fas fa-user fa-2x"></i>
                                </a>
                            </c:if>
                            <c:if test="${not empty sessionScope.USER}">
                                <div class="nav-item dropdown">
                                    <a href="#" class="position-relative me-0 nav-link dropdown-toggle d-flex align-items-center">
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
                                    <a href="#" class="nav-link dropdown-toggle d-flex align-items-center" data-bs-toggle="dropdown">
                                        <img src="img/avatar.png" alt="User Avatar" class="rounded-circle" width="60">${sessionScope.USER.fullName}
                                    </a>
                                    <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                        <a href="viewProfileAction" class="dropdown-item">My Profile</a>
                                        <a href="#" class="dropdown-item">Purchase Order</a>
                                        <a href="logoutAction" class="dropdown-item">Logout</a>
                                    </div>
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
                                <th style="text-align: center">Ngày</th>
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
                                                <p class="mb-4 mt-4 total-price" style="text-align: center">${pending.deliveryOptions}</p>
                                            </td>
                                            <td>
                                                <c:if test="${pending.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${pending.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center"><fmt:formatNumber value="${pending.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_PENDING}">
                            <h3 style="text-align: center">Bạn chưa có đơn hàng nào cả</h3>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-verify" role="tabpanel" aria-labelledby="nav-verify-tab">
                        <c:if test="${not empty requestScope.LIST_CONFIRM}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày</th>
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
                                                <p class="mb-4 mt-4 total-price" style="text-align: center">${confirm.deliveryOptions}</p>
                                            </td>
                                            <td>
                                                <c:if test="${confirm.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${confirm.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center"><fmt:formatNumber value="${confirm.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_CONFIRM}">
                            <h3 style="text-align: center">Bạn chưa có đơn hàng nào cả</h3>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-ship" role="tabpanel" aria-labelledby="nav-ship-tab">
                        <c:if test="${not empty requestScope.LIST_SHIPPING}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày</th>
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
                                                <p class="mb-4 mt-4 total-price" style="text-align: center">${shipping.deliveryOptions}</p>
                                            </td>
                                            <td>
                                                <c:if test="${shipping.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${shipping.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center"><fmt:formatNumber value="${shipping.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_SHIPPING}">
                            <h3 style="text-align: center">Bạn chưa có đơn hàng nào cả</h3>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-done" role="tabpanel" aria-labelledby="nav-done-tab">
                        <c:if test="${not empty requestScope.LIST_RECEIVE}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày</th>
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
                                            </th>
                                            <td>
                                                <p class="mb-4 mt-4" style="text-align: center"><fmt:formatDate value="${receive.orderDate}" pattern="dd/MM/yyyy"/></p>
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
                                                <p class="mb-4 mt-4 total-price" style="text-align: center">${receive.deliveryOptions}</p>
                                            </td>
                                            <td>
                                                <c:if test="${receive.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${receive.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center"><fmt:formatNumber value="${receive.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_RECEIVE}">
                            <h3 style="text-align: center">Bạn chưa có đơn hàng nào cả</h3>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="nav-cancelled" role="tabpanel" aria-labelledby="nav-cancelled-tab">
                        <c:if test="${not empty requestScope.LIST_CANCEL}">
                            <table class="table" style="border-radius: 10px; z-index: 1; background-color: #ffffff">
                                <thead>
                                <th style="text-align: center">Đơn hàng</th>
                                <th style="text-align: center">Ngày</th>
                                <th style="text-align: center">Hình thức thanh toán</th>
                                <th style="text-align: center">Hình thức vận chuyển</th>
                                <th style="text-align: center">Thanh toán</th>
                                <th style="text-align: center">Tổng tiền</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="cancel" items="${requestScope.LIST_CANCEL}">
                                        <tr>
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
                                                <p class="mb-4 mt-4 total-price" style="text-align: center">${cancel.deliveryOptions}</p>
                                            </td>
                                            <td>
                                                <c:if test="${cancel.paid == true}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Đã thanh toán</p>
                                                </c:if>
                                                <c:if test="${cancel.paid == false}">
                                                    <p class="mb-4 mt-4 total-price" style="text-align: center">Chưa thanh toán</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <p class="mb-4 mt-4 price-per-unit" style="text-align: center"><fmt:formatNumber value="${cancel.ammount}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.LIST_CANCEL}">
                            <h3 style="text-align: center">Bạn chưa có đơn hàng nào cả</h3>
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

                    // Hiển thị thông tin chung của đơn hàng trong modal
                    $("#modalOrderId").text(orderId);
                    $("#modalFullname").text(fulname);
                    $("#modalPhone").text(phone);
                    $("#modalStreet").text(street);
                    $("#modalCity").text(city);
                    $("#modalNote").text(note);
                    $("#modalEventName").text(eventName);

                    // Gọi AJAX để lấy danh sách sản phẩm của đơn hàng
                    $.ajax({
                        url: 'viewPurchasedOrderDetail', // Đường dẫn đến servlet
                        type: 'GET',
                        data: {orderId: orderId},
                        success: function (response) {
                            // Xóa dữ liệu cũ trước khi thêm mới
                            $("#modalProductList").empty();

                            // Thêm HTML trả về từ servlet vào bảng
                            $("#modalProductList").append(response);

                            // Hiển thị modal
                            $('#orderDetailModal').modal('show');
                        },
                        error: function () {
                            alert("Không thể lấy dữ liệu sản phẩm.");
                        }
                    });
                });
            });
            $('.close, .btn-secondary').click(function () {
                $('#orderDetailModal').modal('hide');
            });
        </script>

        <!-- Template Javascript -->
        <script src="alertPackage/alertJs.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
