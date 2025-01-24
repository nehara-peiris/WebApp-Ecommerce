<%@ page import="java.util.List" %>
<%@ page import="lk.ijse.myclosetecom_web.dto.CategoryDTO" %>
<%@ page import="lk.ijse.myclosetecom_web.entity.Category" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category List</title>
</head>
<body>

<h1>Category List</h1>

<%
    List<CategoryDTO> dataList = (List<CategoryDTO>) request.getAttribute("categories");
    if (dataList != null && !dataList.isEmpty()){
%>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (CategoryDTO categoryDTO : dataList){
    %>
    <tr>
        <td><%=categoryDTO.getCatId()%></td>
        <td><%=categoryDTO.getName()%></td>
        <td><%=categoryDTO.getDescription()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }else {
%>
<p>No Category Found</p>
<%
    }
%>

</body>
</html>
