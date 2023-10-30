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
	<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
	<a href="/"><img alt="" src="${root }/image/titlett.jpg" width="200"></a>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<c:if test="${sessionScope.loginok==null }">
		<button type="button" class="btn btn-outline-danger" onclick="location.href='${root}/login/form'">Login</button>
	</c:if>
	
	<!-- 로그인에 대한 부분은 단순 mapping 말고, 전체 루트를 적어줘야 한다. -->
	
	<c:if test="${sessionScope.loginok!=null }">
		<b>${sessionScope.myid }님 좋은하루 보내세요~</b>
		<button type="button" class="btn btn-outline-danger" onclick="location.href='${root}/login/logoutprocess'">Logout</button>
	</c:if>
</body>
</html>