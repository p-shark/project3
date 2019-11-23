<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
div.wrap{
	width: 100%
}

div.testPic {
	width: 20%;
	height: 300px;
	margin: 5px;
	display: inline-block;
	position: relative;
	border-bottom: #e5e5e5 1px solid;
	overflow: hidden;
	cursor: pointer;
}

.fas {
	color: pink;
}

div#choices {
	width: 100%;
	min-height: 400px;
	border: 1px solid black;
	margin: 5px;
}
.testImg{
	width:100%;
	height: 200px;
	margin: 0;
	padding: 0;
	border: 0 none;
	display: inline-block;
}

a:link, a:visited, a:active {
    text-decoration: none;
    color: #000;
    line-height: 180%;
}

i{
	
}
</style>

</head>
<body>
	<div class="wrap">
		<div class="testPic" id="1">
			<img class="testImg" src="resources/images/hotel.jpg">
			<i class="far fa-heart"></i>
		</div>
		<div class="testPic" id="2">
			<img class="testImg" src="resources/images/hotel.jpg">
			<i class="far fa-heart"></i> 
		</div>
		<div class="testPic" id="3">
			<img class="testImg" src="resources/images/hotel.jpg"> 
			<i class="far fa-heart"></i>
		</div>
		<div class="testPic" id="4">
			<img class="testImg" src="resources/images/hotel.jpg"> 
			<i class="far fa-heart"></i>
		</div>
	</div>

	<div>
		<button type="button" id="compare">찜 목록 비교</button>
	</div>

	<div id="choices"></div>



</body>
<script>
	$('i').click(function() {
		var clicks = $(this).data('clicks');
		if (clicks) {
			$(this).removeClass("fas").addClass("far");
		} else {
			$(this).removeClass("far").addClass("fas");

		}
		$(this).data("clicks", !clicks);
	});

	$(function() {
		$('#compare').click(function() {
			var choices = [];

			$('i.fas').each(function() {
				choices.push($(this).parent().attr('id'));
			});

			var params = {
				"pen_nos" : choices
			};
			console.log(params);
			var url = "test/choices";
			$.ajax({
				type : "post",
				url : url,
				dataType : 'json',
				data : JSON.stringify(params),
				contentType : 'application/json; charset=utf8',
				success : function(data) {
					//console.log(data);
					showChoices(data);
				},
				fail : function(err) {
					console.log(err);
				}
			});

		});
	});

	var showChoices = function(data) {
		console.log(data);
		for (var i = 0; i < data.length; i++) {
			var pen_id = data[i].pen_id;
			var div_pension = $("<div></div>").addClass('pension'+i);
			$('#choices').append(div_pension);
			$('.pension'+i).append("<h3>" + data[i].name + "</h3>");
			//alert(data[i].name);
			$('.pension'+i).append("<p>" + data[i].address + "</p>");
			$('.pension'+i).append("<p>" + data[i].area + "</p>");
			$('.pension'+i).append("<p>" + data[i].info + "</p>");
			$('.pension'+i).append("<p>" + data[i].phone + "</p>");
			$('.pension'+i).append("<p>" + data[i].pickup + "</p>");
			var button_detail = $("<button>자세히 보기</button>").addClass('detail').attr("id",pen_id);
			$('.pension'+i).append(button_detail);
			
			
		}
		$(document).ready(function(){
	          $(document).on("click",".detail",function(event){
	            // 동적으로 여러 태그가 생성된 경우라면 이런식으로 클릭된 객체를 this 키워드를 이용해서 잡아올 수 있다.
	            var pen_id = $(this).attr("id");
	            location.href = "${pageContext.request.contextPath}/searchPension/pensionInfo?pen_id="+ pen_id;
	          });
	      });


		
			
		}
		
	
</script>


</html>