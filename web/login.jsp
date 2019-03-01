<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/18
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<style>
    #Layer1{
        background-image: url("img/uuu.jpg") ;
        width: 100%;
        height: 100%;
        position: relative;
        background-position: 50% 50%;
        background-size: cover;
        background-repeat: no-repeat;
        margin-left: auto;
        margin-right: auto;
    }
</style>

<body >

    <div id="Layer1" style="position: absolute; left:0px; top:0px; width:100%; height:100%">


<%--<div style="height: 150px">--%>

<div style="height: 150px"></div>

    <div align="center"  margin-top:50px >
        <form  class="form-horizontal" action="${pageContext.request.contextPath}/LoginServlet?method=userLogin" method="post">
            <h2>郑州大学</h2>
            <h2>课程知识图谱录入系统</h2>
            ${msg}<br/>
            <input type="text" name="loginId"  placeholder="账号"> <br/>
            <input type="password" name = "passWord" placeholder="密码">  <br/>
            <%--<input type="checkbox" name="autoLogin" value="1">自动登录  <br/>--%>
<%--            <input type="checkbox" name="autoLogin" value="1">
            <input type="checkbox" name="autoLogin" value="1">  --%>

            <input type="radio" name="loginStyle" checked="checked" value="student">学生登录
            <input type="radio" name="loginStyle" value="teacher">教师登录
            <br/><br/>
            <input type="submit" width="100" value="登录" name="submit" border = "0">
        </form>
    </div>
    </div>

</body>
</html>
