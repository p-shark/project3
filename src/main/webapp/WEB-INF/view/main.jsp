<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<html>
<title>WARA PENSION :: 메인</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

.searchBox input {
	margin-top: 10px;
}

.recommend:hover {
	opacity: 0.7;
}

button {
	border-radius: 10px;
	border: 1px solid #5392f9;
	background-color: #5392f9;
	color: #FFFFFF;
	font-size: 20px;
	font-weight: bold;
	padding: 12px 235px;
	letter-spacing: 1px;
	text-transform: uppercase;
	transition: transform 80ms ease-in;
	cursor: pointer;
}

button:active {
	transform: scale(0.95);
}

button:focus {
	outline: none;
}

</style>

<script>
	$('document')
			.ready(
					function() {
						var area0 = [ "시/도", "서울특별시 ", "인천광역시 ", "대전광역시 ",
								"광주광역시 ", "대구광역시 ", "울산광역시 ", "부산광역시 ", "경기도 ",
								"강원도 ", "충청북도 ", "충청남도 ", "전라북도 ", "전라남도 ",
								"경상북도 ", "경상남도 ", "제주도 " ];
						var area1 = [ "강남구", "강동구", "강북구", "강서구", "관악구", "광진구",
								"구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구",
								"마포구", "서대문구", "서초구", "성동구", "성북구", "송파구",
								"양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" ];
						var area2 = [ "계양구", "남구", "남동구", "동구", "부평구", "서구",
								"연수구", "중구", "강화군", "옹진군" ];
						var area3 = [ "대덕구", "동구", "서구", "유성구", "중구" ];
						var area4 = [ "광산구", "남구", "동구", "북구", "서구" ];
						var area5 = [ "남구", "달서구", "동구", "북구", "서구", "수성구",
								"중구", "달성군" ];
						var area6 = [ "남구", "동구", "북구", "중구", "울주군" ];
						var area7 = [ "강서구", "금정구", "남구", "동구", "동래구", "부산진구",
								"북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구",
								"중구", "해운대구", "기장군" ];
						var area8 = [ "고양시", "과천시", "광명시", "광주시", "구리시", "군포시",
								"김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시",
								"시흥시", "안산시", "안성시", "안양시", "양주시", "오산시",
								"용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시",
								"포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군" ];
						var area9 = [ "강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시",
								"태백시", "고성군", "양구군", "양양군", "영월군", "인제군",
								"정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군" ];
						var area10 = [ "제천시", "청주시", "충주시", "괴산군", "단양군",
								"보은군", "영동군", "옥천군", "음성군", "증평군", "진천군", "청원군" ];
						var area11 = [ "계룡시", "공주시", "논산시", "보령시", "서산시",
								"아산시", "천안시", "금산군", "당진군", "부여군", "서천군",
								"연기군", "예산군", "청양군", "태안군", "홍성군" ];
						var area12 = [ "군산시", "김제시", "남원시", "익산시", "전주시",
								"정읍시", "고창군", "무주군", "부안군", "순창군", "완주군",
								"임실군", "장수군", "진안군" ];
						var area13 = [ "광양시", "나주시", "목포시", "순천시", "여수시",
								"강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군",
								"보성군", "신안군", "영광군", "영암군", "완도군", "장성군",
								"장흥군", "진도군", "함평군", "해남군", "화순군" ];
						var area14 = [ "경산시", "경주시", "구미시", "김천시", "문경시",
								"상주시", "안동시", "영주시", "영천시", "포항시", "고령군",
								"군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군",
								"울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군" ];
						var area15 = [ "거제시", "김해시", "마산시", "밀양시", "사천시",
								"양산시", "진주시", "진해시", "창원시", "통영시", "거창군",
								"고성군", "남해군", "산청군", "의령군", "창녕군", "하동군",
								"함안군", "함양군", "합천군" ];
						var area16 = [ "서귀포시", "제주시", "남제주군", "북제주군" ];

						// 시/도 선택 박스 초기화
						$("select[name^=sido]").each(
										function() {
											$selsido = $(this);
											$
													.each(
															eval(area0),
															function() {
																$selsido
																		.append("<option value='"+this+"'>"
																				+ this
																				+ "</option>");
															});
											$selsido
													.next()
													.append(
															"<option value=''>구/군</option>");
										});

						// 시/도 선택시 구/군 설정
						$("select[name^=sido]")
								.change(
										function() {
											var area = "area"
													+ $("option", $(this))
															.index(
																	$(
																			"option:selected",
																			$(this))); // 선택지역의 구군 Array
											var $gugun = $(this).next(); // 선택영역 군구 객체
											$("option", $gugun).remove(); // 구군 초기화

											if (area == "area0")
												$gugun
														.append("<option value=''>구/군</option>");
											else {
												$
														.each(
																eval(area),
																function() {
																	$gugun
																			.append("<option value='"+this+"'>"
																					+ this
																					+ "</option>");
																});
											}
										});

					});
</script>

