<%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/22/25
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Category</title>
</head>
<body>

<h1>Save Customer</h1>

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


<form action="customer-save" method="post">
    <label for="name">Name : </label><br>
    <input type="text" id="name" name="customer_name"><br><br>

    <label for="address">Address : </label><br>
    <input type="text" id="address" name="customer_address"><br><br>

    <label for="email">Email : </label><br>
    <input type="text" id="email" name="customer_email"><br><br>

    <button type="submit">Save Customer</button>
</form>

</body>
</html>
