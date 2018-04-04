<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改个人信息</title>
</head>
<body>
    <form action="info/info_modify" name="myform" method="post">
        <div align="center">
        <table width="450" class="table" cellpadding="0" cellspacing="0" border="0">
            <tbody>
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
                        <s:fielderror fieldName="personinfo.age" cssStyle="color:red" />
                    </td>
                </tr>
                <tr>
                    <td>性　　别：</td>
                    <td width="360" height="30">
                        <select name="personinfo.sex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
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
                        <font size="1" style="color: red">区号（3或4位）-电话（8或9位）</font>
                    </td>
                </tr>
                <tr>
                    <td>身份证号：</td>
                    <td width="360" height="30">
                        <input type="text" name="personinfo.cardid" value="${personinfo.cardid}" />
                        <font size="1" style="color: red">15位或18位</font>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td width="360" height="30">
                        <input type="submit" value="提交" />
                    </td>
                </tr>
            </tbody>
        </table>
        
    </div>
    </form>
</body>
</html>