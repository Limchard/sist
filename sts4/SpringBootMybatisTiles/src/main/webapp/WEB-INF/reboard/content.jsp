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
	<style>
		div.likes{
			cursor: pointer;
		}

	</style>
	<script>
		$(function (){
			$("div.likes").click(function (){

				var thum=$(this).find("i").attr("class");

				if(thum=='bi bi-hand-thumbs-up'){
					$(this).find("i").attr("class","bi bi-hand-thumbs-up a").css("color","red");
				} else {
					$(this).find("i").attr("class","bi bi-hand-thumbs-up").css("color","dodgerblue");
				}

				var num=${dto.num};
				// alert(num);
				$.ajax({
					type:"get",
					dataType:"json",
					data:{"num":num},
					url:"likes",
					success:function (res){
						//alert(res.likes);
						$("div.likes").find("b").text(res.likes);

					}
				});
			});
		});
	</script>

</head>
<body>
<div style="width: 600px; margin: 50px 100px;" >
	<table class="table table-bordered">
		<tr>
			<td>
				<h2>${dto.subject}</h2>
				<b>${dto.name}(${dto.id})</b>
				<span style="color: gray; font-size: 0.9em;">
					<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					조회: ${dto.readcount}
				</span>
			</td>
		</tr>
		<tr>
			<td>
				<pre>
					${dto.content}
				</pre>
				<br><br>
				<c:if test="${dto.photo==null}">
					<c:forEach items="${dto.photo}" var="photo">
						<img src="../rephoto/${photo}" width="100" class="img-thumbnail">
					</c:forEach>	
				</c:if>
				<br><br>
				<div class="likes">
					<i class="bi bi-hand-thumbs-up" style="color: dodgerblue"></i>&nbsp;&nbsp;
					좋아요 <b>${dto.likes}</b>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" class="btn btn-outline-info" onclick="location.href='form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">답글</button>
				<c:if test="${sessionScope.loginok!=null&&sessionScope.myid==dto.id}">
					<button type="button" class="btn btn-outline-info" onclick="location.href=''">수정</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
				</c:if>
				<button type="button" class="btn btn-outline-info" onclick="location.href='list?currentPage=${currentPage}'">목록</button>
				<c:if test="${sessionScope.loginok!=null}">
					<button type="button" class="btn btn-outline-info" onclick="location.href='form'">새글쓰기</button>
				</c:if>
			</td>
		</tr>
	</table>

</div>
</body>
</html>