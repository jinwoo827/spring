<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.HashMap, java.util.ArrayList, board.Board, reply.Reply " %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#reply_btn').click(function(){
			var rWriter = f.rWriter.value;
			var rTitle = f.rTitle.value;
			var rContent = f.rContent.value;
			var rBoardnum = f.rBoardnum.value;
			
			var data = "rWriter="+rWriter+"&rTitle="+rTitle+"&rContent="+rContent+"&rBoardnum="+rBoardnum;
			alert(data);
			$.ajax({
				type:"POST",
				url: "/jinwoo/reply/insert.do?"+data,
				//data: data,
				success:function(data){
					alert(data);
					$('#reply').html(data);
				}
			});
		});
	});
</script>
</head>
<body>
<h2>글수정</h2>
<form method="post" action="${pageContext.request.contextPath }/board/update.do">
	<table border="2">
		<tr>
			<td>글번호</td><td><input type="text" name="bNum" value="${data.board.bNum }" readonly></td>
		</tr>
		<tr>
			<td>글작성자</td><td><input type="text" name="bWriter" value="${data.board.bWriter }" readonly></td>
		</tr>
		<tr>
			<td>글제목</td><td><input type="text" name="bTitle" value="${data.board.bTitle }"></td>
		</tr>
		<tr>
			<td>글내용</td><td><textarea rows="20" cols="20" name="bContents">${data.board.bContents }</textarea></td>
		</tr>
		<tr>
			<td>글작성일</td><td>${data.board.bDate }</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="글수정하기"></td>
		</tr>	
	</table>
</form>


<%-- ${data.replyList } --%>
<h3>댓글</h3>
<table border="2">
	<tr>
		<td>작성자</td>
		<td>댓글제목</td>
		<td>댓글내용</td>
		<td>게시판번호</td>
	</tr>
	

 <c:forEach var="list" items="${data.replyList }">
 	<tr>
		<td>${list.rWriter }</td><td>${list.rTitle }</td><td>${list.rContent }</td><td>${list.rBoardnum }</td>
	</tr>
</c:forEach> 
</table>
<hr>
<form method="post" name="f" action="${pageContext.request.contextPath }/reply/insert.do">
	<table border="1">
		<tr>
			<td>작성자</td>
			<td>댓글제목</td>
			<td>댓글내용</td>
			<td>게시판번호</td>
		</tr>
		<tr>
			<td><input type="text" name="rWriter" value="${sessionScope.id }" readonly></td>
			<td><input type="text" name="rTitle"></td>
			<td><textarea rows="10" cols="30" name="rContent"></textarea></td>
			<td><input type="text" name="rBoardnum" value="${data.board.bNum }" readonly></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input id="reply_btn" type="button" value="댓글달기"></td>
		</tr>
	</table>
</form>
<div id="reply"></div>
</body>
</html>