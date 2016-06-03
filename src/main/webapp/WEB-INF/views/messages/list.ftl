[@override name="title"]站内信[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li>站内信</li>
</ul>
[/@override]

[@override name="headerText"]
站内信
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="inbox-wrapper">
        <div class="inbox-menu">
            <div class="inbox-menu-inner">
                <ul>
                    <li>
                        <a href="/messages/pagination.htm">
                            <span class="badge badge-success m-right-xs">5</span>
                            收件箱
                        </a>
                    </li>
                    <li>
                        <a href="/messages/create.htm">
                            发送站内信
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="inbox-body padding-md">
            <div class="pagination-row clearfix m-bottom-md">
                <div class="pull-left vertical-middle hidden-xs">112 messages</div>
                <div class="pull-right pull-left-sm">
                    <div class="inline-block vertical-middle m-right-xs">Page 1 of 8</div>
                    <ul class="pagination vertical-middle">
                        <li class="disabled"><a href="#"><i class="fa fa-step-backward"></i></a></li>
                        <li class="disabled"><a href="#"><i class="fa fa-caret-left large"></i></a></li>
                        <li><a href="#"><i class="fa fa-caret-right large"></i></a></li>
                        <li><a href="#"><i class="fa fa-step-forward"></i></a></li>
                    </ul>
                </div>
            </div>

            <div class="message-table table-responsive">
                <table class="table table-bordereds">
                    <thead>
                    <tr>
                        <th class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" id="chkAll" class="inbox-check">
                                <label for="chkAll"></label>
                            </div>
                        </th>
                        <th></th>
                        <th>发送人</th>
                        <th>信息</th>
                        <th>发送时间</th>
                    </tr>
                    </thead>
                    <tbody>
                        [#if pagination.data??]
                            [#list pagination.data as message ]
                            <tr>
                                <td class="text-center">
                                    <div class="custom-checkbox">
                                        <input type="checkbox" id="chk5" class="inbox-check">
                                        <label for="chk5"></label>
                                    </div>
                                </td>
                            <td>
                                [#if message.readStatus == "UNREAD"]
                                    <a href="#"><i class="fa fa-envelope fa-lg"></i></a></td>
                                [#else]
                                    <a href="#"><i class="fa fa-envelope-o fa-lg"></i></a>
                                [/#if]
                                </td>
                                <td>
                                    <div class="author-avatar">
                                        <img src="${message.senderAccount.headPic.picPath!}" alt="">
                                    </div>
                                    <div class="author-name">
                                        <strong class="block font-md">${message.senderAccount.userName!}</strong>
                                        <aclass
                                        ="text-muted">${message.senderAccount.roles[0].name!}</a>
                                    </div>
                                </td>
                                <td>
                                    <a href="#">
                                    ${message.messages.title!}
                                    </a>
                                </td>
                                <td>${message.createDate!}</td>
                            </tr>
                            [/#list]
                        [/#if]
                    </tbody>
                </table>
            </div>
            <div class="pagination-row clearfix">
                <div class="pull-left vertical-middle hidden-xs">112 messages</div>
                <div class="pull-right pull-left-sm">
                    <div class="inline-block vertical-middle m-right-xs">Page 1 of 8</div>
                    <ul class="pagination vertical-middle">
                        <li class="disabled"><a href="#"><i class="fa fa-step-backward"></i></a></li>
                        <li class="disabled"><a href="#"><i class="fa fa-caret-left large"></i></a></li>
                        <li><a href="#"><i class="fa fa-caret-right large"></i></a></li>
                        <li><a href="#"><i class="fa fa-step-forward"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
    [#include 'shared/confirmation.ftl'/]
[/@override]

[@override name="bottomResources"]
    [@super /]
<!-- Datepicker 时间选择js -->
<script src="[@spring.url '/resources/js/uncompressed/datepicker.js'/]"></script>
[/@override]
[@extends name="/decorator.ftl"/]