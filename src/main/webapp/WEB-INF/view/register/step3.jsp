<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<!DOCTYPE html>
<html>
<head>
<title>WARA PENSION :: 회원가입</title>
<div class="w3-bar w3-white w3-large">
	<jsp:include page="../header/header.jsp" />
</div>
</head>
<body>
	<p>
		<spring:message code="register.done">
			<spring:argument value="${registerRequest.name}" />
			<spring:argument value="${registerRequest.email}" />
		</spring:message>
	</p>
	<p>
		<a href="<c:url value='/'/>"> [<spring:message code="go.main" />]
		</a>
	</p>
</body>
</html>
