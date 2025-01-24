<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Account</title>
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h4 {
            margin-bottom: 20px;
        }

        form div {
            margin-bottom: 15px;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        input[type="text"], input[type="password"], input[type="email"] {
            width: 50%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<form action="myAccount" method="post">
    <div class="tab-pane fade show active" id="account-tab" role="tabpanel" aria-labelledby="account-nav">
        <h4>Account Details</h4>
        <div class="row">
            <div class="col-md-6">
                <input type="text" name="fullName" placeholder="Full Name" required>
            </div>
            <div class="col-md-6">
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div class="col-md-6">
                <input type="email" name="email" placeholder="Email" required>
            </div>
            <div class="col-md-12">
                <button type="submit" name="action" value="updateAccount">Update Account</button>
            </div>
        </div>

        <h4>Password Change</h4>
        <div class="row">
            <div class="col-md-12">
                <input type="password" name="currentPassword" placeholder="Current Password" required>
            </div>
            <div class="col-md-6">
                <input type="password" name="newPassword" placeholder="New Password" required>
            </div>
            <div class="col-md-6">
                <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
            </div>
            <div class="col-md-12">
                <button type="submit" name="action" value="changePassword">Save Changes</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
