<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.modifyform {
	display: flex;
	margin-left: 10px;
	margin-top: 10px;
	padding: 20px;
	padding-bottom:50px;
	justify-content: center;
	align-items: center;
}
.content {
	margin-left: 50px;
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
	
	<div class="modifyform">
		<div class="content">
		<form:form action="3" modelAttribute="modifyCommand">
			<p>
				아이디:<br>
				${modi.id}
			</p>
			<p>
				비밀번호:<br>
				<form:password path="password" value="${modi.password}" />
				<form:errors path="password" />
			</p>
			<p>
				이름:<br>
				<form:input path="name" value="${modi.name}" />
				<form:errors path="name" />
			</p>
			<p>
				이메일:<br>
				<form:input path="email" value="${modi.email}" />
				<form:errors path="email" />
			</p>
			<p>
				전화번호:<br>
				<form:input path="phone" value="${modi.phone}" />
				<form:errors path="phone" />
			</p>
			<input type="submit" value="수정" />
		</form:form>
	</div>
	</div>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
	
</body>
</html>