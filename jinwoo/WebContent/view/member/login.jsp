<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>${sessionScope.id } �� ȯ���մϴ�</h3>
<a href="${pageContext.request.contextPath }/member/editForm.do">����������</a>
<a href="${pageContext.request.contextPath }/member/logout.do">�α׾ƿ�</a>
<a href="${pageContext.request.contextPath }/member/del.do">Ż��</a>
<a href="${pageContext.request.contextPath }/board/list.do">�Խù�����</a>
</body>
</html>