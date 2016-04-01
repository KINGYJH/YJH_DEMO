[@override name="title"]AppKey管理[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="headerText"]
AppKey 管理
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="smart-widget widget-purple">
    <div class="smart-widget-header">
        <span class="smart-widget-option">
            <span class="refresh-icon-animated" style="display: none;"><i
                    class="fa fa-circle-o-notch fa-spin"></i></span>
            <a href="#" class="widget-toggle-hidden-option"><i class="fa fa-cog"></i></a>
            <a href="#" class="widget-collapse-option" data-toggle="collapse"><i class="fa fa-chevron-up"></i></a>
            <a href="#" class="widget-refresh-option"><i class="fa fa-refresh"></i></a>
            <a href="#" class="widget-remove-option"><i class="fa fa-times"></i></a>
        </span>
        <form class="form-inline no-margin">
            <div class="form-group">
                <label class="sr-only">AppKey名称</label>
                <input type="text" class="form-control" name="name" value="${command.name!}" placeholder="AppKey名称"/>
            </div>
            <div class="form-group">
                <label class="sr-only">状态</label>
                <select name="status">
                    [#assign status = (command.status!)?default("") /]
                    <option value="">请选择</option>
                    <option value="ENABLE" [@mc.selected status "ENABLE" /]>启用</option>
                    <option value="DISABLE" [@mc.selected status "DISABLE" /]>禁用</option>
                </select>
            </div>
            <button type="submit" class="btn btn-sm btn-success">Sign in</button>
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
        <div class="smart-widget-body">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>AppKey名称</th>
                    <th>AppKey项目名</th>
                    <th>AppKey描述</th>
                    <th>AppKey最近更新时间</th>
                    <th>AppKey状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    [#if pagination.data??]
                        [#list pagination.data as appKey ]
                        <tr>
                            <td>${appKey.name!}</td>
                            <td>${appKey.projectName!}</td>
                            <td>${appKey.description!}</td>
                            <td>${appKey.updateDate?datetime}</td>
                            <td>${(appKey.status.getName())!}</td>
                            <td>

                            </td>
                        </tr>
                        [/#list]
                    [/#if]
                </tbody>
            </table>
            [#if pagination!]
                [@mc.showPagination '/role/list?roleName=${(command.roleName)!}&status=${(command.status)!}&appKey=${command.appKey!}' /]
            [/#if]
        </div>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]

[/@override]
[@extends name="/decorator.ftl"/]