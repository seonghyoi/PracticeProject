<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<jsp:include page="common/menubar.jsp"/>

	<div class="content" style="padding: 10px 40px 40px 40px; height: 500px; text-align: center;">
	
		<h2>어서오세요!</h2>
		
		<hr color="black" style="width: 95%;">
		
		<a href="member/member">
			<button  class="btn btn-primary">회원CRUD페이지로</button>
		</a>
		<a href="board/bbs">
			<button  class="btn btn-primary"">게시판CRUD페이지로</button>
		</a>
	
		
	</div>
	
	<jsp:include page="common/footer.jsp"/>

</body>

</html>