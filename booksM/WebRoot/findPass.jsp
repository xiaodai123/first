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
	<title>findPass</title>
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="findPass.js"></script>

<link rel="stylesheet" type="text/css" href="css/step1.css">
</head>
<body>
<!-- 页面主体START -->
<header class="sso_header">
</header>
<form name="demo">
<section style="display: block;" class="content_box" id="findPwd1">
	<!-- 通过账号找回密码 -->
	<div class="findPwd">
		<h5 class="change_way"><a id="go-mail"></a></h5>
		
			<ul class="form_head clearfix">
				<li class="active">
					<span class="icon_step step1"></span>
					验证账号
				</li>
				<li style="width:59px;margin-left: 73px;" id="step12">
					<span class="icon_step step2"></span>
					重置密码
				</li>
			</ul>
			<div class="form_body" style="display:block" id="idFindStep1">
				<div style="display: block;" class="input_item clearfix">
					<input class="input input_white" id="teacherName" name="teacherName" placeholder="请输入账号" autocomplete="off" type="text"> 
				</div>
				<span class="input_tips" id="teacherNameTips" style="display:none;"></span>
				<div class="input_item clearfix" style="display: block;">
					<input class="input input_white fl" style="width:170px; display:block;" name="code" id="code" placeholder="请证明你不是机器人" data-required="required" autocomplete="off" type="text">
					<img src="/booksM/AuthCodeServlet" class="yzm" style="cursor: pointer;">
				</div>
				<span class="input_tips" id="codeTips" style="display:none;"></span>
				<div style="display: block;" class="input_item clearfix">
					<input class="btn btn_green btn_active btn_block" value="找回密码" type="button" onclick="checkId()">
				</div>
			</div>
			<div class="form_body" style="display:none" id="idFindStep2">
				<span class="input_tips" id="oldPassTips" style="display:block;"></span>
				<div style="display: block;" class="input_item clearfix">
					<input class="input input_white" id="password1" name="password1" placeholder="请输入新密码 " data-required="required" autocomplete="off" type="password"> 
				</div>
				<span class="input_tips" id="password1Tips" style="display:none;"></span>
				<div style="display: block;" class="input_item clearfix">
					<input class="input input_white" id="password2" name="password2" placeholder="请再次输入密码" data-required="required" autocomplete="off" type="password"> 
				</div>
				<span class="input_tips" id="password2Tips" style="display:none;"></span>
				<div style="display: block;" class="input_item clearfix">
					<input class="btn btn_green btn_active btn_block" value="确定" type="button" onclick="checkId2()">
				</div>
			</div>
	</div>
</section>
<section style="display: none;" class="content_box" id="findPwd3">
	<!-- 通过账号找回密码 -->
	<div class="findPwd">
			<div class="form_body" style="display:block">
				<span class="input_tips" id="changeTips" style="display:block;"></span>
				<a href="http://localhost:8080/booksM/findPass.jsp" style="color:blank;">返回</a>
			</div>
	</div>
</section>
</form>
<footer>
	<h4 class="slogan">— 读书使人进步 —</h4>
</footer>
</body></html>
