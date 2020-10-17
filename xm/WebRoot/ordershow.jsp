<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.Order,dao.UserDao" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单展示页面</title>
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
  	<h2 align="center">订单信息</h2>
    <table class="table table-striped table-hover table-bordered">
    	<tr><td>订单号</td><td>车次</td><td>起始站</td><td>目的站</td><td>发出时间</td><td>到达时间</td><td>票价</td><td>操作</td></tr>
    	<%
    		String username=(String)session.getAttribute("success");
    		UserDao orderdao=new UserDao();
  			ArrayList<Order> orderlist=new ArrayList<Order>();
  			int id=orderdao.findId(username);
  			orderlist=orderdao.orderShow(id);
  			if(orderlist!=null&&orderlist.size()>0){
  				for(int i=0;i<orderlist.size();i++){
  					Order order=(Order)orderlist.get(i);
  					int x=order.getArgeid();
    	 %>
    	 <tr>
    	 	<td><%=order.getArgeid()%></td>
    	 	<td><%=order.getCartimes()%></td>
    	 	<td><%=order.getSource()%></td>
    	 	<td><%=order.getDestination()%></td>
    	 	<td><%=order.getBegindate()%>&nbsp;<%=order.getBegintime()%></td>
    	 	<td><%=order.getEnddate()%>&nbsp;<%=order.getEndtime()%></td>
    	 	<td><%=order.getPrice()%></td>
    	 	<td><form action="servlets/Returntk" method="post"><input type="hidden" name="argeid" value="<%=x%>"/><input type="submit" value="退票" class="btn btn-primary"/></form></td>
    	 </tr>
    	 <%
    	 		}
    	 	}
    	  %>
    </table>
  </body>
</html>
