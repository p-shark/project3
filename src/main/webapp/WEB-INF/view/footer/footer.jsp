<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.footer-div {
	margin-top: 25px;
}

.footer-a {
	text-decoration: none;
	color: mediumblue;
	margin-right: 5px;
}

.footer-i {
	margin-left: 5px;
}

h3 {
	margin-top: 10px;
}

p {
	margin-top: 2px;
	margin-bottom: 2px;
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Footer -->
	<footer class="w3-padding-16 w3-center">
		<h3>WARAPENSION</h3>
		<p>All material herein © 2019 – WaraPension Company Pte. Ltd., All Rights Reserved.</p>
		<p>와라펜션은 온라인 여행 및 관련 서비스 분야의 세계적인 선도 기업입니다.</p>
		<div class="footer-div">
			<a class="footer-a" href="owner/ownerStep1">가맹점 신청</a>
			<a class="footer-a" href="<c:url value="/manager" />">관리자로그인</a>
		</div>
	</footer>

</body>
</html>