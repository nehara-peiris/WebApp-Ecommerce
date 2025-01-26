<%@ page import="lk.ijse.myclosetecom_web.dto.ProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .form-container {
            max-width: 500px; /* Increased width for better layout */
            margin: 0 auto;
            background: #fff;
            padding: 30px; /* Increased padding for a more spacious feel */
            border-radius: 8px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* Enhanced shadow for depth */
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px; /* Added margin for spacing */
        }
        .message {
            text-align: center;
            margin-bottom: 20px;
        }
        .success {
            color: green;
        }
        .error {
            color: red;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-weight: bold;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="number"],
        input[type="file"] {
            padding: 12px; /* Increased padding for better touch targets */
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="number"]:focus {
            border-color: #007BFF;
            outline: none;
        }
        button {
            padding: 12px; /* Increased padding for better touch targets */
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
        /* Responsive design */
        @media (max-width: 600px) {
            .form-container {
                width: 90%; /* Make the form responsive on smaller screens */
            }
        }
    </style>
</head>
<body>

<div class="form-container">
    <h1>Update Product</h1>

    <%
        String message = request.getParameter("message");
        String error = request.getParameter("error");
    %>

    <%
        if (message != null) {
    %>
    <div class="message success"> <%= message %> </div>
    <%
        }
    %>

    <%
        if (error != null) {
    %>
    <div class="message error"> <%= error %> </div>
    <%
        }
    %>

    <form action="${pageContext.request.contextPath}/product-update" method="post" enctype="multipart/form-data">
        <label for="p_id">Product ID:</label>
        <input type="text" id="p_id" name="p_id" required>

        <label for="cat_id">Category ID:</label>
        <input type="text" id="cat_id" name="cat_id" required>

        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required>

        <label for="qtyOnHand">Quantity:</label>
        <input type="number" id="qtyOnHand" name="qtyOnHand" required>

        <label for="image">Image:</label>
        <input type="file" id="image" name="image" accept="image/*">

        <button type="submit">Update Product</button>
    </form>
</div>

</body>
</html>