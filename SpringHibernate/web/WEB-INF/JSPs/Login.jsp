<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%!int day = 3;%>
	<%
		if (day == 1 | day == 7) {
	%>
	<p>Today is weekend</p>
	<%
		} else {
	%>
	<p>Today is not weekend</p>
	<%
		}
	%>
	<%
		switch (day) {
		case 0:
			out.println("It\'s Sunday.");
			break;
		case 1:
			out.println("It\'s Monday.");
			break;
		case 2:
			out.println("It\'s Tuesday.");
			break;
		case 3:
			out.println("It\'s Wednesday.");
			break;
		case 4:
			out.println("It\'s Thursday.");
			break;
		case 5:
			out.println("It\'s Friday.");
			break;
		default:
			out.println("It's Saturday.");
		}
	%>
	
	<%for ( int fontSize = 1; fontSize <= 3; fontSize++){ %>
   <font color="green" size="<%= fontSize %>"><br/>
    JSP Tutorial
   </font><br />
<%}%>
	<form:form method="post" commandName="user1"
		action="http://localhost:8999/SpringHibernate/login">
		<table>
			<tr>
				<td><form:label path="username">User Name</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" /></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>