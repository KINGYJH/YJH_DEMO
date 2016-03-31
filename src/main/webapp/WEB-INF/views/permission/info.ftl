[@override name="title"]访问资源管理-查看访问资源[/@override]
[@override name="topResources"]

    [@super /]
[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/resource/list.htm'/]">访问资源管理</a></li>
<li class="am-active">查看访问资源</li>
[/@override]

[@override name="content"]
<div class="am-g">
    [@mc.showAlert /]
    <ul class="am-list am-list-static am-list-border">
        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">访问资源名称 : </div>
                <div class="am-u-sm-6">${resource.resName!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">访问资源key : </div>
                <div class="am-u-sm-6">${resource.resKey!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">访问资源Url : </div>
                <div class="am-u-sm-6">${resource.resUrl!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">访问资源类型 : </div>
                <div class="am-u-sm-6">${(resource.type.getName())!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">访问资源等级 : </div>
                <div class="am-u-sm-6">${resource.level!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">父级访问资源 : </div>
                <div class="am-u-sm-6"></div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-1 am-u-sm-centered">
                    <a class="am-btn am-btn-default am-round am-btn-success" href="[@spring.url '/resource/list.htm'/]">返回列表</a>
                </div>
            </div>
        </li>
    </ul>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]

[/@override]
[@extends name="/decorator.ftl"/]