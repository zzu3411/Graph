<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>课程知识图谱构建系统</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <script src="assets/js/go.js"></script>
    <script src="assets/js/DataInspector.js"></script>
    <link rel="stylesheet" href="assets/css/xcConfirm.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/css/ready.css">
    <link rel="stylesheet" href="assets/css/demo.css">
    <link rel="stylesheet" href="css/DataInspector.css">
</head>
<body onload="init()">
<div class="wrapper">
    <c:if test="${empty loginStudent}">
        <li><a href="${pageContext.request.contextPath}/StudentServlet?method=login">登录</a></li>
    </c:if>

    <c:if test="${not empty loginStudent}">
        <div class="main-header">
            <div class="logo-header" style="width: auto">
                <img src="assets/img/zzu_logo.png" class="zzu-logo">
                <a class="logo">
                    课程知识图谱构建系统
                </a>
                <button class="navbar-toggler sidenav-toggler ml-auto" type="button" data-toggle="collapse"
                        data-target="collapse" aria-controls="sidebar" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <button class="topbar-toggler more"><i class="la la-ellipsis-v"></i></button>
            </div>
            <nav class="navbar navbar-header navbar-expand-lg">
                <div class="container-fluid">
                    <ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
                        <li class="nav-item dropdown hidden-caret">
                            <a style="font-size:20px" class="btn btn-rounded btn-danger btn-sm" href="#" role="button"
                               aria-haspopup="true"
                               aria-expanded="false" onclick="save()">
                                保存
                            </a>
                            <!--<a href="profile.html" class="btn btn-rounded btn-danger btn-sm">保存</a>-->
                        </li>
                        <li class="nav-item dropdown">
                            <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"
                               aria-expanded="false"> <img src="assets/img/cat.png" alt="user-img" width="36"
                                                           class="img-circle"><span
                                    style="font-size:20px">${loginStudent.name}</span></span>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <div class="user-box">
                                        <div class="u-img"><img src="assets/img/cat.png" alt="user"></div>
                                        <div class="u-text">
                                            <h4 style="font-size:20px">${loginStudent.name}</h4>
                                                <%--<p class="text-muted">hello@themekita.com</p>--%></div>
                                    </div>
                                </li>
                                <div class="dropdown-divider"></div>
                                <a onclick="location.href='login.jsp'" class="dropdown-item" href="#"><i
                                        class="fa fa-power-off"></i> 退出系统</a>
                            </ul>
                            <!-- /.dropdown-user -->
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </c:if>
    <div class="sidebar">
        <div class="scrollbar-inner sidebar-wrapper">
            <ul class="nav">
                <%--<li class="nav-item active">
                    <a href="index.html">
                        <i class="la la-dashboard"></i>
                        <p>Dashboard</p>
                        <span class="badge badge-count">5</span>
                    </a>
                </li>--%>
                <c:forEach items="${StuCur}" var="StuCur" varStatus="id">
                    <li class="nav-item">
                        <a class="chooseCur" onclick="showGraph(${StuCur.ID})">
                            <i class="la la-dashboard"></i>
                            <p style="font-size:20px">${StuCur.curriculumName}</p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="main-panel" style="min-height: 95%">
        <div class="content">
            <div class="container-fluid">
                <h4 class="page-title">采集板</h4>
            </div>
            <div class="row row-card-no-pd">
                <div id="myDiagramDiv" style="height: 800px" class="col-md-11"></div>
                <div id="myInspectorDiv"></div>
                <textarea id="graph" name="graph" style="width:100%; display: none">
                {}
            </textarea>

                <input id="curId" name="curId" style="display: none"/>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="container-fluid">
            <div class="copyright m-auto">
                <p style="font-size:20px">Copyright &copy; 郑州大学 2019 all rights reserved</p>
            </div>
        </div>
        <%--<div class="copy-rights">
            <p>Copyright &copy; 郑州大学 2019 all rights reserved</p>
        </div>--%>
    </footer>
