<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="dropdown-menu m-0 bg-secondary rounded-0">
    <a href="viewProfileAction" class="dropdown-item">Hồ sơ của tôi</a>
    <a href="purchasedOrder" class="dropdown-item">Đơn hàng
        <c:if test="${not empty sessionScope.NUMBER_ORDER}">
            <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: 44px;left: 127px;height: 23px;min-width: 23px;">${sessionScope.NUMBER_ORDER}</span>
        </c:if>
    </a>
    <a href="logoutAction" class="dropdown-item">Đăng xuất</a>
</div>
