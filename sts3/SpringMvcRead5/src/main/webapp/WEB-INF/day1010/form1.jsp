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
<form action="read1" method="post">
	<table class="table table-bordered" style="width: 600px;">
	<caption align="top" class="alert alert-info">정보 입력</caption>
		<tr style="width: 100px;">
			<th>이름 </th>
			<td>
				<input type="text" name="name" style="width: 120px;">
			</td>
		</tr>
		
		<tr style="width: 100px;">
			<th>성별 </th>
			<td>
				<input type="radio" name="gender" value="남자" checked="checked" style="width: 30px;">남자 &nbsp;&nbsp;
				<input type="radio" name="gender" value="여자" style="width: 120px;">여자
			</td>
		</tr>
		
		<tr style="width: 100px;">
			<th>주거지역 </th>
			<td>
				<select name="addr" class="form-control">
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="제주">제주</option>
					<option value="세종">세종</option>
					<option value="부산">부산</option>
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