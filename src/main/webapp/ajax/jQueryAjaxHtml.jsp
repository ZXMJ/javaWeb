<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$("a").click(function(){
				//load 的URL可以加选择器第一个空格是格式
				var url=this.href+" h2 a";
				var args={"time":new Date()};
				$("#details").load(url,args);
				return false;
			})
		})
	</script>
</head>
  <body>
    <h1>People</h1>
    <ul>
    	<li><a href="ajaxhtml/andx.html">Andx</a></li>
    	<li><a href="ajaxhtml/andy.html">Andy</a></li>
    	<li><a href="ajaxhtml/andz.html">Andz</a></li>
    </ul>
    <div id="details"></div>
  </body>
</html>
