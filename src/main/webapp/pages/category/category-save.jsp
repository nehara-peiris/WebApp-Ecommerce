<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Category</title>
</head>
<body>

<h1>Save Category</h1>

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


<form action="${pageContext.request.contextPath}/category-save" method="post">
    <label for="name">Name : </label><br>
    <input type="text" id="name" name="cat_name"><br><br>

    <label for="desc">Description : </label><br>
    <input type="text" id="desc" name="cat_desc"><br><br>

    <button type="submit">Save Category</button>
</form>

</body>
</html>
