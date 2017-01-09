<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 2016/12/15
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/forward" method="post">
 <table align="center">
     <tr>
         <td>用户名</td>
         <td><input type="text" name="name" /></td>
     </tr>
     <tr>
         <td>密码</td>
         <td><input type="password" name="pwd" /></td>
     </tr>
     <tr>
         <td colspan="2"><input type="submit" value="登录"/></td>
     </tr>
 </table>
</form>
</body>
</html>
