[@override name="title"]个人简介[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li>个人简介</li>
</ul>
[/@override]

[@override name="headerText"]
个人简介
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row user-profile-wrapper">
    <div class="col-md-3 user-profile-sidebar m-bottom-md">
        <div class="row">
            <div class="col-sm-4 col-md-12">
                <div class="user-profile-pic">
                    <img id="head-img" src="[@spring.url '/resources/images/profile/profile1.jpg'/]" alt="">
                    <div class="ribbon-wrapper">
                        <div class="ribbon-inner shadow-pulse bg-success">
                            点击修改头像
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-12">
                <div class="user-name m-top-sm">Jane Doe<i class="fa fa-circle text-success m-left-xs font-14"></i>
                </div>

                <div class="m-top-sm">
                    <div>
                        <i class="fa fa-map-marker user-profile-icon"></i>
                        San Francisco, California, USA
                    </div>

                    <div class="m-top-xs">
                        <i class="fa fa-briefcase user-profile-icon"></i>
                        Software Engineer
                    </div>

                    <div class="m-top-xs">
                        <i class="fa fa-external-link user-profile-icon"></i>
                        www.mywebsite.com
                    </div>
                </div>

                <div class="m-top-sm text-centers">
                    <a class="btn btn-success"><i class="fa fa-edit m-right-xs"></i>Edit Profile</a>
                </div>

                <h4 class="m-top-md m-bottom-sm">About Me</h4>
                <p class="m-top-sm">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis
                    ullamcorper ligula sodales at.
                <p>

                <h4 class="m-top-md m-bottom-sm">Get Social</h4>

                <a class="social-link facebook-hover"><i class="fa fa-facebook"></i></a>
                <a class="social-link twitter-hover"><i class="fa fa-twitter"></i></a>
                <a class="social-link pinterest-hover"><i class="fa fa-pinterest"></i></a>

            </div>
        </div>
    </div>
    <div class="col-md-9">
        <div class="smart-widget">
            <div class="smart-widget-inner">
                <ul class="nav nav-tabs tab-style2 tab-right bg-grey">
                    <li>
                        <a href="#profileTab3" data-toggle="tab">
                            <span class="icon-wrapper"><i class="fa fa-eye"></i></span>
                            <span class="text-wrapper">Followers</span>
                        </a>
                    </li>
                    <li>
                        <a href="#profileTab2" data-toggle="tab">
                            <span class="icon-wrapper"><i class="fa fa-book"></i></span>
                            <span class="text-wrapper">Account</span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="#profileTab1" data-toggle="tab">
                            <span class="icon-wrapper"><i class="fa fa-trophy"></i></span>
                            <span class="text-wrapper">Overview</span>
                        </a>
                    </li>
                </ul>
                <div class="smart-widget-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="profileTab1">
                            <h4 class="header-text m-bottom-md">
                                My Skill
													<span class="sub-header">
														Welocome back, Jane
													</span>
                            </h4>
                            <div class="row">
                                <div class="col-sm-3 col-sm-6s">
                                    <div class="m-bottom-md">
                                        <div class="text-center">HTML5</div>
                                        <div class="chart profile-skill chart-skill-red center-block" data-percent="73">
                                            73%
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-sm-6s">
                                    <div class="m-bottom-md">
                                        <div class="text-center">CSS</div>
                                        <div class="chart profile-skill chart-skill-blue center-block"
                                             data-percent="54">54%
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-sms-6">
                                    <div class="m-bottom-md">
                                        <div class="text-center">Jquery</div>
                                        <div class="chart profile-skill chart-skill-green center-block"
                                             data-percent="89">89%
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-sm-6s">
                                    <div class="m-bottom-md">
                                        <div class="text-center">PHP</div>
                                        <div class="chart profile-skill chart-skill-purple center-block"
                                             data-percent="92">92%
                                        </div>
                                    </div>
                                </div>
                            </div><!-- ./row -->

                            <div class="row">
                                <div class="col-lg-6">
                                    <h4 class="m-top-md">Recent Activity</h4>

                                    <div class="recent-activity-list">
                                        <ul>
                                            <li>
                                                <div class="activity-user-profile">
                                                    <img src="[@spring.url '/resources/images/profile/profile3.jpg'/]"
                                                         alt="">
                                                </div>
                                                <div class="activity-detail">
                                                    <span class="font-semi-bold">Karen Martin</span> started following
                                                    <span class="font-semi-bold">Jame Smith</span>.
                                                    <small class="text-muted block">36 mins ago</small>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="activity-user-profile">
                                                    <img src="[@spring.url '/resources/images/profile/profile3.jpg'/]"
                                                         alt="">
                                                </div>
                                                <div class="activity-detail">
                                                    <span class="font-semi-bold">Karen Martin</span> just added <span
                                                        class="font-semi-bold">Simplify Admin</span> to dashboard.
                                                    <small class="text-muted block">3 hrs ago</small>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="activity-user-profile">
                                                    <img src="[@spring.url '/resources/images/profile/profile5.jpg'/]"
                                                         alt="">
                                                </div>
                                                <div class="activity-detail">
                                                    <span class="font-semi-bold">Sarah Garcia</span> added new photo
                                                    <small class="text-muted block">Yesterday</small>

                                                    <div class="m-top-sm">
                                                        <img src="[@spring.url '/resources/images/img11.jpg'/]" alt="">
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="activity-user-profile">
                                                    <img src="[@spring.url '/resources/images/profile/profile4.jpg'/]"
                                                         alt="">
                                                </div>
                                                <div class="activity-detail">
                                                    <span class="font-semi-bold">Jame Smith</span> started following
                                                    <span class="font-semi-bold">Karen Martin</span>.
                                                    <small class="text-muted block">36 mins ago</small>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="activity-user-profile">
                                                    <img src="[@spring.url '/resources/images/profile/profile6.jpg'/]"
                                                         alt="">
                                                </div>
                                                <div class="activity-detail">
                                                    <span class="font-semi-bold">Chistopher Brown</span> just purchased
                                                    <span class="font-semi-bold">your item</span>.
                                                    <small class="text-muted block">36 mins ago</small>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="activity-user-profile">
                                                    <img src="[@spring.url '/resources/images/profile/profile7.jpg'/]"
                                                         alt="">
                                                </div>
                                                <div class="activity-detail">
                                                    <span class="font-semi-bold">Elizabeth Carter</span> uploaded <a
                                                        class="font-semi-bold">3 photos</a>.
                                                    <small class="text-muted block">36 mins ago</small>

                                                    <ul class="uploaded-photo-list m-top-sm clearfix">
                                                        <li><a href="#"><img
                                                                src="[@spring.url '/resources/images/gallery/gallery4.jpg'/]"
                                                                alt=""></a></li>
                                                        <li><a href="#"><img
                                                                src="[@spring.url '/resources/images/gallery/gallery5.jpg'/]"
                                                                alt=""></a></li>
                                                        <li><a href="#"><img
                                                                src="[@spring.url '/resources/images/gallery/gallery6.jpg'/]"
                                                                alt=""></a></li>
                                                    </ul><!-- ./upload-photo-list -->
                                                </div>
                                            </li>
                                        </ul>
                                    </div><!-- ./.recent-activity-list -->
                                </div><!-- ./col -->
                                <div class="col-lg-6">
                                    <h4 class="m-top-md">User Statistic</h4>

                                    <div class="row m-top-md">
                                        <div class="col-sm-6">
                                            <div class="widget-stat3 bg-primary">
                                                <div class="widget-stat-icon">
                                                    <i class="fa fa-facebook fa-3x"></i>
                                                </div>
                                                <small class="text-upper">Like</small>
                                                <h3 class="no-margin">5123</h3>
                                            </div>
                                        </div><!-- ./col -->
                                        <div class="col-sm-6">
                                            <div class="widget-stat3 bg-info">
                                                <div class="widget-stat-icon">
                                                    <i class="fa fa-twitter fa-3x"></i>
                                                </div>
                                                <small class="text-upper">Follower</small>
                                                <h3 class="no-margin">981</h3>
                                            </div>
                                        </div><!-- ./col -->
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="widget-stat3 text-white" style="background-color:#ea4c89;">
                                                <div class="widget-stat-icon">
                                                    <i class="fa fa-dribbble fa-3x"></i>
                                                </div>
                                                <small class="text-upper">Follower</small>
                                                <h3 class="no-margin">1903</h3>
                                            </div>
                                        </div><!-- ./col -->
                                        <div class="col-sm-6">
                                            <div class="widget-stat3 bg-success">
                                                <div class="widget-stat-icon">
                                                    <i class="fa fa-eye fa-3x"></i>
                                                </div>
                                                <small class="text-upper">Visit</small>
                                                <h3 class="no-margin">2176</h3>
                                            </div>
                                        </div><!-- ./col -->
                                    </div><!-- ./row -->

                                    <div class="panel panel-default m-top-md">
                                        <div class="panel-heading">
                                            <i class="fa fa-twitter"></i> Latest Tweets
                                        </div>
                                        <ul class="list-group">
                                            <li class="list-group-item">
                                                <p>Welcome <a href="#" class="text-info">@John Doe</a> Lorem ipsum dolor
                                                    sit amet, consectetur adipiscing elit.</p>
                                                <small class="block text-muted">
                                                    <i class="fa fa-clock-o"></i> 6 minutes ago
                                                </small>
                                            </li>
                                            <li class="list-group-item">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. <a href="#"
                                                                                                               class="text-info">@Jand
                                                    Doe</a></p>
                                                <small class="block text-muted">
                                                    <i class="fa fa-clock-o"></i> 41 minutes ago
                                                </small>
                                            </li>
                                            <li class="list-group-item"><p><a href="#" class="text-info">@Bill Doe</a>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eros
                                                nibh, viverra a dui a, gravida varius velit.</p>
                                                <small class="block text-muted">
                                                    <i class="fa fa-clock-o"></i> 1 hour ago
                                                </small>
                                            </li>
                                        </ul><!-- /list-group -->
                                    </div><!-- ./panel -->
                                </div><!-- ./col -->
                            </div><!-- ./row -->
                        </div><!-- ./tab-pane -->
                        <div class="tab-pane fade" id="profileTab2">
                            <h4 class="header-text m-top-md">General Information</h4>
                            <form class="form-horizontal m-top-md">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Name</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" value="Jane Doe">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Surname</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Gender</label>
                                    <div class="col-sm-9">
                                        <div class="radio inline-block">
                                            <div class="custom-radio m-right-xs">
                                                <input type="radio" id="inlineRadio1" name="profileGender">
                                                <label for="inlineRadio1"></label>
                                            </div>
                                            <div class="inline-block vertical-top">Male</div>
                                        </div>
                                        <div class="radio inline-block m-left-sm">
                                            <div class="custom-radio m-right-xs">
                                                <input type="radio" id="inlineRadio2" name="profileGender">
                                                <label for="inlineRadio2"></label>
                                            </div>
                                            <div class="inline-block vertical-top">Female</div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Address</label>
                                    <div class="col-sm-9">
                                        <textarea rows="4" class="form-control"></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Phone</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" value="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Website</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" value="">
                                    </div>
                                </div>

                                <h4 class="header-text m-top-lg">Security Setting</h4>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Security Question</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" value="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Security Browsing</label>
                                    <div class="col-sm-9">
                                        <div class="m-top-xs">
                                            <div class="custom-checkbox">
                                                <input type="checkbox" id="securityChk1">
                                                <label for="securityChk1"></label>
                                            </div>
                                            Yes
                                            <div class="custom-checkbox m-left-sm">
                                                <input type="checkbox" id="securityChk2">
                                                <label for="securityChk2"></label>
                                            </div>
                                            No
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group m-top-lg">
                                    <label class="col-sm-3 control-label"></label>
                                    <div class="col-sm-9">
                                        <a class="btn btn-default">Submit</a>
                                        <a class="btn btn-info m-left-xs">Cancel</a>
                                    </div>
                                </div>
                            </form>
                        </div><!-- ./tab-pane -->
                        <div class="tab-pane fade" id="profileTab3">
                            <div class="profile-follower-list clearfix">
                                <ul>
                                    <li>
                                        <div class="panel panel-default clearfix">
                                            <div class="panel-body">
                                                <div class="user-wrapper">
                                                    <div class="user-avatar">
                                                        <img class="small-img img-circle img-thumbnail"
                                                             src="[@spring.url '/resources/images/profile/profile2.jpg'/]"
                                                             alt="">
                                                    </div>
                                                    <div class="user-detail small-img">
                                                        <div class="font-16">Karen Martin</div>
                                                        <small class="block text-muted font-12">Web Designer</small>
                                                        <small>
                                                            <small class="freelancer-rating">
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                            </small>
                                                        </small>

                                                        <div class="m-top-sm">
                                                            <button type="button"
                                                                    class="btn btn-default btn-sm marginTB-xs"
                                                                    disabled="" data-toggle="modal">following
                                                            </button>
                                                            <button type="button"
                                                                    class="btn btn-success btn-sm marginTB-xs"
                                                                    data-toggle="modal">View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div><!-- ./user-wrapper -->
                                            </div>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="panel panel-default clearfix">
                                            <div class="panel-body">
                                                <div class="user-wrapper">
                                                    <div class="user-avatar">
                                                        <img class="small-img img-circle img-thumbnail"
                                                             src="[@spring.url '/resources/images/profile/profile3.jpg'/]"
                                                             alt="">
                                                    </div>
                                                    <div class="user-detail small-img">
                                                        <div class="font-16">Sarah Garcia</div>
                                                        <small class="block text-muted font-12">Content Writing</small>
                                                        <small>
                                                            <small class="freelancer-rating">
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                            </small>
                                                        </small>

                                                        <div class="m-top-sm">
                                                            <button type="button"
                                                                    class="btn btn-default btn-sm marginTB-xs"
                                                                    disabled="" data-toggle="modal">following
                                                            </button>
                                                            <button type="button"
                                                                    class="btn btn-success btn-sm marginTB-xs"
                                                                    data-toggle="modal">View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div><!-- ./user-wrapper -->
                                            </div>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="panel panel-default clearfix">
                                            <div class="panel-body">
                                                <div class="user-wrapper">
                                                    <div class="user-avatar">
                                                        <img class="small-img img-circle img-thumbnail"
                                                             src="[@spring.url '/resources/images/profile/profile4.jpg'/]"
                                                             alt="">
                                                    </div>
                                                    <div class="user-detail small-img">
                                                        <div class="font-16">Jame Smith</div>
                                                        <small class="block text-muted font-12">Programmer</small>
                                                        <small>
                                                            <small class="freelancer-rating">
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                            </small>
                                                        </small>

                                                        <div class="m-top-sm">
                                                            <button type="button"
                                                                    class="btn btn-primary btn-sm marginTB-xs"
                                                                    data-toggle="modal">follow
                                                            </button>
                                                            <button type="button"
                                                                    class="btn btn-success btn-sm marginTB-xs"
                                                                    data-toggle="modal">View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div><!-- ./user-wrapper -->
                                            </div>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="panel panel-default clearfix">
                                            <div class="panel-body">
                                                <div class="user-wrapper">
                                                    <div class="user-avatar">
                                                        <img class="small-img img-circle img-thumbnail"
                                                             src="[@spring.url '/resources/images/profile/profile5.jpg'/]"
                                                             alt="">
                                                    </div>
                                                    <div class="user-detail small-img">
                                                        <div class="font-16">Elizabeth Carter</div>
                                                        <small class="block text-muted font-12">@Elizabeth</small>
                                                        <small>
                                                            <small class="freelancer-rating">
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                            </small>
                                                        </small>

                                                        <div class="m-top-sm">
                                                            <button type="button"
                                                                    class="btn btn-primary btn-sm marginTB-xs"
                                                                    data-toggle="modal">follow
                                                            </button>
                                                            <button type="button"
                                                                    class="btn btn-success btn-sm marginTB-xs"
                                                                    data-toggle="modal">View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div><!-- ./user-wrapper -->
                                            </div>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="panel panel-default clearfix">
                                            <div class="panel-body">
                                                <div class="user-wrapper">
                                                    <div class="user-avatar">
                                                        <img class="small-img img-circle img-thumbnail"
                                                             src="[@spring.url '/resources/images/profile/profile6.jpg'/]"
                                                             alt="">
                                                    </div>
                                                    <div class="user-detail small-img">
                                                        <div class="font-16">Christopher Brown</div>
                                                        <small class="block text-muted font-12">@Christopher</small>
                                                        <small>
                                                            <small class="freelancer-rating">
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                            </small>
                                                        </small>

                                                        <div class="m-top-sm">
                                                            <button type="button"
                                                                    class="btn btn-primary btn-sm marginTB-xs"
                                                                    data-toggle="modal">follow
                                                            </button>
                                                            <button type="button"
                                                                    class="btn btn-success btn-sm marginTB-xs"
                                                                    data-toggle="modal">View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div><!-- ./user-wrapper -->
                                            </div>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="panel panel-default clearfix">
                                            <div class="panel-body">
                                                <div class="user-wrapper">
                                                    <div class="user-avatar">
                                                        <img class="small-img img-circle img-thumbnail"
                                                             src="[@spring.url '/resources/images/profile/profile7.jpg'/]"
                                                             alt="">
                                                    </div>
                                                    <div class="user-detail small-img">
                                                        <div class="font-16">Jane Doe</div>
                                                        <small class="block text-muted font-12">janeDoe@company.com
                                                        </small>
                                                        <small>
                                                            <small class="freelancer-rating">
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                                <i class="fa fa-star text-warning"></i>
                                                            </small>
                                                        </small>

                                                        <div class="m-top-sm">
                                                            <button type="button"
                                                                    class="btn btn-primary btn-sm marginTB-xs"
                                                                    data-toggle="modal">follow
                                                            </button>
                                                            <button type="button"
                                                                    class="btn btn-success btn-sm marginTB-xs"
                                                                    data-toggle="modal">View Profile
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div><!-- ./user-wrapper -->
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div><!-- ./profile-follower-list -->
                        </div><!-- ./tab-pane -->
                    </div><!-- ./tab-content -->
                </div><!-- ./smart-widget-body -->
            </div><!-- ./smart-widget-inner -->
        </div><!-- ./smart-widget -->
    </div>
</div>

[#--文件上传进度--]
<div class="file_upload_load"></div>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script src="[@spring.url '/resources/js/upload/webuploader.js'/]"></script>
<script type="text/javascript">

    // 初始化Web Uploader
    uploader = WebUploader.create({
        // 自动上传。
        auto: true,
        // 文件接收服务端。
        server: '/upload/img_upload',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '.user-profile-pic',
        // 只允许选择文件，可选。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });

    // 当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {
        uploader.makeThumb(file, function (error, src) {
            if (error) {
                return;
            }
            $("#head-img").attr("src", src);
        }, 400, 400);
    });

    uploader.on('uploadProgress', function (file, percentage) {
        $('html').addClass('.file_upload_mask');
        $('.file_upload_load').show();
    });

    uploader.on('uploadSuccess', function (file, result) {
        $('html').removeClass('.file_upload_mask');
        $('.file_upload_load').hide();
        var url = result.files[0].url;

    });
</script>
[/@override]
[@extends name="/decorator.ftl"/]