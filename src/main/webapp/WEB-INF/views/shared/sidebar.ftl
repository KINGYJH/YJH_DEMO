<!-- sidebar start -->
<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
        <ul class="am-list admin-sidebar-list">
            <li><a href="admin-index.html"><span class="am-icon-home"></span> 首页</a></li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                    <li>
                        <a data-am-collapse="{target:'#collapse-nav-users'}" class="am-cf"><span class="am-icon-check"></span> 用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                        <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav-users">
                            <li><a href="[@spring.url '/user/list.htm'/]"><span class="am-icon-users"></span>用户列表</a></li>
                            <li><a href="[@spring.url '/user/create.htm'/]"><span class="am-icon-user-secret"></span>用户创建</a></li>
                        </ul>
                    </li>

                    <li>
                        <a data-am-collapse="{target:'#collapse-nav-roles'}" class="am-cf"><span class="am-icon-check"></span> 角色管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                        <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav-roles">
                            <li><a href="[@spring.url '/role/list.htm'/]"><span class="am-icon-users"></span>角色列表</a></li>
                            <li><a href="[@spring.url '/role/create.htm'/]"><span class="am-icon-user-secret"></span>角色创建</a></li>
                        </ul>
                    </li>

                    <li>
                        <a data-am-collapse="{target:'#collapse-nav-resources'}" class="am-cf"><span class="am-icon-check"></span> 访问资源管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                        <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav-resources">
                            <li><a href="[@spring.url '/permission/list.htm'/]"><span class="am-icon-users"></span>访问资源列表</a></li>
                            <li><a href="[@spring.url '/permission/create.htm'/]"><span class="am-icon-user-secret"></span>访问资源创建</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>

        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-bookmark"></span> 公告</p>
                <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
            </div>
        </div>

        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-tag"></span> wiki</p>
                <p>Welcome to the Amaze UI wiki!</p>
            </div>
        </div>
    </div>
</div>
<!-- sidebar end -->