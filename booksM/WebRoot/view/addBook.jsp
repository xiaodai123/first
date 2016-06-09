<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>后台管理系统 by www.xxxxxxxxx.com</title>
<link rel="stylesheet" rev="stylesheet" href="<%=basePath%>/css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
<script type="text/javascript">
$(function(){
	$("#bookIsbn").blur(function(){
		var bookIsbn=$(this).val();
		$.get(
				"http://localhost:8080/booksM/CheckBookIsbnServlet?flag=borrow&bookIsbn="+bookIsbn,
				function(data,status){
					if(data!='书号不存在！'){
						alert("书号已存在！！！");
						$("#bookIsbn")[0].focus();
					}
				},
				"text"
			);
	});
	
});
function check(){
	var bookIsbn = $("#bookIsbn").val();
	var bookName = $("#bookName").val();
	var bookPublish = $("#bookPublish").val();
	var bookMoney = $("#bookMoney").val();
	var bookAuthor = $("#bookAuthor").val();
	if(bookIsbn==''||bookName==''||bookPublish==''||bookMoney==''||bookAuthor==''){
		alert("请全部填写！！！");
		return false;
	}
	var bookIsbnReg = /^[a-zA-Z0-9]*$/;
	if(bookIsbn!=null){
		if(!bookIsbnReg.test(bookIsbn)){
			alert("书号只能是数字和英文的组合");
			return false;
		}
	}
	var bookMoneyReg=/^[0-9]*$/;
	if(bookMoney!=null){
		if(!bookMoneyReg.test(bookMoney)){
			alert("定价只能是数字组合");
			return false;
		}
	}
	return true;
}
</script>
</head>
<body class="ContentBody">
  <form id="fom" action="/booksM/AddBookServlet" onsubmit="return check();" method="post"  name="fom" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >图书录入
      <span style="color:red;">${requestScope.msg } </span>   </th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		</td></tr>
		<tr align="center">
          <td class="TablePanel"></td>
		  </tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>Book ADD</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					  	<td nowrap align="right" width="15%">书号:</td>
					    <td width="35%"><input name="bookIsbn" id="bookIsbn" type="text"  style="width:154px" value="${requestScope.book.bookIsbn }" />
				        <span class="red">*</span></td>
					    <td nowrap align="right" width="18%">书名:</td>
					    <td width="35%"><input name="bookName" id="bookName" type="text" class="text" style="width:154px" value="${requestScope.book.bookName }" />	
					    <span class="red">*</span></td>
				        
					   
					    </tr>
						
						<tr>
						 <td nowrap align="right" width="15%">出版社:</td>
					    <td width="35%"><input name="bookPublish" id="bookPublish" type="text"  style="width:154px" value="${requestScope.book.bookPublish }" />
				        <span class="red">*</span></td>
					    <td nowrap align="right" width="18%">定价:</td>
					    <td width="35%"><input name="bookMoney" id="bookMoney" type="text" class="text" style="width:154px" value="${requestScope.book.bookMoney }" />	
					    <span class="red">*</span></td>
				         
						</tr>
						<tr>
						<td  width="15%" nowrap align="right">作者:</td>
					    <td colspan="3"><input name="bookAuthor" id="bookAuthor" type="text" class="text" style="width:154px" value="${requestScope.book.bookAuthor }" />
					    <span class="red">*多个作者之间用;（中文）分开</span>
					    <input name="up" value="${requestScope.up }" type="hidden">
					    <input name="bookId" value="${requestScope.book.bookId }" type="hidden">
					    </td>	
						</tr>
					  </table>
			  <br />
				</fieldset>			</TD>
		</TR>
		
		
		</TABLE>
	
	
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" value="保存" class="button" style="cursor: pointer;"/>　
			<input type="reset" value="重置" class="button" style="cursor: pointer;"/>　
			<input type="button" value="返回" class="button"  style="cursor: pointer;" onclick="window.location.href='/booksM/view/bookList.jsp'"/></TD>
		</TR>
		</TABLE>
	
	

  
  
  


</div>
</form>
</body>
</html>