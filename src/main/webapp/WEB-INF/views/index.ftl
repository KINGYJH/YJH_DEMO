[@override name="title"]首页控制台[/@override]

[@override name="topResources"]
    [@super /]
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
    <h1>内容整理中。。。。。。。。</h1>
    <button class="btn btn-warning modal-search-modal" data-toggle="modal">Large modal</button>
    <div class="show-permission"></div>
</div>

<div class="modal fade" id="appKey-modalSearch">
    <div class="modal-content">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <p class="modal-title">XX列表--勾选添加到已选XX列表
                    <small class="text-muted"></small>
                </p>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-9 input-list">
                        <!-- 查询表单 -->
                        <form class="form-inline margin-md" role="form" action="[@spring.url '/app_key/list' /]">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="appKeyName">AppKey名称</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" id="appKeyName"
                                           name="appKeyName" value="${command.name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-6" for="appKey-name">AppKey状态</label>
                                <div class="col-md-6">
                                    <select name="status" id class="form-control">
                                        [#assign status = (command.status!)?default("") /]
                                        <option value="">全部</option>
                                        <option value="ENABLE" [@mc.selected status "ENABLE" /]>启用</option>
                                        <option value="DISABLE" [@mc.selected status "DISABLE" /]>禁用</option>
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
                                <small class="inline table-options paging-info paging-permission">
                                </small>
                            </div>
                            <div class="col-sm-4 text-right sm-center">
                                <ul class="pagination pagination-xs nomargin pagination-custom pagination-permission">
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
</div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/modal-search-optimize.js'/]"></script>
<script>
    $(document).ready(function () {
        var showTdPermission = $(".show-permission");
        var modalSearch = new ModalSearch({
            url: "/app_key/list",
            pageSize : 6,
            isSingle : true,
            id:"appKey-modalSearch",
            header :['AppKey名称','AppKey描述','AppKey项目名称'],
            rowData :["name", "description","projectName"],
            selectorData : ["name"],
            hideModalHandler : function(jsonDataArr){
                showTdPermission.empty();
                for (var key in jsonDataArr) {
                    logger.info(jsonDataArr[key]);
                    showTdPermission.append("<div class=\"check-td-info\">" + jsonDataArr[key].name + "</div>");
                    showTdPermission.append("<input type=\"hidden\" name=\"permissionIds\" value=\"" + jsonDataArr[key].id + "\"/>")
                };
            }
        });
    })
</script>
[/@override]
[@extends name="/decorator.ftl"/]
