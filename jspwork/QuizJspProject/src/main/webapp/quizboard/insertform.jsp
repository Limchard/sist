<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<form action="insertaction.jsp" method="post" enctype="multipart/form-data" >
		<table class="table table-bordered" style="width: 400px;">
			<caption align="top" style="font-size: 1.3em;">정보 입력</caption>
			<tr>
				<th style="width: 100px;">작성자</th>
				<td>
					<input type="text" name="writer" required="required">
				</td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" required="required">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea style="width: 400px; height: 200px;" name="content" required="required"></textarea>
				</td>
			</tr>
			
			<tr>
				<th>이미지</th>
				<td>
					<input type="file" name="imgname" >
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-outline-info" value="전송">
					<input type="button" class="btn btn-outline-success" value="목록" onclick="location.href='quizlist.jsp'">
				</td>
			</tr>
			
		</table>
	</form>	
	
</body>
</html>