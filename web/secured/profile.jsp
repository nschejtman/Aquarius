<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports" %>
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
<navigation:main_nav title="User Profile" active="profile">
        <jsp:attribute name="body">
          <!-- BEGIN PAGE CONTAINER-->
  <div class="page-content condensed">

      <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
      <div class="content" style="padding-top: 10px">
          <div class="row">
              <div class=" tiles white col-md-12 no-padding">
                  <div class="tiles green cover-pic-wrapper">
                      <div class="overlayer bottom-right">
                          <div class="overlayer-wrapper">
                              <div class="padding-10 hidden-xs">
                                  <button type="button" class="btn btn-primary btn-small"><i class="fa fa-check"></i>&nbsp;&nbsp;Follow
                                  </button>
                                  <button type="button" class="btn btn-primary btn-small">Send Message</button>
                              </div>
                          </div>
                      </div>
                      <img src="../assets/img/profile_cover.jpg" alt="" width="100%">
                  </div>
                  <div class="tiles white">

                      <div class="row">
                          <div class="col-md-3 col-sm-3">
                              <div class="user-profile-pic">
                                  <img width="69" height="69" data-src-retina="secured/media/img/defaultuserpic.png"
                                       data-src="secured/media/img/defaultuserpic.png"
                                       src="secured/media/img/defaultuserpic.png" alt="">
                              </div>
                              <div class="user-mini-description">
                                  <h3 class="text-success semi-bold">
                                          ${requestScope.profiling.getFollowers().size()}
                                  </h3>
                                  <h5>Followers</h5>

                                  <h3 class="text-success semi-bold">
                                          ${requestScope.followed}
                                  </h3>
                                  <h5>Following</h5>
                              </div>
                          </div>
                          <div class="col-md-8 user-description-box  col-sm-8">
                              <h3 class="semi-bold no-margin">${requestScope.profiling.getFirstName()} ${requestScope.profiling.getLastName()}</h3>
                              <h4 class="no-margin">${requestScope.profiling.getUserName()}</h4>
                              <h6 class="no-margin">Reputation: ${requestScope.profiling.reputation}</h6>
                          </div>
                      </div>
                      <br>
                      <br>

                      <!--TOP OWNED PROJECTS-->
                      <div class="row" style="padding: 20px">
                          <div class="col-md-12  col-sm-4">
                              <h5><span class="semi-bold">Top Owned Projects</span>&nbsp;&nbsp; <a href="#"
                                                                                                   class="text-info normal-text">view
                                  more</a></h5>

                              <div class="row">
                                  <!-- JSTL to display top 3 projects from progression standpoint-->
                                  <c:forEach var="project" items="${requestScope.projects}">
                                      <div class="col-md-4">
                                          <div class="friend-list">

                                              <div class="friend-profile-pic">
                                                  <div class="user-profile-pic-normal">
                                                      <img width="35" height="35" src="../assets/img/briefcase.png">
                                                  </div>
                                              </div>
                                              <div class="friend-details-wrapper">
                                                  <div class="friend-name">
                                                          ${project.name}
                                                  </div>
                                                  <div class="friend-description">
                                                      Objective: $ ${project.objective}
                                                  </div>
                                                  <div class="project-followers">
                                                      Followers: ${project.getFollowersQty()}
                                                  </div>
                                              </div>
                                              <div class="action-bar">
                                                  <button class="btn btn-primary" type="button">Follow</button>
                                              </div>
                                              <div class="clearfix"></div>
                                          </div>
                                      </div>
                                  </c:forEach>
                              </div>
                          </div>
                      </div>


                      <!-- Make TOP 3 projects following-->
                      <div class="row" style="padding: 20px">
                          <div class="col-md-12  col-sm-4">
                              <h5><span class="semi-bold">Top Followed Projects</span>&nbsp;&nbsp; <a href="#"
                                                                                                      class="text-info normal-text">view
                                  more</a></h5>

                              <div class="row">
                                  <!-- JSTL to display top 3 projects from progression standpoint-->
                                  <c:forEach var="project" items="${requestScope.following}">
                                      <div class="col-md-4">
                                          <div class="friend-list">

                                              <div class="friend-profile-pic">
                                                  <div class="user-profile-pic-normal">
                                                      <img width="35" height="35"
                                                           src="${requestScope.project.user.profilePicture.path}"
                                                           data-src="assets/img/profiles/d.jpg"
                                                           data-src-retina="assets/img/profiles/d2x.jpg" alt="">
                                                  </div>
                                              </div>
                                              <div class="friend-details-wrapper">
                                                  <div class="friend-name">
                                                          ${project.name}
                                                  </div>
                                                  <div class="friend-description">
                                                      Objective: $ ${project.objective}
                                                  </div>
                                                  <div class="project-followers">
                                                      Followers: ${project.getFollowersQty()}
                                                  </div>
                                              </div>
                                              <div class="action-bar pull-right">
                                                  <button class="btn btn-primary" type="button">Follow</button>
                                              </div>
                                              <div class="clearfix"></div>
                                          </div>
                                      </div>
                                  </c:forEach>
                              </div>
                          </div>
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

</body>
</html>
