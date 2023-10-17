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
<div style="margin: 100px 100px;">
	<table class="table table-bordered" style="width: 600px;">
		<caption align="top"><b>내용보기</b></caption>
		<tr>
			<td>
				<h2><b>${bdto.subject }</b></h2>
				<span style="float: right; margin-right: 20px;">
					조회: ${bdto.readCount } &nbsp;&nbsp;&nbsp;
					<fmt:formatDate value="${bdto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
				</span>
				<br>
				<h5><b>작성자: ${bdto.writer }</b></h5>
			</td>
		</tr>
		
		<tr>
			<td>
				<pre>${bdto.content }</pre>
				<br><br>
				<!-- 이미지가 있을때만 출력 -->
				<c:if test="${bdto.photo!='no' }"> <!-- null이 아니다. DB 확인할 것!! -->
					<c:forTokens var="pho" items="${bdto.photo }" delims=","> <!-- 사진 여러개의 경우 끊어서 사진 넣기 -->
						<a href="../upload/${pho }"> <!-- 사진 클릭 시 원본사진 나오게 하기 -->
							<img alt="" src="../upload/${pho }" width="150" style="border: 1px solid gray; border-radius: 10px;">
						</a>
					</c:forTokens>
				</c:if>
			</td>
		</tr>
		<tr>
			<td align="right">
				<button type="button" class="btn btn-info" onclick="location.href='writeform'" style="width: 100px;">글쓰기</button>
				<button type="button" class="btn btn-success" onclick="location.href='writeform?num=${bdto.num}&regroup=${bdto.regroup }&restep=${bdto.restep }&relevel=${bdto.relevel }&currentPage=${currentPage }'" style="width: 100px;">답글쓰기</button>
				<button type="button" class="btn btn-warning" onclick="location.href='updatepassform?num=${bdto.num}&currentPage=${currentPage }'" style="width: 100px;">수정</button>
				<button type="button" class="btn btn-danger" onclick="location.href='deletepassform?num=${bdto.num}&currentPage=${currentPage }'" style="width: 100px;">삭제</button>
				<button type="button" class="btn btn-primary" onclick="location.href='list?currentPage=${currentPage}'" style="width: 100px;">목록</button>
			</td>
		</tr>
	</table>
</div>
	
</body>
</html>