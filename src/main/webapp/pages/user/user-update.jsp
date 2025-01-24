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


<form action="user-update" method="post">
    <label for="id">ID : </label><br>
    <input type="text" id="id" name="user_id"><br><br>

    <label for="fullname">Full name : </label><br>
    <input type="text" id="fullname" name="fullname"><br><br>

    <label for="uname">Description : </label><br>
    <input type="text" id="uname" name="user_name"><br><br>

    <label for="email">Description : </label><br>
    <input type="text" id="email" name="email"><br><br>

    <label for="password">Description : </label><br>
    <input type="text" id="password" name="password"><br><br>

    <label for="role">Description : </label><br>
    <input type="text" id="role" name="role"><br><br>

    <button type="submit">Update Category</button>
</form>

</body>
</html>
