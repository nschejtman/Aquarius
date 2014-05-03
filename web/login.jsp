<%@ page import="servlets.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 19/03/14
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form id="<%=Constants.LOGIN_FORM_ID%>" method="post" action="<%=Constants.LOGIN_FORM_ACTION%>">


    <h3>User</h3>
    <input type="text" name="<%=Constants.LOGIN_USERNAME_FIELD%>" formmethod="post">

    <h3>Password</h3>
    <input type="password" id="password" name="<%=Constants.LOGIN_PASSWORD_FIELD%>" formmethod="post">
    <br>

    <input type="submit">
    </form>
</body>
</html>
