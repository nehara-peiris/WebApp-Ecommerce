<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Category</title>
</head>
<body>

<h1>Update Category</h1>

<%
    String message = request.getParameter("message");
    String error = request.getParameter("error");
%>

<%
    if (message != null){
%>
<div style="color: green"> <%=message%> </div>
<%
    }
%>

<%
    if (error != null){
%>
<div style="color: red"> <%=error%> </div>
<%
    }
%>


<form action="${pageContext.request.contextPath}/category-update" method="post">
    <label for="id">ID : </label><br>
    <input type="text" id="id" name="cat_id"><br><br>

    <label for="name">Name : </label><br>
    <input type="text" id="name" name="cat_name"><br><br>

    <label for="desc">Description : </label><br>
    <input type="text" id="desc" name="cat_desc"><br><br>

    <button type="submit">Update Category</button>
</form>

</body>
</html>
