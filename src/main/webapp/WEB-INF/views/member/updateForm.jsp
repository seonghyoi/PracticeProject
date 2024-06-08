<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <!-- 메뉴바 -->
    <jsp:include page="../common/menubar.jsp"/>
    
    <div class="content" style="padding: 10px 40px 40px 40px">
        <div class="innerOuter" style="padding: 0% 30% 0% 0%">
            <h2>회원 정보 수정</h2>
            <br>

			<form id="updateForm" action="updateMember" class="was-validated" method="post">
			  <div class="form-group">
				<input type="hidden" id="userId" name="userId" value="${ sessionScope.loginUser.userId }">
			  </div>
			  <div class="form-group">
			    <label for="id">아이디:</label>
			    <input type="text" class="form-control" id="id" value="${ sessionScope.loginUser.id }" name="id" disabled>
			  </div>
			  <div class="form-group">
			    <label for="name">이름:</label>
			    <input type="text" class="form-control" id="name" value="${ sessionScope.loginUser.name }" name="name" required>
			    <div class="valid-feedback">입력 완료</div>
			    <div class="invalid-feedback">이름을 입력해 주세요.</div>
			  </div>
			  <div class="form-group">
			    <label for="tel">전화번호:</label>
			    <input type="text" class="form-control" id="tel" value="${ sessionScope.loginUser.tel }" name="tel" required>
			    <div class="valid-feedback">입력 완료</div>
			    <div class="invalid-feedback">전화번호를 입력해 주세요.</div>
			  </div>
			  <button type="submit" class="btn btn-primary">회원 정보 수정</button>
			</form>
        </div>
    </div>


    <!-- 푸터바 -->
    <jsp:include page="../common/footer.jsp"/>
    
</body>
</html>