<%@ tag import="control.dao.UserDAO" %>
<%@tag body-content="tagdependent" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="active" required="true" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports" %>

<!-- Get user -->
<%@ tag import="model.User" %>
<% User user = UserDAO.getUser(request.getRemoteUser()); %>
<%@ attribute name="body" fragment="true" %>
<base href="../../../">


<!--TODO agregarlo en un css aparte-->
<style>
    div.header-seperation {
        background-color: #0aa699;
    }

    img.logo {
        margin-top: 12px;
        margin-left: 28px;
    }

    div.page-sidebar {
        position: fixed;
    }

    span.space {
        margin-left: 5px;
    }

</style>

<!-- NAVBAR START -->
<div class="header navbar navbar-inverse ">
    <div class="navbar-inner">
        <!--LOGO START-->
        <div class="header-seperation">
            <a href="/index"><img src="/assets/img/logo.png" class="logo"></a>
        </div>
        <!--LOGO END-->

        <div class="header-quick-nav">
            <div class="pull-left">
                <ul class="nav quick-section">
                    <li class="m-r-10 input-prepend inside search-form no-boarder">
                        <span class="add-on"> <span class="iconset top-search"></span></span>
                        <input name="navSearch" type="text" class="no-boarder " placeholder="Search"
                               style="width:250px;">
                    </li>
                </ul>
            </div>
            <!-- END TOP NAVIGATION MENU -->
            <!-- BEGIN CHAT TOGGLER -->
            <div class="pull-right">
                <div class="chat-toggler">
                    <a href="#" class="dropdown-toggle" id="my-task-list" data-placement="bottom" data-content=''
                       data-toggle="dropdown" data-original-title="Notifications">
                        <div class="user-details">
                            <div class="username">
                                <span class="badge badge-important">1</span>
                                <%=user.getFirstName()%> <span class="bold"><%=user.getLastName()%></span>
                            </div>
                        </div>
                        <div class="iconset top-down-arrow"></div>
                    </a>

                    <div class="profile-pic">
                        <img src="assets/img/profiles/avatar_small.jpg" width="35" height="35"/>
                    </div>
                </div>
                <ul class="nav quick-section ">
                    <li class="quicklinks">
                        <a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="#" id="user-options">
                            <div class="iconset top-settings-dark "></div>
                        </a>
                        <ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="user-options">
                            <li><a href="user-profile.html"> Profile</a>
                            </li>
                            <li><a href="calender.html">Notifications</a>
                            </li>
                            <li><a href="email.html"> Messages&nbsp;&nbsp;<span
                                    class="badge badge-important animated bounceIn">2</span></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="login.html"><i class="fa fa-power-off"></i>&nbsp;&nbsp;Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- END CHAT TOGGLER -->
        </div>
        <!-- END TOP NAVIGATION MENU -->

    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>

<!-- END HEADER -->
<!-- BEGIN CONTAINER -->

<!-- BEGIN SIDEBAR -->
<div class="page-sidebar" id="main-menu">
    <!-- BEGIN SIDEBAR MENU -->
    <br>
    <ul>
        <li id="sidenav-home">
            <a href="/index">
                <i class="icon-custom-home"></i>
                <span class="title">Home</span>


            </a>
        </li>
        <li id="sidenav-notifications">
            <a>
                <i class="fa fa-flag"></i>
                <span class="title">Notifications</span>
                <span class="badge badge-important pull-right"><%=user.getUnreadNotificationsQty()%></span>
            </a>
        </li>
        <li id="sidenav-messages">
            <a href="javascript:;">
                <i class="fa fa-envelope"></i>
                <span class="title">Messages</span>
                <span class="arrow"></span>
            </a>
            <ul class="sub-menu" style="overflow: hidden;">
                <li><a> Inbox </a></li>
                <li><a> Sent </a></li>
                <li><a> Create new </a></li>

            </ul>

        </li>
        <li id="sidenav-profile">
            <a>
                <i class="fa fa-user"></i>
                <span class="title">Profile</span>
            </a>
        </li>
        <li id="sidenav-projects">
            <a>
                <i class="icon-custom-chart"></i>
                <span class="title">Projects</span>
            </a>
        </li>
        <li id="sidenav-community">
            <a>
                <i class="fa fa-users"></i>
                <span class="title">Community</span>
                <span class=" badge badge-disable pull-right "><%=user.getCommunityUpdatesQty()%></span>
            </a>
        </li>
        <li id="sidenav-advanced_search">
            <a>
                <i class="fa fa-search"></i>
                <span class="title">Advanced Search</span>
            </a>
        </li>
        <li id="sidenav-settings">
            <a>
                <i class="icon-custom-settings"></i>
                <span class="title">Settings</span>
            </a>
        </li>
        <li id="sidenav-about">
            <a>
                <i class="fa fa-info"></i>
                <span class="title">About</span>
            </a>

        </li>
    </ul>
    <div class="clearfix"></div>
    <!-- END SIDEBAR MENU -->
</div>


</div>
<!-- END SIDEBAR -->
<!-- BEGIN PAGE CONTAINER-->
<div class="page-content">
    <div class="clearfix"></div>
    <div class="content">
        <div class="page-title">
            <h3><span class="semi-bold">${title}</span></h3>
        </div>
        <div id="container">
            <jsp:invoke fragment="body"/>
            <!-- END PAGE -->
        </div>
    </div>
    <!-- END CONTAINER -->
</div>
<import:js_files></import:js_files>
<script>
    //Sets the corresponding section to the side nav as active
    $("#sidenav-${active}").addClass("start active");
</script>


