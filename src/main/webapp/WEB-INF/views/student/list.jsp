<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
<a href="/Exercise/students/new">학생 등록</a>
<a href="/Exercise/students/update">학과명 변경 등록</a>
<a href="/Exercise/students/delete">학과 삭제</a>
<table>
	<tr>
		<th>학번</th>
		<th>학과</th>
		<th>이름</th>
		<th>주소</th>
		<th>연락처</th>
	</tr>
	<c:forEach items="${students}" var="student">
	<tr>
		<td>${student.sNo}</td>
		<td>${student.depart}</td>
		<td>${student.name}</td>
		<td>${student.address}</td>
		<td>${student.phone}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>