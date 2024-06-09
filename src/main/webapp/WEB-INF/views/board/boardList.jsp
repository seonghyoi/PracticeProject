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
	
<!-- ajax로 보내줄 때도, 만약 보내주는 데이터에 script로 funtion이 걸려 있다면 Main에 있더라도 똑같이 작성해야 하는 것 같다. -->
<script>
	$(document).ready(function() {
		// 각 tr 요소에 클릭 이벤트 추가
		$('table').on('click', 'tr.clickable', function() {
			// 현재 tr 요소 내의 a 태그 href 속성 가져오기
			var url = $(this).find('input').attr('value');
			// url이 존재하면 해당 URL로 이동
			if (url) {
				window.location.href = url;
			}
		});
	});
</script>
	
</head>
<body>
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
</body>
</html>