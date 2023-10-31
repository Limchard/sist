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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
$(function(){
	
	// 사진 수정
	$(".btnnewphoto").click(function(){
		
		$("#newphoto").trigger("click"); // triger : 강제 실행?
			
	});
	
	$("#newphoto").change(function(){
		var num=$(this).attr("num");
		console.log(num);
		
		var form=new FormData();
		form.append("photo",$("#newphoto")[0].files[0]); //선택한 이미지 한개만 추가. // 선택한 이미지 중 한개만 추가하겠다.
		form.append("num",num);
		
		console.dir(form);
		
		$.ajax({
			type:"post",
			dataType:"html",
			url:"updatephoto",
			processData: false,
            contentType: false,
			data:form,
			success:function(res){
				location.reload();
			}
			
		});
		
	});
	
	// 회원 탈퇴
	$(".btndelete").click(function(){
		
		var num=$(this).attr("num");
		// alert(num);
		var ans=confirm("정말 탈퇴 하시겠습니까?");
		
		if(ans){
			
			$.ajax({
				type:"get",
				dataType:"html",
				url:"deleteme",
				data:{"num":num},
				success:function(){
					alert("탈퇴되었습니다.");
					location.href="/";
					
				}
			});
		}
	});
	
	
	// modal창 띄우기
	
	
	$(".btnmodify").click(function(){
		
		// 수정 모달창 띄우기
		$(".umodal").modal("show");

	});
	
	$("#btnupdateok").click(function(){
		
		var name=$("#uname").val();
		var hp=$("#uhp").val();
		var addr=$("#uaddr").val();
		var email=$("#uemail").val();
		var num=$(this).attr("num");
		
		
		// alert(name);
		// alert(num);
		
 		$.ajax({
		type:"post",
		dataType:"html",
		url:"updateinfo",
		data:{"num":num,"name":name,"hp":hp,"addr":addr,"email":email},
		success:function(res){
			// alert(res.num); 
			location.reload();
		}
		
	}); 
		
	});
	
	
	
	
});


</script>
</head>
<body>

<c:forEach var="dto" items="${list }">
	<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.id }">
	<%-- <c:if test="${sessionScope.loginok!=null && sessionScope.myid==dto.id }"> --%>
		<table class="table table-bordered" style="width: 800px;">
			<tr>
				<td rowspan="7" align="center" style="width: 350px;">
					<img alt="" src="../membersave/${dto.photo }" style="width: 300px;">
					<br><br>
					<input type="file" style="display: none;" num=${dto.num} id="newphoto"> <!-- 사진 수정 시 호출하기. -->
					<button type="button" class="btn btn-primary btnnewphoto">사진수정</button>
				</td>
				<td>
					이름: ${dto.name }
				</td>
				<td rowspan="7" align="center" valign="middle">
					<button type="button" class="btn btn-success btnmodify">정보수정</button><br><br>
					<button type="button" class="btn btn-danger btndelete" num=${dto.num }>회원탈퇴</button>
				</td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td>
					아이디: ${dto.id }
				</td>
			</tr>
			<tr>
				<td>
					연락처: ${dto.hp }
				</td>
			</tr>
			<tr>
				<td>
					주소: ${dto.addr }
				</td>
			</tr>
			<tr>
				<td>
					e-mail: ${dto.email }
				</td>
			</tr>
			<tr>
				<td>
					가입날짜: ${dto.gaipday }
				</td>
			</tr>
		</table>
		
		<!-- modal 로 개인정보 수정 -->
		<div class="umodal modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4>회원정보수정</h4>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="mb-3 mt-3">
						<label for="uname">이름:</label> 
						<input type="text" class="form-control" id="uname" value="${dto.name }" style="width: 300px;">
					</div>
					<div class="mb-3 mt-3">
						<label for="uhp" class="form-label">연락처:</label> 
						<input type="text" class="form-control" id="uhp" value="${dto.hp }" style="width: 300px;">
					</div>
					<div class="mb-3 mt-3">
						<label for="uaddr" class="form-label">주소:</label> 
						<input type="text" class="form-control" id="uaddr" value="${dto.addr }" style="width: 300px;">
					</div>
					<div class="mb-3 mt-3">
						<label for="uemail" class="form-label">e-mail:</label> 
						<input type="text" class="form-control" id="uemail" value="${dto.email }" style="width: 300px;">
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-outline-warning" id="btnupdateok" num="${dto.num }">수정</button>
					<button type="button" class="btn btn-outline-danger">Close</button>
				</div>
			</div>
		</div>
 	</div>
		
	</c:if>
</c:forEach>

</body>
</html>