<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .form-container {
            width: 300px;
            margin: 0 auto;
        }
        h2 {
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        input[type="text"],
        input[type="number"] {
            padding: 8px;
            font-size: 14px;
        }
        button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="form-container">

    <h2>Update Product</h2>

    <form action="${pageContext.request.contextPath}/product-update" method="post">
        <label for="p_id">Product ID:</label>
        <input type="text" id="p_id" name="p_id" required>

        <label for="cat_id">Category ID:</label>
        <input type="text" id="cat_id" name="cat_id" required>

        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" required>

        <label for="qtyOnHand">Quantity on Hand:</label>
        <input type="number" id="qtyOnHand" name="qtyOnHand" required>

        <button type="submit">Update Product</button>
    </form>
</div>
</body>
</html>
