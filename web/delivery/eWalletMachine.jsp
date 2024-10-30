<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/css/font-awesome.min.css">
        <!-- <link rel="stylesheet" href="css/AdminLTE.css"> -->
        <link rel="stylesheet" href="css/css/_all-skins.min.css">
        <link rel="stylesheet" href="css/css/jquery-ui.css">
        <link rel="stylesheet" href="css/css/style.css" />
        <link rel="stylesheet" href="css/css/admincss.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/chart.js/dist/chart.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="icon" href="img/flora-favicon.png"/>
        <title>Delivery</title>
        <style>
            .info-bank{
                display: flex;
                justify-content: center;

            }
            .content-wrapperd {
                display: flex;
                justify-content: center; 
                align-items: center;
                margin-top: 20px; 
            }

            .card {
                width: 100%; 
                max-width: 400px;
                border-radius: 10px; 
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); 
            }

            .card-header {
                color: white;
                padding: 15px; 
                border-top-left-radius: 10px;
                border-top-right-radius: 10px; 
            }

            .card-body {
                padding: 20px;
            }

            .balance-info {
                text-align: center; 
                margin: 20px 0; 
            }

            .button-group {
                display: flex; 
                justify-content: space-around; 
                margin-top: 20px; 
            }

            .action-btn {
                border: none;
                border-radius: 50px; 
                padding: 15px 30px; 
                font-size: 18px; 
                color: #fff; 
                font-weight: bold; 
                cursor: pointer; 
                transition: background 0.3s; 
            }

            .deposit-btn {
                background: linear-gradient(135deg, #28a745, #218838); 
            }

            .withdraw-btn {
                background: linear-gradient(135deg, #dc3545, #c82333); 
            }

            .deposit-btn:hover {
                background: linear-gradient(135deg, #218838, #28a745); 
            }

            .withdraw-btn:hover {
                background: linear-gradient(135deg, #c82333, #dc3545); 
            }

        </style>
    </head>
    <body>
        <section class="admin">
            <div class="row-grid">
                <div id="adminSidebar" class="admin-sidebar"> <%--Side bar here--%>
                    <div class="admin-sidebar-top">
                        <img src="img/flora-favicon.png" alt="">
                    </div>
                    <div class="admin-sidebar-content" style="padding: 19px 0 0 10px; box-sizing: border-box;">
                        <ul style="margin-bottom: 10px; padding-left: 0px;">
                            <div class="logout-admin"><a href="logoutAction" class="logout-btn">Logout</a></div>
                            <p class="admin-p">Delivery</p>
                            <div class="admin-under-p" style="margin: 1px 5px 5px 5px">Flora Store Delivery</div>
                            <li>
                                <a href="" style="color: #131EAD"><i class="ri-file-list-line"></i>Danh sách đơn hàng<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                           href="delivererOrders">Nhận đơn hàng mới</a></li>
                                    <li><a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                           href="viewOrdersForDelivery">Đơn hàng cần giao</a></li>
                                </ul>   
                            </li>
                            <li>
                                <a href="" style="color: #131EAD"><i class="bi bi-credit-card-fill"></i>Ví điện tử FLora<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <c:if test="${sessionScope.EWALLET_ACTIVE != true}">
                                        <li>
                                            <a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                               href="myWallet">Tạo tài khoản</a>
                                        </li>
                                    </c:if>
                                    <c:if  test="${sessionScope.EWALLET_ACTIVE == true}">
                                        <li>
                                            <a class="ri-arrow-right-s-fill" style="color: #131EAD"
                                               href="eWallet">Tài khoản</a>
                                        </li>
                                    </c:if>
                                </ul>  
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="admin-content">
                    <div class="admin-content-top">
                        <div class="admin-content-top-left">
                            <ul class="flex-box"> 
                                <a style="padding-left: 0px" href="home"/>
                                <button type="button" class="btn btn-primary" 
                                        style="font-size: 14px; background-color: #337AB7; padding-bottom: 6px">BACK TO STORE</button>
                                </a>    
                            </ul>          
                        </div>
                        <div class="admin-content-top-right">
                            <ul class="flex-box">
                                <c:if test="${requestScope.FoundError2 != null}">
                                    <i>
                                        Số dư tài khoản: 
                                        <i style="color: red; font-weight: bold" id="staffBalance">
                                            <fmt:formatNumber value="${sessionScope.Staff_Balance}" pattern="#,###"/>
                                        </i>
                                    </i>
                                </c:if>
                                <c:if test="${requestScope.FoundError2 == null}">
                                    <i>
                                        Số dư tài khoản: 
                                        <i style="font-weight: bold" id="staffBalance">
                                            <fmt:formatNumber value="${sessionScope.Staff_Balance}" pattern="#,###"/>
                                        </i>
                                    </i>
                                </c:if>
                                <li href="viewOrderForDelivery">
                                    <c:if test="${requestScope.Total_Order != null}">
                                        <i class="ri-notification-4-line" number="${requestScope.Total_Order}"></i>
                                    </c:if>
                                    <c:if test="${requestScope.Total_Order == null}">
                                        <i class="ri-notification-4-line" number="0"></i>
                                    </c:if>
                                </li>
                                <li></li>
                                <li class="flex-box">
                                    <img style="width: 50px" src="img/flora-favicon.png">
                                    <p>${sessionScope.USER.fullName}<i></i></p>
                                </li>
                            </ul>
                        </div>
                    </div> 
                    <div class="admin-content-main">
                        <div class="admin-content-main-title">
                            <h1 style="font-size: 36px; margin-bottom: 20px; color: #343a40;">Quản lý ví điện tử Flora:</h1>
                        </div>
                        <div class="admin-content-main-content">
                            <div class="content-wrapperd">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="card-title">Thông tin tài khoản</h5>
                                    </div>
                                    <div class="card-body">
                                        <h5 style="color: #6c757d; text-align: center">
                                            Tài khoản: ${sessionScope.USERNAME}
                                        </h5>
                                        <div class="balance-info">
                                            <h4 style="margin-bottom: 10px;">Số dư tài khoản:</h4>
                                            <div class="info-bank">
                                                <h2 style="color: #28a745;" id="staffBalanceOther">
                                                    <fmt:formatNumber value="${sessionScope.Staff_Balance}" pattern="#,###"/>
                                                </h2>
                                                <h2 style="color: #28a745">
                                                    VNĐ
                                                </h2>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="button-group">
                                            <button class="action-btn deposit-btn" data-toggle="modal" data-target="#transactionModal" onclick="setTransactionType('deposit')">Nạp tiền</button>
                                            <button class="action-btn withdraw-btn" data-toggle="modal" data-target="#transactionModal" onclick="setTransactionType('withdraw')">Rút tiền</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal -->
            <div class="modal fade" id="transactionModal" tabindex="-1" role="dialog" aria-labelledby="transactionModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="transactionModalLabel">Nạp/Rút tiền</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form id="transactionForm">
                                <div class="form-group">
                                    <label for="amountInput">Số tiền:</label>
                                    <input type="number" class="form-control" id="amountInput" placeholder="Nhập số tiền" required>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                            <button type="button" class="btn btn-primary" id="confirmButton">Xác nhận</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="alerJs.js"></script>
        <script src="js/javascript.js"></script>
        <script>

                                                let transactionType = '';

                                                function formatNumber(num) {
                                                    return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                                }
                                                function setTransactionType(type) {
                                                    transactionType = type;
                                                    const modalTitle = document.getElementById('transactionModalLabel');
                                                    modalTitle.innerText = type === 'deposit' ? 'Nạp tiền' : 'Rút tiền';
                                                }

                                                document.getElementById('amountInput').addEventListener('keydown', function (event) {
                                                    if (event.key === 'Enter') {
                                                        event.preventDefault();
                                                        document.getElementById('confirmButton').click();
                                                    }
                                                });

                                                document.getElementById('confirmButton').addEventListener('click', function () {
                                                    const amount = document.getElementById('amountInput').value;

                                                    if (!amount || isNaN(amount) || Number(amount) <= 0) {
                                                        Swal.fire({
                                                            title: 'Lỗi!',
                                                            text: 'Vui lòng nhập số tiền hợp lệ.',
                                                            icon: 'error',
                                                            confirmButtonText: 'OK'
                                                        });
                                                        return;
                                                    }
                                                    if (transactionType === 'deposit') {
                                                        $.ajax({
                                                            type: 'POST',
                                                            url: 'depositMoney',
                                                            data: {amount: amount},
                                                            success: function (response) {
                                                                if (response.success) {
                                                                    Swal.fire({
                                                                        title: 'Thành công!',
                                                                        text: response.message + "\nSố dư mới: " + formatNumber(response.newBalance),
                                                                        icon: 'success',
                                                                        confirmButtonText: 'OK'
                                                                    });
                                                                    document.getElementById('staffBalance').innerText = formatNumber(response.newBalance);
                                                                    document.getElementById('staffBalanceOther').innerText = formatNumber(response.newBalance);
                                                                    document.getElementById('amountInput').value = '';
                                                                } else {
                                                                    // Nếu server trả về không thành công
                                                                    Swal.fire({
                                                                        title: 'Thông báo!',
                                                                        text: response.message || 'Không có thông tin chi tiết.',
                                                                        icon: 'info',
                                                                        confirmButtonText: 'OK'
                                                                    });
                                                                }
                                                            },
                                                            error: function () {
                                                                Swal.fire({
                                                                    title: 'Lỗi!',
                                                                    text: 'Có lỗi xảy ra khi nạp tiền.',
                                                                    icon: 'error',
                                                                    confirmButtonText: 'OK'
                                                                });
                                                            }
                                                        });
                                                    } else if (transactionType === 'withdraw') {
                                                        $.ajax({
                                                            type: 'POST',
                                                            url: 'withDrawMoney',
                                                            data: {amount: amount},
                                                            success: function (response) {
                                                                if (response.success) {
                                                                    Swal.fire({
                                                                        title: 'Thành công!',
                                                                        text: response.message + "\nSố dư mới: " + formatNumber(response.newBalance),
                                                                        icon: 'success',
                                                                        confirmButtonText: 'OK'
                                                                    });
                                                                    document.getElementById('staffBalance').innerText = formatNumber(response.newBalance);
                                                                    document.getElementById('staffBalanceOther').innerText = formatNumber(response.newBalance);
                                                                    document.getElementById('amountInput').value = '';
                                                                } else {
                                                                    // Nếu server trả về không thành công
                                                                    Swal.fire({
                                                                        title: 'Thông báo!',
                                                                        text: response.message || 'Không có thông tin chi tiết.',
                                                                        icon: 'info',
                                                                        confirmButtonText: 'OK'
                                                                    });
                                                                }
                                                            },
                                                            error: function () {
                                                                Swal.fire({
                                                                    title: 'Lỗi!',
                                                                    text: 'Có lỗi xảy ra khi nạp tiền.',
                                                                    icon: 'error',
                                                                    confirmButtonText: 'OK'
                                                                });
                                                            }
                                                        });
                                                    }

                                                    $('#transactionModal').modal('hide');
                                                });
        </script>
    </body>
</html>