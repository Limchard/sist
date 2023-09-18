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
	
	request.setCharacterEncoding("utf-8");
	
	// 세션이 있는지 확인 후 없으면 꽝!!
	String msg=(String)session.getAttribute("msg"); // session은 오브젝트 타입이라서.. String type으로 형을 맞춰줘야 한다. 
	
	String travel=request.getParameter("travel");
	
	if(msg==null||!msg.equals("happy")){
		%>
		<h3 style="color: red;">시간초과로 꽝!!!</h3>	
		
	<%} else {
		%> 
		<h3 style="color: blue">축!!<%=travel %> 상품에 당첨!!</h3>
	<%}
	
	%>
	
	<a href="sessionForm.jsp">다시 선택하세요~</a>
</body>
</html>