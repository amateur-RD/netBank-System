<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet" >
</head>
<body>
    <table width="170" height="100%" cellspacing="0" cellpadding="0" background="images/menu_bg.jpg" border="0">
        <tr>
            <td valign="top" align="center">
                <table width="150" cellpadding="0" cellspacing="0" border="0">
                    <tr height="25">
                        <td style="padding-left: 30px" background="images/menu_bt.jpg">
                            <a style="font-size: 15px" class="menuParent" onclick="expend(1)" href="javascript:void(0);">²Ù×÷²Ëµ¥</a>
                        </td>
                    </tr>
                    <tr height="6">
                        <td></td>
                    </tr>
                </table>
                <table id="child0" width="150" cellpadding="0" cellspacing="0" border="0">
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/deposit.jsp" target="main">´æ¿î</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/withdraw.jsp" target="main">È¡¿î</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/transfer.jsp" target="main">×ªÕË</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/transaction/list?pager.curPage=1" target="main">²éÑ¯½»Ò×¼ÇÂ¼</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/infomation.jsp" target="main">²é¿´¸öÈËÐÅÏ¢</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td> 
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/modify.jsp" target="main">ÐÞ¸Ä¸öÈËÐÅÏ¢</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/changepwd.jsp" target="main">ÐÞ¸ÄÃÜÂë</a>
                        </td>
                    </tr>
                    <tr height="20">
                        <td width="30" align="center">
                           <img width="9" height="9" src="images/menu_icon.gif"> 
                        </td>
                        <td>
                            <a id="menuChild" style="font-size: 13px" href="/ssh2-netBank/user/user_logout" target="_top">×¢Ïú</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>