</div>
</div>
</div>
<!-- Modal -->
<div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog" aria-labelledby="modalUpdatePro"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <h6 class="modal-title"><i class="la la-frown-o"></i> Under Development</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-center">
                <p>Currently the pro version of the <b>Ready Dashboard</b> Bootstrap is in progress development</p>
                <p>
                    <b>We'll let you know when it's done</b></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>

<script src="assets/js/collect.js"></script>
<script src="assets/js/core/jquery.3.2.1.min.js"></script>
<script src="assets/js/xcConfirm.js"></script>
<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="assets/js/core/popper.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
<script src="assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script src="assets/js/plugin/jquery-mapael/jquery.mapael.min.js"></script>
<script src="assets/js/plugin/jquery-mapael/maps/world_countries.min.js"></script>
<script src="assets/js/plugin/chart-circle/circles.min.js"></script>
<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script src="assets/js/ready.min.js"></script>
<script type="text/javascript">
    function init() {
        var $ = go.GraphObject.make;  // for conciseness in defining templates
        myDiagram =
            $(go.Diagram, "myDiagramDiv",  // must name or refer to the DIV HTML element
                {
                    // have mouse wheel events zoom in and out instead of scroll up and down
                    "toolManager.mouseWheelBehavior": go.ToolManager.WheelZoom,
                    // support double-click in background creating a new node
                    "clickCreatingTool.archetypeNodeData": {
                        name: "知识点",
                        concept: "(概述)",
                        weight: "1",
                        color: "#ffbc00",
                    },
                    // enable undo & redo
                    "undoManager.isEnabled": true,

                });
        // when the document is modified, add a "*" to the title and enable the "Save" button
        myDiagram.addDiagramListener("Modified", function (e) {
            var button = document.getElementById("SaveButton");
            if (button) button.disabled = !myDiagram.isModified;
            var idx = document.title.indexOf("*");
            if (myDiagram.isModified) {
                if (idx < 0) document.title += "*";
            } else {
                if (idx >= 0) document.title = document.title.substr(0, idx);
            }
        });
        // define the Node template
        myDiagram.nodeTemplate =
            $(go.Node, "Auto",
                {
                    desiredSize: new go.Size(100, 100),
                    toolTip: $("ToolTip", $(go.TextBlock, "权重的取值范围:"+"[0,1]")),
                },
                new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
                $(go.Shape, "Circle",
                    {
                        parameter1: 20,  // the corner has a large radius
                        fill: "#ffbc00",
                        stroke: null,
                        //fill: "whitesmoke",
                        //stroke: "black",
                        portId: "",  // this Shape is the Node's port, not the whole Node
                        fromLinkable: true, fromLinkableSelfNode: true, fromLinkableDuplicates: true,
                        toLinkable: true, toLinkableSelfNode: true, toLinkableDuplicates: true,
                        cursor: "pointer",

                    },
                    new go.Binding("fill", "color")
                ),

                $(go.TextBlock, textStyle(),  // the name
                    {
                        editable: true,
                    },
                    new go.Binding("text", "name").makeTwoWay()),

                $(go.TextBlock,   // the weight
                    {
                        editable: true,
                        alignment: go.Spot.Bottom,
                        toolTip: $("ToolTip", $(go.TextBlock, "取值范围:"+"[0,1]")),
                    },
                    new go.Binding("text", "weight").makeTwoWay()),


                $("TreeExpanderButton",
                    {
                        alignment: go.Spot.BottomRight,
                        visible: true,
                    },
                )
            ),
            // unlike the normal selection Adornment, this one includes a Button
            myDiagram.nodeTemplate.selectionAdornmentTemplate =
                $(go.Adornment, "Spot",
                    $(go.Panel, "Auto",
                        $(go.Shape, {
                            fill: null,
                            stroke: "lightblue",
                            strokeWidth: 2,
                            strokeDashArray: [6, 6, 2, 2]
                        }),
                        $(go.Placeholder),  // a Placeholder sizes itself to the selected Node
                    ),
                ); // end Adornment
        // clicking the button inserts a new node to the right of the selected node,
        // and adds a link to that new node
        function mouseEnter(e, obj) {
            var name_panel = obj.findObject("name_panel");
            var concept_panel = obj.findObject("concept_panel");
            var weight_panel = obj.findObject("weight_panel");
            name_panel.visible = true;
            concept_panel.visible = true;
            weight_panel.visible = true;
            last = obj;

        }

        function mouseLeave(e, obj) {
            var name_panel = obj.findObject("name_panel");
            var concept_panel = obj.findObject("concept_panel");
            var weight_panel = obj.findObject("weight_panel");
            name_panel.visible = false;
            concept_panel.visible = false;
            weight_panel.visible = false;

        }

        // Called when the mouse is over the diagram's background
        function doMouseOver(e) {

        }


        function addNodeAndLink(e, obj) {
            var adornment = obj.part;
            var diagram = e.diagram;
            diagram.startTransaction("Add State");
            // get the node data for which the user clicked the button
            var fromNode = adornment.adornedPart;
            var fromData = fromNode.data;
            // create a new "State" data object, positioned off to the right of the adorned Node
            var toData = {text: "new"};
            var p = fromNode.location.copy();
            p.x += 200;
            toData.loc = go.Point.stringify(p);  // the "loc" property is a string, not a Point object
            // add the new node data to the model
            var model = diagram.model;
            model.mouseLeave(toData);
            // create a link data from the old node data to the new node data
            var linkdata = {
                from: model.getKeyForNodeData(fromData),  // or just: fromData.id
                to: model.getKeyForNodeData(toData),
                relate: "0"
            };
            // and add the link data to the model
            model.addLinkData(linkdata);
            // select the new Node
            var newnode = diagram.findNodeForData(toData);
            diagram.select(newnode);
            diagram.commitTransaction("Add State");
            // if the new node is off-screen, scroll the diagram to show the new node
            diagram.scrollToRect(newnode.actualBounds);
        }

        function textStyle() {
            return {font: "12pt utf-8", stroke: "black",};
        }

        // replace the default Link template in the linkTemplateMap
        myDiagram.linkTemplate =
            $(go.Link,  // the whole link panel
                {
                    adjusting: go.Link.Stretch,
                    reshapable: true, relinkableFrom: true, relinkableTo: true,
                    toShortLength: 3,
                    toolTip: $("ToolTip", $(go.TextBlock, "取值范围:"+"[0,1]")),
                },
                new go.Binding("points").makeTwoWay(),
                new go.Binding("curviness"),
                $(go.Shape,  // the link shape
                    {strokeWidth: 1.5}),
                $(go.Shape,  // the arrowhead
                    {toArrow: "standard", stroke: null}),
                $(go.Panel, "Auto",
                    $(go.Shape,  // the label background, which becomes transparent around the edges
                        {
                            fill: $(go.Brush, "Radial",
                                {0: "rgb(255, 255, 255)", 0.3: "rgb(255, 255, 255)", 1: "rgba(255, 255, 255, 0)"}),
                            stroke: null
                        }),
                    $(go.TextBlock, "0",  // the label text
                        {
                            textAlign: "center",
                            font: "15pt",
                            margin: 4,
                            editable: true
                        },
                        new go.Binding("text", "relate").makeTwoWay())
                )
            );
        // read in the JSON data from the "graph" element
        load();
        // support editing the properties of the selected person in HTML
        if (window.Inspector) myInspector = new Inspector("myInspectorDiv", myDiagram,
            {
                properties: {
                    "name": {show: Inspector.showIfNode},
                    "concept": {show: Inspector.showIfNode},
                    "color": {show: Inspector.showIfNode, type: 'color'},
                    "loc": {show: false},
                    "key": {show: false},
                    "comments": {show: false},
                    "from": {show: false},
                    "to": {show: false},
                    "points": {show: false},
                    "text": {show: false},

                }
            });
    }

    // Show the diagram's model in JSON format
    function save() {
        document.getElementById("graph").value = myDiagram.model.toJson();
        let curId = document.getElementById("curId").value;
        let graph = document.getElementById("graph").value;
        //提交数据前 判断
        //节点判断
        if (graph.indexOf("知识点") != -1) {
            var txt = "存在未修改名称的知识点，请修改.";
            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
            //$('.alert').html('存在未修改名称的知识点，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
            return;
        }
        //判断 是否存在自连接、孤立节点、关联值
        keys = [];
        validateNode = true;
        doAjax = true;
        graphJson = $.parseJSON(graph);

        validateLink();
        if (validateNode) {
            soleNode();
        }

        if (doAjax && validateNode) {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/CollectServlet?method=collectData",
                data: {curId: curId, graph: graph},
                success: function (data) {
                    if (data != null) {
                        var txt = "操作成功";
                        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                        //$('.alert').html('操作成功').removeClass("hide").addClass('alert-success').show().delay(2500).fadeOut();
                        myDiagram.model = go.Model.fromJson(data);
                    } else myDiagram.model = go.Model.fromJson({
                        "class": "GraphLinksModel",
                        "copiesKey": false,
                        "nodeDataArray": [],
                        "linkDataArray": []
                    });
                }
            });
        }
    }

    function load() {
        myDiagram.model = go.Model.fromJson(document.getElementById("graph").value);
    }

    function showGraph(curId) {
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/CollectServlet?method=findMemo",
            data: {curId: curId},
            dataType: "json",
            success: function (data) {
                if (data != null && data.nodeDataArray.length) {
                    myDiagram.model = go.Model.fromJson(data);
                } else {
                    myDiagram.model = go.Model.fromJson({
                        "class": "GraphLinksModel",
                        "copiesKey": false,
                        "nodeDataArray": [],
                        "linkDataArray": []
                    });
                    var txt = "暂无该课程的图谱，可在下方空白区域双击鼠标左键，制作图谱.";
                    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
                    //$('.alert').html('暂无该课程的图谱，可在下方空白区域双击鼠标，制作图谱.').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
                }
            }
        });
        document.getElementById("curId").value = curId;
    }

    function validateLink() {
        link = graphJson.linkDataArray;
        for (var i = 0; i < link.length; i++) {
            if (parseInt(link[i].relate) < 0 || parseInt(link[i].relate) > 1) {
                var txt = "‘关联值’的范围为[0,1]，请修改.";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                //$('.alert').html('"关联值"的范围为[0,1]，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
                validateNode = false;
                break;
            }
            if (link[i].from == link[i].to) {
                var txt = "存在未与其他节点相连的知识点，请修改.";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                //$('.alert').html('存在未与其他节点相连的知识点，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
                validateNode = false;
                break;
            }
            keys.push(link[i].from);
            keys.push(link[i].to);
        }
    }

    function soleNode() {
        node = graphJson.nodeDataArray;
        for (var i = 0; i < node.length; i++) {
            if (parseInt(node[i].weight) < 0 || parseInt(node[i].weight) > 1) {
                var txt = "‘权重’的范围为[0,1]，请修改.";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                //$('.alert').html('"权重"的范围为[0,1]，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
                doAjax = false;
                break;
            }
            if (keys.indexOf(node[i].key) == -1) {
                var txt = "图中存在未与其他节点相连的知识点，请修改.";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                //$('.alert').html('图中存在未与其他节点相连的知识点，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
                doAjax = false;
                break;
            }
        }
    }

    /*$(".nav li:first").addClass("active");
    $(".nav li:first a").click();*/
    $('.nav li a').click(function () {
        $('.nav li').removeClass("active");
        $(this).parent().addClass("active");
    })
