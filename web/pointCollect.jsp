<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>采集页面</title>
</head>
<body>

    <c:if test="${empty loginStudent}">
        <li><a href="${pageContext.request.contextPath}/StudentServlet?method=login">登录</a></li>
    </c:if>
    
    <c:if test="${not empty loginStudent}">
        欢迎! ${loginStudent.name}
        <li><a href="${pageContext.request.contextPath}/jsp/order_list.jsp">修改个人信息</a></li>
        <li><a href="${pageContext.request.contextPath}/StudentServlet?method=logout">退出</a></li>
    </c:if>


    <form class="form-horizontal" action="${pageContext.request.contextPath}/StudentServlet?method=studentLogin" method="post">

        知识点名称 ：<input type="text" name="knowledgePointName" id="knowledgePointName"> <br/>
        理解 ：<input type="text" name="knowledgePointConcept" id="knowledgePointConcept"> <br/>
        权重 ：<input type="text" name="knowledgePointLinkWeight" id="knowledgePointLinkWeight"> <br/>

        <li><a href="${pageContext.request.contextPath}/CurriculumServlet?method=findAllCurriculum">查询课程 服务端输出信息</a></li>
        <br/>

        <li><a href="${pageContext.request.contextPath}/CollectServlet?method=collectData">服务端查看用户session</a></li> <br/>

        <input type="checkbox" name="" id="" >


</form>





</body>


<script src="js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
    $(function() {
        var url="${pageContext.request.contextPath}/CategoryServlet";
        var obj= {"method":"findAllCategory"};
        $.post(url,obj,function (data){
            $.each(data,function(i,objs) {
                var li="<li><a href='#'>" +objs.cname+" </a></li>";
                $("#menu").append(li);

                // alert(li);
            });
        },"json");
    });
</script>

</html>
