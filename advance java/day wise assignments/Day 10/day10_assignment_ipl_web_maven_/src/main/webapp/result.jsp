<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%--transfer clnt's conversation state to JB --%>
<jsp:setProperty property="*" name="player" />

<body>

<%-- invoke B.L of JB from here --%>
<h1>${sessionScope.player.addPlayer()}</h1>
</body>
</html>