<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<!-- alertify -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
<!-- alertify css -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
   <!-- Default theme -->
   <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
   <!-- Semantic UI theme -->
   <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .nav-link {
            text-decoration: none;
            color: black;
        }
         #navi{
           /* border : 1px solid blue;*/
            list-style-type: none;
            margin: 0;
            
                padding :0;
                height: 100%;
        }
        #navi >li{
            /*border: 1px solid blue;*/
            float: center;
           
            text-align: center;
        }
        
          #navi a:hover{
            font-size: 16px;
            color:  rgb(240,165,0);
        }
        #navi>li>ul{
            list-style-type: none;
            padding: 0;
            display: none;
        }
        #navi>li>ul>a{
           
         font-size: medium;
        font-weight: 600;

        }
         #navi>li>ul>a:hover{
             font-size: medium;
        font-weight: 600;

        }
        
        #navi>li>a:hover+ul{/*동위레벨 선택자
            평소에는 안보여지다가 마우스가 올라갈때만 효과를 부여*/
            display: block;
        } 
        #navi>li>ul:hover{
            display: block;
        }
    </style>
</head>
<body>


	


<div class="content1">

        <ul id="navi">
           <li><a class="nav-link" aria-current="page" href="##" style="text-align: center;font-family: 'Do Hyeon', sans-serif;

font-size: 30px;">조회</a>
 <ul>
           <li><a class="nav-link" href="${pageContext.request.contextPath}/list/loList"style="text-align: center;font-family: 'Do Hyeon', sans-serif;

font-size: 20px;">여신</a></li>
             <li><a class="nav-link" href="${pageContext.request.contextPath}/list/dpList"style="text-align: center;font-family: 'Do Hyeon', sans-serif;

font-size: 20px;">수신</a></li>
<li><a class="nav-link" href="${pageContext.request.contextPath}/list/coList"style="text-align: center;font-family: 'Do Hyeon', sans-serif;

font-size: 20px;">공통</a></li>
           
           </ul>
</li>
             <br><br><br><br><br>
          <li>
            <a href="##" class="nav-link" style="text-align: center;font-family: 'Do Hyeon', sans-serif;

font-size: 30px; color:orange">기능</a>
            <ul>
           <li><a class="nav-link" href="${pageContext.request.contextPath}/enroll/enroll"style="text-align: center;font-family: 'Do Hyeon', sans-serif;

font-size: 20px;">이미지 등록</a></li>
             <li><a class="nav-link" href="${pageContext.request.contextPath}/download/download"style="text-align: center;font-family: 'Do Hyeon', sans-serif;

font-size: 20px;">이미지 다운로드</a></li>
           
           </ul>
           
        </li>
           
          
           
           
        </ul>
        


   </div>
</body>
</html>