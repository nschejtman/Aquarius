<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports"%>
<html>
<head>
    <import:css_files/>
    <import:js_files/>
</head>

<body>
<!--define tag library for imports-->
<%--<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports" %>--%>


<%--TODO tiene que recibir el user como parametro del jsp que se lo pasa--%>

<!-- Get user -->

<%@ page import="control.dao.UserDAO" %>
<%@ page import="model.User" %>
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
    span.space {
        margin-left: 5px;
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
            <a href="">
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
                <span class=" badge badge-disable pull-right "><%=user.getUnreadMessagesQty()%></span>
            </a>
            <ul class="sub-menu" style="overflow: hidden; display: block;">
                <li><a href=""> Inbox </a></li>
                <li><a href=""> Sent </a></li>
                <li><a href=""> Create new </a></li>

            </ul>

        </li>
        <li id="sidenav-profile">
            <a href="">
                <i class="fa fa-user"></i>
                <span class="title">Profile</span>
            </a>
        </li>
        <li id="sidenav-projects">
            <a href="">
                <i class="icon-custom-chart"></i>
                <span class="title">Projects</span>
            </a>
        </li>
        <li id="sidenav-community">
            <a href="">
                <i class="fa fa-users"></i>
                <span class="title">Community</span>
                <span class=" badge badge-disable pull-right "><%=user.getCommunityUpdatesQty()%></span>
            </a>
        </li>
        <li id="sidenav-advanced_search">
            <a href="">
                <i class="fa fa-search"></i>
                <span class="title">Advanced Search</span>
            </a>
        </li>
        <li id="sidenav-settings">
            <a href="">
                <i class="icon-custom-settings"></i>
                <span class="title">Settings</span>
            </a>
        </li>
        <li id="sidenav-about">
            <a onclick="sayHi()">
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

        <form id = "projectForm" method = "post" action ="secured/addproject">
        <!-- BEGIN BASIC FORM ELEMENTS-->
        <div class="row">
            <div class="col-md-12">
                <div class="grid simple">
                    <div class="grid-title no-border">
                        <h4>Project <span class="semi-bold">Data</span></h4>
                        <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                    </div>
                    <div class="grid-body no-border"> <br>
                        <div class="row">
                            <div class="col-md-8 col-sm-8 col-xs-8">
                                <div class="form-group">
                                    <label class="form-label">Project Name</label>
                                    <div class="controls">
                                        <input name="projectName" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Objective</label>
                                    <span class="help">e.g. "$45.50"</span>
                                    <div class="controls">
                                        <input name="objective" type="text" class="form-control" data-a-sign="$ ">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END BASIC FORM ELEMENTS-->

        <!-- BEGIN DROPDOWN CONTROLS-->
        <div class="row">
            <div class="col-md-4">
                <div class="grid simple">
                    <div class="grid-title no-border">
                        <h4>Select <span class="semi-bold">Type</span></h4>
                        <div class="tools"> <a class="collapse" href="javascript:;"></a> <a class="config" data-toggle="modal" href="#grid-config"></a> <a class="reload" href="javascript:;"></a> <a class="remove" href="javascript:;"></a> </div>
                    </div>
                    <div class="grid-body no-border">
                        <div class="row">
                            <div class="col-md-12">
                                <br>
                                <select id="source" name = "type" style="width:100%">
                                        <optgroup label="TYPES">
                                            <c:forEach var="type" items="${requestScope.types}" >
                                            <option> ${type.name} </option>
                                            </c:forEach>
                                        </optgroup>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END DROPDOWN CONTROLS-->

        <!-- BEGIN DATEPICKER CONTROLS-->
        <div class="row">
            <div class="col-md-12">
                <div class="grid simple">
                    <div class="grid-title no-border">
                        <h4>Date <span class="semi-bold">Controls</span></h4>
                        <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                    </div>
                    <div class="grid-body no-border">
                        <div class="row">
                            <div class="col-md-4">
                                <h3>Start Date<span class="semi-bold"> Picker</span></h3>
                                <br>
                                <div class="input-append success date col-md-10 col-lg-6 no-padding">
                                    <input type="text" class="form-control">
                                    <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span> </div>
                                <br>
                                <br>
                                <div class="clearfix"></div>

                                <h3>End Date<span class="semi-bold"> Picker</span></h3>
                                <div class="input-append success date col-md-10 col-lg-6 no-padding">
                                    <input type="text" class="form-control">
                                    <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span> </div>
                                <br>
                                <br>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END DATEPICKER CONTROLS-->

        <!-- BEGIN HTML5 WYSIWG CONTROLS-->
        <div class="row">
            <div class="col-md-12">
                <div class="grid simple">
                    <div class="grid-title no-border">
                        <h4>Describe your <span class="semi-bold">Project</span></h4>
                        <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                    </div>
                    <div class="grid-body no-border">

                        <h3>Write <span class="semi-bold">Description</span></h3>
                        <code>textarea</code> </p>
                        <br>
                        <textarea id="text-editor" name="description" placeholder="Enter text ..." class="form-control" rows="10"></textarea>

                    </div>
                </div>
            </div>
        </div>
        <!-- END HTML5 WYSIWG CONTROLS-->

        <!-- BEGIN TAG INPUTS -->
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6">
                        <div class="grid simple">
                            <div class="grid-title no-border">
                                <h4>Tags <span class="semi-bold">Input</span></h4>
                                <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>
                            </div>
                            <div class="grid-body no-border">
                                <div class="row-fluid">
                                    <h3>Tag <span class="semi-bold">Input</span></h3>
                                    <br>
                                    <input class="span12 tagsinput" id="source-tags" type="text"  />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END TAG INPUTS -->
        <button type="submit" class="btn btn-primary btn-cons"><i class="fa fa-check"></i>&nbsp;Submit</button>


    </form>
</div>

<!-- END CONTAINER -->
</div>

<%--<import:js_files/>--%>

<script>
    //Sets the corresponding section to the side nav as active
    $("#sidenav-${active}").addClass("start active");
</script>

</body>
</html>
