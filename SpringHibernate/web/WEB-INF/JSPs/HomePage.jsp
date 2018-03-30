<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
    <div align="center">
        <h2>Welcome ${user1.username}! You have logged in successfully.</h2>
    </div>
    
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