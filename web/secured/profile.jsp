<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports"%>
<%@taglib prefix="navigation" tagdir="/WEB-INF/tags/navigation" %>

<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 03/07/2014
  Time: 04:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <import:css_files/>
</head>
<body>
    <navigation:main_nav title= " User Profile" active="projects">
        <jsp:attribute name="body">
          <!-- BEGIN PAGE CONTAINER-->
  <div class="page-content condensed">

  <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
  <div id="portlet-config" class="modal hide">
      <div class="modal-header">
          <button data-dismiss="modal" class="close" type="button"></button>
          <h3>Widget Settings</h3>
      </div>
      <div class="modal-body"> Widget settings form goes here </div>
  </div>
  <div class="clearfix"></div>
  <div class="content">
  <div class="row">
  <div class="col-md-6">
      <div class=" tiles white col-md-12 no-padding">
          <div class="tiles green cover-pic-wrapper">
              <div class="overlayer bottom-right">
                  <div class="overlayer-wrapper">
                      <div class="padding-10 hidden-xs">
                          <button type="button" class="btn btn-primary btn-small"><i class="fa fa-check"></i>&nbsp;&nbsp;Following</button> <button type="button" class="btn btn-primary btn-small">Add</button>
                      </div>
                  </div>
              </div>
              <img src="../assets/img/cover_pic.png" alt="">
          </div>
          <div class="tiles white">

              <div class="row">
                  <div class="col-md-3 col-sm-3" >
                      <div class="user-profile-pic">
                          <img width="69" height="69" data-src-retina="secured/media/img/defaultuserpic.png" data-src="secured/media/img/defaultuserpic.png" src="secured/media/img/defaultuserpic.png" alt="">
                      </div>
                      <div class="user-mini-description">
                          <h3 class="text-success semi-bold">
                              ${requestScope.profiling.getFollowers().size()}
                          </h3>
                          <h5>Followers</h5>
                          <h3 class="text-success semi-bold">
                              457
                          </h3>
                          <h5>Following</h5>
                      </div>
                  </div>
                  <div class="col-md-5 user-description-box  col-sm-5">
                      <h4 class="semi-bold no-margin">${requestScope.profiling.getFirstName()} ${requestScope.profiling.getLastName()}</h4>
                      <h6 class="no-margin">${requestScope.profiling.getUserName()}</h6>
                      <br>
                      <p><i class="fa fa-envelope"></i>Send Message</p>
                  </div>
              </div>

              <div class="row">
                  <div class="col-md-12  col-sm-4">
                      <h5 ><span class="semi-bold">TOP 5 PROJECTS</span>&nbsp;&nbsp; <a href="#" class="text-info normal-text">view more</a></h5>
                      <div class="row">
                          <!-- JSTL to display top 5 projects from progression standpoint-->
                          <div class="col-md-3">
                              <div class="friend-list">
                                  <c:forEach var="project" items="${requestScope.projects}" >
                                  <div class="friend-profile-pic">
                                      <div class="user-profile-pic-normal">
                                          <img width="35" height="35" src="../assets/img/profiles/d.jpg" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" alt="">
                                      </div>
                                  </div>
                                  <div class="friend-details-wrapper">
                                      <div class="friend-name">
                                          Johne Drake
                                      </div>
                                      <div class="friend-description">
                                          James Smith in commman
                                      </div>
                                  </div>
                                  <div class="action-bar pull-right">
                                      <button class="btn btn-primary" type="button">Add</button>
                                  </div>
                                  <div class="clearfix"></div>
                                  </c:forEach>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>

          </div>
      </div>

  </div>

  <div class="col-md-6">
      <div class="row">
          <div class="col-md-12 no-padding">
              <div class="tiles white">
                  <textarea rows="3"  class="form-control user-status-box post-input"  placeholder="Whats on your mind?"></textarea>
              </div>
              <div class="tiles grey padding-10">
                  <div class="pull-left">
                      <button class="btn btn-default btn-sm btn-small" type="button"><i class="fa fa-camera"></i></button>
                      <button class="btn btn-default btn-sm btn-small" type="button"><i class="fa fa-map-marker"></i></button>
                  </div>
                  <div class="pull-right">
                      <button class="btn btn-primary btn-sm btn-small" type="button">POST</button>
                  </div>
                  <div class="clearfix"></div>
              </div>
          </div>
      </div>
      <br>
      <br>
      <div class="row">
          <div class="post col-md-12">
              <div class="user-profile-pic-wrapper">
                  <div class="user-profile-pic-normal">
                      <img width="35" height="35" src="../assets/img/profiles/c.jpg" data-src="assets/img/profiles/c.jpg" data-src-retina="assets/img/profiles/c2x.jpg" alt="">
                  </div>
              </div>
              <div class="info-wrapper">
                  <div class="username">
                      <span class="dark-text">John Drake</span> in <span class="dark-text">nervada hotspot</span>
                  </div>
                  <div class="info">
                      Great design concepts by <span class="dark-text">John Smith</span> and his crew! Totally owned the WCG!, Best of luck for your future endeavours,
                      Special thanks for <span class="dark-text">Jane smith</span> for her motivation ;)
                  </div>
                  <div class="more-details">
                      <ul class="post-links">
                          <li><a href="#" class="muted">2 Minutes ago</a></li>
                          <li><a href="#" class="text-info">Collapse</a></li>
                          <li><a href="#" class="text-info" ><i class="fa fa-reply"></i> Reply</a></li>
                          <li><a href="#" class="text-warning"><i class="fa fa-star"></i> Favourited</a></li>
                          <li><a href="#"  class="muted">More</a></li>
                      </ul>
                  </div>
                  <div class="clearfix"></div>

                  <ul class="action-bar">
                      <li><a href="#"  class="muted"><i class="fa fa-comment"></i> 1584</a> Comments</li>
                      <li><a href="#" class="text-error" ><i class="fa fa-heart"></i> 47k</a> likes</li>
                  </ul>
                  <div class="clearfix"></div>
                  <div class="post comments-section">
                      <div class="user-profile-pic-wrapper">
                          <div class="user-profile-pic-normal">
                              <img width="35" height="35" data-src-retina="assets/img/profiles/e2x.jpg" data-src="assets/img/profiles/e.jpg" src="../assets/img/profiles/e.jpg" alt="">
                          </div>
                      </div>
                      <div class="info-wrapper">
                          <div class="username">
                              <span class="dark-text">Thunderbolt</span>
                          </div>
                          <div class="info">
                              Congrats, <span class="dark-text">John Smith</span>  & <span class="dark-text">Jane Smith</span>
                          </div>
                          <div class="more-details">
                              <ul class="post-links">
                                  <li><a href="#" class="muted">2 Minutes ago</a></li>
                                  <li><a href="#" class="text-error" ><i class="fa fa-heart"></i> Like</a></li>
                                  <li><a href="#"  class="muted">Details</a></li>
                              </ul>
                          </div>

                      </div>
                      <div class="clearfix"></div>
                  </div>
                  <div class="post comments-section">
                      <div class="user-profile-pic-wrapper">
                          <div class="user-profile-pic-normal">
                              <img width="35" height="35" data-src-retina="assets/img/profiles/b2x.jpg" data-src="assets/img/profiles/b.jpg" src="../assets/img/profiles/b.jpg" alt="">
                          </div>
                      </div>
                      <div class="info-wrapper">
                          <div class="username">
                              <span class="dark-text">Thunderbolt</span>
                          </div>
                          <div class="info">
                              Congrats, <span class="dark-text">John Smith</span>  & <span class="dark-text">Jane Smith</span>
                          </div>
                          <div class="more-details">
                              <ul class="post-links">
                                  <li><a href="#" class="muted">2 Minutes ago</a></li>
                                  <li><a href="#" class="text-error" ><i class="fa fa-heart"></i> Like</a></li>
                                  <li><a href="#"  class="muted">Details</a></li>
                              </ul>
                          </div>

                      </div>
                      <div class="clearfix"></div>
                  </div>
                  <div class="post comments-section">
                      <div class="row-fluid">
                          <div class="input-append success date span12">
                              <input type="text" class="span11">
                              <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="clearfix"></div>
          </div>
      </div>
  </div>
  </div>



  </div>
  </div>
<!-- END CONTAINER -->
</div>
        </jsp:attribute>
    </navigation:main_nav>

<import:js_files/>
</body>
</html>
