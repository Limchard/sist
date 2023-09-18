<%@page import="model.intro.IntroDao"%>
<%@page import="model.intro.IntroDto"%>
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
	request.setCharacterEncoding("utf-8");
	
	// Form에 입력된 값 읽기
	String name=request.getParameter("name");
	String blood=request.getParameter("blood");
	String hp1=request.getParameter("hp1");
	String hp2=request.getParameter("hp2");
	String hp3=request.getParameter("hp3");
	String hp=(hp1+"-"+hp2+"-"+hp3);
	String city=request.getParameter("city");
	
	// dto에 담기 
	IntroDto dto=new IntroDto();
	dto.setName(name);
	dto.setBlood(blood);
	dto.setHp(hp);
	dto.setCity(city);
	
	// dao 선언
	IntroDao dao=new IntroDao();
	dao.insertIntro(dto);
	
	// page 이동
	response.sendRedirect("list.jsp");
	
	
	
	%>
</body>
</html>