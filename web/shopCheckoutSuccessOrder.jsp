<%-- 
    Document   : shopCheckoutSuccessOrder
    Created on : Oct 16, 2024, 10:46:14 PM
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
        <title>Thank you for your purchase | Buy and sell on the website</title>
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
                                    <div class="steps"> <span><i class="fa fa-check"></i></span> </div> <span class="non-line"></span>
                                    <div class="non-steps"> <span class="font-weight-bold">2</span> </div> <span class="non-line"></span>
                                    <div class="non-steps"> <span class="font-weight-bold">3</span> </div>
                                </div>
                            </div>
                        </div>
                        <div class="row g-0">
                            <div class="col-md-6 border-right p-5">
                                <div class="text-center order-details">
                                    <div class="d-flex justify-content-center mb-5 flex-column align-items-center"> 
                                        <span class="check1"><i class="fa fa-check"></i></span> 
                                        <span class="font-weight-bold">Transaction successful</span> 
                                        <small class="mt-2">Thanks ${sessionScope.CUST_NAME_SHOP} for purchasing on our platform.</small> 
                                        <p>Status: </p>
                                        <c:if test="${sessionScope.PAYMENT_STATUS_SHOP == true}">
                                            <p class="green bold">Paid</p>
                                        </c:if>
                                        <c:if test="${sessionScope.PAYMENT_STATUS_SHOP == false}">
                                            <p class="red bold">Unpaid</p>
                                        </c:if>
                                    </div> 
                                    <a href="home" class="text-decoration-none">
                                        <button class="btn btn-success btn-block order-button">Continue shopping</button>
                                    </a>
                                </div>
                                <div class="text-center-content">
                                    <div class="admin-left-content-left">
                                        <div class="admin-left-content-left-input">Contact phone number:<p>${sessionScope.CUST_PHONE_SHOP}</p></div>
                                        <div class="admin-left-content-left-input">Delivery address:<p>${sessionScope.CUST_ADDRESS_SHOP}, ${sessionScope.CUST_CITY_SHOP}</p></div>
                                    </div>
                                    <div class="admin-left-content-right">
                                        <div class="admin-left-content-right-input">Shipping method:<p><c:if test="${sessionScope.SHIPPING_SHOP == 'Delivery'}">Delivered by Flora Delivery</c:if>
                                                <c:if test="${sessionScope.SHIPPING_SHOP == 'Pick Up'}">Pick up at point of sale</c:if></p></div>
                                        <div class="admin-left-content-right-input">Payment method:<p><c:if test="${sessionScope.CUST_PAYMENT_SHOP == 'COD'}">Cash on Delivery</c:if>
                                                <c:if test="${sessionScope.CUST_PAYMENT_SHOP == 'ONLINE'}">Online Payment</c:if></p></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 background-muted">
                                    <div class="p-3 border-bottom">
                                        <!--                                        <div class="d-flex justify-content-between align-items-center"> <span><i class="fa fa-clock-o text-muted"></i></span> <span><i class="fa fa-refresh text-muted"></i> 2 Max Revisions</span> </div>-->
                                        <div class="mt-3">
                                            <h6 class="mb-0">You can view order details here: </h6> <span class="d-block mb-0"><a href="purchasedOrder">Order information</a></span> 
                                        </div>
                                    </div>
                                    <div class="admin-sidebar">                               
                                        <div class="admin-sidebar-content">
                                            <ul>
                                                <li>
                                                    <a href="#" data-toggle="collapse" class="admin-sidebar-content-detail">Details</a>
                                                    <ul class="sub-menu">
                                                        <div class="admin-content-main-content-product-list">
                                                        <c:set var="bill" value="${sessionScope.ORDER_ITEMS_SHOP}"/>
                                                        <c:forEach var="entry" items="${bill.items}">
                                                            <c:set var="storeName" value="${entry.key}"/>
                                                            <c:set var="storeItems" value="${entry.value}"/>
                                                            <h5>Shop: ${storeName}</h5>
                                                            <table>
                                                                <thead>
                                                                <th>Product</th>
                                                                <th>Name</th>
                                                                <th>Unit Price</th>
                                                                <th>Quantity</th>
                                                                <th>Total Price</th>                               
                                                                </thead>
                                                                <tbody style="height: 100px;">
                                                                    <c:set var="totalShop" value="0"/>
                                                                    <c:forEach var="item" items="${storeItems}">
                                                                        <c:set var="totalShop" value="${totalShop + (item.unitPrice * item.quantity)}"/>
                                                                        <tr>
                                                                            <td><img src="${item.imageURL}" class="img-fluid rounded-circle" style="width: 50px; height: 50px;" alt=""></td>
                                                                            <td>${item.name}</td>
                                                                            <td><fmt:formatNumber value="${item.unitPrice}" type="number" groupingUsed="true"/>đ</td>
                                                                            <td>${item.quantity}</td>
                                                                            <td><fmt:formatNumber value="${item.quantity * item.unitPrice}" type="number" groupingUsed="true"/>đ</td>                                                     
                                                                        </tr>
                                                                    </c:forEach>
                                                                    <tr>
                                                                        <td style="font-weight: 700;" colspan="4">Total amount:</td>
                                                                        <td style="font-weight: 700;" ><fmt:formatNumber value="${totalShop}" type="number" groupingUsed="true"/>đ</td>  
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
