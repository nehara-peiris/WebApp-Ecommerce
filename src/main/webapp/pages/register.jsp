<%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/20/25
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>RegistrationForm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="../assets/fonts2/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="../assets/css/register.css">
</head>

<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    <div class="wrapper" style="background-image: url('../assets/img/login/bg-registration-form-2.jpg');">
        <div class="inner">
            <h3>Registration Form</h3>
            <div class="form-group">
                <div class="form-wrapper">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" class="form-control">
                </div>
                <div class="form-wrapper">
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" class="form-control">
                </div>
            </div>
            <div class="form-wrapper">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" class="form-control">
            </div>
            <div class="form-wrapper">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" class="form-control">
            </div>
            <div class="form-wrapper">
                <label for="role">Role</label>
                <input type="text" id="role" name="role" class="form-control">
            </div>
            <div class="form-wrapper">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control">
            </div>
            <div class="form-wrapper">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control">
            </div>
            <div class="checkbox">
                <label for="terms">
                    <input type="checkbox" id="terms" name="terms"> I accept the Terms of Use & Privacy Policy.
                    <span class="checkmark"></span>
                </label>
            </div>
            <button type="submit">Register Now</button>
        </div>
    </div>
</form>

<script>
    function navigateToLogin() {
        window.location.href = 'pages/login.jsp';
    }
</script>

</body>
</html>
