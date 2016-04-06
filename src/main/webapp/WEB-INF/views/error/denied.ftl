<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="yjh">
    <link rel="shortcut icon" href="[@spring.url '/resources/images/favicon.ico' /]" type="image/x-icon"/>

    <title>Simplify Admin - denied</title>

    <!-- Bootstrap core CSS -->
    <link href="[@spring.url '/resources/bootstrap/css/bootstrap.min.css'/]" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet">

    <!-- ionicons -->
    <link href="[@spring.url '/resources/css/ionicons.min.css'/]" rel="stylesheet">

    <!-- Simplify -->
    <link href="[@spring.url '/resources/css/simplify.min.css'/]" rel="stylesheet">

</head>

<body class="overflow-hidden light-background">
<div class="wrapper no-navigation preload">
    <div class="error-wrapper">
        <div class="error-inner">
            <div class="error-type">NO</div>
            <h2>抱歉! 您没有足够的权限访问此页面!</h2>
            <p>可联系管理员提升您的权限</p>
            <div class="m-top-md">
                <a href="javascript:history.go(-1);" class="btn btn-default btn-lg text-upper">返回上一页</a>
                <a href="/" class="btn btn-default btn-lg text-upper">返回首页</a>
            </div>
        </div><!-- ./error-inner -->
    </div><!-- ./error-wrapper -->
</div><!-- /wrapper -->

<a href="" id="scroll-to-top" class="hidden-print"><i class="icon-chevron-up"></i></a>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<!-- Jquery -->
<script src="[@spring.url '/resources/js/jquery-1.11.1.min.js'/]"></script>

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

<script>
    $(function()	{
        setTimeout(function() {
            $('.error-type').addClass('animated');
        },100);
    });
</script>

</body>
</html>
