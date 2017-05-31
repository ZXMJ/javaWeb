<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/scripts/jquery-1.7.2.js"></script>
	<script type="text/javascript">
	$(function(){
		$(":input[name='username']").change(function(){
			var url="${pageContext.request.contextPath }/servlet/LoginServlet";
			var val=$(this).val();
			val=$.trim(val);
			var args={"username":val,"time":new Date()};
			if(val!=""){
				$.post(url,args,function(data){
					$("#message").html(data);
				});
			}
		})
	})
	</script>
  </head>
  <body>
  <form action="" method="post">
	    用户名： <input type="text" name="username"><br>
	       <div id="message"></div><br>
	   	   <input type="submit" value="submit">
  </form>
  </body>
</html>
