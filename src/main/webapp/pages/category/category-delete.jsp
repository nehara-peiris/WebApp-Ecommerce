
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>

<h1>Delete Customer</h1>

<form action="${pageContext.request.contextPath}/category-delete" method="post">
    <label for="id"> ID : </label>
    <input type="text" id="id" name="cat_id">

    <button type="submit">Delete Category</button>
</form>

</body>
</html>
