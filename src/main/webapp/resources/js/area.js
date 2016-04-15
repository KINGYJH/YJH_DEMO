/**
 * 区域级联
 * Created by YJH on 2016/4/14.
 */
$.fn.areaCascade = function (attrName) {
    var _this = $(this);
    var attr_name = attrName;
    var searchDate = {};
    searchDate['parent'] = '';
    var initAjax = function (event) {
        $.ajax({
            url: "/area/search",
            contentType: "application/json",
            type: "post",
            dataType: "json",
            data: JSON.stringify(searchDate),
            success: function (data) {
                bindingData(data, event);
            }
        })
    }

    var loadLowerAjax = function (event) {
        $.ajax({
            url: "/area/search",
            contentType: "application/json",
            type: "post",
            dataType: "json",
            data: JSON.stringify(searchDate),
            success: function (data) {
                bindLowerData(data, event);
            }
        })
    }

    var bindingData = function (data, event) {
        event.empty();
        event.append("<select class='form-control'></select>")
        var _select = event.find("select");
        _select.append("<option value=''>请选择</option>");
        $.each(data, function (index, area) {
            _select.append("<option value='" + area.id + "'>" + area.name + "</option>");
        })
    }


    var bindLowerData = function (data, event) {
        event.parent().parent().append("<div class='col-lg-4 no-padding'><select class='form-control'></select></div>");
        var _select = event.parent().next("div").find("select");
        _select.empty();
        _select.append("<option value=''>请选择</option>");
        $.each(data, function (index, area) {
            _select.append("<option value='" + area.id + "'>" + area.name + "</option>");
        })
    }

    $(_this).on("change", "select", function () {
        var _div = $(_this).find("div");
        var _selectDiv = $(this).parent();
        var _selectIndex = _selectDiv.index();
        $(this).attr("name", attr_name);
        $.each(_div, function (index, data) {
            if (index > _selectIndex) {
                $(data).remove();
            }
            if (index != _selectIndex) {
                $(data).find("select").removeAttr("name");
            }
        });
        _div = $(_this).find("div");
        if (_div.size() < 3 && $(this).val() != "") {
            searchDate['parent'] = $(this).val();
            loadLowerAjax($(this));
        }
    })

    var init = function () {
        var _select = _this.find("div");
        initAjax($(_select[0]));
    }
    init();
}
