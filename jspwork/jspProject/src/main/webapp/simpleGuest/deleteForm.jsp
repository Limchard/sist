
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
String pass=request.getParameter("pass");
System.out.println(num);

%>
</head>
<body>
	<form action="deleteAction.jsp" method="post">
	<input type="hidden" name="num" value="<%=num %>">
	<table class="table table-bordered" style="width: 150px">
		<tr class="table">
			<th>비밀번호를 입력하세요</th>
		</tr>
		<tr>
			<td>
				<input type="password" name="pass">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="확인" class="btn btn-outline-danger" style="text-align: center">
			</td>
		</tr>
	</table>
	</form>
	
</body>
</html>