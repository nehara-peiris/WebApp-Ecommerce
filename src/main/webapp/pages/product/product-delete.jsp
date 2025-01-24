<%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/22/25
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>

<h1>Delete Product</h1>

<form action="${pageContext.request.contextPath}/product-delete" method="post">
    <label for="id"> ID : </label>
    <input type="text" id="id" name="p_id">

    <button type="submit">Delete Product</button>
</form>

</body>
</html>
