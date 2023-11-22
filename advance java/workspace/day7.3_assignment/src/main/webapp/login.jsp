<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%-- IMPORTANT --%>
<%-- if user directly goes to register.jsp from another browser(incognito) exceptin would be throws --%>

<%--create JB instance n add it under session --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>

<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>

<body>

   <form action="validate.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Enter User Email</td>
          <td><input type="email" name="email" /></td>
        </tr>
        <tr>
          <td>Enter Password</td>
          <td><input type="password" name="pass" /></td>
        </tr>
        <tr>
          <td><input type="submit" value="Login" /></td>
          <td><button><a href="register.jsp">Register</a></button></td>
          
        </tr>
      </table>
    </form>
</body>
</html>