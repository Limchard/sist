<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
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
// db에 저장할 아이디 얻기
String myid=(String)session.getAttribute("myid");

// 실제경로
String realPath=getServletContext().getRealPath("/save");
System.out.println(realPath);

int uploadSize=1024*1024*5;

MultipartRequest multi=null;

try{
	multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());

	//주의 : requset가 아닌 multi 변수로 모든 폼데이터를 읽어야 한다. 
	String content=multi.getParameter("content");
	String photoname=multi.getFilesystemName("photo");

	//num, currentPage 
	String num=multi.getParameter("num");
	String currentPage=multi.getParameter("currentPage"); 
	
	//dao 선언
	GuestDao dao=new GuestDao();
	
	// 기존포토 가져오기
	String old_photo=dao.getData(num).getPhotoname();
	System.out.println(old_photo);
	
	//dto에 저장
	GuestDto dto=new GuestDto();
	dto.setNum(num);
	dto.setMyid(myid);
	dto.setContent(content);
	dto.setPhotoname(photoname==null?old_photo:photoname);

	// update	
	dao.updateGuest(dto);
	
	// 방명록으로 이동..... 현재수정된 페이지 
	response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);

	} catch(Exception e){
	
	} 

%>
</body>
</html>