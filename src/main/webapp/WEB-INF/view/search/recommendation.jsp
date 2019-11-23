<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-bar w3-white w3-Small">
		<jsp:include page="../header/header.jsp" />
	</div>

	<!-- Page content -->
	<div class="w3-content" style="max-width: 1600px;">
		<div class="w3-row-padding w3-padding-16"
			style="margin-top: 100px; margin-bottom: 100px; text-align: center;">
			<h3>추천 여행지</h3>
			<div style="display: flex; justify-content: center;">
				<div class="recommend" id="jeju">
					<img id="Image-Maps-Com-image-maps-2019-10-17-024747"
						src="https://www.image-maps.com/m/private/0/ipnfd7hcm0rrl2ih67cea0omeq_jeju.jpg"
						border="0" width="400" height="300"
						usemap="#image-maps-2019-10-17-024747" alt="" />
					<map name="image-maps-2019-10-17-024747"
						id="ImageMapsCom-image-maps-2019-10-17-024747">
						<area alt="" title=""
							href="<c:url value="/recommend?recommend=제주"/>" shape="rect"
							coords="0,31,398,300" style="outline: none;" target="_self" />
						<area shape="rect" coords="398,298,400,300" alt="Image Map"
							style="outline: none;" title="Image Map"
							href="http://www.image-maps.com/index.php?aff=mapped_users_0" />
					</map>
				</div>
				<div class="recommend" id="jeonju">
					<img id="Image-Maps-Com-image-maps-2019-10-17-024930"
						src="https://www.image-maps.com/m/private/0/ipnfd7hcm0rrl2ih67cea0omeq_jeonju.jpg"
						border="0" width="400" height="300"
						usemap="#image-maps-2019-10-17-024930" alt="" />
					<map name="image-maps-2019-10-17-024930"
						id="ImageMapsCom-image-maps-2019-10-17-024930">
						<area alt="" title=""
							href="<c:url value="/recommend?recommend=전주"/>" shape="rect"
							coords="0,28,400,300" style="outline: none;" target="_self" />
						<area shape="rect" coords="398,298,400,300" alt="Image Map"
							style="outline: none;" title="Image Map"
							href="http://www.image-maps.com/index.php?aff=mapped_users_0" />
					</map>
				</div>
				<div class="recommend" id="gangneung">
					<img id="Image-Maps-Com-image-maps-2019-10-17-025042"
						src="https://www.image-maps.com/m/private/0/ipnfd7hcm0rrl2ih67cea0omeq_gangneung.jpg"
						border="0" width="400" height="300"
						usemap="#image-maps-2019-10-17-025042" alt="" />
					<map name="image-maps-2019-10-17-025042"
						id="ImageMapsCom-image-maps-2019-10-17-025042">
						<area alt="" title=""
							href="<c:url value="/recommend?recommend=강릉"/>" shape="rect"
							coords="0,31,400,300" style="outline: none;" target="_self" />
						<area shape="rect" coords="398,298,400,300" alt="Image Map"
							style="outline: none;" title="Image Map"
							href="http://www.image-maps.com/index.php?aff=mapped_users_0" />
					</map>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
</html>