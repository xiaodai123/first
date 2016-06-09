$(function(){
	$("#bookIsbn").blur(function(){
		var bookIsbn=$(this).val();
		if(bookIsbn==''){
			$("#bookIsbnTips").html("");
			$("#bookIsbnTips").css("display","none");
			$("#studentCodeLable").css("display","none");
			$("#buttonLable").css("display","none");
			return false;
		}else{
			$.get(
					"http://localhost:8080/booksM/CheckBookIsbnServlet?flag=borrow&bookIsbn="+bookIsbn,
					function(data,status){
						if(data!='ok'){
							$("#bookIsbnTips").html(data);
							$("#bookIsbnTips").css("display","block");
							$("#studentCodeLable").css("display","none");
							return false;
						}else{
							$("#bookIsbnTips").html("");
							$("#bookIsbnTips").css("display","none");
							$("#studentCodeLable").css("display","block");
							return true;
						}
					},
					"text"
				);
		}
	});
	$("#bookIsbn").focus(function(){
		$("#bookIsbnTips").html("");
		$("#bookIsbnTips").css("display","none");
		$("#studentCodeLable").css("display","none");
		$("#buttonLable").css("display","none");
	});
	$("#studentCode").blur(function(){
		var studentCode=$(this).val();
		if(studentCode==''){
			$("#studentCodeTips").html("");
			$("#studentCodeTips").css("display","none");
			$("#buttonLable").css("display","none");
			return false;
		}else{
			$.get(
					"http://localhost:8080/booksM/CheckStudentIdServlet?studentCode="+studentCode,
					function(data,status){
						if(data!='ok'){
							$("#studentCodeTips").html(data);
							$("#studentCodeTips").css("display","block");
							$("#buttonLable").css("display","none");
							return false;
						}else{
							$("#studentCodeTips").html("");
							$("#studentCodeTips").css("display","none");
							$("#buttonLable").css("display","block");
							return true;
						}
					},
					"text"
				);
		}
	});
	$("#studentCode").focus(function(){
		$("#studentCodeTips").html("");
		$("#studentCodeTips").css("display","none");
		$("#buttonLable").css("display","none");
	});
	$("#borrow").click(function(){
		var bookIsbn=$("#bookIsbn").val();
		var studentCode=$("#studentCode").val();
		$.get(
				"http://localhost:8080/booksM/BorrowBookServlet?bookIsbn="+bookIsbn+"&studentCode="+studentCode,
				function(data,status){
					alert(data);
					$("#buttonLable").css("display","none");
					$("#studentCodeLable").css("display","none");
					$("#bookIsbn").val("");
					$("#studentCode").val("");
				},
				"text"
			);
	});
});