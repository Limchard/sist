<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="inputform" style="width: 600px;">
	<form action="shop/addaction.jsp" method="post" enctype="multipart/form-data">
		<table class="table table-bordered">
			<caption align="top"><b>상품등록</b></caption>
			<tr>
				<td style="width: 150px;" class="table-success">
					<b>카테고리</b><br>
					<select class="form-control" name="category" required="required">
						<option value="아우터">아우터</option>
						<option value="상의">상의</option>
						<option value="하의">하의</option>
						<option value="원피스">원피스</option>
						<option value="악세서리">악세서리</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="width: 150px;" class="table-success">
					<b>상품명</b><br>
					<input type="text" name="sangpum" class="fonr-control" required="required" style="width: 200px;" placeholder="상품명입력">
				</td>
			</tr>
			<tr>
				<td style="width: 150px;" class="table-success">
					<b>상품이미지</b><br>
					<input type="file" name="photo" class="fonr-control" required="required" style="width: 400px;">
				</td>
			</tr>
			<tr>
				<td style="width: 150px;" class="table-success">
					<b>상품가격</b><br>
					<input type="text" name="price" class="fonr-control" required="required" style="width: 150px;" placeholder="가격입력">
				</td>
				<td style="width: 150px;" class="table-success">
					<b>입고일</b><br>
					
					<%
					// 현재날짜 구하기
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String day=sdf.format(new Date());
					%>
					<input type="date" name="ipgoday" class="fonr-control" required="required" style="width: 400px;" value="<%=day %>" >
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success" style="width: 80px;">상품저장</button>
					<button type="button" class="btn btn-outline-warning" style="width: 80px;" onclick="location.href='index.jsp?main=shop/shoplist.jsp'">상품목록</button>
				</td>
			
			</tr>
		</table>
	</form>


</div>
	
</body>
</html>