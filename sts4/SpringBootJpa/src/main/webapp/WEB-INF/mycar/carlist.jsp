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
.box{
	border: 1px solid gray;
	width: 30px;
	height: 30px;
	border-radius: 30px;
}

</style>

</head>
<body>
	<div style="margin: 50px 100px;">
	<img alt="" src="../20.jpg" style="width: 150px;">
		<button type="button" class="btn btn-info" onclick="location.href='carform'">자동차정보입력</button>
		
		<br><br>
		<h3 class="alert alert-info">
			<b>총 ${totalCount }개의 자동차 정보가 있습니다.</b>
		</h3>
		<table class="table table-bordered">
			<tr>
				<th style="width: 60px;">번호</th>
				<th style="width: 120px;">자동차명</th>
				<th style="width: 100px;">색상</th>
				<th style="width: 160px;">가격</th>
				<th style="width: 220px;">구입일</th>
				<th style="width: 220px;">등록일</th>
				<th style="width: 200px;">편집</th>
			</tr>
			
 			
			<c:forEach var="dto" items="${list }" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${dto.carname }</td>
					<td><div style="background-color: ${dto.carcolor}" class="box"></div></td>
					<td><fmt:formatNumber value="${dto.carprice }" type="currency"/></td>
					<td>${dto.carguip }</td>
					<td><fmt:formatDate value="${dto.guipday }" pattern="yyyy.MM.dd"/></td>
					<td>
						<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
						<button type="button" class="btn btn-outline-danger" onclick="location.href='deletecar?num=${dto.num}'">삭제</button>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>