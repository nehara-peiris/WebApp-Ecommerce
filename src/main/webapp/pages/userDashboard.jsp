<%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/24/25
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
--%>
<html>
<head>
    <title>User Dashboard</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        body{
            margin: 30px;
        }
    </style>
</head>
<body>

<!-- Top Header Start -->
<div class="top-header">
    <div class="container">
        <div class="row align-items-center">
            <!-- Logo Section -->
            <div class="col-md-3">
                <div class="logo">
                    <a href="#">
                        <img src="../assets/img/logo/logo.png" alt="Website Logo">
                    </a>
                </div>
            </div>

            <!-- Search Bar Section -->
            <div class="col-md-6">
                <div class="search d-flex">
                    <input type="text" placeholder="Search" aria-label="Search" class="form-control">
                    <button class="btn btn-primary">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                </div>
            </div>

            <!-- User and Cart Section -->
            <div class="col-md-3">
                <div class="user d-flex justify-content-end align-items-center">
                    <!-- My Account Dropdown -->
                    <div class="dropdown me-3">
                        <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">My Account</a>
                        <ul class="dropdown-menu">
                            <li><a href="#" class="dropdown-item">Login</a></li>
                            <li><a href="#" class="dropdown-item">Register</a></li>
                        </ul>
                    </div>
                    <!-- Cart Icon -->
                    <a href="cart.jsp" class="cart position-relative">
                        <i class="fa fa-cart-plus" aria-hidden="true"></i>
                        <span class="badge bg-danger position-absolute top-0 start-100 translate-middle">(0)</span>
                    </a>
                </div>
            </div>
        </div>

        <!-- Navigation Bar -->
        <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-3">
            <a href="#" class="navbar-brand">MENU</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav m-auto">
                    <li class="nav-item">
                        <a href="../index.jsp" class="nav-link active">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link text-white">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a href="order/order-list.jsp" class="nav-link text-white">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a href="product/product-wall.jsp" class="nav-link text-white">Browse</a>
                    </li>
                    <li class="nav-item">
                        <a href="../contact.jsp" class="nav-link">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a href="login.jsp" class="nav-link" id="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>

<!-- Dashboard Section -->
<div class="container mt-5">
    <h2 class="mb-4">Welcome to Your Dashboard</h2>
    <div class="row">
        <!-- Statistics Section -->
        <div class="col-md-4">
            <div class="card text-white bg-primary mb-3">
                <div class="card-body">
                    <h5 class="card-title">Orders</h5>
                    <p class="card-text">You have <strong>12</strong> active orders.</p>
                    <a href="order/order-list.jsp" class="btn btn-light">View Orders</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-white bg-success mb-3">
                <div class="card-body">
                    <h5 class="card-title">Cart</h5>
                    <p class="card-text">Your cart has <strong>3</strong> items.</p>
                    <a href="cart.jsp" class="btn btn-light">View Cart</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-white bg-warning mb-3">
                <div class="card-body">
                    <h5 class="card-title">Profile</h5>
                    <p class="card-text">Complete your profile to unlock full features.</p>
                    <a href="myAccount.jsp" class="btn btn-light">Go to Profile</a>
                </div>
            </div>
        </div>
    </div>

    <h3 class="mt-5 mb-3">Quick Actions</h3>
    <div class="row">
        <div class="col-md-3">
            <a href="browse.jsp" class="btn btn-outline-primary btn-block mb-3">Browse Products</a>
        </div>
        <div class="col-md-3">
            <a href="checkout.jsp" class="btn btn-outline-success btn-block mb-3">Proceed to Checkout</a>
        </div>
        <div class="col-md-3">
            <a href="refund.jsp" class="btn btn-outline-warning btn-block mb-3">Request Refund</a>
        </div>
        <div class="col-md-3">
            <a href="../contact.jsp" class="btn btn-outline-info btn-block mb-3">Contact Support</a>
        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- Logout Confirmation -->
<script>
    document.getElementById("logout").addEventListener("click", function (e) {
        if (!confirm("Are you sure you want to log out?")) {
            e.preventDefault();
        }
    });
</script>
</body>
</html>
