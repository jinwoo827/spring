<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String str = (String)request.getAttribute("str");
	if(str == ""){
		out.print("사용가능합니다");
	} else {
		out.print(str+" 은 사용 불가능!!");
	}
%>