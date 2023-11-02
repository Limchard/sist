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
<div style="margin: 20px 50px;">
	<form action="update" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width: 500px;">
			<caption align="top"><b>회원게시판 수정</b></caption>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subjects" class="form-control" required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="upload" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 490px; height: 150px;" class="form-control" required="required" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-info">등록</button>
					<button type="button" class="btn btn-outline-success" onclick="location.href='list'">목록</button>					
				</td>
			</tr>
		</table>
	</form>	
</div>
</body>
</html>