<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category Management</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Category Management</h2>
    <!-- Display success or error messages -->
    <%
        String message = (String) request.getAttribute("message");
        String messageType = (String) request.getAttribute("messageType"); // "success" or "error"
        if (message != null) {
    %>
    <div class="alert alert-<%= messageType %>" role="alert">
        <%= message %>
    </div>
    <% } %>

    <form action="category" method="post" class="mt-4">
        <input type="hidden" name="action" value="<%= request.getAttribute("action") != null ? request.getAttribute("action") : "add" %>">
        <div class="form-group">
            <label for="cat_id">Category ID</label>
            <input type="text" class="form-control" id="cat_id" name="cat_id"
                   value="<%= request.getAttribute("cat_id") != null ? request.getAttribute("cat_id") : "" %>"
                   placeholder="Enter Category ID" required>
        </div>
        <div class="form-group">
            <label for="name">Category Name</label>
            <input type="text" class="form-control" id="name" name="name"
                   value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"
                   placeholder="Enter Category Name" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3"
                      placeholder="Enter Category Description" required><%= request.getAttribute("description") != null ? request.getAttribute("description") : "" %></textarea>
        </div>
        <div class="text-center">
            <button type="submit" name="action" value="add" class="btn btn-primary">Add</button>
            <button type="submit" name="action" value="update" class="btn btn-warning">Update</button>
            <button type="submit" name="action" value="delete" class="btn btn-danger">Delete</button>
            <button type="reset" class="btn btn-secondary">Clear</button>
        </div>
    </form>
</div>

<!-- Include Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