</script>
</html>


<%--
&lt;%&ndash;
Created by IntelliJ IDEA.
User: Administrator
Date: 2019/1/18
Time: 14:36
To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>郑州大学--采集页面</title>
<script src="JS/go.js"></script>
<script src="JS/jquery-1.12.2.min.js"></script>
<script src="JS/DataInspector.js"></script>
<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/collect.css" rel="stylesheet"/>
<link href="css/DataInspector.css" rel="stylesheet"/>
</head>
<body onload="init()">
<c:if test="${empty loginStudent}">
<li><a href="${pageContext.request.contextPath}/StudentServlet?method=login">登录</a></li>
</c:if>

<c:if test="${not empty loginStudent}">
<nav class="navbar navbar-default" role="navigation">
<div class="container-fluid">
    <div class="navbar-header">
        <img src="img/zzu_logo.png" class="logo">
        <a class="navbar-brand" href="#"> 课程知识图谱数据采集</a>
    </div>
    <div class="collapse navbar-collapse pull-right" id="example-navbar-collapse">
        <ul class="nav navbar-nav pull-right">
            <li id="SaveButton" onclick="save()"><a>保存</a></li>
            &lt;%&ndash;<li onclick = "location.href='${pageContext.request.contextPath}/jsp/order_list.jsp'"><a>修改个人信息</a></li>&ndash;%&gt;
            <li onclick = "location.href='login.jsp'"><a>退出</a></li>
            <li ><a>当前用户：${loginStudent.name}</a></li>
        </ul>
    </div>
