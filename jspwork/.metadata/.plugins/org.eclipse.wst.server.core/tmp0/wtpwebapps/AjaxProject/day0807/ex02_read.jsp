<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	
	// front 에서 백엔드로 값을 얻어옴 
	String code=request.getParameter("s_code");
	String name=request.getParameter("s_name");
	String price=request.getParameter("s_price");
	String color=request.getParameter("color");
	
	JSONObject ob=new JSONObject(); // 위에서 front에서 백엔드로 얻어온 값을 JSONObject를 통해 다시 front로 보낸다.
	ob.put("code",code);  // obput("받아오는값을 다시 지정해준다 ",받아오는 값)
	ob.put("name",name);
	ob.put("price",price);
	ob.put("color",color);
	
	%>

	<%=ob.toString() %> 