<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>	
	

<!DOCTYPE html>
<style>
.contents {
	margin: 15px;
}

.column {
	display: none;
}

.show {
	display: block;
}
table td th{
	border: 1px solid black; border-collapse: collapse;
}
</style>


<html>
<head>
<title>WARA PENSION :: ${pension.name}</title>
<div class="w3-bar w3-white w3-small">
	<jsp:include page="../header/header.jsp" />
</div>
</head>
<body>
	<div class="contents">
		<h2>${pension.name}</h2>
		<div class="pension">
			<div class="info">
				<p>위치 : ${pension.address}</p>
				<p>문의번호 : ${pension.phone}</p>
				<p>입퇴실 안내 : ${pension.info}</p>
				<p>픽업여부 : ${pension.pickup}</p>
				
			</div>
		</div>
		<br />

		<div class="room">
			<c:forEach var="rooms" items="${rooms}">
				<div id="myBtnContainer">
					<button class="btn replace" id="${rooms.name}"
						onclick="filterSelection(this.id)">${rooms.name}</button>
				</div>
				<div id="roomInfo" class="column ${rooms.name}">
					<p>방 크기: ${rooms.size}</p>
					<p>최대인원: ${rooms.amount}</p>
					<p>
						<span id="nopeak_weekend" class="${rooms.nopeak_weekend}">비수기
							주말가 : ${rooms.nopeak_weekend}</span>
					</p>
					<p>
						<span id="nopeak_week" class="${rooms.nopeak_week}">비수기 주중가
							: ${rooms.nopeak_week}</span>
					</p>
					<p>
						<span id="peak_weekend" class="${rooms.peak_weekend}">성수기
							주말가 : ${rooms.peak_weekend}</span>
					</p>
					<p>
						<span id="peak_week" class="${rooms.peak_week}">성수기 주중가 :
							${rooms.peak_week}</span>
					</p>
					<div class="option">
						<p>
							방 옵션:
							<c:if test="${rooms.swim eq 'true'}"> 수영장 </c:if>
							<c:if test="${rooms.spa eq 'true'}"> 스파 </c:if>
							<c:if test="${rooms.mul eq 'true'}"> 복층 </c:if>
							<c:if test="${rooms.single eq 'true'}"> 독채 </c:if>
							<c:if test="${rooms.view eq 'true'}"> 오션뷰/리버뷰 </c:if>
							<c:if test="${rooms.bar_ter eq 'true'}"> 개별 바베큐 테라스 </c:if>
							<c:if test="${rooms.bar_toge eq 'true'}"> 공용 바베큐 테라스 </c:if>
						</p>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<hr>
	<br>
	<div class="calendar">
		<div class="txt_center">
			<a href="javascript:move_date('PSJ-1556011263','2019-10-22',1);"><img
				src="../resources/images/popup/sbtn_prev.jpg" class="vab" alt=""></a>
			&nbsp; <strong id="totalDate">2019년 10월 22일 ~ 2019년 11월 04일</strong>
			&nbsp; <a
				href="javascript:move_date('PSJ-1556011263','2019-11-04',2);"><img
				src="../resources/images/popup/sbtn_next.jpg" class="vab" alt=""></a>
		</div>
		<div class="cal_icon" style="top: 3px;">
			<span class="ic_wait">예약대기</span> <span class="ic_com">예약완료</span>

		</div>
		<p class="">&nbsp;</p>

		<div id="tableDiv">
			<%-- 
			<table class="table_price">
				<colgroup>
					<col width="100">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
				</colgroup>
				<tbody>
					<tr id="peakvar">
						<th rowspan="2" id="peakdate" class="${pension.peak_start} ${pension.peak_end}"><p>객실명</p></th>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
						<td class="peak"></td>
					</tr>

					<tr id="mmddday">
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
						<th><p class="mmdd"></p><p class="dayko"></p></th>
					</tr>


					<c:forEach var="rooms" items="${rooms}">
						<!-- 방하나에 가격 하나 -->
						<tr class="${rooms.name}">
							<th rowspan="2" id="${rooms.name}">
							<u>${rooms.name}</u>
							<br>크기	: ${rooms.size}
							</th>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>
							<td class="price "></td>

						</tr>
						
						
						<tr id="chk" class="">
						
					<c:forEach var="books" items="${books}" end="14">
							<th class="" id="">
							<!-- <script>
							console.log(">>>>>>>>>>>>>>>>>>>>>> ", typeof ${rooms.room_no});
							console.log(typeof ${books.room_no});
							</script> -->
							<c:if test="${rooms.room_no}==${books.room_no}">
							<input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)">
							</c:if>
							</th>
							
					</c:forEach>
							
							<th><input type="checkbox" name="multi[]" class="${rooms.room_no}" ></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" id=""><input type="checkbox" name="multi[]" value="" id="" class="${rooms.room_no}" onclick="ins_re(this)"></th>
							<th class="${rooms.room_no}" name="multi[]" id=""><img src="../resources/images/popup/2.jpg">
							

							</th>

						</tr>
					</c:forEach>

				</tbody>
				<!-- Book 가져와서 if 해서 있으면 이미지, 없으면 input checkbox, chexkbox도 innerㅗHTML 바뀍뀍 -->


			</table>
			 --%>
		</div>

	</div>
	
	<div id="qq">
	
	</div>
	
	<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
