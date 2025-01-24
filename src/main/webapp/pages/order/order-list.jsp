<%@ page import="lk.ijse.myclosetecom_web.dto.OrderDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/24/25
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Management</title>
</head>
<body>

<h1>Order List</h1>

<%
    List<OrderDTO> dataList = (List<OrderDTO>) request.getAttribute("orders");
    if (dataList != null && !dataList.isEmpty()){
%>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>UserID</th>
        <th>Date</th>
        <th>Total</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (OrderDTO orderDTO : dataList){
    %>
    <tr>
        <td><%=orderDTO.getOId()%></td>
        <td><%=orderDTO.getUser()%></td>
        <td><%=orderDTO.getDate()%></td>
        <td><%=orderDTO.getTotal()%></td>
        <td><%=orderDTO.getStatus()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
}else {
%>
<p>No Orders Found</p>
<%
    }
%>

</body>
</html>
