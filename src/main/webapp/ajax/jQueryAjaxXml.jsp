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
				var url=this.href;
				var args={"time":new Date()};
				//$.post(url,args,function(data){
				$.get(url,args,function(data){
					var name = $(data).find("name").text();
					var website = $(data).find("website").text();
					var email = $(data).find("email").text();
					$("#details").empty()
								 .append("<a>"+name +"</a><br>")
								 .append("<a>"+website +"</a><br>")
								 .append("<a>"+email +"</a><br>");
				});
				return false;
			})
		})
	</script>
</head>
  <body>
    <h1>People</h1>
    <ul>
    	<li><a href="ajaxxml/andx.xml">Andx</a></li>
    	<li><a href="ajaxxml/andy.xml">Andy</a></li>
    	<li><a href="ajaxxml/andz.xml">Andz</a></li>
    </ul>
    <div id="details"></div>
  </body>
</html>
