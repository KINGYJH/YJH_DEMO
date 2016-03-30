[@override name="title"]角色管理-创建角色[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/role/list.htm'/]">角色管理</a></li>
<li class="am-active">创建角色</li>
[/@override]

[@override name="content"]
<div class="am-g">
    <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">

        <h1>*为必填项</h1>
    </div>

    <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        [@mc.showAlert /]
        <form action="[@spring.url '/role/create.htm'/]" class="am-form" id="doc-vld-msg" method="post">

            [@spring.bind "command.roleName"/]
            <div class="am-form-group">
                <label for="doc-vld-roleName-2-1">角色名*：</label>
                <input type="text" id="doc-vld-roleName-2-1" minlength="1" name="roleName" value="${command.roleName!}"
                       placeholder="输入角色名" required/>
                [@spring.showErrors "roleName"/]
            </div>

            [@spring.bind "command.roleKey"/]
            <div class="am-form-group">
                <label for="doc-vld-roleKey-2-1">角色key*：</label>
                <input type="text" id="doc-vld-roleKey-2-1" minlength="1" name="roleKey" value="${command.roleKey!}"
                       placeholder="输入角色key" required/>
                [@spring.showErrors "roleKey"/]
            </div>

            [@spring.bind "command.description"/]
            <div class="am-form-group">
                <label for="doc-vld-description-2-1">角色描述*：</label>
                <input type="text" id="doc-vld-description-2-1" minlength="1" name="description" value="${command.description!}"
                       placeholder="输入角色描述" required/>
                [@spring.showErrors "description"/]
            </div>

            <br>
            [@spring.bind "command.status" /]
            <div class="am-form-group">
                <label for="doc-vld-status-2-1">角色状态：</label>
                <select name="status" id="doc-vld-status-2-1" data-am-selected="{dropUp: 1}" required>
                    [#assign status = (command.type!)?default("") /]
                    <option value="">请选择</option>
                    <option value="ENABLE" [@mc.selected status "ENABLE"/]>启用</option>
                    <option value="DISABLE" [@mc.selected status "DISABLE"/]>禁用</option>
                </select>
                [@spring.showErrors "command.status" /]
            </div>

            <div class="am-form-group">
                <label for="doc-vld-description-2-1">访问资源集合*：</label>
                <input type="text" readonly id="doc-vld-description-2-1" placeholder="输入访问资源集合" />
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
    $(function () {
        $('#doc-vld-msg').validator({
            onValid: function (validity) {
                $(validity.field).closest('.am-form-group').find('.am-alert').hide();
            },

            onInValid: function (validity) {
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