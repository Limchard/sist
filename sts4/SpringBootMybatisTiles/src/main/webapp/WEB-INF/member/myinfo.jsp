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
				<button type="button" class="btn btn-success">정보수정</button><br><br>
				<button type="button" class="btn btn-danger">회원탈퇴</button>
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
	</c:if>
</c:forEach>
</body>
</html>