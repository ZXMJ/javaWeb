<%@page import="java.util.Date"%>
<%@page import="com.pojo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp隐含对象</title>
</head>
<body>
	<%
		Person person = new Person();
		System.out.println(person.getString());
	%>
	
	<% 
		Date date = new Date();
		System.out.print("-->" + date); 
	%>
	
	<% 
		String str = date.toString();
	
		/* jsp隐含内置对象 */
		String name = request.getParameter("name");
		System.out.println(name);
		
		//
		System.out.println(response instanceof HttpServletResponse);
		
		ServletRequest req = pageContext.getRequest();
		System.out.println(req == request); 
		
		System.out.println(session.getId());
		
		System.out.println(application.getInitParameter("driver"));
		
		System.out.println(config.getInitParameter("test")); 
		
		out.println(request.getParameter("name")); 
		out.println("<br><br>");
		out.println(application.getInitParameter("driver"));
		out.println("<br><br>");
		out.println(this);
		out.println("<br><br>");
		out.println(page);
		
	%>
</body>
</html>
