/**
 * 弹窗搜索选择组件
 * User: EthanTu
 * Date: 2/13/15
 * Time: 4:24 PM
 */

(function () {
    var ModalSearch = function (config) {
        var defaultConfig = {
            id: "modalSearch",
            openModalBtn: '.modal-search-modal',
            hideModalBtn: '.modal-search-hide-modal',
            url: "",
            pageSize: 10,
            header: [],
            rowData: [],
            selectorData: [],
            hideModalHandler: $.noop,
            isSingle: false
        };
        this.config = $.extend(defaultConfig, config || {});
        this.modalEle = $('#' + this.config.id);
        this._table = this.modalEle.find("table");
        this.searchData = {page: 1};
        this.rowDataList = [];
        this.rowDataListObj = {};
        this.allDataList = [];
        this.allDataListObj = {};
        this.OldData = {};
        this.addDataObj = {};
        this.allSelected = {};
        this.openModal();
    };

    ModalSearch.prototype = {
        init: function () {
            this.renderHeader();
            this.ajaxData();
            this.hideModal()
        },
        openModal: function () {
            var _this = this;
            $(this.config.openModalBtn).on('click', function () {
                $('#' + _this.config.id).modal('show');
                _this.init();
            });
            $('.input-list').find('button').on('click', function () {
                _this.searchData['page'] = 1;
                _this.ajaxData();
            });
            $('.selector-remove-all').on('click', function () {
                _this.removeAll();
            })
            $('.selector-box').append('<div class="selector-box-data">');
        },

        hideModal: function () {
            var _this = this;
            $(this.config.hideModalBtn).on('click', function () {
                $('#' + _this.config.id).modal('hide');
                _this.config.hideModalHandler(_this.allSelected);
            });

        },
        ajaxData: function () {
            var _this = this;
            this.updateSearch(_this.config.pageSize);
            $.ajax({
                url: _this.config.url,
                contentType: "application/json",
                type: "post",
                dataType: "json",
                data: JSON.stringify(_this.searchData),
                success: function (pagination) {
                    _this.rowDataList.length = 0;
                    FastJson.format(pagination);
                    $.each(pagination.data, function (index, element) {
                        _this.rowDataList.push(element);
                    });
                    _this.renderBody(_this.rowDataList, pagination.page);

                    _this._paginationRender(pagination.count, pagination.page, pagination.pageSize);

                    _this.ajaxAllData(pagination.count);
                },
                error: function (data) {

                }
            });
        },
        ajaxAllData: function (count) {
            var _this = this;
            this.updateSearch(count)
            $.ajax({
                url: _this.config.url,
                contentType: "application/json",
                type: "post",
                dataType: "json",
                data: JSON.stringify(_this.searchData),
                success: function (pagination) {
                    _this.allDataList.length = 0;
                    $.each(pagination.data, function (index, element) {
                        _this.allDataList.push(element);
                    });
                    $.each(_this.allDataList, function (a, b) {
                        b.tag = 'modalSearch-' + a;
                        _this.allDataListObj[b.tag] = b;
                    });
                    _this.getOldData()
                }
            })
        },
        updateSearch: function (_pageSize) {
            var _this = this;
            this.modalEle.find("form").find("input, select").each(function (a, b) {
                _this.searchData[$(b).attr("name")] = $(b).val();
            });
            _this.searchData['pageSize'] = _pageSize;

        },
        getOldData: function () {   //获取之前的数据
            var _this = this;
            var checkTdInfo = $('.check-td-info');

            $.each(checkTdInfo, function () {
                var _that = $(this);
                $.each(_this.allDataList, function (a, b) {
                    console.log("1");
                    if (b.id == _that.attr('data-id')) {
                        b.checked = 'checked';
                        _this.OldData[b.tag] = b;
                    }
                });
            });
            //console.log(_this.config.oldDataIds.exists("4028818253dacf800153dacfc4bd0000"));
            this.loadData(_this.allSelected);
            $.each(_this.rowDataList, function (a, b) {
                for (var i in _this.allSelected) {
                    if (b.id == _this.allSelected[i].id) {
                        $('#' + b.checkBoxId).prop('checked', true)
                    }
                }
            });
        },
        setOldData: function (newData) {
            this.OldData = newData;
        },
        _paginationRender: function (count, page, pageSize) {

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
                _this.searchData["page"] = $(this).find("a").attr("href");
                _this.ajaxData();
                return false;
            });

        },
        renderHeader: function () {
            var _this = this;
            var _thead = this._table.find('thead');
            _thead.empty();
            _thead.append("<tr>")
            _thead.find("tr").append("<th class='th-width'>请选择</th>");
            $(_this.config.header).each(function (a, b) {
                _thead.find('tr').append("<th>" + b + "</th>")
            });
        },
        renderBody: function (rowList, pageSize) {
            var _this = this;
            var tagVal;
            var _tbody = this._table.find('tbody');
            _tbody.empty();
            $(rowList).each(function (a, b) {

                tagVal = 'modalSearch-' + pageSize + '-' + (a + 1);
                if (_this.config.isSingle) {
                    var dom_tr = $('<tr><td class="vertical-middle"><div class=\"radio modal-search-radio radio-transparent\"><input class=\"modal_input\" name="optionsRadios" type=\"radio\" vaule="' + tagVal + '" id="' + tagVal + '"  ><label for="' + tagVal + '"></label>' + '</div></td></tr>');
                } else {
                    var dom_tr = $('<tr><td class="vertical-middle"><div class=\"checkbox check-transparent\"><input class=\"modal_input\" type=\"checkbox\" vaule="' + tagVal + '" id="' + tagVal + '" ><label for="' + tagVal + '"></label>' + '</div></td></tr>');
                }
                $(_this.config.rowData).each(function (c, d) {
                    var dom_td;
                    if (d.indexOf('.') != -1) {
                        var strs = new Array();
                        strs = d.split(".");
                        var _objectDate = "";
                        var _lastAttr = "";
                        $(strs).each(function (j, k) {
                            if (typeof b[k] == "object") {
                                _objectDate = b[k];
                            }
                            _lastAttr = k;
                        });
                        dom_td = $("<td class='checkTd'>" + _objectDate[_lastAttr] + "</td>");
                    } else {
                        dom_td = $("<td class='checkTd'>" + b[d] + "</td>");
                    }

                    dom_tr.append(dom_td);
                });
                _tbody.append(dom_tr);
                b.checkBoxId = tagVal;
                _this.rowDataListObj[b.checkBoxId] = b;
                _this.getOldData();

                $.each(_this.allSelected, function(index, element){
                    if(b.id == element.id){
                        $('#' + b.checkBoxId).prop('checked',true)
                    }
                });
            });

            var modal_input = this._table.find('.modal_input');
            modal_input.on('click', function () {
                if ($(this).prop('checked')) {
                    _this.add(rowList, $(this));
                } else {
                    _this.remove(rowList, $(this));
                }
            });
            _this.loadData();
            //console.log("所有数据+"_this.rowDataListObj)
        },
        loadData: function (newDataObj) {  //弹窗里面加载数据
            var _this = this;
            if (typeof newDataObj == 'undefined') {
                this.allSelected = $.extend({}, this.OldData, this.addDataObj);
                this.addDataObj = {};
            } else {
                this.allSelected = $.extend({}, newDataObj, this.addDataObj);
            }

            $('.selector-box-data').empty();
            $.each(_this.allSelected, function (index, element) {
                var selectorDataArr = [];
                $.each(_this.config.selectorData, function (a, b) {
                    selectorDataArr.push(b);
                });
                var togglerId = 'modalSearchSelector' + element.id;
                $('.selector-box-data').append("<div class='checkbox check-transparent'><a href='javascript:;' data-id='" + element.id + "' id='" + togglerId + "' class='check-toggler'></a></div>")
                    .append('<div class="check-td-modal">' + element[selectorDataArr] + '</div>');
            })

            $('.check-toggler').on('click', function () {
                var _checkBoxId = $(this).attr('data-id');
                for (var i in _this.allSelected) {
                    if (_this.allSelected[i].id == _checkBoxId) {
                        delete _this.allSelected[i];
                    }
                }
                for (var i in _this.rowDataListObj) {
                    if (_this.rowDataListObj[i].id == _checkBoxId) {
                        $('#' + _this.rowDataListObj[i].checkBoxId).prop('checked', false);
                        _this.rowDataListObj[i].checked = 'undefined';
                    }
                }
                $(this).parent(".checkbox").next("div").remove();
                $(this).parent(".checkbox").remove();
            });
            _this.setOldData(_this.allSelected);
        },
        add: function (rowList, that) {
            if (this.config.isSingle) {
                this.allSelected = {}
                this.loadData(this.allSelected);
            }
            var _checkBoxId = that.attr('id');
            for (var i  in rowList) {
                if (rowList[i].checkBoxId == _checkBoxId) {
                    rowList[i].checked = 'checked';
                    this.addDataObj[rowList[i].checkBoxId] = rowList[i]
                }
            }
            this.allSelected = $.extend({}, this.OldData, this.addDataObj);
            for (var j in this.allSelected) {
                if (this.allSelected[j].checked == undefined) {
                    delete  this.allSelected[j];
                }
            }
            this.loadData();
        },

        remove: function (rowList, that) {
            var _checkBoxId = that.attr('id');
            for (var i  in rowList) {
                if (rowList[i].checkBoxId == _checkBoxId) {
                    rowList[i].checked = undefined;
                }
            }
            for (var j in this.addDataObj) {
                if (this.addDataObj[j].checked == undefined) {
                    delete this.addDataObj[j]
                }
            }
            for (var k in this.OldData) {
                if (this.OldData[k].checked == undefined) {
                    delete this.OldData[k]
                }
            }
            this.loadData();
        },
        removeAll: function () {
            this.loadData();
            this.allSelected = {};
            $('.selector-box-data').empty();
            $('.modal_input').prop('checked', false);
        }
    };
    window['ModalSearch'] = ModalSearch;
})();