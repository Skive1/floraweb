<%-- 
    Document   : deliveryRevenue
    Created on : Oct 25, 2024, 3:13:46 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- FavIcon -->
        <link rel="icon" href="img/flora-favicon.png"/>
        <title>Revenue of Shipper</title>
        <style>
            body { font-family: Arial, sans-serif; margin: 0; padding: 20px; }
            header { background: #4CAF50; color: white; padding: 10px; text-align: center; }
            table { width: 100%; border-collapse: collapse; margin-top: 20px; }
            th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
            th { background-color: #f2f2f2; }
            .rating { margin-top: 20px; }
            canvas { max-width: 100%; height: 400px; margin-top: 20px; }
            @media (max-width: 600px) {
                th, td { font-size: 14px; }
            }
            form {
                margin: 20px;
                font-family: Arial, sans-serif;
            }


            #f1 > div {
                display: flex;
                align-items: center; 
            }

            .form-control {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-right: 10px; 
                transition: border-color 0.3s;
            }

            .form-control:hover {
                border-color: #007bff;
            }

            button {
                background-color: #007bff; 
                color: white; 
                border: none;
                border-radius: 4px;
                cursor: pointer; 
                transition: background-color 0.3s, transform 0.2s;
                height: 40px;
            }


            button:hover {
                background-color: #0056b3; 
                transform: scale(1.05); 
            }


            button:active {
                transform: scale(0.95); 
            }
            .container {
                display: flex; 
                justify-content: space-between; 
            }
            .rating {
                background: #fff;
                border-radius: 8px;
                padding: 20px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                max-width: 600px;
                margin: auto;
            }
            h2 {
                color: #333;
                text-align: center;
                margin-bottom: 20px;
            }
            p {
                font-size: 18px;
                color: #555;
                margin: 10px 0;
            }
            .stars {
                font-size: 24px;
                color: #ffcc00; 
            }
            .empty-stars {
                color: #ccc; 
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Revenue of ${sessionScope.USER.fullName}</h1>
        </header>

        <div class="container">
            <form id="f1" method="get" action="deliveryIncome">
                <div style="padding-left: 20px">
                    <select name="year" class="form-control" id="yearSelect" required>
                        <option value="" disabled ${empty requestScope.curYear ? 'selected' : ''}>-- Select  --</option>
                        <c:forEach var="year" begin="2022" end="2024">
                            <option value="${year}" ${year == requestScope.curYear ? 'selected' : ''}>${year}</option>
                        </c:forEach>
                    </select>         
                    <button style="width: 100px; padding: 0" class="form-control" type="submit">Submit</button>
                </div>
            </form>
            <ul class="Back-btn" style="margin-right: 25px"> 
                <a href="home"/><button type="button">BACK TO STORE</button></a>    
            </ul>  
        </div>

        <section>
            <h2>Number of orders delivered in ${requestScope.curYear}</h2>
            <c:if test="${empty listOrder}">
                No orders ${requestScope.curYear}
            </c:if>
            <table>
                <thead>
                    <tr>
                        <th>Months</th>
                        <th>Orders</th>
                    </tr>  
                </thead>
                <tbody>
                    <c:forEach items="${listOrder}" var="o" varStatus="counter">
                        <tr>                                                    
                            <td>${o.month}</td>
                            <td>${Math.round(o.total)}</td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>

            <div style="margin-top: 20px" class="rating">
                <h2>Star Rating</h2>
                <c:if test="${not empty requestScope.listRating}">
                    <c:forEach var="rating" items="${requestScope.listRating}">
                        <p>Total reviews: ${rating.totalRecords}</p>                      
                        <c:set var="rate" value="${rating.totalRecords != 0 ? rating.totalRateStar / rating.totalRecords : 0}" />
                        <c:set var="fullStars" value="${Math.floor(rate)}" />
                        <c:set var="halfStar" value="${rate - fullStars}" />
                        <c:set var="emptyStars" value="${5 - fullStars - (halfStar >= 0.5 ? 1 : 0)}" />
                        <p>
                            Average rating (<fmt:formatNumber value="${rate}" pattern="#0.00"/>/5):
                            <span class="stars">
                                <c:forEach var="i" begin="1" end="${fullStars}">
                                    ★
                                </c:forEach>
                                <c:if test="${halfStar >= 0.5}">
                                    ★
                                </c:if>
                                <c:forEach var="j" begin="1" end="${emptyStars}">
                                    <span class="empty-stars">☆</span>
                                </c:forEach>
                            </span>
                        </p>                      
                    </c:forEach>
                </c:if>
            </div>

            <h2>Income chart</h2>
            <canvas id="revenueChart"></canvas>
        </section>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
            const ctx = document.getElementById('revenueChart').getContext('2d');
            const revenueChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
                    datasets: [{
                            label: 'Income (VNĐ)',
                            data: [
            ${requestScope.month1.total != null ? requestScope.month1.total : 0},
            ${requestScope.month2.total != null ? requestScope.month2.total : 0},
            ${requestScope.month3.total != null ? requestScope.month3.total : 0},
            ${requestScope.month4.total != null ? requestScope.month4.total : 0},
            ${requestScope.month5.total != null ? requestScope.month5.total : 0},
            ${requestScope.month6.total != null ? requestScope.month6.total : 0},
            ${requestScope.month7.total != null ? requestScope.month7.total : 0},
            ${requestScope.month8.total != null ? requestScope.month8.total : 0},
            ${requestScope.month9.total != null ? requestScope.month9.total : 0},
            ${requestScope.month10.total != null ? requestScope.month10.total : 0},
            ${requestScope.month11.total != null ? requestScope.month11.total : 0},
            ${requestScope.month12.total != null ? requestScope.month12.total : 0}
                            ],
                            borderColor: 'rgba(75, 192, 192, 1)',
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderWidth: 2,
                            fill: true
                        }]
                },
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>
    </body>
</html>
