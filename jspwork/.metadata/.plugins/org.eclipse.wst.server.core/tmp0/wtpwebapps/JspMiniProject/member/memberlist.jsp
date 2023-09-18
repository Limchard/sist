<%@page import="data.dto.MemberDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<%
MemberDao dao=new MemberDao();

List<MemberDto> list=dao.getAllMembers();

SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
int no=1;

%>

</head>
<body>

	<table class="table table-bordered" style="width: 1000px;">
		<caption><B>전체 회원 목록</B></caption>
		<tr style="background-color: pink;" align="center">
			<th width="50">번호</th>
			<th width="100">회원명</th>
			<th width="120">아이디</th>
			<th width="200">핸드폰</th>
			<th width="350">주소</th>
			<th width="250">이메일</th>
			<th width="150">가입일</th>
			<th width="150">삭제</th>
		
		</tr>
			
		<%
		for(MemberDto dto:list){ //for~each문 사용.    %> 
			
			<tr align="center">
				<td><%=no++ %></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getId() %></td>
				<td><%=dto.getHp() %></td>
				<td><%=dto.getAddr() %></td>
				<td><%=dto.getEmail() %></td>
				<td><%=sdf.format(dto.getGaipday()) %></td>
				<td>
					<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href=''">삭제</button>
				</td>
			</tr>
			
			
			
		<%}
			
			
		%>
			
	</table>
	
</body>
</html>