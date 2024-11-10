<%-- 
    Document   : LoginJSP
    Created on : Sep 14, 2024, 12:50:27 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <style>
        header {
            height: 200px; 
            display: flex; 
            align-items: center;
            justify-content: center; 
        }
        .logo-header {
            background-color: rgba(255, 255, 255, 0.5); 
            border-radius: 10px; 
        }
        main {
            padding: 20px; 
            height: 100vh; 
        }
        .container {
            background-color: rgba(255, 255, 255, 0.9); 
            border-radius: 10px; 
            padding: 20px; 
            position: relative; 
            z-index: 1; 
        }
        #notification {
            position: absolute; 
            top: 25%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #ffffff;
            padding: 8px;
            padding-top: 18px;
            border-radius: 5px;
            color: red;

        }
        body {
            background-image: url(img/ThousandFlower.jpg); /* Đường dẫn đến hình ảnh background */
            background-size: cover; /* Để hình ảnh bao phủ toàn bộ phần main */
            background-position: center; /* Để căn giữa hình ảnh */
            background-repeat: no-repeat; /* Không lặp lại hình ảnh */
            margin: 0; /* Để loại bỏ margin mặc định */
            padding: 0; /* Để loại bỏ padding mặc định */
        }
        .btn-class {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            color: white;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.2s;
        }

        .btn-class:hover {
            background-color: #0056b3; 
            transform: scale(1.05); 
        }

        input[type="submit"].btn-class {
            background-color: #007bff; 
        }

        a.btn-class {
            background-color: #28a745;
        }

        /* Responsive styling */
        @media (max-width: 600px) {
            .btn-class {
                width: 100%; 
            }
        }
    </style>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sign In | Buy and sell on the website</title>
        <!-- Style CSS -->
        <link rel="stylesheet" href="./css/style.css">
        <!-- Demo CSS (No need to include it into your project) -->
        <link rel="stylesheet" href="./css/demo.css">
        <!--        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>-->
        <link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <link rel="icon" href="img/flora-favicon.png"/>
    </head>
    <body>
        <header class="cd__intro">
            <a href="home">
                <img class="logo-header" src="img/floralogo.png" alt="Home Page" width="360px">
            </a> 
        </header>

        <main class="cd__main">
            <section class="py-3 py-md-5 py-xl-8">
                <div class="container">
                    <div class="row content">
                        <div class="col-12">
                            <div class="mb-5">
                                <h2 class="display-5 fw-bold text-center">Đăng nhập</h2>
                            </div>
                        </div>                        
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-12">
                            <div class="mb-5 text-center">
                                <c:set var="error" value="${requestScope.LOGIN_ERROR}"/>
                                <c:if test="${not empty error.loginErr}">   
                                    <div id="notification" style="background-color: rgb(245, 229, 229)">
                                        <p>
                                            ${error.loginErr}
                                        </p>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-12 col-lg-10 col-xl-8">
                            <div class="row gy-5 justify-content-center">
                                <div class="col-12 col-lg-5">
                                    <form action="loginAction" method="POST">
                                        <div class="row gy-3 overflow-hidden">
                                            <div class="col-12">
                                                <div class="form-floating mb-3">
                                                    <input type="text" name="txtUsername" value="" class="form-control" id="username" placeholder="Username" required/>
                                                    <label for="username" class="form-label">Tài khoản</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="form-floating mb-3">
                                                    <input type="password" id="myPassword" name="txtPassword" value="" class="form-control" placeholder="Password" required/>
                                                    <label for="password" class="form-label">Mật khẩu</label>
                                                    <i class="fa fa-eye" onclick="togglePassword()"></i>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="row justify-content-between">
                                                    <div class="col-12">
                                                        <div class="text-end">
                                                            <a href="forgotPassword" class="link-secondary text-decoration-none">Quên mật khẩu?</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="d-grid">          
                                                    <input type="submit" class="btn btn-class" style="color: #ffffff; font-weight: bold" value="Đăng nhập" name="btAction" />
                                                    <br/>
                                                    <a class="btn btn-class" style="color: #ffffff; font-weight: bold; background-color: #28a745" href="registerPage">Đăng ký</a>                                           
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                                <div class="col-12 col-lg-2 d-flex align-items-center justify-content-center gap-3 flex-lg-column">
                                    <div class="bg-dark h-100 d-none d-lg-block" style="width: 1px; background-color: rgba(0, 0, 0, 0.1);"></div>
                                    <div class="bg-dark w-100 d-lg-none" style="height: 1px; background-color: rgba(0, 0, 0, 0.1);"></div>
                                    <div>Hoặc</div>
                                    <div class="bg-dark h-100 d-none d-lg-block" style="width: 1px; background-color: rgba(0, 0, 0, 0.1);"></div>
                                    <div class="bg-dark w-100 d-lg-none" style="height: 1px; background-color: rgba(0, 0, 0, 0.1);"></div>
                                </div>
                                <div class="col-12 col-lg-5 d-flex align-items-center">
                                    <div class="d-flex gap-3 flex-column w-100 ">
                                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:8084/FloraRewind/loginAction&response_type=code&client_id=979532933754-dkafh4bakdj768m3nldv4fqt97e8acob.apps.googleusercontent.com&approval_prompt=force" class="btn btn-lg btn-danger">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-google" viewBox="0 0 16 16">
                                            <path d="M15.545 6.558a9.42 9.42 0 0 1 .139 1.626c0 2.434-.87 4.492-2.384 5.885h.002C11.978 15.292 10.158 16 8 16A8 8 0 1 1 8 0a7.689 7.689 0 0 1 5.352 2.082l-2.284 2.284A4.347 4.347 0 0 0 8 3.166c-2.087 0-3.86 1.408-4.492 3.304a4.792 4.792 0 0 0 0 3.063h.003c.635 1.893 2.405 3.301 4.492 3.301 1.078 0 2.004-.276 2.722-.764h-.003a3.702 3.702 0 0 0 1.599-2.431H8v-3.08h7.545z" />
                                            </svg>
                                            <span class="ms-2 fs-6">Đăng nhập với Google</span>
                                        </a>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                 
                </div>
            </section>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
                                                        window.onload = function () {
                                                            const urlParams = new URLSearchParams(window.location.search);
                                                            if (urlParams.get('status') === 'success') {
                                                                Swal.fire({
                                                                    icon: 'success',
                                                                    title: 'Đăng ký thành công!',
                                                                    text: 'Bạn có thể đăng nhập ngay bây giờ.',
                                                                    confirmButtonText: 'OK'
                                                                });

                                                                const newURL = window.location.protocol + "//" + window.location.host + window.location.pathname;
                                                                window.history.replaceState({}, document.title, newURL);
                                                            }
                                                            if (urlParams.get('recoveryStatus') === 'success') {
                                                                Swal.fire({
                                                                    icon: 'success',
                                                                    title: 'Thay đổi password thành công!',
                                                                    text: 'Bạn có thể đăng nhập ngay bây giờ.',
                                                                    confirmButtonText: 'OK'
                                                                });

                                                                const newURL = window.location.protocol + "//" + window.location.host + window.location.pathname;
                                                                window.history.replaceState({}, document.title, newURL);
                                                            }
                                                        };
        </script>
        <!-- Script JS -->
        <script src="js/javascript.js"></script>
        <!--$%analytics%$-->
    </body>
</html>