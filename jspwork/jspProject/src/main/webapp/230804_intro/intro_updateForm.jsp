<%@page import="model.intro.IntroDao"%>
<%@page import="model.intro.IntroDto"%>
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
<script type="text/javascript">

<% 

	String num=request.getParameter("num");
	IntroDao dao=new IntroDao();
	IntroDto dto = dao.getData(num);
	
%>

$(function(){
	
	$("#hp2").keyup(function(){
		if($(this).val().length==4){
			$("#hp3").focus();
		}
	})
})

</script>
</head>
<body>
	<form action="intro_updateAction.jsp" method="post">
	<h3>인원수정</h3>
		<table class="table table-bordered" style="width: 500px">
			<tr>
				<th>이름</th>
				<td><input type="text" class="form-control" name="name" required="required" placeholder="이름" style="width: 150px"></td>
			</tr>
			
			<tr>
				<th>혈액형</th>
				<td>
					<label><input type="radio" name="blood" <%=dto.getBlood().equals("A형")?"checked":"" %> style="width: 25px;">A형</label> 
					<label><input type="radio" name="blood" <%=dto.getBlood().equals("B형")?"checked":"" %> style="width: 25px;">B형 </label>
					<label><input type="radio" name="blood" <%=dto.getBlood().equals("O형")?"checked":"" %> style="width: 25px;">O형 </label>
					<label><input type="radio" name="blood" <%=dto.getBlood().equals("AB형")?"checked":"" %> style="width: 25px;">AB형 </label>
				</td>
			</tr>
			
			<tr>
				<th>핸드폰번호</th>
				<td>
					<select id="hp1" name="hp1" >
						<option>010</option>
						<option>011</option>
						<option>016</option>
						<option>017</option>
						<option>018</option>
					</select>
					<b>-</b>
					<input type="text" id="hp2" name="hp2" maxlength="4" style="width: 80px">
					<b>-</b>
					<input type="text" id="hp3" name="hp3" maxlength="4" style="width: 80px">
				</td>
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input type="text" name="city" class="form-control" required="required" placeholder="<%=dto.getCity()%>"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success">수정</button>
					<button type="button" class="btn btn-info" onclick="location.href='intro_list.jsp'">목록</button>
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>