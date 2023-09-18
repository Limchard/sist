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
	
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String cbsave=request.getParameter("cbsave"); // 체크안하면 null
	
	
	MemberDao dao=new MemberDao();
	boolean flag=dao.isIdPass(id, pass);
	
	// id와 비밀번호가 맞으면 3개의 세션을 저장하고 loginmain으로 이동
	if(flag){
		session.setMaxInactiveInterval(60*60*3);
		session.setAttribute("loginok", "yes");
		session.setAttribute("myid", id);
		session.setAttribute("saveok", cbsave==null?null:"yes");
		
		// 로그인메인으로 이동
		response.sendRedirect("../index.jsp?main=login/loginmain.jsp");
	} else {%>
	<script type="text/javascript">
		alert("아이디와 비밀번호가 맞지 않습니다.");
		history.back();
	</script>
	<%}
			
	
	
	%>
</body>
</html>