<%@page import="db.simpleguest.SimpleGuestDto"%>
<%@page import="db.simpleguest.SimpleGuestDao"%>
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
	// 엔코딩
	request.setCharacterEncoding("utf-8");
	
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	System.out.println(pass);
	System.out.println(num);
	
	SimpleGuestDao dao=new SimpleGuestDao();
	
	
	if(dao.isEqualPass(num, pass)){
		dao.deleteGuest(num);
		
		response.sendRedirect("guestList.jsp");
		
	}else{
		%>
		
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.");
			history.back();
		</script>
		 
	<%}
	%>
</body>
</html>