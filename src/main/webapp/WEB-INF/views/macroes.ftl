[#-- 显示提示消息 --]
[#macro showAlert]
    [#if alertMessage?? && (alertMessage.type)??]
        [#switch alertMessage.type.getValue()]
            [#case 0]
                [#local alertClass = "alert-success"]
                [#break]
            [#case 1]
                [#local alertClass = "alert-info"]
                [#break]
            [#case 2]
                [#local alertClass = "alert-warning"]
                [#break]
            [#case 3]
                [#local alertClass = "alert-danger"]
                [#break]
        [/#switch]
    <div class="alert ${alertClass} alert-custom alert-dismissible show-alert" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
        <i class="fa fa-check-circle m-right-xs"></i><strong>${alertMessage.type.getName()}</strong> ${alertMessage.message}
        <i><span class="pull-right time-message">5秒后制动关闭</span></i>
    </div>
    [/#if]
[/#macro]

[#--用于表单元素是否选中的判断--]
[#macro selected src target]
    [#if src == target]
    selected="selected"
    [/#if]
[/#macro]

[#--//TODO with parameters--]
[#macro showPagination path]
<div class="row">
    <section class="col-md-12">
        [#local totalPage = (pagination.count / pagination.pageSize)?ceiling]

        [#if path?contains("?")]
            [#local basePath = path + '&pageSize=' + pagination.pageSize + '&page=']
        [#else]
            [#local basePath = path + '?pageSize=' + pagination.pageSize + '&page=']
        [/#if]

        [#if pagination.data?size > 0]
            <div class="col-md-6">
                <div class="dataTables_info">总计 ${pagination.count} 条数据, 每页显示${pagination.pageSize}条,总计 ${totalPage}页</div>
            </div>
            <div class="col-md-6">
                <ul class="pagination pull-right">
                    [#if pagination.page - 1 <= 0]
                        <li class="disabled"><a href="#">«</a></li>
                    [#else]
                        <li><a href="[@spring.url basePath + (pagination.page - 1)/]">«</a></li>
                    [/#if]

                    [#list 1..totalPage as index]
                        [#if totalPage < 11]
                            [#if pagination.page == index]
                                <li class="active"><a href="#">${index}</a></li>
                            [#else]
                                <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                            [/#if]
                        [#else]
                            [#if (index > (pagination.page - 5)) && (index < (pagination.page + 4))]
                                [#if pagination.page == index]
                                    <li class="active"><a href="#">${index}</a></li>
                                [#else]
                                    <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                                [/#if]
                            [/#if]
                        [/#if]
                    [/#list]

                    [#if pagination.page == totalPage]
                        <li class="disabled"><a href="#">»</a></li>
                    [#else]
                        <li><a href="[@spring.url basePath + (pagination.page + 1)/]">»</a></li>
                    [/#if]
                </ul>
            </div>
        [#else]
            <div class="col-md-2 col-md-offset-5">
                <Strong>没有查询到数据</Strong>
            </div>
        [/#if]
</div>
[/#macro]

[#macro verificationCode id="verificationCode"]
<img id="${id}" src="[@spring.url '/verificationCode'/]" title="点击可切换" class="verificationCode"/>
<script type="text/javascript">
    $(function () {
        $("#${id}").on('click', function (e) {
            var act = "[@spring.url '/verificationCode'/]";
            $(this).attr("src", act + "?" + new Date().getTime());
        }).mouseover(function () {
            $(this).css("cursor", "pointer");
        });
    });
</script>
[/#macro]