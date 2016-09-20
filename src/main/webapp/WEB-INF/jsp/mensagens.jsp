<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
<c:forEach var="error" items="${errors}">
	<m:validationMessage name="${error.category}"></m:validationMessage>
</c:forEach>
<c:if test="${not empty erro}">
	<m:exceptionMessage></m:exceptionMessage>
</c:if>
<c:if test="${not empty sucesso}">
	<m:sucessoMessage></m:sucessoMessage>
</c:if>