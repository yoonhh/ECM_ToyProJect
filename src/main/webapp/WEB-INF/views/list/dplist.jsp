<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="list" value="${map.list }" />
<c:set var="pi" value="${map.pi }" />
<c:if test="${!empty param.condition }">
	<c:set var="sUrl"
		value="&condition=${param.condition}&keyword=${param.keyword }" />
</c:if>
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
#searchForm {
	width: 80%;
	margin: auto;
}

#searchForm>* {
	float: left;
	margin: 5px;
}

.select {
	width: 20%;
}

.text {
	width: 53%;
}

.searchBtn {
	width: 20%;
}

#rno {
	display: none;
}

#nulltd {
	pointer-events: none
}
</style>

</head>
<body>
	<h1>수신</h1>
	<div class="content">
<a href ="${pageContext.request.contextPath}">홈으로</a>
		<form id="searchForm" align="center">
			<div class="select">
				<input type="hidden" name="currentPage" value="1"> <select
					class="custom-select" name="condition">

					<option  ${(param.condition == "imgKey")? "selected":""} value="imgKey">이미지키</option>
					<option ${(param.condition == "custNo")? "selected":""} value="custNo">고객번호</option>

				</select>




			</div>

			<div class="text">


				<input type="text" class="form-control" name="keyword"
					value="${param.keyword }">
			</div>
			<button type="submit" class="searchBtn btn btn-secondary">검색</button>

		</form>

		<br> <br>
		<div class="innerOuter" style="padding: 5% 10%;">
			<table class="table table-hover list">
				<thead>
					<tr>
						<th scope="col" style="text-align: center;">이미지키</th>
						<th scope="col" width="420px">고객번호</th>
						<th scope="col">고객이름</th>
						<th scope="col">등록 사번</th>
						



					</tr>
				</thead>
				<tbody>

					<c:if test="${empty list }">
						<td colspan="5" id="nulltd">등록된 수신 업무가 없습니다.</td>
					</c:if>
					<c:forEach var="l" items="${list }">
						<tr>
							<td id="rno">${l.rrnNo }</td>
							<td id="lno">${l.imgKey }</td>
							<td>${l.custNo }</td>
							<td>${l.custNm }</td>
							<td>${l.enrUserId}</td>
							
							<td><input type="hidden" value="${l.rrnNo }" /></td>

						</tr>
					</c:forEach>

				</tbody>
			</table>

			<script>
				$(
						function() {
							$("tbody>tr")
									.click(
											function() {
												let rno = $(this).children()
														.eq(0).text();

												location.href = '${pageContext.request.contextPath}/detail/dpdetail/'
														+ rno;
											});
						})
			</script>

		</div>

		<c:set var="url" value="?currentPage=" />
		<!-- 컨트롤러에서 PathVariable로 가져옴 -->

		<!-- 페이지 이동기능 구현 -->
		<div id="pagingArea">
			<ul class="pagination justify-content-center">
				<c:choose>
					<c:when test="${pi.currentPage eq 1 }">
						<li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="${url}${pi.currentPage -1 }${sUrl}">Previous</a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="item" begin="${pi.startPage }" end="${pi.endPage }">
					<li class="page-item"><a class="page-link"
						href="${url}${item}${sUrl}">${item}</a></li>
				</c:forEach>

				<c:choose>
					<c:when test="${pi.currentPage eq pi.maxPage }">
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="${url}${pi.currentPage +1 }${sUrl}">Next</a></li>
					</c:otherwise>
				</c:choose>
			</ul>

		</div>

		<button type="button" class="btn btn-secondary" class="last1"
			onclick="history.back();">이전으로</button>
	</div>
</body>
</html>