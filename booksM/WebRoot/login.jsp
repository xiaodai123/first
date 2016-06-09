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
	<title>login</title>
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main_login.css">
<script type="text/javascript" src="login.js"></script>
</head>
<body>

<!-- 页面主体START -->
<header class="sso_header"></header>
<section class="content_box cleafix">
	<div class="left_area fl">
	<span class="input_tips" id="sessionTips" style="display: block;">${requestScope.msg}</span>
		<form action="/booksM/LoginServlet" method="post" onsubmit="return check()">
			<div class="form_body">
				<div style="display: block;" class="input_item clearfix">
					<input class="input input_white input_warning" id="teacherName" name="teacherName" placeholder="请输入已注册账号" data-required="required" autocomplete="off" type="text">
				<span class="input_tips" id="teacherNameTips" style="display: none;"></span></div>
				<div style="display: block;" class="input_item clearfix">
					<input class="input input_white input_warning" id="teacherPass" name="teacherPass" placeholder="请输入密码" data-required="required" autocomplete="off" type="password">
				<span class="input_tips" id="teacherPassTips" style="display: none;"></span></div>
				
				<div class="input_item clearfix">
					<a href="/booksM/findPass.jsp" class="forgot_pwd">忘记密码？</a>
				</div>
				<div style="display: block;" class="input_item clearfix">
					<input class="btn btn_green btn_active btn_block btn_lg" value="登&nbsp;录" type="submit">
				</div>
				<div class="input_item clearfix">
					<h5 class="reg_now">还没有账号？<a href="/booksM/register.jsp">立即注册</a></h5>
				</div>
			</div>
		</form>
	</div>
</section>

<footer>
	<h4 class="slogan">— 读书使人进步 —</h4>
</footer>

</body></html>
