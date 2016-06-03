[@override name="title"]站内信 - 站内信查看[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/messages/pagination.htm">所有站内信</a></li>
    <li>站内信查看</li>
</ul>
[/@override]

[@override name="headerText"]
站内信 查看
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-12">
        <ul class="contract-show">
            <li>
                <span class="col-md-3">信息标题</span>
                <div class="col-md-8 contract-box">${messages.title!}</div>
            </li>
            <li>
                <span class="col-md-3">信息内容</span>
                <div class="col-md-8 contract-box">${messages.content!}</div>
            </li>
            <li>
                <span class="col-md-3">发送时间</span>
                <div class="col-md-8 contract-box">[@mc.dateShow messages.sendDate /]</div>
            </li>
            <li>
                <span class="col-md-3">发送人</span>
                <div class="col-md-8 contract-box">${messages.senderAccount.userName!}</div>
            </li>
            <li>
                <span class="col-md-3">接收人</span>
                <div class="col-md-8">
                    <div class="data-list margin-md">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>用户名</th>
                                <th>状态</th>
                            </tr>
                            </thead>
                            <tbody>
                                [#if messages.handMessagesList??]
                                    [#list messages.handMessagesList as handMessages]
                                    <tr>
                                        <td>${handMessages.receiveAccount.userName!}</td>
                                        <td>${(handMessages.readStatus.getName())!}</td>
                                    </tr>
                                    [/#list]
                                [/#if]
                            </tbody>
                        </table>
                    </div>
                </div>
            </li>
            <div>
                <div class="col-sm-offset-6 col-sm-12">
                    <a href="[@spring.url '/messages/pagination.htm' /]" class="btn btn-default">返回列表</a>
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