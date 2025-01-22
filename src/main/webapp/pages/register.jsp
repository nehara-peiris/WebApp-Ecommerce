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

<div class="wrapper" style="background-image: url('../assets/img/login/bg-registration-form-2.jpg');">
    <div class="inner">
        <form action="">
            <h3>Registration Form</h3>
            <div class="form-group">
                <div class="form-wrapper">
                    <label>First Name</label>
                    <input type="text" class="form-control">
                </div>
                <div class="form-wrapper">
                    <label>Last Name</label>
                    <input type="text" class="form-control">
                </div>
            </div>
            <div class="form-wrapper">
                <label>Username</label>
                <input type="text" class="form-control">
            </div>
            <div class="form-wrapper">
                <label>Email</label>
                <input type="text" class="form-control">
            </div>
            <div class="form-wrapper">
                <label>Password</label>
                <input type="password" class="form-control">
            </div>
            <div class="form-wrapper">
                <label>Confirm Password</label>
                <input type="password" class="form-control">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> I accept the Terms of Use & Privacy Policy.
                    <span class="checkmark"></span>
                </label>
            </div>
            <button onclick="navigateToLogin()">Register Now</button>
        </form>
    </div>
</div>

<script>
    function navigateToLogin() {
        // Redirects to the login page
        window.location.href = 'login.jsp';
    }
</script>

</body>
</html>
