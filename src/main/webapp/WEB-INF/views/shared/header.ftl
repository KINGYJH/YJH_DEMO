<header class="top-nav">
    <div class="top-nav-inner">
        <div class="nav-header">
            <button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleSM">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <ul class="nav-notification pull-right">
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog fa-lg"></i></a>
                    <span class="badge badge-danger bounceIn">1</span>
                    <ul class="dropdown-menu dropdown-sm pull-right user-dropdown">
                        <li class="user-avatar">
                            <img src="${Session["sessionUser"].headPic.picPath!}" alt="" class="img-circle">
                            <div class="user-content">
                                <h5 class="no-m-bottom">${Session["sessionUser"].userName!}</h5>
                                <div class="m-top-xs">
                                    <a href="#" class="m-right-sm">个人资料</a>
                                    <a href="[@spring.url '/logout'/]">注销</a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="#">
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
                </li>
            </ul>

            <a href="/" class="brand">
                <i class="fa fa-database"></i><span class="brand-name">YJH_DEMO ADMIN</span>
            </a>
        </div>
        <div class="nav-container">
            <button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleLG">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <ul class="nav-notification">
                <li class="search-list">
                    <div class="search-input-wrapper">
                        <div class="search-input">
                            <input type="text" class="form-control input-sm inline-block">
                            <a href="#" class="input-icon text-normal"><i class="ion-ios7-search-strong"></i></a>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="pull-right m-right-sm">
                <div class="user-block hidden-xs">
                    <a href="#" id="userToggle" data-toggle="dropdown">
                        <img src="${Session["sessionUser"].headPic.picPath!}" alt=""
                             class="img-circle inline-block user-profile-pic">
                        <div class="user-detail inline-block">
                        ${Session["sessionUser"].userName!}
                            <i class="fa fa-angle-down"></i>
                        </div>
                    </a>
                    <div class="panel border dropdown-menu user-panel">
                        <div class="panel-body paddingTB-sm">
                            <ul>
                                <li>
                                    <a href="[@spring.url '/account/profile.htm'/]">
                                        <i class="fa fa-edit fa-lg"></i><span class="m-left-xs">我的资料</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-inbox fa-lg"></i><span class="m-left-xs">Inboxes</span>
                                        <span class="badge badge-danger bounceIn animation-delay3">2</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="[@spring.url '/logout'/]">
                                        <i class="fa fa-power-off fa-lg"></i><span class="m-left-xs">注销</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <ul class="nav-notification">
                    <li>
                        <a href="#" data-toggle="dropdown"><i class="fa fa-envelope fa-lg"></i></a>
                        <span class="badge badge-purple bounceIn animation-delay5 active">1</span>
                        <ul class="dropdown-menu message pull-right">
                            <li><a>您有<span>1</span>个新的未读邮件</a></li>
                            <li>
                                <a class="clearfix" href="#">
                                    <img src="[@spring.url '/resources/images/profile/profile2.jpg'/]"
                                         alt="User Avatar">
                                    <div class="detail">
                                        <strong>John Doe</strong>
                                        <p class="no-margin">
                                            Lorem ipsum dolor sit amet...
                                        </p>
                                        <small class="text-muted"><i class="fa fa-check text-success"></i> 27m ago
                                        </small>
                                    </div>
                                </a>
                            </li>
                            <li><a href="[@spring.url '/messages/pagination.htm'/]">查看所有邮件</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="dropdown"><i class="fa fa-bell fa-lg"></i></a>
                        <span class="badge badge-info bounceIn animation-delay6 active">1</span>
                        <ul class="dropdown-menu notification dropdown-3 pull-right">
                            <li><a>您有<span>1</span>个新的通知</a></li>
                            <li>
                                <a href="#">
                                    <span class="notification-icon bg-warning"><i class="fa fa-warning"></i></span>
                                    <span class="m-left-xs">Server #2 not responding.</span>
                                    <span class="time text-muted">Just now</span>
                                </a>
                            </li>
                            <li><a href="#">查看所有通知</a></li>
                        </ul>
                    </li>
                    <li class="chat-notification">
                        <a href="#" class="sidebarRight-toggle"><i class="fa fa-comments fa-lg"></i></a>
                        <span class="badge badge-danger bounceIn">1</span>

                        <div class="chat-alert">
                            Hello, Are you there?
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>