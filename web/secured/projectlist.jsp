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
<%@ page import="servlets.Constants" %>
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

<!-- END SIDEBAR -->
<!-- BEGIN PAGE CONTAINER-->
<div class="page-content">
    <div class="clearfix"></div>
    <div class="content">
        <div class="page-title">
            <h3>${title} </h3>
        </div>
        <div id="container">
            <div class="row-fluid">
                <div class="span12">
                    <div class="grid simple ">
                        <div class="grid-title">
                            <h4><span class="semi-bold">Projects</span></h4>
                            <div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> </div>
                        </div>
                        <div class="grid-body ">
                            <table class="table table-hover table-condensed" id="example">
                                <thead>
                                <tr>
                                    <th style="width:1%"><div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                        <input type="checkbox" value="1" id="checkbox1">
                                        <label for="checkbox1"></label>
                                    </div></th>
                                    <th style="width:10%">Project Name</th>
                                    <th style="width:22%" data-hide="phone,tablet">Description</th>
                                    <th style="width:6%">Objective</th>
                                    <th style="width:10%" data-hide="phone,tablet">Progress</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="project" items="${requestScope.projects}" >
                                    <tr >
                                        <td class="v-align-middle"><div class="checkbox check-default">
                                            <input type="checkbox" value="3" id="checkbox2">
                                            <label for="checkbox2"></label>
                                        </div></td>
                                        <td class="v-align-middle"><c:out value="${project.name}"/></td>
                                        <td class="v-align-middle"><span class="muted"><c:out value="${project.description}" escapeXml="false"/></span></td>
                                        <td><span class="muted"><c:out value="${project.objective}"/></span></td>
                                        <td class="v-align-middle">
                                            <div class="progress ">
                                                <div data-percentage="<c:out value="${project.getProgress()}"/>"  class=<%=Constants.PRIMARY_BAR%>></div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <!-- END PAGE -->
        </div>
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
