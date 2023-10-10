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
	<fmt:requestEncoding value="utf-8"/>
	<form action="ex4_jstlTagTest.jsp" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="text" name="age" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<th>급여</th>
				<td>
					<input type="text" name="pay" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<th>가고싶은나라</th>
				<td>
					<input type="text" name="nara" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success">결과확인</button>
				</td>
			</tr>
		
		</table>
	</form>
	
	<!-- 이름을 입력했을경우에만 출력 div 출력
	
		이름: 김영환
		나이 : 19세(미성년자) .. 조건 : 20살 이상이면 성년 아니면 미성년
		월급여 : 180만원 .. 화폐단위와 천단위 구분기호 넣기
		가고싶은나라 : choose 이용해서 출력은 마음대로 할것.
	
	
	 -->
	 
	 <c:if test="${!empty param.name }">
	 	이름: ${param.name } <br>
	 	<c:if test="${param.age>=20 }">
	 		나이:${param.age }살 (술담배 쌉가능)<br>
	 	</c:if>
	 	<c:if test="${param.age<20 }">
	 		나이:${param.age }세 (노담)<br>
	 	</c:if>
	 	<fmt:formatNumber value="${param.pay }" type="currency"></fmt:formatNumber>
	 	
	 	<c:choose>
	 		<c:when test="${param.nara=='북한' }">
	 			<h3 style="color:red;">붉게타오르는 아오지~ 진호랑 놀라고 왔음둥~ 진호가 나랑 안놀아주면 수류탄만 남기고 간단다~</h3>
	 		</c:when>
	 		<c:when test="${param.nara=='중국' }">
	 			<h3 style="color:red;">니취빨러마!! 배고프다!!</h3>
	 		</c:when>
	 		<c:when test="${param.nara=='미국' }">
	 			<h3 style="color:blue;">총맞고 싶니?</h3>
	 		</c:when>
	 		<c:when test="${param.nara=='콩고' }">
	 			<h3 style="color:balck;">콩콩 고고 </h3>
	 		</c:when>
	 		<c:when test="${param.nara=='메이플월드' }">
	 			<h3 style="color:green;">나는 메붕이 </h3>
	 		</c:when>
	 		<c:otherwise>
	 			<h3>해당사항 ㄴㄴ </h3>
	 		</c:otherwise>
	 	</c:choose>
	 
	 </c:if>
	
	
</body>
</html>