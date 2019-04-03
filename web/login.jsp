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
    <title>课程知识图谱构建系统登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <meta name="keywords"
          content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates"/>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>

</head>
<body>
<script>$(document).ready(function (c) {
    $('.close').on('click', function (c) {
        $('.login-form').fadeOut('slow', function (c) {
            $('.login-form').remove();
        });
    });
});
</script>
<!--SIGN UP-->
<h1>课程知识图谱构建系统</h1>
<div class="login-form">
    <%--<div class="close"></div>--%>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"></div>
    <div class="avtar">
        <img src="assets/img/cat.png" style="width: 75px;height: 75px"/>
    </div>
    <form action="${pageContext.request.contextPath}/LoginServlet?method=userLogin" method="post">
        <input type="text" class="text" placeholder="账号" name="loginId" onfocus="this.value = '';"
               onblur="if (this.value == '') {this.value = '';}">
        <div class="key">
            <input type="password" placeholder="密码" name="passWord" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = '';}">
        </div>
        <div class="status">
            <input type="radio" name="loginStyle" checked="checked" value="student" style="font-size: 18px"><label>学生登录</label>
            <input type="radio" name="loginStyle" value="teacher"><label>教师登录</label>
        </div>
        <div class="signin">
            <input type="submit" value="登录" name="submit">
        </div>
    </form>
</div>
<div class="copy-rights">
    <p style="font-size: 25px">Copyright &copy; 郑州大学 2019 all rights reserved</p>
</div>

</body>
</html>


<%--
<html>
<head>
    <title>登录</title>
</head>
<style>
    #Layer1{
        background-image: url("Images/uuu.jpg") ;
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


&lt;%&ndash;<div style="height: 150px">&ndash;%&gt;

<div style="height: 150px"></div>

    <div align="center"  margin-top:50px >
        <form  class="form-horizontal" action="${pageContext.request.contextPath}/LoginServlet?method=userLogin" method="post">
            <h2>郑州大学</h2>
            <h2>课程知识图谱录入系统</h2>
            ${msg}<br/>
            <input type="text" name="loginId"  placeholder="账号"> <br/>
            <input type="password" name = "passWord" placeholder="密码">  <br/>
            &lt;%&ndash;<input type="checkbox" name="autoLogin" value="1">自动登录  <br/>&ndash;%&gt;
&lt;%&ndash;            <input type="checkbox" name="autoLogin" value="1">
            <input type="checkbox" name="autoLogin" value="1">  &ndash;%&gt;

            <input type="radio" name="loginStyle" checked="checked" value="student">学生登录
            <input type="radio" name="loginStyle" value="teacher">教师登录
            <br/><br/>
            <input type="submit" width="100" value="登录" name="submit" border = "0">
        </form>
    </div>
    </div>

</body>
</html>--%>
