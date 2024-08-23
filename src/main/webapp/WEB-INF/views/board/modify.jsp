<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/boards/modify" method="post">
		<div>
			<input type="hidden" name="id" value='${board.id }'>
		</div>
		<div>
			<label> 제목: <input type="text" name="title" value="${baord.title}">
			</label>
		</div>
		<div>
			<label> 내용: <textarea rows="4" , cols="30" name="content">${baord.content}</textarea>
			</label>
		</div>
		<div>
			<label> 작성자: <input type="text" name="writer" value="${board.writer}" readonly>
			</label>
		</div>
		<div>
			<button>수정</button>
		</div>
	</form>
</body>
</html>