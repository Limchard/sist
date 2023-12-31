<%@page import="java.util.Date"%>
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
	<!-- jstl 변수선언  -->
	<c:set var="name" value="김영준"></c:set>
	<c:set var="age" value="22"></c:set>
	<c:set var="today" value="<%=new Date() %>"></c:set>
	
	<!-- jstl 출력법1 -->
	<h2>이름: <c:out value="${name }"></c:out></h2>
	
	<!-- jstl 출력법2 -->
	<h2>이름: ${name } </h2>
	<h2>나이: ${age } </h2>
	<h2>오늘날짜: ${today } </h2>
	
	<!-- pattern 이용하면 fmt날짜형식 -->
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/><br>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd a hh:mm"/><br>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEE"/><br>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEEE"/><br>
	<fmt:formatDate value="${today }" pattern="yyyy년MM월dd일 HH:mm"/><br>
	
	<c:set var="money" value="122000"></c:set>
	<c:set var="num1" value="123.45678"></c:set>
	
	<!-- 숫자형식 -->
	<pre>
		${money }
		${num1 }
		
		<!-- number : 3자리마다 컴마 (천단위 구분기호) -->
		<fmt:formatNumber value="${money }" type="number"></fmt:formatNumber>
		
		<!-- currency : 앞에 화폐단위 + 3자리마다 컴마(천단위 구분기호)  -->
		<fmt:formatNumber value="${money }" type="currency"></fmt:formatNumber>
		
		<!-- pattern -->
		<fmt:formatNumber value="${num1 }" pattern="0.00"></fmt:formatNumber>
		<fmt:formatNumber value="2.5" pattern="0.00"></fmt:formatNumber>
		<fmt:formatNumber value="2.5" pattern="0.##"></fmt:formatNumber> <!-- #의 경우 0값 생략 -->
		
	</pre>
	
	
	<!-- if문 -->
	<c:set var="num1" value="7"></c:set>
	<c:set var="num2" value="4"></c:set>
	
	<!-- 출력( c:out은 생략 가능) -->
	숫자1: ${num1 }<br>
	숫자2: ${num2 }<br>
	
	<!-- 조건문 c:if -->
	<!-- else 없음. c:if 하나뿐이다.  -->
	<c:if test="${num1>num2 }">
		<h2>숫자1이 더 큽니다.</h2>
	</c:if>
	<c:if test="${num1<num2 }">
		<h2>숫자2가 더 큽니다.</h2>
	</c:if> 
	<!-- 조건에 맞는것만 출력한다.  -->
	
	
	<!-- if문 -->
	<c:set var="nara" value="프랑스"></c:set>
	
	<!-- java 는 문자열 비교가 안되지만, jstl 에서는 문자열 비교 가능  -->
	<c:if test="${nara=='체코' }"> 
		<h2>체코에서 한달살기</h2>
	</c:if>
	<c:if test="${nara=='프랑스' }"> 
		<h2>프랑스의 에펠탑에서 와인마시기</h2>
	</c:if>
	
	
</body>
</html>