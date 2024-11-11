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
                                            <option value="An Giang"
                                                    <c:if test="${param.txtCity == 'An Giang'}">
                                                        selected="selected"
                                                    </c:if>>An Giang</option>
                                            <option value="Bà Rịa Vũng Tàu"
                                                    <c:if test="${param.txtCity == 'Bà Rịa Vũng Tàu'}">
                                                        selected="selected"
                                                    </c:if>>Bà Rịa Vũng Tàu</option>
                                            <option value="Bắc Giang"
                                                    <c:if test="${param.txtCity == 'Bắc Giang'}">
                                                        selected="selected"
                                                    </c:if>>Bắc Giang</option>
                                            <option value="Bắc Kạn"
                                                    <c:if test="${param.txtCity == 'Bắc Kạn'}">
                                                        selected="selected"
                                                    </c:if>>Bắc Kạn</option>
                                            <option value="Bạc Liêu"
                                                    <c:if test="${param.txtCity == 'Bạc Liêu'}">
                                                        selected="selected"
                                                    </c:if>>Bạc Liêu</option>
                                            <option value="Bắc Ninh"
                                                    <c:if test="${param.txtCity == 'Bắc Ninh'}">
                                                        selected="selected"
                                                    </c:if>>Bắc Ninh</option>
                                            <option value="Bến Tre"
                                                    <c:if test="${param.txtCity == 'Bến Tre'}">
                                                        selected="selected"
                                                    </c:if>>Bến Tre</option>
                                            <option value="Bình Định"
                                                    <c:if test="${param.txtCity == 'Bình Định'}">
                                                        selected="selected"
                                                    </c:if>>Bình Định</option>
                                            <option value="Bình Dương"
                                                    <c:if test="${param.txtCity == 'Bình Dương'}">
                                                        selected="selected"
                                                    </c:if>>Bình Dương</option>
                                            <option value="Bình Phước"
                                                    <c:if test="${param.txtCity == 'Bình Phước'}">
                                                        selected="selected"
                                                    </c:if>>Bình Phước</option>
                                            <option value="Bình Thuận"
                                                    <c:if test="${param.txtCity == 'Bình Thuận'}">
                                                        selected="selected"
                                                    </c:if>>Bình Thuận</option>
                                            <option value="Cà Mau"
                                                    <c:if test="${param.txtCity == 'Cà Mau'}">
                                                        selected="selected"
                                                    </c:if>>Cà Mau</option>
                                            <option value="Cần Thơ"
                                                    <c:if test="${param.txtCity == 'Cần Thơ'}">
                                                        selected="selected"
                                                    </c:if>>Cần Thơ</option>
                                            <option value="Cao Bằng"
                                                    <c:if test="${param.txtCity == 'Cao Bằng'}">
                                                        selected="selected"
                                                    </c:if>>Cao Bằng</option>
                                            <option value="Đà Nẵng"
                                                    <c:if test="${param.txtCity == 'Đà Nẵng'}">
                                                        selected="selected"
                                                    </c:if>>Đà Nẵng</option>
                                            <option value="Đắk Lắk"
                                                    <c:if test="${param.txtCity == 'Đắk Lắk'}">
                                                        selected="selected"
                                                    </c:if>>Đắk Lắk</option>
                                            <option value="Đắk Nông"
                                                    <c:if test="${param.txtCity == 'Đắk Nông'}">
                                                        selected="selected"
                                                    </c:if>>Đắk Nông</option>
                                            <option value="Điện Biên"
                                                    <c:if test="${param.txtCity == 'Điện Biên'}">
                                                        selected="selected"
                                                    </c:if>>Điện Biên</option>
                                            <option value="Đồng Nai"
                                                    <c:if test="${param.txtCity == 'Đồng Nai'}">
                                                        selected="selected"
                                                    </c:if>>Đồng Nai</option>
                                            <option value="Đồng Tháp"
                                                    <c:if test="${param.txtCity == 'Đồng Tháp'}">
                                                        selected="selected"
                                                    </c:if>>Đồng Tháp</option>
                                            <option value="Gia Lai"
                                                    <c:if test="${param.txtCity == 'Gia Lai'}">
                                                        selected="selected"
                                                    </c:if>>Gia Lai</option>
                                            <option value="Hà Giang"
                                                    <c:if test="${param.txtCity == 'Hà Giang'}">
                                                        selected="selected"
                                                    </c:if>>Hà Giang</option>
                                            <option value="Hà Nam"
                                                    <c:if test="${param.txtCity == 'Hà Nam'}">
                                                        selected="selected"
                                                    </c:if>>Hà Nam</option>
                                            <option value="Hà Nội"
                                                    <c:if test="${param.txtCity == 'Hà Nội'}">
                                                        selected="selected"
                                                    </c:if>>Hà Nội</option>
                                            <option value="Hà Tĩnh"
                                                    <c:if test="${param.txtCity == 'Hà Tĩnh'}">
                                                        selected="selected"
                                                    </c:if>>Hà Tĩnh</option>
                                            <option value="Hải Dương"
                                                    <c:if test="${param.txtCity == 'Hải Dương'}">
                                                        selected="selected"
                                                    </c:if>>Hải Dương</option>
                                            <option value="Hải Phòng"
                                                    <c:if test="${param.txtCity == 'Hải Phòng'}">
                                                        selected="selected"
                                                    </c:if>>Hải Phòng</option>
                                            <option value="Hậu Giang"
                                                    <c:if test="${param.txtCity == 'Hậu Giang'}">
                                                        selected="selected"
                                                    </c:if>>Hậu Giang</option>
                                            <option value="Hồ Chí Minh"
                                                    <c:if test="${param.txtCity == 'Hồ Chí Minh'}">
                                                        selected="selected"
                                                    </c:if>>Hồ Chí Minh</option>
                                            <option value="Hòa Bình"
                                                    <c:if test="${param.txtCity == 'Hòa Bình'}">
                                                        selected="selected"
                                                    </c:if>>Hòa Bình</option>
                                            <option value="Hưng Yên"
                                                    <c:if test="${param.txtCity == 'Hưng Yên'}">
                                                        selected="selected"
                                                    </c:if>>Hưng Yên</option>
                                            <option value="Khánh Hòa"
                                                    <c:if test="${param.txtCity == 'Khánh Hòa'}">
                                                        selected="selected"
                                                    </c:if>>Khánh Hòa</option>
                                            <option value="Kiên Giang"
                                                    <c:if test="${param.txtCity == 'Kiên Giang'}">
                                                        selected="selected"
                                                    </c:if>>Kiên Giang</option>
                                            <option value="Kon Tum"
                                                    <c:if test="${param.txtCity == 'Kon Tum'}">
                                                        selected="selected"
                                                    </c:if>>Kon Tum</option>
                                            <option value="Lai Châu"
                                                    <c:if test="${param.txtCity == 'Lai Châu'}">
                                                        selected="selected"
                                                    </c:if>>Lai Châu</option>
                                            <option value="Lâm Đồng"
                                                    <c:if test="${param.txtCity == 'Lâm Đồng'}">
                                                        selected="selected"
                                                    </c:if>>Lâm Đồng</option>
                                            <option value="Lạng Sơn"
                                                    <c:if test="${param.txtCity == 'Lạng Sơn'}">
                                                        selected="selected"
                                                    </c:if>>Lạng Sơn</option>
                                            <option value="Lào Cai"
                                                    <c:if test="${param.txtCity == 'Lào Cai'}">
                                                        selected="selected"
                                                    </c:if>>Lào Cai</option>
                                            <option value="Long An"
                                                    <c:if test="${param.txtCity == 'Long An'}">
                                                        selected="selected"
                                                    </c:if>>Long An</option>
                                            <option value="Nam Định"
                                                    <c:if test="${param.txtCity == 'Nam Định'}">
                                                        selected="selected"
                                                    </c:if>>Nam Định</option>
                                            <option value="Nghệ An"
                                                    <c:if test="${param.txtCity == 'Nghệ An'}">
                                                        selected="selected"
                                                    </c:if>>Nghệ An</option>
                                            <option value="Ninh Bình"
                                                    <c:if test="${param.txtCity == 'Ninh Bình'}">
                                                        selected="selected"
                                                    </c:if>>Ninh Bình</option>
                                            <option value="Ninh Thuận"
                                                    <c:if test="${param.txtCity == 'Ninh Thuận'}">
                                                        selected="selected"
                                                    </c:if>>Ninh Thuận</option>
                                            <option value="Phú Thọ"
                                                    <c:if test="${param.txtCity == 'Phú Thọ'}">
                                                        selected="selected"
                                                    </c:if>>Phú Thọ</option>
                                            <option value="Phú Yên"
                                                    <c:if test="${param.txtCity == 'Phú Yên'}">
                                                        selected="selected"
                                                    </c:if>>Phú Yên</option>
                                            <option value="Quảng Bình"
                                                    <c:if test="${param.txtCity == 'Quảng Bình'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Bình</option>
                                            <option value="Quảng Nam"
                                                    <c:if test="${param.txtCity == 'Quảng Nam'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Nam</option>
                                            <option value="Quảng Ngãi"
                                                    <c:if test="${param.txtCity == 'Quảng Ngãi'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Ngãi</option>
                                            <option value="Quảng Ninh"
                                                    <c:if test="${param.txtCity == 'Quảng Ninh'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Ninh</option>
                                            <option value="Quảng Trị"
                                                    <c:if test="${param.txtCity == 'Quảng Trị'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Trị</option>
                                            <option value="Sóc Trăng"
                                                    <c:if test="${param.txtCity == 'Sóc Trăng'}">
                                                        selected="selected"
                                                    </c:if>>Sóc Trăng</option>
                                            <option value="Sơn La"
                                                    <c:if test="${param.txtCity == 'Sơn La'}">
                                                        selected="selected"
                                                    </c:if>>Sơn La</option>
                                            <option value="Tây Ninh"
                                                    <c:if test="${param.txtCity == 'Tây Ninh'}">
                                                        selected="selected"
                                                    </c:if>>Tây Ninh</option>
                                            <option value="Thái Bình"
                                                    <c:if test="${param.txtCity == 'Thái Bình'}">
                                                        selected="selected"
                                                    </c:if>>Thái Bình</option>
                                            <option value="Thái Nguyên"
                                                    <c:if test="${param.txtCity == 'Thái Nguyên'}">
                                                        selected="selected"
                                                    </c:if>>Thái Nguyên</option>
                                            <option value="Thanh Hóa"
                                                    <c:if test="${param.txtCity == 'Thanh Hóa'}">
                                                        selected="selected"
                                                    </c:if>>Thanh Hóa</option>
                                            <option value="Thủ Đức"
                                                    <c:if test="${param.txtCity == 'Thủ Đức'}">
                                                        selected="selected"
                                                    </c:if>>Thủ Đức</option>
                                            <option value="Thừa Thiên Huế"
                                                    <c:if test="${param.txtCity == 'Thừa Thiên Huế'}">
                                                        selected="selected"
                                                    </c:if>>Thừa Thiên - Huế</option>
                                            <option value="Tiền Giang"
                                                    <c:if test="${param.txtCity == 'Tiền Giang'}">
                                                        selected="selected"
                                                    </c:if>>Tiền Giang</option>
                                            <option value="Trà Vinh"
                                                    <c:if test="${param.txtCity == 'Trà Vinh'}">
                                                        selected="selected"
                                                    </c:if>>Trà Vinh</option>
                                            <option value="Tuyên Quang"
                                                    <c:if test="${param.txtCity == 'Tuyên Quang'}">
                                                        selected="selected"
                                                    </c:if>>Tuyên Quang</option>
                                            <option value="Vĩnh Long"
                                                    <c:if test="${param.txtCity == 'Vĩnh Long'}">
                                                        selected="selected"
                                                    </c:if>>Vĩnh Long</option>
                                            <option value="Vĩnh Phúc"
                                                    <c:if test="${param.txtCity == 'Vĩnh Phúc'}">
                                                        selected="selected"
                                                    </c:if>>Vĩnh Phúc</option>
                                            <option value="Yên Bái"
                                                    <c:if test="${param.txtCity == 'Yên Bái'}">
                                                        selected="selected"
                                                    </c:if>>Yên Bái</option>
                                        </select>
                                        <label for="city" class="form-label">City</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <label class="form-label text-secondary">Gender:</label>
                                    <div class="form-check form-check-inline" style="
                                         margin-left: 9px;
                                         ">
                                        <input class="form-check-input" type="radio" value="Nam" name="txtGender" id="male" required checked>
                                        <label class="form-check-label text-secondary" for="male">
                                            Male
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" value="Nữ" name="txtGender" id="female" required>
                                        <label class="form-check-label text-secondary" for="female">
                                            Female
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" value="Ẩn" name="txtGender" id="hidden" required>
                                        <label class="form-check-label text-secondary" for="hidden">
                                            Hidden
                                        </label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" name="iAgree" id="iAgree" required>
                                        <label class="form-check-label text-secondary" for="iAgree">
                                            I agree to the <a href="termsOfUse" target="_blank" class="link-primary text-decoration-none">terms and conditions</a>
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
