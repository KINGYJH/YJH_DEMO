[@override name="title"]个人简介[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li>个人简介</li>
</ul>
[/@override]

[@override name="headerText"]
个人简介
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row user-profile-wrapper">
    <div class="col-md-3 user-profile-sidebar m-bottom-md">
        <div class="row">
            <div class="col-sm-4 col-md-12" data-toggle="tooltip" data-placement="" title="点击更换头像">
                <div class="user-profile-pic">
                    <img id="head-img" src="${Session["sessionUser"].headPic.picPath?default('/resources/images/profile/profile1.jpg')}" alt="">
                    <div class="ribbon-wrapper">
                        <div class="ribbon-inner shadow-pulse bg-success">
                            点击修改头像
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-12">
                <div class="user-name m-top-sm">${Session["sessionUser"].userName!}<i class="fa fa-circle text-success m-left-xs font-14"></i>
                </div>

                <div class="m-top-sm">
                    <div>
                        <i class="fa fa-map-marker user-profile-icon"></i>
                        最后登录IP:${Session["sessionUser"].lastLoginIP!}
                    </div>

                    <div class="m-top-xs">
                        <i class="fa fa-briefcase user-profile-icon"></i>
                        最后登录时间:[@mc.dateShow Session["sessionUser"].lastLoginDate /]
                    </div>
                </div>

                <div class="m-top-sm text-centers">
                    <a class="btn btn-success"><i class="fa fa-edit m-right-xs"></i>Edit Profile</a>
                </div>

                <h4 class="m-top-md m-bottom-sm">关于我</h4>
                <p class="m-top-sm">
                    ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸ
                <p>
            </div>
        </div>
    </div>
</div>

[#--文件上传进度--]
<div class="file_upload_load"></div>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/upload/webuploader.js'/]"></script>
<script type="text/javascript">

    // 初始化Web Uploader
    uploader = WebUploader.create({
        // 自动上传。
        auto: true,
        // 文件接收服务端。
        server: '/account/update_headPic',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '.user-profile-pic',
        // 只允许选择文件，可选。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });

    // 当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {
        uploader.makeThumb(file, function (error, src) {
            if (error) {
                return;
            }
            $("#head-img").attr("src", src);
        });
    });

    uploader.on('uploadProgress', function (file, percentage) {
        $('html').addClass('.file_upload_mask');
        $('.file_upload_load').show();
    });

    uploader.on('uploadSuccess', function (file, result) {
        $('html').removeClass('.file_upload_mask');
        $('.file_upload_load').hide();
        layer.msg("上传成功！", {icon: 1});
    });

    uploader.on('uploadError', function (handler) {
        $('html').removeClass('.file_upload_mask');
        $('.file_upload_load').hide();
        layer.msg("上传失败！");
    });
</script>
[/@override]
[@extends name="/decorator.ftl"/]