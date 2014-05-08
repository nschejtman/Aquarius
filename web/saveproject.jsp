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
    <form id="projectForm" method="post" action="saveproject">
            <input type="text" id="userName" name="userName" placeholder="User Name" value="ccc"><br>
            <input type="text" id="projectName" name="projectName" placeholder="Project Name" value="aaa"><br>
            <input type="text" id="description" name="description" placeholder="Description" value="bbb"><br>
            <input type="date" id="startDate" name="startDate" placeholder="Start" value="19/11/1993"><br>
            <input type="date" id="endDate" name="endDate" placeholder="End" value="19/11/1993"><br>
            <input type="text" id="type" name="type" placeholder="Project Type" value="A Type"><br>
            <input type="submit">
     </form>
</body>
</html>
