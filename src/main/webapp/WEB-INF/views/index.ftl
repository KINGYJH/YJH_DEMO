[@override name="title"]首页控制台[/@override]

[@override name="topResources"]
    [@super /]
<!-- 文件上传 -->
<link href="[@spring.url '/resources/js/upload/webuploader.css'/]" rel="stylesheet">
<link href="[@spring.url '/resources/css/upload.css'/]" rel="stylesheet">
[/@override]

[@override name="breadcrumb"]
<div class="row">
    <div class="col-sm-12">
        <div class="page-title">
            控制面板
        </div>
        <div class="page-sub-header">
            欢迎回来, XXXXXXX , <i class="fa fa-map-marker text-danger"></i> XXXXXXX
        </div>
    </div>
</div>
[/@override]
[@override name="subContent"]
<div class="row">
    <div class="col-md-12">
        <h1>多图片上传</h1>
        <div id="uploader" class="wu-example">
            <div class="queueList">
                <div id="dndArea" class="placeholder">
                    [#--<div id="filePicker"></div>--]
                </div>
            </div>
            <div class="statusBar" style="display:none;">
                <div class="progress">
                    <span class="text">0%</span>
                    <span class="percentage"></span>
                </div>
                <div class="info"></div>
                <div class="btns">
                    <div id="filePicker2"></div>
                    <div class="uploadBtn">开始上传</div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12">
        <h1>单图片上传</h1>
        <!--dom结构部分-->
        <div id="uploader-demo">
            <!--用来存放item-->
            <div id="fileList" class="uploader-list"></div>
            <div id="filePicker">选择图片</div>
        </div>
    </div>
</div>


</div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/upload/webuploader.js'/]"></script>
<script src="[@spring.url '/resources/js/upload/morePicUpload.js'/]"></script>
<script src="[@spring.url '/resources/js/upload/onePicUpload.js'/]"></script>
<script>
</script>
[/@override]
[@extends name="/decorator.ftl"/]
