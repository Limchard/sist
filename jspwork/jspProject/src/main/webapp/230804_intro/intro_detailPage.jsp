<%@page import="java.text.NumberFormat"%>
<%@page import="model.intro.IntroDto"%>
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

<%

String num=request.getParameter("num");
IntroDao dao=new IntroDao();
IntroDto dto=dao.getData(num);

%>

</head>
<body>
	<table class="table table-bordered" style="width: 300px">
		<tr style="width: 100px;" align="center" valign="middle" >
			<th colspan="2" style="width: 200px;"><%=dto.getName() %>님의 자기소개</th>
		</tr>
		<tr></tr>
		<tr align="center" valign="middle" >
			<th>이름</th>
			<td><%=dto.getName() %></td>
		</tr>
		<tr align="center" valign="middle" >
			<th>지역</th>
			<td><%=dto.getCity() %></td>
		</tr>
		<tr align="center" valign="middle" >
			<th>전화번호</th>
			<td><%=dto.getHp() %></td>
		</tr>
		<tr align="center" valign="middle" >
			<th>혈액형</th>
			<td><%=dto.getBlood() %></td>
		</tr>
		<tr align="center" valign="middle" >
			<th>가입일</th>
			<td><%=dto.getGaipday() %></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-success" onclick="history.back()">돌아가기</button>
			</td>
		</tr>
		
	</table>
</body>
</html>