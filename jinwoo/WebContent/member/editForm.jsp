<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>회원정보수정</h3>
<form action="${pageContext.request.contextPath }/member/edit.do" method="post">
<table border="2">
	<tr>
		<td>아이디</td><td><input type="text" name="userId" value="${requestScope.m.userId }" readonly></td>
	</tr>
	<tr>
		<th>비밀번호</th><td><input type="text" name="userPwd" value="${m.userPwd }"></td>
	</tr>
	<tr>
		<td>이름</td><td><input type="text" name="userName" value="${m.userName }" readonly></td>
	</tr>
	<tr>
		<td>가입인사</td><td><input type="text" name="userMsg" value="${m.userMsg }"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="정보수정"></td>
	</tr>
</table>
</form>

</body>
</html>