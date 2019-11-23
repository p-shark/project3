<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<html>
<style>
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
    width: 150px;
    padding: 20px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
table.regTable td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
table.regTable tr td input {
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
  font-size: 20px;
}

div.regForm {
	display: inline-block;
	padding-left: 35%;
	margin-top: 50px;
	margin-bottom: 20px;
}
</style>
<head>
    <title><spring:message code="member.register" /></title>
</head>

<body>

<div class="w3-bar w3-white w3-Small">
<jsp:include page="../header/header.jsp" />
</div>

<div class="regForm">
	<form:form action="ownerStep3" modelAttribute="ownerRegisterRequest">
		<table class="regTable">
			<thead>
				<tr>
					<th><h2><spring:message code="member.info" /></h2></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th><spring:message code="name" /></th>
					<td>
						<form:input path="owner_name" />
       					<form:errors path="owner_name"/>
					</td>
				</tr>
				<tr>
					<th><spring:message code="id" /></th>
					<td>
						<form:input path="owner_id" />
        				<form:errors path="owner_id"/>
					</td>
				</tr>
				<tr>
					<th><spring:message code="password" /></th>
					<td>
						<form:password path="owner_pwd" />
        				<form:errors path="owner_pwd"/>
					</td>
				</tr>
				<tr>
					<th><spring:message code="password.confirm" /></th>
					<td>
						<form:password path="confirmPassword" />
        				<form:errors path="confirmPassword"/>
					</td>
				</tr>
				<tr>
					<th><spring:message code="email" /></th>
					<td>
						<form:input path="owner_email" />
        				<form:errors path="owner_email"/>
					</td>
				</tr>
				<tr>
					<th><spring:message code="phone" /></th>
					<td>
						<form:input path="owner_phone" />
        				<form:errors path="owner_phone"/>
					</td>
				</tr>
				<tr>
					<th><spring:message code="content" /></th>
					<td>
						<form:input path="owner_content" />
        				<form:errors path="owner_content"/>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="<spring:message code="register.btn" />">
	</form:form>
</div>
<!-- Footer -->
	<div class="w3-center" style="clear: both; background-color: #999; color: #fff;">
		<jsp:include page="../footer/footer.jsp" />
	</div>
</body>
</html>
