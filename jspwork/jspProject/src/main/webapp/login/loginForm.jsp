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

<style type="text/css">
	div.loginform{
		width: 500px;
		margin-top: 100px;
		margin-left: 200px;
		
	}
</style>
</head>
<%
// 세션으로부터 id와 savechk값 얻어야 합니다. 
String myid=(String)session.getAttribute("idok"); // idok에 대한 초기 선언일 뿐이다. idok에 대해 크게 생각하지 말자 
String saveid=(String)session.getAttribute("saveok"); // saveok에 대한 초기 선언일 뿐이다. 크게 생각하지 말자.

boolean save=true;
if(saveid==null){
	myid=""; // 아이디 저장을 체크하지 않을 경우 아이디 없애는 것. 
	save=false; // 체크하지 않을 경우 false -> 그 이외에는 초기값이 ture니까 아이디가 표시된다.
} 

%>
<body>
	<div class="loginform">
		<form action="loginAction.jsp" method="post">
			<input type="text" name="id" style="width: 200px;" class="form-control" placeholder="로그인할아이디" required="required" value="<%=myid%>">
			<br>
			<input type="password" name="pass" style="width: 200px;" class="form-control" placeholder="비밀번호입력" required="required">
			<br>
			<button type="submit" class="btn btn-outline-success" style="width: 200px;">login</button>
			<br>
			<label><input type="checkbox" name="savechk" <%=save?"checkced":"" %>>아이디저장</label>
			
		</form>
	</div>
</body>
</html>