<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function(){
			alert("  ");
			$("a").click(function(){
				alert("11");
				var url=this.href;
				var args={
					"time":new Date()	
				};
				$("#content").load(url,args);
				return false;
			})
		})
	</script>
</head>
<body>
	<a href="ajaxtxt/ajax.txt">hello Ajax</a>
	<div id="content"></div>
</body>
</html>