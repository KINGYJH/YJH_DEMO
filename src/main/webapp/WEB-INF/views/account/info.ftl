[@override name="title"]用户管理 - 用户查看[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/account/pagination.htm">用户管理</a></li>
    <li>用户查看</li>
</ul>
[/@override]

[@override name="headerText"]
用户 查看
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-12">
        <ul class="contract-show">
            <li>
                <span class="col-md-3">用户名</span>
                <div class="col-md-8 contract-box">${account.userName!}</div>
            </li>
            <li>
                <span class="col-md-3">创建时间</span>
                <div class="col-md-8 contract-box">[@mc.dateShow account.createDate/]</div>
            </li>
            <li>
                <span class="col-md-3">角色</span>
                <div class="col-md-8 contract-box">${account.roles[0].name!}</div>
            </li>
            <li>
                <span class="col-md-3">最后登录IP</span>
                <div class="col-md-8 contract-box">${account.lastLoginIP!}</div>
            </li>
            <li>
                <span class="col-md-3">最后登录时间</span>
                <div class="col-md-8 contract-box">[@mc.dateShow account.lastLoginDate/]</div>
            </li>
            <li>
                <span class="col-md-3">最后登录平台</span>
                <div class="col-md-8 contract-box">${account.lastLoginPlatform!}</div>
            </li>
            <li>
                <span class="col-md-3">AppKey</span>
                <div class="col-md-8 contract-box">${account.appKey.name!}</div>
            </li>
            <li>
                <span class="col-md-3">用户状态</span>
                <div class="col-md-8 contract-box">${(account.status.getName())!}</div>
            </li>
            <div>
                <div class="col-sm-offset-6 col-sm-12">
                    <a href="[@spring.url '/account/create.htm' /]" class="btn btn-success">再创建一个</a>
                    <a href="[@spring.url '/account/pagination.htm' /]" class="btn btn-default">返回列表</a>
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