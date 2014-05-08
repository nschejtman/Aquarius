<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 19/03/14
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="resources/scripts/jquery-1.10.2.min.js"></script>
    <link href="resources/stylesheets/bootstrap.min.css" rel="stylesheet">
    <script src="resources/scripts/bootstrap.min.js"></script>
    <script src="resources/scripts/less-1.7.0.min.js"></script>
    <link href="resources/stylesheets/less/aq_style.less" rel="stylesheet/less">
</head>
<body>
<!-- Static navbar -->
<div class="navbar navbar-inverse navbar-static-top" role="navigation">
    <div style="margin-left: 20px; margin-right: 20px" class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Aquarius</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Projects <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="">Top valuated</a></li>
                        <li><a href="@routes.Patients.newPatient()">Followed projects</a></li>
                        <li><a href="@routes.Patients.searchView()">Search</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">User<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/login.jsp">Log in</a></li>
                        <li><a href="/register.jsp">Register</a></li>
                    </ul>
                </li>
            </ul>


        </div>
        <!--/.nav-collapse -->
    </div>
</div>
</body>
</html>
