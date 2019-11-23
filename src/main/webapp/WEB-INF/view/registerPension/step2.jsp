<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<head>
<script>
$(document).ready (function () {    
	var i = 0;
	$('#fileForm').append (
			'<div class="regForm" id="target" style="padding: 0px; text-align: center"><table class="regTable"><tbody><tr><th>방 이름</th><td><input type="text" name="name['+i+']" required/></td></tr><tr><th>최대 인원수</th><td><input type="number" name="amount['+i+']" required/></td></tr><tr><th>방 크기</th><td><input type="number" name="size['+i+']" required/></td></tr><tr><th>비수기 주중 가격</th><td><input type="number" name="nopeak_week['+i+']" required/></td></tr><tr><th>비수기 주말 가격</th><td><input type="number" name="nopeak_weekend['+i+']" required/></td></tr><tr><th>성수기 주중 가격</th><td><input type="number" name="peak_week['+i+']" required/></td></tr><tr><th>성수기 주말 가격</th><td><input type="number" name="peak_weekend['+i+']" required/></td></tr><tr><th>시설 선택</th><td><input type="checkbox" id="c_swim['+i+']" /> 수영장 <input type="checkbox" id="c_spa['+i+']" /> 스파 <input type="checkbox" id="c_mul['+i+']" /> 복층 <input type="checkbox" id="c_single['+i+']" /> 독채 <input type="checkbox" id="c_view['+i+']"/> 오션뷰/리버뷰 <input type="checkbox" id="c_bar_ter['+i+']" /> 개별 바베큐 <input type="checkbox" id="c_bar_toge['+i+']" /> 공동 바베큐 <input type="hidden" name="cswim['+i+']" /> <input type="hidden" name="cspa['+i+']" /><input type="hidden" name="cmul['+i+']" /> <input type="hidden" name="csingle['+i+']" /> <input type="hidden" name="cview['+i+']" /> <input type="hidden" name="cbar_ter['+i+']" /> <input type="hidden" name="cbar_toge['+i+']" /></td></tr><tr><th>방 사진</th><td><input type="file" name="files['+i+']" multiple="multiple" required></td></tr></tbody></table><hr/></div>'   
	);
    $('.btnAdd').click (function () {
    	i++;
        $('#fileForm').append (
            '<div class="regForm" id="target" style="padding: 0px; text-align: center"><table class="regTable"><tbody><tr><th>방 이름</th><td><input type="text" name="name['+i+']" required/></td></tr><tr><th>최대 인원수</th><td><input type="number" name="amount['+i+']" required/></td></tr><tr><th>방 크기</th><td><input type="number" name="size['+i+']" required/></td></tr><tr><th>비수기 주중 가격</th><td><input type="number" name="nopeak_week['+i+']" required/></td></tr><tr><th>비수기 주말 가격</th><td><input type="number" name="nopeak_weekend['+i+']" required/></td></tr><tr><th>성수기 주중 가격</th><td><input type="number" name="peak_week['+i+']" required/></td></tr><tr><th>성수기 주말 가격</th><td><input type="number" name="peak_weekend['+i+']" required/></td></tr><tr><th>시설 선택</th><td><input type="checkbox" id="c_swim['+i+']" /> 수영장 <input type="checkbox" id="c_spa['+i+']" /> 스파 <input type="checkbox" id="c_mul['+i+']" /> 복층 <input type="checkbox" id="c_single['+i+']" /> 독채 <input type="checkbox" id="c_view['+i+']"/> 오션뷰/리버뷰 <input type="checkbox" id="c_bar_ter['+i+']" /> 개별 바베큐 <input type="checkbox" id="c_bar_toge['+i+']" /> 공동 바베큐 <input type="hidden" name="swim['+i+']" /> <input type="hidden" name="spa['+i+']" /><input type="hidden" name="mul['+i+']" /> <input type="hidden" name="single['+i+']" /> <input type="hidden" name="view['+i+']" /> <input type="hidden" name="bar_ter['+i+']" /> <input type="hidden" name="bar_toge['+i+']" /></td></tr><tr><th>방 사진</th><td><input type="file" name="files['+i+']" multiple="multiple" required></td></tr></tbody></table><input type="button" class="btnRemove" value="Remove"><hr/></div>'                    
        ); // end append                            
        $('.btnRemove').on('click', function () { 
            $(this).prev().remove (); // remove the textbox
            $(this).next ().remove (); // remove the <br>
            $(this).remove (); // remove the button
        });
    }); // end click
}); // end ready
</script>
<style>
.btnRemove {
	margin-top: 20px;
	margin-bottom: 10px;
}
.regForm {
	padding-top: 100px;
}

