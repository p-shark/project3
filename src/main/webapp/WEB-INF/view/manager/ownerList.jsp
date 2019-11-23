<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<style>

body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

.body {
	display: flex;
	margin-left: 10px;
	margin-top: 10px;
	padding: 20px;
	padding-bottom: 198px;
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- Header -->
	<div class="w3-bar w3-white w3-Small">
		<jsp:include page="../header/header.jsp" />
	</div>
	
	<h1>펜션주 정보</h1>
	<div class="body">
		<div class="content">
			<c:if test="${! empty owners}">
				<table>
					<tr>
						<th>아이디</th>
						<th>이메일</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>내용</th>
						<th>승인여부</th>
					</tr>
					<c:forEach var="owner" items="${owners}">
						<tr>
							<td>${owner.owner_id}</td>
							<td>${owner.owner_email}</td>
							<td>${owner.owner_name}</td>
							<td>${owner.owner_phone}</td>
							<td>${owner.owner_content}</td>
							<td>
								<c:if test="${! owner.logincheck}">
									<input type="button" onclick="loginCheck(${owner.owner_no})"
										value="승인" />
								</c:if> <c:if test="${owner.logincheck}">승인</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
	
	<!-- Modal content -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<p>승인 처리하시겠습니까?</p>
			<span class="close"><a id="modal_a" class="approval">승인 확정 </a></span> <span class="close">
				미승인 유지</span>
		</div>
	</div>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>

	<script type="text/javascript">
		var modal = document.getElementById("myModal");
		var modal_a = document.getElementById("modal_a");
		var approval = document.getElementsByClassName("approval");
		var close = document.getElementsByClassName("close");
		
		function loginCheck(owner_no) {
			modal.style.display = "block";
			modal_a.setAttribute("href", "approval?owner_no="+owner_no);
		}

		approval.onclick = function() {
			modal.style.display = "none";
		}

		approval.onclick = function() {
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