<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>持久化session Cookie</title>
</head>
<body>
	<%=session.getId()%>
	<%
		//session="false" 禁用该jsp的默认session引用(但是可以再手动创建session引用)，并非禁用该jsp的session功能
		//session的标识JSESSIONID存放在Cookie中，为了区别于其它的Cookie，把这个Cookie取名为session Cookie
		//所以持久化session的方法就是持久化session Cookie
		//持久化session Cookie
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(20);
		response.addCookie(cookie);
	%>
</body>
</html>