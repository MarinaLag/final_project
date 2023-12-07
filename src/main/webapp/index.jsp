<%@ page import="by.itclass.constans.ApplicationConstants" %>
<%@ page import="by.itclass.constans.JspConstants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Pizza 2211</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <jsp:include page="<%= JspConstants.MENU_JSP%>"/>
        <img class="default-image" src="<%= JspConstants.BACKGROUND_IMAGE%>" alt="pizza">
        <h1 style="position: absolute; top:50%; width: 100%; text-align: center;">
            The best and tasty pizza!!!
        </h1>
    </body>
</html>
