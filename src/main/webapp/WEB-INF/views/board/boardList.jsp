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
</head>
<body>
	<div id="d1">
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>No.</th>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="one">
				<tbody>
					<tr class="clickable">
						<td>${one.rownum}</td>
						<td>${one.boardNo}</td>
						<td><a href="boardDetail?boardNo=${one.boardNo}">${one.title}</a></td>
						<td>${one.writer}</td>
						<td>${one.views}</td>
					</tr>

				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>