</div>
</nav>
</c:if>


<form class="form-horizontal">
<div id="main" style="width: 100%">
<div id="left" class="col-md-1">
<ul class="nav nav-tabs nav-stacked">
    <c:forEach items="${StuCur}" var="StuCur" varStatus="id">
        <li><a class="chooseCur" onclick='showGraph(${StuCur.ID})'>${StuCur.curriculumName}</a></li>
    </c:forEach>
</ul>
</div>

<div class="alert col-md-11 hide text-center"></div>
<div id="right" >

<div id="myDiagramDiv" class="col-md-11 diagram"></div>
<div id="myInspectorDiv"></div>
&lt;%&ndash;<div>
    <button class="btn btn-info" id="SaveButton" onclick="save()">保存</button>
</div>&ndash;%&gt;
<textarea id="graph" name="graph" style="width:100%; display: none">
    {}
</textarea>

<input id="curId" name="curId" style="display: none"/>
</div>
</div>

</form>


</body>
<script type="text/javascript">
function init() {
var $ = go.GraphObject.make;  // for conciseness in defining templates
myDiagram =
$(go.Diagram, "myDiagramDiv",  // must name or refer to the DIV HTML element
    {
        // have mouse wheel events zoom in and out instead of scroll up and down
        "toolManager.mouseWheelBehavior": go.ToolManager.WheelZoom,
        // support double-click in background creating a new node
        "clickCreatingTool.archetypeNodeData": {
            name: "知识点",
            concept: "(概述)",
            weight:"1",
            color: "#ffbc00",
        },
        // enable undo & redo
        "undoManager.isEnabled": true,

    });
// when the document is modified, add a "*" to the title and enable the "Save" button
myDiagram.addDiagramListener("Modified", function (e) {
var button = document.getElementById("SaveButton");
if (button) button.disabled = !myDiagram.isModified;
var idx = document.title.indexOf("*");
if (myDiagram.isModified) {
    if (idx < 0) document.title += "*";
} else {
    if (idx >= 0) document.title = document.title.substr(0, idx);
}
});
// define the Node template
myDiagram.nodeTemplate =
$(go.Node, "Auto",
    {
        desiredSize: new go.Size(100,100),
        toolTip: $("ToolTip", $(go.TextBlock,"权重的取值范围:[0,1]")),
    },
    new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
    $(go.Shape, "Circle",
        {
            parameter1: 20,  // the corner has a large radius
            fill: "#ffbc00",
            stroke: null,
            //fill: "whitesmoke",
            //stroke: "black",
            portId: "",  // this Shape is the Node's port, not the whole Node
            fromLinkable: true, fromLinkableSelfNode: true, fromLinkableDuplicates: true,
            toLinkable: true, toLinkableSelfNode: true, toLinkableDuplicates: true,
            cursor: "pointer",

        },
        new go.Binding("fill", "color")
        ),

    $(go.TextBlock, textStyle(),  // the name
        {
            editable: true,
        },
        new go.Binding("text", "name").makeTwoWay()),

    $(go.TextBlock,   // the weight
        {
            editable: true,
            alignment: go.Spot.Bottom,
            toolTip: $("ToolTip", $(go.TextBlock,"取值范围:[0,1]")),
        },
        new go.Binding("text", "weight").makeTwoWay()),


    $("TreeExpanderButton",
        {
            alignment: go.Spot.BottomRight,
            visible: true,
        },
    )
),
// unlike the normal selection Adornment, this one includes a Button
myDiagram.nodeTemplate.selectionAdornmentTemplate =
    $(go.Adornment, "Spot",
        $(go.Panel, "Auto",
            $(go.Shape, {
                fill: null,
                stroke: "lightblue",
                strokeWidth: 2,
                strokeDashArray: [6, 6, 2, 2]
            }),
            $(go.Placeholder),  // a Placeholder sizes itself to the selected Node
        ),

    ); // end Adornment
// clicking the button inserts a new node to the right of the selected node,
// and adds a link to that new node
function mouseEnter(e, obj) {
var name_panel = obj.findObject("name_panel");
var concept_panel = obj.findObject("concept_panel");
var weight_panel = obj.findObject("weight_panel");
name_panel.visible = true;
concept_panel.visible = true;
weight_panel.visible = true;
last = obj;

}

function mouseLeave(e, obj) {
var name_panel = obj.findObject("name_panel");
var concept_panel = obj.findObject("concept_panel");
var weight_panel = obj.findObject("weight_panel");
name_panel.visible = false;
concept_panel.visible = false;
weight_panel.visible = false;

}

// Called when the mouse is over the diagram's background
function doMouseOver(e) {

}


function addNodeAndLink(e, obj) {
var adornment = obj.part;
var diagram = e.diagram;
diagram.startTransaction("Add State");
// get the node data for which the user clicked the button
var fromNode = adornment.adornedPart;
var fromData = fromNode.data;
// create a new "State" data object, positioned off to the right of the adorned Node
var toData = {text: "new"};
var p = fromNode.location.copy();
p.x += 200;
toData.loc = go.Point.stringify(p);  // the "loc" property is a string, not a Point object
// add the new node data to the model
var model = diagram.model;
model.mouseLeave(toData);
// create a link data from the old node data to the new node data
var linkdata = {
    from: model.getKeyForNodeData(fromData),  // or just: fromData.id
    to: model.getKeyForNodeData(toData),
    relate: "0"
};
// and add the link data to the model
model.addLinkData(linkdata);
// select the new Node
var newnode = diagram.findNodeForData(toData);
diagram.select(newnode);
diagram.commitTransaction("Add State");
// if the new node is off-screen, scroll the diagram to show the new node
diagram.scrollToRect(newnode.actualBounds);
}

function textStyle() {
return { font: "12pt utf-8", stroke: "black", };
}

// replace the default Link template in the linkTemplateMap
myDiagram.linkTemplate =
$(go.Link,  // the whole link panel
    {
        adjusting: go.Link.Stretch,
        reshapable: true, relinkableFrom: true, relinkableTo: true,
        toShortLength: 3,
        toolTip: $("ToolTip", $(go.TextBlock,"取值范围:[0,1]")),
    },
    new go.Binding("points").makeTwoWay(),
    new go.Binding("curviness"),
    $(go.Shape,  // the link shape
        {strokeWidth: 1.5}),
    $(go.Shape,  // the arrowhead
        {toArrow: "standard", stroke: null}),
    $(go.Panel, "Auto",
        $(go.Shape,  // the label background, which becomes transparent around the edges
            {
                fill: $(go.Brush, "Radial",
                    {0: "rgb(255, 255, 255)", 0.3: "rgb(255, 255, 255)", 1: "rgba(255, 255, 255, 0)"}),
                stroke: null
            }),
        $(go.TextBlock, "0",  // the label text
            {
                textAlign: "center",
                font: "15pt",
                margin: 4,
                editable: true
            },
            new go.Binding("text", "relate").makeTwoWay())
    )
);
// read in the JSON data from the "graph" element
load();
// support editing the properties of the selected person in HTML
if (window.Inspector) myInspector = new Inspector("myInspectorDiv", myDiagram,
{
    properties: {
        "name": {show: Inspector.showIfNode},
        "concept": {show: Inspector.showIfNode},
        "color": { show: Inspector.showIfNode,type: 'color' },
        "loc": { show: false },
        "key": { show: false },
        "comments": { show: false },
        "from": { show: false },
        "to": { show: false },
        "points": { show: false },
        "text": { show: false },

    }
});
}

