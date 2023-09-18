<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- include jsp action code 중에 하나입니다. -->
	<!-- include : 원래 action page로 돌아간다. -->
	<!-- request, respons의 과정속에서 갔다가 다시 돌아온다. -->
	
	<h2>다른폴더의 파일 include하기</h2>
	<h4>구구단 가져오기</h4>
	<%-- <jsp:include page="./guguWrite.jsp"></jsp:include> --%>
	<jsp:include page="./guguWrite.jsp"/>  <!-- 위와 같은 의미  -->
	<hr>
	<h4>퀴즈 이미지 가져오기 </h4>
	<jsp:include page="./quizArrImage.jsp"></jsp:include>
	
	
	<h3>현재파일 종료!</h3>
</body>
</html>