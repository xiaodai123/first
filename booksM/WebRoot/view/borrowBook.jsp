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
<script type="text/javascript" src="<%=basePath%>/view/borrowBook.js"></script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>
<body class="ContentBody">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >借阅书籍   </th>
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
				<legend>Borrow Book</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr id="bookIsbnLable" style="display:block;">
				        <td  width="33%" align="right">请输入借阅书籍的书号:</td>
					    <td width="33%"><input name="bookIsbn" id="bookIsbn" type="text" class="text" style="width:154px" value="" />
					    </td>	
					    <td width="33%"><span class="red" id="bookIsbnTips" style="display:none"></span></td>
					    </tr>
						
						<tr id="studentCodeLable" style="display:none;">
						 <td width="33%" align="right">请输入借阅者的学号:</td>
					    <td width="33%"><input name="studentCode" id="studentCode" type="text" class="text" style="width:154px" value="" />
					    </td>	
				         <td width="33%"><span class="red" id="studentCodeTips" style="display:none"></span></td>
						</tr>
						<tr id="buttonLable" style="display:none;">
					    <td width="33%" colspan="3" align="center">
						<input type="button" value="借阅" class="button" id="borrow" style="cursor: pointer;"/>　
					    </td>
						</tr>
					  </table>
			  <br />
				</fieldset>			</TD>
		</TR>
		
		
		</TABLE>
	
	
	 </td>
  </tr>
		
		</TABLE>
	
	

  
  
  


</div>
</body>
</html>