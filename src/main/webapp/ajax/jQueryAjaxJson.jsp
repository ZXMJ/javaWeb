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
			$("a").click(function(){
				var url=this.href;
				var args={
					"time":new Date()	
				};
				$.getJSON(url,args,function(data){
					var name=data.person.name;
					var website=data.person.website;
					var email=data.person.email;
					$("#details").empty()
								 .append("<a>"+name +"</a><br>")
								 .append("<a>"+website +"</a><br>")
								 .append("<a>"+email +"</a><br>");
				});
				return false;
			})
		})
	</script>
  <body>
    <h1>People</h1>
    <ul>
    	<li><a href="ajaxJson/json.js">Andy</a></li>
    </ul>
    <div id="details"></div>
  </body>
</html>