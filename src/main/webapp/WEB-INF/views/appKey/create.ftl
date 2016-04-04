[@override name="title"]AppKey管理 - AppKey创建[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/app_key/pagination.htm">AppKey管理</a></li>
    <li>AppKey创建</li>
</ul>
[/@override]

[@override name="headerText"]
AppKey 创建
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/app_key/create.htm" method="post" data-parsley-validate>

            [@spring.bind "command.name"/]
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">AppKey名称*</label>
                <div class="col-md-9">
                    <input class="form-control" id="name" name="name"
                           value="${command.name!}" placeholder="输入AppKey名称"
                           data-parsley-required="true" data-parsley-required-message="AppKey名称不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "name" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.projectName"/]
            <div class="form-group">
                <label for="projectName" class="col-md-3 control-label">AppKey项目名称*</label>
                <div class="col-md-9">
                    <input class="form-control" id="projectName" name="projectName"
                           value="${command.projectName!}" placeholder="AppKey项目名称"
                           data-parsley-required="true" data-parsley-required-message="AppKey项目名不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "projectName" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.description"/]
            <div class="form-group">
                <label for="description" class="col-md-3 control-label">AppKey描述*</label>
                <div class="col-md-9">
                    <input class="form-control" id="description" name="description"
                           value="${command.description!}" placeholder="AppKey描述"
                           data-parsley-required="true" data-parsley-required-message="AppKey描述不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "description" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.status"/]
            <div class="form-group">
                <label for="status" class="col-md-3 control-label">AppKey状态*</label>
                <div class="col-md-9">
                    <select class="form-control" name="status"
                            data-parsley-required="true" data-parsley-required-message="请选择AppKey状态"
                            data-parsley-trigger="change">
                        [#assign status = (command.status!)?default("") /]
                        <option value="">请选择</option>
                        <option value="ENABLE" [@mc.selected status "ENABLE"/]>启用</option>
                        <option value="DISABLE" [@mc.selected status "DISABLE"/]>禁用</option>
                    </select>
                    [@spring.showErrors "name"/]
                </div>
            </div>
            <div class="text-center m-top-md">
                <button type="reset" class="btn btn-info">重置</button>
                <button type="submit" class="btn btn-info">创建</button>
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

[/@override]
[@extends name="/decorator.ftl"/]