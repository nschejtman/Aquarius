<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 23/05/2014
  Time: 04:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="servlets.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form id="<%=Constants.REGISTER_FORM_ID%>" method="post" action="register">
    <input type="text" name="reg_first_name" placeholder="First Name" value="Nicolas"><br>
    <input type="text" name="reg_last_name" placeholder="Last Name" value="Schejtman"><br>
    <input type="date" name="birthday" placeholder="Birth Date"><br>
    <input type="text" name="<%=Constants.REGISTER_USERNAME_FIELD%>" placeholder="Username" value="nschejtman"><br>
    <input type="email" name="reg_email" placeholder="Email" value="nschejtman@hotmail.com"><br>
    <input type="password" name="<%=Constants.REGISTER_PASSWORD_FIELD%>" placeholder="Password" value="1234"><br>
    <input type="submit">
</form>


</body>
</html>

