<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Diphylleia&family=Dokdo&family=Nanum+Brush+Script&family=Nanum+Gothic+Coding&family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	ServletContext context=getServletContext();
	//가상의 폴더를 써준다...업로드할 경로
	String realFolder=context.getRealPath("/upload");
	
	//realFolder가 생성자단에 들어가야함
	System.out.println(realFolder);
	
	int filesize=1024*1024*3; //3mb 맨 뒤 숫자로 몇 메가일지 결정
	
	//생성자
	MultipartRequest multi=null;
	
	//MultipartRequest 라는 클래스를 사용 생성자 (request,fileDirectory(업로드할 경로),1024*5(업로드할 파일의 크기),
	//"utf-8"(한글타입) , new DefaultFileRenamePolicy() <-같은이름이 있을경우 다른이름으로 저장)
	
	try{
	multi=new MultipartRequest(request,realFolder,filesize,"utf-8",new DefaultFileRenamePolicy());
	
	//form에 있는 name과 ""안 이름이 같아야함
	String writer=multi.getParameter("writer");
	String subject=multi.getParameter("subject");
	String uploadName=multi.getFilesystemName("uFile");
	//uFile의 진짜이름
	String originalFileName=multi.getOriginalFileName("uFile");
	%>
	
	<table class="table" style="width: 300px;">
		<tr>
			<th>글쓴이</th>
			<td><%=writer %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=subject %></td>
		</tr>
		<tr>
			<th>업로드파일명</th>
			<%-- 프로젝트 내 파일 경로 --%>
			<td><img src="../upload/<%=uploadName%>" style="width: 100px;"></td>
		</tr>
		<tr>
			<th><%=uploadName%></th>
		</tr>
		<tr>
			<th>원래파일명</th>
			<td><%=originalFileName %></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="다시업로드"
				onclick="location.href='action.jsp'">
			</td>
		</tr>
	</table>	
	
	
	<%}catch(Exception e){
		//업로드 오류 보여주는 문구
		System.out.println("업로드 오류: "+e.getMessage());
	}
	//브라우저로 업로드하면 콘솔창에 저장된 경로가 나와서 이동하면 파일 업로드 된 것을 확인 가능
%>
</body>
</html>