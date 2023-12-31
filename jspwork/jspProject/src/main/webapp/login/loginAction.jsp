<%@page import="idx.model.idxDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String save=request.getParameter("savechk");
	
	// 아이디와 비밀번호가 맞는지 확인 
	idxDao db=new idxDao();
	boolean flag=db.isLogin(id, pass);
	
	// 맞으면 세션 지정 후 loginMain으로 이동
	if(flag){
		// 세션 지정. 
		// 로그인 중인지 알 수 있는 세션 저장
		session.setAttribute("loginok", "yes");
		
		// 아이디 세션 저장
		session.setAttribute("idok", id);
		
		// savecheck값 세션에 저장.. 체크하면 값으로 on이 넘어온다. 안하면 null이 넘어온다. 	
		session.setAttribute("saveok", save); // value값이 없으면 on,null 등으로 표현된다.
		
		// session 유지시간 저장 
		session.setMaxInactiveInterval(60*60*8); // 8시간동안 유지(생략시 30분)
		
		// 로그인 메인으로 이동 
		response.sendRedirect("loginMain.jsp");
		
	} else { %>
		<script type="text/javascript">
			alert("아이디와 비밀번호가 맞지 않습니다.");
			history.back();
		</script>	
	<%}
			
	%>
</body>
</html>