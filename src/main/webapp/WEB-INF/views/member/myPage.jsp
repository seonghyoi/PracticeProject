<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <!-- 이쪽에 메뉴바 포함 할꺼임 -->
    <jsp:include page="../common/menubar.jsp"/>
    
	<div class="content" style="padding: 10px 40px 40px 40px">
        <div class="innerOuter" style="padding: 0% 30% 0% 0%">
            <h2>마이페이지</h2>
            
            <br>
            
		    <table class="table">
		    <thead>
		      <tr>
		        <th>아이디</th>
		        <th>이름</th>
		        <th>전화번호</th>
		        <th>가입일시</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>${ sessionScope.loginUser.id }</td>
		        <td>${ sessionScope.loginUser.name }</td>
		        <td>${ sessionScope.loginUser.tel }</td>
		        <td>${ sessionScope.loginUser.createdDate }</td>
		      </tr>
		  </table>

			<br>

			<div class="list-group">
	  			<a href="updateForm" class="list-group-item list-group-item-action">회원 정보 수정</a>
	  			<a href="passwordUpdateForm" class="list-group-item list-group-item-action">비밀번호 수정</a>
	  			<a href="deleteForm" class="list-group-item list-group-item-action">회원 탈퇴</a>
			</div>
        </div>
    </div>
    
    <!-- 이쪽에 푸터바 포함할꺼임 -->
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>