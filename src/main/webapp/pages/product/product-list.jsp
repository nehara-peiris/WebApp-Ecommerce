<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>Product List</h2>
<table>
    <tr>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Image</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.qtyOnHand}</td>
            <td><img src="${product.imgUrl}" alt="${product.name}" width="100" /></td>
        </tr>
    </c:forEach>
</table>


<c:if test="${empty productList}">
    <p>No products available.</p>
</c:if>
</body>
</html>