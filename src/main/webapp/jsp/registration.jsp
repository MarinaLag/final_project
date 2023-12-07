<%@ page import="by.itclass.constans.ApplicationConstants" %>
<%@ page import="by.itclass.constans.JspConstants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%= JspConstants.MENU_JSP %>"/>
    <img class="default-image" src="<%= JspConstants.BACKGROUND_IMAGE %>" alt="pizza">
    <div class="form-box">
        <h2>Registration</h2>
        <form method="post" action="<c:url value="<%= ApplicationConstants. REGISTRATION_CONTROLLER %>"/>">
            <input name="<%= JspConstants.LOGIN_PARAM %>" placeholder="Login">
            <input name="<%= JspConstants.NAME_PARAM %>" placeholder="Name">
            <input type="password" name="<%= JspConstants.PASS_PARAM %>" placeholder="Password">
            <input name="<%= JspConstants.EMAIL_PARAM %>" placeholder="Email">
            <input type="submit" value="Register">
        </form>
        <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
        </c:if>
    </div>
</body>
</html>
