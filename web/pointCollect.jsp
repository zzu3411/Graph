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
                        <%--<li onclick = "location.href='${pageContext.request.contextPath}/jsp/order_list.jsp'"><a>修改个人信息</a></li>--%>
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
        <%--<div>
                <button class="btn btn-info" id="SaveButton" onclick="save()">保存</button>
            </div>--%>
            <textarea id="graph" name="graph" style="width:100%; display: none">
                ${memo}
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
                {desiredSize: new go.Size(100,100)},
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
                    toShortLength: 3
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
                console.log(data)
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


    $(".nav-tabs li:first").addClass("active");
    $(".nav-tabs li:first a").click();
    $('.nav-tabs li a').click(function () {
        $('.nav li').removeClass("active");
        $(this).parent().addClass("active");
    })
</script>

</html>
