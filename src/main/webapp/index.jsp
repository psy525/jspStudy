<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이 문서는 JSP 페이지 입니다.
<% 
 int	a=5;
 	if(a<10){
		out.print ("10보다 작다");
	}
%>
</body>
</html>