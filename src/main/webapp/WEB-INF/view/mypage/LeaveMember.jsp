<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.body {
	display: flex;
	margin-left: 10px;
	margin-top: 10px;
	padding: 20px;
	padding-bottom:50px;
	justify-content: center;
	align-items: center;
}
.leaveMem {
	margin-left: 50px;
}

</style>
<!DOCTYPE html>
<html>
<head>
<title>WARA PENSION :: 회원 탈퇴</title>
</head>
<body>
	<div class="w3-bar w3-white w3-small">
		<jsp:include page="../header/header.jsp" />
	</div>
	
	<jsp:include page="menu.jsp" />

	<div class="body">
		<div class="leaveMem">
			<p>탈퇴</p>
			<form:form action="3">
				<input type="submit" value="탈퇴" />
			</form:form>
		</div>
	</div>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
</html>