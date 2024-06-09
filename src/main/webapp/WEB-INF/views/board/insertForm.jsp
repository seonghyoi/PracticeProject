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
	<jsp:include page="../common/menubar.jsp" />

	<div class="content" style="padding: 10px 40px 40px 40px">
		<div class="innerOuter" style="padding: 0% 30% 0% 0%">
			<h2>게시글 작성</h2>
			<br>

			<form action="insertBoard" method="post" enctype="multipart/form-data">
				<div class="input-group mb-3">
					<span class="input-group-text">제목</span>
					<input type="text" class="form-control" id="title" name="title" required>
					<span class="input-group-text" style="margin-left:10px">작성자</span>
					<input type="text" class="form-control" style="background-color:white" value="${sessionScope.loginUser.id}" disabled>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text">이미지</span>
					<input type="file" class="form-control" style="padding-bottom: 0px; padding-top: 3px;" id="img" name="img">
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text">내용</span>
					<textarea type="text" class="form-control" rows="15" id="content" name="content" required></textarea>
				</div>
				<button type="submit" class="btn btn-primary">게시글 작성</button>
			</form>
			
		</div>
	</div>
	
	<!-- 푸터바 -->
	<jsp:include page="../common/footer.jsp" />

</body>
</html>