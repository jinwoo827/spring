<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String str = (String)request.getAttribute("str");
	if(str == ""){
		out.print("��밡���մϴ�");
	} else {
		out.print(str+" �� ��� �Ұ���!!");
	}
%>