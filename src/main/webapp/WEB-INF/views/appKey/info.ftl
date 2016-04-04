[@override name="title"]AppKey管理 - AppKey查看[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/app_key/pagination.htm">AppKey管理</a></li>
    <li>AppKey查看</li>
</ul>
[/@override]

[@override name="headerText"]
AppKey 查看
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-12">
        <ul class="contract-show">
            <li>
                <span class="col-md-3">AppKey名称</span>
                <div class="col-md-8 contract-box">${appKey.name!}</div>
            </li>
            <li>
                <span class="col-md-3">AppKey项目名</span>
                <div class="col-md-8 contract-box">${appKey.projectName!}</div>
            </li>
            <li>
                <span class="col-md-3">AppKey描述</span>
                <div class="col-md-8 contract-box">${appKey.description!}</div>
            </li>
            <li>
                <span class="col-md-3">AppKey最近更新时间</span>
                <div class="col-md-8 contract-box">${appKey.updateDate?datetime!}</div>
            </li>
            <li>
                <span class="col-md-3">AppKey状态</span>
                <div class="col-md-8 contract-box">${(appKey.status.getName())!}</div>
            </li>
            <div>
                <div class="col-sm-offset-6 col-sm-12">
                    <a href="[@spring.url '/app_key/create.htm' /]" class="btn btn-success">再创建一个</a>
                    <a href="[@spring.url '/app_key/pagination.htm' /]" class="btn btn-default">返回列表</a>
                </div>
            </div>
        </ul>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]

[/@override]
[@extends name="/decorator.ftl"/]