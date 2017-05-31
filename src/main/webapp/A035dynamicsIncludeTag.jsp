<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动态包含 和 转发包含测试页面</title>
</head>
<body>
	<h3>second Page</h3>
	<%
		out.print(request.getParameter("testInclude"));
	%>
	<%
		//out.print(request.getParameter("testForward"));
	%>
</body>
</html>