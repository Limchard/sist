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
	
	<button type="button" class="btn btn-success" onclick="location.href='writeForm'">차 정보 입력</button>

	<c:if test="${totalCount==0 }">
		<h3 class="alert alert-info">저장된 차의 정보가 없습니다.</h3>
	</c:if>
	<c:if test="${totalCount>0 }">
		<h3 class="alert alert-success">${totalCount }개의 자동자가 등록되었습니다.</h3>
	</c:if>
	
	<table class="table table-bordered" style="width: 700px;">
		<tr>
			<th width="60">번호</th>
			<th width="160">차량 이름</th>
			<th width="100">차량 색상</th>
			<th width="160">차량 가격</th>
			<th width="160">차량 구입 날짜</th>
			<th width="200">편집</th>
		</tr>
		
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${dto.carname }</td>
				<td>
					<div style="width: 20px; height: 20px; border-radius: 20px; background-color: ${dto.carcolor };" ></div>
				</td>
				<td>
					<fmt:formatNumber value="${dto.carprice }" type="currency"/>
				</td>
				<td>${dto.carguip }</td>
				<td>
					<button type="button" class="btn btn-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
		
		
		</c:forEach>
	
	</table>
	
</body>
</html>