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
	// 배열선언
	String [] colors={"green","yello","pink","blue","magenta"};
	String title="배열출력";
	
	%>
	
	<table class="table table-bordered" style="width:200px;">
		<caption><b><%=title %></b></caption>
		<tr>
			<th>번호</th>
			<th>색상</th>
		</tr>
		
		<%
		for(int i=0;i<colors.length;i++){ // <% 는 자바문법이다. 프론트의 태그를 위해서 닫아줘야 한다.
			%>
			<tr>
				<td align="center"><%=i+1 %></td>
				<td>
					<b style="color: <%=colors[i]%>"><%=colors[i] %></b>	
				</td>
				
			</tr>
			
		<%}
		%>
	</table>
</body>
</html>