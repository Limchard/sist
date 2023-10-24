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
<style type="text/css">
div.box{
	margin: 20px 20px;
}

</style>
</head>
<body>

<div class="box">
	<table style="width: 400px;">
		<caption align="top"><h4>영화 상세 정보</h4></caption>
		<tr>
			<td rowspan="4" width="220">
				<img alt="" src="../moviephoto/${dto.mv_poster }" style="width: 200px;">
			</td>
		</tr>
		<tr>
			<td>
				<h5>제목: ${dto.mv_title }</h5>
			</td>
		</tr>
		<tr>
			<td>
				<h5>감독: ${dto.mv_director }</h5>
			</td>
		</tr>
		<tr>
			<td>
				<h5>개봉: ${dto.mv_opendate }</h5>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-outline-warning" onclick="location.href=''" style="width: 80px;">수정</button>
				<button type="button" class="btn btn-outline-danger" onclick="location.href=''" style="width: 80px;">삭제</button>
				<button type="button" class="btn btn-outline-success" onclick="location.href=''" style="width: 80px;">목록</button>
				<button type="button" class="btn btn-outline-info" onclick="location.href=''" style="width: 80px;">글쓰기</button>
			</td>
		</tr>
	</table>
	
	
</div>
	
</body>
</html>