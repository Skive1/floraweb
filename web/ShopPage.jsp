<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Search product</title>
        <%--<title>Fruitables - Vegetable Website Template</title>--%>
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
                            <a href="home" class="nav-item nav-link">Home</a>
                            <a href="shoppingAction" class="nav-item nav-link">Sản phẩm</a>
                            <input type="hidden" name="navbarShop" value="1" id="navbarShop"/>
                            <form method="POST" action="searchAction" id="searchProduct">
                                <a href="#" class="nav-item nav-link active"
                                   onclick="document.getElementById('navbarShop'); document.getElementById('searchProduct').submit()">Shop</a>
                            </form>
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

        <!-- Modal Search End -->

        <!-- Single Page Header start -->
        <div class="container-fluid py-5 mb-5 hero-header">
            <h1 class="text-center text-white display-6">Shop</h1>

        </div>
        <!-- Single Page Header End -->

        <!-- Fruits Shop Start-->
        <div class="container-fluid fruite py-5">
            <div class="container py-5">
                <h1 class="mb-4">Flower shop</h1>
                <div class="row g-4">
                    <div class="col-lg-12">
                        <div class="row g-4">
                            <div class="col-xl-3">
                                <form action="searchAction" method="POST">
                                    <div class="input-group w-100 mx-auto d-flex">
                                        <input type="search" name="txtSearchValue" value="${sessionScope.lastSearch}" 
                                               class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                                        <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                                    </div>
                                </form>
                            </div>
                            <div class="col-7"></div>
                            <div class="col-xl-2">
                                <div class="bg-light ps-3 py-3 rounded d-flex justify-content-center mb-4">
                                    <label for="fruits" >Sort price:</label>
                                    <form id="orderByForm" action="orderBy" method="POST">
                                        <input type="hidden" id="txtOrderBy" name="txtOrderBy"/>
                                        <c:if test="${sessionScope.txtOrderBy == 'default'}">
                                            <button type="submit" style="border: 0; background: none;" class="bg-light" 
                                                    onclick="document.getElementById('txtOrderBy').value = 'default';
                                                            document.getElementById('orderByForm').submit();">
                                                <span style="color: black;">&uarr;</span><span style="color: black;">&darr;</span>
                                            </button>
                                        </c:if>
                                        <c:if test="${sessionScope.txtOrderBy == 'ascending'}">
                                            <button type="submit" style="border: 0; background: none;" class="bg-light" 
                                                    onclick="document.getElementById('txtOrderBy').value = 'ascending';
                                                            document.getElementById('orderByForm').submit();">
                                                <span style="color: red;">&uarr;</span><span style="color: black;">&darr;</span>
                                            </button>
                                        </c:if>
                                        <c:if test="${sessionScope.txtOrderBy == 'descending'}">
                                            <button type="submit" style="border: 0; background: none;" class="bg-light" 
                                                    onclick="document.getElementById('txtOrderBy').value = 'descending';
                                                            document.getElementById('orderByForm').submit();">
                                                <span style="color: black;">&uarr;</span><span style="color: red;">&darr;</span>
                                            </button>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="row g-4">
                            <div class="col-lg-3">
                                <div class="row g-4">
                                    <div class="col-lg-12">
                                        <div class="mb-3">
                                            <h4>Categories</h4>
                                            <ul class="list-unstyled fruite-categorie">
                                                <form id="categoriesForm" action="SearchForTypeServlet" method="POST">
                                                    <li>
                                                        <div class="d-flex justify-content-between fruite-name">
                                                            <input type="hidden" id="categories" name="categories"/>
                                                            <a href="#" onclick="document.getElementById('categories').value = 'Toàn bộ';
                                                                    document.getElementById('categoriesForm').submit();"><i class="fas fa-apple-alt me-2"></i>
                                                                Toàn bộ
                                                            </a>
                                                            <span>(${sessionScope.allType})</span>
                                                        </div>
                                                    </li>
                                                    <c:if test="${sessionScope.freshFlower != 0}">
                                                        <li>
                                                            <div class="d-flex justify-content-between fruite-name">
                                                                <input type="hidden" id="categories" name="categories"/>
                                                                <a href="#" onclick="document.getElementById('categories').value = 'Hoa ly';
                                                                        document.getElementById('categoriesForm').submit();"><i class="fas fa-apple-alt me-2"></i>
                                                                    Hoa ly
                                                                </a>
                                                                <span>(${sessionScope.freshFlower})</span>
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                    <c:if test="${sessionScope.pottedFlower != 0}">
                                                        <li>
                                                            <div class="d-flex justify-content-between fruite-name">
                                                                <input type="hidden" id="categories" name="categories"/>
                                                                <a href="#" onclick="document.getElementById('categories').value = 'Hoa hồng';
                                                                        document.getElementById('categoriesForm').submit();"><i class="fas fa-apple-alt me-2"></i>
                                                                    Hoa hồng
                                                                </a>
                                                                <span>(${sessionScope.pottedFlower})</span>
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                    <c:if test="${sessionScope.dryFlower != 0}">
                                                        <li>
                                                            <div class="d-flex justify-content-between fruite-name">
                                                                <input type="hidden" id="categories" name="categories"/>
                                                                <a href="#" onclick="document.getElementById('categories').value = 'Hoa hướng dương';
                                                                        document.getElementById('categoriesForm').submit();"><i class="fas fa-apple-alt me-2"></i>
                                                                    Hoa hướng dương
                                                                </a>
                                                                <span>(${sessionScope.dryFlower})</span>
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                    <c:if test="${sessionScope.otherType != 0}">
                                                        <li>
                                                            <div class="d-flex justify-content-between fruite-name">
                                                                <input type="hidden" id="categories" name="categories"/>
                                                                <a href="#" onclick="document.getElementById('categories').value = 'Other Flower';
                                                                        document.getElementById('categoriesForm').submit();"><i class="fas fa-apple-alt me-2"></i>
                                                                    Other type
                                                                </a>
                                                                <span>(${sessionScope.otherType})</span>
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                </form>
                                            </ul>
                                        </div>
                                    </div>
                                    <form id="searchRangeAndColor" action="searchFindError" method="POST">
                                        <div class="col-lg-12">
                                            <c:if test="${sessionScope.PriceFromSave == null && sessionScope.PriceToSave == null}">
                                                <h4 class="mb-2">Price: </h4>
                                            </c:if>
                                            <c:if test="${sessionScope.PriceFromSave != null && sessionScope.PriceToSave != null}">
                                                <h4 class="mb-2">Price: (${sessionScope.PriceFromSave} - ${sessionScope.PriceToSave})</h4>
                                            </c:if>
                                            <div class="d-flex align-items-center justify-content-between mb-3">
                                                <input type="number" name="txtPriceFrom" value="" 
                                                       class="form-control p-3" placeholder="From" style="width: 125px">
                                                <input type="number" name="txtPriceTo" value="" 
                                                       class="form-control p-3" placeholder="To" style="width: 125px">
                                            </div>
                                            <c:set var="errors" value="${requestScope.PRICE_ERROR}"/>
                                            <c:if test="${not empty errors.priceEmpty}">
                                                <font color="red">
                                                ${errors.priceEmpty}
                                                </font> <br/>
                                            </c:if>
                                            <c:if test="${not empty errors.priceInvalid}">
                                                <font color="red">
                                                ${errors.priceInvalid}
                                                </font> <br/>
                                            </c:if>
                                            <c:if test="${not empty errors.priceRangeError}">
                                                <font color="red">
                                                ${errors.priceRangeError}
                                                </font> <br/>
                                            </c:if>

                                        </div>
                                        <div class="col-lg-12">

                                            <select class="form-control" name="txtColor" id="searchRangeAndColor">
                                                <option disabled>Choose color:</option>
                                                <c:forEach var="color" items="${requestScope.requestColor}">
                                                    <c:if test="${color == sessionScope.currentColor}">
                                                        <option value="${sessionScope.currentColor}" selected="selected">${sessionScope.currentColor}</option>
                                                    </c:if>
                                                    <c:if test="${color != sessionScope.currentColor}">
                                                        <option value="${color}">${color}</option>
                                                    </c:if>   
                                                </c:forEach>
                                            </select>
                                            <div class="d-flex justify-content-center my-4">
                                                <a href="#" class="btn border border-secondary px-4 py-3 rounded-pill text-third w-100" 
                                                   onclick="document.getElementById('searchRangeAndColor').submit()">Search</a>
                                            </div>

                                        </div>
                                    </form>
                                    <%--Top new--%>
                                    <div class="col-lg-12">
                                        <h4 class="mb-3">Featured products</h4>
                                        <c:set var="newIncome" value="${requestScope.requestNewProduct}"/>
                                        <c:forEach var="dto" items="${newIncome}">
                                            <div class="d-flex align-items-center justify-content-start">
                                                <div class="rounded me-4" style="width: 100px; height: 100px;">
                                                    <img src="${dto.getImageURL()}" class="img-fluid rounded" alt=""
                                                         style="width: 75%; height: 75%; object-fit: cover;">
                                                </div>
                                                <div>
                                                    <h6 class="mb-2">${dto.getProductName()}</h6>
                                                    <div class="d-flex mb-2">
                                                        <h5 class="fw-bold me-2">
                                                            <fmt:formatNumber value="${dto.getProductPrice()}" pattern="#,###"/> vnd
                                                        </h5>
                                                        <!--                                                        <h5 class="text-danger text-decoration-line-through">
                                                        <fmt:formatNumber value="${(dto.getProductPrice() + 1000000)}" pattern="#,###"/> vnd
                                                    </h5>-->
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="position-relative">
                                            <img src="img/classic-autumn.jpg" class="img-fluid w-100 rounded" alt="">
                                            <div class="position-absolute" style="top: 50%; right: 10px; transform: translateY(-50%);">
                                                <!--                                                <h3 class="text-secondary fw-bold">Fresh <br> Fruits <br> Banner</h3>-->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="row g-4 justify-content-center">
                                    <c:set var="result" value="${requestScope.requestResultList}"/>
                                    <c:forEach var="dto" items="${result}">
                                        <div class="col-md-6 col-lg-6 col-xl-4">
                                            <div class="rounded position-relative fruite-item">
                                                <form action="ProductDetail.jsp" method="POST">
                                                    <input type="hidden" name="productID" value="">
                                                    <div class="fruite-img">
                                                        <button type="submit" style="border: none; background: none; padding: 0;">
                                                            <div class="img-searchPage">
                                                                <img src="${dto.getImageURL()}" class="img-fluid square-img rounded-top" alt="">
                                                            </div>                                                           
                                                        </button>
                                                    </div>
                                                    <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">New</div>
                                                    <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                        <h4 class="small-heading">${dto.getProductName()}</h4>
                                                        <p>${dto.getProductDetail()}</p>
                                                        <div class="d-flex justify-content-between flex-lg-wrap">
                                                            <p class="text-dark fs-5 fw-bold mb-0" style="margin-right: 10px">
                                                                <fmt:formatNumber value="${dto.getProductPrice()}" pattern="#,###"/> vnd
                                                            </p>
                                                            <button type="submit" class="btn border border-secondary rounded-pill px-3 text-third">
                                                                <i class="fa fa-shopping-bag me-2 text-third"></i> Add to cart
                                                            </button>
                                                        </div> 
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <div class="col-12" >
                                        <div class="pagination d-flex justify-content-center mt-5">
                                            <c:if test="${sessionScope.currentPage == 1}"> 
                                                <form>
                                                    <a href="#" class="rounded" style="margin: 1; 
                                                       background-color: gray; color: white; pointer-events: none; opacity: 0.6;">
                                                        &laquo;
                                                    </a>
                                                </form>
                                            </c:if>
                                            <c:if test="${sessionScope.currentPage != 1}"> 
                                                <form id="backForm" action="searchPageChange" method="POST">
                                                    <input type="hidden" id="pageBack" name="pageBack"/>
                                                    <a href="#" class="rounded" style="margin: 1;"
                                                       onclick="document.getElementById('pageBack').value = '${(sessionScope.currentPage - 1)}';
                                                               document.getElementById('backForm').submit();">
                                                        &laquo;
                                                    </a>
                                                </form>
                                            </c:if>
                                            <form id="paginationForm" action="searchPageChange" method="POST">
                                                <input type="hidden" id="pageNo" name="pageNo">
                                                <c:if test="${sessionScope.pageSize <= 5}">
                                                    <c:forEach var="i" begin="1" end="${sessionScope.pageSize}">
                                                        <c:if test="${sessionScope.currentPage == i}">
                                                            <a href="#" class="active rounded" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 0;
                                                               ">${i}</a>
                                                        </c:if>
                                                        <c:if test="${sessionScope.currentPage != i}">
                                                            <a href="#" class="rounded" 
                                                               onclick="document.getElementById('pageNo').value = '${i}';
                                                                       document.getElementById('paginationForm').submit();
                                                                       return false;" style="margin: 0; 
                                                               ">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${sessionScope.pageSize >= 5}">
                                                    <c:if test="${sessionScope.currentPage == 1 || sessionScope.currentPage == 2}">
                                                        <c:forEach var="i" begin="1" end="5">
                                                            <c:if test="${sessionScope.currentPage == i}">
                                                                <a href="#" class="active rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0;
                                                                   ">${i}</a>
                                                            </c:if>
                                                            <c:if test="${sessionScope.currentPage != i}">
                                                                <a href="#" class="rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0; 
                                                                   ">${i}</a>
                                                            </c:if>
                                                        </c:forEach>
                                                        <a href="#" class="rounded" style="margin: 1; border-color: black;
                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;">
                                                            ...
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${sessionScope.currentPage != 1 && sessionScope.currentPage != 2 &&
                                                                  sessionScope.currentPage != (sessionScope.pageSize - 2) &&
                                                                  sessionScope.currentPage != (sessionScope.pageSize - 1) &&
                                                                  sessionScope.currentPage != sessionScope.pageSize}">
                                                        <c:forEach var="i" begin="1" end="2">
                                                            <c:if test="${sessionScope.currentPage == i}">
                                                                <a href="#" class="active rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0;
                                                                   ">${i}</a>
                                                            </c:if>
                                                            <c:if test="${sessionScope.currentPage != i}">
                                                                <a href="#" class="rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0; 
                                                                   ">${i}</a>
                                                            </c:if>
                                                        </c:forEach>
                                                        <a href="#" class="rounded" style="margin: 1; border-color: black;
                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;">
                                                            ...
                                                        </a>
                                                        <c:forEach var="i" begin="${sessionScope.currentPage}" end="${(sessionScope.currentPage + 2)}">
                                                            <c:if test="${sessionScope.currentPage == i}">
                                                                <a href="#" class="active rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0;
                                                                   ">${i}</a>
                                                            </c:if>
                                                            <c:if test="${sessionScope.currentPage != i}">
                                                                <a href="#" class="rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0; 
                                                                   ">${i}</a>
                                                            </c:if>
                                                        </c:forEach>
                                                        <a href="#" class="rounded" style="margin: 1; border-color: black;
                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;">
                                                            ...
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${sessionScope.currentPage == (sessionScope.pageSize - 2) ||
                                                                  sessionScope.currentPage == (sessionScope.pageSize - 1) ||
                                                                  sessionScope.currentPage == sessionScope.pageSize}">
                                                        <c:forEach var="i" begin="1" end="2">
                                                            <c:if test="${sessionScope.currentPage == i}">
                                                                <a href="#" class="active rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0;
                                                                   ">${i}</a>
                                                            </c:if>
                                                            <c:if test="${sessionScope.currentPage != i}">
                                                                <a href="#" class="rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0; 
                                                                   ">${i}</a>
                                                            </c:if>
                                                        </c:forEach>
                                                        <a href="#" class="rounded" style="margin: 1; border-color: black;
                                                           background-color: white; color: black; pointer-events: none; opacity: 0.6;">
                                                            ...
                                                        </a>
                                                        <c:forEach var="i" begin="${(sessionScope.pageSize - 2)}" end="${sessionScope.pageSize}">
                                                            <c:if test="${sessionScope.currentPage == i}">
                                                                <a href="#" class="active rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0;
                                                                   ">${i}</a>
                                                            </c:if>
                                                            <c:if test="${sessionScope.currentPage != i}">
                                                                <a href="#" class="rounded" 
                                                                   onclick="document.getElementById('pageNo').value = '${i}';
                                                                           document.getElementById('paginationForm').submit();
                                                                           return false;" style="margin: 0; 
                                                                   ">${i}</a>
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:if>
                                                </c:if>
                                            </form>
                                            <c:if test="${sessionScope.currentPage != sessionScope.pageSize}"> 
                                                <form id="forwardForm" action="searchPageChange" method="POST">
                                                    <input type="hidden" id="pageForward" name="pageForward"/>
                                                    <a href="#" class="rounded" style="margin: 1;"
                                                       onclick="document.getElementById('pageForward').value = '${(sessionScope.currentPage + 1)}';
                                                               document.getElementById('forwardForm').submit();">
                                                        &raquo;
                                                    </a>
                                                </form>
                                            </c:if>
                                            <c:if test="${sessionScope.currentPage == sessionScope.pageSize}"> 
                                                <form>
                                                    <a href="#" class="rounded" style="margin: 1;
                                                       background-color: gray; color: white; pointer-events: none; opacity: 0.6;">
                                                        &raquo;
                                                    </a>
                                                </form>
                                            </c:if>  
                                        </div>
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
        <div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
            <div class="container py-5">
                <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
                    <div class="row g-4">
                        <div class="col-lg-3">
                            <a href="#">
                                <h1 class="text-third mb-0">Fruitables</h1>
                                <p class="text-secondary mb-0">Fresh products</p>
                            </a>
                        </div>
                        <div class="col-lg-6">
                            <div class="position-relative mx-auto">
                                <input class="form-control border-0 w-100 py-3 px-4 rounded-pill" type="number" placeholder="Your Email">
                                <button type="submit" class="btn btn-primary border-0 border-secondary py-3 px-4 position-absolute rounded-pill text-white" style="top: 0; right: 0;">Subscribe Now</button>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="d-flex justify-content-end pt-3">
                                <a class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-youtube"></i></a>
                                <a class="btn btn-outline-secondary btn-md-square rounded-circle" href=""><i class="fab fa-linkedin-in"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-item">
                            <h4 class="text-light mb-3">Why People Like us!</h4>
                            <p class="mb-4">typesetting, remaining essentially unchanged. It was 
                                popularised in the 1960s with the like Aldus PageMaker including of Lorem Ipsum.</p>
                            <a href="" class="btn border-secondary py-2 px-4 rounded-pill text-third">Read More</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="d-flex flex-column text-start footer-item">
                            <h4 class="text-light mb-3">Shop Info</h4>
                            <a class="btn-link" href="">About Us</a>
                            <a class="btn-link" href="">Contact Us</a>
                            <a class="btn-link" href="">Privacy Policy</a>
                            <a class="btn-link" href="">Terms & Condition</a>
                            <a class="btn-link" href="">Return Policy</a>
                            <a class="btn-link" href="">FAQs & Help</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="d-flex flex-column text-start footer-item">
                            <h4 class="text-light mb-3">Account</h4>
                            <a class="btn-link" href="">My Account</a>
                            <a class="btn-link" href="">Shop details</a>
                            <a class="btn-link" href="">Shopping Cart</a>
                            <a class="btn-link" href="">Wishlist</a>
                            <a class="btn-link" href="">Order History</a>
                            <a class="btn-link" href="">International Orders</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-item">
                            <h4 class="text-light mb-3">Contact</h4>
                            <p>Address: 1429 Netus Rd, NY 48247</p>
                            <p>Email: Example@gmail.com</p>
                            <p>Phone: +0123 4567 8910</p>
                            <p>Payment Accepted</p>
                            <img src="img/payment.png" class="img-fluid" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->

        <!-- Copyright Start -->
        <div class="container-fluid copyright bg-dark py-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        <span class="text-light"><a href="#"><i class="fas fa-copyright text-light me-2"></i>Your Site Name</a>, All right reserved.</span>
                    </div>
                    <div class="col-md-6 my-auto text-center text-md-end text-white">
                        <!--/*** This template is free as long as you keep the below author?s credit link/attribution link/backlink. ***/-->
                        <!--/*** If you'd like to use the template without the below author?s credit link/attribution link/backlink, ***/-->
                        <!--/*** you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". ***/-->
                        Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a> Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
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
    </body>

</html>