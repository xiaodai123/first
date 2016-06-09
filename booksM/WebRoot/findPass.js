$(function(){
	$("#teacherName").blur(function(){
		var teacherName=$(this).val();
		if(teacherName==''){
			$("#teacherNameTips").html("");
			$("#teacherNameTips").css("display","none");
			return false;
		}else{
			$.get(
					"http://localhost:8080/booksM/FindTeacherNameIsRegister?flag=1&teacherName="+teacherName,
					function(data,status){
						if(data!='ok'){
							$("#teacherNameTips").html(data);
							$("#teacherNameTips").css("display","block");
							return false;
						}else{
							$("#teacherNameTips").html("");
							$("#teacherNameTips").css("display","none");
							return true;
						}
					},
					"text"
				);
		}
	});
	$("#teacherName").focus(function(){
		$("#teacherNameTips").html("");
		$("#teacherNameTips").css("display","none");
	});
	$("#code").blur(function(){
		var codeVal=$(this).val();
		//var upIdorupPassReg=/^[a-zA-Z][a-zA-Z0-9_]*$/;
		
		if(codeVal==''){
			$("#codeTips").html("");
			$("#codeTips").css("display","none");
			return false;
		}else{
			$.get(
				"http://localhost:8080/booksM/CheckCodeServlet?code="+codeVal,
				function(data,status){
					if(data!='ok'){
						$("#codeTips").html(data);
						$("#codeTips").css("display","block");
						return false;
					}else{
						$("#codeTips").html("");
						$("#codeTips").css("display","none");
						return true;
					}
				},
				"text"
			);
		}
		
	});
	$("#code").focus(function(){
		$("#codeTips").html("");
		$("#codeTips").css("display","none");
		var codeVal=$(this).val();
		if(codeVal!=''){
			$(this).val('');
			var imgSrc=$(".yzm");
			var src=imgSrc.attr("src");
			imgSrc.attr("src",chgUrl(src));
		}
	});
	$(".yzm").click(function(){
		var imgSrc=$(this);
		//alert("sss");
		var src=imgSrc.attr("src");
		//alert(src);
		imgSrc.attr("src",chgUrl(src));
		
	});
	
});
function chgUrl(url){
	var timestamp = (new Date()).valueOf();     
	urlurl = url.substring(0,49);      
	urlurl = urlurl + "?timestamp=" + timestamp;     
	return urlurl; 
}
function checkId(){
	this.flag='ok';
	var teacherName=$("#teacherName").val();
	if(teacherName==''){
		$("#teacherNameTips").html("请输入用户名！！！");
		$("#teacherNameTips").css("display","block");
		this.flag='error';
	}
	var teacherNameTips=$("#teacherNameTips").html();
	if(teacherNameTips!=''){
		this.flag='error';
	}
	var codeVal=$("#code").val();
	if(codeVal==''){
		$("#codeTips").html("请输入");
		$("#codeTips").css("display","block");
		this.flag='error';
	}
	var codeTips=$("#codeTips").html();
	if(codeTips!=''){
		this.flag='error';
	}
	if(this.flag=='ok'){
		$("#step12").addClass("active");
		$("#idFindStep1").css("display","none");
		$("#idFindStep2").css("display","block");
		$.get(
		"http://localhost:8080/booksM/FindTeacherPassServlet?teacherName="+teacherName,
		function(data,status){
			$("#oldPassTips").html("旧密码："+data);
			
		},
		"text"
		);
		
	}
}
function checkId2(){
	this.flag='ok';
	var password1Val=$("#password1").val();
	if(password1Val==''){
		$("#password1Tips").html("请输入密码");
		$("#password1Tips").css("display","block");
		this.flag='error';
	}
	var password2Val=$("#password2").val();
	if(password2Val==''){
		$("#password2Tips").html("请输入密码");
		$("#password2Tips").css("display","block");
		this.flag='error';
	}
	var password1TipsVal=$("#password1Tips").html();
	if(password1TipsVal!=''){
		this.flag='error';
	}
	var password2TipsVal=$("#password2Tips").html();
	if(password2TipsVal!=''){
		this.flag='error';
	}
	if(this.flag=='ok'){
		$("#findPwd1").css("display","none");
		$("#findPwd3").css("display","block");
		$.get(
		"http://localhost:8080/booksM/ChangeTeacherPassServlet?teacherName="+$("#teacherName").val()+"&teacherPass="+$("#password1").val(),
		function(data,status){
			$("#changeTips").html(data);
			
		},
		"text"
		);
		
	}
}