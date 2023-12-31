<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	
	// 데이타 읽어서 Dto에 넣기
	MemberDto dto=new MemberDto();
	
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String pass=request.getParameter("pass");
	String hp=request.getParameter("hp");
	String addr=request.getParameter("addr");
	String email=request.getParameter("email1")+"@"+request.getParameter("email2");
	
	dto.setNum(num);
	dto.setName(name);
	dto.setPass(pass);
	dto.setHp(hp);
	dto.setAddr(addr);
	dto.setEmail(email);
	
	
	// dao 선언 후 insert 호출 
	MemberDao dao=new MemberDao();
	dao.updateMember(dto);
	
	// gaipsuccess 페이지로 이동 
	response.sendRedirect("../index.jsp?main=member/myinfo.jsp"); 
	
	%>
</body>
</html>