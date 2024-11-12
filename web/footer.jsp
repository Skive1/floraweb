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
                    <p class="mb-4">We are an intermediary connecting people who have surplus flowers after events with customers who need to buy flowers at reasonable prices. At the same time, we also create a place for individuals, flower farms or flower shops to trade flowers on the platform so that customers can easily connect and buy.</p>
                </div>
            </div>
            <c:if test="${not empty sessionScope.USER}">
                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Our platform</h4>
                        <a class="btn-link" href="home#aboutUs" onclick="setTimeout(removeHashUrl, 0);">About Us</a>
                        <a class="btn-link" href="contactPage">Contact Us</a>
                        <a class="btn-link" href="privacyPage">Privacy Policy</a>
                        <a class="btn-link" href="termsOfUse">Terms of use</a>
                        <a class="btn-link" href="mailto:flora.flower.platform@gmail.com">FAQs & Help</a>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Account</h4>
                        <a class="btn-link" href="viewProfileAction">My profile</a>
                        <a class="btn-link" href="eventCart">Event Cart</a>
                        <a class="btn-link" href="cartPage">Shopping Cart</a>
                        <a class="btn-link" href="purchasedOrder">Purchased Order</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${empty sessionScope.USER}">
                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Our platform</h4>
                        <a class="btn-link" href="https://github.com/Skive1/floraweb">About Us</a>
                        <a class="btn-link" href="contactPage">Contact Us</a>
                        <a class="btn-link" href="privacyPage">Privacy Policy</a>
                        <a class="btn-link" href="termsOfUse">Terms of use</a>
                        <a class="btn-link" href="mailto:flora.flower.platform@gmail.com">FAQs & Help</a>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="d-flex flex-column text-start footer-item">
                        <h4 class="text-light mb-3">Account</h4>
                        <a class="btn-link" href="loginPage">My profile</a>
                        <a class="btn-link" href="eventCart">Event Cart</a>
                        <a class="btn-link" href="cartPage">Shopping Cart</a>
                        <a class="btn-link" href="loginPage">Purchased Order</a>
                    </div>
                </div>
            </c:if>
            <div class="col-lg-3 col-md-6">
                <div class="footer-item">
                    <h4 class="text-light mb-3">Contact</h4>
                    <p>Address: Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Hồ Chí Minh</p>
                    <p>Email: flora.flower.platform@gmail.com</p>
                    <p>Phone number: +84 123 456 789</p>
                    <p>Payment Accepted</p>
                    <img loading="lazy" decoding="async" width="52px" style="border-radius: 5px; box-sizing: border-box" src="https://cdn.brandfetch.io/vnpay.vn/fallback/lettermark/theme/dark/h/256/w/256/icon?c=1idQIUBzC_rD6DbYqZx" class="img-fluid" alt="">
                    <img loading="lazy" decoding="async" width="52px" height="52px" style="border-radius: 5px; box-sizing: border-box; background-color: #ffffff" src="https://down-vn.img.susercontent.com/file/2c46b83d84111ddc32cfd3b5995d9281" class="img-fluid" alt="">
                </div>
            </div>
        </div>
    </div>
</div>