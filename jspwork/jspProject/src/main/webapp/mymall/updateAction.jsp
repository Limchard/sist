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
	request.setCharacterEncoding("utf-8");

	//data 읽기
	String no=request.getParameter("no");
	String sangpum=request.getParameter("sangpum");
	String price=request.getParameter("price");
	String photo=request.getParameter("photo");
	String ipgoday=request.getParameter("ipgoday");
	
	// dto에 담기
	mallDto dto=new mallDto();
	dto.setNo(no);
	dto.setSangpum(sangpum);
	dto.setPrice(price);
	dto.setPhoto(photo);
	dto.setIpgoday(ipgoday);
	
	mallDao dao=new mallDao();
	dao.updateMyMall(dto);
	
	response.sendRedirect("list.jsp");
			



%>

	
</body>
</html>