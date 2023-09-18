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
	<h2>JSP는 HTML5구조에서 자바코드를 사용할수 있는 서버언어이다.</h2>
	<h3>Servlet은 확장자가 java이며 자바클래스 구조에 <br> html.css.js도 사용할 수 있다.</h3>
	<h3>jsp 주석은 2가지 가능하다. </h3>
	<!-- 주석1 : 소스보기에서는 보인다. -->
	<%-- jsp주석: 소스보기에서도 안보인다.  --%>
<%-- 	<%=name %>님의 나이는 <%=age %>세 입니다. <!-- 여기서는 못읽는다.  --> --%>
	
	<%! /* 선언문! */
	// 스크립트릿(scriptlet)
	// 여기서 선언하는 변수는 지역변수로 등록이 된다.
	// 그래서 이곳의 변수를 html에서 사용하려면
	// 선언한 곳보다 아래에서 사용 가능하다.
	// 주석도 자바... 자바코드도 사용이 가능하다.
	int age=20;
	String name="김영환";
	
	// 메서드
	public String getCheck(){
		
		if(age>20){
			return "성인입니다.";
		} else {
			return "미성년자 입니다.";
		}
	}
	
	%>
	
	<%-- <%=name %>님의 나이는 <%=age %>세 입니다. --%>
	
	<h3 class='alert alert-info'>멤버변수 출력 </h3>
	<b>이름: <%=name %></b><br> <!-- 표현식  -->
	<b>나이: <%=age %>세(<%=getCheck() %>)</b><br>
</body>
</html>