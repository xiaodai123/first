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
	$("#studentCode").blur(function(){
		$.get(
				"http://localhost:8080/booksM/CheckStudentIdServlet?studentCode="+$(this).val(),
				function(data,status){
					if(data=='ok'){
						alert("学号已存在！！！");
						$("#studentCode")[0].focus();
					}
				},
				"text"
		);
	});
});
function check(){
	var studentCode = $("#studentCode").val();
	var studentName = $("#studentName").val();
	var studentClass = $("#studentClass").val();
	if(studentCode==''||studentName==''||studentClass==''){
		alert("请全部填写！！！");
		return false;
	}
	var studentCodeReg=/^[0-9]*$/;
	if(studentCode!=null){
		if(!studentCodeReg.test(studentCode)){
			alert("学号只能是数字组合");
			return false;
		}
	}
	return true;
}
</script>
</head>
<body class="ContentBody">
  <form id="fom" action="/booksM/AddStudentServlet" onsubmit="return check();" method="post"  name="fom" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >学生录入
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
				<legend>Student ADD</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
				        <td  width="15%" nowrap align="right">学号:</td>
					    <td colspan="3"><input name="studentCode" id="studentCode" type="text" class="text" style="width:154px" value="${requestScope.student.studentCode }" />
					    <span class="red">*</span>
					    <input name="up" value="${requestScope.up }" type="hidden">
					    <input name="studentId" value="${requestScope.student.studentId }" type="hidden">
					    </td>	
					   
					    </tr>
						
						<tr>
						 <td nowrap align="right" width="15%">姓名:</td>
					    <td width="35%"><input name="studentName" id="studentName" type="text"  style="width:154px" value="${requestScope.student.studentName }" />
				        <span class="red">*</span></td>
					    <td nowrap align="right" width="18%">班级:</td>
					    <td width="35%"><input name="studentClass" id="studentClass" type="text" class="text" style="width:154px" value="${requestScope.student.studentClass }" />	
					    <span class="red">*</span></td>
				         
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
			<input type="button" value="返回" class="button"  style="cursor: pointer;" onclick="window.location.href='/booksM/view/studentList.jsp'"/></TD>
		</TR>
		</TABLE>
	
	

  
  
  


</div>
</form>
</body>
</html>