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
	
	<div style="margin: 100px 50px;">
	<form action="update" method="post">
	<input type="hidden" name="num" value="${cardto.num }">
		<table class="table table-bordered" style="width: 350px;">
			<tr>
				<th>고객명</th>
				<td>
					<input type="text" name="name" required="required" class="form-control" value="${cardto.name }">
				</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<input type="text" name="hp" required="required" class="form-control" value="${cardto.hp }">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="addr" required="required" class="form-control" value="${cardto.addr }">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-warning">수정</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href='list'">목록</button>
				</td>
			</tr>
			
		</table>
	</form>
</div>
	
</body>
</html>