<body class="w3-light-grey">
	<!-- Navigation Bar -->
	<div class="w3-bar w3-white w3-Small">
		<jsp:include page="header/header.jsp" />
	</div>
	
	<!-- Main -->
	<div class="w3-display-container w3-content" style="max-width: 1500px;">
		<img class="w3-image" src="resources/images/main.png"
			alt="The Hotel"
			style="min-width: 1000px; width: 1500px; height: 850px; margin-top: 10px">
		<!-- Search -->
		<div class="w3-display-left w3-padding w3-col" style="top: 45%; width: 700px; opacity: 0.9;">
			<h1 style="text-align: center;">WARAPENSION</h1>
			<h3 style="text-align: center;">전국 200만 개 이상의 다양한 펜션을 베스트 요금으로 예약하세요!</h3>
			<div class="w3-container w3-padding-16 searchBox"
				style="height: 360px">
				<form action="searchPension" id="frm">
					<!-- Area -->
					<div class="w3-half w3-margin-bottom" style="display: flex; width: 630px">
						<select class="w3-input w3-border" name="sido1" id="sido1" style="margin-right: 5px; padding:15px;" required></select>
						<select class="w3-input w3-border" name="gugun1" id="gugun1" required></select>
					</div>

					<!-- Check In -->
					<div class="w3-row-padding" style="margin: 0 -16px">
						<div class="w3-half1 w3-margin-bottom" style="display: inline-block">
							<input class="w3-input w3-border" type="date" placeholder="DD MM YYYY"
								name="checkIn" style="width: 630px; padding:15px;" required>
						</div>
					</div>

					<!-- Stay_Count -->
					<div class="w3-half" style="width: 310px; margin-right: 5px">
						<input
							class="w3-input w3-border" type="number" placeholder="머무는 기간" 
							name="stay_count" style="padding:15px;" min="1" max="15" required>
					</div>

					<!-- Person -->
					<div class="w3-half w3-margin-bottom" style="width: 310px;">
						<input
							class="w3-input w3-border" type="number" placeholder="인원"  name="person"
							style="padding:15px;" min="1" max="6">
					</div>

					<!-- 테마 옵션 선택 -->
					<div style="margin-bottom: 15px; width: 630px; text-align: center;">
						<input type="checkbox" name="c_swim" value="swim" /> 수영장 
						<input type="checkbox" name="c_spa" value="spa" /> 스파 
						<input type="checkbox" name="c_mul" value="mul" /> 복층 
						<input type="checkbox" name="c_single" value="single" /> 독채 
						<input type="checkbox" name="c_view" value="view" /> 오션뷰/리버뷰 
						<input type="checkbox" name="c_bar_ter" value="bar_ter" /> 개별 바베큐 
						<input type="checkbox" name="c_bar_toge" value="bar_toge" /> 공동 바베큐 
						<input type="hidden" name="swim" /> 
						<input type="hidden" name="spa" />
						<input type="hidden" name="mul" /> 
						<input type="hidden" name="single" /> 
						<input type="hidden" name="view" /> 
						<input type="hidden" name="bar_ter" /> 
						<input type="hidden" name="bar_toge" />
					</div>
					<button type="submit" style="display:flex; width:98%; height:50px; align-items: center;">
						<i class="fa fa-search w3-margin-right"></i>조회하기
					</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="footer/footer.jsp" />
	</div>
</body>

<!-- Add Google Maps -->
<script>
	function myMap() {
		myCenter = new google.maps.LatLng(41.878114, -87.629798);
		var mapOptions = {
			center : myCenter,
			zoom : 12,
			scrollwheel : false,
			draggable : false,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapOptions);

		var marker = new google.maps.Marker({
			position : myCenter,
		});
		marker.setMap(map);
	}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>

<!-- 옵션 선택용 jQuery -->
<script>
	$(document).ready(function() {
		$('#btn1').click(function() {
			if ($('input[name=c_swim]').is(":checked")) {
				$('input[name=swim]').val('1');
			} else {
				$('input[name=swim]').val('0');
			}
			if ($('input[name=c_spa]').is(":checked")) {
				$('input[name=spa]').val('1');
			} else {
				$('input[name=spa]').val('0');
			}
			if ($('input[name=c_mul]').is(":checked")) {
				$('input[name=mul]').val('1');
			} else {
				$('input[name=mul]').val('0');
			}
			if ($('input[name=c_single]').is(":checked")) {
				$('input[name=single]').val('1');
			} else {
				$('input[name=single]').val('0');
			}
			if ($('input[name=c_view]').is(":checked")) {
				$('input[name=view]').val('1');
			} else {
				$('input[name=view]').val('0');
			}
			if ($('input[name=c_bar_ter]').is(":checked")) {
				$('input[name=bar_ter]').val('1');
			} else {
				$('input[name=bar_ter]').val('0');
			}
			if ($('input[name=c_bar_toge]').is(":checked")) {
				$('input[name=bar_toge]').val('1');
			} else {
				$('input[name=bar_toge]').val('0');
			}
		});
	});
</script>
</html>
