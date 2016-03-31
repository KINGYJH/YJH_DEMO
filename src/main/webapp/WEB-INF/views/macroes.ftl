[#-- 显示提示消息 --]
[#macro showAlert]
    [#if alertMessage?? && (alertMessage.type)??]
        [#switch alertMessage.type.getValue()]
            [#case 0]
                [#local alertClass = "am-alert-success"]
                [#break]
            [#case 1]
                [#local alertClass = "am-alert-secondary"]
                [#break]
            [#case 2]
                [#local alertClass = "am-alert-warning"]
                [#break]
            [#case 3]
                [#local alertClass = "am-alert-danger"]
                [#break]
        [/#switch]
    <div class="am-alert ${alertClass}" data-am-alert>
        <button type="button" class="am-close">&times;</button>
        <p>${alertMessage.type.getName()}:${alertMessage.message}</p>
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
<div class="tile color pagination-nice-scroll row">
    <section class="tile color am-u-sm-12">
        [#local totalPage = (pagination.count / pagination.pageSize)?ceiling]

        [#if path?contains("?")]
            [#local basePath = path + '&pageSize=' + pagination.pageSize + '&page=']
        [#else]
            [#local basePath = path + '?pageSize=' + pagination.pageSize + '&page=']
        [/#if]

        [#if pagination.data?size > 0]
            <div class="am-u-sm-6">
                <div>总计 ${pagination.count} 条数据, 每页显示${pagination.pageSize}条,总计 ${totalPage}页</div>
            </div>
            <div class="am-u-sm-6">
                <ul class="am-pagination am-pagination-right">
                    [#if pagination.page - 1 <= 0]
                        <li class="am-disabled"><a href="#">&laquo;</a></li>
                    [#else]
                        <li><a href="[@spring.url basePath + (pagination.page - 1)/]">&laquo;</a></li>
                    [/#if]

                    [#list 1..totalPage as index]
                        [#if totalPage < 11]
                            [#if pagination.page == index]
                                <li class="am-active"><a href="#">${index}</a></li>
                            [#else]
                                <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                            [/#if]
                        [#else]
                            [#if (index > (pagination.page - 5)) && (index < (pagination.page + 4))]
                                [#if pagination.page == index]
                                    <li class="am-active"><a href="#">${index}</a></li>
                                [#else]
                                    <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                                [/#if]
                            [/#if]
                        [/#if]
                    [/#list]

                    [#if pagination.page == totalPage]
                        <li class="am-disabled"><a href="#">&raquo;</a></li>
                    [#else]
                        <li><a href="[@spring.url basePath + (pagination.page + 1)/]">&raquo;</a></li>
                    [/#if]
                </ul>
            </div>
        [#else]
            <div class="am-u-md-2 am-u-md-offset-5">
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