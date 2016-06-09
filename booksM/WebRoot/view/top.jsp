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
}
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="59" background="<%=basePath%>/image/top.gif"><table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
      	
        <td width="1%"><img src="<%=basePath%>/image/logo1.png" width="557" height="59" border="0" /></td>
        <td width="64%" align="right" style="font-size:12px;vertical-align:bottom;">&copy; 2016 www.xxxxxxxxx.com QQ:xxxxxxxxxxx Email:xxxxxxxxxxxx@163.com</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

