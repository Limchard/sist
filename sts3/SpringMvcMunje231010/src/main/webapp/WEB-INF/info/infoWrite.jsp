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
.divv{
	width: 30px;
	height: 30px;
	border-radius: 30px;
	background-color: ${dto.color };
	 
	
}
</style>

</head>
<body>
	<form action="result" method="post">
	<table class="table table-bordered" style="width: 600px;">
	<caption align="top" class="alert alert-warning">정보 출력</caption>
		<tr style="width: 100px;">
			<th>이름 </th>
			<td>
				${dto.name }
			</td>
		</tr>
		<tr>
			<th>좋아하는 색상 </th>
			<td>
				<div class="divv">
				</div>
			</td>
		</tr>
		<tr>
			<th>취미 </th>
			<td>
				<c:if test="${empty dto.hobby }">
				[없음]
				</c:if>
				<c:if test="${!empty dto.hobby }">
					<c:forEach var="h" items="${dto.hobby }">
						[${h }]
					</c:forEach>
				</c:if>
			</td>
		</tr>
		<tr>
			<th>가장 좋아하는 언어 </th>
			<td>
				${dto.lang }
			</td>
		</tr>
		
	</table>
</form>	
</body>
</html>