[@override name="title"]AppKey管理-AppKey列表[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="contentTitle"]
<li class="am-active">AppKey列表</li>
[/@override]

[@override name="content"]
    [@mc.showAlert /]
<div class="am-g am-padding-bottom">
    <form class="am-form-inline" role="form">
        <div class="am-u-md-12">
            <div class="am-u-sm-3">
                <div class="am-form-group">
                    <div class="am-u-md-5">
                        <label for="name" class="control-label">AppKey名称</label>
                    </div>
                    <div class="am-u-md-7">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${command.name!}"/>
                    </div>
                </div>
            </div>
            <div class="am-u-sm-3">
                <div class="am-form-group">
                    <div class="am-u-md-7">
                        <label for="status" class="control-label">AppKey状态</label>
                    </div>
                    <div class="am-u-md-5">
                        <select name="status" id="status">
                            [#assign status = (command.status!)?default("") /]
                            <option value="">请选择</option>
                            <option value="ENABLE" [@mc.selected status "ENABLE" /]>启用</option>
                            <option value="DISABLE" [@mc.selected status "DISABLE" /]>禁用</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="am-u-sm-6">
                <button type="submit" class="am-btn am-btn-primary">查询</button>
            </div>
        </div>
    </form>
</div>

<div class="am-g">
    <div class="am-u-sm-12">
        <table class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover am-text-center">
            <thead>
            <tr>
                <th>AppKey名称</th>
                <th>AppKey描述</th>
                <th>AppKey项目名</th>
                <th>AppKey状态</th>
                <th>数据最近更新时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                [#if pagination.data??]
                    [#list pagination.data as appKey ]
                    <tr>
                        <td>${appKey.name!}</td>
                        <td>${appKey.description!}</td>
                        <td>${appKey.projectName!}</td>
                        <td>${(appKey.status.getName())!}</td>
                        <td>${appKey.updateDate?datetime!}</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <a href="[@spring.url '/app_key/edit.htm/${appKey.id!}'/]"
                                       class="am-btn am-btn-default am-btn-secondary am-btn-xs"><span
                                            class="am-icon-pencil-square-o"></span> 编辑</a>
                                    <a href="[@spring.url '/app_key/info.htm/${appKey.id!}'/]"
                                       class="am-btn am-btn-default am-btn-success am-btn-xs am-hide-sm-only"><span
                                            class="am-icon-copy"></span> 查看</a>
                                    [#if appKey.status == "ENABLE"]
                                        <a href="[@spring.url '/app_key/update_status.htm?id=${appKey.id!}&version=${appKey.version!}'/]"
                                           class="am-btn am-btn-default am-btn-danger am-btn-xs am-hide-sm-only"><span
                                                class="am-icon-copy"></span> 禁用</a>
                                    [#else]
                                        <a href="[@spring.url '/app_key/update_status.htm?id=${appKey.id!}&version=${appKey.version!}'/]"
                                           class="am-btn am-btn-default am-btn-danger am-btn-xs am-hide-sm-only"><span
                                                class="am-icon-copy"></span> 启用</a>
                                    [/#if]
                                </div>
                            </div>
                        </td>
                    </tr>
                    [/#list]
                [/#if]
            </tbody>
        </table>
        [#if pagination!]
            [@mc.showPagination '/app_key/pagination.htm?' /]
        [/#if]
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]

[/@override]
[@extends name="/decorator.ftl"/]