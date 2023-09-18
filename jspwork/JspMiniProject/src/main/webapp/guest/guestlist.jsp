<%@page import="data.dto.AnswerDto"%>
<%@page import="data.dao.AnswerDao"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dao.GuestDao"%>
<%@page import="java.util.Vector"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
	span.day{
		float: right;
		font-size: 0.9em;
		color: gray;
	}

	img.photo{
		border-radius: 10px;
		
	}

</style>



<title>Insert title here</title>

<%
// 로그인 상태 확인 후 입력폼 나타낼것_회원만 보이게
String loginok=(String)session.getAttribute("loginok");


GuestDao dao=new GuestDao();

//페이징처리하기
int totalCount=dao.getTotalCount(); // 전체 갯수
int totalPage; // 총 페이지 수
int startPage; // 각 블럭에서 보여질 시작 페이지
int endPage; // 각 블럭에서 보여질 끝 페이지
int startNum; // db에서 가져올 글의 시작번호 (MySQL에서는 첫 글이 0번, Oracle에서는 1번)
int perPage=3; // 한페이지당 몇개의 게시글을 보여줄 것인가? // 선생님 표현 : 한페이지당 몇개의 글을 보여줄 것인가? 
int perBlock=5; // 한 페이지당 몇개의 블락 no을 보여줄 것인가? //선생님 표현 : 한 블럭당 몇개의 페이지를 보여줄 것인가? 보통 페이지 아래에 1~숫자... 다음 페이지  
int currentPage; // 현재페이지 -> 몇번 block No에 있는가? 


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
 
 
 // 페이지에서 보여질 글만 가져오기
 List<GuestDto> list=dao.getList(startNum, perPage);
 
 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 
 
 // 마지막 페이지 남은 한개의 게시글 지우면 빈페이지만 남는다. 이를 해결하기 위해 예외처리 해준다. (이전 페이지로 넘어간다.)
 if(list.size()==0&&currentPage!=1){%>
	 
<script type="text/javascript">
	location.href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=currentPage-1%>";

</script>
	 
 <%}

%>

<script type="text/javascript">

	// 추천수 증가 
$(function(){
	
	$("span.likes").click(function(){
	var num=$(this).attr("num");
	
	// alert(num);
	var tag=$(this);
	
	$.ajax({
		
		type:"get",
		dataType:"json",
		url:"guest/ajaxlikes.jsp",
		data:{"num":num},
		success:function(data){
			
			// alert(data.chu);
			tag.next().text(data.chu);
			
			// 추천클릭시 하트 커지고 끝나면 다시 0px;
			tag.next().next().animate({"font-size":"20px"},1000,function(){
				$(this).css("font-size","0px");
			}); 
		}
	}); 
	
	});
	
	// 댓글부분은 무조건 안보이게 처리
	$("div.answer").hide();
	
	// 댓글 클릭 시 댓글 부분이 보였다 안보였다 하기
	$("span.answer").click(function(){
		//$(this).prev().slideToggle('slow');
		$(this).parent().find("div.answer").toggle();
		
	});
	
	
	$("i.adel").click(function(){
		
		var a=confirm("삭제하시려면 [확인]을 눌러주세요")
		
		if(a){

		var idx=$(this).attr("idx");
		// alert(idx);
		
		$.ajax({
			
			type:"get",
			dataType:"html",
			url:"guest/answerdelete.jsp",
			data:{"idx":idx},
			success:function(data){
				
				location.reload(); // 새로고침
				
			}
		});
		}
	});
	
	// 수정아이콘 누르면 모달로 수정폼을 띠우기 
	$("i.aedit").click(function(){
		var idx=$(this).attr("idx");
		alert(idx);
		
		// 댓글수정폼의 hidden에 idx를 넣어주기
		$("#idx").val(idx);
	
		$.ajax({
			
			type:"get",
			dataType:"json",
			url:"guest/answercontent.jsp",
			data:{"idx":idx},
			success:function(res){
				
				$("#idx").val(res.idx);
				$("#content").val(res.story);
				
			}	
		});
	});
	
	
	// 모달창의 수정버튼 누르면 수정이 된 후 reload()
	$("#btnupdate").click(function(){
		var idx=$("#idx").val();
		var content=$("#content").val();
				
		$.ajax({
			
			type:"post",
			dataType:"html",
			url:"guest/answerupdate.jsp",
			data:{"idx":idx,"content":content},
			success:function(res){
				location.reload();				
				
			}
			
		});
		
	});
	
});
	

</script>


</head>
<body>

