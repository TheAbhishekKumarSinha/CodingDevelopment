<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

<div align="center">
        <h2>Welcome ${user1.username}! You have logged in successfully.</h2>
    </div>


<form:form method="post" commandName="customers" action="SpringHibernateSelectTeam" >
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Subscribe to newsletter? :</td>
				<td><form:checkbox path="receiveNewsletter" /></td>
				<td><form:errors path="receiveNewsletter" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Favourite Languages :</td>
				<td><form:checkbox path="favLanguages" value="Java" />Java <form:checkbox
						path="favLanguages" value="C++" />C++ <form:checkbox
						path="favLanguages" value=".Net" />.Net</td>
				<td><form:errors path="favLanguages" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Favourite Web Frameworks :</td>
				<td><form:checkboxes items="${webFrameworkList}"
						path="favFramework" /></td>
				<td><form:errors path="favFramework" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form> 
	
=======
    
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
</body>
</html>