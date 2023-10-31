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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	
	$("#btnloginok").click(function(){
		
		// 아이디 비번 읽기
		var id=$("#loginid").val();
		var pass=$("#loginpass").val();
		// alert(id);
		// alert(pass);
		
		var root='${root}';
		console.log("root"+root);
		
		$.ajax({
			
			type:"get",
			url:"/member/login",
			dataType:"json",
			data:{"id":id,"pass":pass},
			success:function(res){
				if(res.result=='fail'){
					alert("아이디와 비밀번호를 확인해주세요.");
				} else {
					location.reload();
				}
			}
		});
		
	});
	
	
	// 로그아웃
	$("#btnlogout").click(function(){
		$.ajax({	
			type:"get",
			url:"/member/logout",
			dataType:"html",
			success:function(res){
				alert("로그아웃 되었습니다.");
				location.reload();
				
			}
		});
	});
	
});


</script>
</head>
<body>
	<div class="d-inline-flex">
		<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
		<a href="/"><img alt="" src="${root }/image/titlett.jpg" width="200"></a>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<c:if test="${sessionScope.loginok==null }">
			<button type="button" class="btn btn-outline-danger" onclick="location.href='${root}/login/form'">Login</button>
		</c:if>
		
		<!-- 로그인에 대한 부분은 단순 mapping 말고, 전체 루트를 적어줘야 한다. -->
		
		<c:if test="${sessionScope.loginok!=null }">
			<b>${sessionScope.myid }님 좋은하루 보내세요~</b>
			<button type="button" class="btn btn-outline-danger" onclick="location.href='${root}/login/logoutprocess'">Logout</button>
		</c:if>
		
		<!-- 모달~ 모달~ -->	
		<!-- Ajax modal -->
		<div class="container">
		
		<c:if test="${sessionScope.loginok==null }">
		  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal" id="btnlogin">
		    Login
		  </button>
		</c:if>
		<c:if test="${sessionScope.loginok!=null }">
		  <button type="button" class="btn btn-danger" id="btnlogout">
		    Logout
		  </button>
		</c:if>
				  
		</div>

		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4>Login</h4>
					</div>
						<!-- Modal body -->
					<div class="modal-body">
						<div class="mb-3 mt-3">
							<label for="loginid">id:</label> 
							<input type="text" class="form-control" id="loginid" placeholder="아이디 입력" style="width: 300px;">
						</div>
						<div class="mb-3">
							<label for="loginpass" class="form-label">Password:</label> 
							<input type="password" class="form-control" id="loginpass" placeholder="비밀번호 입력" style="width: 300px;">
						</div>
					</div>
						<!-- Modal footer -->
					<div class="modal-footer">
						<div class="form-check mb-3">
							<label class="form-check-label"> 
								<input class="form-check-input" type="checkbox" name="remember">Remember me
							</label>
						</div>
						<button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal" id="btnloginok">Login</button>
						<button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>	
	
</body>
</html>