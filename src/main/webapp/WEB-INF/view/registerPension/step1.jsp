<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<style>
.regForm {
	margin-top: 30px;
}

table.regTable {
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
	text-align: center;
	width: 400px;
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

div.regForm {
	display: inline-block;
	padding-left: 35%;
}

input {
	padding-left: 5px;
	font-size: 13px;
}
</style>
<head>
<title>WARA PENSION :: 펜션 등록</title>
<script type="text/javascript">
function itemChange(){
	var day31 = ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"];
	var day30 = ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"];
	var day28 = ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"];
	var selectItem = $("#select1").val();
	var changeItem;
	if(selectItem == "1" ||selectItem == "3" ||selectItem == "5" ||selectItem == "7" ||selectItem == "8" ||selectItem == "10" ||selectItem == "12"){
	  changeItem = day31;
	}
	else if(selectItem == "4" ||selectItem == "6" ||selectItem == "9" ||selectItem == "11"){
	  changeItem = day30;
	}
	else if(selectItem == "2"){
	  changeItem = day28;
	}
	$('#select2').empty();
	for(var count = 0; count < changeItem.length; count++){                
			var option = $("<option>"+changeItem[count]+"</option>");
			$('#select2').append(option);
	}
}

function itemChange2(){
	var day31 = ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"];
	var day30 = ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"];
	var day28 = ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"];
	var selectItem = $("#select3").val();
	var changeItem;
	if(selectItem == "1" ||selectItem == "3" ||selectItem == "5" ||selectItem == "7" ||selectItem == "8" ||selectItem == "10" ||selectItem == "12"){
	  changeItem = day31;
	}
	else if(selectItem == "4" ||selectItem == "6" ||selectItem == "9" ||selectItem == "11"){
	  changeItem = day30;
	}
	else if(selectItem == "2"){
	  changeItem = day28;
	}
	$('#select4').empty();
	for(var count = 0; count < changeItem.length; count++){                
			var option = $("<option>"+changeItem[count]+"</option>");
			$('#select4').append(option);
	}
}
</script>
</head>
<body>
	<div class="w3-bar w3-white w3-small">
		<jsp:include page="../header/header.jsp" />
	</div>
	<div class="content" style="max-width: 1600px; text-align: center">
		<div class="regForm" style="padding: 0px; text-align: center">
			<form id="fileForm" action="step2" method="post" enctype="multipart/form-data" >
				<table class="regTable">
					<tbody>
						<tr>
							<th>펜션명</th>
							<td><input type="text" name="name" required/></td>
						</tr>
						<tr>
							<th>펜션주소</th>
							<td><input type="text" name="address" required/></td>
						</tr>
						<tr>
							<th>문의번호</th>
							<td><input type="tel" name="phone" required/></td>
						</tr>
						<tr>
							<th>펜션 성수기 시작일</th>
							<td>
								<select id="select1" name="month1" onchange="itemChange()" required>
									<option>월</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
								</select>
								<select id="select2" name="day1" required></select>
								<input type="hidden" name="peak_start" />
							</td>
						</tr>
						<tr>
							<th>펜션 성수기 종료일</th>
							<td>
								<select id="select3" name="month2" onchange="itemChange2()" required>
									<option>월</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
								</select>
								<select id="select4" name="day2" required></select>
								<input type="hidden" name="peak_end" />
							</td>
						</tr>
						<tr>
							<th>입실 시간</th>
							<td>
								<select id="hour1" name="hour1" required>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
									<option>13</option>
									<option>14</option>
									<option>15</option>
									<option>16</option>
									<option>17</option>
									<option>18</option>
									<option>19</option>
									<option>20</option>
									<option>21</option>
									<option>22</option>
									<option>23</option>
									<option>24</option>
								</select>
								<select id="min1" name="min1" required>
									<option>00</option>
									<option>10</option>
									<option>20</option>
									<option>30</option>
									<option>40</option>
									<option>50</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>퇴실 시간</th>
							<td>
								<select id="hour2" name="hour2" required>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
									<option>13</option>
									<option>14</option>
									<option>15</option>
									<option>16</option>
									<option>17</option>
									<option>18</option>
									<option>19</option>
									<option>20</option>
									<option>21</option>
									<option>22</option>
									<option>23</option>
									<option>24</option>
								</select>
								<select id="min2" name="min2" required>
									<option>00</option>
									<option>10</option>
									<option>20</option>
									<option>30</option>
									<option>40</option>
									<option>50</option>
								</select>
								<input type="hidden" name="info" />
							</td>
						</tr>
						<tr>
							<th>픽업 여부</th>
							<td><input type="checkbox" name="pu" id="pu" /></td>
							<input type="hidden" name="pickup" id="pickup" />
						</tr>
						<tr>
							<th>기타</th>
							<td><textarea name="content" rows="5" cols="30" name="name"></textarea></td>
						</tr>
					</tbody>
				</table>
				<hr />
					<input type="file" name="file" multiple="multiple" required>
				<input id="btn1" type="submit" value="다음 단계">
			</form>
		</div>
	</div>
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
<script>
	$(document).ready(function () {
		$('#btn1').click(function () {
			$('input[name=peak_start]').val('2019-'+$('#select1').val()+'-'+$('#select2').val());
			$('input[name=peak_end]').val('2019-'+$('#select3').val()+'-'+$('#select4').val());
			$('input[name=info]').val($('#hour1').val()+':'+$('#min1').val()+'/'+$('#hour2').val()+':'+$('#min2').val());
			
			$('input[name=pickup]').val($('input:checkbox[id="pu"]').is(':checked'));
		});
	
	});
</script>
</html>