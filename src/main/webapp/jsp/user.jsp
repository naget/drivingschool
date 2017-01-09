<%@ page import="bean.model.Student" %>
<%@ page import="bean.model.StudentGrade" %><%--
  Created by IntelliJ IDEA.
  User: t
  Date: 2016/12/30
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>我是user</title>
    <%--<link href="/css/style.css" rel="stylesheet" type="text/css" >--%>
    <style type="text/css">
        #head{
            margin: auto;
            height:200px;
            background-color: cornflowerblue;
        }
        #gradetable{
            border: #68ff86 ;
            border-bottom-width: thin;
            background-color: antiquewhite;
            align-items:center;
        }
        #grade,#info{
            display: none;
            font-family: "微软雅黑 Light";
        }
    </style>

    <script>
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

            }
        }
        createXMLHTTP();

        var personalInfo=function (name) {
//            var url="/getPersonalInfo?name="+name;
//            xmlHttp.open("Post",url,true);
//            xmlHttp.onreadystatechange=ModifyScore;
//            xmlHttp.send(null);
        };
        var personalGrade=function (name) {
//            var url="/getPersonalGrade?name="+name;
//            xmlHttp.open("Post",url,true);
//            xmlHttp.onreadystatechange=ModifyScore;
//            xmlHttp.send(null);
        };
        var changeInfo=function (element,sno) {
            var oldcontent=element.innerHTML;
            var newcontent = document.createElement("input");
            newcontent.type="text";

            newcontent.value=oldcontent;
            element.innerHTML='';
            element.appendChild(newcontent);
            newcontent.focus();
            newcontent.onblur=function () {
                if (this.value&&this.value!=oldcontent)
                {

                    var index=element.id;
                    window.console.log("index="+index+"newcontent="+newcontent.value+"sno="+sno)
                    var url="/personalChange?index="+index+"&newcontent="+newcontent.value+"&sno="+sno;
                    xmlHttp.open("Post",url,true);
                    xmlHttp.onreadystatechange=ModifyScore;
                    xmlHttp.send(null);

                }
                element.innerHTML=this.value?this.value:oldcontent;
            }

        }
        var showInfo=function () {
            var grade=document.getElementById("grade");
            var info=document.getElementById("info");
            grade.style.display="none";
            info.style.display="block"
        };
        var showGrade=function () {
            var grade=document.getElementById("grade");
            var info=document.getElementById("info");
            grade.style.display="block";
            info.style.display="none"
        };
    </script>

</head>
<body>
<div id="head">
    <h3 align="center">您好 ${param.name}</h3>
</div>
<div id="main">
    <table align="center">
        <tr>
            <td><button onclick="showInfo()">个人信息</button></td>
            <td><button onclick="showGrade()">成绩</button></td>
        </tr>
    </table>
    <div id="info">
    <table border="1" align="center" width="250" >
        <tr>
            <td>姓名</td>
            <td id="sname" ondblclick="changeInfo(this,${studentInfo.sno})">${studentInfo.sname}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td id="age" ondblclick="changeInfo(this,${studentInfo.sno})">${studentInfo.age}</td>
        </tr>
        <tr>
            <td>学号</td>
            <td id="sno" ondblclick="changeInfo(this,${studentInfo.sno})">${studentInfo.sno}</td>
        </tr>
        <tr>
            <td>车型</td>
            <td id="car_type" ondblclick="changeInfo(this,${studentInfo.sno})">${studentInfo.carType}</td>
        </tr>
        <tr>
            <td>省份证号</td>
            <td name="identify" ondblclick="changeInfo(this,${studentInfo.sno})">${studentInfo.identify}</td>
        </tr>
    </table>

    </div>
    <div id="grade" >

        <table id="gradetable" align="center" width="500">
            <tr>
                <td>科目一</td>
                <td>科目二</td>
                <td>科目三</td>
                <td>科目四</td>
            </tr>
            <tr>
                <td id="1" >${studentGrade.classone}</td>
                <td id="2" >${studentGrade.classtwo}</td>
                <td id="3" >${studentGrade.classthree}</td>
                <td id="4" >${studentGrade.classfore}</td>
            </tr>
        </table>

    </div>
</div>
</body>
</html>
