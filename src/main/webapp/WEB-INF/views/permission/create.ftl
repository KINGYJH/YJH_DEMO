[@override name="title"]访问资源管理-创建访问资源[/@override]
[@override name="topResources"]

    [@super /]
[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/resource/list.htm'/]">访问资源管理</a></li>
<li class="am-active">创建访问资源</li>
[/@override]

[@override name="content"]
<div class="am-g">

    <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">

        <h1>*为必填项</h1>
    </div>

    <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        [@mc.showAlert /]
        <form action="[@spring.url '/resource/create.htm'/]" class="am-form" id="doc-vld-msg" method="post">

            [@spring.bind "command.resName"/]
            <div class="am-form-group">
                <label for="doc-vld-resName-2-1">资源名*：</label>
                <input type="text" id="doc-vld-resName-2-1" minlength="1" name="resName" value="${command.resName!}"
                       placeholder="输入资源名" required/>
                [@spring.showErrors "resName"/]
            </div>

            [@spring.bind "command.resKey"/]
            <div class="am-form-group">
                <label for="doc-vld-resKey-2-1">资源key*：</label>
                <input type="text" id="doc-vld-resKey-2-1" minlength="1" name="resKey" value="${command.resKey!}"
                       placeholder="输入资源key" required/>
                [@spring.showErrors "resKey"/]
            </div>

            [@spring.bind "command.resUrl"/]
            <div class="am-form-group">
                <label for="doc-vld-resUrl-2-1">资源url*：</label>
                <input type="text" id="doc-vld-resUrl-2-1" minlength="1" name="resUrl" value="${command.resUrl}"
                       placeholder="输入资源url" required/>
                [@spring.showErrors "resUrl"/]
            </div>

            [@spring.bind "command.level"/]
            <div class="am-form-group">
                <label for="doc-vld-password-2-1">资源等级*：</label>
                <input type="number" id="doc-vld-password-2-1" name="level" minlength="1" value="${command.level!}"
                       placeholder="输入资源等级" required/>
                [@spring.showErrors "level"/]
            </div>

            [@spring.bind "command.description"/]
            <div class="am-form-group">
                <label for="doc-vld-description-2-1">资源描述：</label>
                <input type="text" id="doc-vld-description-2-1" name="description" minlength="1" value="${command.description!}"
                       placeholder="输入资源描述" required/>
                [@spring.showErrors "description"/]
            </div>

            <br>
            [@spring.bind "command.type"/]
            <div class="am-form-group">
                <label for="doc-vld-status-2-1">资源类型*：</label>
                <select name="type" id="doc-vld-status-2-1" data-am-selected="{dropUp: 1}" required>
                    [#assign type = (command.type!)?default("") /]
                    <option value="">请选择</option>
                    <option value="DIRECTORY" [@mc.selected type "DIRECTORY" /]>目录</option>
                    <option value="MENU" [@mc.selected type "MENU" /]>菜单</option>
                    <option value="BUTTON" [@mc.selected type "BUTTON" /]>按钮</option>
                </select>
                [@spring.showErrors "type"/]
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
<script>
    $(function() {
        $('#doc-vld-msg').validator({
            onValid: function(validity) {
                $(validity.field).closest('.am-form-group').find('.am-alert').hide();
            },

            onInValid: function(validity) {
                var $field = $(validity.field);
                var $group = $field.closest('.am-form-group');
                var $alert = $group.find('.am-alert');
                // 使用自定义的提示信息 或 插件内置的提示信息
                var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

                if (!$alert.length) {
                    $alert = $('<div class="am-alert am-alert-danger"></div>').hide().
                    appendTo($group);
                }

                $alert.html(msg).show();
            }
        });
    });
</script>
[/@override]

[@extends name="/decorator.ftl"/]