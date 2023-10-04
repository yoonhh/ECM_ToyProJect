<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<title>Document</title>
</head>

<style>
#lo_conshow {
	margin-right: 0 !important;
	margin-left: 40 !important;
	/*           display: flex; */
	flex-wrap: wrap;
	border-radius: 12px;
	border: 4px solid SSSS;
}
</style>

<c:if test="${not empty alertMsg}">
	<script>
	alertify.alert("Success",'${alertMsg}');// 변수를 문자열로
	</script>
		<c:remove var="alertMsg" scope="session" />
	</c:if>


<body>



	<div class="list-form" style="margin: auto; padding-left: 50px;">
		<fieldset id="mForm">
			<div class="list-content">
				<div class="list-a">
					<button class="lo_con" type="button" onclick="show(this);"
						id="lo_con" name="show" value="03" onchange='call()'>
						<span class="r_loan">여신</span>
					</button>
					<button class="dp_con" type="button" onclick="show(this);"
						id="dp_con" name="show" value="02" onchange='call2()'>
						<span class="r_deposit">수신</span>
					</button>
					<button class="com_con" type="button" onclick="show(this);"
						id="com_con" name="show" value="01" onchange='call2()'>
						<span class="r_common">공통</span>
					</button>
					<!-- <button class="del_show" type="button" onclick="show(this);"
						id="del_show" name="show">
						<span class="r_del">삭제</span>
					</button> -->

				</div>
				<br> <br>
			</div>
			<div id="lo_conshow" class="box">

				<fieldset>
					<legend>여신 이미지 등록 양식</legend>
					<form id="sellInsertForm"
						action="${pageContext.request.contextPath}/enroll/loenroll.do"
						enctype="multipart/form-data" method="post">


						<label for="mid">중분류</label> <select id="lo_mid" onchange='call()'>
						<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${lolist }">
							
								<option value="${list.midCateCd }">${list.midCate }</option>
							</c:forEach>

							<br>

						</select> <label for="mid">소분류</label> <select id="lo_sub"
							onchange='call()'>
							<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${lolist }">
							
								<option value="${list.subCateCd }">${list.subCate }</option>
							</c:forEach>

						</select> <br> *문서코드<br> <input type="text" id="doccode"
							name="docCd" value="" readonly> <br> <label
							for="upfile">첨부파일</label> <br> <input type="file"
							name="file1" onchange="checkFile(this)" id="file" required><br>
						<br> *이름<br> <input type="text" size="40" name="custNm"
							maxlength="13" minlength="3" required> <br> *주민번호<br>
						<input type="text" size="13" name="rrnNo" maxlength="13" minlength="13" placeholder="숫자만 입력해주세요"
							minlength="13" required> <br> <label for="userCd">등록사번</label>
						<select id="userCd" name="enrUserId" required>
						<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${emplist }">
								<option value="${list.userId }" required>${list.userId }</option>
							</c:forEach>



						</select> <br> <label for="orgCd">조직코드</label> <select id="orgCd"
							name="orgCd" required>
							<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${emplist }">
								<option value="${list.orgCd }" required>${list.orgCd }</option>
							</c:forEach>
						</select>



						<div class="insertBtmArea">

							<button type="submit" class="insertBtn" id="insertBtn">등록</button>
						</div>

					</form>
				</fieldset>
			</div>
			<div class="box box2" id="dp_conshow" style="display: none;">
				<fieldset>
					<legend>수신 이미지 등록 양식</legend>
					<form id="sellInsertForm"
						action="${pageContext.request.contextPath}/enroll/dpenroll.do"
						enctype="multipart/form-data" method="post">


						<label for="mid">중분류</label> <select id="dp_mid"
							onchange='call2()'>
							<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${dplist }">
								<option value="${list.midCateCd }">${list.midCate }</option>
							</c:forEach>

							<br>

						</select> <label for="mid">소분류</label> <select id="dp_sub"
							onchange='call2()'>
		<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${dplist }">
								<option value="${list.subCateCd }">${list.subCate }</option>
							</c:forEach>

						</select> <br> *문서코드<br> <input type="text" id="doccode1"
							name="docCd" value="" readonly> <br> <label
							for="upfile">첨부파일</label> <br> <input type="file"
							name="file1" onchange="checkFile(this)" id="file" required><br>
						<br> *이름<br> <input type="text" size="40" name="custNm"
							maxlength="13" minlength="3" required> <br> *주민번호<br>
						<input type="text" size="13" name="rrnNo" maxlength="13" minlength="13" placeholder="숫자만 입력해주세요"
							minlength="13" required> <br> <label for="userCd">등록사번</label>
						<select id="userCd" name="enrUserId"required>
						<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${emplist }">
								<option value="${list.userId }"required>${list.userId }</option>
							</c:forEach>



						</select> <br> <label for="orgCd">조직코드</label> <select id="orgCd"
							name="orgCd" required>
							<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${emplist }">

								<option value="${list.orgCd }" required>${list.orgCd }</option>
							</c:forEach>
						</select>



						<div class="insertBtmArea">
							
							<button type="submit" class="insertBtn" id="insertBtn">등록</button>
							
						</div>

					</form>
				</fieldset>

			</div>
			<div class="box box3" id="com_conshow" style="display: none;">

				<fieldset>
					<legend>공통 이미지 등록 양식</legend>
					<form id="sellInsertForm"
						action="${pageContext.request.contextPath}/enroll/coenroll.do"
						enctype="multipart/form-data" method="post">


						<label for="mid">중분류</label> <select id="co_mid"
							onchange='call3()'>
						<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${comlist }">
								<option value="${list.midCateCd }">${list.midCate }</option>
							</c:forEach>

							<br>

						</select> <label for="mid">소분류</label> <select id="co_sub"
							onchange='call3()'>
							<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${comlist }">
								<option value="${list.subCateCd }">${list.subCate }</option>
							</c:forEach>

						</select> <br> *문서코드<br> <input type="text" id="doccode2"
							name="docCd" value="" readonly> <br> <label
							for="upfile">첨부파일</label> <br> <input type="file"
							name="file1" onchange="checkFile(this)" id="file" required><br>
						<br> *이름<br> <input type="text" size="40" name="custNm"
							maxlength="13" minlength="3" required> <br> *주민번호<br>
						<input type="text" size="13" name="rrnNo" maxlength="13" minlength="13" placeholder="13자리 입력해주세요"
							minlength="13" required> <br> <label for="userCd">등록사번</label>
						<select id="userCd" name="enrUserId" required>
						<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${emplist }">
								<option value="${list.userId }"required>${list.userId }</option>
							</c:forEach>



						</select> <br> <label for="orgCd" >조직코드</label> <select id="orgCd"
							name="orgCd" required>
							<option value="" style="display:none">선택</option>
							<c:forEach var="list" items="${emplist }">
								<option value="${list.orgCd }" required>${list.orgCd }</option>
							</c:forEach>
						</select>



						<div class="insertBtmArea">

							<button type="submit" class="insertBtn" id="insertBtn">등록</button>
						</div>

					</form>
				</fieldset>
			</div>

			<div class="box box4" id="del_showshow" style="display: none;">



				<%-- <form id="sellInsertForm" method="POST"
					action="${pageContext.request.contextPath}/enroll/delete.do">
					<input type="text" name="delete" />
					<button type="submit" value="delete">삭제</button>


				</form> --%>

			</div>



		</fieldset>

		<button type="button" class="btn btn-secondary" class="last1"
			onclick="history.back();">이전으로</button>

	</div>


	<!-- 업무 나누는 스크립트 -->
	<script>
                function show(element){
                let tag = document.getElementsByClassName("box");
            
                for(let i=0; i<tag.length; i++){
                        if(element.id+"show" == tag[i].id){
                            tag[i].style.display = "block";
                            tag[i].style.animation = "fadeIn";
                            tag[i].style.animationDuration = "1s";
                                
                        }else{
                            tag[i].style.display = "none";
                        }
                    }
                }
                
            </script>
	<!-- 여신 문서코드 생성 스크립트 -->
	<script>
            function call(){
           	const name1  = document.getElementById("lo_con").value;
            const name2= document.getElementById("lo_mid").value;
            const name3 = document.getElementById("lo_sub").value;
            const result = name1+name2+name3;
            
            console.log(result);
            $('#doccode').val(result);
            }
            </script>

	<!-- 수신 문서코드 생성 스크립트 -->
	<script>
            function call2(){
           	const name1  = document.getElementById("dp_con").value;
            const name2= document.getElementById("dp_mid").value;
            const name3 = document.getElementById("dp_sub").value;
            const result = name1+name2+name3;
            
            console.log(result);
            $('#doccode1').val(result);
            }
            </script>

	<!-- 수신 문서코드 생성 스크립트 -->
	<script>
            function call3(){
           	const name1  = document.getElementById("com_con").value;
            const name2= document.getElementById("co_mid").value;
            const name3 = document.getElementById("co_sub").value;
            const result = name1+name2+name3;
            
            console.log(result);
            $('#doccode2').val(result);
            }
            </script>


	<!-- 확장자 제한 스크립트 -->
	<script>
            function checkFile(f){

            	// files 로 해당 파일 정보 얻기.
            	var file = f.files;

            	// file[0].name 은 파일명 입니다.
            	// 정규식으로 확장자 체크
            	if(!/\.(hwp|jpg|pdf|xls|ppt|xlsx|doc|docx|pptx|tif|bmp|png|)$/i.test(file[0].name)) alert('hwp,jpg,pdf,xls,ppt,xlsx,doc,docx,pptx,bmp,tif,png 파일만 선택해 주세요.\n\n현재 파일 : ' + file[0].name);

            	// 체크를 통과했다면 종료.
            	else return;

            	// 체크에 걸리면 선택된  내용 취소 처리를 해야함.
            	// 파일선택 폼의 내용은 스크립트로 컨트롤 할 수 없습니다.
            	// 그래서 그냥 새로 폼을 새로 써주는 방식으로 초기화 합니다.
            	f.outerHTML = f.outerHTML;
            }
            </script>

	<script>
            
           
           

            </script>

</body>
</html>