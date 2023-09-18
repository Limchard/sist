<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.quiz.QuizBoardDao"%>
<%@page import="java.util.List"%>
<%@page import="db.quiz.QuizBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<%
	QuizBoardDao dao=new QuizBoardDao();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");

//페이징처리하기
int totalCount=dao.getTotalCount(); // 전체 갯수
int totalPage; // 총 페이지 수
int startPage; // 각 블럭에서 보여질 시작 페이지
int endPage; // 각 블럭에서 보여질 끝 페이지
int startNum; // db에서 가져올 글의 시작번호 (MySQL에서는 첫 글이 0번, Oracle에서는 1번)
int perPage=20; // 한페이지당 몇개의 게시글을 보여줄 것인가? // 선생님 표현 : 한페이지당 몇개의 글을 보여줄 것인가? 
int perBlock=3; // 한 페이지당 몇개의 블락 no을 보여줄 것인가? //선생님 표현 : 한 블럭당 몇개의 페이지를 보여줄 것인가? 보통 페이지 아래에 1~숫자... 다음 페이지  
int currentPage; // 현재페이지 -> 몇번 block No에 있는가? 
int no; // 각페이지당 출력할 시작번호



//현재 페이지에대한 설정
//현재 페이지 읽기(단 null일 경우는 1페이지로 준다)
if(request.getParameter("currentPage")==null){
     	currentPage=1;
}  else {
        currentPage=Integer.parseInt(request.getParameter("currentPage")); // getParameter로 받을때에는 무조건 문자열로 불러온다. 계산을 해야하기 때문에 형변환 해준다.
}     
 // 총페이지수 구하기
 // 총 글의 갯수/한페이지당 보여질 갯수로 나눔(7/5=1) -> 나머지가 1개라도 있으면 1page를 추가한다는 의미다.
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
	
 // 각 블럭당 보여야 할 시작페이지 
 // perBlock=5일 경우는 현재페이지가 1~5 까지, 시작이 1, 끝이 5라는 뜻!
 // 현재페이지가 13일경우 시작이 11, 끝이 15 라는 것을 지정해주는 수식! // block 넘버를 뜻한다. 
	startPage=(currentPage-1)/perBlock*perBlock+1; // 현재 페이지에 표현되는 시작 block number	
  
	endPage=startPage+perBlock-1; // 현재 페이지에 표현되는 끝 block number
 
 // 만약에 총page가 23까지 있으면 마지막 블럭은 25가 아니라 23이다. 
   if(endPage>totalPage)
     	endPage=totalPage;

 // 각 페이지에서 보여질 시작번호
 // 1페이지 : 0, 2페이지 : 5, 3페이지 : 10....
 startNum=(currentPage-1)*perPage;
 
 // 각 페이지당 출력할 시작번호 구하기 no	
 // 예) 총 글 갯수가 23이면, 1페이지 넘버링 시작은 23이다. 2페이지는 18, 3페이지는 13...
	// 출력시 1 감소하면서 출력
	no=totalCount-(currentPage-1)*perPage; // 내림차순이기때문에 쓴 것이다.	
 
 // 페이지에서 보여질 글만 가져오기
	List<QuizBoardDto> list=dao.getPagingList(startNum, perPage);
	
%>

<style type="text/css">

.bi{
	margin-left: 10px;
	font-size: 1.5em;
	float: right;
}

.bi-pencil-square{
	color: blue;
}

.bi-images{
	color: green;
}

</style>

</head>
<body>
<div>
	<div class="table table-bordered" style="width: 600px;">
		<h4 style="margin: 10px;">총 <%=totalCount %>개의 게시글이 있습니다.</h4>
		<i class="bi bi-list-ul" onclick="location.href='quizlist.jsp'"></i>
		<i class="bi bi-pencil-square" onclick="location.href='insertform.jsp'"></i>	
		<br><br>
		<%
		for(int i=0;i<list.size();i++){
			QuizBoardDto dto=list.get(i);
			%>
			
			<div style="float: left; margin-left: 20px;">
				<img src="<%=dto.getImgname() %>" style="width: 100px;"><br>
				<%=dto.getWriter() %><br>
				<%=dto.getTitle() %><br>
				조회수: <%=dto.getReadcount() %><br>
				
			</div>
			<%
			if(i%5==4){
				%><br><br><br><br><br><br><br><br><br><br><br><br><br><%
			}
			%>
		<%}
		
		
		%>

	</div>
</div>
</html>