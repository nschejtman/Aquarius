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

       <form id="<%=Constants.LOGIN_FORM_ID%>" action="<%=response.encodeURL(Constants.LOGIN_FORM_ACTION)%>" method="POST">
           <table>
               <tr>
                   <td>User</td>
                   <td><input type="text"
                              name="<%=Constants.LOGIN_USERNAME_FIELD%>"
                              value="<%=Constants.VALID_USERNAME%>"
                           ></td>
               </tr>
               <tr>
                   <td>Password</td>
                   <td><input type="password"
                              name="<%=Constants.LOGIN_PASSWORD_FIELD%>"
                              value="<%=Constants.VALID_PASSWORD%>"
                           ></td>
               </tr>
           </table>
           <input type="Submit" value="<%=Constants.LOG_IN%>"/>
       </form>
</body>
</html>
