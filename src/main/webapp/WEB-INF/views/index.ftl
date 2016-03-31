[@override name="title"]首页[/@override]
[@override name="topResources"]
    [@super /]
[/@override]

[@override name="contentTitle"]
一些mode
[/@override]

[@override name="content"]
<div class="am-g">
    <div class="am-u-md-6">
        <div class="am-panel am-panel-default">
            <div class="am-panel-hd am-cf am-collapsed" data-am-collapse="{target: '#collapse-panel-1'}">文件上传<span
                    class="am-icon-chevron-down am-fr"></span></div>
            <div class="am-panel-bd am-collapse" id="collapse-panel-1">
                <ul class="am-list admin-content-file">
                    <li>
                        <strong><span class="am-icon-upload"></span> Kong-cetian.Mp3</strong>
                        <p>3.3 of 5MB - 5 mins - 1MB/Sec</p>
                        <div class="am-progress am-progress-striped am-progress-sm am-active">
                            <div class="am-progress-bar am-progress-bar-success" style="width: 82%">82%</div>
                        </div>
                    </li>
                    <li>
                        <strong><span class="am-icon-check"></span> 好人-cetian.Mp3</strong>
                        <p>3.3 of 5MB - 5 mins - 3MB/Sec</p>
                    </li>
                    <li>
                        <strong><span class="am-icon-check"></span> 其实都没有.Mp3</strong>
                        <p>3.3 of 5MB - 5 mins - 3MB/Sec</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="am-panel am-panel-default">
            <div class="am-panel-hd am-cf am-collapsed" data-am-collapse="{target: '#collapse-panel-2'}">浏览器统计<span
                    class="am-icon-chevron-down am-fr"></span></div>
            <div id="collapse-panel-2" class="am-collapse">
                <table class="am-table am-table-bd am-table-bdrs am-table-striped am-table-hover">
                    <tbody>
                    <tr>
                        <th class="am-text-center">#</th>
                        <th>浏览器</th>
                        <th>访问量</th>
                    </tr>
                    <tr>
                        <td class="am-text-center"><img
                                src="[@spring.url '/resources/assets/i/examples/admin-chrome.png'/]" alt=""></td>
                        <td>Google Chrome</td>
                        <td>3,005</td>
                    </tr>
                    <tr>
                        <td class="am-text-center"><img
                                src="[@spring.url '/resources/assets/i/examples/admin-firefox.png'/]" alt=""></td>
                        <td>Mozilla Firefox</td>
                        <td>2,505</td>
                    </tr>
                    <tr>
                        <td class="am-text-center"><img src="[@spring.url '/resources/assets/i/examples/admin-ie.png'/]"
                                                        alt=""></td>
                        <td>Internet Explorer</td>
                        <td>1,405</td>
                    </tr>
                    <tr>
                        <td class="am-text-center"><img
                                src="[@spring.url '/resources/assets/i/examples/admin-opera.png'/]" alt=""></td>
                        <td>Opera</td>
                        <td>4,005</td>
                    </tr>
                    <tr>
                        <td class="am-text-center"><img
                                src="[@spring.url '/resources/assets/i/examples/admin-safari.png'/]" alt=""></td>
                        <td>Safari</td>
                        <td>505</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="am-u-md-6">
        <div class="am-panel am-panel-default">
            <div class="am-panel-hd am-cf am-collapsed" data-am-collapse="{target: '#collapse-panel-4'}">任务 task<span
                    class="am-icon-chevron-down am-fr"></span></div>
            <div id="collapse-panel-4" class="am-panel-bd am-collapse">
                <ul class="am-list admin-content-task">
                    <li>
                        <div class="admin-task-meta"> Posted on 25/1/2120 by John Clark</div>
                        <div class="admin-task-bd">
                            The starting place for exploring business management; helping new managers get started and
                            experienced managers get better.
                        </div>
                        <div class="am-cf">
                            <div class="am-btn-toolbar am-fl">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default"><span
                                            class="am-icon-check"></span></button>
                                    <button type="button" class="am-btn am-btn-default"><span
                                            class="am-icon-pencil"></span></button>
                                    <button type="button" class="am-btn am-btn-default"><span
                                            class="am-icon-times"></span></button>
                                </div>
                            </div>
                            <div class="am-fr">
                                <button type="button" class="am-btn am-btn-default am-btn-xs">删除</button>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="admin-task-meta"> Posted on 25/1/2120 by 呵呵呵</div>
                        <div class="admin-task-bd">
                            基兰和狗熊出现在不同阵营时。基兰会获得BUFF，“装甲熊憎恨者”。狗熊会获得BUFF，“时光老人憎恨者”。
                        </div>
                        <div class="am-cf">
                            <div class="am-btn-toolbar am-fl">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default"><span
                                            class="am-icon-check"></span></button>
                                    <button type="button" class="am-btn am-btn-default"><span
                                            class="am-icon-pencil"></span></button>
                                    <button type="button" class="am-btn am-btn-default"><span
                                            class="am-icon-times"></span></button>
                                </div>
                            </div>
                            <div class="am-fr">
                                <button type="button" class="am-btn am-btn-default am-btn-xs">删除</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <div class="am-panel am-panel-default">
            <div class="am-panel-hd am-cf am-collapsed" data-am-collapse="{target: '#collapse-panel-3'}">最近留言<span
                    class="am-icon-chevron-down am-fr"></span></div>
            <div class="am-panel-bd am-collapse am-cf" id="collapse-panel-3">
                <ul class="am-comments-list admin-content-comment">
                    <li class="am-comment">
                        <a href="#"><img
                                src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/96/h/96" alt=""
                                class="am-comment-avatar" width="48" height="48"></a>
                        <div class="am-comment-main">
                            <header class="am-comment-hd">
                                <div class="am-comment-meta"><a href="#" class="am-comment-author">某人</a> 评论于
                                    <time>2014-7-12 15:30</time>
                                </div>
                            </header>
                            <div class="am-comment-bd"><p>遵循 “移动优先（Mobile First）”、“渐进增强（Progressive
                                enhancement）”的理念，可先从移动设备开始开发网站，逐步在扩展的更大屏幕的设备上，专注于最重要的内容和交互，很好。</p>
                            </div>
                        </div>
                    </li>

                    <li class="am-comment">
                        <a href="#"><img
                                src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/96/h/96" alt=""
                                class="am-comment-avatar" width="48" height="48"></a>
                        <div class="am-comment-main">
                            <header class="am-comment-hd">
                                <div class="am-comment-meta"><a href="#" class="am-comment-author">某人</a> 评论于
                                    <time>2014-7-12 15:30</time>
                                </div>
                            </header>
                            <div class="am-comment-bd"><p>有效减少为兼容旧浏览器的臃肿代码；基于 CSS3
                                的交互效果，平滑、高效。AMUI专注于现代浏览器（支持HTML5），不再为过时的浏览器耗费资源，为更有价值的用户提高更好的体验。</p>
                            </div>
                        </div>
                    </li>

                </ul>
                <ul class="am-pagination am-fr admin-content-pagination">
                    <li class="am-disabled"><a href="#">&laquo;</a></li>
                    <li class="am-active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div>
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

[/@override]

[@override name="bottomResources"]
    [@super /]
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
[/@override]
[@extends name="/decorator.ftl"/]
