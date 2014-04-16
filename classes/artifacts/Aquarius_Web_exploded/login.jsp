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
    <title></title>
    <style type="text/css">
        input {

            border-radius: 5px;
            border: 1 solid lightgray;

        }
        input::selection{
            box-shadow: 5px;
        }
    </style>
</head>
<body>
       <form name="myForm">

           <h3>User</h3>
           <input type="text" name="username" formmethod="post">

           <h3>Password</h3>
           <input type="password" id="password" name="password" formmethod="post">
           <br>

           <input type="submit">
       </form>
</body>
</html>
