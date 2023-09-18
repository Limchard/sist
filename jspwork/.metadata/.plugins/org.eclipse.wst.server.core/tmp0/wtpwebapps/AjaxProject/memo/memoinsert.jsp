<%@page import="db.memo.MemoDto"%>
<%@page import="db.memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	MemoDao dao=new MemoDao();
	
	// 엔코딩
	request.setCharacterEncoding("utf-8");
	
	// data 읽기 (writer,story,avata)
	String writer=request.getParameter("writer");
	String story=request.getParameter("story");
	String avata=request.getParameter("avata");
	
	// dto 에 묶기. 다시 setting 해줘야 insert에 값을 담을 수 있다.
	MemoDto dto=new MemoDto();
	dto.setWriter(writer);
	dto.setStory(story);
	dto.setAvata(avata);
	
	// insert 호출ㅇ하여 dto 넣어주기 
	dao.insertMemo(dto);

	
%>