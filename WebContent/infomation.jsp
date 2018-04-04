<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息详情</title>
</head>
<body>
    <div align="center">
        <table width="450" class="table" cellpadding="0" cellspacing="0" border="0">
            <tbody>
                <tr>
                    <td>账户　ID：</td>
                    <td width="360" height="30">
                        <input type="text" name="user.accountid" value="${user.accountid}" />
                    </td>
                </tr>
                <tr>
                    <td>姓　　名：</td>
                    <td width="360" height="30">
                        <input type="text" name="personinfo.realname" value="${personinfo.realname}" />
                    </td>
                </tr>
                <tr>
                    <td>年　　龄：</td>
                    <td width="360" height="30">
                        <input type="text" name="personinfo.age" value="${personinfo.age}" />
                    </td>
                </tr>
                <tr>
                    <td>性　　别：</td>
                    <td width="360" height="30">
                        <input type="text" name="personinfo.sex" value="${personinfo.sex}" />
                    </td>
                </tr>
                <tr>
                    <td>家庭住址：</td>
                    <td width="360" height="30">
                        <input type="text" name="personinfo.address" value="${personinfo.address}" />
                    </td>
                </tr>
                <tr>
                    <td>联系电话：</td>
                    <td width="360" height="30">
                        <input type="text" name="personinfo.telephone" value="${personinfo.telephone}" />
                    </td>
                </tr>
                <tr>
                    <td>身份证号：</td>
                    <td width="360" height="30">
                        <input type="text" name="personinfo.cardid" value="${personinfo.cardid}" />
                    </td>
                </tr>
                <tr>
                    <td>账户余额：</td>
                    <td width="360" height="30">
                        <input type="text" name="user.balance" value="${user.balance}" />
                    </td>
                </tr>
            </tbody>
        </table>
        
    </div>
</body>
</html>