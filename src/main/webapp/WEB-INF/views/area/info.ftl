[@override name="title"]区域管理 - 区域查看[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/area/pagination.htm">区域管理</a></li>
    <li>区域查看</li>
</ul>
[/@override]

[@override name="headerText"]
区域 查看
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-12">
        <ul class="contract-show">
            <li>
                <span class="col-md-3">区域名称</span>
                <div class="col-md-8 contract-box">${area.name!}</div>
            </li>
            <li>
                <span class="col-md-3">区域简称</span>
                <div class="col-md-8 contract-box">${area.shortName!}</div>
            </li>
            <li>
                <span class="col-md-3">父级区域</span>
                <div class="col-md-8 contract-box">${area.parent.name!}</div>
            </li>
            <li>
                <span class="col-md-3">区域排序值</span>
                <div class="col-md-8 contract-box">${area.sort!}</div>
            </li>
            <li>
                <span class="col-md-3">区域创建时间</span>
                <div class="col-md-8 contract-box">[@mc.dateShow area.createDate /]</div>
            </li>
            <li>
                <span class="col-md-3">区域经度</span>
                <div class="col-md-8 contract-box">${area.longitude!}</div>
            </li>
            <li>
                <span class="col-md-3">区域纬度</span>
                <div class="col-md-8 contract-box">${area.latitude!}</div>
            </li>
            <li>
                <span class="col-md-3">区域等级</span>
                <div class="col-md-8 contract-box">${(area.level.getName())!}</div>
            </li>
            <li>
                <span class="col-md-3">区域状态</span>
                <div class="col-md-8 contract-box">${(area.status.getName())!}</div>
            </li>
            <div>
                <div class="col-sm-offset-6 col-sm-12">
                    <a href="[@spring.url '/area/create.htm' /]" class="btn btn-success">再创建一个</a>
                    <a href="[@spring.url '/area/pagination.htm' /]" class="btn btn-default">返回列表</a>
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