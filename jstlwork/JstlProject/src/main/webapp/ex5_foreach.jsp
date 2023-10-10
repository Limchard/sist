<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
</head>
<body>

	<h3>1~10 출력</h3>
	<c:forEach var="a" begin="1" end="10">
	${a }&nbsp;
	</c:forEach>

	<h3>0~30출력 3의 배수</h3>
	<c:forEach var="a" begin="0" end="30" step="3">
		${a }&nbsp;
	</c:forEach>

	<%
	List<String> list = new ArrayList<String>();
	list.add("red");
	list.add("blue");
	list.add("black");
	list.add("pink");
	list.add("green");
	list.add("gray");
	list.add("orange");

	request.setAttribute("list", list);
	request.setAttribute("totalCount", list.size());

	// 세션에 아이디 저장하기
	session.setAttribute("id", "scott");
	%>

	<h3>list에는 총 ${totalCount}개의 색상이 들어있다.</h3>
	<h3>list에는 총 ${requestScope.totalCount }개의 색상이 들어있다.</h3>
	<!-- requestScope 의 경우 생략 가능 -->


	<!-- 달러{변수명} 일 경우에 앞에 requestScope가 생략된것임.. request 에 저장된 데이터는 자바처럼 getAttribute로 얻지않아도 바로 출력 가능하다. -->

	<h3>세션 아이디 출력</h3>
	<h3>현재 로그인한 아이디는 ${id } 입니다.</h3>
	<h3>현재 로그인한 아이디는 ${sessionScope.id } 입니다.</h3>
	<!-- sessionScope 의 경우도 생략은 가능 하지만 구분을 위해 보통 생략하지 않는다. -->

	<hr>
	<h3>list 전체 출력</h3>
	<table class="table table-bordered" style="width: 300px;">
		<tr>
			<th>No.</th>
			<th>index</th>
			<th>color</th>
		</tr>
		<c:forEach items="${list }" var="s" varStatus="i">
			<tr>
				<td>${i.count }</td><!-- 무조건 1번부터 출력 -->
				<td>${i.index }</td><!-- 실제 List의 index값이 출력된다. -->
				<td><b style="color:${s};">${s }</b></td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>list 인덱스 2~4 출력</h3>
	<table class="table table-bordered" style="width: 300px;">
		<tr>
			<th>No.</th>
			<th>index</th>
			<th>color</th>
		</tr>
		<c:forEach items="${list }" var="s" varStatus="i" begin="2" end="4">
			<tr>
				<td>${i.count }</td><!-- 무조건 1번부터 출력 -->
				<td>${i.index }</td><!-- 실제 List의 index값이 출력된다. -->
				<td><b style="color:${s};">${s }</b></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>