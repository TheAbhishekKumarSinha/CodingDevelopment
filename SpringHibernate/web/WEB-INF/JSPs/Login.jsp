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
	
	<form:form method="post" commandName="user1"
		action="http://localhost:8181/SpringHibernate/">
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