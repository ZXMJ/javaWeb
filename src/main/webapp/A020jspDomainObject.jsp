<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>域对象 超链接  转发重定向</title>
</head>
<body>
	<%
		pageContext.setAttribute("pageContext","pageContextValue");
		request.setAttribute("request","requestValue");
		session.setAttribute("session","sessionValue");
		application.setAttribute("application","applicationValue");
	%>
	
	<br><br>
	<!-- 当前页面有效 -->
	pageContext:<%= pageContext.getAttribute("pageContext") %>
	<br><br>
	pageContext:<% out.print(pageContext.getAttribute("pageContext")); %>
	<!-- 以上两种方式本质是一样的 -->
	
	<br><br>
	<!-- 一次请求有效 -->
	request:<%= request.getAttribute("request") %>
	<br><br>
	<!-- 一次回话有效 -->
	session:<%= session.getAttribute("session") %>
	<br><br>
	<!-- 一次服务启动有效 -->
	application:<%= application.getAttribute("application") %>
	
	<br><br>
	<!-- 超链接是get请求 -->
	<!-- 超链接到jsp -->
	<a href="A025.jsp">TO Jsp</a>
	
	<br><br>
	<!-- 超链接到servlet -->
	<a href="domainObject">TO Servlet</a>
	
	<%
		//request.getRequestDispatcher("A25.jsp").forward(request,response);
	%>
</body>
</html>