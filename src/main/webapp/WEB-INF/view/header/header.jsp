<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
.headerMain{
	font-family: 'Montserrat', sans-serif;
	font-size: 1.5em;
	font-weight: 700;
	
}

.slide {
  background: linear-gradient(to right, #FF4B2B, #FF416C);
  transition: 0.25s;
  padding: 1em 2em;
  text-decoration: none;
  color: #fff;
}

.bar{
	padding: 10px 7px;
	float: left;
	width: auto;
	border: none;
	display: block;
	outline: 0;
}

.bar-left{
	padding: 13px 7px;
	float: left;
	width: auto;
	border: none;
	display: block;
	outline: 0;
	text-decoration: none;
	white-space: normal;
	border: none;
	color: inherit;
	background-color: inherit;
	cursor: pointer;
}

</style>
<!DOCTYPE html>
<html>
<head>
<title>header</title>
</head>
<body>
	<a href="<c:url value="/" />" class="bar w3-mobile headerMain slide">WARAPENSION</a>
	<a class="bar-left w3-mobile" href="<c:url value="#" />">입점안내</a>
	<a class="bar-left w3-mobile" href="<c:url value="/recommendation" />">추천여행지</a>
	<c:if test="${empty authInfo}">
	<a class="bar-left w3-right w3-mobile" href="<c:url value="/owner" />">가맹점 로그인</a>
	<a class="bar-left w3-right w3-mobile" href="<c:url value="/register/step1" />">회원가입</a>
    <a class="bar-left w3-right w3-mobile" href="<c:url value="/login" />">로그인</a>
    
    </c:if>
    
    <c:if test="${! empty authInfo}">
    	<c:if test="${authInfo.cate_id eq 1}">
    	<a class="bar-left w3-right" href="<c:url value="/mypage/checkBooking" />">마이페이지</a>
    	<a class="bar-left w3-right" href="<c:url value="/logout" />">로그아웃</a>
    	</c:if>
    	<c:if test="${authInfo.cate_id eq 2}">
    	<a class="bar-left w3-right" href="<c:url value="/ownerPage/confirmBooking" />">예약관리</a>
    	<a class="bar-left w3-right" href="<c:url value="/ownerPage" />">펜션주페이지</a>
    	<a class="bar-left w3-right" href="<c:url value="/logout" />">로그아웃</a>
    	</c:if>
    	<c:if test="${authInfo.cate_id eq 3}">
    	<a class="bar-left w3-right" href="<c:url value="/managerPage/ownerList" />">가맹점관리</a>
    	<a class="bar-left w3-right" href="<c:url value="/managerPage" />">매니저페이지</a>
    	<a class="bar-left w3-right" href="<c:url value="/logout" />">로그아웃</a>
    	</c:if>
    </c:if>
    
</body>
</html>