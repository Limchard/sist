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
	String sangpum=request.getParameter("sangpum");
	String size=request.getParameter("size");
	String [] colors=request.getParameterValues("colors");
	String [] sang2=request.getParameterValues("sang2");
	%>
	
	<h3>결과값 출력</h3>
	상품명: <%=sangpum %><br>
	size: <%=size %><br>
	색상: 
	<%
	for(int i=0;i<colors.length;i++){
		%> 
		<%=colors[i] %>&nbsp;
		<div style="background-color:<%=colors[i] %>; width:50px; height:50px; border-radius:50px;"></div>
		<%
	}
	%>
	추가상품: 
	<%
	for(int j=0;j<sang2.length;j++){
		%><br>
		<%=sang2[j] %>&nbsp;
		<%
	}
	
	%>
	
</body>
</html>