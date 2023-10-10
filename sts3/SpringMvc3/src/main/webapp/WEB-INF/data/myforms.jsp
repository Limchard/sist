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
	<h2>get방식 폼</h2>
	<form action="read1" method="get">
		이름: <input type="text" name="myname" size="6"><br>
		나이: <input type="text" name="myage" size="5"><br>
		<button type="submit" class="btn btn-info">get방식 전송</button>
	</form>
	<br><br>
	
	<h2>post방식 폼_dto읽기</h2>
	<form action="read2" method="post">
		상품: <input type="text" name="sang" size="10"><br>
		가격: <input type="text" name="price" size="10"><br>
		<button type="submit" class="btn btn-success">post방식 전송</button>
	</form>
	<br><br>
	
	<h2>post방식 폼_map 읽기</h2>
	<form action="read3" method="post">
		상품: <input type="text" name="sang" size="10"><br>
		가격: <input type="text" name="price" size="10"><br>
		<button type="submit" class="btn btn-warning">post방식 전송</button>
	</form>
	
</body>
</html>