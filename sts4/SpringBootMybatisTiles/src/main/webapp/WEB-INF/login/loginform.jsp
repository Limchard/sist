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
div.loginform {
}
caption.cap{
	font-size: 30px;
	color: green;
}
</style>
</head>
<body>
<form action="loginprocess" method="post">
	<div class="loginform">
		<table style="width: 300px;">
			<caption align="top" class="cap"><b>Login</b></caption>
			<tr>
				<td>
					<input type="text" class="form-control" name="id" id="id" required="required" placeholder="아이디" value="${sessionScope.saveok==null?"":sessionScope.myid }">
					<br>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="password" class="form-control" name="pass" id="pass" required="required" placeholder="비밀번호">
					<br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="saveid" ${sessionScope.saveok==null?"":"checked" }> 아이디 저장
				</td>
			</tr>
			<tr>
				<td align="center">
					<button type="submit" class="btn btn-success" style="width: 200px;">Login</button>
				</td>
			</tr>
		</table>
	</div>	
</form>	
</body>
</html>