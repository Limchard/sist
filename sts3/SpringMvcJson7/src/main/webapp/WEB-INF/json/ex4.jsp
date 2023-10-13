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
	<h3 class="alert alert-success">Ex4번 예제</h3>
	<br>
	<h4>메뉴명을 입력후 엔터를 쳐주세요</h4>
	<input type="text" id="serch" class="form-control" style="width: 150px;">
	<br><br>
	<h2 id="cname"></h2>
	<img alt="" src="" id="photo" width="500">
	
	<script type="text/javascript">
		$("#serch").keydown(function(key){
			var name=$(this).val();
			if(key.keyCode == 13){
				$.ajax({
					type:"get",
					dataType:"json",
					url:"list4",
					data:{"name":name},
					success:function(res){
						$("#cname").html(res.name);
						$("#photo").attr("src","image/"+res.photo);
						$("#serch").val("");
					}
				});
			}
		})
	</script>
	
	
	<script type="text/javascript">
		$("#btn2").click(function(){
			$.ajax({
				type:"get",
				dataType:"json",
				url:"list2",
				success:function(res){
					$("#out2").empty();
					$("#out2").append("기종: "+res.phone+"<br>");
					$("#out2").append("가격: "+res.price+"<br>");
					$("#out2").append("색상: "+res.color+"<br>");
				}
			});
		});
	</script>
	
	
	
	
</body>
</html>