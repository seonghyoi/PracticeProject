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
            <h2>비밀번호 수정</h2>
            <br>
			
			<form id="passwordUpdateForm" action="passwordUpdate" class="was-validated" method="post">
			  <div class="form-group">
				<input type="hidden" id="userId" name="userId" value="${ sessionScope.loginUser.userId }">
			  </div>
			  <div class="form-group">
			    <label for="pw">새 비밀번호:</label>
			    <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw" required>
			    <div class="valid-feedback">입력 완료</div>
			    <div class="invalid-feedback">비밀번호를 입력해 주세요.</div>
			  </div>
			  <div class="form-group">
            	<label for="pwConfirm">새 비밀번호 확인:</label>
            	<input type="password" class="form-control" id="pwConfirm" placeholder="Confirm password" name="pwConfirm" required>
           		<div class="valid-feedback">비밀번호 확인 완료</div>
           		<div class="invalid-feedback">비밀번호를 다시 확인해 주세요.</div>
       	 	  </div>
			  <button type="submit" class="btn btn-primary">비밀번호 수정</button>
			</form>
        </div>
    </div>
    
    <script>
		function validatePasswords() {
		    var pw = document.getElementById("pw").value;
		    var pwConfirm = document.getElementById("pwConfirm").value;
		
		    if (pw !== pwConfirm) {
		        document.getElementById("pwConfirm").setCustomValidity("비밀번호가 일치하지 않습니다. 다시 확인해 주세요.");
		        return false;
		    } else {
		        document.getElementById("pwConfirm").setCustomValidity("");
		        return true;
		    }
		}
		
		document.getElementById("pw").addEventListener('input', validatePasswords);
		document.getElementById("pwConfirm").addEventListener('input', validatePasswords);
	</script>

    


    <!-- 푸터바 -->
    <jsp:include page="../common/footer.jsp"/>
    
</body>
</html>