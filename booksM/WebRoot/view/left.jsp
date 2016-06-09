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
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(<%=basePath%>/image/left.gif);
}
-->
</style>
<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>

function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="<%=basePath%>/image/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="<%=basePath%>/image/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="<%=basePath%>/image/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="<%=basePath%>/image/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="<%=basePath%>/image/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="<%=basePath%>/image/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="<%=basePath%>/image/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">${sessionScope.teacher.teacherName}  </span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						<!-- javascript:parent.window.location.href='<%=basePath%>/login.html' -->
						[&nbsp;<a href="/booksM/LogoutServlet" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
		


		<!--  用户管理开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="<%=basePath%>/image/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >用户管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu20" src="<%=basePath%>/image/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="/booksM/view/studentList.jsp" target="mainFrame" class="left-font03" onClick="tupian('20');">学生管理</a></td>
				</tr>
      </table>
		<!--  用户管理结束    -->

		

		<!-- 图书系统开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="<%=basePath%>/image/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >图书管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu17" src="<%=basePath%>/image/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="/booksM/view/bookList.jsp" target="mainFrame" class="left-font03" onClick="tupian('17');">管理图书</a></td>
				</tr>
				<tr>
				  <td width="9%" height="21" ><img id="xiaotu21" src="<%=basePath%>/image/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="/booksM/view/borrowBook.jsp" target="mainFrame" class="left-font03" onClick="tupian('21');">借阅图书</a></td>
				</tr>
				<tr>
				  <td width="9%" height="23" ><img id="xiaotu24" src="<%=basePath%>/image/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="/booksM/view/returnBook.jsp" target="mainFrame" class="left-font03" 
						onClick="tupian('24');">归还图书</a></td>
				</tr>
      </table>
		<!--  审核系统结束    -->
		
	  </TD>
  </tr>
  
</table>
</body>
</html>