<%-- 
    Document   : shop
    Created on : Sep 20, 2024, 9:23:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/indicator.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="alertPackage/alertCss.css">
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <style>
            .fruite-item {
                height: 450px;
                display: flex; 
                flex-direction: column; 
                overflow: hidden; 
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
                            <a href="home" class="nav-item nav-link">Home</a>
                            <a href="shoppingAction" class="nav-item nav-link active">Products</a>
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
                            <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Search End -->



        <!-- Single Page Header start -->
        <div class="container-fluid page-header py-5">
            <h1 class="text-center text-white display-6">Products</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="home">Home</a></li>
                <li class="breadcrumb-item active text-white">Products</li>
            </ol>
        </div>
        <!-- Single Page Header End -->


        <!-- Fruits Shop Start-->
        <div class="container-fluid fruite py-5">
            <div class="container py-5">
                <h1 class="mb-4">List of Flowers:</h1>
                <div class="row g-4">
                    <div class="col-lg-12">
                        <div class="row g-4">
                            <div class="col-xl-3">
                                <div class="input-group w-100 mx-auto d-flex">
                                    <input type="search" class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                                    <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                                </div>
                            </div>
                            <div class="col-6"></div>
                            <div class="col-xl-3">
                                
                            </div>
                        </div>
                        <div class="row g-4">
                            <div class="col-lg-3">
                                <div class="row g-4">
                                    <div class="col-lg-12">
                                        <div class="mb-3">
                                            <h4>Categories</h4>
                                            <ul class="list-unstyled fruite-categorie">
                                                <li>
                                                    <div class="d-flex justify-content-between fruite-name"> 
                                                        <a href="shoppingAction"><i class="fas fa-apple-alt me-2"></i>All products</a>
                                                        <span>(${requestScope.allProducts})</span>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-lg-12">
                                                                            <div class="mb-3">
                                                                                <h4 class="mb-2">Price</h4>
                                                                                <input type="range" class="form-range w-100" id="rangeInput" name="rangeInput" min="0" max="500" value="0" oninput="amount.value=rangeInput.value">
                                                                                <output id="amount" name="amount" min-velue="0" max-value="500" for="rangeInput">0</output>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-lg-12">
                                                                            <div class="mb-3">
                                                                                <h4>Additional</h4>
                                                                                <div class="mb-2">
                                                                                    <input type="radio" class="me-2" id="Categories-1" name="Categories-1" value="Beverages">
                                                                                    <label for="Categories-1"> Organic</label>
                                                                                </div>
                                                                                <div class="mb-2">
                                                                                    <input type="radio" class="me-2" id="Categories-2" name="Categories-1" value="Beverages">
                                                                                    <label for="Categories-2"> Fresh</label>
                                                                                </div>
                                                                                <div class="mb-2">
                                                                                    <input type="radio" class="me-2" id="Categories-3" name="Categories-1" value="Beverages">
                                                                                    <label for="Categories-3"> Sales</label>
                                                                                </div>
                                                                                <div class="mb-2">
                                                                                    <input type="radio" class="me-2" id="Categories-4" name="Categories-1" value="Beverages">
                                                                                    <label for="Categories-4"> Discount</label>
                                                                                </div>
                                                                                <div class="mb-2">
                                                                                    <input type="radio" class="me-2" id="Categories-5" name="Categories-1" value="Beverages">
                                                                                    <label for="Categories-5"> Expired</label>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-lg-12">
                                                                            <h4 class="mb-3">Featured products</h4>
                                                                            <div class="d-flex align-items-center justify-content-start">
                                                                                <div class="rounded me-4" style="width: 100px; height: 100px;">
                                                                                    <img src="img/featur-1.jpg" class="img-fluid rounded" alt="">
                                                                                </div>
                                                                                <div>
                                                                                    <h6 class="mb-2">Big Banana</h6>
                                                                                    <div class="d-flex mb-2">
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star"></i>
                                                                                    </div>
                                                                                    <div class="d-flex mb-2">
                                                                                        <h5 class="fw-bold me-2">2.99 $</h5>
                                                                                        <h5 class="text-danger text-decoration-line-through">4.11 $</h5>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="d-flex align-items-center justify-content-start">
                                                                                <div class="rounded me-4" style="width: 100px; height: 100px;">
                                                                                    <img src="img/featur-2.jpg" class="img-fluid rounded" alt="">
                                                                                </div>
                                                                                <div>
                                                                                    <h6 class="mb-2">Big Banana</h6>
                                                                                    <div class="d-flex mb-2">
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star"></i>
                                                                                    </div>
                                                                                    <div class="d-flex mb-2">
                                                                                        <h5 class="fw-bold me-2">2.99 $</h5>
                                                                                        <h5 class="text-danger text-decoration-line-through">4.11 $</h5>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="d-flex align-items-center justify-content-start">
                                                                                <div class="rounded me-4" style="width: 100px; height: 100px;">
                                                                                    <img src="img/featur-3.jpg" class="img-fluid rounded" alt="">
                                                                                </div>
                                                                                <div>
                                                                                    <h6 class="mb-2">Big Banana</h6>
                                                                                    <div class="d-flex mb-2">
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star text-secondary"></i>
                                                                                        <i class="fa fa-star"></i>
                                                                                    </div>
                                                                                    <div class="d-flex mb-2">
                                                                                        <h5 class="fw-bold me-2">2.99 $</h5>
                                                                                        <h5 class="text-danger text-decoration-line-through">4.11 $</h5>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="d-flex justify-content-center my-4">
                                                                                <a href="#" class="btn border border-secondary px-4 py-3 rounded-pill text-third w-100">Vew More</a>
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-lg-12">
                                        <div class="position-relative">
                                            <img src="img/banner-fruits.jpg" class="img-fluid w-100 rounded" alt="">
                                            <div class="position-absolute" style="top: 50%; right: 10px; transform: translateY(-50%);">
                                                <h3 class="text-secondary fw-bold">Fresh <br> Fruits <br> Banner</h3>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="row g-4 justify-content-center">
                                    <c:forEach var="product" items="${requestScope.products}">
                                        <div class="col-md-6 col-lg-6 col-xl-4">
                                            <form action="cartAddItem">
                                                <input type="hidden" name="page" value="shop"/>
                                                <input type="hidden" name="pageIndex" value="${currentPage}"/>
                                                <div class="rounded position-relative fruite-item">
                                                    <div class="fruite-img">
                                                        <img src="${product.imageURL}" class="img-fluid w-100 rounded-top" alt="${product.productName}">
                                                    </div>
                                                    <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">
                                                        ${product.productType} 
                                                    </div>
                                                    <div class="p-4 custom-orange-border p-3 border-top-0 rounded-bottom">
                                                        <c:url var="urlRewriting" value="productDetail">
                                                            <c:param name="productId" value="${product.productId}"/>
                                                            <c:param name="productType" value="${product.productType}"/>
                                                        </c:url>
                                                        <a href="${urlRewriting}">
                                                            <h4 style="height: 50px">${product.productName}</h4>
                                                        </a>
                                                        <p style="height: 50px">${product.productDetail}</p>
                                                        <div class="d-flex justify-content-between flex-lg-wrap">
                                                            <p class="text-dark fs-5 fw-bold mb-0">
                                                                <fmt:formatNumber value="${product.productPrice}" type="number" groupingUsed="true"/>đ
                                                            </p>
                                                            <!-- Hidden inputs to pass product details to the servlet -->
                                                            <input type="hidden" name="productId" value="${product.productId}">
                                                            <input type="hidden" name="storeId" value="${product.storeId}">
                                                            <input type="hidden" name="imageURL" value="${product.imageURL}">
                                                            <input type="hidden" name="productName" value="${product.productName}">
                                                            <input type="hidden" name="productPrice" value="${product.productPrice}">
                                                            <input type="hidden" name="productQuantity" value="${product.productQuantity}">
                                                            <input type="hidden" name="itemQuantity" value="1">
                                                            <c:if test="${not empty sessionScope.USER}">
                                                                <c:if test="${product.productQuantity > 0}">
                                                                    <button type="submit" name="btAction" value="Add to cart" class="btn border border-secondary rounded-pill px-3 text-third">
                                                                        <i class="fa fa-shopping-bag me-2 text-third"></i> Add to cart
                                                                    </button>
                                                                </c:if>
                                                                <c:if test="${product.productQuantity == 0}">
                                                                    <button type="submit" name="btAction" value="Add to cart" class="btn border border-secondary rounded-pill px-3 text-third" disabled="">
                                                                        <i class="fa fa-shopping-bag me-2 text-third"></i> Out of stock
                                                                    </button>
                                                                </c:if>
                                                            </c:if>
                                                            <c:if test="${empty sessionScope.USER}">
                                                                <c:if test="${product.productQuantity == 0}">
                                                                    <a href="loginPage" class="btn border border-secondary rounded-pill px-3 text-third disabled-link">
                                                                        <i class="fa fa-shopping-bag me-2 text-third"></i> Out of stock
                                                                    </a>
                                                                </c:if>
                                                                <c:if test="${product.productQuantity > 0}">
                                                                    <a href="loginPage" class="btn border border-secondary rounded-pill px-3 text-third">
                                                                        <i class="fa fa-shopping-bag me-2 text-third"></i> Add to cart
                                                                    </a>
                                                                </c:if>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </c:forEach>
                                    <div class="col-12">
                                        <nav aria-label="Page navigation">
                                            <ul class="pagination d-flex justify-content-center mt-5">
                                                <c:if test="${currentPage > 1}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="shoppingAction?page=${currentPage - 1}" aria-label="Previous">
                                                            <span aria-hidden="true">&laquo;</span>
                                                        </a>
                                                    </li>
                                                </c:if>
                                                <c:forEach var="i" begin="1" end="${totalPages}">
                                                    <li class="page-item ${i == currentPage ? 'active' : ''}">
                                                        <a class="page-link" href="shoppingAction?page=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <c:if test="${currentPage < totalPages}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="shoppingAction?page=${currentPage + 1}" aria-label="Next">
                                                            <span aria-hidden="true">&raquo;</span>
                                                        </a>
                                                    </li>
                                                </c:if>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fruits Shop End-->


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
        <c:if test="${not empty requestScope.INSUFFICIENTSHOP}">
            <div id="modal-alert" class="modal-alert">
                <div class="modal-alert-fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="" role="document">
                        <div class="modal-content-alert">
                            <h5 class="modal-title-alert">${requestScope.INSUFFICIENTSHOP}</h5>
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
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Template Javascript -->
        <script src="alertPackage/alertJs.js"></script>
        <script src="js/main.js"></script>
        <script src="js/newProduct.js"></script>
    </body>

</html>
