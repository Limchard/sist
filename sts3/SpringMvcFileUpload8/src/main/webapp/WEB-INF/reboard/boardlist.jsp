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
</head>
<body>
<div style="margin: 50px 50px;">
	<table class="table table-bordered" style="width: 800px;">
		<caption align="top">
			<b>스프링 답변형 게시판</b>
				<span style="float: right;">
					<button type="button" class="btn btn-outline-info" onclick="location.href='writeform?currentPage=${currentPage}'">글쓰기</button>
				</span>
		</caption>
		
		<tr>
			<th width="60">번호</th>
			<th width="300">제목</th>
			<th width="220">작성자</th>
			<th width="250">작성일</th>
			<th width="60">조회</th>
		</tr>
		
		<c:if test="${totalCount==0 }">
			<tr>
				<td colspan="5" align="center">
					<b>등록된 게시글이 없습니다.</b>
				</td>
			</tr>	
		</c:if>
		<c:if test="${totalCount>0 }">
			<c:forEach var="bdto" items="${list }" >
				<tr>
					<td align="center">${no }</td>
					<c:set var="no" value="${no-1 }"></c:set> <!-- 출력 후 감소시키는것. 증감연산자 사용이 불가하기 때문이다. -->
					<td> <!-- 제목 -->
						<!-- relevel만큼 앞에 공백이 와야한다. -->
						<c:forEach var="s" begin="1" end="${bdto.relevel }">
							&nbsp;&nbsp;
						</c:forEach>
						
						<!-- 답글인 경우에만 re.png이미지 출력 -->
						<c:if test="${bdto.relevel>0 }">
							<img alt="" src="../upload/re.png">
						</c:if>
						
						<!-- 제목.. 여기 누르면 내용 보기로 갈꺼다! -->
						<a href="content?num=${bdto.num }&currentPage=${currentPage}">${bdto.subject }</a>
						
						<!-- 댓글개수 표시하기 -->
						<c:if test="${bdto.acount>0 }">
							<a style="color: red;" href="content?num=${bdto.num }&currentPage=${currentPage}#answer">[${bdto.acount }]</a>
						</c:if>
						
						<!-- 사진이 있을경우 아이콘 표시 -->
						<c:if test="${bdto.photo!='no' }">
							<i class="bi bi-image"></i>
						</c:if>
					</td>
					<td align="center"> ${bdto.writer }</td>
					<td><fmt:formatDate value="${bdto.writeday }" pattern="yyyy-MM-dd"/></td>
					<td align="center">${bdto.readCount }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>	

<!-- 페이지번호 출력 -->

	<c:if test="${totalCount>0 }">
		<div style="width: 800px; text-align: center;">
			<ul class="pagination justify-content-center">
				<!-- 이전 -->
				<c:if test="${startPage>1 }">
					<li class="page-item">
						<a href="list?currentPage=${startPage-1 }">이전</a>
					</li>
				</c:if>
				
				<!-- 가운데 숫자들.. -->
				<c:forEach var="pp" begin="${startPage }" end="${endPage }">
					<c:if test="${currentPage==pp }">
						<li class="page-item active">
							<a href="list?currentPage=${pp }" class="page-link">${pp }</a>
						</li>
					</c:if>
					<c:if test="${currentPage!=pp }">
						<li class="page-item">
							<a href="list?currentPage=${pp }" class="page-link">${pp }</a>
						</li>
					</c:if>
				</c:forEach>
			
				<!-- 다음 -->
				<c:if test="${endPage<totalPage }">
					<li class="page-item">
						<a href="list?currentPage=${endPage+1 }">다음</a>
					</li>
				</c:if>
			</ul>
		</div>			
	</c:if>
	
	
</div>
</body>
</html>