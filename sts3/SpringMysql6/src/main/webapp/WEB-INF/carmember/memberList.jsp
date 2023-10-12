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
	<c:if test="${count==0 }">
		<h2 class="alert alert-info">등록된 고객 정보가 없습니다.</h2>
	</c:if>
	<c:if test="${count>0 }">
		<h2 class="alert alert-info">총 ${count }명의 고객 정보가 있습니다.</h2>
	</c:if>
	
	<button type="button" class="btn btn-outline-info" onclick="location.href='insertform'">고객 정보 추가</button>

	<table class="table table-bordered" style="width: 800px;">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>연락처</th>
			<th>주소</th>
			<th>가입날짜</th>
			<th>수정 삭제</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${dto.name }</td>
				<td>${dto.hp }</td>
				<td>${dto.addr }</td>
				<td>${dto.gaipday }</td>
				<td>
					<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}'">DB수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}'">DB삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>