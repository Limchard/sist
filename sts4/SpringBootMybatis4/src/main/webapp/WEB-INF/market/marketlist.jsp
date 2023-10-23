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
	<c:if test="${totalCount==0 }">
		<div class="alert alert-danger" style="margin: 20px 20px;">
			<b>저장된 상품 정보가 없습니다.</b>
		</div>
	</c:if>
	<c:if test="${totalCount>0 }">
		<div class="alert alert-info">
			<b>총 ${totalCount }개의 상품이 있습니다.</b>
		</div>
	</c:if>
	<div style="margin: 20px 20px;">
	<button type="button" class="btn btn-info" onclick="location.href='writeform'">글쓰기</button>
	</div>
	
	<table class="table table-bordered" style="width: 800px;">
		<caption align="top"><b>상품 목록</b></caption>
		<tr>
			<th width="100">번호</th>
			<th width="300">상품명</th>
			<th width="150">가격</th>
			<th width="150">입고날짜</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>
					<c:if test="${ dto.photoname==null}">
						<img alt="" src="../save/noimage.jpg" width="50">
						${dto.sang }
					</c:if>
					<c:if test="${ dto.photoname!=null}">
						<img alt="" src="../save/${dto.photoname }" width="50">
						${dto.sang }
					</c:if>
				</td>
				<td><fmt:formatNumber value="${dto.price }" type="currency"/></td>
				<td><fmt:formatDate value="${dto.ipgoday }" pattern="yyyy.MM.dd"/></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>