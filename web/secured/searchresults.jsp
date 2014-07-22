<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports"%>
<%@taglib prefix="navigation" tagdir="/WEB-INF/tags/navigation" %>

<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 22/07/2014
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <import:css_files/></head>
    <link href="../assets/plugins/jquery-superbox/css/style.css" rel="stylesheet" type="text/css" media="screen"/>

<body>
    <navigation:main_nav title= "Search" active="search">
        <jsp:attribute name="body">
            <!-- BEGIN PAGE CONTAINER-->
  <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
  <div class="content">
  <div class="page-title"> <i class="icon-custom-left"></i>
      <h3>Search - <span class="semi-bold">Results</span></h3>
  </div>
  <div class="pull-left" id="Filters">
      <div class="btn-group"> <a href="#" data-toggle="dropdown" class="btn dropdown-toggle btn-demo-space"> <span class="anim150">Region</span> <span class="caret"></span> </a>
          <ul class="dropdown-menu">
              <li class="active" data-filter="all" data-dimension="region"><a href="#">All</a></li>
              <li data-filter="alaska" data-dimension="region"><a href="#">Alaska</a></li>
              <li data-filter="intermountain" data-dimension="region"><a href="#">Intermountain</a></li>
              <li data-filter="northeast" data-dimension="region"><a href="#">Northeast</a></li>
              <li data-filter="pacific_west" data-dimension="region"><a href="#">Pacific</a> </li>
              <li data-filter="southeast" data-dimension="region"><a href="#">Southeast</a></li>
          </ul>
      </div>
      <div class="btn-group"> <a href="#" data-toggle="dropdown" class="btn dropdown-toggle btn-demo-space"> <span class="anim150">Recreation</span> <span class="caret"></span> </a>
          <ul class="dropdown-menu">
              <li class="active" data-filter="all" data-dimension="recreation"><a href="#">All</a></li>
              <li data-filter="camping" data-dimension="recreation"><a href="#">Camping</a></li>
              <li data-filter="climbing" data-dimension="recreation"><a href="#">Climbing</a></li>
              <li data-filter="fishing" data-dimension="recreation"><a href="#">Fishing</a></li>
              <li data-filter="swimming" data-dimension="recreation"><a href="#">AlSwimmingl</a></li>
          </ul>
      </div>
  </div>
  <div class="pull-right">
      <div data-toggle="buttons-radio" class="btn-group">
          <button class="btn btn-primary active" type="button" id="ToList"><i class="fa fa-th-list"></i></button>
          <button class="btn btn-primary" type="button" id="ToGrid"><i class="fa fa-th-large"></i></button>
      </div>
  </div>
  <div class="clearfix"></div>
  <br>
  <div id="Parks" class="just">
  <!-- "TABLE" HEADER CONTAINING SORT BUTTONS (HIDDEN IN GRID MODE)-->
  <div class="list_header">
      <div class="meta name active desc" id="SortByName"> Name &nbsp; <span class="sort anim150 asc active" data-sort="data-name" data-order="desc"></span> <span class="sort anim150 desc" data-sort="data-name" data-order="asc"></span> </div>
      <div class="meta region">User</div>
      <div class="meta rec">Tags</div>
      <div class="meta area" id="SortByArea"> Funds &nbsp; <span class="sort anim150 asc" data-sort="data-area" data-order="asc"></span> <span class="sort anim150 desc" data-sort="data-area" data-order="desc"></span> </div>
  </div>
  <!-- FAIL ELEMENT -->
  <div class="fail_element anim250">Sorry &mdash; we could not find any parks matching matching these criteria</div>
  <!-- BEGIN LIST OF PARKS (MANY OF THESE ELEMENTS ARE VISIBLE ONLY IN LIST MODE)-->
  <ul>
  <c:forEach var="project" items="${requestScope.projects}">
  <li class="mix northeast camping climbing fishing swimming" data-name="Acadia" data-area="47452.80">
      <div class="meta name">
          <div class="img_wrapper"> <img src="../assets/img/others/acadia.jpg" alt="" /> </div>
          <div class="titles">
              <h2>${project.name}</h2>
          </div>
      </div>
      <div class="meta region">
          <p>${(project.user).userName}</p>
      </div>
      <div class="meta rec">
          <ul>
              <c:forEach var="tag" items="${project.tags}">
                  <li>${tag.name}</li>
              </c:forEach>
          </ul>
      </div>
      <div class="meta area">
          <p>${project.getFundsRaised()}</p>
      </div>
  </li>
      </c:forEach>
  <!-- END LIST OF PARKS -->
  </ul>
  </div>
  </div>
  <!-- END PAGE -->
        </jsp:attribute>
    </navigation:main_nav>
<import:js_files/>
    <script src="../assets/plugins/jquery-mixitup/jquery.mixitup.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <script src="../assets/js/search_results.js" type="text/javascript"></script>
</body>
</html>
