<%@ page language="java" import="java.util.*" contentType="text/html;" pageEncoding="gb2312"%>

<% if(session.getAttribute("user")==null) { %>
        <<jsp:forward page="login.jsp"></jsp:forward>
<% } %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>网上银行系统</title>
<link href="css/admin.css" type="text/css" rel="stylesheet">
</head>
    <frameset border="1" framespacing="0" rows="60,*" frameborder="1">
        <frame name="header" src="/ssh2-netBank/header.jsp" frameborder="1" noresize scrolling="no" />
        <frameset cols="170,*">
             <frame name="menu" src="/ssh2-netBank/left.jsp" frameborder="1" noresize>
             <frame name="main" src="/ssh2-netBank/main.jsp" frameborder="1" noresize scrolling="yes">
        </frameset>    
    </frameset>
    <noframes>
    </noframes>
</html>