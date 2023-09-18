<%@page import="data.dao.MemberDao"%>
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
	String id=request.getParameter("id"); // 넘겼으니까 받을 수 있는 것이다. // 이름을 바로 받으면 글자가 깨진다. 그래서 id를 받아서 이름을 다시 반환한다.
	MemberDao dao=new MemberDao();
	
	// id에 대한 이름 얻기
	String name=dao.getName(id);
	
	%>
	
	<div style="margin: 200px 200px;">
		<img alt="" src="image/cat/14.jpg" style="width: 200px;">
		<b><%=name %>님의 회원가입을 축하합니다.</b>
		<br><br>
		<button type="button" class="btn btn-info" onclick="location.href='index.jsp?main=login/loginmain.jsp'">로그인</button>
		<button type="button" class="btn btn-success" onclick="location.href='index.jsp'">메인</button>
	</div>
	
</body>
</html>