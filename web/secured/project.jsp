<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 11/05/2014
  Time: 05:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="project" value="${requestScope.project}" scope="page"/>
<c:set var="url" value="${pageContext.request.contextPath}/goTo?goto&q=${requestScope.project.getId()}" scope="page"/>
<c:set var="userThatAsked" value="${question.getUser().equals(sessionScope.loggedUser)}" scope="request"/>
<html>
</header>
<div class="ProjectBody" style="width: 650px">
    <div class="Shadow">sdff</div>
    <div class="QuestionsClass">
        <jsp:include page="../secured/projectcontrolpanel.jsp"/>
        <jsp:include page="../secured/projectclass.jsp"/>
    </div>

</div>
</html>
