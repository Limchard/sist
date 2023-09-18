<%@page import="data.dto.TourSpotDto"%>
<%@page import="data.dto.CourseDto"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.RecomCourseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
<%
// dao 호출
RecomCourseDao RecomCourseDao = new RecomCourseDao();

String name = request.getParameter("name");

// name값을 받아서 HashMap 정보 출력 메서드 호출 
List<CourseDto> recomlist = RecomCourseDao.getRecomCourseName(name);

String [] seq=new String[recomlist.size()];

for(int i=0;i<recomlist.size();i++){
	CourseDto cdto=recomlist.get(i);
	seq[i]=cdto.getTour_seq();
}

for(int i=0;i<recomlist.size();i++){
	
	List<TourSpotDto> tourspotlist=RecomCourseDao.getCourse(seq[i]);
	TourSpotDto tdto=tourspotlist.get(i);
	
	System.out.println(tdto.getName());
}


%>

<style type="text/css">

/* @import url(common.css); */
.banner { /*배너전체영역*/
	position: relative;
	width: 1100px;
	height: 300px;
	/*background:yellow;*/
}

.banner .ban { /*슬라이드영역*/
	width: 1000px; /*보여주는 폭을 줄이고자 할때 가로폭을 맞춰서 줄여줌*/
	height: 500px;
	overflow: hidden;
	padding-top: 35px;
	margin-left: 50px;
	/*background:orange;	*/
}

.banner .ban ul {
	width: 4600px; /* 총길이=230*18+여백포함 */
	position: relative;
	left: -255px;
	/*html의 이미지목록에서 끊기지 않고 이어지는 이미지를 위해서 맨 마지막 이미지를 맨 앞에 두었지만,
	실행화면에 보이는 이미지는 첫번째 이미지어야 하므로, 
	맨 마지막 이미지를 맨앞에 넣어둔것을 다시 왼쪽으로(left:-255px) 밀어둠 */
}

.banner ul li:hover {
	border-color: #cc0000;
}

.banner ul{
	list-style: none;
}

/*좌우버튼*/
.ban_left {
	position: absolute;
	top: 80px;
	left: 25px;
	cursor: pointer;
}

.ban_right {
	position: absolute;
	top: 80px;
	right: 25px;
	cursor: pointer;
}

.ban_btn span {
	display: inline-block;
	width: 17px;
	height: 27px;
}


/* div.detailbg{
	background-color: #d2d2d2;
	width: 1200px;
	height: 1500px;
} */

.bi{
	font-size: 24px;
	color: #2962FF;
}

img.spotimg{
	float: left;
	margin-right: 25px;
	width: 300px;
	height: 300px;
	cursor: pointer;
}

div.ban{
	position: relative;
}

span.photoname{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate( -50%, -50% );
	color: black;
}

</style>

<title>Insert title here</title>
</head>
<body>
<%-- 
	<div class="detailbg">
		<div class="banner">
			<div>
				<h4><%=name %> 테마</h4>
			</div>
		
			<div class="ban">
				<!--좌우로 끊기지 않고 이미지를 이어지게 하려면 맨뒤의 이미지를 맨 앞으로 배치함-->
				<ul>
				
	
					
					<li>
					<img class="spotimg" src="no_image/<%=map.get("photo") %>" alt="" photo=<%=map.get("photo")%>>
					<span class="photoname"><%=map.get("name") %></span>
					</li>			
					
					
				</ul>
			</div>
			

			<div class="ban_btn">
				<span class="ban_left"><span class="indent"><i class="bi bi-caret-left-fill"></i></span></span> 
				<span class="ban_right"><span class="indent"><i class="bi bi-caret-right-fill"></i></span></span>
			</div>
		</div>

	</div>


	<script type="text/javascript">
		$(document).ready(function() {

			//다음보기
			$(".ban_btn .ban_right").click(function() {

				$(".ban ul").stop(true, true).animate({
					marginLeft : "-=255px"
				}, 500, function() {
					$(".ban ul li:first-child").appendTo(".ban ul"); //첫번째 이미지 맨뒤로 이동
					$(this).css({
						marginLeft : "0px"
					}); //최종목적지
				});
			});

			//이전보기
			$(".ban_btn .ban_left").click(function() {

				$(".ban ul").stop(true, true).animate({
					marginLeft : "+=255px"
				}, 1000, function() {
					$(".ban ul li:last-child").prependTo(".ban ul"); //첫번째 이미지 맨뒤로 이동
					$(this).css({
						marginLeft : "0px"
					}); //최종목적지
				});
			});
		});
			
	</script>
 --%>
</body>
</html>