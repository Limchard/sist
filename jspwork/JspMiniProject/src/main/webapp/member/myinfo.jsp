<%@page import="data.dto.MemberDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MemberDao"%>
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

$(function(){
	
	$(".btndelete").click(function(){
		
		var num=$(this).attr("num");
		// alert(num);
		var ans=confirm("정말 탈퇴하시겠습니까?");
		
		if(ans){
			location.href="member/deleteme.jsp?num="+num;
			
		}
		
	});
	
});



</script>


<%
MemberDao dao=new MemberDao();

List<MemberDto> list=dao.getAllMembers();

SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

String loginok=(String)session.getAttribute("loginok");
String myid=(String)session.getAttribute("myid");

%>

<script type="text/javascript">

	function funcdel(num){
		var yes=confirm("강퇴처리 하시겠습니까?");
		
		if(yes){
			location.href='member/memberdelete.jsp?num='+num;
		}
	}

</script>

</head>
<body>
	
	<table class="table table-bordered" style="width: 900px;">
		<%
		for(MemberDto dto:list){
		
			if(loginok!=null&&myid.equals(dto.getId())){ // 3.메뉴: 나의 정보는 로그인한 본인것만 보이게 한다
				
		%>
			
			<tr>
				<td rowspan="6" style="width: 350px; height: 300px;" align="center" valign="middle"><img alt="" src="image/cat/10.jpg" style="width: 300px;"></td>
				<td>이름: <%=dto.getName()%></td>
				<td rowspan="6" align="center" valign="middle" style="width: 200px;">
					<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='index.jsp?main=member/updateform.jsp?num=<%=dto.getNum()%>'" style="width: 50px;">수정</button><br><br>
					<%-- <button type="button" class="btn btn-outline-danger btn-sm" onclick="funcdel(<%=dto.getNum() %>)" style="width: 50px;">강퇴</button> --%>
					<button type="button" class="btn btn-outline-danger btn-sm btndelete" num=<%=dto.getNum() %> style="width: 50px;">탈퇴</button>
				</td>
			</tr>
			<tr>
				<td>아이디: <%=dto.getId() %></td>
			</tr>
			<tr>
				<td>핸드폰: <%=dto.getHp() %></td>
			</tr>
			<tr>
				<td>주소: <%=dto.getAddr() %></td>
			</tr>
			<tr>
				<td>이메일: <%=dto.getEmail() %></td>
			</tr>
			<tr>
				<td>가입일:<%=sdf.format(dto.getGaipday()) %></td>
			</tr>			
			
			<%}
		}
		%>	
	</table>

</body>
</html>