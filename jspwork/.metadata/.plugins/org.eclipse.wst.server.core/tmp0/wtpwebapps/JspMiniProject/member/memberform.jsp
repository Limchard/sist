<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

$(function() {
	// id 중복체크
	$("#btncheck").click(function(){
		
		// id읽어오나 확인
		var id=$("#id").val();
		// alert(id);
		
		$.ajax({
			
			type:"get",
			url:"member/idsearch.jsp",
			dataType:"json",
			data:{"id":id},
			success:function(data){
				
				// alert(data.count);
				 if(data.count==1){
					//alert(" 이미 가입된 아이디 입니다. \n 다시 입력해 주세요.");
					$("span.idsuccess").css("color","red").text("이미 가입된 아이디 입니다.");
					$("#id").val("");
					$("#id").focus();
				}else{
					//alert("사용 가능한 아이디 입니다.")
					$("span.idsuccess").css("color","blue").text("사용 가능한 아이디 입니다.");
				} 
			}	
			
		});
		
	});
	
	// 선택 이메일 주소 넣기.. 혹은 직접입력
	$("#selemail").change(function(){
		var e=$(this).val();
		//alert(e);
		
		if(e=='-'){
			$("#email2").val("");
			$("#email2").focus();
		} else {
			$("#email2").val(e);
		}
		
	});

});

	function check(f) {
		if(f.pass.value!=f.pass2.value){
			alert("비밀번호가 서로 다릅니다.");
			f.pass.value="";
			f.pass2.value="";
			
			return false; // form태그의 action 이 호출되지 않는다. 
		}
	}
	
	

</script>
</head>
<body>
	<form action="member/memberproc.jsp" method="post" onsubmit="return check(this)"> <!-- onsubmit="return check(this) : submit 할때 check(this) 에 대해 한번 확인하고 submit 하자! 라는 뜻	 -->
		<table class="table table-bordered" style="width: 500px;">
			<caption align="top"><b>회원가입</b></caption>
			<tr>
				<th style="width: 100px; background-color: pink;">아이디</th>
				<td>
					<input type="text" name="id" id="id" class="form-group" required="required" style="width: 120px;" >
					<button type="button" class="btn btn-info btn-sm" id="btncheck">중복체크</button>
					<span class="idsuccess"></span>
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: pink;">비밀번호</th>
				<td>
					<input type="password" name="pass" class="form-group" required="required" style="width: 120px;" placeholder="비밀번호">
					<input type="password" name="pass2" class="form-group" required="required" style="width: 120px;" placeholder="비밀번호확인">
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: pink;">이름</th>
				<td>
					<input type="text" name="name" class="form-group" required="required" style="width: 120px;" placeholder="이름" >
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: pink;">핸드폰</th>
				<td>
					<input type="text" name="hp" class="form-group" required="required" style="width: 200px;" placeholder="핸드폰번호" >
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: pink;">주소</th>
				<td>
					<input type="text" name="addr" class="form-group" required="required" style="width: 200px;" placeholder="주소" >
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: pink;">이메일</th>
				<td>
					<input type="text" name="email1" id="email1" class="form-group" required="required" style="width: 120px;" placeholder="이메일" >
					<b>@</b>
					<input type="text" name="email2" id="email2" class="form-group" required="required" style="width: 150px;" placeholder="이메일주소">
					<select id="selemail" class="form-group">
						<option value="-">직접입력</option>
						<option value="naver.com" selected>네이버</option>
						<option value="gmail.com">구글</option>
						<option value="kakao.com">카카오</option>
						<option value="hanmail.net">다음</option>
						<option value="nate.com">네이트</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success" style="width: 100px;">회원가입</button>
					<button type="reset" class="btn btn-outline-warning" style="width: 100px;">초기화</button>
					
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>