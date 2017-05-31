<%@page import="com.pojo.Person"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="A095ELJavaBean.jsp" method="post">
		
		username: <input type="text" name="username" 
			value="<%= request.getParameter("username") == null ? "" : request.getParameter("username")%>"/>
		<!--  
			EL 表达式的有点: 简洁!
		-->	
		username: <input type="text" name="username" value="${param.username }"/>
		<input type="submit" value="Submit"/>
	</form>
	username: <%= request.getParameter("username") %>
	<br><br>
	<jsp:useBean id="person" class="com.pojo.Person" scope="session"></jsp:useBean>
	<jsp:setProperty property="score" value="12" name="person"/>
	score: 
	<% 
		Person person2 = (Person)session.getAttribute("person");
		out.print(person2.getScore());
	%>
	<br>
	score: <jsp:getProperty property="score" name="person"/>
	<br><br>
	<% 
		application.setAttribute("time", new Date());
	%>
	<a href="A090EL.jsp?score=89&name=A&name=B&name=C">To A090EL.jsp Page</a>
</body>
</html>