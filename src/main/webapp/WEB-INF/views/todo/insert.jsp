<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do 등록</title>
</head>
<!-- 
url: get                 view?tNo=1 tNo가 파라미터 
form: get, post          name 속성의 값이 파라미터 이름
참고: 
요청할 때 parameter와 attribute를 사용해서 데이터를 전달함
parameter: 사용자가 보내는 데이터 => getParameter() (o) setParameter() (x)
		   setParameter()가 없는 대신 <input type="hidden" name="" value="">을 사용함
		   개발자가 사용자 몰래 데이터를 심어놓고 전달할 수 있게 하는 방식 
attribute: 개발자가 보내는 데이터 => getAttribute() (o) setAttribute() (x) 

 -->
<body>
	<div style="color: red">${msg}</div>
	<form action="/todo/insert" method='post'>
		<div>
			할 일 : <input type="text" name="title">
		</div>
		<div>
			작성자 : <input type="text" name="writer">
		</div>
		<div>완료일자:
			<input type="date" name="dueDate">
		</div>
		<div>
			<button>등록</button>
		</div>
	</form>
</body>
</html>