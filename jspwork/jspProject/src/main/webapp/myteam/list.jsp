<%@page import="model.myteam.TeamDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.myteam.TeamDao"%>
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
<%
	TeamDao dao=new TeamDao();
	ArrayList<TeamDto> list=dao.getAllMyTeam();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	%>
<body>
	<a href="addForm.jsp">팀원추가</a>
	<br>
	<table class="table table-bordered" style="width: 800px">
		<tr align="center" class="table-warning">
			<th width="100">번호</th>
			<th width="120">이름</th>
			<th width="200">운전면허</th>
			<th width="250">주소</th>
			<th width="150">작성일</th>
			<th width="250">수정 | 삭제</th>
		</tr>
		
		<%
			for(int i=0;i<list.size();i++){
				TeamDto dto=list.get(i);
			
		%>
		
		<tr>
			<td align="center"><%=i+1 %></td>
			<td align="center"><%=dto.getName() %></td>
			<td align="center"><%=dto.getDriver() %></td>
			<td><%=dto.getAddr() %></td>
			<td><%=sdf.format(dto.getWriteday())%></td>
			<td>
				<button type="button" class="btn btn-info" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
				<%-- <button type="button" class="btn btn-danger" onclick="location.href='deleteMyTeam.jsp?num=<%=dto.getNum()%>'">삭제</button> --%>
				<%-- <button type="button" class="btn btn-danger" onclick="confirm('정말 삭제하시겠습니까?')?location.href='deleteMyTeam.jsp?num=<%=dto.getNum()%>':alert('취소되었습니다')">삭제</button> --%>
				<button type="button" class="btn btn-danger" onclick="funcdel(<%=dto.getNum()%>)">삭제</button>
			</td>
		</tr>
		<%} 
		%>
	</table>
	
	<script>
      function funcdel(num){
         var yes = confirm("정말 삭제 하시겠습니까?");
         if(yes){
            location.href='deleteMyTeam.jsp?num=' + num;
         }
         else{
            return;
         }
      }
	</script>
	
</body>
</html>












