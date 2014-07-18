<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 20/05/2014
  Time: 03:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<c:set var="project" value="${requestScope.project}" scope="request"/>
<c:if test="${project.isActive()}">
    <div class="ClosedProject">
    </div>
</c:if>
<div class="UserProject">
    <c:out value="${project.getUser().getUserName()}"/>
</div>
<div class="Title">
    <c:out value="${project.getName()}"/>
</div>
<div class="Description">
    <c:out value="${project.getDescription()}" escapeXml="false"/>
</div>
<div class="Objective">
    <c:out value="${project.getObjective()}"/>
</div>

</html>


