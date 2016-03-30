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
    <title>AmazeUIMode-[@block name="title"][/@block]</title>
[@block name="topResources"]
[/@block]
</head>

<body>
<div class="am-g am-u-sm-12">
    <div class="am-u-md-12">
        选择角色
        <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
        </div>
    </div>
    <div class="am-u-md-12">
        <div class="am-panel am-panel-default am-u-sm-9">
            <div class="am-panel-bd">
                <ul class="app-alert-layer-ul-data">
                    <li><a href="">123123123</a></li>
                    <li><a href="">123134212</a></li>
                    <li><a href="">1231sdfss</a></li>
                    <li><a href="">1231sdf23123</a></li>
                    <li><a href="">123123123</a></li>
                </ul>
            </div>
        </div>
        <div class="am-panel am-panel-default am-u-sm-3">
            <div class="am-panel-hd am-u-md-12">
                <button type="button" class="am-btn am-btn-primary">确定</button>
                <button type="button" class="am-btn am-btn-danger am-align-right">取消</button>
            </div>
            <div class="am-panel-bd">
                123
            </div>
        </div>
    </div>
</div>
</div>


[@block name="bottomResources"]
<script src="[@spring.url '/resources/assets/js/jquery.min.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/amazeui.min.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/app.js'/]"></script>
[/@block]
</body>
</html>