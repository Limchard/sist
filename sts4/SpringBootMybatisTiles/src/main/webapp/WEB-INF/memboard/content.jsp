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
				<span style="float: right;"><b>조회: ${dto.readcount }</b></span>
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
		
		<!-- 버튼들 추가 -->
		<tr>
			<td align="right">
				<c:if test="${sessionScope.loginok!=null }">
					<button type="button" class="btn btn-outline-info" onclick="location.href='form'">글쓰기</button>
				</c:if>
					<button type="button" class="btn btn-outline-success" onclick="location.href='list'">목록</button>
				<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid }">	
					<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</c:if>	
			</td>
		</tr>
	</table>
</div>	
</body>
</html>