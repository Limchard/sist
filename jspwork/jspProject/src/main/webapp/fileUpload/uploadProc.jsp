<%@page import="java.util.Enumeration"%>
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
	//tomcat에 업로드된 프로젝트 경로 구하기
	ServletContext context=getServletContext();
	//프로젝트의 upload의 실제 경로 구하기
	String realFolder=context.getRealPath("/upload");
	
	System.out.println(realFolder);
	
	//업로드시 허용되는 크기 지정
	int uploadsize=1024*1024*3; //3mb
	
	MultipartRequest multi=null;
	
	try{
		multi=new MultipartRequest(request,realFolder,uploadsize,"utf-8",new DefaultFileRenamePolicy());
	
		//입력된 값들 읽어오기
		String writer=multi.getParameter("nick");
		%>
	
		<h2>작성자명: <%=writer %></h2>
		
		<%
			//파일타입이 여러개인 경우
			//getFileNames() : input 타입에서 속성이 file 로 된 이름들을 반환(반환값:Enumeration...인터페이스(api))
			Enumeration forNames=multi.getFileNames(); //file타입만 얻어옴
			
			//복수형으로 여러 값을 얻어와야하기 때문에 while(forNames.hasMoreElements()) 사용 -->(**.next())와 같은 사용
			while(forNames.hasMoreElements())
			{
				String fileName=(String)forNames.nextElement(); //다음값 계속 반환//반환값이 object이기 때문에 String형변환해야함
				System.out.println("file type의 실제 name: "+fileName);
				
				//실제 업로드된 파일명 얻기
				String uploadName=multi.getFilesystemName(fileName); //form의 photo1,2,3 실제 파일명 확인
				
				//파일선택안하면 null
				if(uploadName!=null) //null이 아닐때만 얻어오겠다
				{%>
					<%-- 여러개 업로드할 때 figure로 감싸주면 잘 정렬됨 --%>
					<figure>
					<%-- 최대 크기 200px로 조정 --%>
					<img src="../upload/<%=uploadName %>" style="max-width: 200px;" border="1"><br>
					<%-- 업로드 파일명 --%>	
					<b><%=uploadName %></b>
					</figure>
				<%}
			}
		%>
	<%} catch(Exception e){
		
	}
%>
</body>
</html>