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
<form action="result" method="post">
	<table class="table table-bordered" style="width: 600px;">
	<caption align="top" class="alert alert-info">정보 입력</caption>
		<tr style="width: 100px;">
			<th>이름 </th>
			<td>
				<input type="text" name="name" style="width: 120px;">
			</td>
		</tr>
		<tr>
			<th>좋아하는 색상 </th>
			<td>
				<input type="color" name="color" style="width: 120px;">
			</td>
		</tr>
		<tr>
			<th>취미 </th>
			<td>
				<input type="checkbox" name="hobby" value="축구" style="width: 30px;">축구
				<input type="checkbox" name="hobby" value="농구" style="width: 30px;">농구
				<input type="checkbox" name="hobby" value="야구" style="width: 30px;">야구
				<input type="checkbox" name="hobby" value="탁구" style="width: 30px;">탁구
				<input type="checkbox" name="hobby" value="당구" style="width: 30px;">당구
				<input type="checkbox" name="hobby" value="신구" style="width: 30px;">신구
			</td>
		</tr>
		<tr>
			<th>가장 좋아하는 언어 </th>
			<td>
				<select name="lang">
					<option value="java">java
					<option value="javascript">javascript
					<option value="html">html
					<option value="jquery">jquery
					<option value="css">css
					<option value="spring">spring
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info">서버에 전송</button>
			</td>
		</tr>
	</table>
</form>	
</body>
</html>