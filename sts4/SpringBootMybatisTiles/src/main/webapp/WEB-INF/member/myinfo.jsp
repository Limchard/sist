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
<c:forEach var="dto" items="${list }">
	<table class="table table-bordered" style="width: 800px;">
		<tr>
			<td rowspan="7" align="center" style="width: 350px;">
				<img alt="" src="../membersave/${dto.photo }" style="width: 300px;">
				<br><br>
				<button type="button" class="btn btn-primary">사진수정</button>
			</td>
			<td>
				이름: ${dto.name }
			</td>
			<td rowspan="7" align="center" valign="middle">
				<button type="button" class="btn btn-success">정보수정</button><br><br>
				<button type="button" class="btn btn-danger">회원탈퇴</button>
			</td>
		</tr>
		<tr>
			
		</tr>
		<tr>
			<td>
				id: ${dto.id }
			</td>
		</tr>
		<tr>
			<td>
				hp	: ${dto.hp }
			</td>
		</tr>
		<tr>
			<td>
				addr: ${dto.addr }
			</td>
		</tr>
		<tr>
			<td>
				email: ${dto.email }
			</td>
		</tr>
		<tr>
			<td>
				gaipday: ${dto.gaipday }
			</td>
		</tr>
		
	</table>
</c:forEach>
</body>
</html>