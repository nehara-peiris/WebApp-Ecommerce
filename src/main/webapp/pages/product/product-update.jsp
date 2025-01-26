<%@ page import="lk.ijse.myclosetecom_web.dto.ProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>

<h1>Update Product</h1>

<%
    String message = request.getParameter("message");
    String error = request.getParameter("error");
%>

<%
    if (message != null) {
%>
<div style="color: green"> <%= message %> </div>
<%
    }
%>

<%
    if (error != null) {
%>
<div style="color: red"> <%= error %> </div>
<%
    }
%>


<form action="${pageContext.request.contextPath}/product-update" method="post" enctype="multipart/form-data">
    <label for="p_id">Product ID:</label><br>
    <input type="text" id="p_id" name="p_id" required><br><br>

    <label for="cat_id">Category ID:</label><br>
    <input type="text" id="cat_id" name="cat_id" required><br><br>

    <label for="name">Product Name:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="price">Price:</label><br>
    <input type="number" id="price" name="price" step="0.01" required><br><br>

    <label for="qtyOnHand">Quantity:</label><br>
    <input type="number" id="qtyOnHand" name="qtyOnHand" required><br><br>

    <label for="image">Image (leave blank to keep current):</label><br>
    <input type="file" id="image" name= "image" accept="image/*"><br><br>

    <button type="submit">Update Product</button>
</form>

</body>
</html>