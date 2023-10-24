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

	<form action="insert" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width: 500px; margin: 20px 20px;">
		<caption align="top"><h4><b>영화 정보 입력</b></h4></caption>
			<tr>
				<th width="80">제목</th>
				<td>
					<input type="text" class="form-control" name="mv_title" required="required" style="width: 400px;">
				</td>
				
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" class="form-control" name="mv_file" required="required" style="width: 400px;">
				</td>
				
			</tr>
			<tr>
				<th>감독</th>
				<td>
					<input type="text" class="form-control" name="mv_director" required="required" style="width: 400px;">
				</td>
			</tr>
			<tr>
				<th>개봉</th>
				<td>
					<input type="date" class="form-control" name="mv_opendate" required="required" style="width: 400px;" value="2023-09-01">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-info" style="width: 80px;">업로드</button>
					<button type="button" class="btn btn-outline-success" style="width: 80px;" onclick="location.href='list'">목록</button>
				</td>
			</tr>
		</table>
	
	</form>

</body>
</html>