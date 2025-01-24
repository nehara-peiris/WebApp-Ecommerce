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

<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="wrapper" style="background-image: url('../assets/img/login/bg-registration-form-2.jpg');">
        <div class="inner">
            <h3>Login Form</h3>
            <div class="form-wrapper">
                <label>Username</label>
                <input type="text" class="form-control" name="username" required>
            </div>
            <div class="form-wrapper">
                <label>Password</label>
                <input type="password" class="form-control" name="password" required>
            </div>

            <a href="register.jsp">Create an account</a>

            <button type="submit">Login</button>

            <c:if test="${not empty error}">
                <p style="color: red;">${error}</p>
            </c:if>
        </div>
    </div>
</form>

</body>
</html>
