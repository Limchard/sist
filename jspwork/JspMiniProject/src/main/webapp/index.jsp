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
<style type="text/css">
	div.layout{
		/* border: 1px solid gray; */
		position: absolute;
	
	}

	div.title{
		width: 100%;
		height: 80px;
		line-height: 80px;
		font-size: 30px;
		font-family: 'Dongle';
		text-align: center;
	}
	
	div.menu{
		width: 100%;
		height: 80px;
		line-height: 80px;
		font-family: Gowun Dodum;
		text-align: center;
		top: 80px;
	}
	
	div.info{
		width: 180px;
		height: 500px;
		line-height: 10px;
		font-family: Nanum Pen Script;
		font-size: 15pt;
		left: 30px;
		top: 300px;
		padding: 20px 10px;
		border: 5px groove gray;
		border-radius: 30px;
	}
	
	div.main{
		width: 1200px;
		height: 1000px;
		font-size: 13pt;
		font-family: East Sea Dokdo;
		left: 300px;
		top: 200px;
	}
</style>
<%
// 절대경로 잡기
String root=request.getContextPath();

String mainPage="layout/main.jsp"; // 기본 페이지 

// url을 통해서 main값을 얻어서 메인웹페이지에 출력한다.
if(request.getParameter("main")!=null){
	mainPage=request.getParameter("main");
}

%>
</head>
<body>
	<%-- <%=root %> --%>
	
	<div class="layout title">
		<jsp:include page="layout/title.jsp"></jsp:include>
	</div>
	<div class="layout menu">
		<jsp:include page="layout/menu.jsp"></jsp:include>
	</div>
	<div class="layout info">
		<jsp:include page="layout/info.jsp"></jsp:include>
	</div>
	<div class="layout main">
		<jsp:include page="<%=mainPage %>"></jsp:include>
	</div>

	
</body>
</html>