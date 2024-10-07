<%-- 
    Document   : eventCartJSP
    Created on : Sep 14, 2024, 1:29:47 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Fruitables - Vegetable Website Template</title>
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
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <style>
            /* Đảm bảo ghi đè toàn bộ kiểu mặc định của input readonly */
            input[readonly] {
                background-color: white !important;  /* Nền trắng */
                pointer-events: none;                /* Ngăn thay đổi */
                cursor: none;
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
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#" class="text-white">123 Street, New York</a></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">Email@Example.com</a></small>
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
                            <a href="home" class="nav-item nav-link">Home</a>
                            <a href="shoppingAction" class="nav-item nav-link">Shop</a>
                            <a href="event" class="nav-item nav-link">Event</a>
                            <a href="contactPage" class="nav-item nav-link">Contact</a>
                            <!--        Session Management  -->
                            <c:if test="${not empty sessionScope.USER}">
                                <!--                Manager Session-->
                                <c:if test="${sessionScope.USER.role == 'Admin'}">
                                    <a href="manageAccount" class="nav-item nav-link">Manage Account</a>
                                </c:if>
                                <!--                Delivery Session-->
                                <c:if test="${sessionScope.USER.role == 'Delivery'}">
                                    <a href="#" class="nav-item nav-link">Delivery Order</a>
                                </c:if>
                                <!--                Seller Session-->
                                <c:if test="${sessionScope.USER.role == 'Seller'}">
                                    <a href="ProductManagementAction" class="nav-item nav-link">Manage Shop</a>
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
                                    <a href="" class="position-relative me-0 nav-link dropdown-toggle d-flex align-items-center">
                                        <i class="fa fa-shopping-bag fa-2x"></i>
                                    </a>
                                    <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                        <a href="cartPage" class="dropdown-item">Cart</a>
                                        <a href="eventCart" class="dropdown-item">Event Cart</a>
                                    </div>
                                </div>

                                <div class="nav-item dropdown">
                                    <a href="" class="nav-link dropdown-toggle d-flex align-items-center" data-bs-toggle="dropdown">
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
            <h1 class="text-center text-white display-6">Giỏ hàng sự kiện</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="home">Home</a></li>
                <li class="breadcrumb-item active text-white">Giỏ hàng</li>
            </ol>
        </div>
        <!-- Single Page Header End -->


        <!-- Cart Page Start -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="table-responsive">
                    <c:set var="ecart" value="${sessionScope.ECART}"/>
                    <c:if test="${not empty ecart && not empty ecart.items}">
                        <c:forEach var="entry" items="${ecart.items}">
                            <c:set var="eventId" value="${entry.key}"/>
                            <c:set var="eventItems" value="${entry.value}"/>
                            <h3>Sự kiện: ${eventId}</h3>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Sản phẩm</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">Đơn Giá</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Thành tiền</th>
                                        <th scope="col">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${eventItems}" varStatus="counter">
                                        <tr>
                                            <th scope="row">
                                                <div class="d-flex align-items-center">
                                                    <img src="${item.img}" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="">
                                                </div>
                                            </th>
                                            <td>
                                                <p class="mb-0 mt-4">${item.epName}</p>
                                            </td>
                                            <td>
                                                <p class="mb-0 mt-4 price-per-unit"><fmt:formatNumber value="${item.unitPrice}" type="number" groupingUsed="true"/>đ</p>
                                            </td>

                                            <td>
                                                <div class="input-group quantity mt-4" style="width: 100px;">
                                                    <form action="eventCartView" method="POST">
                                                        <input type="hidden" name="eventProductName" value="${item.epName}"/>
                                                        <input type="hidden" name="eventName" value="${eventId}"/>
                                                        <div class="input-group">   
                                                            <div class="input-group-btn">
                                                                <button type="submit" name="action" value="minus" id="btn-minus" class="btn btn-sm btn-minus rounded-circle bg-light border"
                                                                        <c:if test="${item.quantity <= 1}">disabled</c:if>>
                                                                            <i class="fa fa-minus"></i>
                                                                        </button>
                                                                </div>
                                                                <input type="text" name="quantity" class="form-control form-control-sm text-center border-0"
                                                                       value="${item.quantity}" readonly="">
                                                            <div class="input-group-btn">
                                                                <button type="submit" id="btn-plus" name="action" value="plus" class="btn btn-sm btn-plus rounded-circle bg-light border"
                                                                        <c:if test="${item.quantity >= item.stockQuantity}">disabled</c:if>>
                                                                            <i class="fa fa-plus"></i>
                                                                        </button>
                                                                </div>  
                                                            </div>
                                                        </form>
                                                    </div>
                                                </td>
                                                <td>
                                                    <p class="mb-0 mt-4 total-price"><fmt:formatNumber value="${item.quantity * item.unitPrice}" type="number" groupingUsed="true"/>đ</p>
                                            </td>
                                            <td>      
                                                <form action="eventCartView" method="POST">
                                                    <input type="hidden" name="ekey" value="${eventId}" />
                                                    <input type="hidden" name="ename" value="${item.epName}" />
                                                    <button type="submit" name="rmvButton" value="delete" class="btn btn-md rounded-circle bg-light border mt-4">
                                                        <i class="fa fa-times text-danger"></i>
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty ecart || empty ecart.items}">
                        <div class="d-flex align-items-center justify-content-center">
                            <h3>Your event cart is empty</h3>
                        </div>

                    </c:if>
                </div>
                <div class="mt-5">
                    <input type="text" class="border-0 border-bottom rounded me-5 py-3 mb-4" placeholder="Coupon Code" <c:if test="${empty ecart || empty ecart.items}">readonly=""</c:if>>
                    <button class="btn border-secondary rounded-pill px-4 py-3 text-third" type="button" <c:if test="${empty ecart || empty ecart.items}">disabled="disabled"</c:if>>Apply Coupon</button>
                    </div>

                    <div class="row g-4 justify-content-end">
                        <div class="col-8"></div>
                        <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
                            <form action="checkout" method="POST">
                                <div class="bg-light rounded">
                                    <div class="p-4">
                                        <h1 class="display-6 mb-4">Cart <span class="fw-normal">Total</span></h1>
                                        <div class="d-flex justify-content-between mb-4">
                                            <h5 class="mb-0 me-4">Subtotal:</h5>
                                            <p class="mb-0"><fmt:formatNumber value="${sessionScope.ETOTAL}" type="number" groupingUsed="true"/>đ</p>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <h5 class="mb-0 me-4">Discount:</h5>
                                        <div class="">
                                            <p class="mb-0"></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                                    <h5 class="mb-0 ps-4 me-4">Total</h5>
                                    <p class="mb-0 pe-4"><fmt:formatNumber value="${sessionScope.ETOTAL}" type="number" groupingUsed="true"/>đ</p>
                                    <input type="hidden" name="total" value="${sessionScope.ETOTAL}"/>
                                </div>
                                <button class="btn border-secondary rounded-pill px-4 py-3 text-third text-uppercase mb-4 ms-4" type="submit" <c:if test="${empty ecart || empty ecart.items}">disabled="disabled"</c:if>>Mua Hàng</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Cart Page End -->


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
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
        <script>
            document.getElementById("minusButton").addEventListener("click", function () {
                document.getElementById("action").value = "minus";
                document.querySelector("form").submit();
            });
            document.getElementById("plusButton").addEventListener("click", function () {
                document.getElementById("action").value = "plus";
                document.querySelector("form").submit();
            });
        </script>
    </body>

</html>