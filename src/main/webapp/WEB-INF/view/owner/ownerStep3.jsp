<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="member.register" /></title>
</head>
<body>
	<div class="w3-bar w3-white w3-Small">
		<jsp:include page="../header/header.jsp" />
	</div>
	<p>
		<spring:message code="register.done">
			<spring:argument value="${ownerRegisterRequest.owner_name}" />
			<spring:argument value="${ownerRegisterRequest.owner_email}" />
		</spring:message>
		<br>
		로그인 하려면 관리자의 승인을 받으셔야합니다
	</p>
	<p>
		<a href="<c:url value='/'/>"> [<spring:message code="go.main" />]
		</a>
	</p>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
</html>
