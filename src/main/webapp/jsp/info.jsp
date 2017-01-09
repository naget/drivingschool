<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: t
  Date: 2016/12/27
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"%>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<table>
    <tr>
        <td>用户名</td>
        <td>密码</td>
    </tr>
    <%
//        String name=request.getAttribute("name").toString();

//        String name= (String) request.getAttribute("name");
    %>
    <tr>
        <td><%=request.getAttribute("name").toString()%></td>

    </tr>

</table>
</body>
</html>
