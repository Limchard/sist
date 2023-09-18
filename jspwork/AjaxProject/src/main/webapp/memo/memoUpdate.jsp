<%@page import="db.memo.MemoDto"%>
<%@page import="db.memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	MemoDao dao=new MemoDao();	

	String num=request.getParameter("unum");
	String writer=request.getParameter("uwriter");
	String story=request.getParameter("ustory");
	String avata=request.getParameter("uavata");
	
	MemoDto dto=new MemoDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setStory(story);
	dto.setAvata(avata);
	
	dao.updateMemo(dto);
	
%>