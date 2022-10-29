<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<!-- 반응형 웹에 사용하는 메타태그 -->
<title>게시판</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">게시판 글
							보기</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${showPost != null}">
						<tr>
							<td style="width: 20%;">글 제목</td>
							<td colspan="2">${showPost.post_subject}</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="2">${showPost.member_id }</td>
						</tr>
						<tr>
							<td>작성일자</td>
							<td colspan="2">${showPost.post_date }</td>
						</tr>
						<tr>
							<td>내용</td>
							<td colspan="2" style="min-height: 200px; text-align: left;">
								<!-- 특수문자를 제대로 출력하기위해 & 악성스크립트를 방지하기위해 -->
								${showPost.post_text }
							</td>
						</tr>
					</c:if>
					<c:if test="${showPost == null}">
						<td colspan="3">post 정보를 불러오지 못했습니다.</td>
					</c:if>
				</tbody>
			</table>
			<a href="userBoard.usr" class="btn btn-primary">목록</a>
			<%--  <a href="update.jsp?bbsID=<%= %>" class="btn btn-primary">수정</a>
            <a href="deleteAction.jsp?bbsID=<%= %>" class="btn btn-primary">삭제</a> --%>

		</div>
	</div>
</body>
</html>
</body>
</html>