<%@ page import="java.util.List" %>
<%@ page import="lk.ijse.myclosetecom_web.dto.CategoryDTO" %>
<%@ page import="lk.ijse.myclosetecom_web.entity.Category" %>
<%@ page import="lk.ijse.myclosetecom_web.dto.UserDTO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>

<h1>User List</h1>

<%
    List<UserDTO> dataList = (List<UserDTO>) request.getAttribute("users");
    if (dataList != null && !dataList.isEmpty()){
%>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Username</th>
        <th>email</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (UserDTO userDTO : dataList){
    %>
    <tr>
        <td><%=userDTO.getUId()%></td>
        <td><%=userDTO.getFullName()%></td>
        <td><%=userDTO.getUName()%></td>
        <td><%=userDTO.getEmail()%></td>
        <td><%=userDTO.getPassword()%></td>
        <td><%=userDTO.getRole()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }else {
%>
<p>No User Found</p>
<%
    }
%>

</body>
</html>
