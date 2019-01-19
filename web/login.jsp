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
<body>
欢迎登录

<form class="form-horizontal" action="${pageContext.request.contextPath}/StudentServlet?method=studentLogin" method="post">
    <br/>${msg}<br/>
学号：<input type="text" name="studentId"  placeholder="请输入学号"> <br/>
密码：<input type="password" name = "passWord">  <br/>
    <input type="submit" width="100" value="登录" name="submit" border = "0">


</form>
</body>
</html>
