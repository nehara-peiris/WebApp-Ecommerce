<%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/20/25
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>LoginForm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="../assets/fonts2/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="../assets/css/register.css">
</head>

<body>

<div class="wrapper" style="background-image: url('../assets/img/login/bg-registration-form-2.jpg');">
    <div class="inner">
        <form action="">
            <h3>Login Form</h3>
            <div class="form-wrapper">
                <label>Username</label>
                <input type="text" class="form-control">
            </div>
            <div class="form-wrapper">
                <label>Password</label>
                <input type="password" class="form-control">
            </div>

            <a href="register.jsp">Create an account</a>

            <button>Login</button>
        </form>
    </div>
</div>

</body>
</html>
