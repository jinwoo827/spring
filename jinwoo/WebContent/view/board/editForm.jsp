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
			
			$.ajax({
				type:"POST",
				url: "/jinwoo/reply/insert.do?"+data,
				//data: data,
				success:function(data){
					console.log(data);
					var list = $.parseJSON(data);
					var str = "";
					$('#reply').html("");
					$.each(list, function(idx, obj) {					
						str += "<tr><td>"+obj.rWriter+"</td><td>"+obj.rTitle+"</td><td>"+obj.rContent+"</td><td>"+obj.rBoardnum+"</td><td><input class='replyDelbtn' type='button' value='����'><input type='hidden' name='rNum' value="+obj.rNum+"></td></tr>";
					});
					$('#reply').append(str);
				}
			});
		});
		
		$('.replyDelbtn').click(function(){
			alert("----------------");
			var rNum = $(this).next().val();
			console.log(rNum);
			$.ajax({
				type:"POST",
				url:"/jinwoo/reply/del.do?rNum="+rNum,
				success:function(data){
					var list = $.parseJSON(data);
					var str = "";
					$('#reply').html("");
					$.each(list, function(idx, obj) {					
						str += "<tr><td>"+obj.rWriter+"</td><td>"+obj.rTitle+"</td><td>"+obj.rContent+"</td><td>"+obj.rBoardnum+"</td><td><input class='replyDelbtn' type='button' value='����'><input type='hidden' name='rNum' value="+obj.rNum+"></td></tr>";
					});
					$('#reply').append(str);
				}		
						
			});
		});
	});
</script>
</head>
<body>
<h2>�ۼ���</h2>
<form method="post" action="${pageContext.request.contextPath }/board/update.do">
	<table border="2">
		<tr>
			<td>�۹�ȣ</td><td><input type="text" name="bNum" value="${data.board.bNum }" readonly></td>
		</tr>
		<tr>
			<td>���ۼ���</td><td><input type="text" name="bWriter" value="${data.board.bWriter }" readonly></td>
		</tr>
		<tr>
			<td>������</td><td><input type="text" name="bTitle" value="${data.board.bTitle }"></td>
		</tr>
		<tr>
			<td>�۳���</td><td><textarea rows="20" cols="20" name="bContents">${data.board.bContents }</textarea></td>
		</tr>
		<tr>
			<td>���ۼ���</td><td>${data.board.bDate }</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="�ۼ����ϱ�"></td>
		</tr>	
	</table>
</form>


<%-- ${data.replyList } --%>
<h3>���</h3>
<table border="2">
	
	<tr>
		<td>�ۼ���</td>
		<td>�������</td>
		<td>��۳���</td>
		<td>�Խ��ǹ�ȣ</td>
		<td>������ư</td>
	</tr>
	<tbody id="reply">

 <c:forEach var="list" items="${data.replyList }">
 	<tr>
		<td>${list.rWriter }</td><td>${list.rTitle }</td><td>${list.rContent }</td><td>${list.rBoardnum }</td>
		<td><input class="replyDelbtn" type="button" value="����"><input type="hidden" name="rNum" value="${list.rNum }"></td>
	</tr>
</c:forEach>
	</tbody>
	 
</table>
<hr>
<form method="post" name="f" action="${pageContext.request.contextPath }/reply/insert.do">
	<table border="1">
		<tr>
			<td>�ۼ���</td>
			<td>�������</td>
			<td>��۳���</td>
			<td>�Խ��ǹ�ȣ</td>
		</tr>
		<tr>
			<td><input type="text" name="rWriter" value="${sessionScope.id }" readonly></td>
			<td><input type="text" name="rTitle"></td>
			<td><textarea rows="10" cols="30" name="rContent"></textarea></td>
			<td><input type="text" name="rBoardnum" value="${data.board.bNum }" readonly></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input id="reply_btn" type="button" value="��۴ޱ�"></td>
		</tr>
	</table>
</form>

</body>
</html>