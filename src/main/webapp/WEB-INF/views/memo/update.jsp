<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 수정</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty msg }">
			<div style="color: red">${msg}</div>
			<div>
				<a href="javascript:history.back();">뒤로가기</a>
			</div>
		</c:when>
		<c:otherwise>
			<form action="/memos/update" method='post'>
				<div>
					<input type="hidden" name="mNo" value='${memo.mNo }'>
				</div>
				<div>
					<label>제목: <input type="text" name="mTitle"
						value='${memo.mTitle}'>
					</label>
				</div>
				<div>
					<label>내용: <textarea name="mContent">${memo.mContent }</textarea>
					</label>
				</div>
				<div>
					<label>작성자: <input type="text" name="mWriter"
						value='${memo.mWriter }' readonly="readonly">
					</label>
				</div>
				<div>
					<button>저장</button>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>