table.regTable {
	margin:auto;
	width: 80%;
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
}

table.regTable thead th {
	padding: 0 20px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.regTable tbody th {
	width: 20%;
	text-align: center;
	padding: 20px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #f3f6f7;
}

table.regTable td {
	width: 350px;
	padding: 10px;
	vertical-align:middle;
	border-bottom: 1px solid #ccc;
}

table.regTable tr td input option select{
	height: 35px;
	width: 300px;
}

input[type=submit] {
	background-color: #5392f9;
	border: none;
	color: white;
	padding: 20px 215px;
	text-decoration: none;
	margin: 24px 0;
	cursor: pointer;
	border-radius: 5px;
	font-size: 15px;
}

.btnAdd {
	background-color: #5392f9;
	border: none;
	color: white;
	padding: 20px 215px;
	text-decoration: none;
	margin: 24px 0;
	cursor: pointer;
	border-radius: 5px;
	font-size: 15px;
}

div.regForm {
	padding-left: 35%;
	width: 70%;
	margin: auto;
}

input {
	padding-left: 5px;
	font-size: 13px;
}
#fileForm {
	text-align: center;
}

#target {
	margin-bottom: 50px;
}
#btn2 {
text-align: center;
}
</style>
<title>WARA PENSION :: </title>
</head>
<body>
	<div class="w3-bar w3-white w3-small">
		<jsp:include page="../header/header.jsp" />
	</div>
	
	<div class="buttons">
		<form id="fileForm" action="step3" method="get" enctype="multipart/form-data" >
			<input type="button" class="btnAdd" value="방 추가"> 
			<input id="btn1" type="submit" value="다음 단계">
			<input type="hidden" name="pen_no" value="${pen_no}">
 		</form>
	</div>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
<!-- 옵션 선택용 jQuery -->
<script>
	$(document).ready(function() {
		$('#btn1').click(function() {
			if ($('input[id=c_swim[0]]').is(":checked")) {
				$('input[name=cswim[0]]').val('1');
			} else {
				$('input[name=cswim[0]]').val('0');
			}
			if ($('input[id=c_spa[0]]').is(":checked")) {
				$('input[name=cspa[0]]').val('1');
			} else {
				$('input[name=cspa[0]]').val('0');
			}
			if ($('input[id=c_mul[0]]').is(":checked")) {
				$('input[name=cmul[0]]').val('1');
			} else {
				$('input[name=cmul[0]]').val('0');
			}
			if ($('input[id=c_single[0]]').is(":checked")) {
				$('input[name=csingle[0]]').val('1');
			} else {
				$('input[name=csingle[0]]').val('0');
			}
			if ($('input[id=c_view[0]]').is(":checked")) {
				$('input[name=cview[0]]').val('1');
			} else {
				$('input[name=cview[0]]').val('0');
			}
			if ($('input[id=c_bar_ter[0]]').is(":checked")) {
				$('input[name=cbar_ter[0]]').val('1');
			} else {
				$('input[name=cbar_ter[0]]').val('0');
			}
			if ($('input[id=c_bar_toge[0]]').is(":checked")) {
				$('input[name=cbar_toge[0]]').val('1');
			} else {
				$('input[name=cbar_toge[0]]').val('0');
			}
		});
	});
</script>
</html>
