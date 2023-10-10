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
<!-- 한글엔코딩 -->
<fmt:requestEncoding value="utf-8"/>
	<form action="ex3_jstl_form.jsp" method="post" style="width: 200px;">
		<h3>이름입력</h3>
		<input type="text" name="irum" class="form-control">
		<h3>가고싶은나라</h3>
		<input type="text" name="nara" class="form-control">
		<br>
		<button type="submit" class="btn btn-info">결과확인</button>
	</form>
	
	<!-- 이름을 입력시에만 결과가 출력되게 합시다 -->
	<c:if test="${!empty param.irum}">
		<h2>이름: ${param.irum }</h2>	
		<h3>가고싶은 나라: ${param.nara }</h3>
	</c:if>
	
	<c:choose>
		<c:when test="${param.nara=='프랑스' }">
			<h3 style="color:blue;">프랑스는 에펠탑</h3>
		</c:when>
		<c:when test="${param.nara=='북한' }">
			<h3 style="color:red;">아오지탄광</h3>
		</c:when>
		<c:when test="${param.nara=='중국' }">
			<h3 style="color:red;">워싱싱</h3>
		</c:when>
		<c:when test="${param.nara=='인도' }">
			<h3 style="color:yellow;">카레</h3>
		</c:when>
		<c:otherwise>
			<h3 style="color:pink;">${param.nara }는 해당사항 없습니다.</h3>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>