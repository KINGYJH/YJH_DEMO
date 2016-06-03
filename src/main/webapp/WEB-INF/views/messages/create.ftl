[@override name="title"]站内信管理 - 站内信创建[/@override]
[@override name="topResources"]
    [@super /]
<script type="text/javascript" charset="utf-8" src="[@spring.url '/resources/ueditor/ueditor.config.js'/]"></script>
<script type="text/javascript" charset="utf-8" src="[@spring.url '/resources/ueditor/ueditor.all.min.js'/]"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="[@spring.url '/resources/ueditor/lang/zh-cn/zh-cn.js'/]"></script>
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
        <form class="form-horizontal" id="message-form" action="/messages/create.htm" method="post"
              data-parsley-validate>

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
                    <script id="editor" type="text/plain" name="content"
                            style="width:100%;height:300px;">${command.content!}</script>
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
                        <button type="button" class="btn btn-primary role-modal-search-modal" data-toggle="modal">
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
                        <button type="button" class="btn btn-primary account-modal-search-modal" data-toggle="modal">
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
                            <button class="btn margin-top-15 btn-success role-modal-search-hide-modal">确定</button>
                            <button class="btn margin-top-15 btn-danger role-selector-remove-all">删除全部</button>
                            <div class="role-selector-box-data"></div>
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
                            <button class="btn margin-top-15 btn-success account-modal-search-hide-modal">确定</button>
                            <button class="btn margin-top-15 btn-danger account-selector-remove-all">删除全部</button>
                            <div class="account-selector-box-data">

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

    $(".account-send").hide("fast");
    $("input[name='sendType']").on("click", function () {
        if ($(this).val() == "role") {
            $(".role-send").show("fast");
            $(".account-send").hide("fast");
            $(_accountDate).find("ul").empty()
            _accountModel._removeAll()
        } else {
            $(".account-send").show("fast");
            $(".role-send").hide("fast");
            $(_roleData).find("ul").empty()
            _roleModel._removeAll();
        }
    });

    //选中角色弹窗
    var _roleModel = new ModalSearch({
        url: "/role/list",
        pageSize: 6,
        isSingle: false,
        id: "role-modalSearch",
        openModalClass: ".role-modal-search-modal",
        hideModalClass: ".role-modal-search-hide-modal",
        removeAllClass: ".role-selector-remove-all",
        selectorBoxClass: ".role-selector-box-data",
        headers: ['角色名称', '角色描述', 'AppKey'],
        rowDataName: ["name", "description", "appKey.name"],
        selectorDateName: ["name"],
        hideModalHandler: function (jsonDataArr) {
            var ul_list = _roleData.find("ul");
            ul_list.empty();
            $.each(jsonDataArr, function (a, b) {
                ul_list.append("<li><div class=\"col-md-12 contract-box\">" + b.name + "-----" + b.description + "</div><input type=\"hidden\" name=\"roles\" value=\"" + b.id + "\"/></li>");
            })
        }
    });

    //选中账户弹窗
    var _accountModel = new ModalSearch({
        url: "/account/list",
        pageSize: 6,
        isSingle: false,
        id: "account-modalSearch",
        openModalClass: ".account-modal-search-modal",
        hideModalClass: ".account-modal-search-hide-modal",
        removeAllClass: ".account-selector-remove-all",
        selectorBoxClass: ".account-selector-box-data",
        headers: ['账户名称', 'AppKey'],
        rowDataName: ["userName", "appKey.name"],
        selectorDateName: ["userName"],
        hideModalHandler: function (jsonDataArr) {
            var ul_list = _accountDate.find("ul");
            ul_list.empty();
            $.each(jsonDataArr, function (a, b) {
                ul_list.append("<li><div class=\"col-md-12 contract-box\">" + b.userName + "-----" + b.appKey.name + "</div><input type=\"hidden\" name=\"receiveAccounts\" value=\"" + b.id + "\"/></li>");
            })
        }
    });

    var _roleData = $(".role-list");
    _roleData.slimScroll({
        height: '300px'
    });
    var _accountDate = $(".account-list");
    _accountDate.slimScroll({
        height: '300px'
    });

    var ue = UE.getEditor('editor');
    $("#message-form").submit(function () {
        if (UE.getEditor('editor').hasContents() == false) {
            layer.msg("请输入站内信内容!！");
            return false;
        }
        if ($('input:radio[name="sendType"]:checked').val() == "role") {
            var data = $("input[name='roles']");
            if (data.length <= 0) {
                layer.msg("请选择要发送的角色");
                return false;
            }
        } else {
            var data = $("input[name='receiveAccounts']");
            if (data.length <= 0) {
                layer.msg("请选择要发送的用户");
                return false;
            }
        }

    })
</script>
[/@override]
[@extends name="/decorator.ftl"/]