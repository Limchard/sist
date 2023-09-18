<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
<style type="text/css">
	span.day{
		color: gray; font-size: 0.8em;
	}
	
	span.aday{
		color: gray; font-size: 0.8em;
	}

</style>

<script type="text/javascript">
$(function(){
	
	// 시작할때 일단 list 호출해야 한다
	list();
	
	// num 값 받아오는지 alert 테스트
	var num=$("#num").val();
	// salert(num);
	
	
	// 댓글부분 ajax insert
	$("#btnadd").click(function(){
		var nickname=$("#nickname").val().trim();
		var content=$("#content").val().trim();
		
		//null값 체크
		if(nickname.trim().length==0){
			swal("No!!","니 이름 없나?","error");
			return;
		}
		
		if(content.trim().length==0){
			swal("No!!","마!! 댓글쓰라!!","error");
			return;
		}
		
		$.ajax({
			
			type:"get",
			url:"board/insertanswer.jsp",
			dataType:"html",
			data:{"num":num,"nickname":nickname,"content":content},
			success:function(){
				
				//기존 입력값 지우기(초기화)
				$("#nickname").val("");
				$("#content").val("");
				
				// 리스트 호출
				list();
			},
			statusCode:{
				404:function(){
					alert("json 파일을 찾을 수 없어요");
				},
				500:function(){
					alert("서버오류.. 코드 다시 확인!!");
				}
			}
		});
	}); 
});

function list(){
    var num=$("#num").val();
    //alert(num);
    
    $.ajax({
       type:"get",
       dataType:"json",
       url:"board/listanswer.jsp",
       data:{"num":num},
       success:function(data){
          //댓글 갯수 입력
          $("b.acount>span").text(data.length);
          
          //출력
          var s="";
          $.each(data,function(idx,item){
             s+="<div>"+item.nickname+" : "+item.content+"&nbsp;";
             s+="<span style='color:gray;float:right;'>"+item.writeday+"</span>"+"&nbsp;";
             s+="<i idx="+item.idx+" class='bi bi-trash adel' style='color:red;'></i>";
             s+="</div>";
          });
          $("div.alist").html(s);
       }
    });
 }

</script>

</head>
	<jsp:useBean id="dao" class="data.dao.SmartDao"></jsp:useBean>
<body>
	<%
	
	String num=request.getParameter("num");
	
	// 현재페이지 받기
	String currentPage=request.getParameter("currentPage");
	
	
	dao.updateReadCount(num);
	
	SmartDto dto=dao.getData(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	%>
	
<div style="margin: 30px 30px; width: 500px;" >
<input type="hidden" id="num" value="<%=num%>">
	<table class="table table-bordered">
		<caption>
			<b><h2><%=dto.getSubject() %></h2></b>
		</caption>
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span class="day"><%=sdf.format(dto.getWriteday()) %> &nbsp;&nbsp; 조회: <%=dto.getReadcount() %></span>
			</td>
		</tr>
		<tr>
			<td height="150">
				<%=dto.getContent() %>
			</td>
		</tr>
		
		<!-- 댓글 -->
		<tr>
			<td>
				<b class="acount" id="alist">댓글<span>0</span></b>
				<div class="alist">
					댓글목록
				</div>
				<div class="aform input-group">
					<input type="text" id="nickname" class="form-control" style="width: 80px;" placeholder="닉네임">
					<input type="text" id="content" class="form-control" style="width: 300px;" placeholder="댓글메세지">
					<button type="button" id="btnadd" class="btn btn-outline-primary">저장</button>
				</div>
				
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<button type="button" class="btn btn-outline-success btn-sm" onclick="location.href='index.jsp?main=board/smartform.jsp'"><i class="bi bi-pencil">글쓰기</i></button>
				<button type="button" class="btn btn-outline-info btn-sm" onclick="location.href='index.jsp?main=board/boardlist.jsp?currentPage=<%=currentPage%>'"><i class="bi bi-list-task">목록</i></button>
				<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='index.jsp?main=board/updateform.jsp?num=<%=num%>&currentPage=<%=currentPage%>'"><i class="bi bi-pencil-square">수정</i></button>
				<button type="button" class="btn btn-outline-danger btn-sm" onclick="funcdel(<%=dto.getNum()%>,<%=currentPage%>)"><i class="bi bi-trash">삭제</i></button>
			</td>
		</tr>
	</table>
</div>
	
<script type="text/javascript">

	function funcdel(num,currentPage){
		// alert(num+","+currentPage);
		
		var a=confirm("삭제하려면 [확인]을 눌러주세요")
		
		if(a){
			location.href="board/deleteaction.jsp?num="+num+"&currentPage="+currentPage;
		}
	}

</script>
	
</body>
</html>