<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	/* 	var userId = $('input[name=userId]').val();
		var userPwd = $('input[name=userPwd]').val();
		var rePwd = $('input[name=rePwd]').val();
		var userMsg = $('input[name=userMsg]').val();
		var userType = $('input:radio[name=userType]:checked').val();
		console.log(userId);
		console.log(userPwd);
		console.log(rePwd);
		console.log(userMsg);
		console.log(userType); */
		
		$('#btn-c').click(function(){
			
			var userId = $('input[name=userId]').val();
			console.log(userId);
			$.ajax({
				type:"POST",
				url: "/jinwoo/member/checKId.do?userId="+userId,
			//	data:userId,
				success:function(data){
					$('#idCheck').text(data);
				}
			});
		});
		
	});
	 
</script>
</head>
<body>
<h3>ȸ������</h3>
<form name="f" action="${pageContext.request.contextPath }/member/join.do" method="post">
<table border="2">
	<tr>
		<td>���̵�</td><td><input type="text" name="userId">
			<input id="btn-c" type="button" value="�ߺ�Ȯ��" >
			<span id="idCheck"></span>
		</td>
	</tr>
	<tr>
		<td>��й�ȣ</td><td><input type="text" name="userPwd"></td>
	</tr>
	<tr>
		<td>��й�ȣȮ��</td><td><input type="text" name="rePwd"></td>
	</tr>
	<tr>
		<td>�̸�</td><td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>�����λ�</td><td><input type="text" name="userMsg"></td>
	</tr>
	<tr>
		<td>Ÿ��</td>
		<td><input type="radio" name="userType" value="0">������
			<input type="radio" name="userType" value="1">ȸ��
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�����ϱ�">
			<input type="reset" value="����ϱ�">
		</td>	
	</tr>
</table>
</form>
</body>
</html>