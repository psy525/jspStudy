<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 목록</title>
</head>
<body>
	<a href="/memos/new">메모 등록</a>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
		<c:forEach var="memos" items="${memoList}">
			<tr>
				<td>${memos.mNo }</td>
				<td><a href="/memos/view?mNo=${memos.mNo}">${memos.mTitle }</a></td>
				<td>${memos.mWriter }</td>
				<td>${memos.mRegistDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>