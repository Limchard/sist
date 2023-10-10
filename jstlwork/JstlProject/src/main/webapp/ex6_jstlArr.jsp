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
	<c:forEach var="s" begin="1" end="10">
		[${s }]
	</c:forEach>
	<br>
	<%
	String [] myColor={"red","blue","pink","green","gray","orange","magenta","purple","aqua"};
		
	
	%>
	<c:set var="mycolor" value="<%=myColor%>" ></c:set>
	
	<table class="table table-bordered" style="width: 300px;">
	<caption align="top"><b>전체값출력</b></caption>
		<tr>
			<th>index</th>
			<th>count</th>
			<th>color</th>
		</tr>
		
		<c:forEach var="a" items="${mycolor }" varStatus="i">
			<tr align="center">
				<td>${i.index }</td>
				<td>${i.count }</td>
				<td style="background-color: ${a}">${a }</td>
			</tr>
		</c:forEach>
	</table>
	
	<table class="table table-bordered" style="width: 300px;">
	<caption align="top"><b>일부값출력</b></caption>
		<tr>
			<th>index</th>
			<th>count</th>
			<th>color</th>
		</tr>
		
		<c:forEach var="a" items="${mycolor }" varStatus="i" begin="2" end="5">
			<tr align="center">
				<td>${i.index }</td>
				<td>${i.count }</td>
				<td style="background-color: ${a}">${a }</td>
			</tr>
		</c:forEach>
	</table>	
	
	<hr>
	
	<c:set var="msg" value="민규,성신,영환,성경,희찬"></c:set>
	${msg }<br>
	
	<h2>msg값을 컴마로 분리해서 출력</h2>
	<c:forTokens var="s" items="${msg }" delims="," varStatus="i">
		<h3>${i.count }: ${s }</h3>
	</c:forTokens>
	
</body>
</html>