<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/2e05403237.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>Insert title here</title>
<style>
.del {
	display: none;
}

#test_obj {
	
}
</style>
</head>
<body>


	<div class="innerOuter" style="padding: 5% 10%;">
		<table class="table table-hover list">
			<thead>
				<tr>
					<th scope="col" style="text-align: center;">엘리먼트아이디</th>
					<th scope="col" width="420px">시퀀스</th>
					<th scope="col" width="420px">문서코드</th>
					<th scope="col" width="420px">등록날짜</th>
					<th scope="col" width="420px"></th>
					<th scope="col" width="420px">이미지</th>



				</tr>
			</thead>
			<tbody>

				<c:if test="${empty dplist }">
					<td colspan="6">등록된 수신 업무가 없습니다.</td>
				</c:if>
				<c:forEach var="d" items="${dplist }">
					<tr>
						<td id="lno">${d.elementId }</td>
						<td>${d.enSeq }</td>
						<td>${d.docCd }</td>
						<td>${d.enrDtm }</td>
						<td class="del">${d.delYN }</td>


						<td><button type="button"
								onclick="changeStatus('${d.elementId}')">삭제</button></td>

						
						<td>
							 <%-- <img id="test_obj" src="\downImg/${d.elementId }"
							onerror="this.style.display='none'" /> --%>   <img id="test_obj"
							src="/downImg/${d.elementId }"
							onerror="this.style.display='none'" /> 
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

	<script>
			function changeStatus(elementId){
		      var elementId = elementId;
		        
		        $.ajax({
		           url : '${pageContext.request.contextPath}/dpchangeStatus',
		             type : 'post',
		            data : {elementId :elementId},
		            success : function(result){
		                   if(result == 1) {
		                	   alert("성공")                 
		                	  
		                   }
		                   setTimeout(function() {
		                      	  location.reload();
		                    	}, 1500);
		             },
		             error:function(){
		                  console.log("실패");
		               }
		        });
		     };
			</script>






</body>
</html>