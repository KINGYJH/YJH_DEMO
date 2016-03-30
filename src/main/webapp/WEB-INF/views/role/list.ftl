[@override name="title"]角色管理-角色列表[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="contentTitle"]
<li class="am-active">角色列表</li>
[/@override]

[@override name="content"]
<div class="am-g">
    <div class="am-u-sm-12 am-u-md-3">
        <div class="am-form-group">
            <select data-am-selected="{btnSize: 'sm'}">
                <option value="option1">所有类别</option>
                <option value="option2">IT业界</option>
                <option value="option3">数码产品</option>
                <option value="option3">笔记本电脑</option>
                <option value="option3">平板电脑</option>
                <option value="option3">只能手机</option>
                <option value="option3">超极本</option>
            </select>
        </div>
    </div>
    <div class="am-u-sm-12 am-u-md-3">
        <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
        </div>
    </div>
</div>

<div class="am-g">
    <div class="am-u-sm-12">
        <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main am-text-center">
                <thead class="am-text-center">
                <tr>
                    <th>角色名</th>
                    <th>角色key</th>
                    <th>角色描述</th>
                    <th>角色状态</th>
                    <th>角色访问资源集合</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    [#if pagination.data??]
                        [#list pagination.data as role ]
                        <tr>
                            <td>${role.roleName!}</td>
                            <td>${role.roleKey!}</td>
                            <td>${role.description!}</td>
                            <td>${(role.status.getName())!}</td>
                            <td></td>
                            <td>
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <a href="[@spring.url '/role/edit.htm/${role.id!}'/]" class="am-btn am-btn-default am-btn-secondary am-btn-xs"><span class="am-icon-pencil-square-o"></span> 编辑</a>
                                        <a href="[@spring.url '/role/show.htm/${role.id!}'/]" class="am-btn am-btn-default am-btn-success am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 查看</a>
                                        [#if role.status == "ENABLE"]
                                            <a href="[@spring.url '/role/updateStatus.htm/${role.id!}&${role.version!}'/]" class="am-btn am-btn-default am-btn-danger am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 禁用</a>
                                        [#else]
                                            <a href="[@spring.url '/role/updateStatus.htm/${role.id!}&${role.version!}'/]" class="am-btn am-btn-default am-btn-danger am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 启用</a>
                                        [/#if]
                                    </div>
                                </div>
                            </td>
                        </tr>
                        [/#list]
                    [/#if]
                </tbody>
            </table>
            <div class="am-cf">
                共 15 条记录
                <div class="am-fr">
                    <ul class="am-pagination">
                        <li class="am-disabled"><a href="#">«</a></li>
                        <li class="am-active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">»</a></li>
                    </ul>
                </div>
            </div>
            <hr />
            <p>注：.....</p>
        </form>
    </div>

</div>
[/@override]

[@override name="bottomResources"]
[@super /]

[/@override]
[@extends name="/decorator.ftl"/]