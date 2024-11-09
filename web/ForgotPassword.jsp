<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Verify Email</title>
        <link rel="icon" href="img/flora-favicon.png"/>
        <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
            rel='stylesheet'>
        <link href='' rel='stylesheet'>
        <script type='text/javascript'
        src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <style>
            body {
                background-position: center;
                background-color: #eee;
                background-repeat: no-repeat;
                background-size: cover;
                color: #505050;
                font-family: "Rubik", Helvetica, Arial, sans-serif;
                font-size: 14px;
                font-weight: normal;
                line-height: 1.5;
                text-transform: none
            }

            .forgot {
                background-color: #fff;
                padding: 12px;
                border: 1px solid #dfdfdf
            }

            .padding-bottom-3x {
                padding-bottom: 72px !important
            }

            .card-footer {
                background-color: #fff
            }

            .btn {
                font-size: 13px
            }

            .form-control:focus {
                color: #495057;
                background-color: #fff;
                border-color: #76b7e9;
                outline: 0;
                box-shadow: 0 0 0 0px #28a745
            }
        </style>
    </head>
    <body oncontextmenu='return false' class='snippet-body'>
        <div class="container padding-bottom-3x mb-2 mt-5">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10">
                    <div class="forgot">
                        <h2>Quên mật khẩu?</h2>
                        <p>Thay đổi mật khẩu của bạn trong ba bước đơn giản. Điều này sẽ giúp bạn bảo mật mật khẩu của mình!</p>
                        <ol class="list-unstyled">
                            <li><span class="text-primary text-medium">1. </span>Nhập tài khoản của bạn dưới.</li>
                            <li><span class="text-primary text-medium">2. </span>Nếu tên người dùng của bạn khớp với tài khoản hiện có, chúng tôi sẽ gửi email đặt lại mật khẩu trong vòng vài phút.</li>
                            <li><span class="text-primary text-medium">3. </span>Nhập mã xác minh ở trang tiếp theo</li>
                        </ol>
                    </div>
                    <form class="card mt-4" action="forgotPasswordAction" method="POST" id="form">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="email-for-pass">Nhập tài khoản của bạn</label> <input
                                    class="form-control" type="text" name="txtUsername" id="email-for-pass" required><small
                                    class="form-text text-muted">Nhập tài khoản của bạn. Sau đó chúng tôi sẽ gửi mã xác minh tới email đã đăng ký.</small>
                            </div>
                            <div style="color: red">
                                <c:set var="error" value="${requestScope.FORGOT_ERROR}"/>
                                <c:if test="${not empty error.usernameIsNotExisted}">
                                    ${error.usernameIsNotExisted}
                                </c:if>
                            </div>

                        </div>
                        <div class="card-footer">
                            <button id="submitBtn" class="btn btn-success" name="btAction" onclick="disableButton()">Tạo mật khẩu mới</button>
                            <a href="loginPage">
                                <button class="btn btn-danger" type="button" id="login">Trở về trang đăng nhập</button>
                            </a>

                        </div>
                    </form>
                    <div class="row">
                        <div class="col-12">
                            <hr class="mt-5 mb-4 border-secondary-subtle">
                            <p class="m-0 text-secondary text-center">Bạn chưa có tài khoản? <a href="registerPage" class="link-primary text-decoration-none">Đăng ký</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type='text/javascript'
        src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
        <script>
                                function disableButton() {
                                    const submitButton = document.getElementById("submitBtn");
                                    submitButton.disabled = true;
                                    const backLoginButton = document.getElementById("login");
                                    backLoginButton.disabled = true;
                                    document.getElementById("form").submit();
                                }
        </script>
    </body>
</html>