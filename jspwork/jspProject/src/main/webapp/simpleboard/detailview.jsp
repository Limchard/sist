<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.simpleboard.SimpleBoardDto"%>
<%@page import="java.util.List"%>
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
<style type="text/css">
	span.day{color: #ccc; font-size: '0.8em;'}

</style>
</head>
<body>
<jsp:useBean id="dao" class="db.simpleboard.SimpleBoardDao"></jsp:useBean>

<%

// num을 읽는다.

String num=request.getParameter("num");

//dao 선언
// 조회수 1증가
dao.updateReadCount(num);

// dto
SimpleBoardDto dto=dao.getBoard(num);

// 날짜형식
SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm");


%>

<div style="margin: 30px 30px;">
	<table class="table table-bordered">
		<caption align="top"><b><%=dto.getSubject() %></b></caption>
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span class="day"><%=sdf.format(dto.getWriteday()) %>
					&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount() %>
				</span>
			</td>
		</tr>
	
		<tr height="150">
			<td>
				<%=dto.getStory().replace("\n", "<br>") %>  <!-- pre태그 쓰거나 replace 사용하기.
				db저장 시 <br> 태그가 \n역할을 하도록 지정된다.. 그러므로 출력 시 다시 <br>로 전환된다. -->
			</td>
		</tr>
		
		<tr>
			<td>
				<button type="button" class="btn btn-outline-success" onclick="location.href='addform.jsp'"><i class="bi bi-plus-square">글쓰기</i></button>
				<button type="button" class="btn btn-outline-info" onclick="location.href='boardlist.jsp'"><i class="bi bi-card-list">목록</i></button>
				<button type="button" class="btn btn-outline-warning" onclick="location.href='updatepassform.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-pencil-square">수정</i></button>
				<button type="button" class="btn btn-outline-danger" onclick="location.href='deletepassform.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-trash3">삭제</i></button>
			</td>
		</tr>
	</table>
</div>

</body>
</html>