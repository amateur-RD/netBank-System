<%@page contentType="text/html;charset=utf-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
if(session.getAttribute("admin")!=null){
	
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../style.css">
<link rel="stylesheet" type="text/css" href="../default.css">
</head>
<body leftmargin="40" topmargin="20" marginheight="0" marginwidth="0">


	<table cellpadding="0" cellspacing="0" align="center" width="200">
	
	  <tr>
	        <td height=40 align="center" bgcolor="gray"> 
	          <b>后台管理</b></td>
	  </tr>
	  <tr>
	    <td bgcolor="#F5EFE7">
	            <table cellpadding="0" cellspacing="0" align="center" width="200" height="300px">    
	            	<tr> 
	                <td height="40px"><a href=/ssh2-netBank/admin/listUsers?status.id=0 target=right>所有账户</a></td>
	              </tr> 
	              <tr> 
	                <td height="40px"><a href=/ssh2-netBank/admin/listUsers?status.id=2 target=right>已冻结账户</a></td>
	              </tr>
	              <tr> 
	                <td height="40px"><a href=/ssh2-netBank/admin/listUsers?status.id=1 target=right>已启用账户</a></td>
	              </tr>
	              <tr> 
	                <td height="40px"><a href=/ssh2-netBank/admin/add.jsp target=right>开户</a></td>
	              </tr>
	              <tr> 
	                <td height="40px"><a href=/ssh2-netBank/admin/changepwd.jsp target=right>修改个人密码</a></td>
	              </tr>
	              <tr> 
	                <td height="40px"><a href=/ssh2-netBank/admin/logout target=_top>注销</a></td>
	              </tr>
	              </table>
		</td>
	  </tr>
	</table>
</body>
</html>
<%
}
else{//------------------------------------not logged-------------------------------------------------------
response.sendRedirect("index.jsp");
}
%>