<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中文乱码测试</title>
</head>
<body>
	<%
		/* post请求只需在调用参数之前设置编码即可 */
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		out.print(username);
		/* get请求还需要对获取参数进行转码或者在service.xml <Connector/>节点中设置useBodyEncodingForURI="true" */
		//String name = new String(username.getBytes("iso-8859-1"),"utf-8");
		//out.print(name);
	%>
</body>
</html>