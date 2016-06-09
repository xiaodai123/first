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
	
});
function check(){
	var teacherName=$("#teacherName").val();
	if(teacherName==''){
		$("#teacherNameTips").css("display","block");
		$("#teacherNameTips").html("请输入用户名！！！");
		return false;
	}
	var teacherPass=$("#teacherPass").val();
	if(teacherPass==''){
		$("#teacherPassTips").css("display","block");
		$("#teacherPassTips").html("请输入密码！！！");
		return false;
	}
	var teacherNameTipsVal=$("#teacherNameTips").html();
	if(teacherNameTipsVal!=''){
		return false;
	}
	var teacherPassTipsVal=$("#teacherPassTips").html();
	if(teacherPassTipsVal!=''){
		return false;
	}
	return true;
}