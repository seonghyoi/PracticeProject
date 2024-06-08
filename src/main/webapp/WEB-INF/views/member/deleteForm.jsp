<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta content='width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no' name='viewport'>

<!-- Include Bootstrap CSS for styling -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- Include jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#deleteMember').on('submit', function(e) {
        if (!confirm('정말로 탈퇴하시겠습니까?')) {
            e.preventDefault(); // Form submission을 막음
        }
    });
});
</script>

</head>
<body>
	 <!-- 메뉴바 -->
    <jsp:include page="../common/menubar.jsp"/>
    
    <div class="content" style="padding: 10px 40px 40px 40px">
        <div class="innerOuter" style="padding: 0% 30% 0% 0%">
            <h2>회원 탈퇴</h2>
            <br>
			
			<form id="deleteMember" action="deleteMember" class="was-validated" method="post">
			  <div class="form-group">
				<input type="hidden" id="userId" name="userId" value="${ sessionScope.loginUser.userId }">
			  </div>
			  <div class="form-group">
			    <label for="pw">회원 탈퇴를 원하시면 비밀번호를 입력해 주세요:</label>
			    <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw" required>
			    <div class="valid-feedback">입력 완료</div>
			    <div class="invalid-feedback">비밀번호를 입력해 주세요.</div>
			  </div>
			  <button type="submit" class="btn btn-primary">회원 탈퇴</button>
			</form>
        </div>
    </div>

    <!-- 푸터바 -->
    <jsp:include page="../common/footer.jsp"/>
    
</body>
</html>