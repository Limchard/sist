<%@page import="java.text.NumberFormat.Style"%>
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
	<%
	String irum=request.getParameter("irum");
	String birth=request.getParameter("birth");
	// select가 multi인 경우는 getParameterValues 로 읽는다(변환타입이 String [])
	// 이때 선택하지 않으면 null이 되고 선택하면 배열로 값이 넘어온다.
	String [] hobby=request.getParameterValues("hobby");
	%>
	
	<h3 class="alert alert-info">폼태그로부터 읽은 값 </h3>
	
	이름: <%=irum %><br>
	생일: <%=birth %><br>
	취미: 
	<%
	if(hobby==null){
		%><b Style="color:pink;">취미없음</b>
		<%
	} else {
		for(String h:hobby){
			%> 
			[<%=h %>]&nbsp;
			<%
		}
	}
	%>
	
</body>
</html>