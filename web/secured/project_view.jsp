<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/imports" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/navigation" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>

    <script src="../assets/plugins/jquery-1.8.3.min.js"></script>
    <script src="../assets/plugins/jquery-superbox/js/superbox.js" type="text/javascript"></script>
    <script src="../assets/js/tabs_accordian.js" type="text/javascript" rel="script"></script>

    <import:css_files/>
    <link rel="stylesheet" type="text/css" href="../assets/plugins/jquery-superbox/css/style.css">
</head>
<body style="background-color: white">
<style type="text/css">
    h1.project-title {
        font-weight: bold;
        font-size: 90px;
        text-align: center;
    }
</style>
<nav:main_nav title="Projects - ${requestScope.project.getName()}" active="projects">
<jsp:attribute name="body">
<div class="row">
    <!--TAB SELECTOR-->
    <ul class="nav nav-tabs" id="tab-01">
        <li class="active"><a href="#info">INFO</a></li>
        <li class=""><a href="#faq">FAQ</a></li>
        <li class=""><a href="#updates">Updates</a></li>
        <li class=""><a href="#comments-tab">Comments</a></li>
    </ul>
    <!--TAB UTILS-->
    <div class="tools">
        <a href="javascript:;" class="collapse"></a>
        <a href="#grid-config" data-toggle="modal" class="config"></a>
        <a href="javascript:;" class="reload"></a>
        <a href="javascript:;" class="remove"></a>
    </div>
    <!--TAB CONTENTS-->
    <div class="tab-content">
        <!--INFO-->
        <div class="tab-pane active" id="info">
            <div class="row">
                <div class="col-md-8">
                    <h2 class="project-title">${requestScope.project.name}</h2>

                    <p style="text-align: justify">${requestScope.project.description}</p>
                </div>
                <div class="col-md-4" style="border-radius: 5px; background-color: lightgray; text-align: right">
                    <h3><span style="color:#0aa699" id="fundsraised">${requestScope.project.getFundsRaised()}</span>
                        FUNDS</h3>

                    <h3><span style="color:#0aa699">${requestScope.project.objective}</span> OBJECTIVE</h3>

                    <h3><span style="color:#0aa699">${requestScope.project.getFollowersQty()}</span> FOLLOWERS</h3>

                    <h3><span style="color:#0aa699">${requestScope.project.getDaysRemaining()}</span> DAYS REMAINING
                    </h3>
                </div>
            </div>

            <hr>
                ${requestScope.project.getHtml()}
        </div>
        <!--FAQ-->
        <div class="tab-pane" id="faq">
            <br>
            <br>
        </div>
        <!--UPDATES-->
        <div class="tab-pane" id="updates">
            <br>
            <br>
        </div>
        <!--COMMENTS-->
        <div class="tab-pane" id="comments-tab">
            <div id="comment-wrapper">
                <c:forEach var="comm" items="${requestScope.project.comments}">
                    <div class="row" style="padding-left: 20px">
                        <h6>${comm.user.userName}</h6>

                        <p>${comm.comment}</p>
                    </div>
                </c:forEach>
            </div>
            <form name="comment-form">
                <div class="col-md-12 no-padding">
                    <div class="tiles white">
                        <textarea rows="3" id="comment" class="form-control user-status-box post-input"
                                  placeholder="Comment"
                                  style="margin: 0px -10.5px 0px 0px; height: 84px; width: 648px; width: 100%; background-color: #eaeaea"></textarea>
                    </div>
                    <div class="tiles grey padding-10">
                        <div class="pull-right">
                            <button onclick="submitComment();" class="btn btn-primary btn-sm btn-small"
                                    type="button">
                                POST
                            </button>

                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-6">
        <button type="button" class="btn btn-warning btn-cons" style="width: 100%; height: 80px" data-toggle="modal"
                data-target="#donateModal">DONATE
        </button>
    </div>
    <div class="col-md-6">
        <button type="button" class="btn btn-success btn-cons" style="width: 100%; height: 80px">FOLLOW</button>
    </div>
</div>
<div class="modal fade" id="donateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     style="display: none; margin-top: 80px; border: none">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                DONATE
            </div>
            <div class="modal-body">
                <div class="row form-row">
                    AMOUNT<input type="number" class="form-control" id="pledge">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitPledge();">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
                    <!--Images start-->
    <%--<div class="superbox">--%>
    <%--<c:forEach var="image" items="${requestScope.project.images}">--%>
    <%--<div class="superbox-list">--%>
    <%--<img src="${image.path}" class="superbox-img">--%>
    <%--</div>--%>
    <%--</c:forEach>--%>
    <%--<div class="superbox-float"></div>--%>
    <%--</div>--%>
    <!--Images end-->

    </jsp:attribute>
</nav:main_nav>
<!--TEMPLATE COMMENT ROW-->
<div class="row" id="template-comment-row" style="display: none; padding-left: 20px">
    <h6 class="comment-user"></h6>

    <p class="comment-message"></p>
</div>
<script>
    function submitComment() {
        jQuery.ajax({
            url: '/secured/comment_ajax',
            type: 'post',
            data: {
                projectId: ${requestScope.project.id},
                comment: $("#comment").val()
            }
        }).done(
                function (resp) {

                    $("#template-comment-row > h6").html("${requestScope.aquser.userName}");
                    $("#template-comment-row > p").html($("#comment").val());
                    var newRow = $("#template-comment-row").clone();
                    $("#comment-wrapper").append(newRow);
                    newRow.toggle(true);
                    $("#comment").val("");
                });
    }

    function submitPledge() {
        jQuery.ajax({
            url: '/secured/pledge',
            type: 'post',
            data: {
                projectId: ${requestScope.project.id},
                pledge: $("#pledge").val()
            }
        }).done(function (resp) {
            var old = $("#fundsraised").val();
            var pledge = $("#pledge").val();
            $("#fundsraised").val(old + pledge);
        })
    }


</script>

</body>
</html>
