<%@page import="java.util.Date"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IPL Team Auction</title>
</head>

<jsp:useBean id="team" class="beans.TeamBean" scope="session" />
<jsp:useBean id="player" class="beans.PlayerBean" scope="session" />
<body>
	

	<!-- display teams abbreviation in select input type-->

	<form action="result.jsp">

		<h5>

			Select Team <select name="teamAbr">

				<!-- incomplete display list dynamically -->
				<%-- invoke B.L of JB from here --%>




				<c:forEach var="abr" items="${sessionScope.team.teamsAbr()}">

					<option value="${abr}">${abr}</option>


				</c:forEach>


			</select>


		</h5>

		<h5>
			player first name <input type='text' name='firstName' />
		</h5>
		<h5>
			player last name <input type='text' name='lastName' />
		</h5>
		<h5>
			DoB <input type='date' name='dob' />
		</h5>
		<h5>
			Batting Avg <input type='number' name='battingAverage' />
		</h5>
		<h5>
			Wickets Taken <input type='text' name='wicketsTaken' />
		</h5>
		<h5>
			<input type='submit' value='Add New Player' />
		</h5>


	</form>


	<h1>${sessionScope.team.teamsAbr()}</h1>



</body>
</html>