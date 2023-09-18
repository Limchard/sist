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
<style type="text/css">

#selphoto{
			position: absolute;
			left: 500px;
			top: 100px;
			width: 200px;
			border-radius: 20px;
		}
		
</style>

<script type="text/javascript">

	$(function(){
		
		// selecte된 선택값 얻기
		var srcImg=$("#photo").val();
		// selphoto에 넣기
		$("#selphoto").attr("src",srcImg)
		
	
		$("#photo").change(function(){
			var s=$(this).val();
			$("#selphoto").attr("src",s);
		
		});
	});

</script>

</head>
<body>
<form action="addAction.jsp" method="post">
	<table class="table table-bordered" style="width: 500px">
	<caption align="top"><h4><b>상품등록</b></h4></caption>
		<tr>
			<th>상품명</th>
			<td>
				<input type="text" name="sangpum" required="required" placeholder="상품명" style="width: 200px">
			</td>
		</tr>
	
		<tr>
			<th>사진</th>
			<td>
				<select name="photo" id="photo"> <!-- 이미지를 넣기 위해서 id를 넣어야 한다. -->
					<option value="../img/shoppingmall/11.jpg">구두</option>
					<option value="../img/shoppingmall/22.jpg">반지</option>
					<option value="../img/shoppingmall/24.jpg">바지</option>
					<option value="../img/shoppingmall/33.jpg">원피스</option>
					<option value="../img/shoppingmall/29.jpg">모자</option>
					<option value="../img/shoppingmall/26.jpg">머리끈</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>가격</th>
			<td>
				<input type="text" name="price" required="required" placeholder="가격" style="width: 200px">
			</td>
		</tr>
		
		<tr>
			<th>입고날짜</th>
			<td>
				<input type="date" name="ipgoday" required="required" placeholder="입고날짜" style="width: 200px">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center" style="width: 200px">
				<input type="submit" class="btn btn-outline-success" value="목록 추가">
				<input type="button" class="btn btn-outline-info" value="목록 보기" onclick="location.href='list.jsp'">
			</td>
		</tr>
	</table>
</form>
<!-- 이미지를 넣기 위해서 id를 넣어야 한다. -->
	<img alt="" src="" id="selphoto">

</body>
</html>