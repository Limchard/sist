<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<%
// 절대경로 잡기
String root=request.getContextPath();
String myid=(String)session.getAttribute("myid");
String loginok=(String)session.getAttribute("loginok");

%>

	<link rel="stylesheet" type="text/css" href="<%=root %>/menu/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="<%=root %>/menu/css/menu.css">
    
	<script type="text/javascript" src="<%=root %>/menu/js/jquery.js"></script>
	<script type="text/javascript" src="<%=root %>/menu/js/function.js"></script>

<title>Insert title here</title>

</head>
<body>

<div id="wrap">
	<header>
		<div class="inner relative">
			<a class="logo" href="*"></a>
			<a id="menu-toggle" class="button dark" href="#"><i class="icon-reorder"></i></a>
			<nav id="navigation">
				<ul id="main-menu">
					<li class="current-menu-item"><a href="*">Home</a></li>
					<li class="parent">
						<a href="#">about 회원</a>
						<ul class="sub-menu">
							<li><a href="<%=root %>/index.jsp?main=member/memberform.jsp"><i class="icon-credit-card"></i>회원가입</a></li>
							<!-- 2.메뉴: 회원목록: 관리자만 보이게(admin) -->
							
							<% System.out.println(myid);
							if(loginok!=null&&myid.equals("admin")){%>
								
								<li><a href="<%=root %>/index.jsp?main=member/memberlist.jsp"><i class="bi bi-person-lines-fill"></i>회원목록</a></li>
								
							<%}
							%>
							
							<li><a href="<%=root %>/index.jsp?main=member/myinfo.jsp"><i class="bi bi-person-exclamation"></i>나의정보</a></li>

						</ul>
					</li>
					<li><a href="<%=root %>/index.jsp?main=guest/guestlist.jsp">회원 방명록</a></li>
					<li class="parent">
						<a href="#">고객의 소리</a>
						<ul class="sub-menu">
							<li><a href="<%=root %>/index.jsp?main=board/boardlist.jsp">스마트게시판</a></li>
						</ul>
					</li>
					<li><a href="<%=root %>/index.jsp?main=load/map.jsp">찾아오시는길</a></li>
					<!-- 장바구니 -->
					<li class="parent">
						<a href="#">쇼핑몰</a>
						<ul class="sub-menu">
							<%if(loginok!=null&&myid.equals("admin")){%>
								
								<li><a href="<%=root %>/index.jsp?main=shop/addform.jsp"><i class="bi bi-person-lines-fill"></i>상품등록</a></li>
								
							<%}
							%>
							
							<li><a href="<%=root %>/index.jsp?main=shop/shoplist.jsp"><i class="bi bi-person-exclamation"></i>상품목록	</a></li>

						</ul>
					</li>
					
				</ul>
			</nav>
			<div class="clear"></div>
		</div>
	</header>	
</div>     


<!-- head, footer, side 등을 남겨놓고 main만 바꾸기 위해서 이런식으로 모두 링크 걸어서 진행해야 한다.(절대경로도 넣어야 한다.) -->
<%-- 	<a href="<%=root %>/index.jsp">메인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=root %>/index.jsp?login/loginmail.jsp">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=root %>/index.jsp?main=member/memberform.jsp">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=root %>/index.jsp?main=guest/guestlist.jsp">방명록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=root %>/">Q & A</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=root %>/">회원게시판</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=root %>/">Shop</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
</body>
</html>