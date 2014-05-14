<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 30/04/2014
  Time: 02:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
</head>
<body>
    <form id="projectForm" method="post" action="addproject">
            <input type="text" id="projectName" name="projectName" placeholder="Project Name"><br>
            <input type="text" id="description" name="description" placeholder="Description"><br>
            <input type="date" id="startDate" name="startDate" placeholder="Start"><br>
            <input type="date" id="endDate" name="endDate" placeholder="End"><br>
            <input type="text" id="type" name="type" placeholder="Project Type" ><br>
            <input type="text" id="tags" name="tags" placeholder="tag" ><br>
            <input type="submit">
     </form>
</body>
</html>
