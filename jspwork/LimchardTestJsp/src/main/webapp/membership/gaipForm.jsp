<%@page import="model.membership.MembershipDto"%>
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

<style type="text/css">

form{
margin: 20px;
}

</style>

<script>
	$(function(){
		$("#hp1").keyup(function(){
			if($(this).val().length==3){
				$("#hp2").focus();
			}
		});
		
		
		$("#hp2").keyup(function(){
			if($(this).val().length==4){
				$("#hp3").focus();
			}
		});
	});
	
</script>

<%

MembershipDto dto=new MembershipDto();

%>
<body>

<form action="gaipAction.jsp" method="post">
<h4 style="color: gray;">회원가입</h4>
	
	<table class="table table-bordered" style="width: 500px;">
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" placeholder="아이디를 입력하세요" required="required" name="id">
				<input type="button" value="중복체크" class="btn btn-info" onclick="location.idCheck.jsp?id=<%=dto.getId()%>">
			</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" placeholder="비밀번호를 입력하세요" required="required" name="pw">
			</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td>
				<input type="text" placeholder="이름을 입력하세요" required="required" name="name">
			</td>
		</tr>
		
		<tr>
			<th>핸드폰번호</th>
			<td>
				<input type="text" placeholder="010" required="required" id="hp1" name="hp1" maxlength="3" size="3">
				<b>-</b>
				<input type="text" placeholder="0000" required="required" id="hp2" name="hp2" maxlength="4" size="4">
				<b>-</b>
				<input type="text" placeholder="0000" required="required" id="hp3" name="hp3" maxlength="4" size="4">
			</td>
		</tr>
		
		<tr>
			<th>생일</th>
			<td>
				<input type="date" placeholder="핸드폰번호를 입력하세요" required="required" name="birth">
			</td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td>
				<label><input type="radio" required="required" name="gender" value="남자">남자&nbsp;&nbsp;</label>
				<label><input type="radio" required="required" name="gender" value="여자">여자&nbsp;</label>
			</td>
		</tr>
		
		<tr>
			<th>내/외국인</th>
			<td>
				<label><input type="radio" required="required" name="race" value="내국인">내국인&nbsp;&nbsp;</label>
				<label><input type="radio" required="required" name="race" value="외국인">외국인&nbsp;</label>
			</td>
		</tr>
		
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" placeholder="이메일을 입력하세요" required="required" name="email">
			</td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td>
				<input type="text" placeholder="주소를 입력하세요" required="required" name="addr">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" class="btn btn-success" value="회원가입">
			</td>
		</tr>
	</table>
</form>
</body>
</html>