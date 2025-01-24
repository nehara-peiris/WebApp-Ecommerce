<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save User</title>
</head>
<body>

<h1>Save User</h1>

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


<form action="${pageContext.request.contextPath}/user-save" method="post">
    <label for="fullname">Full name : </label><br>
    <input type="text" id="fullname" name="fullname"><br><br>

    <label for="uname">Username : </label><br>
    <input type="text" id="uname" name="username"><br><br>

    <label for="email">Description : </label><br>
    <input type="text" id="email" name="email"><br><br>

    <label for="password">Description : </label><br>
    <input type="text" id="password" name="password"><br><br>

    <label for="role">Description : </label><br>
    <input type="text" id="role" name="role"><br><br>

    <button type="submit">Save User</button>
</form>

</body>
</html>
