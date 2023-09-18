<%@page import="data.dao.ShopDao"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<style type="text/css">
	div.cart{
		float: right;
		cursor: pointer;
		margin-right: 50px;
	}
	.count{
		width: 30px;
		height: 30px;
		float: right;
		background-color: red;
		color: white;
		border-radius: 30px;
		text-align: center;
		line-height:30px;
		z-index: 10;
		position: relative;
		left: -20px;
		top: 10px;
		font-size: 0.8em;
	}
</style>

<script type="text/javascript">

$(function(){
	$("div.cart").click(function(){
		
		location.href="index.jsp?main=shop/mycart.jsp";
		
	});
	
});


</script>

<title>Insert title here</title>
<%
// 절대경로 잡기
String root=request.getContextPath();


// 로그인세션
String loginok=(String)session.getAttribute("loginok");

// 세션으로부터 아이디를 얻는다 
String myid=(String)session.getAttribute("myid");

// db에 있는 이름 가져온다
MemberDao dao=new MemberDao();
String name=dao.getName(myid);

%>
</head>
<body>
	<a href="<%=root%>" style="color: black;"><img alt="" src="<%=root%>/image/spring/s1.webp" style="width: 70px;"></a>
	JSP & JQuery Mini Project
	
	
<%
// 1.타이틀에 로그아웃시: 로그인버튼   로그인시: 로그아웃버튼
if(loginok==null){%>
	
	<button type="button" class="btn btn-success" style="width: 100px;" onclick="location.href='index.jsp?main=login/loginform.jsp'">Login</button>
	
<%} else {%>
	<b style="font-size: 15px;"><%=name %>님이 로그인 중...</b>
	<button type="button" class="btn btn-danger" style="width: 100px;" onclick="location.href='login/logoutaction.jsp'">Logout</button>
	
<%}

%>
<div class="cart">
	<%
	ShopDao sdao=new ShopDao();
	
	// 장바구니에 몇개다 담겨 있는지 갯수 구해보기
	int cartSize=sdao.getCartList(myid).size();
	
	%>
	<i class="bi bi-cart cartimg" style="font-size: 1.05em;"></i>
	<div class="count"><%=cartSize %></div>
</div>
</body>
</html>