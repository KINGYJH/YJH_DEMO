[@override name="title"]权限管理[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li>权限管理</li>
</ul>
[/@override]

[@override name="headerText"]
权限 管理
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row margin-md">
    <a href="/permission/create.htm" class="btn btn-md btn-success">新增权限</a>
</div>
<div class="smart-widget widget-dark-blue">
    <div class="smart-widget-header">
        <span class="smart-widget-option">
            [#--<span class="refresh-icon-animated" style="display: none;"><i--]
            [#--class="fa fa-circle-o-notch fa-spin"></i></span>--]
                <a href="#" class="widget-toggle-hidden-option"><i class="fa fa-cog"></i></a>
            <a href="#" class="widget-collapse-option" data-toggle="collapse"><i class="fa fa-chevron-up"></i></a>
            [#--<a href="#" class="widget-refresh-option"><i class="fa fa-refresh"></i></a>--]
            <a href="#" class="widget-remove-option"><i class="fa fa-times"></i></a>
        </span>
        <form class="form-inline no-margin" role="form">
            <div class="form-group">
                <label for="name" class="control-label">权限名称</label>
                <input type="text" class="form-control" id="name" name="name" value="${command.name!}"
                       placeholder="权限名称"/>
            </div>
            <div class="form-group">
                <label for="appKey" class="control-label">AppKey</label>
                <select class="form-control" id="appKey" name="appKey" data="${command.appKey!}">

                </select>
            </div>
            <div class="form-group">
                <label for="status" class="control-label">权限状态</label>
                <select name="status" id class="form-control">
                    [#assign status = (command.status!)?default("") /]
                    <option value="">全部</option>
                    <option value="ENABLE" [@mc.selected status "ENABLE" /]>启用</option>
                    <option value="DISABLE" [@mc.selected status "DISABLE" /]>禁用</option>
                </select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-md btn-success">查询</button>
            </div>
        </form>
    </div>
    <div class="smart-widget-inner">
        <div class="smart-widget-hidden-section" style="display: none;">
            <ul class="widget-color-list clearfix">
                <li style="background-color:#20232b;" data-color="widget-dark"></li>
                <li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
                <li style="background-color:#23b7e5;" data-color="widget-blue"></li>
                <li style="background-color:#2baab1;" data-color="widget-green"></li>
                <li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
                <li style="background-color:#fbc852;" data-color="widget-orange"></li>
                <li style="background-color:#e36159;" data-color="widget-red"></li>
                <li style="background-color:#7266ba;" data-color="widget-purple"></li>
                <li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
                <li style="background-color:#fff;" data-color="reset"></li>
            </ul>
        </div>
        <div class="smart-widget-body no-padding">
            <div class="padding-md">
                <section class="overflow-auto nice-scrollbar">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>权限名称</th>
                            <th>权限值</th>
                            <th>权限描述</th>
                            <th>appKey</th>
                            <th>权限最近更新时间</th>
                            <th>权限状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            [#if pagination.data??]
                                [#list pagination.data as permission ]
                                <tr>
                                    <td>${permission.name!}</td>
                                    <td>${permission.value!}</td>
                                    <td>${permission.description!}</td>
                                    <td>${permission.appKey.name!}</td>
                                    <td>${permission.updateDate?datetime}</td>
                                    <td>${(permission.status.getName())!}</td>
                                    <td>
                                        <a href="[@spring.url '/permission/info.htm/${permission.id!}'/]"
                                           data-toggle="tooltip" data-placement="top" title="点击查看详情">
                                            <span class="label label-info">查看</span>
                                        </a>
                                        <a href="[@spring.url '/permission/edit.htm/${permission.id!}'/]"
                                           data-toggle="tooltip" data-placement="top" title="点击修改信息">
                                            <span class="label label-success">修改</span>
                                        </a>
                                        [#if permission.status == "ENABLE"]
                                            <a href="[@spring.url '/permission/update_status?id=${permission.id!}&version=${permission.version!}'/]"
                                               data-toggle="tooltip" data-placement="top" title="点击禁用此数据">
                                                <span class="label label-danger">禁用</span>
                                            </a>
                                        [#else]
                                            <a href="[@spring.url '/permission/update_status?id=${permission.id!}&version=${permission.version!}'/]"
                                               data-toggle="tooltip" data-placement="top" title="点击启用此数据">
                                                <span class="label label-danger">启用</span>
                                            </a>
                                        [/#if]
                                    </td>
                                </tr>
                                [/#list]
                            [/#if]
                        </tbody>
                    </table>
                </section>
            </div>
            <div class="bg-grey">
                [#if pagination!]
            [@mc.showPagination '/permission/pagination.htm?name=${command.name!}&status=${command.status!}' /]
        [/#if]
            </div>
        </div>

    </div>
</div>
    [#include 'shared/confirmation.ftl'/]
[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/ajax.js'/]"></script>
<script type="text/javascript">
    $("#appKey").selectAjaxData({url: "/app_key/all_list"});
</script>
[/@override]
[@extends name="/decorator.ftl"/]