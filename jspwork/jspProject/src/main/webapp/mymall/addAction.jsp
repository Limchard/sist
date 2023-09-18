<%@page import="model.mymall.mallDao"%>
<%@page import="model.mymall.mallDto"%>
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
	// 한글 엔코딩(한글 깨지기 때문)
	request.setCharacterEncoding("utf-8");
	
	// data 읽기
	
	String sangpum=request.getParameter("sangpum"); // Form에 있는 name값을 가져오는것. 그래야 입력값을 받을 수 있으니까!!
	String photo=request.getParameter("photo");
	String price=request.getParameter("price");
	String ipgoday=request.getParameter("ipgoday");
	
	// dto에 담기
	mallDto dto=new mallDto();
	dto.setSangpum(sangpum);
	dto.setPhoto(photo);
	dto.setPrice(price);
	dto.setIpgoday(ipgoday);
	
	// dao 선언
	mallDao dao=new mallDao();
	
	// insert	
	dao.insertMyMall(dto);
	
	// page 변경
	response.sendRedirect("list.jsp");
	
	%>
</body>
</html>