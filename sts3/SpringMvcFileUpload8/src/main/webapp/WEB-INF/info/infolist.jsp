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

	<h2 class="alert alert-danger" style="margin: 20px 20px;">총 ${count }개의 정보가 있습니다.</h2>
	<button type="button" class="btn btn-outline-info" onclick="location.href='addform'" style="margin: 20px 20px;">글쓰기</button>

	<table class="table table-bordered" style="width: 800px;">
		<tr>
			<th>no.</th>
			<th>이름</th>
			<th>사진</th>
			<th>운전면허</th>
			<th>주소</th>
			<th>작성일</th>
			<th>편집</th>
		</tr>
		<c:forEach var="idto" items="${list }" varStatus="i">
			<tr>
				<td align="center">${i.count }</td>
				<td align="center">${idto.name }</td>
				<td align="center">
					<c:if test="${idto.photo=='no' }">
						<img alt="" src="../photo/noimage.jpg" width="50" class="img-circle">
					</c:if>
					<c:if test="${idto.photo!='no' }">
						<img alt="" src="../photo/${idto.photo }" width="50" class="img-circle">
					</c:if>
				</td>
				<td>${idto.driver }</td>
				<td>${idto.addr }</td>
				<td>
					<fmt:formatDate value="${idto.gaipday }" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td>
					<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='uform?num=${idto.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='delete?num=${idto.num}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>