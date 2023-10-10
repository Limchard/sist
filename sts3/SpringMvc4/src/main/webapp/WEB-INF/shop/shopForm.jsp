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
	<form action="process2" method="post">
		<table class="table table-bordered" style="width: 300px;">
		<caption align="top"><b>상품등록</b></caption>
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="sang" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<th>수량</th>
				<td>
					<input type="text" name="su" class="form-control" style="width: 100px;">
				</td>
			</tr>
			<tr>
				<th>단가</th>
				<td>
					<input type="text" name="dan" class="form-control" style="width: 100px;">
				</td>
			</tr>
			<tr>
				<th>색상</th>
				<td>
					<input type="color" name="color" class="form-control" style="width: 100px;">
				</td>
			</tr>
		
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-info">서버에 전송</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>