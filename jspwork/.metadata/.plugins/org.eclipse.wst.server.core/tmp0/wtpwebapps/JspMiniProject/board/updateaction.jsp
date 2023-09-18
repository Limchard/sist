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
	// 엔코딩
	request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dao" class="data.dao.SmartDao"></jsp:useBean>
	<jsp:useBean id="dto" class="data.dto.SmartDto"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
	
	<%
	// db에 update 하기
	dao.updateSmart(dto);
	
	// 목록으로 이동
	// response.sendRedirect("../index.jsp?main=board/boardlist.jsp");
	
	
	// 디테일페이지로 이동하려면 방금 insert된 num값을 알아야 한다.	
	
	String num=request.getParameter("num");
	String currentPage=request.getParameter("currentPage");
	response.sendRedirect("../index.jsp?main=board/contentview.jsp?num="+num+"&currentPage="+currentPage);
	
	%>
	
	
	
</body>
</html>