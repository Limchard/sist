<%@page import="db.simpleboard.SimpleBoardDto"%>
<%@page import="db.simpleboard.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<%

	String num=request.getParameter("num");
	
	SimpleBoardDao dao=new SimpleBoardDao();
	SimpleBoardDto dto=dao.getBoard(num);

	%>


<body>
	<div style="margin: 30px 30px; width: 400px;">
		<form action="updateaction.jsp" method="post">
		<input type="hidden" name="num" value="<%=num%>">
			<table class="table table-bordered">
				<caption align="top" style="font-size: 1.5em;"><b><i class="bi bi-pencil-square">글수정</i></b></caption>
				<tr>
					<th style="background-color: #FFE4E1">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control" required="required" autofocus="autofocus" style="width: 150px;" value="<%=dto.getWriter()%>">
					</td>
				</tr>
				
				<tr>
					<th style="background-color: #FFE4E1">제목</th>
					<td>
						<input type="text" name="subject" class="form-control" required="required" style="width: 150px;" value="<%=dto.getSubject()%>">
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<textarea style="width: 400px; height: 200px;" class="form-control" required="required" name="story"><%=dto.getStory() %></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="image" src="../img/submit.png" style="width: 70px;">
						<!-- type이 image 도 기본이 submit이다. -->
						<input type="image" src="../img/list.png" style="width: 70px;" onclick="location.href='boardlist.jsp';return false;">
						<!-- return false 안하면 submit하고 onclick이 겹쳐서 둘 다 실행되거나 오류가 난다. -->
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>