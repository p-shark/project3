<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<style>
.body {
	display: flex;
	margin-left: 10px;
	margin-top: 10px;
	padding: 20px;
	padding-bottom:50px;
	justify-content: center;
	align-items: center;
}
</style>
<!DOCTYPE html>
<html>
<head>
<title>WARA PENSION :: 회원 수정</title>

</head>
<body>
	<div class="w3-bar w3-white w3-small">
		<jsp:include page="../header/header.jsp" />
	</div>

	<jsp:include page="menu.jsp" />
	
	<div class="body">
		<div class="checkPW">
			<p>비밀번호를 입력하세요.</p>
			<form:form action="2" modelAttribute="checkPasswordCommand"
				method="post">
				<form:input path="currentPassword" />
				<form:errors path="currentPassword" />
				<input type="submit" value="제출" />
			</form:form>
		</div>
	</div>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
</html>