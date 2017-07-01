<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>글작성</h2>
<form action="<%=request.getContextPath() %>/board/insert.do" method="post">
	<table border="2">
		<tr>
			<td>작성자</td><td><input type="text" name="bWriter" value="${sessionScope.id }" readonly></td>
		</tr>
		<tr>
			<td>글제목</td><td><input type="text" name="bTitle"></td>
		</tr>
		<tr>
			<td>글내용</td><td><textarea rows="20" cols="20" name="bContents"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="글작성"></td>
		</tr>
	</table>
</form>
</body>
</html>