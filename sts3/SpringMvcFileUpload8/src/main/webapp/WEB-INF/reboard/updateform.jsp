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
	<div style="margin: 50px 100px;">
		<form action="update" method="post" enctype="multipart/form-data">
			<!-- hidden 2개 넣어주기 -->
			<input type="hidden" name="num" value="${bdto.num }">
			<input type="hidden" name="currentPage" value="${currentPage }">

			<table class="table table-bordered" style="width: 500px;">
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="writer" class="form-control" required="required" style="width: 100px;" value="${bdto.writer }">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="subject" class="form-control" required="required" style="width: 300px;" value="${bdto.subject }">
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td>
						<input type="file" name="uimage" class="form-control" style="width: 220px;" multiple="multiple">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea style="width: 480px; height: 150px;" name="content" required="required" class="form-control">${bdto.content }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-info" style="width: 100px;">수정하기</button>
						<button type="button" class="btn btn-success" onclick="location.href='list'" style="width: 100px;">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>