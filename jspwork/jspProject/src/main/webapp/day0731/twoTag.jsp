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
	<!-- twoInclude로 본인들 이름(name)과 주소(addr)를 전달  -->
	
	
	<jsp:include page="./twoInclude.jsp">
		<jsp:param value="limchard" name="name"/>
		<jsp:param value="seoul" name="addr"/>
	
	</jsp:include>
	
</body>
</html>