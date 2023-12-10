<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- display an list of departments here using form  -->


	<form action="employees">
		
			<c:forEach var="dept" items="${requestScope.dept_list}">


				<label for="${dept}">${dept}</label> <input type="radio"
					name="deptName" id="${dept}" value="${dept}">


			</c:forEach>

			<input type="submit">
		


	</form>

</body>
</html>