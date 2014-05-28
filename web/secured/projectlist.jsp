<%@ page import="servlets.Constants" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/navigation" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 21/05/2014
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head lang="en">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Project List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <import:css_files/>
</head>

<body>

<nav:main_nav title="Project list">

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
</nav:main_nav>

<import:js_files/>

</body>
</html>
