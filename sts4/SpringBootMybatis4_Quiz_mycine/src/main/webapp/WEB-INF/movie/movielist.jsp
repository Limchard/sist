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
td.movie{
	padding: 20px 20px;
}

</style>
</head>
<body>
<div class="box">
	<div class="alert alert-warning">
		현재 상영작은 ${movieCount }개 입니다.
	</div>
	<table>
		<tr>
			<c:forEach var="dto" items="${list }">
				<td class="movie">
					<a href="detail?num=${dto.mv_num }">
						<img alt="" src="../moviephoto/${dto.mv_poster }" style="width: 150px; height: 220px;">
					</a>
					<p align="center">${dto.mv_title }</p>
					
					
				</td>
			</c:forEach>
		</tr>
	</table>
	<div>
		<button type="button" class="btn btn-outline-info" onclick="location.href='writeform'">영화정보추가</button>
	</div>
</div>	
</body>
</html>