<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports"%>
<%@taglib prefix="navigation" tagdir="/WEB-INF/tags/navigation" %>

<%--
  Created by IntelliJ IDEA.
  User: franco
  Date: 21/07/2014
  Time: 08:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <import:css_files/>
    <import:css_addproject/>
</head>
<body>
    <navigation:main_nav title= "User Profile" active="profile">
        <jsp:attribute name="body">
            <c:set var="user" value="${requestScope.user}"/>
            <form id="userForm" method="post" action="secured/edituser?id="${requestScope.user.id}>
                <input type="text" name="reg_first_name" placeholder="First Name" value="${user.firstName}"><br>
                <input type="text" name="reg_last_name" placeholder="Last Name" value="${user.lastName}"><br>
                <input type="text" name="" placeholder="Username" value="${user.userName}"><br>
                <input type="email" name="reg_email" placeholder="Email" value="${user.email}"><br>
                <input type="password" name="" placeholder="Password" ><br>
                <!-- BEGIN DATEPICKER CONTROLS-->
                <div class="row">
                    <div class="col-md-6">
                        <div class="grid simple">
                            <div class="grid-title no-border">
                                <h4>Date <span class="semi-bold">Controls</span></h4>
                            </div>
                            <div class="grid-body no-border">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h3>End <span class="semi-bold"> Date</span></h3>

                                        <div class="input-append success date col-md-10 col-lg-6 no-padding">
                                            <input type="text" class="form-control" name="birthday" value="${requestScope.birthday}">
                                                 <span class="add-on"><span class="arrow"></span><i
                                                         class="fa fa-th"></i></span></div>
                                        <br>
                                        <br>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-cons"><i class="fa fa-check"></i>&nbsp;Submit
                </button>
            </form>
            <%--<div class="col-md-6">--%>
                <%--<div class="grid simple">--%>
                    <%--<div class="grid-title no-border">--%>
                        <%--<h4>Icon <span class="semi-bold">Validation</span></h4>--%>
                        <%--<div class="tools"> <a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal" class="config"></a> <a href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a> </div>--%>
                    <%--</div>--%>
                    <%--<div class="grid-body no-border"> <br>--%>
                        <%--<form id="form_iconic_validation" action="#">--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="form-label">Your Name</label>--%>
                                <%--<span class="help">e.g. "Jonh Smith"</span>--%>
                                <%--<div class="input-with-icon  right">--%>
                                    <%--<i class=""></i>--%>
                                    <%--<input type="text" name="form1Name" id="form1Name" class="form-control">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="form-label">Your email</label>--%>
                                <%--<span class="help">e.g. "john@examp.com"</span>--%>
                                <%--<div class="input-with-icon  right">--%>
                                    <%--<i class=""></i>--%>
                                    <%--<input type="text" name="form1Email" id="form1Email" class="form-control">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="form-label">Website</label>--%>
                                <%--<span class="help">e.g. "http://www.webarc.com"</span>--%>
                                <%--<div class="input-with-icon  right">--%>
                                    <%--<i class=""></i>--%>
                                    <%--<input type="text" name="form1Url" id="form1Url" class="form-control">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-actions">--%>
                                <%--<div class="pull-right">--%>
                                    <%--<button type="submit" class="btn btn-danger btn-cons"><i class="icon-ok"></i> Save</button>--%>
                                    <%--<button type="button" class="btn btn-white btn-cons">Cancel</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </jsp:attribute>
    </navigation:main_nav>

<import:js_files/>
<import:js_addproject/>
<script src="../assets/js/form_validations.js" type="text/javascript"></script>

</body>
</html>
