
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String num=request.getParameter("num");
	
	%>
	
	<!-- useBean은 new 객체생성하는 것과 똑같아 id는 변수명이 된다.  --> 
	<jsp:useBean id="dao" class="db.simpleboard.SimpleBoardDao"></jsp:useBean>
	
	<%
	
	// db에 delete
	dao.deleteBoard(num);
	
	// 목록으로 이동
	response.sendRedirect("boardlist.jsp");
	
	%>
	
</body>
</html>