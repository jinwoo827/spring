<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/board/writerForm.do">글쓰기</a>
<h3>글목록</h3>
<table border="2">
	<tr>
		<td>글번호</td><td>작성자</td><td>글제목</td><td>작성일</td>
	<tr>
	<c:forEach var="map" items="${requestScope.mapList }">
	<tr>
		<td>${map.bList.bNum }</td><td>${map.bList.bWriter }</td>
		<td>
		<a href="${pageContext.request.contextPath }/board/editForm.do?bNum=${map.bList.bNum">${map.bList.bTitle }</a>
		</td>
		<td>${map.bList.bDate }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>