<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--define tag library for imports-->
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports"%>
<!--define tag library for navigation-->
<%@ taglib prefix="navigation" tagdir="/WEB-INF/tags/navigation" %>

<html>
<head>
    <meta charset="utf-8" />
    <title><%=request.getUserPrincipal().getName()%>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <!--import css files-->
    <import:css_files/>
    <title>Aquarius</title>
</head>
<body>

<navigation:main_nav title="Home" active="home">


</navigation:main_nav>

</body>
</html>
