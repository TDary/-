<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.Car,dao.UserDao" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link href="style.css" rel="stylesheet">
	<script src="jquery/jquery-3.4.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
    <title>车票显示</title>
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
  	<table class="table table-striped table-hover table-bordered">
  		<tr><td>汽车编号</td><td>车次</td><td>余票数</td><td>车牌号</td><td>座位数</td><td>软硬座</td><td>起始站</td><td>目的站</td><td>票价</td><td>出发日期</td><td>出发时间</td><td>到达日期</td><td>到达时间</td><td>操作</td></tr>
  		<%
  			UserDao cardao=new UserDao();
  			ArrayList<Car> carlist=new ArrayList<Car>();
  			carlist=cardao.carShow();
  			if(carlist!=null&&carlist.size()>0){
  				for(int i=0;i<carlist.size();i++){
  					Car car=(Car)carlist.get(i);
  					int x=car.getCarid();
  		 %>
  		 <tr>
  		 	<td><%=car.getCarid()%></td>
  		 	<td><%=car.getCartimes()%></td>
  		 	<td class="info"><%=car.getNumber()%></td>
  		 	<td><%=car.getCarnumber()%></td>
  		 	<td><%=car.getSitnumber() %></td>
  		 	<td><%=car.getSof() %></td>
  		 	<td><%=car.getSource() %></td>
  		 	<td><%=car.getDestination() %></td>
  		 	<td><%=car.getPrice() %></td>
  		 	<td><%=car.getBegin_date() %></td>
  		 	<td><%=car.getBegin_time() %></td>
  		 	<td><%=car.getEnd_date() %></td>
  		 	<td><%=car.getEnd_time() %></td>
  		 	<td><a href="buytk.jsp?Id=<%=x%>" class="btn btn-primary">订票</a></td>
  		 </tr>
  		 <%
  		 		}
  		 	}
  		  %>
  	</table>
  </body>
</html>
