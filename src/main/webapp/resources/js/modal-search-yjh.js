/**
 *
 * 弹窗数据选择
 * Created by YJH on 2016/4/8.
 */
(function () {
    window.ModalSearch = function (config) {
        var defaultConfig = {
            id: "modalSearch",  //容器ID
            url: "",            //数据获取地址
            headers: [],        //table头部标题
            selectorDateName: [],//选择完展示的属性name
            rowDataName: [],     //table战术数据name
            hideModalHandler: $.noop,//关闭弹窗处理方法
            isSingle: false,                           //是否单选
            openModalClass: ".modal-search-modal",      //打开弹窗的class
            hideModalClass: ".modal-search-hide-modal", //关闭弹窗的class
            removeAllClass: ".selector-remove-all",//移除所有选择class
            selectorBoxClass: ".selector-box-data",//数据选择后放的容器
            pageSize: 10,        //分页大小
            oldDataIds: []       //之前数据ids
        };
        this.config = $.extend(defaultConfig, config || {});
        this.modal = $("#" + this.config.id);//弹窗容器
        this._form = this.modal.find("form");//表单
        this._table = this.modal.find("table");//table
        this.searchCommand = {page: 1};//查询条件
        this.searchPaginationDate = {};//每次加载的数据
        this.allSelectedData = [];//所有选择的数据
        this.allData = [];//所有数据
        this.init();
    }

    window.ModalSearch.prototype = {
        init: function () {
            this._bind();
            this._tableHeaderRender();
            this._loadOldDate();
        },
        //数据请求
        _search: function () {
            var _this = this;
            _this._updateSearchData();
            $.ajax({
                url: _this.config.url,
                contentType: "application/json",
                type: "post",
                dataType: "json",
                data: JSON.stringify(_this.searchCommand),
                success: function (pagination) {
                    _this.searchPaginationDate = pagination;
                    _this._tableBodyRender();
                    _this._paginationRender();
                }
            })
        },
        //绑定事件
        _bind: function () {
            var _this = this;
            //点击查询
            this._form.find("button").on("click", function () {
                _this._search();
            });
            //点击打开弹窗
            $(this.config.openModalClass).on("click", function () {
                _this.modal.modal("show");
                _this._search();
            });
            //点击确定
            $(this.config.hideModalClass).on("click", function () {
                _this.modal.modal("hide");
                _this.config.hideModalHandler(_this.allSelectedData);
            });
            $(this.config.removeAllClass).on("click", function () {
                _this._removeAll();
            })
        },
        //加载table内容信息
        _tableBodyRender: function () {
            var _this = this;
            var tagVal;
            var _tbody = this._table.find('tbody');
            _tbody.empty();
            $(this.searchPaginationDate.data).each(function (index, data) {
                _this._addToAllData(data);
                if (_this.config.isSingle) {
                    var dom_tr = $('<tr><td class="vertical-middle"><div class=\"radio modal-search-radio radio-transparent\"><input class=\"modal_input\" name="optionsRadios" type=\"radio\" vaule="' + data.id + '" id="' + data.id + '"  ><label for="' + data.id + '"></label>' + '</div></td></tr>');
                } else {
                    var dom_tr = $('<tr><td class="vertical-middle"><div class=\"checkbox check-transparent\"><input class=\"modal_input\" type=\"checkbox\" vaule="' + data.id + '" id="' + data.id + '" ><label for="' + data.id + '"></label>' + '</div></td></tr>');
                }

                $(_this.config.rowDataName).each(function (index, name) {
                    var dom_td;
                    if (name.indexOf('.') != -1) {
                        var strs = new Array();
                        strs = name.split(".");
                        var _objectDate = "";
                        var _lastAttr = "";
                        $(strs).each(function (j, k) {
                            if (typeof data[k] == "object") {
                                _objectDate = data[k];
                            }
                            _lastAttr = k;
                        });
                        dom_td = $("<td class='checkTd'>" + _objectDate[_lastAttr] + "</td>");
                    } else {
                        dom_td = $("<td class='checkTd'>" + data[name] + "</td>");
                    }
                    dom_tr.append(dom_td);
                })
                _tbody.append(dom_tr);
            })
            var modal_input = this._table.find('.modal_input');
            modal_input.on('click', function () {
                if ($(this).prop('checked')) {
                    _this._add($(this).attr("vaule"));
                } else {
                    _this._remove($(this).attr("vaule"));
                }
            });
            _this._loadCheckedStatus();
            _this._loadSelectedData();
        },
        //加载table头部信息
        _tableHeaderRender: function () {
            var _thead = this._table.find("thead");
            var sb = new StringBuilder("<tr><th>请选择</th>")
            $.each(this.config.headers, function (index, element) {
                sb.append("<th>")
                    .append(element)
                    .append("</th>");
            });
            sb.append("</tr>");
            _thead.append(sb.toString());
        },
        //加载分页页码信息
        _paginationRender: function () {
            var count = this.searchPaginationDate.count;
            var pageSize = this.searchPaginationDate.pageSize;
            var page = this.searchPaginationDate.page;
            var totalPage = Math.ceil(count / pageSize);
            var sb = new StringBuilder();
            sb.append("总计").append(count).append("条数据，每页显示").append(pageSize).append("条，总共").append(totalPage).append("页");
            $('.paging-info').text(sb.toString());
            sb.clear();

            if (count > 0) {
                if (page - 1 <= 0) {
                    sb.append("<li class=\"disabled\"><a href=\"#\"><i class=\"fa fa-angle-double-left\"></i></a></li>");
                } else {
                    sb.append("<li><a href=\"" + (page - 1) + "\"><i class=\"fa fa-angle-double-left\"></i></a></li>");
                }

                var index = 1;
                while (index <= totalPage) {
                    if (count < 11) {
                        if (page == index) {
                            sb.append("<li class=\"active\"><a href=\"" + index + "\">" + index + "</a></li>");
                        } else {
                            sb.append("<li><a href=\"" + index + "\">" + index + "</a></li>");
                        }
                    } else {
                        if (index > (page - 5) && index < (page + 4)) {
                            if (page == index) {
                                sb.append("<li class=\"active\"><a href=\"" + index + "\">" + index + "</a></li>");
                            } else {
                                sb.append("<li><a href=\"" + index + "\">" + index + "</a></li>");
                            }
                        }
                    }
                    index++;
                }

                if (page == totalPage) {
                    sb.append("<li class=\"disabled\"><a href=\"#\"><i class=\"fa fa-angle-double-right\"></i></a></li>");
                } else {
                    sb.append("<li><a href=\"" + (page + 1) + "\"><i class=\"fa fa-angle-double-right\"></i></a></li>");
                }
            }

            $(".pagination").empty().append(sb.toString());
            var _this = this;
            $(".pagination").find("li[class!='disabled']").on("click", function () {
                _this._updateSearchData();
                _this.searchCommand["page"] = $(this).find("a").attr("href");
                _this._search();
                return false;
            });
        },
        //更新查询条件
        _updateSearchData: function () {
            var _that = this;
            _that._form.find("input,select").each(function (index, element) {
                _that.searchCommand[$(element).attr("name")] = $(element).val();
            });
            _that.searchCommand['pageSize'] = _that.config.pageSize;
        },
        //把新数据加入到所有数据中
        _addToAllData: function (data) {
            var eq = true;
            $.each(this.allData, function (a, b) {
                if (data.id == b.id) {
                    eq = false;
                    return;
                }
            })
            if (eq) {
                this.allData.push(data);
            }
        },
        //添加已选
        _add: function (id) {
            var data;
            $.each(this.allData, function (a, b) {
                if (b.id == id) {
                    data = b;
                    return;
                }
            })
            if (this.config.isSingle) {
                this.allSelectedData.length = 0;
                this.allSelectedData.push(data);
                this._loadSelectedData();
            } else {
                this.allSelectedData.push(data);
                this._loadSelectedData();
            }
        },
        //移除已选
        _remove: function (id) {
            for (var j in this.allSelectedData) {
                if (this.allSelectedData[j].id == id) {
                    this.allSelectedData.splice(j, 1);
                }
            }
            this._loadSelectedData();
        },
        //加载选中的数据
        _loadSelectedData: function () {
            var _this = this;
            $(_this.config.selectorBoxClass).empty();
            $.each(_this.allSelectedData, function (index, element) {
                if (typeof element != 'undefined') {
                    var togglerId = 'modalSearchSelector' + element.id;
                    $(_this.config.selectorBoxClass).append("<div class='checkbox check-transparent'><a href='javascript:;' data-id='" + element.id + "' id='" + togglerId + "' class='check-toggler'></a></div>")
                        .append('<div class="check-td-modal">' + element[_this.config.selectorDateName[0]] + '</div>');
                }
            })

            $(".check-toggler").on("click", function () {
                var removeId = $(this).attr("data-id");
                _this._remove(removeId);
                $(_this._table).find("input").each(function (a, b) {
                    if ($(this).attr("vaule") == removeId) {
                        $(this).prop('checked', false)
                    }
                })
                $(this).parent(".checkbox").next("div").remove();
                $(this).parent(".checkbox").remove();
            });
        },
        //加载数据选中input的状态
        _loadCheckedStatus: function () {
            var _this = this;
            $(_this._table).find("input").each(function (index, element) {
                $(element).prop('checked', false);
                $.each(_this.allSelectedData, function (a, b) {
                    if ($(element).attr("vaule") == b.id) {
                        $(element).prop('checked', true);
                    }
                })
            })
        },
        //移除全部
        _removeAll: function () {
            for (var j in this.allSelectedData) {
                this.allSelectedData.splice(j, 1);
            }
            this._loadSelectedData();
            this._loadCheckedStatus();
        },
        //加载之前数据
        _loadOldDate: function () {
            var _this = this;
            if (this.config.oldDataIds.length > 0) {
                _this.searchCommand["ids"] = this.config.oldDataIds;
                _this.searchCommand["pageSize"] = 1000000;
                $.ajax({
                    url: _this.config.url,
                    contentType: "application/json",
                    type: "post",
                    dataType: "json",
                    data: JSON.stringify(_this.searchCommand),
                    success: function (pagination) {
                        $.each(pagination.data, function (a, b) {
                            _this.allSelectedData.push(b);
                        })
                        _this.searchCommand["ids"] = [];
                    }
                })
            }
        }
    };
})();
