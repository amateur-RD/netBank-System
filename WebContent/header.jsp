<%@ page import="java.util.*" language="java" contentType="text/html;" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link href="css/admin.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">
	    function showTime(){
			//使用对象.innerText修改span元素间的内容
			document.getElementById("now").innerText="当前时间："+new Date().toLocaleString();
		}		
		setInterval("showTime()",1000);//每隔1000毫秒(1s)调用showTime函数
    </script>
</head>
<body>
    <table border="0" cellpadding="0" cellspacing="0" width="100%" background="images/header_bg.jpg">
        <tr height="56">
            <td width="260"><img height="56" src="images/header_left.jpg"></td>
            <td style="font-weight: bold; font-size: 14px; color: #FFF; padding-top: 20px;" align="center">
                                       当前用户：<s:property value="#session.personinfo.realname"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
                <span id="now"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><a id="menuChild" style="font-size: 13px; color:white; font-weight: bold;" href="/ssh2-netBank/user/user_logout" target="_top">注销</a></span>                       
            </td>
            <td align="right" width="268">
                <img height="56" width="268" src="images/header_right.jpg">
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" border="0" width="100%">
        <tr height="4" bgcolor="#1c5db6">
            <td></td>
        </tr>
    </table>
</body>
</html>