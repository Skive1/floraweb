<%-- 
    Document   : AdminPage
    Created on : Sep 30, 2024, 10:06:05 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
    href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css"
    rel="stylesheet"
/>
    <link rel="stylesheet" href="style.css">
    <title>Admin</title>
</head>
<body>
    <style>
        root {
    --main-bg-color: #414e66;
    --sub-bg-color: #f2f7fb;
    --top-height: 70px;

}

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;

}
a {
    text-decoration: none;
    color: unset;
}

.row-grid {
    display: grid;
    justify-content: space-between;
}
/* main của admin */
.admin .row-grid {
    grid-template-columns: 20% 80%;

}
/* 
sidebar
*/
.admin-sidebar-top {
    width: 100px;
}

.admin-sidebar {
    height:100vh;
    background-color: #414e66;
}
.admin-sidebar-top img {
    width: 100px;
}

/* content */
.admin-content {
background-color: #f2f7fb;
}
    </style>
    <section class="admin">
        <div class="row-grid">
            <div class="admin-sidebar">
                <div class="admin-sidebar-top">
                    <img src="" alt=""> Ảnh logo
    
                </div> 
                <div class="admin-sidebar-content">
                    <ul>
                        <li>
                            <i class="ri-dashboard-fill"></i>
                            <a href="">Dashboard</a>                   
                        </li>
                        <li>
                            <li>
                                <i class="ri-dashboard-fill"></i>
                                <a href="">Event list</a>                   
                            </li>    
                        </li>
                            <i class="ri-dashboard-fill"></i>
                            <a href="">Order list</a>                   
                        </li>
                    </ul>
                </div>
            </div>
            <div class="admin-content">
                    Đấy là admin content
            </div>
        </div>
    </section>
</body>
</html>