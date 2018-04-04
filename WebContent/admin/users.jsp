<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@page import="com.cy.entity.Admin"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有账户信息</title>
</head>
<body>
    <div align="center">
        <form action="/ssh2-netBank/admin/search" method="post">
                             输入要查询用户的<b style="color: red">真实姓名</b>：
            <input name="personinfo.realname" />
            <input name="status.id" type="hidden" value="${status.id}">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="提交">
        </form>
    </div>
    <div align="center" style="margin-top: 10px">
        <table width="100%" height="73px" cellpadding="0" cellspacing="0" bordercolor="#999999" bgcolor="#999999" border="1" align="center">
            <tr>
                <td height="20px" bgcolor="#999999" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">序列</font></div>
                </td>
                <td height="20px" bgcolor="#999999" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">账户</font></div>
                </td>
                <td height="20px" bgcolor="#999999" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">用户名</font></div>
                </td>
                <td height="20px" bgcolor="#808080" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">余额</font></div>
                </td>
                <td height="20px" bgcolor="#808080" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">姓名</font></div>
                </td>
                <td height="20px" bgcolor="#808080" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">地址</font></div>
                </td>
                <td height="20px" bgcolor="#999999" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">身份证号</font></div>
                </td>
                <td height="20px" bgcolor="#808080" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">电话号码</font></div>
                </td>
                <td height="20px" bgcolor="#808080" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">状态</font></div>
                </td>
                <td height="20px" bgcolor="#808080" nowrap="nowrap" colspan="2">
                    <div align="center"><font color="#FFFFFF">操作</font></div>
                </td>
                <td height="20px" bgcolor="#999999" nowrap="nowrap">
                    <div align="center"><font color="#FFFFFF">&nbsp;</font></div>
                </td>
            </tr>
            <!-- 循环显示用户信息 -->
            <s:iterator value="#request.users" status="status">
                <tr bgcolor="#FFFFFF">
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="#status.count"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="account.accountid"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="account.username"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="account.balance"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="realname"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="address"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="cardid"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="telephone"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center"><s:property value="account.status.name"/></div>
                    </td>
                    <td height="20px" valign="middle">
                        <div id="noWrap" align="center">
                            <s:if test="account.status.name=='启用'">
                                <input type="button" value="冻结" onclick="javascript:location.href='/ssh2-netBank/admin/locking?id=${account.accountid} & status.id=${status.id}'">
                            </s:if>
                            <s:else>
                                <input type="button" value="启用" onclick="javascript:location.href='/ssh2-netBank/admin/enabled?id=${account.accountid} & status.id=1'">
                            </s:else>
                        </div>
                    </td>
                    <td height="20px" valign="center">
                        <div id="noWrap" align="center">
                            <a href="/ssh2-netBank/admin/del?id=${account.accountid} & status.id=${status.id}"> 删除 </a>
                        </div>
                    </td>
                </tr>
            </s:iterator>
            <tr>
                <td height="20" colspan="14" valign="middle"></td>
            </tr>
        </table>
    </div>
</body>
</html>