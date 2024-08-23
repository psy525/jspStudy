<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<!-- EL(Expression Language) -->
<a href="${pageContext.request.contextPath}/member/insert">회원 등록</a>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>휴대전화번호</th>
		<th>이메일</th>
	</tr>
	<c:forEach items="${members}" var="member">
	<tr>
		<td>${member.memId}</td>
		<td><a href="/member/detail?id=${member.memId}">${member.memName}</a></td>
		<td>${member.memHp}</td>
		<td>${member.memMail}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>