<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取HttpSession的值</title>
</head>
<body>
	<%=session.getId()%>
	<br>
	<%=session.getAttribute("name")%>
	<%
		out.print("<br>");
		out.print("IsNew:" + session.isNew());
		out.print("<br>");
		out.print("CreationTime:" + session.getCreationTime());
		out.print("<br>");
		out.print("LastAccessedTime:" + session.getLastAccessedTime());
		out.print("<br>");
		out.print("MaxInactiveInterval:" + session.getMaxInactiveInterval());
		out.print("<br>");
	%>
</body>
</html>