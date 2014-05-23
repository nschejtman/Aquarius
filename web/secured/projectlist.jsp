<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="control.dao.ProjectDAO" %>
<%@ page import="model.Project" %>
<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 21/05/2014
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!-- Code inside forEach TODO-->
<% Project project = ProjectDAO.getProject(1);%>
<a href="/editproject?projectID=<%=project.getId()%>">Edit project</a>

</body>
</html>
