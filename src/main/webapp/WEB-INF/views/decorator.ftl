[#--[#assign shiro = JspTaglibs["/WEB-INF/shiro.tld"]]--]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content="pengyi"/>
    <link rel="icon" type="image/png" href="[@spring.url '/resources/assets/i/favicon.png'/]">
    <link rel="apple-touch-icon-precomposed" href="[@spring.url '/resources/assets/i/app-icon72x72@2x.png'/]">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.css'/]"/>
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.min.css'/]"/>
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/admin.css'/]">
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/app.css'/]">
[#--<link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.flat.css'/]"/>--]
[#--<link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.flat.min.css'/]"/>--]
[/@block]
    <title>YJH_DEMO-[@block name="title"][/@block]</title>
[@block name="topResources"]
[/@block]
</head>

<body>
[@block name="header"]
    [#include "/shared/header.ftl" /]
[/@block]

<div class="am-cf admin-main">
[@block name="sidebar"]
    [#include "/shared/sidebar.ftl"]
[/@block]

    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <ol class="am-breadcrumb">
                <li><a href="/" class="am-icon-home">首页</a></li>
            [@block name="contentTitle"][/@block]
            </ol>
        </div>

    [@block name="content"]

    [/@block]
    </div>
    <!-- content end -->

</div>

[@block name="footer"]
    [#include "/shared/footer.ftl"]
[/@block]


[@block name="bottomResources"]
<script src="[@spring.url '/resources/assets/js/jquery.min.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/amazeui.min.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/app.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/common.js'/]"></script>
[/@block]
</body>
</html>