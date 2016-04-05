<aside class="sidebar-menu fixed">
    <div class="sidebar-inner scrollable-sidebar">
        <div class="main-menu">
            <ul class="accordion" id="sidebar">
                <li class="menu-header">
                    Main Menu
                </li>
                <li class="bg-palette1">
                    <a href="/">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-home fa-lg"></i></span>
                            <span class="text m-left-sm">首页</span>
                        </span>
                    </a>
                </li>
                <li class="bg-palette1">
                    <a href="[@spring.url '/user/pagination.htm'/]">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-users fa-lg"></i></span>
                            <span class="text m-left-sm">用户管理</span>
                        </span>
                    </a>
                </li>
                <li class="openable bg-palette4">
                    <a href="#">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
                            <span class="text m-left-sm">系统设置</span>
                            <span class="submenu-icon"></span></span>
                        <span class="menu-content-hover block">Menu</span>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="[@spring.url '/app_key/pagination.htm'/]">
                                <span class="submenu-label">AppKey管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="[@spring.url '/permission/pagination.htm'/]">
                                <span class="submenu-label">权限管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="[@spring.url '/role/pagination.htm'/]">
                                <span class="submenu-label">角色管理</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="sidebar-fix-bottom clearfix">
            <div class="user-dropdown dropup pull-left">
                <a href="#" class="dropdwon-toggle font-18" data-toggle="dropdown"><i class="ion-person-add"></i>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="inbox.html">
                            Inbox
                            <span class="badge badge-danger bounceIn animation-delay2 pull-right">1</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            Notification
                            <span class="badge badge-purple bounceIn animation-delay3 pull-right">2</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="sidebarRight-toggle">
                            Message
                            <span class="badge badge-success bounceIn animation-delay4 pull-right">7</span>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">Setting</a>
                    </li>
                </ul>
            </div>
            <a href="lockscreen.html" class="pull-right font-18"><i class="ion-log-out"></i></a>
        </div>
    </div><!-- sidebar-inner -->
</aside>