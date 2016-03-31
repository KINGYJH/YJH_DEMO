[@override name="title"]AppKey管理-查看AppKey[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/app_key/pagination.htm'/]">AppKey管理</a></li>
<li class="am-active">查看AppKey</li>
[/@override]

[@override name="content"]
<div class="am-g">
    [@mc.showAlert /]
    <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        啦啦啦啦啦啦啦啦
    </div>

    <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <ul class="am-list am-list-static am-list-border am-list-striped">
            <li>
                <div class="am-g">
                    <span class="am-u-sm-6 am-lg-text-right">AppKey名称 :</span>
                    <div class="am-u-sm-6">${appKey.name!!}</div>
                </div>
            </li>

            <li>
                <div class="am-g">
                    <span class="am-u-sm-6 am-lg-text-right">AppKey描述 :</span>
                    <div class="am-u-sm-6">${appKey.description!}</div>
                </div>
            </li>

            <li>
                <div class="am-g">
                    <span class="am-u-sm-6 am-lg-text-right">AppKey项目名 :</span>
                    <div class="am-u-sm-6">${appKey.projectName!}</div>
                </div>
            </li>

            <li>
                <div class="am-g">
                    <span class="am-u-sm-6 am-lg-text-right">AppKey状态 :</span>
                    <div class="am-u-sm-6">${(appKey.status.getName())!}</div>
                </div>
            </li>

            <li>
                <div class="am-g">
                    <div class="am-u-sm-12 am-text-center">
                        <a class="am-btn am-btn-default am-round am-btn-secondary"
                           href="[@spring.url '/app_key/create.htm'/]">在创建一个</a>
                        <a class="am-btn am-btn-default am-round am-btn-success"
                           href="[@spring.url '/app_key/pagination.htm'/]">返回列表</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]

[/@override]
[@extends name="/decorator.ftl"/]
