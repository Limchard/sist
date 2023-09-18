<%@page import="model.myteam.TeamDao"%>
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
	<!--1. deleteMyTeam.jsp 만든다
		2. 리스트의 삭제버튼에 경로 지정한다.
		3. 삭제메서드 만든다.(deleteMyTeam)
		4. deleteMyTeam.jsp에서 삭제 처리한 후 목록으로 이동한다. -->
		
	<%
	// 삭제 메서드 호출
	String num=request.getParameter("num");
	TeamDao dao=new TeamDao();
	dao.deleteMyTeam(num);
	
	// list로 이동
	response.sendRedirect("list.jsp");
	%>
		
</body>
</html>