<%@page import="model.sinsang.SinsangDto"%>
<%@page import="java.util.Vector"%>
<%@page import="model.sinsang.SinsangDao"%>
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
<%
	SinsangDao dao=new SinsangDao();
	Vector<SinsangDto> list=dao.getAllDatas();

%>
<body>
<!-- <a href=>데이터 추가</a> -->
<button type="button" class="btn btn-info" onclick="location.href='insertForm.jsp'">데이터 추가</button>
<br>
<table class="table table-bordered" style="width: 700px">
	<tr class="table-success" style="text-align: center;">
		<th width="60">번호</th>
		<th width="100">이름</th>
		<th width="250">주소</th>
		<th width="150">날짜</th>
		<th width="150">편집</th>
	</tr>

<%
	for(int i=0;i<list.size();i++){
		SinsangDto dto=list.get(i);
	 	%>
	 	
	 	<tr>
	 		<td><%=i+1 %></td>
	 		<td><%=dto.getName() %></td>
	 		<td><%=dto.getAddr() %></td>
	 		<td><%=dto.getSdate() %></td>
	 		<td>
	 			<button type="button" class="btn btn-info bnt-xs" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
	 			<button type="button" class="btn btn-danger bnt-xs" onclick="location.href='delete.jsp?num=<%=dto.getNum()%>'">삭제</button> <!-- ? 는 연결 연산자 -->
	 		</td>
	 	</tr>
	<%}

%>

</table>


</body>
</html>