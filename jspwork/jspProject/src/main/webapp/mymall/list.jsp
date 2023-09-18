<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.mymall.mallDao"%>
<%@page import="model.mymall.mallDto"%>
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
<%
 mallDao dao=new mallDao();
 List<mallDto> list=dao.getAllMyMall();


%>
</head>
<body>

	<div style="margin: 100px 30px;">
		<h3 class="alert alert-info" style="widows: 800px;">MyMall 목록</h3>
		<br>
		<button type="button" class="btn btn-outline-info" onclick="location.href='addForm.jsp'" value="상품추가">상품추가</button>
		<br>
	<table class="table table-bordered" style="width: 800px">
		<tr align="center" class="table-warning">
			<th width="60">번호</th>
			<th width="300">상품명</th>
			<th width="160">가격</th>
			<th width="160">입고일</th>
			<th width="160">등록일</th>
			<th width="160">수정|삭제</th>
		</tr>
		
		<%
		if(list.size()==0){
			%>
			<tr>
				<td colspan="6" align="center">
					<h5>등록된 상품이 없습니다</h5>
				</td>
			</tr>	
	
		<%} else {
			
			NumberFormat nf=NumberFormat.getCurrencyInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH시");
			
			for(int i=0;i<list.size();i++){
				mallDto dto=list.get(i);
				%>
				<tr>
					<td align="center"><%=i+1 %></td>
					<td>
						<img alt="" src="<%=dto.getPhoto()%>" width="60" height="60" class="img-thumbnail" onclick="location.href='detailPage.jsp?no=<%=dto.getNo()%>'">
						
						<b><%=dto.getSangpum() %></b>
					</td>
		<%-- 			<td align="center" valign="middle"><%=nf.format(Integer.parseInt(dto.getPrice())) %></td> --%>
					<td align="center" valign="middle"><%=dto.getPrice()%></td>
					
					<td align="center" valign="middle"><%=dto.getIpgoday() %></td>
					<td align="center" valign="middle"><%=dto.getWriteday() %></td>
					<td>
						<button type="button" class="btn btn-info" onclick="location.href='updateForm.jsp?no=<%=dto.getNo()%>'">수정</button>
						<button type="button" class="btn btn-success" onclick="funcdel(<%=dto.getNo()%>)">삭제</button>
					</td>
				</tr>
			<%}	
		}
		%>
	</table>
	</div>
	
	<script type="text/javascript">
		function funcdel(no){
			if(confrim("정말 삭제하시겠습니까? ")){
				alert("삭제되었습니다.");
				location.href="deleteMyMall.jsp?no="+no;
			} else {
				alert("취소되었습니다.");
			}
		}
	
	</script>
	
</body>
</html>