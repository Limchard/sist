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
<%


%>

</head>
<body>
<div style="margin: 30px 50px; width: 900px;">
	<c:if test="${sessionScope.loginok!=null }">
		<button type="button" class="btn btn-info" onclick="location.href='form'">글쓰기</button>
	</c:if>
	<br><br>
	<table class="table table-bordered" style="width: 800px;">
		<tr class="table-secondary">
			<th width="60">번호</th>
			<th width="360">제목</th>
			<th width="160">작성자</th>
			<th width="100">조회</th>
			<th width="200">등록일</th>
		</tr>
		<c:if test="${totalCount==0 }">
			<tr>
				<td colspan="5" align="center">
					<h4>등록된 글이 없습니다.</h4>
				</td>
			</tr>
		</c:if>
		<c:if test="${totalCount!=0 }">
			<c:forEach var="dto" items="${list }" varStatus="i">
				<tr>
					<td>
						${no }
						<c:set var="no" value="${no-1 }"></c:set>
					</td>
					<td>
						<a href="content?num=${dto.num }&currentPage=${currentPage}" style="text-decoration: none; color: black;">${dto.subjects }</a>
					</td>
					<td>
						${dto.name }
					</td>
					<td>
						${dto.readcount }
					</td>
					<td>
						${dto.writeday }
					</td>
				</tr>	
			</c:forEach>
		</c:if>
	</table>
	
		<c:if test="${totalCount>0 }">
		<div style="width: 800px; text-align: center;">
			<ul class="pagination justify-content-center">
				<!-- 이전 -->
				<c:if test="${startPage>1 }">
					<li class="page-item">
						<a class="page-link" href="list?currentPage=${startPage-1 }"><<</a>
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
						<a class="page-link" href="list?currentPage=${endPage+1 }">>></a>
					</li>
				</c:if>
			</ul>
		</div>			
	</c:if>
	
</div>
</body>
</html>