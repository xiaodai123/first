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
	<title>register</title>
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="register.js"></script>

<link rel="stylesheet" type="text/css" href="css/main_register.css">
<script type="text/javascript">
function check(){
	
	var teacherName=$("#teacherName").val();
	
	if(teacherName==''){
		alert("请输入账号！！！");
		return false;
	}
	
	var teacherPass=$("#teacherPass").val();
	
	if(teacherPass==''){
		alert("请输入密码！！！");
		return false;
	}
	var codeVal=$("#code").val();
	if(codeVal==''){
		alert("请输入验证码！！！");
		return false;
	}

	var teacherNameTipsVal=$("#teacherName").html();
	
	if(teacherNameTipsVal!=''){
		return false;
	}
	var teacherPassTipsVal=$("#teacherPass").html();
	
	if(teacherPassTipsVal!=''){
		return false;
	}
	
	var codeTipsVal=$("#codeTips").html();
	if(codeTipsVal!=''){
		return false;
	}
	
	
	
	
	return true;
}
</script>
</head>
<body>

<!-- 页面主体START -->
<header class="sso_header">
</header>
<section class="content_box cleafix">
	<div class="left_area fl">
		<form id="form1" action="/booksM/RegisterServlet" method="post" onsubmit="return check();">
			<ul class="form_head clearfix">
				<li class="active" id="icon_phone">
					<i class="icon icon_phone"></i>
					注册
				</li>
			</ul>
			<span class="input_tips" id="sessionTips" style="display: block;">${requestScope.msg}</span>
			<div style="display: block;" id="phoneRegister" class="form_body">
				<div style="display: block;" class="input_item clearfix">
					<input class="input input_white" id="teacherName" name="teacherName" placeholder="请输入" data-required="required" autocomplete="off" type="text">
				</div>
				<span class="input_tips" id="teacherNameTips" style="display:none;"></span>
				<div style="display: block;" class="input_item clearfix">
					<input class="input input_white" id="teacherPass" name="teacherPass" placeholder="请输入密码" data-required="required" autocomplete="off" type="password">
				</div>
				<span class="input_tips" id="teacherPassTips" style="display:none;"></span>
				<div class="input_item clearfix" style="display: block;">
					<input class="input input_white fl" style="width:170px; display:block;" name="code" id="code" placeholder="请证明你不是机器人" data-required="required" autocomplete="off" type="text">
					<img src="/booksM/AuthCodeServlet" class="yzm" style="cursor: pointer;">
					
					<span class="reflash" style="cursor: pointer;"></span>
				</div>
				<span class="input_tips" id="codeTips" style="display:none;"></span>
				<div style="display: block;" class="input_item clearfix">
					<input class="btn btn_green btn_active btn_block btn_lg" value="注&nbsp;册" type="submit" id="register">
				</div>
			</div>
		</form>
	</div>
	
</section>
<footer>
	<h4 class="slogan">— 读书使人进步—</h4>
</footer>

</body></html>