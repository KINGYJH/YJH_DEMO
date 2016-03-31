[@override name="title"]AppKey管理-创建AppKey[/@override]
[@override name="topResources"]

    [@super /]
[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/app_key/pagination.htm'/]">AppKey管理</a></li>
<li class="am-active">创建AppKey</li>
[/@override]

[@override name="content"]
<div class="am-g">

    <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">

        <h1>*为必填项</h1>
    </div>

    <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        [@mc.showAlert /]
        <form action="[@spring.url '/app_key/create.htm'/]" class="am-form" id="doc-vld-msg" method="post">

            [@spring.bind "command.name"/]
            <div class="am-form-group">
                <label for="doc-vld-name-2-1">AppKey名*：</label>
                <input type="text" id="doc-vld-name-2-1" name="name" value="${command.name!}"
                       placeholder="输入AppKey名" minlength="1" required/>
                [@spring.showErrors "name"/]
            </div>

            [@spring.bind "command.description"/]
            <div class="am-form-group">
                <label for="doc-vld-description-2-1">AppKey描述*：</label>
                <input type="text" id="doc-vld-description-2-1" name="description"
                       value="${command.description!}" placeholder="输入AppKey描述" minlength="1" required/>
                [@spring.showErrors "description"/]
            </div>

            [@spring.bind "command.projectName"/]
            <div class="am-form-group">
                <label for="doc-vld-projectName-2-1">AppKey项目名*：</label>
                <input type="text" id="doc-vld-projectName-2-1" name="projectName"
                       value="${command.projectName}" placeholder="输入AppKey项目名" minlength="1" required/>
                [@spring.showErrors "projectName"/]
            </div>

            [@spring.bind "command.status"/]
            <div class="am-form-group">
                <label for="doc-vld-status-2-1">AppKey状态*：</label>
                <select name="status" id="doc-vld-status-2-1" required>
                    [#assign status = (command.status!)?default("") /]
                    <option value="">请选择</option>
                    <option value="ENABLE" [@mc.selected status "ENABLE" /]>启用</option>
                    <option value="DISABLE" [@mc.selected status "DISABLE" /]>禁用</option>
                </select>
                [@spring.showErrors "status"/]
            </div>


            <div class="am-form-group">
                <div class="am-u-sm-9 am-u-sm-push-3">
                    <button type="submit" class="am-btn am-btn-primary">创建</button>
                    <button type="reset" class="am-btn am-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]

[@extends name="/decorator.ftl"/]