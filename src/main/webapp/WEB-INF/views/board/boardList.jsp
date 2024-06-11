<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<td>${one.boardNo}<input type="hidden"
					value="boardDetail?boardNo=${one.boardNo}"></td>
				<td>${one.title}</td>
				<td>${one.writer}</td>
				<td>${one.views}</td>
			</tr>
		</tbody>
	</c:forEach>
</table>

