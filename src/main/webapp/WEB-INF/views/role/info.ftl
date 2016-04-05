[@override name="title"]权限管理 - 角色查看[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/role/pagination.htm">角色管理</a></li>
    <li>角色查看</li>
</ul>
[/@override]

[@override name="headerText"]
角色 查看
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-12">
        <ul class="contract-show">
            <li>
                <span class="col-md-3">角色名称</span>
                <div class="col-md-8 contract-box">${role.name!}</div>
            </li>
            <li>
                <span class="col-md-3">权限描述</span>
                <div class="col-md-8 contract-box">${role.description!}</div>
            </li>
            <li>
                <span class="col-md-3">appKey</span>
                <div class="col-md-8 contract-box">${role.appKey.name!}</div>
            </li>
            <li>
                <span class="col-md-3">角色最近更新时间</span>
                <div class="col-md-8 contract-box">${role.updateDate?datetime!}</div>
            </li>
            <li>
                <span class="col-md-3">角色状态</span>
                <div class="col-md-8 contract-box">${(role.status.getName())!}</div>
            </li>
            <li>
                <span class="col-md-3">角色权限</span>
                <div class="col-md-8 margin-md">
                    <div class="data-list">
                    <ul class="contract-show margin-sm">
                        [#if role.permissions??]
                            [#list role.permissions as permission]
                                <li>
                                    <div class="col-md-12 contract-box">${permission.name!}
                                        -----${permission.description!}</div>
                                </li>
                            [/#list]
                        [/#if]
                    </ul>
                    </div>
                </div>
            </li>
            <div>
                <div class="col-sm-offset-6 col-sm-12">
                    <a href="[@spring.url '/role/create.htm' /]" class="btn btn-success">再创建一个</a>
                    <a href="[@spring.url '/role/pagination.htm' /]" class="btn btn-default">返回列表</a>
                </div>
            </div>
        </ul>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script type="text/javascript">
    var data_list = $(".data-list");
    data_list.slimScroll({
        height: '600px'
    });
</script>
[/@override]
[@extends name="/decorator.ftl"/]