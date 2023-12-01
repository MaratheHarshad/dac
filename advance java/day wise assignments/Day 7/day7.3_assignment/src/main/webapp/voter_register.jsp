<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%-- invoke all the matching  --%>
<jsp:setProperty property="*" name="user" />
	
<body>
	
	<%-- invoke B.L method for voter reg --%>
	<h1>status : ${sessionScope.user.registerNewVoter()}</h1>
	<h5><a href="login.jsp">login</a></h5>	

</body>
</html>