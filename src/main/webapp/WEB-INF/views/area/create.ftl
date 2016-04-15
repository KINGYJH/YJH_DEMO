[@override name="title"]区域管理 - 区域创建[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/area/pagination.htm">区域管理</a></li>
    <li>区域创建</li>
</ul>
[/@override]

[@override name="headerText"]
区域 创建
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/area/create.htm" method="post" data-parsley-validate>

            [@spring.bind "command.name"/]
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">区域名称*</label>
                <div class="col-md-9">
                    <input class="form-control" id="name" name="name"
                           value="${command.name!}" placeholder="输入区域名称"
                           data-parsley-required="true" data-parsley-required-messages="区域名称不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "name" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.shortName"/]
            <div class="form-group">
                <label for="shortName" class="col-md-3 control-label">区域简称*</label>
                <div class="col-md-9">
                    <input class="form-control" id="shortName" name="shortName"
                           value="${command.shortName!}" placeholder="输入区域简称"
                           data-parsley-required="true" data-parsley-required-messages="区域简称不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "shortName" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.longitude"/]
            <div class="form-group">
                <label for="longitude" class="col-md-3 control-label">区域经度*</label>
                <div class="col-md-9">
                    <input class="form-control" id="longitude" name="longitude"
                           value="${command.longitude!}" placeholder="输入区域经度"
                           data-parsley-required="true" data-parsley-required-messages="区域经度不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "longitude" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.latitude"/]
            <div class="form-group">
                <label for="latitude" class="col-md-3 control-label">区域纬度*</label>
                <div class="col-md-9">
                    <input class="form-control" id="latitude" name="latitude"
                           value="${command.latitude!}" placeholder="输入区域纬度"
                           data-parsley-required="true" data-parsley-required-messages="区域纬度不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "latitude" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.sort"/]
            <div class="form-group">
                <label for="sort" class="col-md-3 control-label">区域排序值*</label>
                <div class="col-md-9">
                    <input class="form-control" id="sort" name="sort"
                           value="${command.sort!}" placeholder="输入区域排序值"
                           data-parsley-required="true" data-parsley-required-messages="区域排序值不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "sort" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.level"/]
            <div class="form-group">
                <label for="level" class="col-md-3 control-label">区域等级*</label>
                <div class="col-md-9">
                    <select class="form-control" name="level" id="level"
                            data-parsley-required="true" data-parsley-required-messages="请选择区域等级"
                            data-parsley-trigger="change">
                        [#assign level = (command.level!)?default("") /]
                        <option>请选择</option>
                        <option value="PROVINCE_MUNICIPALITY" [@mc.selected level "PROVINCE_MUNICIPALITY" /]>省/直辖市
                        </option>
                        <option value="MUNICIPAL" [@mc.selected level "MUNICIPAL" /]>地级市</option>
                        <option value="COUNTY" [@mc.selected level "COUNTY" /]>区县</option>
                        <option value="TOWN_STREET" [@mc.selected level "TOWN_STREET" /]>镇/街道</option>
                    </select>
                    [@spring.showErrors "level" "parsley-required"/]
                </div>
            </div>


            [@spring.bind "command.status"/]
            <div class="form-group">
                <label for="status" class="col-md-3 control-label">区域状态*</label>
                <div class="col-md-9">
                    <select class="form-control" name="status" id="status"
                            data-parsley-required="true" data-parsley-required-messages="请选择角色状态"
                            data-parsley-trigger="change">
                        [#assign status = (command.status!)?default("") /]
                        <option value="">请选择</option>
                        <option value="ENABLE" [@mc.selected status "ENABLE"/]>启用</option>
                        <option value="DISABLE" [@mc.selected status "DISABLE"/]>禁用</option>
                    </select>
                    [@spring.showErrors "status" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.parent"/]
            <div class="form-group">
                <label for="parent" class="col-md-3 control-label">父级区域</label>
                <div class="col-md-9 area-cascade">
                    <div class="col-lg-4 no-padding">
                        <select class="form-control">

                        </select>
                    </div>
                </div>
            </div>

            <div class="text-center m-top-md">
                <button type="reset" class="btn btn-default">重置</button>
                <button type="submit" class="btn btn-success">创建</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3">
        <ul class="blog-sidebar-list font-18">创建注意事项
            <li>*位必填项</li>
        </ul>
    </div>
</div>

[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/area.js'/]"></script>
<script>
    $(".area-cascade").areaCascade("parent");
</script>
[/@override]
[@extends name="/decorator.ftl"/]