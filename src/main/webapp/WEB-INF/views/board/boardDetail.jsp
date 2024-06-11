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
	<!-- 메뉴바 -->
	<jsp:include page="../common/menubar.jsp" />

	<div class="content" style="padding: 10px 40px 40px 40px">
		<div class="innerOuter" style="padding: 0% 30% 0% 0%">
			<h2>게시글 상세</h2>
			<br>

			<div class="input-group mb-3">
				<span class="input-group-text">제목</span>
				<input type="text" class="form-control" value="${boardDTO.title}" style="background-color: white" disabled>
				<span class="input-group-text" style="margin-left: 10px">작성자</span>
				<input type="text" class="form-control" value="${boardDTO.writer}" style="background-color: white" disabled>
			    <span class="input-group-text" style="margin-left: 10px">조회수</span>
				<input type="text" class="form-control" value="${boardDTO.views}" style="background-color: white" disabled>
			</div>
			<c:if test="${boardDTO.imgName != null}">
			<div class="input-group mb-3">
				<span class="input-group-text">이미지</span>
				<img src="${ pageContext.servletContext.contextPath }/resources/uploadFiles/${boardDTO.imgName}" width=300 height=300 style="border: 1px solid lightgray; padding: 15px;">
			</div>
			</c:if>
			<div class="input-group mb-3">
				<span class="input-group-text">내용</span>
				<textarea type="text" class="form-control" rows="15" style="background-color: white" disabled>${boardDTO.content}</textarea>
			</div>

			<a href="boardMain?page=1">
				<button class="btn btn-primary">게시글 목록</button>
			</a>&nbsp;
			
			<c:if test="${boardDTO.writer == sessionScope.loginUser.id}">
				<a href="updateForm">
					<button class="btn btn-primary">게시글 수정</button>
				</a>&nbsp;
				<a href="deleteBoard">
					<button class="btn btn-danger">게시글 삭제</button>
				</a>&nbsp;
			</c:if>
			
			
		</div>
	</div>

	<!-- 푸터바 -->
	<jsp:include page="../common/footer.jsp" />

</body>
</html>