<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

<style>

	#header_2>a {
		color: black;
        text-decoration: none; /* 링크의 밑줄 제거 */
    }

    /* 마우스를 올렸을 때 a 태그에 대한 스타일 지정 */
    #header_2>a:hover {
    	color: skyblue; /* 링크의 텍스트 색상을 하늘색으로 지정 */
        text-decoration: underline; /* 링크에 마우스를 올렸을 때 밑줄 추가 */
    }

	#header_2>a:hover{cursor: pointer;}
</style>

</head>
<body>

	<c:if test="${ !empty msg }">
		<script>
			alert("${msg}");
		</script>
		<c:remove var="msg" scope="session"/>
	</c:if>


	<div id="header">

        <div id="header_1">
        
	        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <ul class="navbar-nav">
			    <li class="nav-item">
			      <a class="nav-link" href="${ pageContext.servletContext.contextPath }">HOME</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="${ pageContext.servletContext.contextPath }/board/boardMain?page=1">게시판</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="#">사진</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="#">지도</a>
			    </li>
			  </ul>
			</nav>
			
        </div>
        
        <div id="header_2" style="padding: 10px 20px 10px 10px; text-align: right;">
            
                <!-- 로그인 전 -->
                <c:if test="${ empty sessionScope.loginUser }">
	                <a href="${ pageContext.servletContext.contextPath }/member/enrollForm" >회원가입</a> &nbsp;|&nbsp;
	                <a data-toggle="modal" data-target="#loginModal">로그인</a> 
                </c:if>
                
                <c:if test="${ !empty sessionScope.loginUser }">
	                <label>[&nbsp;&nbsp;'${ sessionScope.loginUser.name }'님 환영합니다!&nbsp;&nbsp;]</label> &nbsp;&nbsp;&nbsp;
	                <a href="${ pageContext.servletContext.contextPath }/member/myPage">마이페이지</a> &nbsp;|&nbsp;
	                <a href="${ pageContext.servletContext.contextPath }/member/logout">로그아웃</a>
                </c:if>  
                
        </div>
        
    </div>
    
    <div class="modal fade" id="loginModal">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">로그인</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button> 
            </div>

            <form action="${ pageContext.servletContext.contextPath }/member/login" method="post">
                <!-- Modal Body -->
                <div class="modal-body">
                    <label for="userId" class="mr-sm-2">아이디:</label>
                    <input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter ID" id="userId" name="id"> <br>
                    <label for="userPwd" class="mr-sm-2">비밀번호:</label>
                    <input type="password" class="form-control mb-2 mr-sm-2" placeholder="Enter password" id="userPwd" name="pw">
                </div>
                
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">로그인</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>
            </form>
            </div>
        </div>
    </div>


</body>
</html>