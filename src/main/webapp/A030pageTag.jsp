<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导包 -->
<%@ page import="java.util.*" %>
<!-- session是否可用 -->
<%@ page session="true" %>
<!-- 本页面出现错误时到指定错误页面 -->
<!-- 这是在页面配置本页面出错后转到指定错误页面，还可以在web.xml中配置指定的错误页面 -->
<%@ page errorPage="/WEB-INF/error.jsp" %>
<!-- 是否忽略EL表达式 -->
<%@ page isELIgnored="false" %>
<!-- 是否是错误页面true时可以使用exception隐藏对象 -->
<%@ page isErrorPage="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page tag</title>
</head>
<body>
	<% 
		Date date = new Date();
		out.print(date);
		session.getId();
	%>
	<br><br>
	<%
		int i =10/0;
	%>
</body>
</html>