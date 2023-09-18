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
	String per1=request.getParameter("person");
	String [] per2=request.getParameterValues("person2"); 
	%>
	
	조장 1순위: <%=per1 %><br><br>
	
	예비 조장:  <!-- 중복선택 및 null이 가능하므로 java 가 와야지  --> 
	<%
	if(per2==null){
		%>
		<b style="color:red;">예비조장 없음</b>
		<%	
	} else {
		for(int i=0;i<per2.length;i++){
			%> 
			[<%=per2[i] %>]&nbsp;
			<%
		}
		
		%> 
		<b> 총 <%=per2.length %> 명의 예비 조장이 있습니다.</b>
		<%
		
	}
	
	%> 
</body>
</html>