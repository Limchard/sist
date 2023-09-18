<%@page import="model.intro.IntroDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.intro.IntroDao"%>
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
	IntroDao dao=new IntroDao(); // method를 생성시기 위해 가져온다.
	ArrayList<IntroDto> list=dao.getIntro();
	
%>
<button type="button" class="btn btn-success" onclick="location.href='intro_addForm.jsp'" style="width: 100px; height: 50px;">인원 추가</button>
<br>
<table class="table table-bordered" style="width: 700px;">
	<tr align="center" class="table-success" >
		<th width="60">번호</th>
		<th width="80">이름</th>
		<th width="80">혈액형</th>
		<th width="80">연락처</th>
		<th width="160">거주지</th>
		<th width="160">가입일</th>
		<th width="160">수정|삭제</th>
	</tr>

<%
	for(int i=0;i<list.size();i++){ // 컬렉션일때 size() 사용.
		%>
		<tr>
			<td align="center"><%=i+1 %></td>
			<td align="center" onclick="location.href='detailPage.jsp'?num<%=list.get(i).getNum()%>"><%=list.get(i).getName() %></td>
			<td align="center"><%=list.get(i).getBlood() %></td>
			<td align="center"><%=list.get(i).getHp() %></td>
			<td align="center"><%=list.get(i).getCity() %></td>
			<td align="center"><%=list.get(i).getGaipday() %></td>
			<td>
				<button type="button" class="btn btn-warning" onclick="location.href='intro_updateForm.jsp?num=<%=list.get(i).getNum()%>'">수정</button>
				<button type="button" class="btn btn-success" onclick="location.href='intro_delete.jsp?num=<%=list.get(i).getNum()%>'">삭제</button>
			</td>
		</tr>
	<%}
%>
</table>
</body>
</html>