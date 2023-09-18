<%@page import="idx.model.idxDao"%>
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
	// 세션으로부터 idok 받아오기  
	String id=(String)session.getAttribute("idok");
	
	// 세션으로부터 id에 대한 name을 dao로부터 받아오기
	idxDao db=new idxDao();
	String name=db.getName(id);
	
	%>
	
	<br><br>
	<b style="color: blue"><%=name %></b> 님이 로그인 중입니다~~ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="로그아웃" class="btn btn-danger" onclick="location.href='logoutAction.jsp'">
	<br><br>
	<img src="../img/avata/b8.png" width="200px">
</body> 
</html>