<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购买操作</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link href="style.css" rel="stylesheet">
	<script src="jquery/jquery-3.4.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
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
  	<form action="servlets/Buyservlet" method="post" class="form-group">
  		<input type="hidden" name="id" value="${param.Id}"/>
  		<h1>请填写要购买的车票数量：</h1>
  		<h2>您需要购买<input type="text" name="count" size="2"/>张车票</h2>
  		<input type="submit" value="购买" class="btn btn-primary"/>
  	</form>
  </body>
</html>
