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

    <div>

    </div>

    <div align="center"  margin-top:50px>
        <form  class="form-horizontal" action="${pageContext.request.contextPath}/StudentServlet?method=studentLogin" method="post">
            <h2>郑州大学教育知识图谱录入系统</h2>
            ${msg}<br/>
            <input type="text" name="studentId"  placeholder="学号"> <br/>
            <input type="password" name = "passWord" placeholder="密码">  <br/>
            <%--<input type="checkbox" name="autoLogin" value="1">自动登录  <br/>--%>
            <br/>
            <input type="submit" width="100" value="登录" name="submit" border = "0">
        </form>
    </div>
</body>
</html>
