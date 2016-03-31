[@override name="title"]用户管理-查看用户[/@override]
[@override name="topResources"]

    [@super /]
[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/user/list.htm'/]">用户管理</a></li>
<li class="am-active">查看用户</li>
[/@override]

[@override name="content"]
<div class="am-g">

    [@mc.showAlert /]
    <ul class="am-list am-list-static am-list-border">
        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">账户名 : </div>
                <div class="am-u-sm-5">${user.accountNumber!}</div>
            </div>
        </li>
        <li>
            <div class="am-g">
                <div class="am-u-sm-1 am-u-sm-centered">
                    <a class="am-btn am-btn-default am-round am-btn-success" href="[@spring.url '/user/list.htm'/]">返回列表</a>
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