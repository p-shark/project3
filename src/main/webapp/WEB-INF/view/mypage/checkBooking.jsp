<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,800"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">


<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

.body {
	display: flex;
	margin-left: 10px;
	margin-top: 10px;
	padding: 20px;
	padding-bottom: 180px;
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


/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
	height: 22%;
}

.cancel {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
	margin-right: 10px;
	margin-left: 10px;
	text-decoration: none;
}

.cancel:hover, .cancel:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
	margin-right: 10px;
	margin-left: 10px;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>WARA PENSION :: 예약 확인</title>
</head>
<body>
	<div class="w3-bar w3-white w3-small">
		<jsp:include page="../header/header.jsp" />
	</div>
	
	<!-- mypage menu -->
	<jsp:include page="menu.jsp" />
	
	<div class="body">
		<div class="content">
			<c:if test="${! empty bookList}">
				<h1>나의 예약 관리</h1>
				<table>
					<tr>
						<th>예약 번호</th>
						<th>예약 날짜</th>
						<th>체크인</th>
						<th>체크아웃</th>
						<th>머물 기간</th>
						<th>인원수</th>
						<th>방 이름</th>
						<th>펜션 이름</th>
						<th>취소</th>
					</tr>
					<c:forEach var="bookListCommand" items="${bookList}">
						<tr>
							<td>${bookListCommand.book_no}</td>
							<td>${bookListCommand.book_date}</td>
							<td>${bookListCommand.check_in}</td>
							<td>${bookListCommand.check_out}</td>
							<td>${bookListCommand.stay_count}</td>
							<td>${bookListCommand.room_amount}</td>
							<td>${bookListCommand.room_name}</td>
							<td>${bookListCommand.pen_name}</td>
							<td><c:if test="${bookListCommand.book_checks}">
									<input type="button" onclick="bookcancel(${bookListCommand.book_no})" value="취소" />
								</c:if> <c:if test="${! bookListCommand.book_checks}">예약취소</c:if></td>
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
	
	<!-- Modal content -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<p>예약을 취소하시겠습니까?</p>
			<a id="modal_a" class="cancel">취소 확정 </a> <span class="close">
				예약 유지</span>
		</div>
	</div>

	<script type="text/javascript">
		var modal = document.getElementById("myModal");
		var modal_a = document.getElementById("modal_a");
		var cancel = document.getElementsByClassName("cancel");
		var close = document.getElementsByClassName("close");
		
		function bookcancel(bookno) {
			modal.style.display = "block";
			modal_a.setAttribute("href", "cancel?book_no="+bookno);
		}

		cancel.onclick = function() {
			modal.style.display = "none";
		}

		close.onclick = function() {
			modal.style.display = "none";
			href.location = "";
		}

		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>