<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports"%>
<%@taglib prefix="navigation" tagdir="/WEB-INF/tags/navigation" %>

<html>
<head>
    <import:css_files/>
    <import:css_projectlist/>
</head>
<body>
    <navigation:main_nav title="Project List" active="projects">
        <jsp:attribute name="body">
            <div class="row-fluid">
                <div class="span12">
                    <div class="grid simple ">
                        <div class="grid-title">
                            <h4><span class="semi-bold">Projects</span></h4>
                            <div class="tools"> <a href="javascript:;" class="collapse"></a>  <a href="javascript:;" class="reload"></a> </div>
                        </div>
                        <div class="grid-body ">
                            <table class="table table-hover table-condensed" id="example">
                                <thead>
                                <tr>
                                    <th style="width:1%"><div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                        <input type="checkbox" value="1" id="checkbox1">
                                        <label for="checkbox1"></label>
                                    </div></th>
                                    <th style="width:10%">Project Name</th>
                                    <th style="width:22%" data-hide="phone,tablet">Description</th>
                                    <th style="width:6%">Objective</th>
                                    <th style="width:10%" data-hide="phone,tablet">Progress</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach var="project" items="${requestScope.projects}" >
                                    <tr >
                                        <td class="v-align-middle"><div class="checkbox check-default">
                                            <input type="checkbox" value="3" onload="name(this)">
                                        </div></td>
                                        <td class="v-align-middle"><c:out value="${project.name}"/></td>
                                        <td class="v-align-middle"><span class="muted"><c:out value="${project.description}" escapeXml="false"/></span></td>
                                        <td><span class="muted"><c:out value="${project.objective}"/></span></td>
                                        <td class="v-align-middle">
                                            <div class="progress ">
                                                <div data-percentage="<c:out value="${project.getProgress()}"/>"  class="progress-bar progress-bar-primary animate-progress-bar"></div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </jsp:attribute>
    </navigation:main_nav>
    <import:js_files/>
    <import:js_projectlist/>
    <script>
        var i = 2;
        function name(element){
            $("element").attr("id","checkbox" + i);
            i++;
        }
    </script>
</body>
</html>
