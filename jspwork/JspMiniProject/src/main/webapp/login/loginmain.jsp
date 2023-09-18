<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	
	// loginok는 로그인성공시 저장하고 로그아웃시 제거
	String loginok=(String)session.getAttribute("loginok");
	
	if(loginok==null){ %> 
		
		<jsp:include page="loginform.jsp"></jsp:include>
		
	<%} else { %> 
		
		<jsp:include page="logoutform.jsp"></jsp:include>
		
	<%}
	
	
	%>
</body>
</html>