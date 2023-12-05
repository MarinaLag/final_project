<%@ page import="by.itclass.constans.ApplicationConstants" %>
<%@ page import="by.itclass.constans.JspConstants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <p>
        <a href="<%= ApplicationConstants.LOGOUT_CONTROLLER%>">Logout</a>
    </p>
    <h2> User Info:</h2>
    <p> Login: ${user.login}</p>
    <p> Login: ${user.name}</p>
    <p> Login: ${user.email}</p>
</body>
</html>
