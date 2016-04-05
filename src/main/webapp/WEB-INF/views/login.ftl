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

    <title>YJH_DEMO Admin - 登录</title>

    <!-- Bootstrap core CSS -->
    <link href="[@spring.url '/resources/bootstrap/css/bootstrap.min.css'/]" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet">

    <!-- ionicons -->
    <link href="[@spring.url '/resources/css/ionicons.min.css'/]" rel="stylesheet">

    <!-- Simplify -->
    <link href="[@spring.url '/resources/css/simplify.min.css'/]" rel="stylesheet">

    <link href="[@spring.url '/resources/app/login/login.css'/]" rel="stylesheet">

    <link href="[@spring.url '/resources//js/parsley/parsley.css'/]" rel="stylesheet">

    <!-- Jquery -->
    <script src="[@spring.url '/resources/js/jquery-1.11.1.min.js'/]"></script>
</head>

<body class="overflow-hidden light-background">
<div class="wrapper no-navigation preload">
    <div class="sign-in-wrapper">
        <div class="sign-in-inner">
            <div class="login-brand text-center">
                <i class="fa fa-lock m-right-xs"></i> YJH_DEMO <strong class="text-skin">Admin</strong>
            </div>

            <form action="[@spring.url '/login.htm'/]" method="post" data-parsley-validate>
            [@mc.showAlert /]

            [@spring.bind 'command.userName'/]
                <div class="form-group m-bottom-md">
                    <input type="text" class="form-control" value="${command.userName!}" name="userName" placeholder="用户名"
                           data-parsley-required="true" data-parsley-required-message="请输入用户名"
                           data-parsley-trigger="change"/>
                [@spring.showErrors 'userName' 'parsley-required'/]
                </div>
            [@spring.bind 'command.password'/]
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="密码"
                           data-parsley-required="true" data-parsley-required-message="请输入密码"
                           data-parsley-trigger="change"/>
                [@spring.showErrors 'password' 'parsley-required'/]
                </div>
            [@spring.bind 'command.verificationCode'/]
                <div class="form-group loginVerification">
                [@mc.verificationCode /]
                    <input type="text" class="form-control" name="verificationCode" placeholder="验证码"
                           data-parsley-required="true" data-parsley-required-message="请输入验证码"
                           data-parsley-trigger="change"/>
                [@spring.showErrors 'verificationCode' 'parsley-required'/]
                </div>

                <div class="form-group">
                    <div class="custom-checkbox">
                        <input type="checkbox" id="chkRemember" [@mc.checked command.rememberMe/] name="rememberMe">
                        <label for="chkRemember"></label>
                    </div>
                    记住我
                </div>

                <div class="m-top-md p-top-sm">
                    <button type="submit" class="btn btn-success block col-xs-12">登录</button>
                </div>

            </form>
        </div><!-- ./sign-in-inner -->
    </div><!-- ./sign-in-wrapper -->
</div><!-- /wrapper -->

<a href="" id="scroll-to-top" class="hidden-print"><i class="icon-chevron-up"></i></a>

<!-- Le javascript
================================================== -->

<!--验证表单-->
<script src="[@spring.url '/resources/js/parsley/parsley.js' /]" type="text/javascript"></script>
<!-- Bootstrap -->
<script src="[@spring.url '/resources/bootstrap/js/bootstrap.min.js'/]"></script>

<!-- Slimscroll -->
<script src="[@spring.url '/resources/js/jquery.slimscroll.min.js'/]"></script>

<!-- Popup Overlay -->
<script src="[@spring.url '/resources/js/jquery.popupoverlay.min.js'/]"></script>

<!-- Modernizr -->
<script src="[@spring.url '/resources/js/modernizr.min.js'/]"></script>

<!-- Simplify -->
<script src="[@spring.url '/resources/js/simplify/simplify.js'/]"></script>

<script src="[@spring.url '/resources/js/common.js'/]"></script>
</body>
</html>