<script>
 var getTodayLabel = function(date) {
	    
	    var week = new Array('일', '월', '화', '수', '목', '금', '토');
	    
	    var today = date.getDay();
	    var todayLabel = week[today];
	    
	    return todayLabel;
	}
 
 var get_date_str = function(date){
	    var sMonth = date.getMonth() + 1;
	    var sDate = date.getDate();

	    sMonth = sMonth > 9 ? sMonth : "0" + sMonth;
	    sDate  = sDate > 9 ? sDate : "0" + sDate;
	    return sMonth + "/" + sDate;
	}
 
 var get_date_str_gubun = function(date, gubun){
	    var sYear = date.getFullYear();
	    var sMonth = date.getMonth() + 1;
	    var sDate = date.getDate();

	    sMonth = sMonth > 9 ? sMonth : "0" + sMonth;
	    sDate  = sDate > 9 ? sDate : "0" + sDate;
	    return sYear + gubun + sMonth + gubun + sDate;
	}



 
 
     var table = $('<table></table>').attr("id", "pensionInfo");
     var colgroup = $('<colgroup></colgroup>');
     var col1 = $('<col>').attr("width", "100");
     var tbody = $('<tbody></tbody>');
     var tr1 = $('<tr></tr>');
     var th1 = $('<th rowspan="2"></th>').text('객실명');
     var tr2 = $('<tr></tr>').attr('id', 'mmddday');




     colgroup.append(col1);
     table.append(colgroup);
     for (i = 0; i < 14; i++) {
         var col = $('<col>');
         colgroup.append(col);
     }

    
     tr1.append(th1);
     

    
     var today = new Date(); 
     for (i = 0; i < 14; i++) {
         var td1 = $('<td></td>');
         var peak_s =  new Date("${pension.peak_start}").getTime();
         var peak_e =  new Date("${pension.peak_end}").getTime();
         
         if(today.getTime() < peak_s || today.getTime() > peak_e ){
				td1.text('비수기');
			}else{
				td1.text('성수기');
			}
         
         tr1.append(td1);
         today.setDate(today.getDate()+1);
     }
     tbody.append(tr1);
     
     var today2 = new Date();
     for (i = 0; i < 14; i++) {
         var th2 = $('<th></th>');
         var p1 = $('<p></p>');
         var p2 = $('<font></font>');
         
         p1.text(get_date_str(today2));
         
         if(getTodayLabel(today2) == '일'){
        	 	p2.attr('color','#F10000').text('('+getTodayLabel(today2)+')');
			}else if(getTodayLabel(today2) == '토'){
				p2.attr('color','#0384D5').text('('+getTodayLabel(today2)+')');
			}else{
				p2.attr('color','#888888').text('('+getTodayLabel(today2)+')');
			}
         th2.append(p1);
         th2.append(p2);
         tr2.append(th2);
         today2.setDate(today2.getDate()+1);
     }
     tbody.append(tr2);
     
     var peakss = new Date(${pension.peak_start});
     
     
     


     
     /* var parsedate = function(str) {
        var y = str.substr(0, 4);
        var m = str.substr(5, 2);
        var d = str.substr(8, 2);
        return new Date(y,m-1,d);
    } */

     var tabledate =  $('#checked').attr('class');
     var cccc = $('#checked').attr('name');

     
     
     <c:forEach var="rooms" items="${rooms}">

     var tr3 = $('<tr></tr>');
     var th3 = $('<th></th>').attr("rowspan", 2).text('${rooms.name}').append('<br>${rooms.size}');

     var tr4 = $('<tr></tr>').attr('id', 'chk');
     
     tr3.append(th3);
     
     //<c:set var="loop_flag" value="false" />
     <c:forEach var="book" items="${books}">
     //<c:if test="${not loop_flag }">    
     //<c:set var="loop_flag" value="true" />
     //</c:if>
     var today3 = new Date();
     
     for (i = 0; i < 14; i++) {
    	 var todayTime = today3.getTime();
         var td3 = $('<td></td>');
         var peak_s =  new Date("${pension.peak_start}").getTime();
         var peak_e =  new Date("${pension.peak_end}").getTime();

         if(todayTime >= peak_s && todayTime <= peak_e){
        	 if(getTodayLabel(today3) == '일' || getTodayLabel(today3) == '토'){
					td3.text("${rooms.peak_weekend}");
				}else{
					td3.text("${rooms.peak_week}");
				}	
		 }else{
			 if(getTodayLabel(today3) == '일' || getTodayLabel(today3) == '토'){
					td3.text("${rooms.nopeak_weekend}");
				}else{
					td3.text("${rooms.nopeak_week}");
				}
			}
         tr3.append(td3);
         
         
         var td4 = $('<td></td>').attr('id','checked').attr('name','${rooms.room_no}').addClass(get_date_str_gubun(today3,'-'));

	         if(todayTime >= new Date("${book.check_in}").getTime() && todayTime < new Date("${book.check_out}").getTime()
	        		 && "${rooms.room_no}"=="${book.room_no}"){
	           	var img = $('<img>').attr('src','../resources/images/popup/2.jpg');
	           	td4.append(img);
	          
	    	 }else{
	    		 var input4 = $('<input></input>').attr('type', 'checkbox').attr('name', 'multi[]');
	    		 td4.append(input4);
	    	 }
	         
	        
        
         
         
         tr4.append(td4);
         
         today3.setDate(today3.getDate()+1);
     }
     
     </c:forEach>
		
     tbody.append(tr3);
     tbody.append(tr4);

     </c:forEach>  

     table.append(tbody);
	
     $('#tableDiv').append(table);


     /* 
     var checkAry = new Array();
     <c:forEach var="book" items="${books}">
     checkAry.push("${book.check_in}/${book.check_out}/${book.room_no}");
     </c:forEach>
     
     
     
     var inArr = new Array();
     var outArr = new Array();
     var rmnoArr = new Array();
     
     for(i=0; i<checkAry.length; i++){
    	 var chchch = checkAry[i].split('/');
    	 inArr[i] = chchch[0];
    	 outArr[i] = chchch[1];
    	 rmnoArr[i] = chchch[2];
     } 
     
     
     var today4 = new Date();
     for(i=0; i<rmnoArr.length; i++){
    	 var img = $('<img>').attr('src','../resources/images/popup/2.jpg');
    	 
    	 var roomno = document.getElementsByName(rmnoArr[i]);
    	 
    	 for(k=0; i<roomno.length; k++){
    		 
    		 var tddate = new Date(roomno[k].attr('class')).getTime();
    		 
    		 if(tddate >= new Date(inArr[i]).getTime() && tddate < new Date(outArr[i]).getTime()){
    			 document.querySelector("td input[name="+rmnoArr[i]+"] *, ."+roomno[k].className+" *").remove();
    			 document.querySelector("td input[name="+rmnoArr[i]+"] *, ."+roomno[k].className+" *").append(img);
    		 }
    	 }
    	 
    	 
     } */
 
 
 
 </script>



