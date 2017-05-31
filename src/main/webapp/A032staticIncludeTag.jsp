<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>静态包含</title>
</head>
<body>
	<h3>first Page</h3>
	<%
		String str = "first para";
	%>
	<!-- 静态包含:两个jsp被编译成一个servlet，所以两个jsp的变量可以相互被调用(按照先定义后使用的顺序) -->
	<%@include file="A033staticIncludeTag.jsp" %>
</body>
</html>