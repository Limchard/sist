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
	
	<form action="update" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${idto.num }">
		<table class="table table-bordered" style="width: 400px;">
			<caption align="top"><b>개인정보 수정</b></caption>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" class="form-control" style="width: 120px;" required="required" value="${idto.name }">
				</td>
			</tr>
			<tr>
				<th>운전면허</th>
				<td>
					<input type="radio" name="driver" value="있음" ${idto.driver=='있음'?"checked":"" }>있음&nbsp;&nbsp;
					<input type="radio" name="driver" value="없음" ${idto.driver=='없음'?"checked":"" }>없음
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="addr" class="form-control" style="width: 250px;" required="required" value="${idto.addr }">
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="upload" class="form-control" style="width: 200px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-info">저장</button>
					<button type="button" class="btn btn-outline-success" onclick="location.href='list'">목록</button>
				</td>
			</tr>
			
		</table>
	</form>
	
</body>
</html>