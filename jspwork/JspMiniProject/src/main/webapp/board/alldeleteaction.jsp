<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	
	String nums=request.getParameter("nums");
	
	// ,로 분리해서 배열화[] 시키기
	String [] num=nums.split(",");
	
	// 배열의 길이만큼 삭제하기
	SmartDao dao=new SmartDao();
	
	for(String n:num){
		dao.deleteSmart(n);
	}
	
	// 목록으로 이동
	response.sendRedirect("../index.jsp?main=board/boardlist.jsp");
	
	
	%>
	
	
	
</body>
</html>