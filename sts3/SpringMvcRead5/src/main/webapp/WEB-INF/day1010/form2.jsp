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
<form action="read2" method="post">
	<table class="table table-bordered" style="width: 600px;">
	<caption align="top" class="alert alert-info">정보 입력</caption>
		<tr style="width: 100px;">
			<th>상품명 </th>
			<td>
				<input type="text" name="sang" style="width: 120px;" class="form-control">
			</td>
		</tr>
		
		<tr style="width: 100px;">
			<th>색상 </th>
			<td>
				<input type="color" name="color" value="#ff0000" class="form-control" >
			</td>
		</tr>
		
		<tr style="width: 100px;">
			<th>가격 </th>
			<td>
				<input type="text" name="price" class="form-control">
			</td>
		</tr>
		
		<tr style="width: 100px;">
			<th>이미지 </th>
			<td>
				<select name="image" class="form-control">
					<option value="2.jpg">사진1</option>
					<option value="3.jpg">사진2</option>
					<option value="4.jpg">사진3</option>
					<option value="5.jpg">사진4</option>
					<option value="6.jpg">사진5</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-warning">서버에 전송</button>
			</td>
		</tr>
	</table>
</form>	
</body>
</html>