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
		var userId = $('input[name=userId]');
		var userPwd = $('input[name=userPwd]');
		
		$('.error').css({'color':'red'});
		$(userId).keyup(function(){
			if($(this).val().length == 0){
				$(this).next().show();
			} else {
				$(this).next().hide();
			}
		});
		$(userPwd).keyup(function(){
			if($(this).val().length == 0){
				$(this).next().show();
			} else {
				$(this).next().hide();
			}
		});
		
		$('#submit').click(function(event){
			if($(userId).val().length==0){
				event.preventDefault();
			}
			else if($(userPwd).val().length==0){
				event.preventDefault();
			}
			
			document.f.action+="/member/login.do";
		//	document.f.submit();
		});
		
	});
</script>
</head>
<body>
<h3>로그인</h3>
<form name="f" action="<%=request.getContextPath()%>" method="post">
<table border="2">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="userId">
			<span class="error">아이디필수</span>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="text" name="userPwd">
			<span class="error">비번필수</span>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input id="submit" type="submit" value="로그인하기" ></td>
	</tr>
</table>
</form>
</body>
</html>