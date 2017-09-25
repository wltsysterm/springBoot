<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hello.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
    <div id="name"></div>
    <button onclick="test();">获取用户信息==autowire自动注入属性方式</button>
    <button onclick="test1();">插入用户信息==</button>
  </body>
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.0.min.js"></script>
  <script type="text/javascript">
  	var path = '<%=path%>';
  	function test(){
  		$.ajax({
		   type: "POST",
	       url:  "getUser",
	       error: function(){alert('error');},
	       success: function(msg){
	    	 	$("#name").html(JSON.stringify(msg));
	       }
		});
		}
	function test1(){
 		$.ajax({
	   type: "POST",
	   contentType: "application/json",
	   data:JSON.stringify([{username:'name1',password:'pass1'},{username:'name2',password:'pass2'}]),
       url:  "addUser",
       error: function(){alert('error');},
       success: function(msg){
    	 	$("#name").html(JSON.stringify(msg));
       }
	});
	}
  </script>
</html>
