<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动态包含 和 转发包含</title>
</head>
<body>
	<h3>first Page</h3>
	<!-- 动态包含:两个jsp被编译成两个servlet，所以两个jsp的变量不可以相互被调用，但是可以传递参数 -->
	<jsp:include page="A035dynamicsIncludeTag.jsp">
		<jsp:param value="testIncludeValue" name="testInclude"/>
	</jsp:include>
	

	<!-- 以下两种方式是等效的 -->
<%-- 	<jsp:forward page="A035dynamicsIncludeTag.jsp">
		<jsp:param value="testForwardValue" name="testForward" />
	</jsp:forward> --%>
<%-- 	<%
		request.getRequestDispatcher("A035dynamicsIncludeTag.jsp?testForward=testForwardValue").forward(request, response);
	%> --%>
</body>
</html>