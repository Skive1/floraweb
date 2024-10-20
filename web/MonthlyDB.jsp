<%-- 
    Document   : dashBoardPage
    Created on : Oct 7, 2024, 10:37:29 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/css/style.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/css/font-awesome.min.css">
        <!-- <link rel="stylesheet" href="css/AdminLTE.css"> -->
        <link rel="stylesheet" href="css/css/_all-skins.min.css">
        <link rel="stylesheet" href="css/css/jquery-ui.css">
        <link rel="stylesheet" href="css/css/style.css" />
        <link rel="stylesheet" href="css/css/admincss.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/chart.js/dist/chart.min.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <title>Monthly Product DashBoard</title>
    </head>
    <body>
        <section class="admin">
            <div class="row-grid">
                <div class="admin-sidebar">
                    <div class="admin-sidebar-top">
                        <img src="data:image/png;base64,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" alt=""> 
                    </div>
                    <div class="admin-sidebar-content">
                        <ul>
                            <li>
                                <a href=""><i class="ri-dashboard-fill"></i>Dashboard<i class="ri-add-circle-line"></i></a>

                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" href="monthlyEvent">Event theo tháng</a></li>
                                    <li><a class="ri-arrow-right-s-fill" href="weeklyBoard">Event theo tuần</a></li>
                                    <li><a class="ri-arrow-right-s-fill" href="monthlyBoard">Sản phẩm theo tháng</a></li>
                                    <li><a class="ri-arrow-right-s-fill" href="">Sản phẩm theo tuần</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href=""><i class="ri-file-list-line"></i>Manage<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" href="">Account</a></li>
                                    <li><a class="ri-arrow-right-s-fill" href="">Event</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href=""><i class="ri-file-list-line"></i>Order<i class="ri-add-circle-line"></i></a>
                                <ul class="sub-menu">
                                    <li><a class="ri-arrow-right-s-fill" href="">Danh sách đơn hàng</a></li>
                                    <li><a class="ri-arrow-right-s-fill" href="">Delivery</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
                <div class="admin-content">
                    <div class="admin-content-top">
                        <div class="admin-content-top-left">
                            <ul class="flex-box"> 
                                <a style="padding-left:20px" href="homePage"/><button type="button" class="btn btn-primary">BACK TO STORE</button></a>    
                            </ul>          
                        </div>
                        <div class="admin-content-top-right">
                            <ul class="flex-box">
                                <li><i class="ri-notification-4-line" number="3"></i></li>
                                <li><i class="ri-message-2-line" number="5"></i></li>
                                <li class="flex-box">
                                    <img style="width: 50px;" src="" alt="">
                                    <p>${sessionScope.USER.fullName}<i class="ri-arrow-down-s-fill"></i></p>
                                </li>
                            </ul>
                        </div>
                    </div> 
                    <div class="admin-content-main">
                        <!--                        <c:if test="${empty requestScope.MonthList}">
                                                    <p>Không có sản phẩm được bán trong tháng/năm này</p>
                        </c:if>                      -->
                        <h1 style="text-align: center;">Dashboard</h1>                    
                        <h3 class="mb-0 text-center">
                            <strong>Revenue by month</strong>
                            <form id="f1" method="get" action="monthlyRevenue">
                                <div style="padding-left: 20px">
                                    <select name="year" class="form-control" id="dropdownYear" style="width: 120px;" onchange="getYear(this)">
                                        <c:set var="currentYear" value="2024"/>
                                        <c:set var="endYear" value="2018"/>
                                        <c:forEach var="year" begin="0" end="${currentYear - endYear}">
                                            <option  value="${currentYear - year}">${currentYear - year}</option>
                                        </c:forEach>
                                    </select>

                                    <select name="month" class="form-control" id="dropdownMonth" style="width: 120px;">
                                        <option value="" selected="" disabled="">-- Select Month --</option>
                                        <c:forEach var="month" begin="1" end="12">
                                            <option  value="${month}">${month}</option>
                                        </c:forEach>
                                    </select>                               
                                    <button style="width: 100px; padding: 0" class="form-control" type="submit">Submit</button>
                                </div>
                            </form>
                        </h3>
                        <div class="admin-content-main-chart">
                            <div class="admin-content-main-chart-line">            
                                <canvas id="myChart"></canvas>
                            </div>

                            <div class="admin-content-main-chart-bar-chart">
                                <canvas id="myBarChart"></canvas>
                            </div>
                        </div>
                    </div>                             
                </div>
            </div>

        </div>
    </div>
</div> 

</section>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
            datasets: [{
                    label: 'Biểu đồ doanh thu tổng của cả năm',
                    data: [${requestScope.month1.total}, ${requestScope.month2.total}, ${requestScope.month3.total}, ${requestScope.month4.total}, ${requestScope.month5.total}
                        , ${requestScope.month6.total}, ${requestScope.month7.total}, ${requestScope.month8.total}, ${requestScope.month9.total}, ${requestScope.month10.total}
                        , ${requestScope.month11.total}, ${requestScope.month12.total}],
                    fill: false,
                    borderColor: 'rgb(75, 192, 192)',
                    tension: 0.1
                }]
        },
        options: {}
    });
</script>

<script>
    var xValues = ["${requestScope.pro1.productName}", "${requestScope.pro2.productName}", "${requestScope.pro3.productName}", "${requestScope.pro4.productName}", "${requestScope.pro5.productName}"];
//    var xValues = [1, 2, 3, 4, 5];
    var yValues = [${requestScope.pro1.total}, ${requestScope.pro2.total}, ${requestScope.pro3.total}, ${requestScope.pro4.total}, ${requestScope.pro5.total}];
    var barColors = ["red", "green", "blue", "orange", "brown"];

    new Chart("myBarChart", {
        type: "bar",
        data: {
            labels: xValues,
            datasets: [{
                    label: 'Biểu đồ Top 5 sản phẩm bán chạy theo tháng',
                    backgroundColor: barColors,
                    data: yValues,
                    borderColor: 'rgb(75, 192, 192)'
                }]
        },
        options: {
            legend: {display: false},
            title: {
                display: true,
                text: "TOP 5 Best Selling Product"
            }
        }
    });


</script>
<script src="js/javascript.js"></script>
</body>
</html>
