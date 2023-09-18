<%@page import="db.ajaxboard.AjaxBoardDao"%>
<%@page import="db.ajaxboard.AjaxBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

// 엔코딩 
request.setCharacterEncoding("utf-8");



// 입력될 변수 호출
String writer=request.getParameter("writer");
String subject=request.getParameter("subject");
String story=request.getParameter("story");
String avata=request.getParameter("avata");

AjaxBoardDto dto=new AjaxBoardDto();
dto.setWriter(writer);
dto.setSubject(subject);
dto.setStory(story);
dto.setAvata(avata);

AjaxBoardDao dao=new AjaxBoardDao();
dao.insertBoard(dto);


%>