<%@ page import="servlets.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 23/04/14
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form id="<%=Constants.REGISTER_FORM_ID%>" method="post" action="register">
    <input type="text" name="firstname" placeholder="First Name" value="Nicolas"><br>
    <input type="text" name="lastname" placeholder="Last Name" value="Schejtman"><br>
    <input type="date" name="birthday" placeholder="Birth Date" value="19/11/1993"><br>
    <input type="text" name="<%=Constants.REGISTER_USERNAME_FIELD%>" placeholder="Username" value="nschejtman"><br>
    <input type="email" name="email" placeholder="Email" value="nschejtman@hotmail.com"><br>
    <input type="password" name="<%=Constants.REGISTER_PASSWORD_FIELD%>" placeholder="Password" value="1234"><br>
    <input type="submit">
</form>


</body>
</html>
