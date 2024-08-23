<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록</title>
</head>
<body>

<form action="/Exercise/students/new" method="post">
	<div>
		<label>학번:
			<input type="text" name="sNo">
		</label>
	</div>
		<div>
		<label>학과:
			<input type="text" name="depart">
		</label>
	</div>
	<div>
		<label>이름:
			<input type="text" name="name">
		</label>
	</div>	
	<div>
		<label>주소:
			<input type="text" name="address">
		</label>
	</div>	
	<div>
		<label>연락처:
			<input type="text" name="phone">
		</label>
	</div>	
	<div>
		<button type="submit">전송</button>
	</div>
</form>
</body>
</html>