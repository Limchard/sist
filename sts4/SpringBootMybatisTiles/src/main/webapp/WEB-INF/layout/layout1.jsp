<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!-- 타이핑 해줘야 한다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
div.layout div {
	/* border: 1px solid gray; */
	
}

div.layout div.title {
	position: absolute;
	top: 10px;
	left: 450px;
	height: 100px;
}

div.layout div.menu {
	position: absolute;
	top: 150px;
	left: 250px;
	height: 100px;
	width: 1000px;
}

div.layout div.info {
	position: absolute;
	top: 250px;
	left: 50px;
	height: 100px;
	font-family: 'Dongle';
	font-size: 17px;
	width: 200px;
}

div.layout div.main {
	position: absolute;
	top: 300px;
	left: 300px;
	height: 500px;
	font-family: 'Dongle';
	font-size: 17px;
	width: 1000px;
}
</style>
</head>
<body>
	<!-- 여기(layout1)가 jsp pjt때의 index 역할을 하는 곳이다. -->
	<div class="layout">
		<div class="title">
			<tiles:insertAttribute name="title" />
		</div>
		<div class="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div class="info">
			<tiles:insertAttribute name="info" />
		</div>
		<div class="main">
			<tiles:insertAttribute name="main" />
		</div>
	</div>
</body>
</html>