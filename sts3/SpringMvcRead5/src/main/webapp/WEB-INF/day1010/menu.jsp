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
	<div style="margin-left: 200px; margin-top: 50px;">
		<button type="button" class="btn btn-outline-info" onclick="location.href='naver/form1'" style="width: 200px;">각각 읽기</button>
		<button type="button" class="btn btn-outline-success" onclick="location.href='naver/form2'" style="width: 200px;">Dto로 읽기</button>
		<button type="button" class="btn btn-outline-warning" onclick="location.href='naver/form3'" style="width: 200px;">Map으로 읽기</button>
		<button type="button" class="btn btn-outline-danger" onclick="location.href='naver/form4'" style="width: 200px;">이미지 업로드_1개</button>
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='naver/uploadform5'" style="width: 200px;">이미지 업로드_여러개</button>
	</div>
</body>
</html>