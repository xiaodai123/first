<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/xiangmu.js"></script>

</head>
<SCRIPT language=JavaScript>

function link(){
	var turnPage=document.getElementById("goText").value;
	var number=/^[\d]{0,14}$/;
	if(!number.test(turnPage)){
		alert("请正确输入");
	}else{
		window.location.href="/booksM/BookServlet?flag=list&sign=3&pageNow="+turnPage;
	}
	
}
function del(){
	if(confirm("确定要删除吗？")){
		return true;
	}else{
		return false;
	}
}

function check(){
	var bookIsbn=$("#bookIsbn").val();
	var bookName=$("#bookName").val();
	var bookAuthor=$("#bookAuthor").val();
	var bookPublish=$("#bookPublish").val();
	if(!bookIsbn && !bookName && !bookAuthor && !bookPublish){
		alert("书号、书名、作者、出版社，至少填写一个信息，查询条件不能全为空。");
		return false;
	}
}
</SCRIPT>

<body>

<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="<%=basePath%>/image/nav04.gif">
          <form name="fom" id="fom" method="post" onsubmit="return check();" action="/booksM/BookServlet">
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="<%=basePath%>/image/ico07.gif" width="20" height="18" /></td>
			<td width="600">
	
			
			查看内容：按书号：
              <input name="bookIsbn" id="bookIsbn" type="text" size="12"/>&nbsp;
			 按书名：
			 <input name="bookName" id="bookName" type="text" size="12"/>
			 <input name="pageNow" type="hidden" value="1"/>
			 <input name="sign" id="sign" value="1" type="hidden">
			 <input name="flag" id="flag" value="list" type="hidden">
			 &nbsp;
			 按作者：
			<input name="bookAuthor" id="bookAuthor" type="text" size="12"/>
			 &nbsp;
			  按出版社：
			<input name="bookPublish" id="bookPublish" type="text" size="12"/>
			 &nbsp;
			 </td>
			 <td width="82" align="left">&nbsp;
			 <input name="Submit" type="submit" class="right-button02" value="查 询" style="cursor: pointer;"/></td>	
		  </tr>
		  
        </table>
        </form>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20">
	              
	              <input name="Submit2" type="button" class="right-button08" value="添加图书" style="cursor: pointer;" onclick="window.location.href='/booksM/view/addBook.jsp'"/>
	              <span style="color:red;">${requestScope.msg }</span> </td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 图书信息列表 &nbsp;</td>
                    </tr>
                  <tr>
                    <td width="14%" height="20" align="center" bgcolor="#EEEEEE">书号</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">书名</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">作者</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">出版社</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">定价</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">借阅状态</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${requestScope.books }" var="book">
                  	<tr align="center">
                    		<td height="20" bgcolor="#FFFFFF"><a href="/booksM/BookServlet?flag=one&bookId=${book.bookId } ">${book.bookIsbn } </a></td>
                    		<td bgcolor="#FFFFFF">${book.bookName } </td>
                    		<td bgcolor="#FFFFFF">${book.bookAuthor } </td>
                    		<td bgcolor="#FFFFFF">${book.bookPublish } </td>
                    		<td bgcolor="#FFFFFF">${book.bookMoney }元 </td>
                    		<td bgcolor="#FFFFFF">
                    		<c:if test="${book.bookStatus }">借出</c:if>
                    		<c:if test="${!book.bookStatus }">未借出</c:if>
                    		 </td>
                    		<td bgcolor="#FFFFFF"><a href="/booksM/DelBookServlet?bookId=${book.bookId }" onclick="return del();">删除</a>
                    		|<a href="/booksM/BookServlet?flag=one&bookId=${book.bookId } ">编辑</a>
                    		</td>
                  		</tr>
                  </c:forEach>
                  
                   
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="<%=basePath%>/image/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
          
          <c:if test="${requestScope.pageNum>1 }">
          	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">${requestScope.pageNum } </span> 页 | 第 <span class="right-text09">${requestScope.pageNow }</span> 页</td>
                <td width="49%" align="right">
               [<a href="/booksM/BookServlet?flag=list&sign=3&pageNow=1" class="right-font08">首页</a>
               		
               			<c:if test="${requestScope.pageNow==1 }">
               				| <a href="/booksM/BookServlet?flag=list&sign=3&pageNow=${requestScope.pageNow+1 }" class="right-font08">下一页</a>
               			</c:if>
               			<c:if test="${requestScope.pageNow==requestScope.pageNum }">
               				| <a href="/booksM/BookServlet?flag=list&sign=3&pageNow=${requestScope.pageNow-1 }" class="right-font08">上一页</a> 
               			</c:if>
               			<c:if test="${requestScope.pageNow>1&&requestScope.pageNow<requestScope.pageNum }">
               				| <a href="/booksM/BookServlet?flag=list&sign=3&pageNow=${requestScope.pageNow-1 }" class="right-font08">上一页</a> 
                			| <a href="/booksM/BookServlet?flag=list&sign=3&pageNow=${requestScope.pageNow+1 }" class="right-font08">下一页</a>
               			</c:if>
               		
                	
                
                 
                	| <a href="/booksM/BookServlet?flag=list&sign=3&pageNow=${requestScope.pageNum }" class="right-font08">末页</a>]
                 
                	转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" id="goText" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="button" id="go" value="GO" onclick="link()" style="cursor: pointer;" class="right-button06"/>
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table>
          	
         </c:if> 
          
          
          
          </td>
        </tr>
      </table></td>
  </tr>
</table>


</body>
</html>