<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A025</title>
</head>
<body>

	<br><br>
	pageContext:<%= pageContext.getAttribute("pageContext") %>
	<br><br>
	request:<%= request.getAttribute("request") %>
	<br><br>
	session:<%= session.getAttribute("session") %>
	<br><br>
	application:<%= application.getAttribute("application") %>
	
</body>
</html>