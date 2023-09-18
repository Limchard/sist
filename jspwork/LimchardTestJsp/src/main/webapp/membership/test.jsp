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
<body>
	
	<div class="search-view">
  <button id="btn">검색</button>
  <input id="ele" type="text" class="hidden" />
</div>

<script type="text/javascript">

$('#btn').click(function() {
	  $('#ele').removeClass('hidden');
	});
	$('#ele').focusout(function() {
	  $(this).addClass('hidden');
	});
</script>
</body>
</html>