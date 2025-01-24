<%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/24/25
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <div class="sidebar bg-dark text-white fixed-left">
        <div class="sidebar-header">
            <img src="assets/img/adminDash/favicon.png" class="logo" alt="logo">
            <h3>User Dashboard</h3>
        </div>
        <ul class="list-unstyled">
            <li><a href="#" class="text-white">Dashboard</a></li>
            <li><a href="order/order-list.jsp" class="text-white">Orders</a></li>
            <li><a href="order/order-wall.jsp" class="text-white">Browse</a></li>
            <li><a href="myAccount.jsp" class="text-white">My Account</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="content-wrapper">
        <!-- Top Navigation Bar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

    </div>

</div>
</body>
</html>
