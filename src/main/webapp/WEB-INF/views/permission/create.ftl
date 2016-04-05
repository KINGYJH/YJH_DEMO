[@override name="title"]权限管理 - 权限创建[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/permission/pagination.htm">权限管理</a></li>
    <li>权限创建</li>
</ul>
[/@override]

[@override name="headerText"]
权限 创建
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/permission/create.htm" method="post" data-parsley-validate>

            [@spring.bind "command.name"/]
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">权限名称*</label>
                <div class="col-md-9">
                    <input class="form-control" id="name" name="name"
                           value="${command.name!}" placeholder="输入权限名称"
                           data-parsley-required="true" data-parsley-required-message="权限名称不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "name" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.value"/]
            <div class="form-group">
                <label for="projectName" class="col-md-3 control-label">权限值*</label>
                <div class="col-md-9">
                    <input class="form-control" id="value" name="value"
                           value="${command.value!}" placeholder="输入权限值"
                           data-parsley-required="true" data-parsley-required-message="权限值不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "value" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.description"/]
            <div class="form-group">
                <label for="description" class="col-md-3 control-label">权限描述*</label>
                <div class="col-md-9">
                    <input class="form-control" id="description" name="description"
                           value="${command.description!}" placeholder="输入权限描述"
                           data-parsley-required="true" data-parsley-required-message="权限描述不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "name" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.appKey"/]
            <div class="form-group">
                <label for="appKey" class="col-md-3 control-label">AppKey</label>
                <div class="col-md-9">
                    <select class="form-control" id="appKey" name="appKey" data="${command.appKey!}"
                            data-parsley-required="true" data-parsley-required-message="请选择AppKey"
                            data-parsley-trigger="change" >

                    </select>
                    [@spring.showErrors "appKey" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.status"/]
            <div class="form-group">
                <label for="status" class="col-md-3 control-label">权限状态*</label>
                <div class="col-md-9">
                    <select class="form-control" name="status" id="status"
                            data-parsley-required="true" data-parsley-required-message="请选择权限状态"
                            data-parsley-trigger="change" >
                        [#assign status = (command.status!)?default("") /]
                        <option value="">请选择</option>
                        <option value="ENABLE" [@mc.selected status "ENABLE"/]>启用</option>
                        <option value="DISABLE" [@mc.selected status "DISABLE"/]>禁用</option>
                    </select>
                    [@spring.showErrors "status" "parsley-required"/]
                </div>
            </div>
            <div class="text-center m-top-md">
                <button type="reset" class="btn btn-default">重置</button>
                <button type="submit" class="btn btn-success">创建</button>
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
    $("#appKey").selectAjaxData({url: "/app_key/all_list"});
</script>
[/@override]
[@extends name="/decorator.ftl"/]