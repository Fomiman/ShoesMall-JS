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
<title>실시간 주문관리</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">주문번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제품번호</th>
						<th style="background-color: #eeeeee; text-align: center;">구매자</th>
						<th style="background-color: #eeeeee; text-align: center;">주문수량</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${orderList != null && orderList.size() > 0}">
						<!-- 1.order 메뉴목록이 있으면 -->
						<c:forEach var="order" items="${orderList}" varStatus="status">
							<!-- 행 시작  -->
							<tr>
								<td><a href="oderDetail.mgr?order_no=${order.post_no}">${order.post_subject }</a></td>
								<td>${order.post_no}</td>
								<td>${order.member_id }</td>
								<td>${order.post_date }</td>
							</tr>
							<!-- 행 끝 -->
						</c:forEach>
					</c:if>
					<c:if test="${orderList == null}">
						<!-- 2.order 메뉴목록이 없으면 -->
						<td colspan="4">등록된 게시글이 없습니다.</td>
					</c:if>
				</tbody>
			</table>

			<a href="userBoard.jsp" class="btn btn-success btn-arraw-left">이전</a>

			<a href="userBoard.jsp" class="btn btn-success btn-arraw-left">다음</a>
			
		</div>

	</div>

</body>
</html>