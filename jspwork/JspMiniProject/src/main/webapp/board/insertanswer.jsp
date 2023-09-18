<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="data.dao.SmartAnswerDao"></jsp:useBean>
<jsp:useBean id="dto" class="data.dto.SmartAnswerDto"></jsp:useBean>

<jsp:setProperty property="*" name="dto"/>

<%
dao.insertSmartAnswer(dto);
%>

