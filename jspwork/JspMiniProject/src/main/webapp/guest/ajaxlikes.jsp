<%@page import="org.json.simple.JSONObject"%>
<%@page import="netscape.javascript.JSObject"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// num을 읽기
String num=request.getParameter("num");

// dao 호출
GuestDao dao=new GuestDao();

// num에 해당하는 chu  증가
dao.updateChu(num);

// 증가된 chu값을 json 형식으로 변환
int chu=dao.getData(num).getChu();

// 무조건 json으로만 보낼 수 있다.
JSONObject ob=new JSONObject();
ob.put("chu",chu);


%>

<%=ob.toString()%>