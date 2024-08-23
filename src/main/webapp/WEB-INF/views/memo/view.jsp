<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 상세 내용</title>
</head>
<body>
	<div>
		<span>제목: </span> <span>${memo.mTitle}</span>
	</div>
	<div>
		<span>작성자: </span> <span>${memo.mWriter}</span>
	</div>
	<div>
		<span>작성일자: </span> <span>${memo.mRegistDate}</span>
	</div>
	<div>
		<span>내용: </span> <span>${memo.mContent}</span>
	</div>
	<div>
		<button><a href="/memos/update?mNo=${memo.mNo}">수정</a></button>
		<button><a href="/memos/delete?mNo=${memo.mNo}">삭제</a></button>
	</div>
</body>
</html>