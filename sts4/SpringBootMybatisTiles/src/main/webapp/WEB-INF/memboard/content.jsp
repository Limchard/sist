<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>

<style type="text/css">
.day{
	color: gray;
	margin-left: 10px;
	margin-right: 10px;
	font-size: 0.9em; 
 
}

.amodi{
	cursor: pointer;
	font-size: 0.7em;
	color: orange;
}
.adel{
	cursor: pointer;
	font-size: 0.7em;
	color: red;
}

</style>

<script type="text/javascript">
$(function(){
	
	
	// list 호출
	list();
	
	$("#btnansweradd").click(function(){
		var num=$("#num").val()
		var content=$("#content").val();
		
		loginok="${sessionScope.loginok}";
		myid="${sessionScope.myid}";
		// alert(num+","+content+","+loginok+","+myid)
		
		// 댓글을 입력하지 않았을 시
		if(content.length==0){
			alert("대슬을 입력해 주세요");
			return;
		}
		
		// 댓글을 입력했을 시 	
		$.ajax({
			type:"post",
			url:"/mbanswer/ainsert",
			dataType:"html",
			data:{"num":num,"content":content},
			success:function(){
				// location.reload();
				
				// 성공했으면 list를 다시 불러와야 한다.
				list();
				
				// 입력값 초기화
				$("#content").val("");
			}
		});

	});
	
	
	// 댓글 수정창 띄우기
	$(document).on("click","i.amodi",function(){
		
		idx=$(this).attr("idx");
		// alert(idx);
		
		$.ajax({
			type:"get",
			dataType:"json",
			url:"/mbanswer/adata",
			data:{"idx":idx},
			success:function(ares){
				$("#ucontent").val(ares.content);
			}
				
		});
		
		$("#mbUpdateModal").modal("show");
		
		
	});
	
	// 댓글 수정
	$(document).on("click","#btnupdate",function(){
		var content=$("#ucontent").val();
		// alert(idx+"."+content);
		
 		$.ajax({
			type:"post",
			dataType:"html",
			url:"/mbanswer/aupdate",
			data:{"content":content,"idx":idx},
			success:function(){
				list();
				$("#mbUpdateModal").modal("hide");
			}
		
		}); 
		
	});
	
	// 댓글 삭제
	$(document).on("click",".adel",function(){
		
		var idx=$(".adel").attr("idx");
		// alert(idx);
		var q=confirm("정말 삭제하시겠습니까?");
		
		if(q){
			$.ajax({
				type:"get",
				dataType:"html",
				data:{"idx":idx},
				url:"/mbanswer/adelete",
				success:function(dres){
					location.reload();
				}
			});
		}
	});
	
	
	
	
	
});

// 사용자 함수는 $(function(){})에 넣으면 안된다.
function list(){
	var num=$("#num").val();
	loginok="${sessionScope.loginok}";
	myid="${sessionScope.myid}";
	
	$.ajax({
		
		type:"get",
		dataType:"json",
		url:"/mbanswer/alist",
		data:{"num":num},
		success:function(res){
			var s="";
			//alert(data.length);
			$("span.acount").text(res.length); // 댓글갯수 확인 후 진행하기.
			
			$.each(res,function(i,ele){
				
				s+="<b>"+ele.name+"</b>: "+ele.content;
				s+="<span class='day'>"+ele.writeday+"</span>";
				if(loginok=='yes' && myid==ele.myid){
					s+="<i class='bi bi-pencil-square amodi' idx='"+ele.idx+"'></i>"
					s+="&nbsp;"
					s+="<i class='bi bi-trash adel' idx='"+ele.idx+"'></i>"
				}
				s+="<br>"
			});
			
			$("div.alist").html(s);
			
		}
		
	});
	
}
</script>

</head>
<body>
<div style="margin: 50px 150px;">
	<table class="table table-bordered" style="width: 600px;">
		<tr>
			<td>
				<h4>
					<b>${dto.subjects }</b>
					<span style="font-size: 14pt; color: gray; float: right;">
						<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
					</span>
				</h4>
				<span>작성자: ${dto.name }(${dto.myid })</span>
				<span style="float: right;">
					<b>조회: ${dto.readcount }</b>
					<b>
						댓글: <span class="acount"></span> 
					</b>
				</span>
				<br>
				<c:if test="${dto.uploadfile!='no' }">
					<span style="float: right;">
						<a href="download?clip=${dto.uploadfile }"><i class="bi bi-arrow-down-square"><b>${dto.uploadfile }</b></i></a>
					</span>
					
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				<c:if test="${bupload==true }">
					<img alt="" src="../savefile/${dto.uploadfile }" style="width: 200px;">
				</c:if>
				<br>
				<pre>
					${dto.content }
				</pre>
			</td>
		</tr>
		
		<!-- 댓글 -->
		<tr>
			<td>
				<div class="alist"></div>
				<input type="hidden" id="num" value="${dto.num }">
				
				<c:if test="${sessionScope.loginok!=null }">
					<div class="aform">
						<div class="d-inline-flex">
							<input type="text" class="form-control" style="width: 500px;" placeholder="댓글을 입력하세요" id="content">&nbsp;&nbsp;
							<button type="button" class="btn btn-info" id="btnansweradd">등록</button>
						</div>
					</div>
				</c:if>
				
			</td>
		</tr>
		
		
		<!-- 버튼들 추가 -->
		<tr>
			<td align="right">
				<c:if test="${sessionScope.loginok!=null }">
					<button type="button" class="btn btn-outline-info" onclick="location.href='form'">글쓰기</button>
				</c:if>
					<button type="button" class="btn btn-outline-success" onclick="location.href='list?currentPage=${currentPage}'">목록</button>
				<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid }">	
					<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</c:if>	
			</td>
		</tr>
	</table>
	
<!-- 수정창 -->
	<!-- The Modal -->
<div class="modal" id="mbUpdateModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<input type="text" id="ucontent" class="form-control">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-warning" id="btnupdate" >수정</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
	
	
</div>	
</body>
</html>