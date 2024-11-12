<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/css/font-awesome.min.css">
        <!-- <link rel="stylesheet" href="css/AdminLTE.css"> -->
        <link rel="stylesheet" href="css/css/_all-skins.min.css">
        <link rel="stylesheet" href="css/css/jquery-ui.css">
        <link rel="stylesheet" href="css/css/style.css" />
        <link rel="stylesheet" href="css/css/admincss.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/chart.js/dist/chart.min.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="icon" href="img/flora-favicon.png"/>
        <title>Delivery</title>
        <style>
            .admin-content{
                overflow-y: hidden;
            }
            .admin-content-main-content {
                display: flex;
                align-items: center;
                justify-content: center;
                height: 80vh;
                text-align: center;
                overflow-y: hidden;
            }
            .content-wrapper {
                max-width: 400px; 
            }
            .info-text {
                font-size: 18px;
                color: #555;
                margin-bottom: 20px; 
            }
            .deposit-btn {
                background: linear-gradient(135deg, #FF512F, #DD2476, #FF512F);
                border: 3px solid rgba(255, 82, 82, 0.7);
                border-radius: 50px;
                padding: 15px 40px;
                font-size: 20px;
                color: #fff;
                font-weight: bold;
                cursor: pointer;
                outline: none;
                position: relative;
                overflow: hidden;
                box-shadow: 0 0 20px rgba(221, 36, 118, 0.5), 0 0 40px rgba(221, 36, 118, 0.4);
                transition: transform 0.3s ease, box-shadow 0.3s ease, background-position 0.5s ease;
                background-size: 200% 200%;
                z-index: 1;
            }
            .deposit-btn:hover {
                background-position: right center;
                box-shadow: 0 0 25px rgba(255, 82, 131, 0.6), 0 0 50px rgba(255, 82, 131, 0.5);
                transform: translateY(-3px);
            }
            .deposit-btn::before {
                content: "";
                position: absolute;
                top: 0;
                left: -75%;
                width: 50%;
                height: 100%;
                background: rgba(255, 255, 255, 0.3);
                transform: skewX(-20deg);
                transition: left 0.5s ease;
            }
            .deposit-btn:hover::before {
                left: 125%;
            }
            .deposit-btn:active::after {
                content: "";
                position: absolute;
                top: 50%;
                left: 50%;
                width: 300%;
                height: 300%;
                background: rgba(255, 255, 255, 0.2);
                border-radius: 50%;
                transform: translate(-50%, -50%) scale(0);
                transition: transform 0.5s ease;
                z-index: -1;
            }
            .deposit-btn:active::after {
                transform: translate(-50%, -50%) scale(1);
                transition: transform 0s;
            }
        </style>
    </head>
    <body>
        <section class="admin">
            <div class="row-grid">
                <div id="adminSidebar" class="admin-sidebar"> <%--Side bar here--%>
                    <div class="admin-sidebar-top">
                        <img src="img/flora-favicon.png" alt="">
                    </div>
                    <div class="admin-sidebar-content" style="padding: 19px 0 0 10px; box-sizing: border-box;">
                        <ul style="margin-bottom: 10px; padding-left: 0px;">
                            <div class="logout-admin"><a href="logoutAction" class="logout-btn">Logout</a></div>
                            <p class="admin-p">Delivery</p>
                            <div class="admin-under-p" style="margin: 1px 5px 5px 5px">Flora Store Delivery</div>
                            <li>
                                <a href="" style="color: #131EAD"><i class="ri-file-list-line"></i>Order List<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                           href="delivererOrders">Receive new orders</a></li>
                                    <li><a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                           href="viewOrdersForDelivery">Orders to be delivered</a></li>
                                </ul>   
                            </li>
                            <li>
                                <a href="" style="color: #131EAD"><i class="bi bi-credit-card-fill"></i>E-wallet FLora<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <c:if test="${sessionScope.EWALLET_ACTIVE != true}">
                                        <li>
                                            <a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                               href="myWallet">Create E-wallett</a>
                                        </li>
                                    </c:if>
                                    <c:if  test="${sessionScope.EWALLET_ACTIVE == true}">
                                        <li>
                                            <a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                               href="eWallet">E-wallet</a>
                                        </li>
                                    </c:if>
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
                                <c:if test="${requestScope.FoundError2 != null}">
                                    <i>
                                        Account balance: 
                                        <i style="color: red; font-weight: bold">
                                            <fmt:formatNumber value="${sessionScope.Staff_Balance}" pattern="#,###"/>
                                        </i>
                                    </i>
                                </c:if>
                                <c:if test="${requestScope.FoundError2 == null}">
                                    <i>
                                        Account balance: 
                                        <i style="font-weight: bold">
                                            <fmt:formatNumber value="${sessionScope.Staff_Balance}" pattern="#,###"/>
                                        </i>
                                    </i>
                                </c:if>
                                <li href="viewOrderForDelivery">
                                    <c:if test="${requestScope.Total_Order != null}">
                                        <i class="ri-notification-4-line" number="${requestScope.Total_Order}"></i>
                                    </c:if>
                                    <c:if test="${requestScope.Total_Order == null}">
                                        <i class="ri-notification-4-line" number="0"></i>
                                    </c:if>
                                </li>
                                <li></li>
                                <li class="flex-box">
                                    <img style="width: 50px" src="img/flora-favicon.png">
                                    <p>${sessionScope.USER.fullName}<i></i></p>
                                </li>
                            </ul>
                        </div>
                    </div> 
                    <div class="admin-content-main">
                        <div class="admin-content-main-title">
                            <h1 style="font-size: 36px">Create Flora e-wallet:</h1>
                        </div>
                        <div class="admin-content-main-content">
                            <div class="content-wrapper">
                                <p class="info-text">Welcome to Flora Rewind! Create an e-wallet to start receiving goods.</p>
                                <a href="taotaikhoan">
                                    <button class="deposit-btn">Create E-wallet</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
</section>
<script src="alerJs.js"></script>
<script src="js/javascript.js"></script>
</body>
</html>