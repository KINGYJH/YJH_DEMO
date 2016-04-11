<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

    <title>Plupload - jQuery UI Widget</title>

    <link rel="stylesheet" href="[@spring.url '/resources/css/jquery-ui.min.css'/]" type="text/css"/>
    <link rel="stylesheet" href="[@spring.url '/resources/js/upload/css/jquery.ui.plupload.css'/]" type="text/css"/>

    <script src="[@spring.url '/resources/js/jquery.min.js'/]"></script>
    <script type="text/javascript" src="[@spring.url '/resources/js/jquery-ui.min.js'/]"></script>

    <!-- production -->
    <script type="text/javascript" src="[@spring.url '/resources/js/upload/plupload.full.min.js'/]"></script>
    <script type="text/javascript" src="[@spring.url '/resources/js/upload/jquery.ui.plupload.js'/]"></script>

    <!-- debug
    <script type="text/javascript" src="../../js/moxie.js"></script>
    <script type="text/javascript" src="../../js/plupload.dev.js"></script>
    <script type="text/javascript" src="../../js/jquery.ui.plupload/jquery.ui.plupload.js"></script>
    -->

</head>
<body style="font: 13px Verdana; background: #eee; color: #333">

<h1>jQuery UI Widget</h1>

<p>You can see this example with different themes on the <a href="http://plupload.com/example_jquery_ui.php">www.plupload.com</a>
    website.</p>

<form id="form" method="post" action="../dump.php">
    <div id="uploader">
        <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
    </div>
    <br/>
    <input type="submit" value="Submit"/>
</form>

<script type="text/javascript">
    // 初始化控件在DOM就绪
    $(function () {
        $("#uploader").plupload({
            // 一般设置
            runtimes: 'html5,flash,silverlight,html4',
            url: '/upload/img_upload',
            name: 'files',
            // 用户可以上传不超过20的文件中去（假集multiple_queues）
            max_file_count: 20,

            chunk_size: '1mb',

            // 调整图像在客户端如果我们能
            resize: {
                width: 200,
                height: 200,
                quality: 90,
                crop: true // crop to exact dimensions
            },

            filters: {
                // 最大文件大小
                max_file_size: '1000mb',
                // 指定要浏览的文件
                mime_types: [
                    {title: "Image files", extensions: "jpg,gif,png"},
                    {title: "Zip files", extensions: "zip"}
                ]
            },

            // 通过点击他们的标题来重命名文件
            rename: true,

            // 文件排序
            sortable: true,

            // 可以拖放文件到窗口小部件的能力（目前只有HTML5的支持）
            dragdrop: true,

            // 视图激活
            views: {
                list: true,
                thumbs: true, // 显示的大拇指
                active: 'thumbs'
            },

            // Flash 位置
            flash_swf_url: '/resources/js/upload/Moxie.swf',

            // Silverlight 位置
            silverlight_xap_url: '/resources/js/upload/Moxie.xap',
            init: {
                PostInit: function () {
                },
                FileUploaded: function (up,file,info) {
                    console.log(up);
                    console.log(file);
                    console.log(info);
                },
                Error: function (up, err) {
                    console.log(err);
                }
            }
        });


        // 在上传完成前处理表单提交的情况
//        $('#form').submit(function (e) {
//            // 队列中的文件先上传
//            if ($('#uploader').plupload('getFiles').length > 0) {
//
//                // 当所有文件上传提交表单
//                $('#uploader').on('complete', function () {
//                    $('#form')[0].submit();
//                });
//
//                $('#uploader').plupload('start');
//            } else {
//                alert("在队列中至少有一个文件.");
//            }
//            return false; // 保持表单提交
//        });
    });
</script>
</body>
</html>
