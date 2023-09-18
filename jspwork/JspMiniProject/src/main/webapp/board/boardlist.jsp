<%@page import="data.dao.SmartAnswerDao"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SmartDao"%>
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
<style>
a:link,a:visited{
	color: black;
	text-decoration: none;
}

a:hover{
	text-decoration: underline;
}

</style>
<script type="text/javascript">

$(function(){
	
	// 전체선택 클릭 시 체크값을 얻어서 모든 체크값에 전달해보자
	$(".alldelcheck").click(function(){
		
		// 전체 체그값 얻기
		var chk=$(this).is(":checked");
		console.log(chk);
		
		// 전체 check값(chk)를 글 앞의 check에 일괄적으로 전달하기 
		$(".delcheck").prop("checked",chk);
		
	});
	
	$("#btndel").click(function(){
		
		// 체크 갯수에 대한 길이 값	
		var len=$(".delcheck:checked").length;
		// alert(len);
		
		if(len==0){
			alert("최소 1개 이상 체크해 주세요")
		} else {
			var a=confirm(len+"개의 글을 삭제하시려면 [확인]을 눌러주세요")
			
			// 체크된 곳의 value값 얻기(num)
			var n="";
			
			$(".delcheck:checked").each(function(idx){
				n+=$(this).val()+",";
			});
			
			// 마지막 컴마 제거하기 	
			n=n.substring(0,n.length-1);
			console.log(n);
			
			// 삭제파일로 전송
			location.href="board/alldeleteaction.jsp?nums="+n;
			
		}
		
	});
	
});


</script>
</head>

<%
SmartDao dao=new SmartDao();

//페이징처리하기
int totalCount=dao.getTotalCount(); // 전체 갯수
int totalPage; // 총 페이지 수
int startPage; // 각 블럭에서 보여질 시작 페이지
int endPage; // 각 블럭에서 보여질 끝 페이지
int startNum; // db에서 가져올 글의 시작번호 (MySQL에서는 첫 글이 0번, Oracle에서는 1번)
int perPage=3; // 한페이지당 몇개의 게시글을 보여줄 것인가? // 선생님 표현 : 한페이지당 몇개의 글을 보여줄 것인가? 
int perBlock=5; // 한 페이지당 몇개의 블락 no을 보여줄 것인가? //선생님 표현 : 한 블럭당 몇개의 페이지를 보여줄 것인가? 보통 페이지 아래에 1~숫자... 다음 페이지  
int currentPage; // 현재페이지 -> 몇번 block No에 있는가? 
int no; // 각페이지당 출력할 시작번호



//현재 페이지에대한 설정
//현재 페이지 읽기(단 null일 경우는 1페이지로 준다)
if(request.getParameter("currentPage")==null||request.getParameter("currentPage").equals("null")){
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
 List<SmartDto> list=dao.getPagingList(startNum, perPage);
 
	

// 댓글 dao 호출
SmartAnswerDao adao=new SmartAnswerDao();
for(SmartDto dto:list){
	// 댓글변수에 댓글 총 갯수 넣기
	int acount=adao.getAllSmartAnswers(dto.getNum()).size();
	dto.setAnswercount(acount);
}
	
%>

<body>

<div style="margin: 30px 30px; width: 800px;" >
	<br>
	
	<h5><b>총 <%=totalCount %>개의 게시글이 있습니다.</b></h5>
	
		<table class="table table-bordered">
			<caption align="top"><B>스마트 게시판 목록</B></caption>
			<tr class="table-light">
				<th width="60">번호</th>
				<th width="360">제목</th>
				<th width="130">작성자</th>
				<th width="160">작성일</th>
				<th width="60">조회</th>
			</tr>
			
			<%
			if(totalCount==0){%>
				<tr>
					<td colspan="5" align="center">
						<h6>등록된 게시글이 없습니다.</h6>
					</td>
				</tr>	
			<%} else {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				for(SmartDto dto:list){%>
					<tr>
						<td align="center"> 
						<input type="checkbox" value="<%=dto.getNum()%>" class="delcheck"> &nbsp;
						<%=no-- %>
						</td>
						<td>
							<a href="index.jsp?main=board/contentview.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>"><%=dto.getSubject() %></a>
							
							<!-- 댓글갯수 출력하기 -->
							<%
							if(dto.getAnswercount()>0){%>
							<a href="index.jsp?main=board/contentview.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>#alist" style="color: red">[<%=dto.getAnswercount() %>]</a>	<!-- #alist : 넘어갈때 바로 댓글 부분으로 간다  %-->
							<%}
							%>
							
						</td>
						<td align="center"><%=dto.getWriter() %></td>
						<td align="center"><%=sdf.format(dto.getWriteday()) %></td>
						<td align="center"><%=dto.getReadcount() %></td>
					</tr>
				<%}
			}
			%>
			<tr>
				<td colspan="5">
					&nbsp;&nbsp;<input type="checkbox" class="alldelcheck"> 전체선택
					<span style="float: right;">
						<button type="button" class="btn btn-outline-success" style="width: 80px;" onclick="location.href='index.jsp?main=board/smartform.jsp'"><i class="bi bi-pencil">글쓰기</i></button>&nbsp;
						<button type="button" class="btn btn-outline-danger" id="btndel" style="width: 80px;" onclick=""><i class="bi bi-trash">삭제</i></button>	
					</span>
					
				</td>
			</tr>
		</table>
		
		<!-- 페이징하기 -->
		<div>
			<ul class="pagination justify-content-center">
		  		<%
		  		// 이전
		  		if(startPage>1){ %>
		  			<li class="page-item">
		  					<a class="page-link" href="index.jsp?main=board/boardlist.jsp?currentPage=<%=startPage-1%>"><<</a>
		  			</li>
		  		<%}
		  		
		  		for(int pp=startPage;pp<=endPage;pp++){
		  			if(pp==currentPage){ // css를 추가하기 위해서 if문 추가하는 것이다. 
		  				%>
		  				<li class="page-item active">
		  					<a class="page-link" href="index.jsp?main=board/boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
		  				</li>
		  			<%} else{
		  				%>
		  				<li class="page-item">
		  					<a class="page-link" href="index.jsp?main=board/boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
		  				</li>
		  			<%}
		  		}
		  		
		  		// 다음
		  		if(totalPage>endPage){
		  			%>
		  			<li class="page-item">
		  					<a class="page-link" href="boardlist.jsp?currentPage=<%=endPage+1%>">>></a>
		  			</li>
		  				  			
		  		<%}
		  		%>
		  	</ul>
		</div>
</div>


</body>
</html>