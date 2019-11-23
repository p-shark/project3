<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.body {
	display: flex;
	margin-left: 10px;
	margin-top: 10px;
	padding: 20px;
	padding-bottom: 270px;
	justify-content: center;
	align-items: center;
}

h1 {
	padding-top: 20px;
  	text-align: center;
}

table {
	text-align: center;
	width: 1000px;
}

tr {
  padding-bottom: 10px;
}

td {
  padding: 5;
  text-align: center;
  background-color: #e6e6e6;
}

th {
  background-color: #202932;
  color: #fff;
  padding: 7;
}

tr:nth-child(2n+2) td {
    background-color: #cccccc;
  }

input[type=button] {
	background-color: #5392f9;
  	border: none;
 	color: white;
 	text-decoration: none;
  	cursor: pointer;
  	border-radius: 5px;
}

.content {
	margin-left: 50px;
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="w3-bar w3-white w3-Small">
		<jsp:include page="../header/header.jsp" />
	</div>

	<h1>내 펜션 예약 정보</h1>
	<div class="body">
		<div class="content">
			<c:if test="${! empty books}">
				<table>
					<tr>
						<th>예약날짜</th>
						<th>체크인</th>
						<th>체크아웃</th>
						<th>머물 기간</th>
						<th>인원수</th>
						<th>방 이름</th>
						<th>펜션 이름</th>
					</tr>
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.book_date}</td>
							<td>${book.check_in}</td>
							<td>${book.check_out}</td>
							<td>${book.stay_count}</td>
							<td>${book.room_amount}</td>
							<td>${book.room_name}</td>
							<td>${book.pen_name}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>

	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>

</body>
</html>