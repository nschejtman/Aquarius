<%@ page import="model.Project" %>
<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 20/05/2014
  Time: 03:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% Project project = (Project) request.getAttribute("project");%>
<html>

<div class="UserProject">
    <c:set var="project" value="${requestScope.project}" scope="request"/>
    <a href="/aquarius/viewProfile?u=${project.getUser().getUserName()}"> <c:out
            value="${project.getUser().getUserName()}"/></a>
</div>
<div class="Title">
    <c:out value="${project.getName()}" escapeXml="false"/>
</div>
<div class="Question">
    <c:out value="${str}" escapeXml="false"/>
</div>
<div class="Tags">
    <%--<c:out value="Tags: ${question.getTags()}"/><p>--%>
    <c:out value="Tags:"/>
    <c:forEach var="tag" items="${question.getTags()}" varStatus="pStatus">
        <a href="/studyroom/filterByTag?byTag&t=${tag.getId()}"> <c:out value="${tag}"/></a>
    </c:forEach>
    <%=project.getName()%>
</div>
</html>

