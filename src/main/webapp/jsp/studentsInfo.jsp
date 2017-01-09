<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.model.StudentGrade" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: t
  Date: 2017/1/4
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="db" class="bean.db.DB" />
<html>
<head>
    <title>各学员成绩信息</title>
    <style>
        #head{
            height: 50px;
            background-color: cornflowerblue;
        }
    </style>
    <%--<script src="${pageContext.request.ContextPath}/js/ajax.js"></script>--%>
    <script>
       var changeInfo=function (element,oldcontent,name,grade,con)
        {
            var xmlHttp;
            function createXMLHTTP() {
                if (window.XMLHttpRequest){
                    xmlHttp = new XMLHttpRequest();
                }
                else if (window.ActiveXObject){
                   try
                   {
                       xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                   }
                   catch (e) {}
                    try{
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }catch(e) {}
                    if (!xmlHttp){
                        window.alert("不能创建XMLHttpRequest对象实例");
                        return false;
                    }
                }
            }
            function ModifyScore() {
                console.log(xmlHttp.readyState+" "+xmlHttp.status+" "+xmlHttp.responseText);
                if (xmlHttp.status ==200)
                {
                        if (xmlHttp.readyState==4){
                            alert("操作成功！");
                            //  if(xmlHttp.responseText=="true");
                        }
                    }
                else {

                    element.innerHTML=oldcontent;
                    alert("操作失败，请重新尝试！");
                }
            }
            createXMLHTTP();
            name=encodeURI(name);
            var url = "/gradeChange?name="+name+"&grade="+grade+"&con="+con+"&Event=gradeChange";
            xmlHttp.open("Post",url,true);
            xmlHttp.onreadystatechange=ModifyScore;
            xmlHttp.send(null);

        }
        var editInfo=function (element,name) {
            var oldcontent=element.innerHTML;
            var newcontent=document.createElement("input");
            newcontent.type='text';
            newcontent.value=oldcontent;
            element.innerHTML='';
            element.appendChild(newcontent);
            newcontent.focus();
            newcontent.onblur=function () {
                if(this.value&&this.value!=oldcontent)
                {
                    var con=element.id.valueOf();
                    window.console.log("con的值为"+con);
                    var grade=this.value;
                    changeInfo(element,oldcontent,name,grade,con)
                }
                element.innerHTML=(this.value?this.value:oldcontent);
            }
        }

    </script>
</head>
<body>
<div id="head">
    <h3>各学员成绩信息</h3>
</div>
<%
    db.connectMySQL();
    String sql="select * from grade_info";
    ResultSet rs=db.query(sql);
    List<StudentGrade> studentGrades=new ArrayList<StudentGrade>();
    List<String> snos=new ArrayList<String>();
    boolean flag;
    while (rs.next())
    {
        flag=true;
        String sno=rs.getString("sno");
        for (String s :
                snos) {
            if (s.equals(sno)) flag=false;

        }
        while (flag){
            StudentGrade studentGrade=new StudentGrade();

            snos.add(sno);
//        String cno = rs.getString("cno");
            String snosql="select sname from student_info where sno= "+sno;
            db.creatStatement();
            ResultSet namers=db.query(snosql);
            while (namers.next()){
                studentGrade.setName(namers.getString("sname"));
            }
            db.closeStatement();

            String cno1sql="select * from grade_info where sno="+sno+" and cno="+"1";
            db.creatStatement();
            ResultSet grade1=db.query(cno1sql);
            while (grade1.next()){
                studentGrade.setClassone(grade1.getString("grade"));
            }
            db.closeStatement();

            String cno2sql="select * from grade_info where sno="+sno+" and cno="+"2";
            db.creatStatement();
            ResultSet grade2=db.query(cno2sql);
            while (grade2.next()){
                studentGrade.setClasstwo(grade2.getString("grade"));
            }
            db.closeStatement();

            String cno3sql="select * from grade_info where sno="+sno+" and cno="+"3";
            db.creatStatement();
            ResultSet grade3=db.query(cno3sql);
            while (grade3.next()){
                studentGrade.setClassthree(grade3.getString("grade"));
            }
            db.closeStatement();

            String cno4sql="select * from grade_info where sno="+sno+" and cno="+"4";
            db.creatStatement();
            ResultSet grade4=db.query(cno4sql);
            while (grade4.next()){
                studentGrade.setClassfore(grade4.getString("grade"));
            }
            db.closeStatement();
            flag=false;
            studentGrades.add(studentGrade);
        }

    }
%>
<div>
    <table border="1" bgcolor="#faebd7">

        <tr>
            <td rowspan="2">姓名</td>
            <td colspan="4" align="center">科目</td>
        </tr>
        <tr>
            <td>科目一</td>
            <td>科目二</td>
            <td>科目三</td>
            <td>科目四</td>
        </tr>
        <%
            for (StudentGrade s :
                    studentGrades) {
                String name = "\'"+s.getName()+"\'";


        %>
        <tr id="info">
            <td id="name"><%=s.getName()%></td>
            <td id="1" ondblclick="editInfo(this,<%=name%>)"><%=s.getClassone()%></td>
            <td id="2" ondblclick="editInfo(this,<%=name%>)"><%=s.getClasstwo()%></td>
            <td id="3" ondblclick="editInfo(this,<%=name%>)"><%=s.getClassthree()%></td>
            <td id="4" ondblclick="editInfo(this,<%=name%>)"><%=s.getClassfore()%></td>
        </tr>
        <%
            }
            db.closeDB();
        %>
    </table>
</div>
</body>
</html>
