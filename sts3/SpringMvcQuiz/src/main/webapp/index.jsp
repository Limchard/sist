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
	<button onclick="location.href='ilike/movie'" class="btn btn-outline-info">제목을 메세지로 받아서 출력하고 그 아래 이미지_result1</button><br>
	<button onclick="location.href='school/myinfo'" class="btn btn-outline-success">get방식 테이블 출력(이름,학교,학년,학교주소)_result2</button><br>
	<button onclick="location.href='shop/ipgo'" class="btn btn-outline-warning">post방식(dto) 테이블 출력(상품명,카테고리,색상,가격)_result3</button><br>
	<button onclick="location.href='myshinsang'" class="btn btn-outline-danger">post방식 Map출력(이름,나이,혈액형,주소)_result4</button><br>
</body>
</html>