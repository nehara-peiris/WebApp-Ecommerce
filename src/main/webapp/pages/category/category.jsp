<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category Management</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Light background for better contrast */
        }
        .container {
            margin-top: 50px;
        }
        h1 {
            text-align: center;
            color: #343a40; /* Darker color for the heading */
        }
        .btn {
            margin: 10px 0; /* Spacing between buttons */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Category Management System</h1>
    <div class="text-center">
        <a href="category-save.jsp" class="btn btn-primary btn-lg">Add New Category</a>
        <a href="category-list.jsp" class="btn btn-info btn-lg">View All Categories</a>
        <a href="category-delete.jsp" class="btn btn-danger btn-lg">Delete Category</a>
        <a href="category-update.jsp" class="btn btn-warning btn-lg">Update Category</a>
    </div>
</div>

<!-- Include Bootstrap JS (optional) -->
<script src="../../assets/js/bootstrap.min.js"></script>
</body>
</html>