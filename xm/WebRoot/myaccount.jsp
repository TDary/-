<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.User,dao.UserDao" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>账户管理</title>
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
    <table class="table table-striped table-hover table-bordered">
    	<%
    		String username=(String)request.getSession().getAttribute("success");
    		UserDao cardao=new UserDao();
  			ArrayList<User> userlist=new ArrayList<User>();
  			userlist=cardao.usershow(username);
  			if(userlist!=null&&userlist.size()>0){
  				for(int i=0;i<userlist.size();i++){
  					User u=(User)userlist.get(i);
    	 %>
    	 <tr><td>账号：</td><td><%=u.getId() %></td></tr>
    	 <tr><td>姓名：</td><td><%=u.getUsername()%></td></tr>
    	 <tr><td>密码：</td><td><%=u.getPassword()%></td></tr>
    	 <tr><td>性别：</td><td><%=u.getSex()%></td></tr>
    	 <tr><td>生日：</td><td><%=u.getBirth()%></td></tr>
    	 <tr><td>电话：</td><td><%=u.getPhone()%></td></tr>
    	 <tr><td>身份证号码：</td><td><%=u.getIdnum()%></td></tr>
    	 <%
    	 		}
    	 	}
    	  %>
    </table>
    <script>
    	
    </script>
    <form action="servlets/Modifyuser" method="post" class="form-group">
    	请选择要修改的类型：<select name="sele">
    							<option value="namevalue" selected>姓名</option>
    							<option value="pwdvalue">密码</option>
    							<option value="sexvalue">性别</option>
    							<option value="birthvalue">生日</option>
    							<option value="phonevalue">电话</option>
    							<option value="idnumvalue">身份证号码</option>
    						</select><br>
    	请输入要修改的内容：<input type="text" name="content"/>
    	<input type="submit" value="修改" onclick="if(confirm('确定修改')==false) return false;"/>
    </form>
  </body>
</html>