<script>
	function filterSelection(c) {
		var dmkwk = document.getElementsByClassName('btn')[0];
		var wwww = dmkwk.getAttribute("id");

		var x, i;
		x = document.getElementsByClassName("column");
		if (c == "all")
			c = "";
		for (i = 0; i < x.length; i++) {
			w3RemoveClass(x[i], "show");
			if (x[i].className.indexOf(c) > -1)
				w3AddClass(x[i], "show");
		}
	}

	function w3AddClass(element, name) {
		var i, arr1, arr2;
		arr1 = element.className.split(" ");
		arr2 = name.split(" ");
		for (i = 0; i < arr2.length; i++) {
			if (arr1.indexOf(arr2[i]) == -1) {
				element.className += " " + arr2[i];
			}
		}
	}
	function w3RemoveClass(element, name) {
		var i, arr1, arr2;
		arr1 = element.className.split(" ");
		arr2 = name.split(" ");
		for (i = 0; i < arr2.length; i++) {
			while (arr1.indexOf(arr2[i]) > -1) {
				arr1.splice(arr1.indexOf(arr2[i]), 1);
			}
		}
		element.className = arr1.join(" ");
	}
	var btnContainer = document.getElementById("myBtnContainer");
	var btns = btnContainer.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
		btns[i].addEventListener("click", function() {
			var current = document.getElementsByClassName("active");
			current[0].className = current[0].className.replace(" active", "");
			this.className += " active";
		});
	}
</script>

<!-- <script>

$(document).ready(function() {
    $('#pensionInfo').DataTable( {
        columnDefs: [ {
            targets: [ 0 ],
            orderData: [ 0, 1 ]
        }, {
            targets: [ 1 ],
            orderData: [ 1, 0 ]
        }, {
            targets: [ 4 ],
            orderData: [ 4, 0 ]
        } ]
    });
});

	
</script> -->
</html>