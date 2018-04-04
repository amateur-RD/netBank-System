<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>分页显示交易记录</title>
    <script type="text/javascript">
        function select() {
        	var curPage=document.getElementById("curPage").value;
			location.href="/ssh2-netBank/transaction/list?pager.curPage="+curPage;
        }
    </script>
</head>
<body>
    <div align="center">
        <table width="650" border="1" cellpadding="0" cellspacing="0">
        <tbody align="center">
            <tr>
                <td colspan="5" style="font-size: 20px; color: red;" align="center">交易记录一览表</td>
            </tr>
            <tr>
                <td width="50">序号</td>
                <td width="80">对方账户</td>
                <td width="80">交易金额</td>
                <td width="80">交易类型</td>
                <td>交易日期</td>
            </tr>
            <s:iterator value="#request.logs" status="status">
                <tr>
                    <td><s:property value="#status.count"/></td>
                    <s:if test="otherid==#session.user.accountid && transactionType.name!='取款'">
                        <td><s:property value="account.accountid"/></td>
                        <td><s:property value="tr_money"/></td>
                    </s:if>
                    <s:else>
                        <td><s:property value="otherid"/></td>
                        <td><s:property value="tr_money"/></td>
                    </s:else>
                    <td><s:property value="transactionType.name"/></td>
                    <td><s:property value="datetime"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <!-- 分页超链接部分 -->
        <table>
            <tr>
                <td width="130"></td>
                <td width="80">
                    <s:if test="pager.curPage > 1">
                        <a href='/ssh2-netBank/transaction/list?pager.curPage=1'>首页</a>&nbsp;&nbsp;
                        <a href='/ssh2-netBank/transaction/list?pager.curPage=${pager.curPage-1}'>上一页</a>
                    </s:if>
                </td>
                <td width="80">
                    <s:if test="pager.curPage < pager.pageCount">
                        <a href='/ssh2-netBank/transaction/list?pager.curPage=${pager.curPage+1}'>下一页</a>&nbsp;&nbsp;
                        <a href='/ssh2-netBank/transaction/list?pager.curPage=${pager.pageCount}'>尾页</a>
                    </s:if>
                </td>
                <td>
                                                共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;转至
                    <select onchange="select()" id="curPage">
                        <s:iterator>
                            <s:if test="#status.count == pager.curPage">
                                <option value="${status.count}" selected="selected">${status.count}</option>
                            </s:if>
                            <s:else>
                                <option value="${status.count}">${status.count}</option>
                            </s:else>
                        </s:iterator>
                    </select>页
                </td>
            </tr>
        </table>
    </div>
</body>
</html>