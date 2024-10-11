<%-- 
    Document   : checkOutSuccess
    Created on : Oct 9, 2024, 10:02:31 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/checkOutCss.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Cảm ơn bạn đã mua hàng | Buy and sell on the website</title>
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <style>
            .red {
                color: red;
            }
            .green{
                color :green;
            }
            .bold{
                font-weight: bold;
            }
        </style>
        <script>
            window.onbeforeunload = function () {
                sessionStorage.setItem('prevPage', window.location.href);
            };
        </script>
    </head>
    <body>
        <div class="container mt-4 mb-4">
            <div class="row d-flex cart align-items-center justify-content-center">
                <div class="col-md-12">
                    <div class="card">
                        <div class="d-flex justify-content-center border-bottom">
                            <div class="p-3">
                                <div class="progresses">
                                    <div class="steps"> <span><i class="fa fa-check"></i></span> </div> <span class="line"></span>
                                    <div class="steps"> <span><i class="fa fa-check"></i></span> </div> <span class="line"></span>
                                    <div class="steps"> <span class="font-weight-bold">3</span> </div>
                                </div>
                            </div>
                        </div>
                        <div class="row g-0">
                            <div class="col-md-6 border-right p-5">
                                <div class="text-center order-details">
                                    <div class="d-flex justify-content-center mb-5 flex-column align-items-center"> 
                                        <span class="check1"><i class="fa fa-check"></i></span> 
                                        <span class="font-weight-bold">Giao dịch thành công</span> 
                                        <small class="mt-2">Cảm ơn ${sessionScope.CUST_NAME} đã mua hàng trên nền tảng chúng tôi</small> 
                                        <p>Tình trạng: </p>
                                        <c:if test="${sessionScope.PAYMENT_STATUS == true}">
                                            <p class="green bold">Đã thanh toán</p>
                                        </c:if>
                                        <c:if test="${sessionScope.PAYMENT_STATUS == false}">
                                            <p class="red bold">Chưa thanh toán</p>
                                        </c:if>
                                    </div> 
                                    <a href="home" class="text-decoration-none">
                                        <button class="btn btn-success btn-block order-button">Tiếp tục mua sắm</button>
                                    </a>
                                </div>
                                <div class="text-center-content">
                                    <div class="admin-left-content-left">
                                        <div class="admin-left-content-left-input">Số điện thoại liên hệ:<p>${sessionScope.CUST_PHONE}</p></div>
                                        <div class="admin-left-content-left-input">Địa chỉ giao hàng:<p>${sessionScope.CUST_ADDRESS}, ${sessionScope.CUST_CITY}</p></div>
                                    </div>
                                    <div class="admin-left-content-right">
                                        <div class="admin-left-content-right-input">Phương thức vận chuyển:<p><c:if test="${sessionScope.SHIPPING == 'Delivery'}">Giao hàng bởi Flora Delivery</c:if>
                                                <c:if test="${sessionScope.SHIPPING == 'Pick Up'}">Lấy hàng tại điểm bán</c:if></p></div>
                                        <div class="admin-left-content-right-input">Phương thức thanh toán:<p><c:if test="${sessionScope.CUST_PAYMENT == 'COD'}">Thanh toán khi nhận hàng</c:if>
                                                <c:if test="${sessionScope.CUST_PAYMENT == 'ONLINE'}">Thanh toán trực tuyến</c:if></p></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 background-muted">
                                    <div class="p-3 border-bottom">
                                        <div class="d-flex justify-content-between align-items-center"> <span><i class="fa fa-clock-o text-muted"></i></span> <span><i class="fa fa-refresh text-muted"></i> 2 Max Revisions</span> </div>
                                        <div class="mt-3">
                                            <h6 class="mb-0">Bạn đã đồng ý tuân theo: </h6> <span class="d-block mb-0"><a href="">Điều khoản Flora Rewind</a></span> 
                                            <small>Đã áp dụng mã miễn phí</small>
                                            <div class="d-flex flex-column mt-3"> 
                                                <small><i class="fa fa-check text-muted"></i> Voucher</small> 
                                                <small><i class="fa fa-check text-muted"></i> Freeship</small> 
                                            </div>
                                        </div>
                                    </div>
                                    <div class="admin-sidebar">                               
                                        <div class="admin-sidebar-content">
                                            <ul>
                                                <li>
                                                    <a href="#" data-toggle="collapse" class="admin-sidebar-content-detail">Thông tin chi tiết</a>
                                                    <ul class="sub-menu">
                                                        <div class="admin-content-main-content-product-list">
                                                        <c:set var="bill" value="${sessionScope.ORDER_ITEMS}"/>
                                                        <c:forEach var="entry" items="${bill.items}">
                                                            <c:set var="eventName" value="${entry.key}"/>
                                                            <c:set var="eventItems" value="${entry.value}"/>
                                                            <h5>Sự kiện: ${eventName}</h5>
                                                            <table>
                                                                <thead>
                                                                <th>Sản phẩm</th>
                                                                <th>Tên</th>
                                                                <th>Giá</th>
                                                                <th>Số lượng</th>
                                                                <th>Thành tiền</th>                               
                                                                </thead>
                                                                <tbody style="height: 100px;">
                                                                    <c:set var="totalEvent" value="0"/>
                                                                    <c:forEach var="item" items="${eventItems}">
                                                                        <c:set var="totalEvent" value="${totalEvent + (item.unitPrice * item.quantity)}"/>
                                                                        <tr>
                                                                            <td><img src="${item.img}" class="img-fluid rounded-circle" style="width: 50px; height: 50px;" alt=""></td>
                                                                            <td>${item.epName}</td>
                                                                            <td><fmt:formatNumber value="${item.unitPrice}" type="number" groupingUsed="true"/>đ</td>
                                                                            <td>${item.quantity}</td>
                                                                            <td><fmt:formatNumber value="${item.quantity * item.unitPrice}" type="number" groupingUsed="true"/>đ</td>                                                     
                                                                        </tr>
                                                                    </c:forEach>
                                                                    <tr>
                                                                        <td style="font-weight: 700;" colspan="4">Tổng cộng:</td>
                                                                        <td style="font-weight: 700;" ><fmt:formatNumber value="${totalEvent}" type="number" groupingUsed="true"/>đ</td>  
                                                                        <td></td>  
                                                                    </tr>                    
                                                                </tbody>
                                                            </table>
                                                            <hr>
                                                        </c:forEach>
                                                    </div>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/javas.js"></script>
    </body>
</html>
