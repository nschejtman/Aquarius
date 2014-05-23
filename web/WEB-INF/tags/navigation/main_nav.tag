<%@ tag import="control.dao.UserDAO" %>
<%@tag body-content="tagdependent" %>
<%@ attribute name="title" required="true" %>
<%--TODO tiene que recibir el user como parametro del jsp que se lo pasa--%>


<!-- Get user -->
<%@ tag import="model.User" %>
<% User user = UserDAO.getUser(request.getRemoteUser()); %>
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
    /*TODO agregarlo al css del login
    /*@font-face {*/
        /*font-family: 'FontsGotSwag';*/
        /*src: url('../../../assets/fonts/PeachMilk.eot?') format('eot'),*/
        /*url('../../../assets/fonts/PeachMilk.woff') format('woff'),*/
        /*url('../../../assets/fonts/PeachMilk.ttf')  format('truetype'),*/
        /*url('../../../assets/fonts/PeachMilk.svg#PeachMilk') format('svg');*/
    /*}*/

    div.page-sidebar{
        position: fixed;
    }

</style>


<!-- NAVBAR START -->
<div class="header navbar navbar-inverse ">
    <div class="navbar-inner">
        <!--LOGO START-->
        <div class="header-seperation">
            <a href="/index"><img src="assets/img/logo.png" class="logo"></a>
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
                                <span class="badge badge-important"><%=user.unreadNotifications()%></span>
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
        <li class="start active ">
            <a href="/index">
                <i class="icon-custom-home"></i>
                <span class="title">Home</span>
                <span class="selected"></span>
                <span class="badge badge-important pull-right">5</span>
            </a>
        </li>
        <li class="">
            <a href="">
                <i class="fa fa-flag"></i>
                <span class="title">Notifications</span>
            </a>
        </li>
        <li class="">
            <a href="">
                <i class="fa fa-envelope"></i>
                <span class="title">Messages</span>
                <span class=" badge badge-disable pull-right ">203</span>
            </a>
        </li>
        <li class="">
            <a href="">
                <i class="fa fa-user"></i>
                <span class="title">Profile</span>
            </a>
        </li>
        <li class="">
            <a href="">
                <i class="icon-custom-chart"></i>
                <span class="title">Projects</span>
            </a>
        </li>
        <li>
            <a href="">
                <i class="fa fa-users"></i>
                <span class="title">Community</span>
            </a>
        </li>
        <li>
            <a href="">
                <i class="fa fa-search"></i>
                <span class="title">Advanced Search</span>
            </a>
        </li>
        <li class="">
            <a href="">
                <i class="icon-custom-settings"></i>
                <span class="title">Settings</span>
            </a>
        </li>
        <li class="">
            <a href="">
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
            <h3>${title} </h3>
        </div>
        <div id="container">

            <!-- END PAGE -->
        </div>
    </div>
    <!-- END CONTAINER -->
</div>

