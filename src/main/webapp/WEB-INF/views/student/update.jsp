<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과명 수정</title>
</head>
<body>
<form action="/Exercise/students/update" method="post">
	<div>
		<label>변경전 학과명: 
			<select id="departSelect">
				<option selected="selected">학과명</option>
				<c:forEach items="${departs}" var="dept">
				<option value="${dept}">${dept}</option>
				</c:forEach>
			</select>
			<input type="text" name="depart" id="depart" value="${depart}" readonly>
		</label>
	</div>
	<div>
		<label>변경후 학과명:
			<input type="text" name="newDepart" placeholder="새로운 학과명 작성">
		</label>
	</div>
	<div>
		<button type="submit">전송</button>
	</div>
</form>
</body>
<script>
	document.querySelector("#departSelect").addEventListener("change", (evt)=> {
		console.log(evt.target.value);
		document.querySelector("#depart").value = evt.target.value;
	})
</script>
</html>