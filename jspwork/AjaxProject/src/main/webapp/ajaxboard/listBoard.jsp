<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="db.ajaxboard.AjaxBoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.ajaxboard.AjaxBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	AjaxBoardDao db=new AjaxBoardDao();
	ArrayList<AjaxBoardDto> list=db.getAllDatas();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	JSONArray arr=new JSONArray();
	for(AjaxBoardDto dto:list){
		JSONObject ob=new JSONObject();
		ob.put("num", dto.getNum()); // key값은 무조건 문자열 형태이다.
		ob.put("writer", dto.getWriter());
		ob.put("subject", dto.getSubject());
		ob.put("story", dto.getStory());
		ob.put("avata",dto.getAvata());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);
		
	}
%>

<%=arr.toString() %>