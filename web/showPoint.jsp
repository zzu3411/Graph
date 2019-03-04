<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>郑州大学--展示页面</title>

    <link href="css/jquery-accordion-menu.css" rel="stylesheet" type="text/css" />
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/collect.css" rel="stylesheet"/>

    <style type="text/css">
        *{box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;}
        body{background:#f0f0f0;}
        .content{width:15%;}
        .filterinput{
            background-color:rgba(249, 244, 244, 0);
            border-radius:15px;
            width:90%;
            height:30px;
            border:thin solid #FFF;
            text-indent:0.5em;
            font-weight:bold;
            color:#FFF;
        }
        #demo-list a{
            overflow:hidden;
            text-overflow:ellipsis;
            -o-text-overflow:ellipsis;
            white-space:nowrap;
            width:100%;
        }
    </style>

    <script src="JS/jquery-1.12.2.min.js"></script>
    <script src="JS/jquery-accordion-menu.js" type="text/javascript"></script>
    <script src="JS/echarts.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            jQuery("#jquery-accordion-menu").jqueryAccordionMenu();

        });

        $(function(){
            //顶部导航切换
            $("#demo-list li").click(function(){
                $("#demo-list li.active").removeClass("active")
                $(this).addClass("active");
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <img src="img/zzu_logo.png" class="logo">
            <a class="navbar-brand" href="#"> 课程知识图谱展示</a>
        </div>
        <div class="collapse navbar-collapse pull-right" id="example-navbar-collapse">
            <ul class="nav navbar-nav pull-right">
                <li id="SaveButton" onclick=""><a>保存</a></li>
                <%--<li onclick = "location.href='${pageContext.request.contextPath}/jsp/order_list.jsp'"><a>修改个人信息</a></li>--%>
                <li onclick = "location.href='login.jsp'"><a>退出</a></li>
                <li ><a>当前用户：ttt</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="content">

    <div id="jquery-accordion-menu" class="jquery-accordion-menu red">
        <div class="jquery-accordion-menu-header" id="form"></div>
        <ul id="demo-list">
            <%--<li class="active"><a href="#"><i class="fa fa-home"></i>Home </a></li>--%>
            <li><a href="#"><i class="fa fa-glass"></i>C语言程序设计 </a></li>
            <li><a href="#"><i class="fa fa-glass"></i>计算机专业导论 </a></li>
           <%-- <li><a href="#"><i class="fa fa-file-image-o"></i>计算机专业导论 </a><span class="jquery-accordion-menu-label">
				12 </span></li>--%>
            <li><a href="#"><i class="fa fa-cog"></i>数据结构 </a>
                <ul class="submenu">
                    <li><a href="#">软件1班 </a></li>
                    <li><a href="#">软件2班 </a></li>
                    <li><a href="#">软件3班 </a>
                        <ul class="submenu">
                            <li><a href="#">张一 </a></li>
                            <li><a href="#">王鹏 </a></li>
                            <li><a href="#">王梦丽 </a></li>
                            <li><a href="#">杨婉 </a></li>
                            <li><a href="#">李想 </a></li>
                            <li><a href="#">刘梦婉 </a></li>
                        </ul>
                    </li>
                    <%--<li><a href="#">Consulting </a></li>--%>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-home"></i>C#程序设计 </a></li>
            <li><a href="#"><i class="fa fa-suitcase"></i>计算机组成原理 </a>
                <%--<ul class="submenu">
                    <li><a href="#">Web Design </a></li>
                    <li><a href="#">Graphics </a><span class="jquery-accordion-menu-label">10 </span>
                    </li>
                    <li><a href="#">Photoshop </a></li>
                    <li><a href="#">Programming </a></li>
                </ul>--%>
            </li>
            <li><a href="#"><i class="fa fa-user"></i>软件工程 </a></li>
            <li><a href="#"><i class="fa fa-envelope"></i>操作系统 </a></li>

        </ul>
        <%--<div class="jquery-accordion-menu-footer">
            Footer
        </div>--%>
    </div>
</div>
<div id="chart1" style="width: 85%;height: 900px;top: 15%;left: 15%;"></div>

<script type="text/javascript">
    // 基于准备好的容器(这里的容器是id为chart1的div)，初始化echarts实例
    var chart1 = echarts.init(document.getElementById("chart1"));

    var	option = {
        backgroundColor: '#ccc',	// 背景颜色
        title: {                    // 图表标题
            text: "杨婉",
            subtext: '学习时长：2.45 h\n登录次数：5 \n提交次数：3',
            /*subtext: '登录次数：5 ',
            subtext: '提交次数：3',*/
            left : '3%',                    // 标题距离左侧边距
            top : '3%',                     // 标题距顶部边距
            textStyle : {                       // 标题样式
                color : '#000',                     // 标题字体颜色
                fontSize : '30',                    // 标题字体大小
            },
            subtextStyle: {
                color : '#000',                     // 标题字体颜色
                fontSize : '15',
            }
        },
        tooltip: {                  // 提示框的配置
            formatter: function(param) {
                if (param.dataType === 'edge') {
                    //return param.data.category + ': ' + param.data.target;
                    return param.data.target;
                }
                //return param.data.category + ': ' + param.data.name;
                return param.data.concept;
            }
        },

        series: [{
            type: "graph",          // 系列类型:关系图
            //top: '10%',             // 图表距离容器顶部的距离
            //roam: true,             // 是否开启鼠标缩放和平移漫游。默认不开启。如果只想要开启缩放或者平移，可以设置成 'scale' 或者 'move'。设置成 true 为都开启
            focusNodeAdjacency: true,   // 是否在鼠标移到节点上的时候突出显示节点以及节点的边和邻接节点。[ default: false ]
            force: {                // 力引导布局相关的配置项，力引导布局是模拟弹簧电荷模型在每两个节点之间添加一个斥力，每条边的两个节点之间添加一个引力，每次迭代节点会在各个斥力和引力的作用下移动位置，多次迭代后节点会静止在一个受力平衡的位置，达到整个模型的能量最小化。
                // 力引导布局的结果有良好的对称性和局部聚合性，也比较美观。
                repulsion: 1000,            // [ default: 50 ]节点之间的斥力因子(关系对象之间的距离)。支持设置成数组表达斥力的范围，此时不同大小的值会线性映射到不同的斥力。值越大则斥力越大
                edgeLength: [150, 100]      // [ default: 30 ]边的两个节点之间的距离(关系对象连接线两端对象的距离,会根据关系对象值得大小来判断距离的大小)，
                                            // 这个距离也会受 repulsion。支持设置成数组表达边长的范围，此时不同大小的值会线性映射到不同的长度。值越小则长度越长。如下示例:
                                            // 值最大的边长度会趋向于 10，值最小的边长度会趋向于 50      edgeLength: [10, 50]
            },
            layout: "force",            // 图的布局。[ default: 'none' ]
                                        // 'none' 不采用任何布局，使用节点中提供的 x， y 作为节点的位置。
                                        // 'circular' 采用环形布局;'force' 采用力引导布局.
            // 标记的图形
            //symbol: "path://M19.300,3.300 L253.300,3.300 C262.136,3.300 269.300,10.463 269.300,19.300 L269.300,21.300 C269.300,30.137 262.136,37.300 253.300,37.300 L19.300,37.300 C10.463,37.300 3.300,30.137 3.300,21.300 L3.300,19.300 C3.300,10.463 10.463,3.300 19.300,3.300 Z",
            symbol: 'circle',
            lineStyle: {            // 关系边的公用线条样式。其中 lineStyle.color 支持设置为'source'或者'target'特殊值，此时边会自动取源节点或目标节点的颜色作为自己的颜色。
                normal: {
                    color: '#000',          // 线的颜色[ default: '#aaa' ]
                    width: 1,               // 线宽[ default: 1 ]
                    type: 'solid',          // 线的类型[ default: solid ]   'dashed'    'dotted'
                    opacity: 0.5,           // 图形透明度。支持从 0 到 1 的数字，为 0 时不绘制该图形。[ default: 0.5 ]
                    curveness: 0            // 边的曲度，支持从 0 到 1 的值，值越大曲度越大。[ default: 0 ]
                }
            },
            label: {                // 关系对象上的标签
                normal: {
                    show: true,                 // 是否显示标签
                    position: "inside",         // 标签位置:'top''left''right''bottom''inside''insideLeft''insideRight''insideTop''insideBottom''insideTopLeft''insideBottomLeft''insideTopRight''insideBottomRight'
                    textStyle: {                // 文本样式
                        fontSize: 16,
                        color: "#212121"
                    },
                }
            },
            edgeLabel: {                // 连接两个关系对象的线上的标签
                normal: {
                    show: true,
                    textStyle: {
                        fontSize: 14
                    },
                    formatter: function(param) {        // 标签内容
                        return param.data.relate;
                    }
                }
            },
            data: [{ "name":"数据结构",
                "concept":"相互之间存在一种或多种特定关系的数据元素的集合",
                "weight":"1",
                symbolSize: [80, 80],
                itemStyle: {
                    color: '#ff8080'
                },
            }, {
                "name":"排序",
                "concept":"将线性表中的元素按关键字从小到大（或从大到小）的顺序重新排列的过程",
                "weight":"0.8",
                symbolSize: [80, 80],
                itemStyle: {
                    color: '#80ff80'
                },
            }, {
                "name":"数据",
                "concept":"数据的基本单位（或从大到小）的顺序重新排列的过程",
                "weight":"0.9",
                symbolSize: [80, 80],
                itemStyle: {
                    color: '#80ff80'
                },
            }, {
                "name":"图",
                "concept":"由顶点集合(Vertex)及顶点间的关系集合组成的一种数据结构",
                "weight":"0.8",
                symbolSize: [80, 80],
                itemStyle: {
                    color: '#80ff80'
                },
            }, {
                "name":"串",
                "concept":"由零个或多个宇符组成的有限序列",
                "weight":"0.3",
                symbolSize: [80, 80],
                itemStyle: {
                    color: '#80ff80'
                },
            }, {
                "name":"外部排序",
                "concept":"排序期间文件的全部记录不能同时存放在计算机的内存里，要借助计算机的外存才能完成排序",
                "weight":"0.5",
                symbolSize: [80, 80],
                itemStyle: {
                    color: '#80ffff'
                },
            }, {
                "name":"内部排序",
                "concept":"对内存中的记录进行排序",
                "weight":"0.9",
                symbolSize: [80, 80],
                itemStyle: {
                    color: '#80ffff'
                },
            }
            ],

            links: [{
                target: "外部排序",
                source: "排序",
                relate: "0.4"
            },{
                target: "内部排序",
                source: "排序",
                relate: "0.8"
            },{
                target: "排序",
                source: "数据结构",
                relate: "0.8"
            },{
                target: "图",
                source: "数据结构",
                relate: "0.8"
            },{
                target: "串",
                source: "数据结构",
                relate: "0.1"
            },{
                target: "数据",
                source: "数据结构",
                relate: "0.9"
            },
            ]
        }],

        animationEasingUpdate: "quinticInOut",          // 数据更新动画的缓动效果。[ default: cubicOut ]    "quinticInOut"
        animationDurationUpdate: 100                    // 数据更新动画的时长。[ default: 300 ]
    };
    // 使用刚指定的配置项和数据显示图表
    chart1.setOption(option)
</script>

<script type="text/javascript">
    (function($) {
        $.expr[":"].Contains = function(a, i, m) {
            return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
        };
        function filterList(header, list) {
            //@header 头部元素
            //@list 无需列表
            //创建一个搜素表单
            var form = $("<form>").attr({
                "class":"filterform",
                action:"#"
            }), input = $("<input>").attr({
                "class":"filterinput",
                type:"text"
            });
            $(form).append(input).appendTo(header);
            $(input).change(function() {
                var filter = $(this).val();
                if (filter) {
                    $matches = $(list).find("a:Contains(" + filter + ")").parent();
                    $("li", list).not($matches).slideUp();
                    $matches.slideDown();
                } else {
                    $(list).find("li").slideDown();
                }
                return false;
            }).keyup(function() {
                $(this).change();
            });
        }
        $(function() {
            filterList($("#form"), $("#demo-list"));
        });
    })(jQuery);
</script>

</body>
</html>
