[@override name="title"]用户管理 - 用户AppKey更新[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/user/pagination.htm">用户管理</a></li>
    <li>用户AppKey更新</li>
</ul>
[/@override]

[@override name="headerText"]
用户AppKey 更新
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/user/update_appKey.htm" method="post" data-parsley-validate>

            <input type="hidden" name="id" value="${user.id!user.id}"/>
            <input type="hidden" name="version" value="${user.version!user.version}"/>

            <div class="form-group">
                <label for="name" class="col-md-3 control-label">用户名*</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" value="${user.userName!}"  disabled/>
                </div>
            </div>

            [@spring.bind "command.appKey"/]
            <div class="form-group">
                <label for="appKey" class="col-md-3 control-label">AppKey</label>
                <div class="col-md-9">
                    <select class="form-control" id="appKey" name="appKey" data="${user.appKey.id!}"
                            data-parsley-required="true" data-parsley-required-message="请选择AppKey"
                            data-parsley-trigger="change">

                    </select>
                    [@spring.showErrors "appKey" "parsley-required"/]
                </div>
            </div>

            <div class="text-center m-top-md">
                <button type="submit" class="btn btn-success">修改AppKey</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3">
        <ul class="blog-sidebar-list font-18">创建注意事项
            <li>*位必填项</li>
        </ul>
    </div>
</div>

[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/ajax.js'/]"></script>
<script type="text/javascript">
    //加载appKey数据
    $("#appKey").selectAjaxData({url: "/app_key/all_list"});
</script>
[/@override]
[@extends name="/decorator.ftl"/]