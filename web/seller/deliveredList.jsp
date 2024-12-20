<%-- 
    Document   : orderSuccessList
    Created on : Oct 17, 2024, 6:51:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/css/font-awesome.min.css">
        <!-- <link rel="stylesheet" href="css/AdminLTE.css"> -->
        <link rel="stylesheet" href="css/css/_all-skins.min.css">
        <link rel="stylesheet" href="css/css/jquery-ui.css">
        <link rel="stylesheet" href="css/css/style.css" />
        <link rel="stylesheet" href="css/css/admincss.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/chart.js/dist/chart.min.css">
        <!--        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
                <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="icon" href="img/flora-favicon.png"/>
        <title>Seller | Delivered Order</title>
    </head>
    <body>
        <section class="admin">
            <div class="row-grid">
                <div class="admin-sidebar">
                    <div class="admin-sidebar-top">
                        <img src="img/flora-favicon.png" alt=""> 
                    </div>
                    <div class="admin-sidebar-content" style="padding: 19px 0 0 10px; box-sizing: border-box;">
                        <ul style="margin-bottom: 10px; padding-left: 0px;">
                            <div class="logout-admin"><a href="logoutAction" class="logout-btn">Logout</a></div>
                            <p class="admin-p">Seller</p>
                            <div class="admin-under-p" style="margin: 1px 5px 5px 5px">Flora Store Seller</div>
                            <li>
                                <a href="" style="color: #337AB7"><i class="ri-dashboard-fill"></i>Dashboard<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" href="monthlyEventSell" style="color: #337AB7">Products by month</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="" style="color: #337AB7"><i class="ri-file-list-line"></i>Event management<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" href="viewSellerEvent" style="color: #337AB7">Event</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="" style="color: #337AB7"><i class="ri-file-list-line"></i>Order management<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" href="viewOrderAction" style="color: #337AB7">Pending Orders</a></li>
                                    <li><a class="ri-arrow-right-s-fill" href="sellerViewOrders" style="color: #337AB7">Shipping Orders</a></li>
                                    <li><a class="ri-arrow-right-s-fill" href="viewDeliveredAction" style="color: #337AB7">Completed Orders</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="" style="color: #337AB7"><i class="ri-file-list-line"></i>Feedback<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" href="viewFeedbacks" style="color: #337AB7">View feedback</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="admin-content">
                    <div class="admin-content-top">
                        <div class="admin-content-top-left">
                            <ul class="flex-box"> 
                                <a style="padding-left: 0px" href="home"/>
                                <button type="button" class="btn btn-primary" 
                                        style="font-size: 14px; background-color: #337AB7; padding-bottom: 6px">BACK TO STORE</button>
                                </a>    
                            </ul>   
                        </div>
                        <div class="admin-content-top-right">
                            <ul class="flex-box">
                                <li><i class="ri-notification-4-line" number="3"></i></li>
                                <li><i class="ri-message-2-line" number="5"></i></li>
                                <li class="flex-box">
                                    <img style="width: 50px;" src="data:image/jpeg;base64,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" alt="">
                                    <p>${sessionScope.USER.fullName}<i class="ri-arrow-down-s-fill"></i></p>
                                </li>
                            </ul>
                        </div>
                    </div> 
                    <div class="admin-content-main">
                        <div class="admin-content-main-title">
                            <h1>Completed Order List</h1>
                        </div>
                        <div class="admin-content-main-content">
                            <!-- Nội dung ở đây -->
                            <div class="admin-content-main-content-product-list">
                                <table id="orderTable">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Buyer's name</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>Note</th>
                                            <th>Details</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="delivered" items="${sessionScope.DELIVERED}" varStatus="counter">
                                            <tr>
                                                <td style="font-weight: bold">#ORD-${delivered.eventOrderId}</td>
                                                <td>${delivered.fullname}</td>
                                                <td>${delivered.phone}</td>
                                                <td style="word-wrap: break-word; width: 400px;">${delivered.street}, ${delivered.city}</td>
                                                <td>
                                                    <c:if test="${not empty order.note}">
                                                        ${order.note}
                                                    </c:if>
                                                    <c:if test="${empty order.note}">
                                                        -
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <button type="button" class="btn btn-primary" data-toggle="modal" 
                                                            data-target="#view${counter.count}" style="color: white">
                                                        Xem
                                                    </button>
                                                    <div class="modal fade" id="view${counter.count}" tabindex="-1" role="dialog" 
                                                         aria-labelledby="view${counter.count}" aria-hidden="true">
                                                        <div class="modal-dialog" role="document" style="max-width: 80%; width: 80%">
                                                            <div class="modal-content">
                                                                <table>
                                                                    <thead>
                                                                        <tr>
                                                                            <th style="background-color: #007bff; color: white">No</th>
                                                                            <th style="background-color: #007bff; color: white">Name</th>
                                                                            <th style="background-color: #007bff; color: white">Order date</th>
                                                                            <th style="background-color: #007bff; color: white">Delivered date</th>
                                                                            <th style="background-color: #007bff; color: white">Shipping method</th>
                                                                            <th style="background-color: #007bff; color: white">Quantity</th>
                                                                            <th style="background-color: #007bff; color: white">Unit Price</th>
                                                                            <th style="background-color: #007bff; color: white">Discount</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <c:forEach var="detail" items="${sessionScope.DETAILS[delivered.eventOrderId]}" varStatus="counter">
                                                                            <tr>
                                                                                <td>${counter.count}</td>
                                                                                <td>${detail.eventProductName}</td>
                                                                                <td><fmt:formatDate value="${delivered.orderDate}" pattern="dd-MM-yyyy" /></td>
                                                                                <td><fmt:formatDate value="${delivered.deliveryDate}" pattern="dd-MM-yyyy" /></td>
                                                                                <td>
                                                                                    <c:if test="${delivered.deliveryOption == 'Delivery'}">
                                                                                        <a style="color: #28a745">
                                                                                            Delivery by Flora
                                                                                        </a>
                                                                                    </c:if>
                                                                                    <c:if test="${delivered.deliveryOption == 'Pick Up'}">
                                                                                        <a style="color: red">
                                                                                            Pick Up
                                                                                        </a>
                                                                                    </c:if>
                                                                                </td>
                                                                                <td>${detail.quantity}</td>
                                                                                <td>
                                                                                    <fmt:formatNumber value="${detail.unitPrice}" pattern="#,###"/>
                                                                                </td>
                                                                                <td>
                                                                                    <fmt:formatNumber value="${detail.discount}" pattern="#,##%"/>
                                                                                </td>
                                                                            </tr>
                                                                        </c:forEach>
                                                                        <c:forEach var="total" items="${requestScope.TOTAL}" varStatus="counter3">
                                                                            <c:if test="${delivered.eventOrderId == total.eventId}">
                                                                                <tr>
                                                                                    <c:if test="${delivered.isPaid == true}">
                                                                                        <td colspan="5"></td>
                                                                                        <td style="font-weight: 700; color: green">Paid</td>
                                                                                    </c:if>
                                                                                    <c:if test="${delivered.isPaid == false}">
                                                                                        <td colspan="6"></td>
                                                                                    </c:if>
                                                                                    <td style="font-weight: 700;">Total amount:</td>
                                                                                    <td style="font-weight: 700;" >${total.total}</td> 
                                                                                </tr>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a style="color: green">
                                                        ${delivered.status}
                                                    </a>
                                                </td>
                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="col-12" >
                                    <div class="d-flex justify-content-center mt-5">
                                        <%--phần code laquo (<<) --%>
                                        <c:if test="${sessionScope.currentPage == 1}"> 
                                            <a href="#" class="btn btn-secondary" style="margin: 2px; 
                                               background-color: gray; color: white; pointer-events: none; opacity: 0.6;
                                               border-color: black; padding: 9px 15px 9px 15px; font-weight: bold;">
                                                &laquo;
                                            </a>
                                        </c:if>
                                        <c:if test="${sessionScope.currentPage != 1}"> 
                                            <form id="backForm" action="viewDeliveredAction" method="POST">
                                                <input type="hidden" id="pageBack" name="pageBack"/>
                                                <a href="#" class="btn btn-secondary" style="margin: 2px; background-color: white; border-color: black; padding: 9px 15px 9px 15px; color: black; font-weight: bold"
                                                   onclick="document.getElementById('pageBack').value = '${(sessionScope.currentPage - 1)}';
                                                           document.getElementById('backForm').submit();">
                                                    &laquo;
                                                </a>
                                            </form>
                                        </c:if>
                                        <%--phần code laquo (<<) --%>
                                        <form id="paginationForm" action="viewDeliveredAction" method="POST">
                                            <input type="hidden" id="pageNo" name="pageNo">
                                            <%--Nếu chỉ có 5 trang thì show << 1 2 3 4 5 >>--%>
                                            <c:if test="${sessionScope.pageSize <= 5}">
                                                <c:forEach var="i" begin="1" end="${sessionScope.pageSize}">
                                                    <c:if test="${sessionScope.currentPage == i}">
                                                        <a href="#" class="btn btn-secondary" 
                                                           onclick="document.getElementById('pageNo').value = '${i}';
                                                                   document.getElementById('paginationForm').submit();
                                                                   return false;" style="margin: 2px; background-color: #000066; border-color: black; padding: 9px 15px 9px 15px; color: white;
                                                           font-weight: bold; margin-right: -2px">${i}</a>
                                                    </c:if>
                                                    <c:if test="${sessionScope.currentPage != i}">
                                                        <a href="#" class="btn btn-secondary" 
                                                           onclick="document.getElementById('pageNo').value = '${i}';
                                                                   document.getElementById('paginationForm').submit();
                                                                   return false;" style="margin: 2px; background-color: white; border-color: black; padding: 9px 15px 9px 15px; color: black; 
                                                           font-weight: bold; margin-right: -2px">${i}</a>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                            <%--Nếu chỉ có 5 trang thì show << 1 2 3 4 5 >>--%>
                                            <%--Nếu nhiều hơn 5 trang thì show << 1 2 3 4 5 ... >> << 1 2 ... 5 6 7 ... >> << 1 2 ... 7 8 9 >>--%>
                                            <c:if test="${sessionScope.pageSize > 5}">
                                                <c:if test="${sessionScope.currentPage == 1 || sessionScope.currentPage == 2 ||
                                                              sessionScope.currentPage == 3}">
                                                    <c:forEach var="i" begin="1" end="5">
                                                        <c:if test="${sessionScope.currentPage == i}">
                                                            <a href="#" class="active btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: #000066; border-color: black; padding: 9px 15px 9px 15px; color: white;
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                        <c:if test="${sessionScope.currentPage != i}">
                                                            <a href="#" class="btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: white; border-color: black; padding: 9px 15px 9px 15px; color: black; 
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                    <a href="#" class="btn btn-secondary" style="margin: 2px; border-color: black; padding: 9px 15px 9px 15px; 
                                                       font-weight: bold; margin-right: -2px;
                                                       background-color: white; color: black; pointer-events: none; opacity: 0.6;">
                                                        ...
                                                    </a>
                                                </c:if>
                                                <c:if test="${sessionScope.currentPage != 1 && sessionScope.currentPage != 2 &&
                                                              sessionScope.currentPage != 3 &&
                                                              sessionScope.currentPage != (sessionScope.pageSize - 2) &&
                                                              sessionScope.currentPage != (sessionScope.pageSize - 1) &&
                                                              sessionScope.currentPage != sessionScope.pageSize}">
                                                    <c:forEach var="i" begin="1" end="2">
                                                        <c:if test="${sessionScope.currentPage == i}">
                                                            <a href="#" class="active btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: #000066; border-color: black; padding: 9px 15px 9px 15px; color: white;
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                        <c:if test="${sessionScope.currentPage != i}">
                                                            <a href="#" class="btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: white; border-color: black; padding: 9px 15px 9px 15px; color: black; 
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                    <a href="#" class="btn btn-secondary" style="margin: 2px; border-color: black; padding: 9px 15px 9px 15px; font-weight: bold;
                                                       background-color: white; color: black; pointer-events: none; opacity: 0.6; margin-right: -2px">
                                                        ...
                                                    </a>
                                                    <c:forEach var="i" begin="${sessionScope.currentPage}" end="${(sessionScope.currentPage + 2)}">
                                                        <c:if test="${sessionScope.currentPage == i}">
                                                            <a href="#" class="active btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: #000066; border-color: black; padding: 9px 15px 9px 15px; color: white;
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                        <c:if test="${sessionScope.currentPage != i}">
                                                            <a href="#" class="btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: white; border-color: black; padding: 9px 15px 9px 15px; color: black; 
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                    <a href="#" class="btn btn-secondary" style="margin: 2px; border-color: black; padding: 9px 15px 9px 15px; font-weight: bold;
                                                       background-color: white; color: black; pointer-events: none; opacity: 0.6; margin-right: -2px">
                                                        ...
                                                    </a>
                                                </c:if>
                                                <c:if test="${sessionScope.currentPage == (sessionScope.pageSize - 2) ||
                                                              sessionScope.currentPage == (sessionScope.pageSize - 1) ||
                                                              sessionScope.currentPage == sessionScope.pageSize}">
                                                    <c:forEach var="i" begin="1" end="2">
                                                        <c:if test="${sessionScope.currentPage == i}">
                                                            <a href="#" class="active btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: #000066; border-color: black; padding: 9px 15px 9px 15px; color: white;
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                        <c:if test="${sessionScope.currentPage != i}">
                                                            <a href="#" class="btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: white; border-color: black; padding: 9px 15px 9px 15px; color: black; 
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                    <a href="#" class="btn btn-secondary" style="margin: 2px; border-color: black; padding: 9px 15px 9px 15px; font-weight: bold;
                                                       background-color: white; color: black; pointer-events: none; opacity: 0.6; margin-right: -2px">
                                                        ...
                                                    </a>
                                                    <c:forEach var="i" begin="${(sessionScope.pageSize - 2)}" end="${sessionScope.pageSize}">
                                                        <c:if test="${sessionScope.currentPage == i}">
                                                            <a href="#" class="active btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: #000066; border-color: black; padding: 9px 15px 9px 15px; color: white;
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                        <c:if test="${sessionScope.currentPage != i}">
                                                            <a href="#" class="btn btn-secondary" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 2px; background-color: white; border-color: black; padding: 9px 15px 9px 15px; color: black; 
                                                               font-weight: bold; margin-right: -2px">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>
                                            </c:if>
                                            <%--Nếu nhiều hơn 5 trang thì show << 1 2 3 4 5 ... >> << 1 2 ... 5 6 7 ... >> << 1 2 ... 7 8 9 >>--%>
                                        </form>
                                        <%--phần code raquo (>>) --%>
                                        <c:if test="${sessionScope.currentPage != sessionScope.pageSize}"> 
                                            <form id="forwardForm" action="viewDeliveredAction" method="POST">
                                                <input type="hidden" id="pageForward" name="pageForward"/>
                                                <a href="#" class="btn btn-secondary" style="margin: 2px; background-color: white; border-color: black; 
                                                   padding: 9px 15px 9px 15px; color: black; font-weight: bold; margin-left: 6px"
                                                   onclick="document.getElementById('pageForward').value = '${(sessionScope.currentPage + 1)}';
                                                           document.getElementById('forwardForm').submit();">
                                                    &raquo;
                                                </a>
                                            </form>
                                        </c:if>
                                        <c:if test="${sessionScope.currentPage == sessionScope.pageSize}"> 
                                            <a href="#" class="btn btn-secondary" style="margin: 2px; border-color: black; 
                                               padding: 9px 15px 9px 15px; font-weight: bold; margin-left: 6px;
                                               background-color: gray; color: white; pointer-events: none; opacity: 0.6;">
                                                &raquo;
                                            </a>
                                        </c:if> 
                                        <%--phần code raquo (>>) --%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </section>

    <script src="js/javascript.js"></script>
</body>
</html>

