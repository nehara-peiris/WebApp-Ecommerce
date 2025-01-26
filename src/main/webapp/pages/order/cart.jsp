<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="lk.ijse.myclosetecom_web.dto.ProductDTO" %>
<%@ page import="lk.ijse.myclosetecom_web.dto.CartDTO" %>
<%
    // Assuming you have a CartItemDTO that contains product details and quantity
    List<CartDTO> cartItems = (List<CartDTO>) request.getAttribute("cartItems");
    double totalPrice = 0.0;

    if (cartItems != null) {
        for (CartDTO item : cartItems) {
            totalPrice += item.getPPrice() * item.getQuantity();
        }
    }
%>
<html>
<head>
    <title>Your Shopping Cart</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h1>Your Shopping Cart</h1>

<%
    if (cartItems == null || cartItems.isEmpty()) {
%>
<p>Your cart is empty.</p>
<%
} else {
%>
<table>
    <tr>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
        <th>Action</th>
    </tr>
    <%
        for (CartDTO item : cartItems) {
            double itemTotal = item.getPPrice() * item.getQuantity();
    %>
    <tr>
        <td><%= item.getPName() %></td>
        <td>$<%= item.getPPrice() %></td>
        <td>
            <form action="${pageContext.request.contextPath}/update-cart" method="post">
                <input type="hidden" name="productId" value="<%= item.getPId() %>">
                <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" required>
                <button type="submit">Update</button>
            </form>
        </td>
        <td>$<%= itemTotal %></td>
        <td>
            <form action="${pageContext.request.contextPath}/remove-from-cart" method="post">
                <input type="hidden" name="productId" value="<%= item.getPId() %>">
                <button type="submit">Remove</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

<h2>Total Price: $<%= totalPrice %></h2>

<form action="${pageContext.request.contextPath}/checkout" method="post">
    <button type="submit">Proceed to Checkout</button>
</form>
<%
    }
%>

</body>
</html>