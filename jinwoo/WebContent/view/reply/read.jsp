<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
[<c:forEach var="list" items="${list }" varStatus="status"><c:if test="${!status.first }">,</c:if>{"rNum":"${list.rNum }","rWriter":"${list.rWriter }","rTitle":"${list.rTitle }","rContent":"${list.rContent }",
"rDate":"${list.rDate }","rBoardnum":"${list.rBoardnum}"}</c:forEach>]
