$(function(){
	$("#bookIsbn").blur(function(){
		var bookIsbn=$(this).val();
		if(bookIsbn==''){
			$("#bookIsbnTips").html("");
			$("#bookIsbnTips").css("display","none");
			$("#buttonLable").css("display","none");
			return false;
		}else{
			$.get(
					"http://localhost:8080/booksM/CheckBookIsbnServlet?flag=return&bookIsbn="+bookIsbn,
					function(data,status){
						
						if(data=='ok'){
							$("#bookIsbnTips").html("");
							$("#bookIsbnTips").css("display","none");
							$("#buttonLable").css("display","block");
						}else if(data=='该书借阅超期，罚款30元!!!'){
							$("#bookIsbnTips").html(data);
							$("#bookIsbnTips").css("display","block");
							$("#buttonLable").css("display","block");
						}else{
							$("#bookIsbnTips").html(data);
							$("#bookIsbnTips").css("display","block");
							$("#buttonLable").css("display","none");
						}
					},
					"text"
				);
		}
	});
	$("#bookIsbn").focus(function(){
		$("#bookIsbnTips").html("");
		$("#bookIsbnTips").css("display","none");
		$("#buttonLable").css("display","none");
	});
	$("#return").click(function(){
		var bookIsbn=$("#bookIsbn").val();
		$.get(
				"http://localhost:8080/booksM/ReturnBookServlet?bookIsbn="+bookIsbn,
				function(data,status){
					alert(data);
					$("#buttonLable").css("display","none");
					$("#bookIsbn").val("");
					$("#bookIsbnTips").html("");
					$("#bookIsbnTips").css("display","none");
				},
				"text"
			);
	});
});