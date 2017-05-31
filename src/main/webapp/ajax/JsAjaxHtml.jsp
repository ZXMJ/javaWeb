<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ajax</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		window.onload=function(){
			var aNodes=document.getElementsByTagName("a");
		 	for(var i=0;i<aNodes.length;i++){
		 		aNodes[i].onclick=function(){
		 			var request=new XMLHttpRequest();
		 			var url=this.href;
		 			var method="GET";
		 			request.open(method,url);
		 			request.send(null);
		 			request.onreadystatechange=function(){
	 					if(request.readyState==4)
		 					if(request.status==200||request.status==304){
		 						document.getElementById("details").innerHTML=request.responseText;
		 					}
		 				}
		 		return false;
		 		}
			}
		}
	</script>
  </head>

  <body>
    <h1>People</h1>
    <ul>
    	<li><a href="ajax/ajaxhtml/andx.html">Andx</a></li>
    	<li><a href="ajax/ajaxhtml/andy.html">Andy</a></li>
    	<li><a href="ajax/ajaxhtml/andz.html">Andz</a></li>
    </ul>
    <div id="details"></div>
  </body>
</html>
