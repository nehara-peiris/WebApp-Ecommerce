<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f9;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        button {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Customer Management</h2>
    <form action="CustomerServlet" method="post">
        <div class="form-group">
            <label for="customerId">Customer ID</label>
            <input type="text" id="customerId" name="customerId" placeholder="Enter Customer ID" required>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" placeholder="Enter Customer Name" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter Email Address" required>
        </div>
        <div class="form-group">
            <label for="contact">Contact Number</label>
            <input type="text" id="contact" name="contact" placeholder="Enter Contact Number" required>
        </div>
        <div class="form-group">
            <button type="submit" name="action" value="add">Add Customer</button>
            <button type="submit" name="action" value="update">Update Customer</button>
            <button type="submit" name="action" value="delete">Delete Customer</button>
        </div>
    </form>

    <!-- Customer List -->
    <h3>Customer List</h3>
    <table>
        <thead>
        <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Contact</th>
        </tr>
        </thead>
        <tbody>
        <%--

        &lt;%&ndash; This section will dynamically render customer data from your backend &ndash;%&gt;
        <%
            // Example backend logic to fetch customer data
            List<Customer> customers = (List<Customer>) request.getAttribute("customerList");
            if (customers != null) {
                for (Customer customer : customers) {
        %>
        <tr>
            <td><%= customer.getCustomerId() %></td>
            <td><%= customer.getName() %></td>
            <td><%= customer.getEmail() %></td>
            <td><%= customer.getContact() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">No customers found.</td>
        </tr>
        <% } %>

        --%>
        </tbody>
    </table>
</div>
</body>
</html>
