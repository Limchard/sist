<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="db.ajaxboard.AjaxBoardDto"%>
<%@page import="db.ajaxboard.AjaxBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String num=request.getParameter("num");

	AjaxBoardDao dao=new AjaxBoardDao();
	AjaxBoardDto dto=dao.getData(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	JSONObject ob=new JSONObject();
	
		ob.put("num", dto.getNum()); // key값은 무조건 문자열 형태이다.
		ob.put("writer", dto.getWriter());
		ob.put("subject", dto.getSubject());
		ob.put("story", dto.getStory());
		ob.put("avata",dto.getAvata());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		

%>

<%=ob.toString() %>
