<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	
	<!-- alertify -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
<!-- alertify css -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
   <!-- Default theme -->
   <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
   <!-- Semantic UI theme -->
   <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
</head>
<body>
 
<c:if test="${not empty alertMsg }">
	<script>
	alertify.alert("다운 성공",'${alertMsg}');// 변수를 문자열로
	</script>
	<c:remove var="alertMsg" scope="session"/>
	</c:if>
<form action="download.do">
		<input type="text" name="test" />
		<button type="submit" value="test">다운</button>
	</form>
	
	<button type="button" class="btn btn-secondary" class="last1"
			onclick="history.back();">이전으로</button>
</body>
</html>