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
		$("#allcheck").click(function(){
			
			var chk=$(this).is(":checked");
			// console.log(chk); 
			
			$(".del").prop("checked",chk);
		});
		
		$("#btnmemberdel").click(function(){
			var cnt=$(".del:checked").length;
			// alert(cnt);
			
			if(cnt==0){
				alert("먼저 선택을 해주세요.")
				return;
			}
			
			$(".del:checked").each(function(i,element){
				var num=$(this).attr("num");	
				// console.log(num);
				
				// 선택한 체크 삭제
				$.ajax({
					type:"get",
					url:"delete",
					dataType:"html",
					data:{"num":num},
					success:function(){
						alert("삭제되었습니다.");
						location.reload();
					}
				});
			});
			
		});
		
	});
</script>
</head>
<body>
	<h2 class="alert alert-info">${totalCount }명의 회원이 있습니다.</h2>
	<button type="button" class="btn btn-outline-info" onclick="location.href='form'">회원가입</button>
	<br><br>
	<table class="table table-bordered" style="width: 800px;">
		<tr>
			<th>No.</th>
			<th>사진</th>
			<th>이름</th>
			<th>id</th>
			<th>연락처</th>
			<th>주소</th>
			<th>이메일</th>
			<th>가입날짜</th>
			<th>
				<input type="checkbox" id="allcheck">강퇴
			</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="no">
			<tr>
				<td>${no.count }</td>
				<td>
					<img alt="" src="../membersave/${dto.photo }" style="width: 50px;">
				</td>
				<td>${dto.name }</td>
				<td>${dto.id }</td>
				<td>${dto.hp }</td>
				<td>${dto.addr }</td>
				<td>${dto.email }</td>
				<td>
					<fmt:formatDate value="${dto.gaipday }" pattern="yyyy.MM.dd"/>
				</td>
				<td>
					<input type="checkbox" num=${dto.num } class="del">
				</td>
			</tr>
		</c:forEach>
	</table>

<button type="button" class="btn btn-outline-danger" id="btnmemberdel">Delete</button>

</body>
</html>