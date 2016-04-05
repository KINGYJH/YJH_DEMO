<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
-->
<html lang="zh_cn">
<head>
[@block name="Meta"]
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="yjh">
    <link rel="shortcut icon" href="[@spring.url '/resources/images/favicon.ico' /]" type="image/x-icon"/>
[/@block]

    <title>YJH_DEMO Admin-[@block name="title"][/@block]</title>

[@block name="topResources"]
    <!-- Bootstrap core CSS -->
    <link href="[@spring.url '/resources/bootstrap/css/bootstrap.min.css'/]" rel="stylesheet">

    <!-- 字体 -->
    <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet">

    <!-- 离子图标 -->
    <link href="[@spring.url '/resources/css/ionicons.min.css'/]" rel="stylesheet">

    <!-- Morris 时间系列绘图 -->
    <link href="[@spring.url '/resources/css/morris.css'/]" rel="stylesheet"/>

    <!-- 时间选择器 -->
    <link href="[@spring.url '/resources/css/datepicker.css'/]" rel="stylesheet"/>

    <!-- Animate css动画库 -->
    <link href="[@spring.url '/resources/css/animate.min.css'/]" rel="stylesheet">

    <!-- Owl Carousel 旋转木马 -->
    <link href="[@spring.url '/resources/css/owl.carousel.min.css'/]" rel="stylesheet">
    <link href="[@spring.url '/resources/css/owl.theme.default.min.css'/]" rel="stylesheet">

    <!-- parsley验证css -->
    <link href="[@spring.url '/resources//js/parsley/parsley.css'/]" rel="stylesheet">

    <!-- 模板自定义css -->
    <link href="[@spring.url '/resources/css/simplify.css'/]" rel="stylesheet">
    [#--<link href="[@spring.url '/resources/css/simplify.min.css'/]" rel="stylesheet">--]
    <link href="[@spring.url '/resources/css/reset.css'/]" rel="stylesheet">
[/@block]
</head>

<body class="overflow-hidden">
<div class="wrapper preload">
    <!-- sidebar-right -->
[#include '/shared/sidebar-right.ftl'/]
    <!-- top-nav-inner header -->
[#include '/shared/header.ftl'/]
    <!-- sidebar-menu -->
[#include '/shared/sidebar-menu.ftl'/]

    <div class="main-container">
        <div class="padding-md">
            <!-- 面包屑导航 -->
        [@block name="breadcrumb"]
            <ul class="breadcrumb">
                <li><span class="primary-font"><i class="icon-home"></i></span><a href="index.html"> Home</a></li>
                <li>UI Elements</li>
                <li>Tab</li>
            </ul>
        [/@block]

            <h3 class="header-text m-top-lg">[@block name="headerText"]Static Tables[/@block]</h3>

        [@block name="subContent"]

        [/@block]
        </div>
    </div><!-- /main-container -->
    <!-- footer -->
[#include '/shared/footer.ftl'/]
</div>

<!-- top 返回顶部按钮 -->
<a href="#" class="scroll-to-top hidden-print active"><i class="fa fa-chevron-up fa-lg"></i></a>

[@block name="bottomResources"]
<!-- ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- Jquery -->
<script src="[@spring.url '/resources/js/jquery-1.11.1.min.js'/]"></script>

<!-- Bootstrap -->
<script src="[@spring.url '/resources/bootstrap/js/bootstrap.min.js'/]"></script>

<!--验证表单-->
<script src="[@spring.url '/resources/js/parsley/parsley.js' /]" type="text/javascript"></script>

<!-- Flot 绘图js -->
[#--<script src="[@spring.url '/resources/js/jquery.flot.min.js'/]"></script>--]

<!-- Slimscroll 滚动条js -->
<script src="[@spring.url '/resources/js/jquery.slimscroll.min.js'/]"></script>

<!-- Nicescroll 滚动条 -->
<script src="[@spring.url '/resources/js/nicescroll/jquery.nicescroll.js'/]"></script>

<!-- Morris 时间系列绘图 -->
[#--<script src="[@spring.url '/resources/js/rapheal.min.js'/]"></script>--]
[#--<script src="[@spring.url '/resources/js/morris.min.js'/]"></script>--]

<!-- Datepicker 时间选择js -->
[#--<script src="[@spring.url '/resources/js/uncompressed/datepicker.js'/]"></script>--]

<!-- Sparkline 线状图插件 -->
[#--<script src="[@spring.url '/resources/js/sparkline.min.js'/]"></script>--]

<!-- Skycons 天气插件 -->
[#--<script src='[@spring.url '/resources/js/uncompressed/skycons.js'/]'></script>--]

<!-- Popup Overlay 弹出层 -->
<script src="[@spring.url '/resources/js/jquery.popupoverlay.min.js'/]"></script>

<!-- Easy Pie Chart 饼状图 -->
[#--<script src="[@spring.url '/resources/js/jquery.easypiechart.min.js'/]"></script>--]

<!-- Sortable 拖拽 -->
[#--<script src="[@spring.url '/resources/js/uncompressed/jquery.sortable.js'/]"></script>--]

<!-- Owl Carousel 旋转木马的 -->
[#--<script src="[@spring.url '/resources/js/owl.carousel.min.js'/]"></script>--]

<!-- Modernizr 浏览器检测 -->
<script src="[@spring.url '/resources/js/modernizr.min.js'/]"></script>

<!-- 模板自定义js -->
<script src="[@spring.url '/resources/js/simplify/simplify.js'/]"></script>
<script src="[@spring.url '/resources/js/simplify/simplify_dashboard.js'/]"></script>

<script src="[@spring.url '/resources/js/fastjson.js'/]"></script>

<!-- 公共js库 -->
<script src="[@spring.url '/resources/js/common.js'/]"></script>
<script src="[@spring.url '/resources/js/ArrayPrototype.js'/]"></script>
<script src="[@spring.url '/resources/js/StringUtil.js'/]"></script>
[/@block]
</body>
</html>
