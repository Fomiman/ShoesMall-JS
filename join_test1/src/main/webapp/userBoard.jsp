<%@page import="org.apache.catalina.User"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="dao.User_boardDAO"%>
<%@page import="vo.User_board"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>게시판</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${boardList != null && boardList.size() > 0}">
						<!-- 1.board 메뉴목록이 있으면 -->
						<c:forEach var="board" items="${boardList}" varStatus="status">
							<!-- 행 시작  -->
							<tr>
								<td>${board.post_no}</td>
								<td><a href="showPost.usr?post_no=${board.post_no}">${board.post_subject }</a></td>
								<td>${board.member_id }</td>
								<td>${board.post_date }</td>
							</tr>
							<!-- 행 끝 -->
						</c:forEach>
					</c:if>
					<c:if test="${boardList == null}">
						<!-- 2.board 메뉴목록이 없으면 -->
						<td colspan="4">등록된 게시글이 없습니다.</td>
					</c:if>
				</tbody>
			</table>

			<a href="userBoard.jsp" class="btn btn-success btn-arraw-left">이전</a>

			<a href="userBoard.jsp" class="btn btn-success btn-arraw-left">다음</a>
			<%
			String member_id = null;
			if (session.getAttribute("member_id") != null) {
				member_id = (String) session.getAttribute("member_id");
			}
			if (member_id == null) {
			%>
			<a href="userLogin.usr" class="btn btn-primary pull-right">로그인 후 글쓰기</a>
			<%
			} else {
			%>
			<a href="userBoardWrite.usr" class="btn btn-primary pull-right">글쓰기</a>
			<%
			}
			%>
		</div>

	</div>

</body>
</html>