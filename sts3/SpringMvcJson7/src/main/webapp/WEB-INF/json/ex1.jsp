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
	<h3>ex1번 예제</h3>
	<br>
	<button type="button" id="btn1" class="btn btn-outline-info">list1 json data 출력</button>
	<div id="out1"></div>
	
	<script type="text/javascript">
		$("#btn1").click(function(){
			$.ajax({
				type:"get",
				dataType:"json",
				url:"list1",
				success:function(res){
					$("#out1").empty();
					$("#out1").append("이름: "+res.name+"<br>");
					$("#out1").append("연락처: "+res.hp+"<br>");
					$("#out1").append("주소: "+res.addr+"<br>");
				}
			});
		});
	</script>
</body>
</html>