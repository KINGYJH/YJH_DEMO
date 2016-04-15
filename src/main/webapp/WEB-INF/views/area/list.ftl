[@override name="title"]区域管理[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li>区域管理</li>
</ul>
[/@override]

[@override name="headerText"]
区域 管理
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row margin-md">
    <a href="/area/create.htm" class="btn btn-md btn-success">新增区域</a>
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
                <label for="name" class="control-label">区域名称</label>
                <input type="text" class="form-control" id="name" name="name" value="${command.name!}"
                       placeholder="角色名称"/>
            </div>
            <div class="form-group">
                <label for="status" class="control-label">区域等级</label>
                <select name="level" id class="form-control">
                    [#assign level = (command.level!)?default("") /]
                    <option value="ALL" [@mc.selected status "ALL" /]>全部</option>
                    <option value="PROVINCE_MUNICIPALITY" [@mc.selected level "PROVINCE_MUNICIPALITY" /]>省/直辖市</option>
                    <option value="MUNICIPAL" [@mc.selected level "MUNICIPAL" /]>地级市</option>
                    <option value="COUNTY" [@mc.selected level "COUNTY" /]>区县</option>
                    <option value="TOWN_STREET" [@mc.selected level "TOWN_STREET" /]>镇/街道</option>
                </select>
            </div>
            <div class="form-group">
                <label for="status" class="control-label">区域状态</label>
                <select name="status" id class="form-control">
                    [#assign status = (command.status!)?default("") /]
                    <option value="ALL" [@mc.selected status "ALL" /]>全部</option>
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
                            <th>区域名称</th>
                            <th>区域简称</th>
                            <th>经度</th>
                            <th>纬度</th>
                            <th>上级区域</th>
                            <th>区域等级</th>
                            <th>区域状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            [#if pagination.data??]
                                [#list pagination.data as area ]
                                <tr>
                                    <td>${area.name!}</td>
                                    <td>${area.shortName!}</td>
                                    <td>${area.longitude!}</td>
                                    <td>${area.latitude!}</td>
                                    <td>${area.parent.name!}</td>
                                    <td>${(area.level.getName())!}</td>
                                    <td>${(area.status.getName())!}</td>
                                    <td>
                                        <a href="[@spring.url '/area/info.htm/${area.id!}'/]"
                                           data-toggle="tooltip" data-placement="top" title="点击查看详情">
                                            <span class="label label-info">查看</span>
                                        </a>
                                        <a href="[@spring.url '/area/edit.htm/${area.id!}'/]"
                                           data-toggle="tooltip" data-placement="top" title="点击修改信息">
                                            <span class="label label-success">修改</span>
                                        </a>
                                        [#if area.status == "ENABLE"]
                                            <a href="[@spring.url '/area/update_status?id=${area.id!}&version=${area.version!}'/]"
                                               data-toggle="tooltip" data-placement="top" title="点击禁用此数据">
                                                <span class="label label-danger">禁用</span>
                                            </a>
                                        [#else]
                                            <a href="[@spring.url '/area/update_status?id=${area.id!}&version=${area.version!}'/]"
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
            [@mc.showPagination '/area/pagination.htm?name=${command.name!}&status=${command.status!}&level=${command.level!}' /]
        [/#if]
            </div>
        </div>

    </div>
</div>
    [#include 'shared/confirmation.ftl'/]
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]