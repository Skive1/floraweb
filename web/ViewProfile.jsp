<%-- 
    Document   : viewProfile
    Created on : 16/09/2024, 12:04:19 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.4/components/registrations/registration-7/assets/css/registration-7.css">
<link rel="icon" href="img/flora-favicon.png"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.0/css/all.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    section {
        background-image: url(img/ThousandFlower.jpg);
        background-size: cover;
        background-position: center;
    }
    .styled-link {
        text-decoration: none;
        color: #fff;
        background-color: #4CAF50;
        padding: 10px 20px;
        border-radius: 5px;
        font-weight: bold;
        font-size: 1.2em;
        transition: all 0.3s ease;
        box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
    }

    .styled-link:hover {
        background-color: #45a049;
        color: #ffffff;
        box-shadow: 0px 6px 20px rgba(0, 0, 0, 0.3);
        transform: scale(1.05);
    }
</style>
<!-- Registration 7 - Bootstrap Brain Component -->
<section class="bg-light p-3 p-md-4 p-xl-5">
    <div class="container">
        <a href="home" class="styled-link">Go back to Home</a>
        <div class="row justify-content-center">
            <div class="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
                <div class="card border border-light-subtle rounded-4">
                    <div class="card-body p-3 p-md-4 p-xl-5">
                        <div class="row">
                            <div class="col-12">
                                <div class="mb-5">
                                    <div class="text-center mb-4">
                                        <img src="img/floralogo.png" alt="Logo" width="360" >
                                    </div>
                                    <h2 class="h4 text-center">My profile</h2>
                                    <h3 class="fs-6 fw-normal text-secondary text-center m-0">You can update your profile here</h3>
                                    <h3 class="fs-6 fw-normal text-secondary text-center m-0">Full name and Email cannot be edited</h3>
                                </div>
                            </div>
                        </div>
                        <form action="updateAction" method="POST" onsubmit="return confirmUpdate()">
                            <%--
                            <div class="row gy-3 overflow-hidden">

                                <div class="col-12">
                                    Full name: ${sessionScope.USER.fullName}
                                </div>

                                <div class="col-12">
                                    Email: ${sessionScope.USER.email}
                              
                                    <div class="form-floating mb-3">

                                        </div>
                              
                                </div>

                                <div class="col-12">
                               
                                    <div class="form-floating mb-3">
                                        
                                    </div>
                                
                                    Gender: 
                                    <select style="border: 0">
                                        <option>Male</option>
                                        <option>Female</option>
                                        <option>Other</option>
                                        <option>Hidden</option>
                                    </select>
                                </div>

                                <c:set var="errors" value="${requestScope.CREATE_ERROR}"/>
                                <c:if test="${sessionScope.confirmFlag == null}">
                                    <c:if test="${not empty errors.emailFormat}">
                                        <font color="red">
                                        ${errors.emailFormat}
                                        </font> <br/>
                                    </c:if> 

                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="txtPhone" id="phone" value="${sessionScope.PHONE}" required>
                                            <label for="phone" class="form-label">Phone</label>
                                        </div>
                                    </div>
                                    <c:if test="${not empty errors.phonelength}">
                                        <font color="red">
                                        ${errors.phonelength}
                                        </font> <br/>
                                    </c:if> 

                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="txtAddress" id="address" value="${sessionScope.ADDRESS}" required>
                                            <label for="address" class="form-label">Address</label>
                                        </div>
                                    </div>
                                    <c:if test="${not empty errors.addressFormat}">
                                        <font color="red">
                                        ${errors.addressFormat}
                                        </font> <br/>
                                    </c:if> 
                              
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="password" class="form-control" name="txtPassword" id="password" value="************" placeholder="Password" required>
                                            <label for="password" class="form-label">Password</label>
                                        </div>
                                    </div>
                                    <c:if test="${not empty errors.passwordLength}">
                                        <font color="red">
                                        ${errors.passwordLength}
                                        </font> <br/>
                                    </c:if> 
                                    <c:if test="${not empty errors.passwordFormat}">
                                        <font color="red">
                                        ${errors.passwordFormat}
                                        </font> <br/>
                                    </c:if> 
                             
                                </c:if>

                                <c:if test="${sessionScope.confirmFlag != null}">
                            
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="email" class="form-control" name="txtEmail" id="email" value="${param.txtEmail}" placeholder="name@example.com" required>
                                            <label for="email" class="form-label">Email</label>
                                        </div>
                                    </div>
                                
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="txtPhone" id="email" value="${param.txtPhone}">
                                            <label for="phone" class="form-label">Phone</label>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="txtAddress" id="email" value="${param.txtAddress}" required>
                                            <label for="address" class="form-label">Address</label>
                                        </div>
                                    </div>
                                
                            <div class="col-12">
                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" name="txtPassword" id="password" value="${param.txtPassword}" placeholder="Password" required>
                                    <label for="password" class="form-label">Password</label>
                                </div>
                            </div>
                           
                                </c:if>
                           
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="txtPassword2" id="password" value="${param.txtPassword2}" placeholder="Password" required>
                                        <label for="password" class="form-label">Confirm Password</label>
                                    </div>
                                    <c:if test="${not empty errors.confirmNotMatched}">
                                        <font color="red">
                                        ${errors.confirmNotMatched}
                                        </font> <br/>
                                    </c:if>
                                </div>
                        
                                <div class="col-12" >
                                    <div style="text-align: right">
                                        <button class="btn bsb-btn-xl btn-primary" type="submit">Save</button><br>
                                        <input type="hidden" name="txtFullname" value="${sessionScope.USER.fullName}" readonly="readonly" />
                                        <font style="color: brown">
                                        <c:if test="${sessionScope.confirmFlag != null}">
                                            ${sessionScope.confirmFlag}
                                        </c:if>
                                        <font/>
                                    </div>
                                </div>
                            </div>
                            --%>
                            <c:set var="errors" value="${requestScope.UPDATE_ERRORS}"/>
                            <input type="hidden" name="txtUsername" value="${sessionScope.USER_INFO.username}"/>
                            <div class="row gy-3 overflow-hidden">
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="txtFullname" value="${sessionScope.USER_INFO.fullName}" id="fullName" placeholder="Full Name" readonly>
                                        <label for="fullName" class="form-label">Full name</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="email" class="form-control" name="txtEmail" value="${sessionScope.USER_INFO.email}" id="email" placeholder="name@example.com" readonly>
                                        <label for="email" class="form-label">Email</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="txtPhone" id="phone" value="${sessionScope.USER_INFO.phone}" placeholder="" >
                                        <label for="phone" class="form-label">Phone number</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.phoneError}">
                                                <c:out value ="${errors.phoneError}"/>
                                            </c:if>
                                        </div> 
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="txtStreet" id="street" value="${sessionScope.USER_INFO.street}" placeholder="" >
                                        <label for="street" class="form-label">Address</label>
                                        <div style="color: red">
                                            <c:if test="${not empty errors.streetError}">
                                                <c:out value ="${errors.streetError}"/>
                                            </c:if>
                                        </div>                                        
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <select class="form-control" name="txtCity" id="city" >
                                            <option value="unknown"  selected>Chọn thành phố</option>
                                            <option value="An Giang"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'An Giang'}">
                                                        selected="selected"
                                                    </c:if>>An Giang</option>
                                            <option value="Bà Rịa Vũng Tàu"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bà Rịa Vũng Tàu'}">
                                                        selected="selected"
                                                    </c:if>>Bà Rịa Vũng Tàu</option>
                                            <option value="Bắc Giang"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bắc Giang'}">
                                                        selected="selected"
                                                    </c:if>>Bắc Giang</option>
                                            <option value="Bắc Kạn"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bắc Kạn'}">
                                                        selected="selected"
                                                    </c:if>>Bắc Kạn</option>
                                            <option value="Bạc Liêu"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bạc Liêu'}">
                                                        selected="selected"
                                                    </c:if>>Bạc Liêu</option>
                                            <option value="Bắc Ninh"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bắc Ninh'}">
                                                        selected="selected"
                                                    </c:if>>Bắc Ninh</option>
                                            <option value="Bến Tre"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bến Tre'}">
                                                        selected="selected"
                                                    </c:if>>Bến Tre</option>
                                            <option value="Bình Định"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bình Định'}">
                                                        selected="selected"
                                                    </c:if>>Bình Định</option>
                                            <option value="Bình Dương"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bình Dương'}">
                                                        selected="selected"
                                                    </c:if>>Bình Dương</option>
                                            <option value="Bình Phước"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bình Phước'}">
                                                        selected="selected"
                                                    </c:if>>Bình Phước</option>
                                            <option value="Bình Thuận"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Bình Thuận'}">
                                                        selected="selected"
                                                    </c:if>>Bình Thuận</option>
                                            <option value="Cà Mau"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Cà Mau'}">
                                                        selected="selected"
                                                    </c:if>>Cà Mau</option>
                                            <option value="Cần Thơ"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Cần Thơ'}">
                                                        selected="selected"
                                                    </c:if>>Cần Thơ</option>
                                            <option value="Cao Bằng"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Cao Bằng'}">
                                                        selected="selected"
                                                    </c:if>>Cao Bằng</option>
                                            <option value="Đà Nẵng"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Đà Nẵng'}">
                                                        selected="selected"
                                                    </c:if>>Đà Nẵng</option>
                                            <option value="Đắk Lắk"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Đắk Lắk'}">
                                                        selected="selected"
                                                    </c:if>>Đắk Lắk</option>
                                            <option value="Đắk Nông"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Đắk Nông'}">
                                                        selected="selected"
                                                    </c:if>>Đắk Nông</option>
                                            <option value="Điện Biên"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Điện Biên'}">
                                                        selected="selected"
                                                    </c:if>>Điện Biên</option>
                                            <option value="Đồng Nai"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Đồng Nai'}">
                                                        selected="selected"
                                                    </c:if>>Đồng Nai</option>
                                            <option value="Đồng Tháp"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Đồng Tháp'}">
                                                        selected="selected"
                                                    </c:if>>Đồng Tháp</option>
                                            <option value="Gia Lai"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Gia Lai'}">
                                                        selected="selected"
                                                    </c:if>>Gia Lai</option>
                                            <option value="Hà Giang"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hà Giang'}">
                                                        selected="selected"
                                                    </c:if>>Hà Giang</option>
                                            <option value="Hà Nam"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hà Nam'}">
                                                        selected="selected"
                                                    </c:if>>Hà Nam</option>
                                            <option value="Hà Nội"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hà Nội'}">
                                                        selected="selected"
                                                    </c:if>>Hà Nội</option>
                                            <option value="Hà Tĩnh"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hà Tĩnh'}">
                                                        selected="selected"
                                                    </c:if>>Hà Tĩnh</option>
                                            <option value="Hải Dương"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hải Dương'}">
                                                        selected="selected"
                                                    </c:if>>Hải Dương</option>
                                            <option value="Hải Phòng"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hải Phòng'}">
                                                        selected="selected"
                                                    </c:if>>Hải Phòng</option>
                                            <option value="Hậu Giang"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hậu Giang'}">
                                                        selected="selected"
                                                    </c:if>>Hậu Giang</option>
                                            <option value="Hồ Chí Minh"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hồ Chí Minh'}">
                                                        selected="selected"
                                                    </c:if>>Hồ Chí Minh</option>
                                            <option value="Hòa Bình"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hòa Bình'}">
                                                        selected="selected"
                                                    </c:if>>Hòa Bình</option>
                                            <option value="Hưng Yên"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Hưng Yên'}">
                                                        selected="selected"
                                                    </c:if>>Hưng Yên</option>
                                            <option value="Khánh Hòa"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Khánh Hòa'}">
                                                        selected="selected"
                                                    </c:if>>Khánh Hòa</option>
                                            <option value="Kiên Giang"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Kiên Giang'}">
                                                        selected="selected"
                                                    </c:if>>Kiên Giang</option>
                                            <option value="Kon Tum"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Kon Tum'}">
                                                        selected="selected"
                                                    </c:if>>Kon Tum</option>
                                            <option value="Lai Châu"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Lai Châu'}">
                                                        selected="selected"
                                                    </c:if>>Lai Châu</option>
                                            <option value="Lâm Đồng"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Lâm Đồng'}">
                                                        selected="selected"
                                                    </c:if>>Lâm Đồng</option>
                                            <option value="Lạng Sơn"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Lạng Sơn'}">
                                                        selected="selected"
                                                    </c:if>>Lạng Sơn</option>
                                            <option value="Lào Cai"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Lào Cai'}">
                                                        selected="selected"
                                                    </c:if>>Lào Cai</option>
                                            <option value="Long An"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Long An'}">
                                                        selected="selected"
                                                    </c:if>>Long An</option>
                                            <option value="Nam Định"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Nam Định'}">
                                                        selected="selected"
                                                    </c:if>>Nam Định</option>
                                            <option value="Nghệ An"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Nghệ An'}">
                                                        selected="selected"
                                                    </c:if>>Nghệ An</option>
                                            <option value="Ninh Bình"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Ninh Bình'}">
                                                        selected="selected"
                                                    </c:if>>Ninh Bình</option>
                                            <option value="Ninh Thuận"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Ninh Thuận'}">
                                                        selected="selected"
                                                    </c:if>>Ninh Thuận</option>
                                            <option value="Phú Thọ"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Phú Thọ'}">
                                                        selected="selected"
                                                    </c:if>>Phú Thọ</option>
                                            <option value="Phú Yên"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Phú Yên'}">
                                                        selected="selected"
                                                    </c:if>>Phú Yên</option>
                                            <option value="Quảng Bình"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Quảng Bình'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Bình</option>
                                            <option value="Quảng Nam"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Quảng Nam'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Nam</option>
                                            <option value="Quảng Ngãi"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Quảng Ngãi'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Ngãi</option>
                                            <option value="Quảng Ninh"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Quảng Ninh'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Ninh</option>
                                            <option value="Quảng Trị"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Quảng Trị'}">
                                                        selected="selected"
                                                    </c:if>>Quảng Trị</option>
                                            <option value="Sóc Trăng"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Sóc Trăng'}">
                                                        selected="selected"
                                                    </c:if>>Sóc Trăng</option>
                                            <option value="Sơn La"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Sơn La'}">
                                                        selected="selected"
                                                    </c:if>>Sơn La</option>
                                            <option value="Tây Ninh"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Tây Ninh'}">
                                                        selected="selected"
                                                    </c:if>>Tây Ninh</option>
                                            <option value="Thái Bình"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Thái Bình'}">
                                                        selected="selected"
                                                    </c:if>>Thái Bình</option>
                                            <option value="Thái Nguyên"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Thái Nguyên'}">
                                                        selected="selected"
                                                    </c:if>>Thái Nguyên</option>
                                            <option value="Thanh Hóa"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Thanh Hóa'}">
                                                        selected="selected"
                                                    </c:if>>Thanh Hóa</option>
                                            <option value="Thủ Đức"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Thủ Đức'}">
                                                        selected="selected"
                                                    </c:if>>Thủ Đức</option>
                                            <option value="Thừa Thiên Huế"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Thừa Thiên Huế'}">
                                                        selected="selected"
                                                    </c:if>>Thừa Thiên - Huế</option>
                                            <option value="Tiền Giang"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Tiền Giang'}">
                                                        selected="selected"
                                                    </c:if>>Tiền Giang</option>
                                            <option value="Trà Vinh"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Trà Vinh'}">
                                                        selected="selected"
                                                    </c:if>>Trà Vinh</option>
                                            <option value="Tuyên Quang"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Tuyên Quang'}">
                                                        selected="selected"
                                                    </c:if>>Tuyên Quang</option>
                                            <option value="Vĩnh Long"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Vĩnh Long'}">
                                                        selected="selected"
                                                    </c:if>>Vĩnh Long</option>
                                            <option value="Vĩnh Phúc"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Vĩnh Phúc'}">
                                                        selected="selected"
                                                    </c:if>>Vĩnh Phúc</option>
                                            <option value="Yên Bái"
                                                    <c:if test="${sessionScope.USER_INFO.city == 'Yên Bái'}">
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
                                        <input class="form-check-input" type="radio" value="Nam" name="txtGender" id="male" required
                                               <c:if test="${sessionScope.USER_INFO.gender == 'Nam'}">
                                                   checked="checked"
                                               </c:if> />
                                        <label class="form-check-label text-secondary" for="male">
                                            Male
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" value="Nữ" name="txtGender" id="female" required
                                               <c:if test="${sessionScope.USER_INFO.gender == 'Nữ'}">
                                                   checked="checked"
                                               </c:if> />
                                        <label class="form-check-label text-secondary" for="female">
                                            Female
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" value="Ẩn" name="txtGender" id="hidden" required
                                               <c:if test="${sessionScope.USER_INFO.gender == 'Ẩn'}">
                                                   checked="checked"
                                               </c:if> />
                                        <label class="form-check-label text-secondary" for="hidden">
                                            Hidden
                                        </label>
                                    </div>
                                </div>

                                <div class="col-12">
                                    <div class="d-grid">
                                        <input type="submit" value="Save" class="btn bsb-btn-xl btn-primary" name="btAction" />
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    function confirmUpdate() {
        let confirmation = confirm("Are you sure you want to update your profile?");

        if (confirmation) {
            document.getElementById("updateForm").submit();
        } else {
            return false;
        }
    }
</script>
<script src="https://kit.fontawesome.com/736622441b.js" crossorigin="anonymous"></script>
