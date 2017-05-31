<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookie</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				out.print(cookie.getName() + ":" + cookie.getValue());
			}
		} else {
			out.print("没有Cookie，正在创建...");
			Cookie cookie = new Cookie("name", "hello");
			//负数表示不存储cookie
			//cookie.setMaxAge(-1);
			//out.print("<br>");
			//out.print(cookie.getName() + ":" + cookie.getValue());
			//0表示删除cookie
			//cookie.setMaxAge(0);
			//out.print("<br>");
			//out.print(cookie.getName() + ":" + cookie.getValue());
			//正数表示cookie存活的时间(单位S)
			cookie.setMaxAge(30);
			response.addCookie(cookie);
		}
	%>
</body>
</html>