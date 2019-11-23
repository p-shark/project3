<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<!DOCTYPE html>
<html>

<head>
<title>WARA PENSION :: ${recommend} 추천 펜션</title>
</head>
<body>
	<div class="w3-bar w3-white w3-Small">
		<jsp:include page="../header/header.jsp" />
	</div>
	
	<h1>${recommend} 추천 펜션</h1>
	<div class="searchResult">
			<table>
				<tr>
					<td><b>펜션명</b></td>
					<td><b>펜션 위치</b></td>
					<td><b>문의번호</b></td>
					<td><b>입/퇴실 안내</b></td>
					<td><b>픽업 여부</b></td>
				</tr>
				<c:forEach var="result" items="${searchResults}">
					<tr>
						<td><a href="<c:url value="/searchPension/pensionInfo?pen_id=" />${result.pen_id}">${result.name}</a></td>
						<td>${result.address}</td>
						<td>${result.phone}</td>
						<td>${result.info}</td>
						<c:if test="${result.pickup}">
							<td>가능</td>
						</c:if>
						<c:if test="${!result.pickup}">
							<td>불가능</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
</html>