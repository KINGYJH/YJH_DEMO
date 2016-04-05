/**
 * Created by YJH on 2016/4/3 0003.
 */

/**
 * select ajax 数据加载
 */
$.fn.selectAjaxData = function (options) {

    var $this = $(this);

    var defaults = {
        url: undefined,
        data: undefined,
        type: "post",
        dataType: "json",
        key: "id",
        value: "name",
        arrValue: []
    }

    $.extend(defaults, options || {});

    var ajax = function () {
        $.ajax({
            type: defaults.type,
            url: defaults.url,
            data: defaults.data,
            dataType: defaults.dataType,
            success: function (data) {
                var results = data.data;
                if (undefined != results) {
                    $this.append("<option value=''>请选择</option>");

                    $.each(results, function (a, b) {
                        if (b[defaults.key] == getDefaultVal()) {
                            $this.append("<option value='" + b[defaults.key] + "' selected>" + b[defaults.value] + "</option>")
                        } else {
                            $this.append("<option value='" + b[defaults.key] + "'>" + b[defaults.value] + "</option>")
                        }
                    });
                }
            }
        })
    }

    var getDefaultVal = function () {
        return $this.attr("data");
    }

    var init = function () {
        ajax();
    }
    init();
}
