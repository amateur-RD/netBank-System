<%@ page language="java" contentType="text/html;" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>存款</title>
    <script type="text/javascript">
    
        //获取时间 
	    function disptime(){
	    	var now=new Date();
	    	
	    	var year=now.getFullYear();
	    	var month=now.getMonth()+1;
	    	var date=now.getDate();
	    	var hour=now.getHours();
	    	var minute=now.getMinutes();
	    	var second =now.getSeconds();
	    		document.getElementById("datetime").value=year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
	    		//year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
	    		setTimeout("disptime()", 1000);
	    	}    
    
        //判断用户输入的存款金额是否合理
        function withdraw() {
        	var money = document.getElementById("tr_money").value;
        	//alert(money.length);
        	if(money.length>0) {
        		if(!(money.search(/^[\+\-]?\d+\.?\d*$/)==0)) {
    				document.getElementById("errormoney").innerHTML="含有非法字符!";
    				return false;
    			}else {
    				if(parseFloat(money)==0) {
    					document.getElementById("errormoney").innerHTML="金额必须大于0!";
    					return false;
    				}
    				return confirm("确认要取款吗？ ");
    			}
        	} else {
        		document.getElementById("errormoney").innerHTML="金额不能为空！";
        		return false;
        	}
        }
        
    </script>
</head>
<body onload="disptime()">
    <form action="/ssh2-netBank/transaction/withdraw" name="myform" method="post" onsubmit="return withdraw()">
        <div align="center">
            <table>
                <tbody>
                    <tr>
                    <td>取款时间：</td>
                    <td width="360" height="30">
                        <input type="text" name="log.datetime" id="datetime" />
                    </td>
                </tr>
                <tr>
                    <td>取款金额：</td>
                    <td width="360" height="30">
                        <input type="text" name="log.tr_money" id="tr_money" />
                        <span id="errormoney" style="color:red;"></span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td width="360" height="30">
                        <input type="submit" value="取款" />
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <s:fielderror name="log.tr_money" style="color:red;"></s:fielderror>
        </div>
    </form>
</body>
</html>