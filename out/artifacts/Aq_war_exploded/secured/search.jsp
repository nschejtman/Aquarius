<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 30/04/2014
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
    <form id="projectSearch" method="post" action="search.jsp">
        <input type="text" name="projectName" placeholder="Project Name"><br>
        <input type="text" name="description" placeholder="Description"><br>
        <input type="text" name="type" placeholder="Project Type" value="A Type"><br>
        <input type="text" name="userName" placeholder="Username" value="yourUsername"><br>
        <input type="text" name="collaborator" placeholder="Collaborator User" value="anotherUsername"><br>
        <input type="text" name="tag" placeholder="Tag" value="#Tag"><br>
        <input type="submit">
    </form>
</body>
</html>
