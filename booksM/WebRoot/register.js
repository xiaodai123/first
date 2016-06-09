$(function(){
	$("#teacherName").blur(function(){
		var teacherName=$(this).val();
		if(teacherName==''){
			$("#teacherNameTips").html("");
			$("#teacherNameTips").css("display","none");
			return false;
		}else{
			$.get(
					"http://localhost:8080/booksM/FindTeacherNameIsRegister?teacherName="+teacherName,
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
	$("#teacherPass").blur(function(){
		var upPass=$(this).val();
		var upIdorupPassReg=/^[a-zA-Z][a-zA-Z0-9_]*$/;
		if(upPass==''){
			$("#teacherPassTips").html("");
			$("#teacherPassTips").css("display","none");
			return false;
		}else{
		
			if(!upIdorupPassReg.test(upPass)){
				$("#teacherPassTips").html("以英文字母开头，只能包含英文字母、数字、下划线");
				$("#teacherPassTips").css("display","block");
				return false;
			}else{
				if(upPass.length<6||upPass.length>16){
					$("#teacherPassTips").html("密码必须是6到16位");
					$("#teacherPassTips").css("display","block");
					return false;
				}else{
					$("#teacherPassTips").html("");
					$("#teacherPassTips").css("display","none");
					return false;
				}
			}
		}
	});
	$("#teacherPass").focus(function(){
		$("#teacherPassTips").html("");
		$("#teacherPassTips").css("display","none");
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
