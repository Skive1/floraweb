<%-- 
    Document   : ChangePasswordJSP
    Created on : Sep 14, 2024, 3:05:30 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.4/components/registrations/registration-7/assets/css/registration-7.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign Up | Buy and sell on the website</title>
<link rel="icon" href="img/flora-favicon.png"/>

<!-- Registration 7 - Bootstrap Brain Component -->
<section class="bg-light p-3 p-md-4 p-xl-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
                <div class="card border border-light-subtle rounded-4">
                    <div class="card-body p-3 p-md-4 p-xl-5">
                        <div class="row">
                            <div class="col-12">
                                <div class="mb-5">
                                    <div class="text-center mb-4">
                                        <a href="home">
                                            <img src="img/floralogo.png" alt="Flora Logo" width="200">
                                        </a>
                                    </div>
                                    <h2 class="h4 text-center">Registration</h2>
                                    <h3 class="fs-6 fw-normal text-secondary text-center m-0">Enter your details to register</h3>
                                </div>
                            </div>
                        </div>
                        <form action="registerAction" method="POST">
                            <c:set var="errors" value="${requestScope.CREATE_ERRORS}"/>
                            <div class="row gy-3 overflow-hidden">
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="txtFullname" value="${param.txtFullname}" id="fullName" placeholder="Full Name">
                                        <label for="fullName" class="form-label">Full Name</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.fullnameError}">
                                                ${errors.fullnameError}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="txtUsername" value="${param.txtUsername}" id="username" placeholder="Username">
                                        <label for="username" class="form-label">Username</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.usernameError}">
                                                ${errors.usernameError}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="email" class="form-control" name="txtEmail" value="${param.txtEmail}" id="email" placeholder="name@example.com">
                                        <label for="email" class="form-label">Email</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.emailError}">
                                                ${errors.emailError}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="txtPassword" id="password" value="" placeholder="Password">
                                        <label for="password" class="form-label">Password</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.passwordError}">
                                                ${errors.passwordError}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="txtConfirm" id="password" value="" placeholder="Confirm Password">
                                        <label for="password" class="form-label">Confirm Password</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.confirmNotMatchError}">
                                                ${errors.confirmNotMatchError}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="txtPhone" id="phone" value="${param.txtPhone}" placeholder="Phone">
                                        <label for="phone" class="form-label">Phone</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.phoneError}">
                                                ${errors.phoneError}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="txtStreet" id="street" value="${param.txtStreet}" placeholder="">
                                        <label for="street" class="form-label">Street</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.streetError}">
                                                ${errors.streetError}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <select class="form-control" name="txtCity" id="city">
                                            <option value="unknown" selected>Chọn thành phố</option>
                                            <option value="An Giang">An Giang</option>
                                            <option value="Bà Rịa Vũng Tàu">Bà Rịa Vũng Tàu</option>
                                            <option value="Bắc Giang">Bắc Giang</option>
                                            <option value="Bắc Kạn">Bắc Kạn</option>
                                            <option value="Bạc Liêu">Bạc Liêu</option>
                                            <option value="Bắc Ninh">Bắc Ninh</option>
                                            <option value="Bến Tre">Bến Tre</option>
                                            <option value="Bình Định">Bình Định</option>
                                            <option value="Bình Dương">Bình Dương</option>
                                            <option value="Bình Phước">Bình Phước</option>
                                            <option value="Bình Thuận">Bình Thuận</option>
                                            <option value="Cà Mau">Cà Mau</option>
                                            <option value="Cần Thơ">Cần Thơ</option>
                                            <option value="Cao Bằng">Cao Bằng</option>
                                            <option value="Đà Nẵng">Đà Nẵng</option>
                                            <option value="Đắk Lắk">Đắk Lắk</option>
                                            <option value="Đắk Nông">Đắk Nông</option>
                                            <option value="Điện Biên">Điện Biên</option>
                                            <option value="Đồng Nai">Đồng Nai</option>
                                            <option value="Đồng Tháp">Đồng Tháp</option>
                                            <option value="Gia Lai">Gia Lai</option>
                                            <option value="Hà Giang">Hà Giang</option>
                                            <option value="Hà Nam">Hà Nam</option>
                                            <option value="Hà Nội">Hà Nội</option>
                                            <option value="Hà Tĩnh">Hà Tĩnh</option>
                                            <option value="Hải Dương">Hải Dương</option>
                                            <option value="Hải Phòng">Hải Phòng</option>
                                            <option value="Hậu Giang">Hậu Giang</option>
                                            <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                                            <option value="Hòa Bình">Hòa Bình</option>
                                            <option value="Hưng Yên">Hưng Yên</option>
                                            <option value="Khánh Hòa">Khánh Hòa</option>
                                            <option value="Kiên Giang">Kiên Giang</option>
                                            <option value="Kon Tum">Kon Tum</option>
                                            <option value="Lai Châu">Lai Châu</option>
                                            <option value="Lâm Đồng">Lâm Đồng</option>
                                            <option value="Lạng Sơn">Lạng Sơn</option>
                                            <option value="Lào Cai">Lào Cai</option>
                                            <option value="Long An">Long An</option>
                                            <option value="Nam Định">Nam Định</option>
                                            <option value="Nghệ An">Nghệ An</option>
                                            <option value="Ninh Bình">Ninh Bình</option>
                                            <option value="Ninh Thuận">Ninh Thuận</option>
                                            <option value="Phú Thọ">Phú Thọ</option>
                                            <option value="Phú Yên">Phú Yên</option>
                                            <option value="Quảng Bình">Quảng Bình</option>
                                            <option value="Quảng Nam">Quảng Nam</option>
                                            <option value="Quảng Ngãi">Quảng Ngãi</option>
                                            <option value="Quảng Ninh">Quảng Ninh</option>
                                            <option value="Quảng Trị">Quảng Trị</option>
                                            <option value="Sóc Trăng">Sóc Trăng</option>
                                            <option value="Sơn La">Sơn La</option>
                                            <option value="Tây Ninh">Tây Ninh</option>
                                            <option value="Thái Bình">Thái Bình</option>
                                            <option value="Thái Nguyên">Thái Nguyên</option>
                                            <option value="Thanh Hóa">Thanh Hóa</option>
                                            <option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
                                            <option value="Tiền Giang">Tiền Giang</option>
                                            <option value="Trà Vinh">Trà Vinh</option>
                                            <option value="Tuyên Quang">Tuyên Quang</option>
                                            <option value="Vĩnh Long">Vĩnh Long</option>
                                            <option value="Vĩnh Phúc">Vĩnh Phúc</option>
                                            <option value="Yên Bái">Yên Bái</option>

                                        </select>
                                        <label for="city" class="form-label">City</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <label class="form-label text-secondary">Gender:</label>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" value="Nam" name="txtGender" id="male" required checked>
                                        <label class="form-check-label text-secondary" for="male">
                                            Nam
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" value="Nữ" name="txtGender" id="female" required>
                                        <label class="form-check-label text-secondary" for="female">
                                            Nữ
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" value="Ẩn" name="txtGender" id="hidden" required>
                                        <label class="form-check-label text-secondary" for="hidden">
                                            Ẩn
                                        </label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" name="iAgree" id="iAgree" required>
                                        <label class="form-check-label text-secondary" for="iAgree">
                                            I agree to the <a href="#!" class="link-primary text-decoration-none">terms and conditions</a>
                                        </label>
                                    </div>
                                </div>              
                                <div class="col-12">
                                    <div class="d-grid">
                                        <input type="submit" value="Sign up" class="btn bsb-btn-xl btn-primary" name="btAction" />
                                    </div>
                                </div>
                                <div style="color: red">
                                    <c:if test="${not empty errors.emailIsExisted}">
                                        ${errors.emailIsExisted}
                                    </c:if>
                                </div>
                                <div style="color: red">
                                    <c:if test="${not empty errors.usernameIsExisted}">

                                        ${errors.usernameIsExisted}
                                    </c:if>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-12">
                                <hr class="mt-5 mb-4 border-secondary-subtle">
                                <p class="m-0 text-secondary text-center">Already have an account? <a href="loginPage" class="link-primary text-decoration-none">Sign in</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
