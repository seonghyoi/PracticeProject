<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		
		$('.pages').click(function() {
			$.ajax({
				url : "boardList",
				data : {
					page : $(this).text()
				},
				success : function(result) { //결과가 담겨진 table부분코드
					$('#d1').html(result)
				},
				error : function() {
					alert('게시글 조회 실패')
				}
			}) //ajax
		})
		
		$('#d1').on('click', 'tr.clickable', function() {
			// 현재 tr 요소 내의 input 태그의 value 속성 가져오기
			var url = $(this).find('input').attr('value');
			// url이 존재하면 해당 URL로 이동
			if (url) {
				window.location.href = url;
			}
		});
		
	})
</script>


</head>
<body>
	<!-- 메뉴바 -->
	<jsp:include page="../common/menubar.jsp" />

	<div class="content" style="padding: 10px 40px 40px 40px; height: 800px;">
		<div class="innerOuter" style="padding: 0% 10% 0% 0%">
			<h2>자유 게시판</h2>
			전체 글: ${count}개 <br> <br>
			
			<c:if test="${ !empty sessionScope.loginUser }">
			<a href="insertForm">
				<button class="btn btn-primary float-right">게시글 작성</button>
			</a>
			</c:if>
			
			<br>

			<div id="d1">
				<br>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글 번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="one">
						<tbody>
							<tr class="clickable">
								<td>${one.boardNo}<input type="hidden" value="boardDetail?boardNo=${one.boardNo}"></td>
								<td>${one.title}</td>
								<td>${one.writer}</td>
								<td>${one.views}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
			<!-- d1 end -->

			<%
			int pages = (int) request.getAttribute("pages");
			for (int p = 1; p <= pages; p++) {
			%>
			<button class="pages"><%=p%></button>
			<%
			}
			%>


		</div>
	</div>


	<!-- 푸터바 -->
	<jsp:include page="../common/footer.jsp" />

</body>
</html>