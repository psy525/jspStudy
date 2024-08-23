<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 등록</title>
</head>
<body>
	<div style="color: red">${msg}</div>
	<form action="/memos/new" method='post'>
		<div>
			<label>제목: <input type="text" name="title">
			</label>
		</div>
		<div>
			<label>내용: <textarea name="content"></textarea>
			</label>
		</div>
		<div>
			<label>작성자: <input type="text" name="writer">
			</label>
		</div>
		<div>
			<button>저장</button>
		</div>
	</form>
</body>
</html>