// Show the diagram's model in JSON format
function save() {
document.getElementById("graph").value = myDiagram.model.toJson();
let curId = document.getElementById("curId").value;
let graph = document.getElementById("graph").value;
//提交数据前 判断
//节点判断
if (graph.indexOf("知识点") != -1) {
$('.alert').html('存在未修改名称的知识点，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
return;
}
//判断 是否存在自连接、孤立节点、关联值
keys = [];
validateNode = true;
doAjax = true;
graphJson = $.parseJSON( graph );

validateLink();
if (validateNode) {
soleNode();
}

if (doAjax && validateNode) {
$.ajax({
    type: "POST",
    url: "${pageContext.request.contextPath}/CollectServlet?method=collectData",
    data: { curId:curId ,graph:graph},
    success: function(data) {
        if(data != null){
            $('.alert').html('操作成功').removeClass("hide").addClass('alert-success').show().delay(2500).fadeOut();
            myDiagram.model = go.Model.fromJson(data);
        }else myDiagram.model = go.Model.fromJson({ "class": "GraphLinksModel",
            "copiesKey": false,
            "nodeDataArray": [  ],
            "linkDataArray": [  ]});
    }
});
}
}

function load() {
myDiagram.model = go.Model.fromJson(document.getElementById("graph").value);
}
function showGraph(curId) {
$.ajax({
type: "POST",
url: "${pageContext.request.contextPath}/CollectServlet?method=findMemo",
data: { curId:curId },
dataType:"json",
success: function(data) {
    if(data != null && data.nodeDataArray.length){
        myDiagram.model = go.Model.fromJson(data);
    }else {
        myDiagram.model = go.Model.fromJson({ "class": "GraphLinksModel",
            "copiesKey": false,
            "nodeDataArray": [  ],
            "linkDataArray": [  ]});

        $('.alert').html('暂无该课程的图谱，可在下方空白区域双击鼠标，制作图谱^-^').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
    }
}
});
document.getElementById("curId").value = curId;
}

function validateLink() {
link = graphJson.linkDataArray;
for (var i=0 ; i < link.length ; i++) {
if (parseInt(link[i].relate) < 0 || parseInt(link[i].relate) > 1) {
    $('.alert').html('"关联值"的范围为[0,1]，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
    validateNode = false;
    break;
}
if (link[i].from == link[i].to) {
    $('.alert').html('存在未与其他节点相连的知识点，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
    validateNode = false;
    break;
}
keys.push(link[i].from);
keys.push(link[i].to);
}
}

function soleNode(){
node = graphJson.nodeDataArray;
for (var i=0 ; i < node.length ; i++) {
if (parseInt(node[i].weight) < 0 || parseInt(node[i].weight) > 1) {
    $('.alert').html('"权重"的范围为[0,1]，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
    doAjax = false;
    break;
}
if (keys.indexOf(node[i].key) == -1) {
    $('.alert').html('图中存在未与其他节点相连的知识点，请修改 -。-').removeClass("hide").addClass('alert-danger').show().delay(2500).fadeOut();
    doAjax = false;
    break;
}
}
}

$(".nav-tabs li:first").addClass("active");
$(".nav-tabs li:first a").click();
$('.nav-tabs li a').click(function () {
$('.nav li').removeClass("active");
$(this).parent().addClass("active");
})
</script>

</html>
--%>
