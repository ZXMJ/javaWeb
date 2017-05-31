<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<form action="login" method="get">
		user:	<input type="text" name="user"></br>
		pasd:	<input type="password" name="pswd"></br>
		hobby:	<input type="checkbox" name="hobby" value="sport">sport
		<input type="checkbox" name="hobby" value="read">read
		<input type="checkbox" name="hobby" value="sleep">sleep</br>
		<input type="submit" value="submit">
	</form>
</body>
</html>