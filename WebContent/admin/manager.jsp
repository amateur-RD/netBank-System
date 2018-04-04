<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if(session.getAttribute("admin")==null)
	{ 
%>
		<jsp:forward page="/login.jsp"></jsp:forward>
<%
	}
%>
<html>
<head>
<title>管理员页面</title>
</head>
    <frameset framespacing="0" border="false" cols="230,*" frameborder="0">
    <frame name="left"  scrolling="no" marginwidth="0" marginheight="0" src="left.jsp">
    <frame name="right" scrolling="yes" src="main.jsp">
</frameset>

<noframes>
</noframes> 
</html>