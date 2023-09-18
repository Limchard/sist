<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.simpleguest.SimpleGuestDao"%>
<%@page import="db.simpleguest.SimpleGuestDto"%>
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

<%
SimpleGuestDao dao=new SimpleGuestDao();
ArrayList<SimpleGuestDto> list=dao.getAllData();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일");

%>

</head>
<body>
	<div style="margin: 50px; 50px;">
    <input type="button" value="글쓰기" class="btn btn-outline-success"
    onclick="location.href='insertForm.jsp'"><br><br>
	
	<%
	for (int i = 0; i < list.size(); i++) {
		SimpleGuestDto dto = list.get(i);
		int no=list.size()-i;
	%>
	
	<table class="table" style="width: 500px">

		<tr>
			<td style="width: 80px;"><b>No. <%=no%></b></td>
			<td style="width: 160px;"><%=dto.getNick()%></td>
			<td align="right" style="color: gray; font-size: 0.8em"><%=sdf.format(dto.getWriteday())%></td>
		</tr>
		<tr>
			<td style="width: 100px;"><img src="../img/avata/b<%=dto.getImage()%>.png"></td>
			<td colspan="2"><pre><%=dto.getStory()%></pre></td>
		</tr>
		
	</table>
	<div style="text-align: right">
		<input type="button" value="수정" class="btn btn-outline-info" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">
		<input type="button" value="삭제" class="btn btn-outline-danger" onclick="location.href='deleteForm.jsp?num=<%=dto.getNum()%>'">
	</div>
	

	<%
	}
	%>

	</div>
</body>
</html>