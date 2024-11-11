<%-- 
    Document   : EFdetail
    Created on : Oct 4, 2024, 1:41:21 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <link rel="stylesheet" href="alertPackage/alertCss.css">
        <link rel="stylesheet" href="css/snackbar.css">
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>

        <style>

            input[readonly] {
                background-color: white !important; 
                pointer-events: none;               
                cursor: none;
            }
            .disabled-link {
                pointer-events: none;  
                color: gray;          
                text-decoration: none; 
                cursor: default;       
            }
            #commentSection {
                max-height: 300px;
                overflow-y: auto; 
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
                            <a href="home" class="nav-item nav-link">Home</a>
                            <a href="shoppingAction" class="nav-item nav-link">Products</a>
                            <a href="searchAction?navbarShop=1" class="nav-item nav-link">Shop</a>
                            <a href="event" class="nav-item nav-link active">Event</a>
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
                            <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Search End -->



        <!-- Single Page Header start -->
        <div class="container-fluid page-header py-5">
            <h1 class="text-center text-white display-6">Event Flower</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="home">Home</a></li>
                <li class="breadcrumb-item"><a href="event">Event</a></li>
                <li class="breadcrumb-item"><a href="eventDetail?eventId=${requestScope.EVENT_ID}">Event Detail</a></li>
                <li class="breadcrumb-item active text-white">Event Flower</li>
            </ol>
        </div>
        <!-- Single Page Header End -->


        <!-- Single Product Start -->
        <div class="container-fluid py-5 mt-5">
            <div class="container py-5">
                <div class="row g-4 mb-5">
                    <div class="col-lg-8 col-xl-9">
                        <div class="row g-4">
                            <c:set var="detail" value="${requestScope.EPRODUCT_DETAIL}"/>
                            <div class="col-lg-6">
                                <div class="border rounded">
                                    <img src="${detail.eventProductImg}" class="img-fluid rounded" alt="Image" style="width: 471px;height: 536px">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <form action="cartAddEventItem">
                                    <input type="hidden" name="page" value="EProduct_detail">
                                    <h4 class="fw-bold mb-3"><c:out value ="${detail.eventProductName}"/></h4>
                                    <p class="mb-3">Flower Type: <c:out value ="${detail.eventProductType}"/></p>
                                    <p class="mb-3">Flower Condition: <c:out value ="${detail.eventProductCondition}"/></p>
                                    <h5 class="fw-bold mb-3"><fmt:formatNumber value="${detail.eventProductPrice}" type="number" groupingUsed="true"/>đ</h5>
                                    <div class="d-flex mb-4">
                                        <i class="fa fa-star text-secondary"></i>
                                        <i class="fa fa-star text-secondary"></i>
                                        <i class="fa fa-star text-secondary"></i>
                                        <i class="fa fa-star text-secondary"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <p class="mb-4"><c:out value ="${detail.eventProductDetail}"/></p>
                                    <c:if test="${detail.eventProductQuantity == 0}">
                                        <p class="mb-4">Quantity: Out of stock</p>
                                    </c:if>
                                    <c:if test="${detail.eventProductQuantity > 0}">
                                        <p class="mb-4">Quantity: <c:out value ="${detail.eventProductQuantity}"/></p>
                                    </c:if>
                                    <div class="input-group quantity mb-5" style="width: 100px;">
                                        <div class="input-group-btn">
                                            <button type="button" id="btnMinus" class="btn btn-sm btn-minus rounded-circle bg-light border">
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                        <input type="text" name="itemQuantity" id="itemQuantity" class="form-control form-control-sm text-center border-0" value="1" readonly/>
                                        <div class="input-group-btn">
                                            <button type="button" id="btnPlus" class="btn btn-sm btn-plus rounded-circle bg-light border">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>

                                    <input type="hidden" name="eventId" value="${EVENT_ID}">
                                    <input type="hidden" name="productId" value="${detail.eventProductId}">
                                    <input type="hidden" name="imageURL" value="${detail.eventProductImg}">
                                    <input type="hidden" name="productName" value="${detail.eventProductName}">
                                    <input type="hidden" name="productPrice" value="${detail.eventProductPrice}">
                                    <input type="hidden" name="productQuantity" value="${detail.eventProductQuantity}">

                                    <c:if test="${not empty sessionScope.USER}">
                                        <c:if test="${detail.eventProductQuantity == 0}">
                                            <button type="submit" name="btAction" value="Add to cart" class="btn border border-secondary rounded-pill px-3 text-third" disabled="">
                                                <i class="fa fa-shopping-bag me-2 text-third"></i> Out of stock
                                            </button>
                                        </c:if>
                                        <c:if test="${detail.eventProductQuantity > 0}">
                                            <button type="submit" name="btAction" value="Add to cart" class="btn border border-secondary rounded-pill px-3 text-third">
                                                <i class="fa fa-shopping-bag me-2 text-third"></i> Add to cart
                                            </button>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${empty sessionScope.USER}">
                                        <c:if test="${detail.eventProductQuantity == 0}">
                                            <a href="loginPage" class="btn border border-secondary rounded-pill px-3 text-third disabled-link">
                                                <i class="fa fa-shopping-bag me-2 text-third"></i> Out of stock
                                            </a>
                                        </c:if>
                                        <c:if test="${detail.eventProductQuantity > 0}">
                                            <a href="loginPage" class="btn border border-secondary rounded-pill px-3 text-third">
                                                <i class="fa fa-shopping-bag me-2 text-third"></i> Add to cart
                                            </a>
                                        </c:if>
                                    </c:if>
                                </form>
                            </div>
                            <div class="col-lg-12">
                                <nav>
                                    <div class="nav nav-tabs mb-3">
                                        <button class="nav-link border-white border-bottom-0 active" type="button" role="tab"
                                                id="nav-mission-tab" data-bs-toggle="tab" data-bs-target="#nav-mission"
                                                aria-controls="nav-mission" aria-selected="false">Reviews</button>
                                    </div>
                                </nav>
                                <div class="tab-content mb-5">
                                    <div id="commentSection">
                                    </div>
                                    <button id="loadMoreBtn" class="btn btn-secondary">Load more comments</button>
                                    <input type="hidden" id="currentPage" value="1">
                                    <input type="hidden" id="productId" value="${detail.eventProductId}">
                                    <input type="hidden" id="eventId" value="${EVENT_ID}">
                                </div>
                            </div>
                            <form action="reviewAction" id="commentForm" method="POST">
                                <h4 class="mb-5 fw-bold">Leave a Reply</h4>
                                <div class="row g-4">
                                    <div class="col-lg-12">
                                        <div class="border-bottom rounded my-4">
                                            <textarea name="comment" id="comment" class="form-control border-0" cols="30" rows="8" placeholder="Your Review *" spellcheck="false"<c:if test="${empty sessionScope.USER}">disabled=""</c:if> required=""></textarea>
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="d-flex justify-content-between py-3 mb-5">
                                                <div class="d-flex align-items-center">
                                                    <p class="mb-0 me-3">Please rate:</p>
                                                    <div class="d-flex align-items-center" style="font-size: 12px;">
                                                        <i class="fa fa-star text-muted"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <input type="hidden" name="productId" id="productId" value="${detail.eventProductId}">
                                            <input type="hidden" name="eventId" id="eventId" value="${EVENT_ID}">
                                            <input type="submit" value="Post Comment" id="postCommentBtn" class="btn border border-secondary text-third rounded-pill px-4 py-3" <c:if test="${empty sessionScope.USER}">disabled=""</c:if>/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Single Product End -->


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
        <c:if test="${not empty requestScope.INSUFFICIENT}">
            <div id="modal-alert" class="modal-alert">
                <div class="modal-alert-fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="" role="document">
                        <div class="modal-content-alert">
                            <h5 class="modal-title-alert">${requestScope.INSUFFICIENT}</h5>
                            <p>Vui lòng hãy chọn sản phẩm khác</p>
                            <button class="btn-secondary-alert">Ok</button>
                        </div>                     `
                    </div>
                </div>
            </div>
        </c:if>


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
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var quantityInput = document.getElementById("itemQuantity");
                var btnMinus = document.getElementById("btnMinus");
                var btnPlus = document.getElementById("btnPlus");

                btnMinus.addEventListener("click", function () {
                    var currentValue = parseInt(quantityInput.value, 10);
                    if (currentValue <= 1) {
                        quantityInput.value = 1;
                    }
                });

                btnPlus.addEventListener("click", function () {
                    var currentValue = parseInt(quantityInput.value, 10);
                    if (currentValue >= ${detail.eventProductQuantity}) {
                        quantityInput.value = ${detail.eventProductQuantity};
                    }
                });
            });

            $(document).ready(function () {
                $('#commentForm').on('submit', function (event) {
                    event.preventDefault();

                    var comment = $('#comment').val();
                    var productId = $('#productId').val();
                    var eventId = $('#eventId').val();

                    $.ajax({
                        type: 'POST',
                        url: 'reviewAction',
                        data: {
                            comment: comment,
                            productId: productId,
                            eventId: eventId
                        },
                        success: function (response) {
                            $('#commentSection').prepend(response);
                            $('#comment').val('');
                        },
                        error: function () {
                            alert('Có lỗi xảy ra khi gửi bình luận.');
                        }
                    });
                });
            });
            $(document).ready(function () {
                loadComments(1);

                $('#loadMoreBtn').click(function () {
                    var currentPage = parseInt($('#currentPage').val());
                    loadComments(currentPage + 1);
                });

                function loadComments(page) {
                    var productId = $('#productId').val();
                    var eventId = $('#eventId').val();

                    $.ajax({
                        type: 'GET',
                        url: 'loadMoreCommentAction',
                        data: {
                            page: page,
                            productId: productId,
                            eventId: eventId
                        },
                        success: function (response) {
                            $('#commentSection').append(response);
                            $('#currentPage').val(page);
                        },
                        error: function () {
                            alert('Có lỗi xảy ra khi tải bình luận.');
                        }
                    });
                }
            });
        </script>
        <c:if test="${not empty sessionScope.USER}">
            <script src="js/notification.js"></script>
        </c:if>
        <script src="alertPackage/alertJs.js"></script>
        <script src="js/main.js"></script>
        <script src="js/newProduct.js"></script>
    </body>

</html>