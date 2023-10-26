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
	ul.menu{
		list-style: none;
		
	}
	ul.menu li{
		width: 100px;
		float: left;
		/* border: 1px solid gray; */
		border-radius: 30px;
		height: 60px;
		line-height: 60px;		
		text-align: center;
		margin-right: 10px;
		font-size: 24px;
		font-family: 'Dongle';
		background-color: #FFD73C;
		cursor: pointer;
	}
	ul.menu li a{
		text-decoration: none;
		color: white;
	}
	
</style>

</head>
<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
<body>

<ul class="menu">
	<li>
		<a href="/">Home</a>
	</li>
	<li>
		<a href="${root }/ipgo/ipgoform">상품등록</a>
	</li>
	<li>
		<a href="${root }/ipgo/list">상품목록</a>
	</li>
	<li>
		<a href="${root }/board/list">답변형게시판</a>
	</li>
	<li>
		<a href="${root }/member/list">회원목록</a>
	</li>
	<li>
		<a href="${root }/member/form">회원가입</a>
	</li>
	<li>
		<a href="/login/form">로그인</a>
	</li>
	<li>
		<a href="/load/map">오시는길</a>
	</li>
</ul>
	
</body>
</html>