<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
[
	<c:forEach var="r" items="${list }" varStatus="status">
	<c:if test="${!status.first }">,</c:if>

{	"rNum":"${list.rNum }",
	"rWriter":"${list.rWriter }",
	"rTitle":"${list.rTitle }",
	"rContent":"${list.rContent }",
	"rDate":"${list.rDate }",
	"rBoardnum":${list.rBoardnum}"
}
</c:forEach>

]