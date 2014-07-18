<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports"%>
<%@taglib prefix="navigation" tagdir="/WEB-INF/tags/navigation" %>

<html>
<head>
    <import:css_files/>
    <import:css_addproject/>
</head>
<body>
<navigation:main_nav title="Add Project" active="projects">
    <jsp:attribute name="body">

                <form id = "projectForm" method = "post" action ="secured/addproject">
                    <!-- BEGIN BASIC FORM ELEMENTS-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="grid simple">
                                <div class="grid-title no-border">
                                    <h4>Project <span class="semi-bold">Data</span></h4>
                                </div>
                                <div class="grid-body no-border"> <br>
                                    <div class="row">
                                        <div class="col-md-8 col-sm-8 col-xs-8">
                                            <div class="form-group">
                                                <label class="form-label">Project Name</label>
                                                <div class="controls">
                                                    <input name="projectName" type="text" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="form-label">Description Name</label>
                                                <div class="controls">
                                                    <input name="description" type="text" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="form-label">Objective</label>
                                                <span class="help">e.g. "$45.50"</span>
                                                <div class="controls">
                                                    <input name="objective" type="text" class="form-control" data-a-sign="$ ">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END BASIC FORM ELEMENTS-->

                    <!-- BEGIN DROPDOWN CONTROLS-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="grid simple">
                                <div class="grid-title no-border">
                                    <h4>Select <span class="semi-bold">Type</span></h4>
                                </div>
                                <div class="grid-body no-border">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <br>
                                            <select id="source" name = "type" style="width:100%">
                                                <optgroup label="TYPES">
                                                    <c:forEach var="type" items="${requestScope.types}" >
                                                        <option> ${type.name} </option>
                                                    </c:forEach>
                                                </optgroup>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="grid simple">
                                <div class="grid-title no-border">
                                    <h4>Tags <span class="semi-bold">Input</span></h4>
                                </div>
                                <div class="grid-body no-border">
                                    <div class="row-fluid">
                                        <h3>Tag <span class="semi-bold">Input</span></h3>
                                        <br>
                                        <input class="span12 tagsinput" id="source-tags" type="text" name="source-tags"  />
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- END DROPDOWN CONTROLS-->

                    <!-- BEGIN DATEPICKER CONTROLS-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="grid simple">
                                <div class="grid-title no-border">
                                    <h4>Date <span class="semi-bold">Controls</span></h4>
                                </div>
                                <div class="grid-body no-border">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <h3>Start Date<span class="semi-bold"> Picker</span></h3>
                                            <br>
                                            <div class="input-append success date col-md-10 col-lg-6 no-padding">
                                                <input type="text" class="form-control" name="startDate">
                                                <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span> </div>
                                            <br>
                                            <br>
                                            <div class="clearfix"></div>
                                            </div>

                                            <div class="col-md-4">
                                            <h3>End Date<span class="semi-bold"> Picker</span></h3>
                                            <div class="input-append success date col-md-10 col-lg-6 no-padding">
                                                <input type="text" class="form-control" name="endDate">
                                                <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span> </div>
                                            <br>
                                            <br>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    <!-- END DATEPICKER CONTROLS-->

                    <!-- BEGIN HTML5 WYSIWG CONTROLS-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="grid simple">
                                <div class="grid-title no-border">
                                    <h4>Describe your <span class="semi-bold">Project</span></h4>
                                </div>
                                <div class="grid-body no-border">

                                    <h3>Write <span class="semi-bold">Description</span></h3>
                                    <code>textarea</code>
                                    <br>
                                    <textarea id="text-editor" name="html" placeholder="Enter text ..." class="form-control" rows="10"></textarea>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END HTML5 WYSIWG CONTROLS-->

                    <button type="submit" class="btn btn-primary btn-cons"><i class="fa fa-check"></i>&nbsp;Submit</button>
                </form>
    </jsp:attribute>
</navigation:main_nav>
<import:js_files/>
<import:js_addproject/>
</body>
</html>
