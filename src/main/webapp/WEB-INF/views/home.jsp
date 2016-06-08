<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Store</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%--<link rel="stylesheet" type="text/css" href="<c:url value="/css/lib/jquery-ui/jquery-ui.css"/>"/>--%>
        <%--<link rel="stylesheet" type="text/css" href="<c:url value="/css/lib/jquery-ui/jquery-ui.structure.css"/>"/>--%>
        <%--<link rel="stylesheet" type="text/css" href="<c:url value="/css/lib/jquery-ui/jquery-ui.theme.css"/>"/>--%>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/lib/bootstrap/bootstrap.css"/>" >
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/lib/font-awesome/css/font-awesome.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
        <script src="<c:url value="/js/lib/jquery.js"/>" type="text/javascript"></script>
        <%--<script src="<c:url value="/js/lib/jquery-ui.js"/>" type="text/javascript"></script>--%>
        <script src="<c:url value="/js/lib/bootstrap.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/lib/underscore.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/lib/backbone.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/lib/backbone.marionette.js"/>" type="text/javascript"></script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <ul class="nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">User Mananagement <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#users">Users</a></li>
                        <li><a href="#userGroups">User Groups</a></li>
                    </ul>

                </li>
            </ul>
        </nav>
        <div id="main-content" class="container">
            <h1>Welcome to Store</h1>
        </div>

        <c:import url="userGroups.jsp"/>
        <c:import url="users.jsp"/>

        <script src="<c:url value="/js/app.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/users.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/userGroups.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/global.js"/>" type="text/javascript"></script>
    </body>
</html>
