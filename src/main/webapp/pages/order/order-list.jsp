<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Management</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            padding: 0;
            background-color: black;
            overflow: hidden;
            color: black;
        }

        #main-container {
            height: 100%;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding: 20px;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            background-color: #fff;
            color: #212529;
        }

        table th, table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #dee2e6;
        }

        table th {
            background-color: #f8f9fa;
            color: #495057;
        }
    </style>
</head>
<body>

<div class="top-header">
    <div class="container">
        <div class="row align-items-center">
            <!-- Logo Section -->
            <div class="col-md-3">
                <div class="logo">
                    <a href="#">
                        <img src="../../assets/img/logo/logo.png" alt="Website Logo">
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
                    <a href="../product/viewProduct.jsp" class="cart position-relative">
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
                        <a href="../../index.jsp" class="nav-link active">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link text-white">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a href="../order/order-list.jsp" class="nav-link text-white">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a href="../product/viewProduct.jsp" class="nav-link text-white">Browse</a>
                    </li>
                    <li class="nav-item">
                        <a href="../contact.jsp" class="nav-link">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a href="../login.jsp" class="nav-link" id="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>


<div id="main-container">
    <div class="container">
        <!-- Orders Table -->
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Order ID</th>
                <th>User ID</th>
                <th>Total</th>
                <th>Date</th>
                <th>Status</th>

            </tr>
            </thead>
            <tbody>
            <%
                Connection connection = null;
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    // Load the database driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish a connection to the database
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Ijse@123");

                    // SQL query to fetch orders (removed status)
                    String sql = "SELECT o_id, user_id, date, total, status FROM orders";
                    pstm = connection.prepareStatement(sql);
                    rs = pstm.executeQuery();

                    // Loop through the result set and display each order
                    while (rs.next()) {
                        int orderId = rs.getInt("o_id");
                        int userId = rs.getInt("user_id");
                        Date date = rs.getDate("date");
                        double total = rs.getDouble("total");
                        String status = rs.getString("status");
            %>
            <tr>
                <td><%= orderId %></td>
                <td><%= userId %></td>
                <td><%= total %></td>
                <td><%= date %></td>
                <td><%= status %></td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (pstm != null) pstm.close();
                        if (connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>