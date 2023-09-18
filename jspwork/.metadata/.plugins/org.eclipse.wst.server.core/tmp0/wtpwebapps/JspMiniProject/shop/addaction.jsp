<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	
	<%
	
	// 업로드 경로
	String uploadPath=getServletContext().getRealPath("/shopsave");
	System.out.println(uploadPath);
	
	//업로드 이미지 사이즈
	int uploadSize=1024*1024*5; // 5MB
	
	MultipartRequest multi=null;
	
	
	
	
	
	try{
		multi=new MultipartRequest(request,uploadPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
		/* new DefaultFileRenamePolicy() : 파일명이 겹칠 시 뒤에 1,2,3... 을 자동으로 붙여 생성해주는 것*/	
		
		String sangpum=multi.getParameter("sangpum");
		String category=multi.getParameter("category");
		String ipgoday=multi.getParameter("ipgoday");
		int price=Integer.parseInt(multi.getParameter("price"));
		String photo=multi.getFilesystemName("photo"); 
	
		// dao 선언
		ShopDao dao=new ShopDao();
		
		// dto에 데이터 넣기
		ShopDto dto=new ShopDto();
		
		dto.setSangpum(sangpum);
		dto.setCategory(category);
		dto.setIpgoday(ipgoday);
		dto.setPrice(price);
		dto.setPhoto(photo);
		
		// db에 추가 
		dao.insertShop(dto);
		
		// 상품 목록으로 이동
		response.sendRedirect("../index.jsp?main=shop/addform.jsp");
		
	} catch(Exception e){
		
		System.out.println("업로드 오류"+e.getMessage());
		
	}
	
	%>
	
</body>
</html>