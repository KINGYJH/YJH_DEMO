[@override name="title"]站内信管理 - 站内信创建[/@override]
[@override name="topResources"]
    [@super /]
[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/messages/pagination.htm">站内信管理</a></li>
    <li>站内信创建</li>
</ul>
[/@override]

[@override name="headerText"]
站内信 创建
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/account/create.htm" method="post" data-parsley-validate>

            [@spring.bind "command.title"/]
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">站内信标题*</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="title" name="title"
                           value="${command.title!}" placeholder="输入站内信标题"
                           data-parsley-required="true" data-parsley-required-messages="站内信标题不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "title" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.content"/]
            <div class="form-group">
                <label for="content" class="col-md-3 control-label">站内信内容*</label>
                <div class="col-md-9">
                    <textarea class="form-control" id="content" name="content"
                              value="${command.content!}" rows="10"
                              placeholder="输入站内信内容"
                              data-parsley-required="true" data-parsley-required-messages="站内信内容不能为空"
                              data-parsley-trigger="change"></textarea>
                    [@spring.showErrors "content" "parsley-required"/]
                </div>
            </div>

            <div class="form-group">
                <label for="content" class="col-md-3 control-label">站内信发送方式*</label>
                <div class="col-md-9">
                    <div class="radio inline-block">
                        <div class="custom-radio m-right-xs">
                            <input type="radio" id="sendType1" name="sendType" value="role" checked/>
                            <label for="sendType1"></label>
                        </div>
                        <div class="inline-block vertical-top">根据角色发送</div>
                    </div>
                    <div class="radio inline-block">
                        <div class="custom-radio m-right-xs">
                            <input type="radio" id="sendType2" name="sendType" value="account"/>
                            <label for="sendType2"></label>
                        </div>
                        <div class="inline-block vertical-top">根据账户发送</div>
                    </div>
                </div>
            </div>

            <div class="form-group role-send">
                <label class="col-md-3 control-label">发送角色*</label>
                <div class="col-md-9">
                    <div class="col-sm- pull-left margin-sm">
                        <button type="button" class="btn btn-primary modal-role-search-modal" data-toggle="modal">
                            点击选择角色
                        </button>
                    </div>
                    <div class="data-list role-list margin-sm">
                        <ul class="col-sm-11 contract-show margin-sm">
                        </ul>
                    </div>
                </div>
            </div>

            <div class="form-group account-send">
                <label class="col-md-3 control-label">发送账户*</label>
                <div class="col-md-9">
                    <div class="col-sm- pull-left margin-sm">
                        <button type="button" class="btn btn-primary modal-account-search-modal" data-toggle="modal">
                            点击选择账户
                        </button>
                    </div>
                    <div class="data-list account-list margin-sm">
                        <ul class="col-sm-11 contract-show margin-sm">
                        </ul>
                    </div>
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
                            <div class="selector-box-data"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<!-- 选择账户弹窗 -->
<div class="modal fade" id="account-modalSearch">
    <div class="modal-content">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true"
                                                                               class="red">&times;</span><span
                        class="sr-only">Close</span></button>
                <p class="modal-title">账户列表--勾选添加到已选账户列表
                    <small class="text-muted"></small>
                </p>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-9 input-list">
                        <!-- 查询表单 -->
                        <form class="form-inline margin-md" role="form" action="[@spring.url '/account/list' /]">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="accountUserName">账户名称</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" id="accountUserName"
                                           name="accountUserName" value="${command.accountUserName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-6" for="status">账户状态</label>
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
                            <div class="selector-box-data">

                            </div>
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
<script src="[@spring.url '/resources/js/modal-search-yjh.js'/]"></script>
<script type="text/javascript">
    //加载appKey数据
    $("#appKey-modal").selectAjaxData({url: "/app_key/all_list"});

    new ModalSearch({
        url: "/role/list",
        pageSize: 1,
        isSingle: false,
        id: "role-modalSearch",
        openModalClass: ".modal-role-search-modal",
        headers: ['角色名称', '角色描述', 'AppKey'],
        rowDataName: ["name", "description", "appKey.name"],
        selectorDateName: ["name"],
        hideModalHandler: function (jsonDataArr) {
            var ul_list = _roleData.find("ul");
            ul_list.empty();
            for (var key in jsonDataArr) {
                logger.info(jsonDataArr[key]);
                ul_list.append("<li><div class=\"col-md-12 contract-box\">" + jsonDataArr[key].name + "-----" + jsonDataArr[key].description + "</div><input type=\"hidden\" name=\"permissions\" value=\"" + jsonDataArr[key].id + "\"/></li>");
            }
        }
    });

    //    $("input[name='sendType']").on("click", function () {
    //        if ($(this).val() == "role") {
    //            _roleModel = new ModalSearch({
    //                url: "/role/list",
    //                pageSize: 6,
    //                isSingle: false,
    //                id: "role-modalSearch",
    //                openModalBtn: ".modal-role-search-modal",
    //                header: ['角色名称', '角色描述', 'AppKey'],
    //                rowData: ["name", "description", "appKey.name"],
    //                selectorData: ["name"],
    //                hideModalHandler: function (jsonDataArr) {
    //                    var ul_list = _roleData.find("ul");
    //                    ul_list.empty();
    //                    for (var key in jsonDataArr) {
    //                        logger.info(jsonDataArr[key]);
    //                        ul_list.append("<li><div class=\"col-md-12 contract-box\">" + jsonDataArr[key].name + "-----" + jsonDataArr[key].description + "</div><input type=\"hidden\" name=\"permissions\" value=\"" + jsonDataArr[key].id + "\"/></li>");
    //                    }
    //                }
    //            });
    //        } else {
    //            _accountModel = new ModalSearch({
    //                url: "/account/list",
    //                pageSize: 6,
    //                isSingle: false,
    //                id: "account-modalSearch",
    //                openModalBtn: ".modal-account-search-modal",
    //                header: ['账户名称', 'AppKey'],
    //                rowData: ["userName", "appKey.name"],
    //                selectorData: ["userName"],
    //                hideModalHandler: function (jsonDataArr) {
    //                    var ul_list = _accountDate.find("ul");
    //                    ul_list.empty();
    //                    for (var key in jsonDataArr) {
    //                        logger.info(jsonDataArr[key]);
    //                        ul_list.append("<li><div class=\"col-md-12 contract-box\">" + jsonDataArr[key].userName + "-----" + jsonDataArr[key].appKey.name + "</div><input type=\"hidden\" name=\"permissions\" value=\"" + jsonDataArr[key].id + "\"/></li>");
    //                    }
    //                }
    //            });
    //        }
    //    });

    var _roleData = $(".role-list");
    _roleData.slimScroll({
        height: '300px'
    });
    var _accountDate = $(".account-list");
    _accountDate.slimScroll({
        height: '300px'
    });

</script>
[/@override]
[@extends name="/decorator.ftl"/]