<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>
		page :
		<%=page%></h4>
	<h4>
		pageContext
		<%=pageContext%></h4>
		<h4> Value of JSESSIONID : <%= session.getId() %></h4>
		<%-- WC cookie.get("JSESSIONID").getVAlue() sent to clnt --%>
		<h4> Value of JSESSIONID : ${cookie.JSESSIONID.value}</h4>
		<h4>JSESSION ID using El with session : ${pageContext.session.id} </h4>
</body>
</html>