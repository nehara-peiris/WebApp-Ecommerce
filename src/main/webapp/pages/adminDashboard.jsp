<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Dashboard</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/img/adminDash/favicon.png">
    <link href="assets/vendor/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <link href="assets/vendor/chartist/css/chartist.min.css" rel="stylesheet">
    <link href="assets/css/adminDash.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

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
                    </div>
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
                        <a href="index.jsp" class="nav-link active">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link text-white">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a href="product/product.jsp" class="nav-link text-white">Products</a>
                    </li>
                    <li class="nav-item">
                        <a href="category/category.jsp" class="nav-link text-white">Categories</a>
                    </li>
                    <li class="nav-item">
                        <a href="order/order-list.jsp" class="nav-link text-white">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a href="user/user.jsp" class="nav-link text-white">Users</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link text-white">Settings</a>
                    </li>
                    <li class="nav-item">
                        <a href="login.jsp" class="nav-link" id="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>


<!-- Main Content -->
<div class="content-wrapper"
     style="background-color: #f9f9f9; font-family: 'Poppins', sans-serif; width: 75%; margin: 0 auto;">

    <!-- Dashboard Content -->
    <div class="container-fluid mt-5 pt-3">
        <div class="row">
            <!-- Fashion Enthusiasts Section -->
            <div class="col-md-3">
                <div class="card shadow-sm" style="border-radius: 15px; background: linear-gradient(135deg, #f3c5ff, #e1c3ff);">
                    <div class="card-body text-center">
                        <div class="icon mb-3">
                            <i class="fas fa-user-friends fa-2x text-white"></i>
                        </div>
                        <h5 class="card-title text-white" style="font-weight: 600;">Fashion Enthusiasts</h5>
                        <h3 id="total-users" style="color: #fff; font-weight: 700;">Loading...</h3>
                    </div>
                </div>
            </div>

            <!-- Orders Placed Section -->
            <div class="col-md-3">
                <div class="card shadow-sm" style="border-radius: 15px; background: linear-gradient(135deg, #ffb3c1, #ffa8b8);">
                    <div class="card-body text-center">
                        <div class="icon mb-3">
                            <i class="fas fa-shopping-bag fa-2x text-white"></i>
                        </div>
                        <h5 class="card-title text-white" style="font-weight: 600;">Orders Placed</h5>
                        <h3 id="total-orders" style="color: #fff; font-weight: 700;">Loading...</h3>
                    </div>
                </div>
            </div>

            <!-- Revenue Section -->
            <div class="col-md-3">
                <div class="card shadow-sm" style="border-radius: 15px; background: linear-gradient(135deg, #ffd3b6, #ffcab0);">
                    <div class="card-body text-center">
                        <div class="icon mb-3">
                            <i class="fas fa-dollar-sign fa-2x text-white"></i>
                        </div>
                        <h5 class="card-title text-white" style="font-weight: 600;">Revenue</h5>
                        <h3 id="total-revenue" style="color: #fff; font-weight: 700;">Loading...</h3>
                    </div>
                </div>
            </div>

            <!-- Calendar Section -->
            <div class="col-md-3">
                <div class="card shadow-sm" style="border-radius: 15px; background: linear-gradient(135deg, #a8e4ff, #98d5ff);">
                    <div class="card-body text-center">
                        <div class="icon mb-3">
                            <i class="fas fa-calendar-alt fa-2x text-white"></i>
                        </div>
                        <h5 class="card-title text-white" style="font-weight: 600;">Upcoming Events</h5>
                        <div id="calendar" style="color: #fff; font-weight: 500;"></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Chart Section -->
        <div class="row mt-5 justify-content-center" style="width: 75%; margin: 0 auto;">
            <!-- Sales Chart -->
            <div class="col-md-5 mx-3">
                <div class="card shadow-sm" style="border-radius: 15px; background-color: #fff; height: 100%;">
                    <div class="card-body d-flex flex-column align-items-center">
                        <h5 class="card-title" style="font-weight: 600; color: #555;">Sales Trends</h5>
                        <div id="sales-chart" style="width: 100%; height: 200px;"></div>
                    </div>
                </div>
            </div>

            <!-- Product Stats -->
            <div class="col-md-5 mx-3">
                <div class="card shadow-sm" style="border-radius: 15px; background-color: #fff; height: 100%;">
                    <div class="card-body d-flex flex-column align-items-center">
                        <h5 class="card-title" style="font-weight: 600; color: #555;">Best Sellers</h5>
                        <div id="product-stats" style="width: 100%; height: 200px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- JS Files -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartist/dist/chartist.min.js"></script>
<script src="assets/vendor/pg-calendar/js/pignose.calendar.min.js"></script>

<script>
    // Initialize Bootstrap Tooltips
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    // Simulate Dynamic Data Fetching
    setTimeout(() => {
        document.getElementById('total-users').textContent = "1,250";
        document.getElementById('total-orders').textContent = "480";
        document.getElementById('total-revenue').textContent = "$13,400";
    }, 1000);

    // Initialize Calendar
    $(document).ready(function() {
        $('#calendar').pignoseCalendar();
    });

    // Initialize Enhanced Chartist Line Chart
    new Chartist.Line('#sales-chart', {
        labels: ['January', 'February', 'March', 'April', 'May', 'June'],
        series: [
            [5, 9, 7, 8, 5, 3],
            [3, 7, 4, 6, 8, 5]
        ]
    });

    // Initialize Enhanced Chartist Pie Chart
    new Chartist.Pie('#product-stats', {
        series: [25, 35, 40],
        labels: ['Tops', 'Bottoms', 'Accessories']
    });
</script>
</body>
</html>
