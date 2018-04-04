<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
    	<s:fielderror cssStyle="color:red;"/>
    	${message}<br>
    	<!--上传时间:<s:date name="date"/><br>
					 realPath:${realPath}<br>
				    contextPath:${contextPath}<br>
				    contextName:${contextName}<br> -->
		
	</div>
</body>
</html>