[@override name="title"]角色管理 - 角色修改[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/role/pagination.htm">角色管理</a></li>
    <li>角色修改</li>
</ul>
[/@override]

[@override name="headerText"]
角色 修改
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/role/edit.htm" method="post" data-parsley-validate>

            <input type="hidden" name="id" value="${role.id!command.id}" />
            <input type="hidden" name="version" value="${role.version!command.version}" />

            [@spring.bind "command.name"/]
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">角色名称*</label>
                <div class="col-md-9">
                    <input class="form-control" id="name" name="name"
                           value="${role.name!command.name}" placeholder="输入角色名称"
                           data-parsley-required="true" data-parsley-required-message="角色名称不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "name" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.description"/]
            <div class="form-group">
                <label for="description" class="col-md-3 control-label">角色描述*</label>
                <div class="col-md-9">
                    <input class="form-control" id="description" name="description"
                           value="${role.description!command.description}" placeholder="输入角色描述"
                           data-parsley-required="true" data-parsley-required-message="角色描述不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "name" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.appKey"/]
            <div class="form-group">
                <label for="appKey" class="col-md-3 control-label">AppKey*</label>
                <div class="col-md-9">
                    <select class="form-control" id="appKey" name="appKey" data="${role.appKey.id!command.appKey!}"
                            data-parsley-required="true" data-parsley-required-message="请选择AppKey"
                            data-parsley-trigger="change">

                    </select>
                    [@spring.showErrors "appKey" "parsley-required"/]
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">角色权限</label>
                <div class="col-md-9">
                    <div class="col-sm- pull-left margin-sm">
                        <button type="button" class="btn btn-primary modal-permission-search-modal" data-toggle="modal">
                            点击添加或删除权限
                        </button>
                    </div>
                    <div class="data-list margin-sm">
                        <ul class="col-sm-11 contract-show margin-sm">
                            [#if role.permissions??]
                                [#list role.permissions as permission]
                                    <li>
                                        <div class="col-md-12 contract-box">${permission.name!}-----${permission.description!}</div>
                                        <input type="hidden" name="permissions" value="${permission.id!}"/>
                                    </li>
                                [/#list]
                            [/#if]
                        </ul>
                    </div>
                </div>
            </div>
            <div class="text-center m-top-md">
                <button type="reset" class="btn btn-default">重置</button>
                <button type="submit" class="btn btn-success">修改</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3">
        <ul class="blog-sidebar-list font-18">创建注意事项
            <li>*位必填项</li>
        </ul>
    </div>
</div>

<!-- 选择权限弹窗 -->
<div class="modal fade" id="permission-modalSearch">
    <div class="modal-content">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true"
                                                                               class="red">&times;</span><span
                        class="sr-only">Close</span></button>
                <p class="modal-title">权限列表--勾选添加到已选权限列表
                    <small class="text-muted"></small>
                </p>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-9 input-list">
                        <!-- 查询表单 -->
                        <form class="form-inline margin-md" role="form" action="[@spring.url '/permission/list' /]">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="permissionName">权限名称</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" id="permissionName"
                                           name="permissionName" value="${command.permissionName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-6" for="status">权限状态</label>
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

    $(document).ready(function () {
        //加载appKey数据
        $("#appKey").selectAjaxData({url: "/app_key/all_list"});
        $("#appKey-modal").selectAjaxData({url: "/app_key/all_list"});

        //选权限弹窗
        var data_list = $(".data-list");
        data_list.slimScroll({
            height: '300px'
        });
        var modalSearch = new ModalSearch({
            url: "/permission/list",
            pageSize: 6,
            isSingle: false,
            id: "permission-modalSearch",
            openModalBtn: ".modal-permission-search-modal",
            header: ['AppKey名称', 'AppKey描述', 'AppKey'],
            rowData: ["name", "description", "appKey.name"],
            selectorData: ["name"],
            hideModalHandler: function (jsonDataArr) {
                var ul_list = data_list.find("ul");
                ul_list.empty();
                for (var key in jsonDataArr) {
                    logger.info(jsonDataArr[key]);
                    ul_list.append("<li><div class=\"col-md-12 contract-box\">" + jsonDataArr[key].name + "-----" + jsonDataArr[key].description + "</div><input type=\"hidden\" name=\"permissions\" value=\"" + jsonDataArr[key].id + "\"/></li>");
                }
            }
        });
    })
</script>
[/@override]
[@extends name="/decorator.ftl"/]