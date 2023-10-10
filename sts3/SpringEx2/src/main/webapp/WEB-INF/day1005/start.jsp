<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<br>
	<h2>안녕하세요</h2>
	<h2>오늘은 MVC 모델 연습하는 날입니다.</h2>
	<h3>StartController로 부터 포워드</h3>
	<b>이름: ${requestScope.name }</b><br>
	<b>주소: ${addr }</b> <!-- requestScope. 생략 가능하다.	-->
	<br><br>
	<h1 class="alert alert-info">매핑연습</h1>
	<ul>
		<li><a href="apple/list">apple/list</a></li>
		<li><a href="apple/list.do">apple/list.do</a></li>
		<li><a href="apple/list.nhn">apple/list.nhn</a></li>
		<li><a href="apple/list.kimoring">apple/list.kimoring</a></li>
		<li><a href="banana/insert">banana/insert</a></li>
		<li><a href="orange/delete">orange/delete</a></li>
	</ul>
	
	<h1 class="alert alert-success">이미지연습</h1>
	<ul>
		<li><a href="shop/detail">resources의 이미지 출력</a></li>
		<li><a href="board/insert/data">WEB-INF의 이미지 출력</a></li>
		
	</ul>
	
</body>
</html>