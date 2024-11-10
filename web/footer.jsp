<%-- 
    Document   : footer
    Created on : Sep 22, 2024, 4:09:19 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
    <div class="container py-5">
        <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
            <div class="row g-4">
                <div class="col-lg-3">
                    <img class="mb-0" src="img/floralogo.png" alt="Flora Logo" width="240">
                    <p class="text-secondary mb-0">Reselling Event Flower Platform</p>
                </div>
                <div class="col-lg-6">
                </div>
                <div class="col-lg-3">
                    <div class="d-flex justify-content-end pt-3">
                        <a class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle" href="https://www.instagram.com/fptuniversityhcm/"><i class="fab fa-instagram"></i></a>
                        <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href="https://www.facebook.com/FPTU.HCM"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href="https://www.youtube.com/@FPTUniversityHCM"><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-secondary btn-md-square rounded-circle" href="https://hcmuni.fpt.edu.vn/"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row g-5">
            <div class="col-lg-3 col-md-6">
                <div class="footer-item">
                    <h4 class="text-light mb-3">Why People Like us!</h4>
                    <p class="mb-4">Chúng tôi là trung gian kết nối những người sở hữu hoa dư sau các sự kiện với những khách hàng có nhu cầu mua hoa với mức giá hợp lý. Đồng thời chúng tôi cũng tạo ra một nơi để các cá nhân, nông trại hoa hay là các cửa hàng hoa có thể buôn bán các loại hoa trên nền tảng để các quý khách hàng có thể dễ dàng kết nối tới và mua hàng</p>
                </div>
            </div>
            <c:if test="${not empty sessionScope.USER}">
                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Thông tin nền tảng</h4>
                        <a class="btn-link" href="">Về chúng tôi</a>
                        <a class="btn-link" href="contactPage">Liên lạc với chúng tôi</a>
                        <a class="btn-link" href="privacyPage">Chính sách bảo mật</a>
                        <a class="btn-link" href="termsOfUse">Điều khoản sử dụng</a>
                        <a class="btn-link" href="mailto:flora.flower.platform@gmail.com">FAQs & Help</a>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Tài khoản</h4>
                        <a class="btn-link" href="viewProfileAction">Hồ sơ của tôi</a>
                        <a class="btn-link" href="eventCart">Giỏ hàng sự kiện</a>
                        <a class="btn-link" href="cartPage">Giỏ hàng cho shop</a>
                        <a class="btn-link" href="purchasedOrder">Lịch sử đơn hàng</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${empty sessionScope.USER}">
                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Thông tin nền tảng</h4>
                        <a class="btn-link" href="">Về chúng tôi</a>
                        <a class="btn-link" href="contactPage">Liên lạc với chúng tôi</a>
                        <a class="btn-link" href="privacyPage">Chính sách bảo mật</a>
                        <a class="btn-link" href="termsOfUse">Điều khoản sử dụng</a>
                        <a class="btn-link" href="mailto:flora.flower.platform@gmail.com">FAQs & Help</a>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Tài khoản</h4>
                        <a class="btn-link" href="loginPage">Hồ sơ của tôi</a>
                        <a class="btn-link" href="eventCart">Giỏ hàng sự kiện</a>
                        <a class="btn-link" href="cartPage">Giỏ hàng cho shop</a>
                        <a class="btn-link" href="loginPage">Lịch sử đơn hàng</a>
                    </div>
                </div>
            </c:if>
            <div class="col-lg-3 col-md-6">
                <div class="footer-item">
                    <h4 class="text-light mb-3">Liên lạc</h4>
                    <p>Địa chỉ: Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Hồ Chí Minh</p>
                    <p>Email: flora.flower.platform@gmail.com</p>
                    <p>Số điện thoại: +84 123 456 789</p>
                    <p>Payment Accepted</p>
                    <img loading="lazy" decoding="async" width="52px" style="border-radius: 5px; box-sizing: border-box" src="https://cdn.brandfetch.io/vnpay.vn/fallback/lettermark/theme/dark/h/256/w/256/icon?c=1idQIUBzC_rD6DbYqZx" class="img-fluid" alt="">
                    <img loading="lazy" decoding="async" width="52px" height="52px" style="border-radius: 5px; box-sizing: border-box; background-color: #ffffff" src="https://down-vn.img.susercontent.com/file/2c46b83d84111ddc32cfd3b5995d9281" class="img-fluid" alt="">
                </div>
            </div>
        </div>
    </div>
</div>