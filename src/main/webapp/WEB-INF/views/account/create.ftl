[@override name="title"]用户管理 - 用户创建[/@override]
[@override name="topResources"]
    [@super /]
[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/account/pagination.htm">用户管理</a></li>
    <li>用户创建</li>
</ul>
[/@override]

[@override name="headerText"]
用户 创建
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/account/create.htm" method="post" data-parsley-validate>

            [@spring.bind "command.userName"/]
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">用户名*</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="userName" name="userName"
                           value="${command.userName!}" placeholder="输入用户名"
                           data-parsley-required="true" data-parsley-required-messages="用户名不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "userName" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.password"/]
            <div class="form-group">
                <label for="projectName" class="col-md-3 control-label">密码*</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" id="password" name="password"
                           value="${command.password!}" placeholder="输入密码"
                           data-parsley-required="true" data-parsley-required-messages="密码不能为空"
                           data-parsley-minlength="6" data-parsley-trigger="change"/>
                    [@spring.showErrors "password" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.confirmPassword"/]
            <div class="form-group">
                <label for="description" class="col-md-3 control-label">确认密码*</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                           value="${command.confirmPassword!}" placeholder="输入确认密码"
                           data-parsley-required="true" data-parsley-required-messages="确认密码不能为空"
                           data-parsley-equalto="#password" data-parsley-equalto-messages="两次密码输入不一致"
                           data-parsley-minlength="6" data-parsley-trigger="change"/>
                    [@spring.showErrors "confirmPassword" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.roles"/]
            <div class="form-group">
                <label for="description" class="col-md-3 control-label">角色*</label>
                <div class="col-md-9">
                    <div class="col-md-10 div-input role-data"></div>
                    <input type="hidden" name="roles" id="role"/>
                    <button type="button" class="btn btn-primary col-md-2 modal-role-search-modal">点击选择角色</button>
                    [@spring.showErrors "roles" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.appKey"/]
            <div class="form-group">
                <label for="appKey" class="col-md-3 control-label">AppKey</label>
                <div class="col-md-9">
                    <select class="form-control" id="appKey" name="appKey" data="${command.appKey!}"
                            data-parsley-required="true" data-parsley-required-messages="请选择AppKey"
                            data-parsley-trigger="change">

                    </select>
                    [@spring.showErrors "appKey" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.status"/]
            <div class="form-group">
                <label for="status" class="col-md-3 control-label">用户状态*</label>
                <div class="col-md-9">
                    <select class="form-control" name="status" id="status"
                            data-parsley-required="true" data-parsley-required-messages="请选择角色状态"
                            data-parsley-trigger="change">
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

<!-- 选择角色弹窗 -->
<div class="modal fade" id="role-modalSearch">
    <div class="modal-content">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true"
                                                                               class="red">&times;</span><span
                        class="sr-only">Close</span></button>
                <p class="modal-title">角色列表--勾选添加到已选角色列表
                    <small class="text-muted"></small>
                </p>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-9 input-list">
                        <!-- 查询表单 -->
                        <form class="form-inline margin-md" role="form" action="[@spring.url '/permission/list' /]">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="permissionName">角色名称</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" id="roleName"
                                           name="roleName" value="${command.roleName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-6" for="status">角色状态</label>
                                <div class="col-md-6">
                                    <select name="status" id="status" class="form-control">
                                        [#assign status = (command.status!)?default("") /]
                                        <option value="ALL">全部</option>
                                        <option value="ENABLE" [@mc.selected status "ENABLE" /]>启用</option>
                                        <option value="DISABLE" [@mc.selected status "DISABLE" /]>禁用</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="appKey-modal">AppKey</label>
                                <div class="col-md-7">
                                    <select class="form-control" id="appKey-modal" name="appKey"
                                            data="${command.appKey!}">

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-md btn-success">查询</button>
                            </div>
                        </form>
                        <!-- table数据 -->
                        <table class="table table-bordered table-sortable table-hover">
                            <thead>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <!-- 分页信息 -->
                        <div class="row">
                            <div class="col-sm-4 text-center">
                                <small class="inline table-options paging-info">
                                </small>
                            </div>
                            <div class="col-sm-4 text-right sm-center">
                                <ul class="pagination pagination-sm no-margin pagination-custom no-m-left">
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="tile-header">
                            <h3><strong>已选</strong>列表</h3>
                        </div>
                        <div class="tile-body selector-box modal-search-selector">
                            <button class="btn margin-top-15 btn-success modal-search-hide-modal">确定</button>
                            <button class="btn margin-top-15 btn-danger selector-remove-all">删除全部</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/ajax.js'/]"></script>
<script src="[@spring.url '/resources/js/modal-search-optimize.js'/]"></script>
<script type="text/javascript">
    //加载appKey数据
    $("#appKey").selectAjaxData({url: "/app_key/all_list"});
    $("#appKey-modal").selectAjaxData({url: "/app_key/all_list"});

    var _roleName = $(".role-data");
    var _roleData = $("#role");
    var modalSearch = new ModalSearch({
        url: "/role/list",
        pageSize: 6,
        isSingle: true,
        id: "role-modalSearch",
        openModalBtn: ".modal-role-search-modal",
        header: ['角色名称', '角色描述', 'AppKey'],
        rowData: ["name", "description", "appKey.name"],
        selectorData: ["name"],
        hideModalHandler: function (jsonDataArr) {
            _roleName.text("");
            _roleData.val("");
            for (var key in jsonDataArr) {
                _roleName.text(jsonDataArr[key].name + "-------" + jsonDataArr[key].description);
                _roleData.val(jsonDataArr[key].id);
            }
        }
    });
</script>
[/@override]
[@extends name="/decorator.ftl"/]