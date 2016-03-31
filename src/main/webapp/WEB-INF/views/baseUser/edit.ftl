[@override name="title"]用户管理-编辑用户[/@override]
[@override name="topResources"]

    [@super /]
[/@override]

[@override name="contentTitle"]
<li><a href="[@spring.url '/user/list.htm'/]">用户管理</a></li>
<li class="am-active">编辑用户</li>
[/@override]

[@override name="content"]
<div class="am-g">

    <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
                <div class="am-g">
                    <div class="am-u-md-4">
                        <img class="am-img-circle am-img-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/200/h/200/q/80" alt=""/>
                    </div>
                    <div class="am-u-md-8">
                        <p>你可以使用<a href="#">gravatar.com</a>提供的头像或者使用本地上传头像。 </p>
                        <form class="am-form">
                            <div class="am-form-group">
                                <input type="file" id="user-pic">
                                <p class="am-form-help">请选择要上传的文件...</p>
                                <button type="button" class="am-btn am-btn-primary am-btn-xs">保存</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
                <div class="user-info">
                    <p>等级信息</p>
                    <div class="am-progress am-progress-sm">
                        <div class="am-progress-bar" style="width: 60%"></div>
                    </div>
                    <p class="user-info-order">当前等级：<strong>LV8</strong> 活跃天数：<strong>587</strong> 距离下一级别：<strong>160</strong></p>
                </div>
                <div class="user-info">
                    <p>信用信息</p>
                    <div class="am-progress am-progress-sm">
                        <div class="am-progress-bar am-progress-bar-success" style="width: 80%"></div>
                    </div>
                    <p class="user-info-order">信用等级：正常当前 信用积分：<strong>80</strong></p>
                </div>
            </div>
        </div>

    </div>

    <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        [@mc.showAlert /]
        <form action="[@spring.url '/user/edit.htm'/]" class="am-form" id="doc-vld-msg" method="post">
            <input type="hidden" value="${user.id!command.id}" name="id" />
            <input type="hidden" value="${user.version!command.version}" name="version" />

            [@spring.bind "command.email"/]
            <div class="am-form-group">
                <label for="doc-vld-email-2-1">邮&nbsp;箱：</label>
                <input type="email" id="doc-vld-email-2-1"  name="email" value="${user.email!command.email}"
                       placeholder="输入邮箱" data-validation-message="请输入正确的邮箱地址(列:xxxx@xx.xx)." required/>
                [@spring.showErrors "email"/]
            </div>

            <div class="am-form-group">
                <div class="am-u-sm-9 am-u-sm-push-3">
                    <button type="submit" class="am-btn am-btn-primary">提交修改</button>
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