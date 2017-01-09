<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="bean.model.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: t
  Date: 2016/12/30
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="student" class="bean.model.Student"/>--%>
<jsp:useBean id="mydb" class="bean.db.DB"/>
<html>
<head>
    <title>admin</title>
</head>
<body>
<%
    List<Student> students=new ArrayList<Student>();
    mydb.connectMySQL();
    String sql = "select * from student_info";
    ResultSet set = mydb.query(sql);
//    ResultSetMetaData md=set.getMetaData();
//    int columnCount = md.getColumnCount();
    while (set.next())
    {
        Student student=new Student();
        student.setAge(Integer.valueOf(set.getString("age")));
        student.setCarType(set.getString("car_type"));
        student.setEnrollTime(Date.valueOf(set.getString("enroll_time")));
        student.setIdentify(set.getString("identify"));
        student.setLeaveTime(Date.valueOf(set.getString("leave_time")));
        student.setScondition(set.getString("scondition"));
        student.setSex(set.getString("sex"));
        student.setSname(set.getString("sname"));
        student.setSno(Integer.valueOf(set.getString("sno")));
        student.setTel(set.getString("tel"));
        student.setText(set.getString("s_text"));
        students.add(student);
    }
    mydb.closeDB();



%>
<h3>我是admin</h3>
<table>
    <tr>
        <td>学员姓名</td>
        <td>学员性别</td>
        <td>身份证号</td>
        <td>电话号码</td>
        <td>年龄</td>
        <td>入学时间</td>
        <td>毕业时间</td>
        <td>现状</td>
        <td>车型</td>
        <td>备注</td>

    </tr>
    <%
        for (Student s:students
                ) {
    %>
    <tr>
        <td><%=s.getSname()%></td>
        <td><%=s.getSex()%></td>
        <td><%=s.getIdentify()%></td>
        <td><%=s.getTel()%></td>
        <td><%=s.getAge()%></td>
        <td><%=s.getEnrollTime()%></td>
        <td><%=s.getLeaveTime()%></td>
        <td><%=s.getScondition()%></td>
        <td><%=s.getCarType()%></td>
        <td><%=s.getText()%></td>

    </tr>
    <%
        }
    %>
</table>
<div>
   <a href="/studentsInfo">学员成绩信息</a>
</div>
</body>
</html>
