<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Focus - Bootstrap Admin Dashboard</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/img/adminDash/favicon.png">
    <link href="assets/vendor/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <link href="assets/vendor/chartist/css/chartist.min.css" rel="stylesheet">
    <link href="assets/css/adminDash.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<!-- Wrapper -->
<div class="wrapper">
    <!-- Sidebar -->
    <div class="sidebar bg-dark text-white fixed-left">
        <div class="sidebar-header">
            <img src="assets/img/adminDash/favicon.png" class="logo" alt="logo">
            <h3>Admin Dashboard</h3>
        </div>
        <ul class="list-unstyled">
            <li><a href="#" class="text-white">Dashboard</a></li>
            <li><a href="product/product.jsp" class="text-white">Products</a></li>
            <li><a href="category/category.jsp" class="text-white">Category</a></li>
            <li><a href="order/order-list.jsp" class="text-white">Orders</a></li>
            <li><a href="user/user-jsp" class="text-white">Users</a></li>
            <li><a href="#" class="text-white">Settings</a></li>
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
                        <a class="nav-link" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Dashboard Content -->
        <div class="container-fluid mt-5 pt-3">
            <div class="row">
                <!-- Total Users Section -->
                <div class="col-md-3">
                    <div class="card shadow-sm">
                        <div class="card-body text-center">
                            <h5 class="card-title">Total Users</h5>
                            <h3>1,230</h3>
                        </div>
                    </div>
                </div>

                <!-- Total Orders Section -->
                <div class="col-md-3">
                    <div class="card shadow-sm">
                        <div class="card-body text-center">
                            <h5 class="card-title">Total Orders</h5>
                            <h3>450</h3>
                        </div>
                    </div>
                </div>

                <!-- Revenue Section -->
                <div class="col-md-3">
                    <div class="card shadow-sm">
                        <div class="card-body text-center">
                            <h5 class="card-title">Revenue</h5>
                            <h3>$12,300</h3>
                        </div>
                    </div>
                </div>

                <!-- Calendar Section -->
                <div class="col-md-3">
                    <div class="card shadow-sm">
                        <div class="card-body text-center">
                            <h5 class="card-title">Calendar</h5>
                            <div id="calendar"></div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Chart Section -->
            <div class="row mt-4">
                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">Sales Chart</h5>
                            <div id="sales-chart"></div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">Product Stats</h5>
                            <div id="product-stats"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- JS Files -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    // Initialize calendar
    $(document).ready(function() {
        $('#calendar').pignoseCalendar();
    });

    // Initialize Chartist
    new Chartist.Line('#sales-chart', {
        labels: ['January', 'February', 'March', 'April', 'May'],
        series: [[5, 8, 3, 7, 5]]
    });
    new Chartist.Pie('#product-stats', {
        series: [30, 20, 50]
    });
</script>
</body>
</html>
