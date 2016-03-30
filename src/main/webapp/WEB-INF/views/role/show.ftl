[@override name="title"]角色管理-查看角色[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/role/list.htm'/]">角色管理</a></li>
<li class="am-active">查看角色</li>
[/@override]

[@override name="content"]
<div class="am-g">
    [@mc.showAlert /]
    <ul class="am-list am-list-static am-list-border">
        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">角色名 : </div>
                <div class="am-u-sm-6">${role.roleName!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">角色key : </div>
                <div class="am-u-sm-6">${role.roleKey!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">角色描述 : </div>
                <div class="am-u-sm-6">${role.description!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">角色状态 : </div>
                <div class="am-u-sm-6">${(role.status.getName())!}</div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-5 am-text-right">角色访问资源集合 : </div>
                <div class="am-u-sm-6">
                    <ul class="am-list am-list-static am-list-border">
                        <li>123123</li>
                        <li>123123</li>
                        <li>123123</li>
                        <li>123123</li>
                    </ul>
                </div>
            </div>
        </li>

        <li>
            <div class="am-g">
                <div class="am-u-sm-1 am-u-sm-centered">
                    <a class="am-btn am-btn-default am-round am-btn-success" href="[@spring.url '/role/list.htm'/]">返回列表</a>
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
