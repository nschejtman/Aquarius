<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/navigation" %>
<html>
<head>
    <title></title>
    <import:css_files/>
</head>
<body>
<nav:main_nav title="Project" active="projects">
    <jsp:attribute name="body">
        <div class="row">
            <div class="grid simple">
                <div class="grid-body no-border invoice-body"><br>

                    <h1>${requestScope.project}</h1>

                    <div class="clearfix"></div>
                <br>
                <br>
                <br>


            </div>
        </div>
    </div>


    <div class="col-md-12">
        <ul class="nav nav-tabs" id="tab-01">
            <li class="active"><a href="#tab1hellowWorld">FAQ</a></li>
            <li class=""><a href="#tab1FollowUs">Updates</a></li>
            <li class=""><a href="#tab1Inspire">Comments</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Dropdown <b
                    class="caret"></b> </a>
                <ul class="dropdown-menu">
                    <li><a href="#">New Project</a></li>
                    <li><a href="#">Edit Details</a></li>
                    <li><a href="#">View More</a></li>
                    <li class="divider"></li>
                    <li><a href="#" class="text-error">Delete Project</a></li>
                </ul>
            </li>
        </ul>
        <div class="tools"><a href="javascript:;" class="collapse"></a> <a href="#grid-config" data-toggle="modal"
                                                                           class="config"></a> <a href="javascript:;"
                                                                                                  class="reload"></a> <a
                href="javascript:;" class="remove"></a></div>
        <div class="tab-content">
            <div class="tab-pane active" id="tab1hellowWorld">
                <div class="row column-seperation">
                    <div class="col-md-6">
                        <h3><span class="semi-bold">Sometimes</span> Small
                            things in life means
                            the most</h3>
                    </div>
                    <div class="col-md-6">
                        <h3 class="semi-bold">great tabs</h3>

                        <p class="light">default, the textarea element comes with a vertical scrollbar (and maybe even a
                            horizontal scrollbar). This vertical scrollbar enables the user to continue entering and
                            reviewing their text (by scrolling up and down).</p>
                    </div>
                </div>
            </div>
            <div class="tab-pane" id="tab1FollowUs">
                <div class="row">
                    <div class="col-md-12">
                        <h3>“ Nothing is<span class="semi-bold"> impossible</span>, the word itself says 'I'm <span
                                class="semi-bold">possible</span>'! ”</h3>

                        <p>A style represents visual customizations on top of a layout. By editing a style, you can use
                            Squarespace's visual interface to customize your...</p>
                        <br>

                        <p class="pull-right">
                            <button type="button" class="btn btn-white btn-cons">White</button>
                            <button type="button" class="btn btn-success btn-cons">Success</button>
                        </p>
                    </div>
                </div>
            </div>
            <div class="tab-pane" id="tab1Inspire">
                <div class="row">
                    <div class="col-md-12">
                        <h3>Follow us &amp; get updated!</h3>

                        <p>Instantly connect to what's most important to you. Follow your friends, experts, favorite
                            celebrities, and breaking news.</p>
                        <br>

                        <p><a href="#" class="btn-social"><i class="icon-facebook"></i></a> <a href="#"
                                                                                               class="btn-social"><i
                                class="icon-twitter"></i> </a> <a href="#" class="btn-social"><i
                                class="icon-dribbble"></i></a> <a href="#" class="btn-social"><i
                                class="icon-pinterest-sign"></i></a> <a href="#" class="btn-social"><i
                                class="icon-tumblr"></i> </a> <a href="#" class="btn-social"><i
                                class="icon-linkedin-sign"></i> </a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </jsp:attribute>


</nav:main_nav>

<script src="../assets/js/tabs_accordian.js" type="text/javascript" rel="script"></script>
</body>
</html>
