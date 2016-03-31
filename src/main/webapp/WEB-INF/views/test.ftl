[#--[#assign shiro = JspTaglibs["/WEB-INF/shiro.tld"]]--]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
-->
<html lang="zh_cn">
<head>
[@block name="Meta"]
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content="pengyi"/>
    <link rel="icon" type="image/png" href="[@spring.url '/resources/assets/i/favicon.png'/]">
    <link rel="apple-touch-icon-precomposed" href="[@spring.url '/resources/assets/i/app-icon72x72@2x.png'/]">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.css'/]"/>
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.min.css'/]"/>
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/admin.css'/]">
    <link rel="stylesheet" href="[@spring.url '/resources/assets/css/app.css'/]">
[#--<link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.flat.css'/]"/>--]
[#--<link rel="stylesheet" href="[@spring.url '/resources/assets/css/amazeui.flat.min.css'/]"/>--]
[/@block]
    <title>YJH_DEMO-[@block name="title"][/@block]</title>
[@block name="topResources"]
[/@block]
</head>
[@block name="content"]
<div class="header">
    <div class="am-g">
        <h1>AmazeUIMode</h1>
        <p>...........................<br/>..............................</p>
    </div>
    <hr />
</div>
<div class="am-g">
    <button type="button" class="am-btn am-btn-primary modal-search-modal">
        Modal
    </button>
    <div class="am-modal" tabindex="-1" id="modalSearch">
        <div class="large-dialog">
            <div class="change-bg">
                <div class="am-modal-hd">
                    <p class="modal-title thin">XXX--XXXX
                        <small class="text-muted"></small>
                    </p>
                </div>
                <div class="am-modal-bd">
                    <div class="row">
                        <div class="col-md-9">
                            <section class="tile color transparent-black">
                                <div class="tile-header">
                                    <div class="controls">
                                        <a href="#" class="minimize"><i class="fa fa-chevron-down"></i></a>
                                        <a href="#" class="refresh"><i class="fa fa-refresh"></i></a>
                                        <a href="#" class="remove"><i class="fa fa-times"></i></a>
                                    </div>
                                </div>
                                <div class="tile-body">
                                    <form class="form-horizontal" role="form"
                                          action="[@spring.url '/role/permission_list' /]">
                                        <input type="hidden" id="permission-app-key" name="appKey"
                                               value="${command.appKey!}"/>
                                        <div class="input-list">
                                            <ul>
                                                <li>
                                                    <label>XX名称:</label>
                                                    <span>
                                                        <input type="text" class="form-control" id="permissionName"
                                                               name="permissionName" value="${command.permissionName}">
                                                    </span>
                                                </li>

                                                <li>
                                                    <label>状态:</label>
                                                    <span>
                                                       <select class="chosen-select chosen-transparent form-control"
                                                               id="permissionStatus" name="status"
                                                               style="display: none;">
                                                           [#assign status = (command.status!)?default("ENABLE") /]
                                                           <option value="ENABLE" [@mc.selected status "ENABLE"/]>启用
                                                           </option>
                                                           <option value="DISABLE" [@mc.selected status "DISABLE"/]>禁用
                                                           </option>
                                                       </select>
                                                    </span>
                                                </li>

                                                <li>
                                                    <button type="button" class="btn btn-dutch margin-left-15"
                                                            id="permissionFind">查询
                                                    </button>
                                                </li>
                                            </ul>
                                        </div>
                                    </form>
                                    <!-- tile body -->
                                    <div class="tile-body nopadding">
                                        <table class="table table-bordered table-sortable table-hover">
                                            <thead></thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                    <!-- tile footer -->
                                    <div class="tile-footer bg-transparent-black-2 rounded-bottom-corners">
                                        <div class="row">
                                            <div class="col-sm-4 text-center">
                                                <small class="inline table-options paging-info paging-permission">
                                                </small>
                                            </div>
                                            <div class="col-sm-4 text-right sm-center">
                                                <ul class="pagination pagination-xs nomargin pagination-custom pagination-permission">
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /tile footer -->
                            </section>
                        </div>

                        <div class="col-md-3">
                            <section class="tile color transparent-black">
                                <div class="tile-header">
                                    <h3><strong>已选</strong>列表</h3>
                                    <div class="controls">
                                        <a href="#" class="minimize"><i class="fa fa-chevron-down"></i></a>
                                        <a href="#" class="refresh"><i class="fa fa-refresh"></i></a>
                                        <a href="#" class="remove"><i class="fa fa-times"></i></a>
                                    </div>
                                </div>
                                <div class="tile-body selector-box modal-search-selector">
                                    <button class="btn margin-top-15 btn-green modal-search-hide-modal">确定</button>
                                    <button class="btn margin-top-15 btn-info selector-remove-all">删除全部</button>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
[/@block]

[@block name="bottomResources"]
<script src="[@spring.url '/resources/assets/js/jquery.min.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/amazeui.min.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/app.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/common.js'/]"></script>
<script src="[@spring.url '/resources/assets/js/modal-search-optimize.js' /]" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        new ModalSearch({
            url: "/app_key/list",
            pageInfoClass: "paging-permission",
            paginationClass: "pagination-permission",
            hideModalHandler: function (jsonDataArr) {

            },
            header: ["AppKey编号", "AppKey名称", "APpKey描述"],
            rowData: ["id", "name", "description"],
            selectorColumn: ["name"],
            pageSize: 10
        });
    })
</script>
[/@block]
</body>
</html>