<%
if(loginok!=null){%>
	<jsp:include page="addform.jsp"></jsp:include>
	<hr align="left" width="700px;">	
	
<%}
%>
<div>
	<B>총 <%=totalCount %>개의 방명록 글이 있습니다.</B>
	
	<%
	MemberDao mdao=new MemberDao();
	for(GuestDto dto:list){
		
		// 이름 얻기
		String name=mdao.getName(dto.getMyid());
		%>
		
		<table class="table" style="width: 600px;">
			<tr>
				<td>
					<B><i class="bi bi-person-bounding-box"><%=name %>(<%=dto.getMyid() %>)</i></B>
					
					<%
					// 로그인한 아이디
					String myid=(String)session.getAttribute("myid");
					
					// 로그인한 아이디와 글쓴아이디가 같을 경우에만 수정,삭제 버튼 표현
					if(loginok!=null&&dto.getMyid().equals(myid)){%>
						
						<a href="index.jsp?main=guest/updateform.jsp?num=<%=dto.getNum() %>&currentPage=<%=currentPage %>" style="color: green;"><i class="bi bi-pencil-square"></i></a>&nbsp;&nbsp;
						<a href="guest/delete.jsp?num=<%=dto.getNum() %>&currentPage=<%=currentPage %>" style="color: red;"><i class="bi bi-trash"></i></a>
						
					<%}
					%>
					<span class="day"><%=sdf.format(dto.getWriteday()) %></span>
				</td>
			</tr>
			<tr height="150px;">
				<td>
					<!-- 이미지가 null이 아닌 경우만 출력하기 -->
					<%
					if(dto.getPhotoname()!=null){%>
						
						<a href="save/<%=dto.getPhotoname()%>" target="_blank">
							<img alt="" src="save/<%=dto.getPhotoname()%>" align="right" style="width: 100px;" class="photo">
						</a>
						
					<%}
					%>
					<%=dto.getContent().replace("\n", "<br>") %>
				</td>
			</tr>
			
			<!-- 댓글,추천  -->
			<!-- 추천수 클릭시 추천숫자 옆에 하트 커졌다 사라지게 하기 (animate) -->
			<tr>
				<td>
				<%
				//각 방명록에 달린 댓글 목록 가져오기
				AnswerDao adao=new AnswerDao();
				List<AnswerDto> alist=adao.getAllAnswers(dto.getNum());
				
				%>
				
				<div class="answer">
					<%
					if(loginok!=null){%>
						<div class="answerform">
							<form action="guest/answerinsert.jsp" method="post">
								<table class="table table-bordered" style="width: 500px;">
									<tr>
										<td>
											<textarea style="width: 480px; height: 80px;" name="content" required="required" class="form-control"></textarea>
										</td>
										<td>
											<button type="submit" class="btn btn-info" style="width: 80px; height: 80px;">등록</button>
											<!-- hidden값 3개.. 내가 직접 기입하지 않고 받아서 넘겨줘야 하는 값  -->
											<input type="hidden" name="num" value="<%=dto.getNum()%>">
											<input type="hidden" name="myid" value="<%=myid%>">
											<input type="hidden" name="currentPage" value="<%=currentPage%>">
										</td>
									</tr>
								</table>
							</form>
						</div>
					<%}
					%>
					
					<div class="answerlist">
						<table class="table" style="width: 480px;">
							<%
							for(AnswerDto adto:alist){%>
								<tr>
									<td width="60">
										<i class="bi bi-person-circle"></i>
									</td>
									<td>
										<%
										// 작성자명
										String aname=mdao.getName(adto.getMyid());
										%>
										<br>
										<b><%=aname %></b>
										&nbsp;
										<%
										// 글쓴이와 댓글 쓴이가 같은 경우에 작성자 표시하기
										if(dto.getMyid().equals(adto.getMyid())){%>
											<b><span style="color: pink; border: 1px solid pink; border-radius: 8px;">작성자</span></b>	
										<%}
										%>
										<span style="font-size: 12pt; color: gray; margin-left: 30px;"><%=sdf.format(adto.getWriteday()) %></span>
										<%
										// 수정 삭제는 로그인중이면서 로그인한 아이디와 같은경우에만 보이게 하기
										if(loginok!=null&&adto.getMyid().equals(myid)){%>
												<i class="bi bi-pencil-square aedit" style="color: green; cursor: pointer; float: right;" idx=<%=adto.getIdx() %>
												data-bs-toggle="modal" data-bs-target="#myModal"></i>
											
											<i class="bi bi-trash adel" style="color: red; cursor: pointer; float: right;" idx=<%=adto.getIdx() %>></i>
										<%}
										%>
										<br>
										<span><%=adto.getContent().replace("\n", "<br>") %></span>
										
										
									</td>
								</tr>	
							<%}
							%>						
						</table>
					</div>
				</div>
					<span class="answer" style="cursor: pointer;" num=<%=dto.getNum() %>> 댓글 <%=alist.size() %> </span> <!-- 댓글 수량 가져오기 -->
					<span class="likes" style="margin-left: 20px; cursor: pointer;" num=<%=dto.getNum() %>>추천</span>
					<span><%=dto.getChu() %></span>
					<i class="bi bi-chat-heart-fill" style="color: red; font-size: 0px;"></i>
				</td>
			</tr>
			
		</table>
	<%}
	%>
</div>

<!-- 페이지 번호 출력 -->
		<div style="width: 600px; text-align: center;" >
			<ul class="pagination justify-content-center">
		  		<%
		  		// 이전
		  		if(startPage>1){ %>
		  			<li class="page-item">
		  					<a class="page-link" href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=startPage-1%>"><<</a>
		  			</li>
		  		<%}
		  		
		  		for(int pp=startPage;pp<=endPage;pp++){
		  			if(pp==currentPage){ // css를 추가하기 위해서 if문 추가하는 것이다. 
		  				%>
		  				<li class="page-item active">
		  					<a class="page-link" href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
		  				</li>
		  			<%} else{
		  				%>
		  				<li class="page-item">
		  					<a class="page-link" href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
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
		
		<!-- 여기부터 -->
		
		<!-- The Modal -->

<input type="hidden">
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
     	<div class="updateform">
     	<input type="hidden" id="idx">
     	  <input type="text" id="content">
     	  <button type="button" class="btn btn-info" id="btnupdate">댓글수정</button>
     	</div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

		
</body>
</html>