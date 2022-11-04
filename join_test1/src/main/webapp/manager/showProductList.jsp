<%@page import="org.apache.catalina.User"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.NamingException"%>
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
<title>관리자용 상품목록</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">제품사진</th>
						<th style="background-color: #eeeeee; text-align: center;">제품번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제조사</th>
						<th style="background-color: #eeeeee; text-align: center;">재고수량</th>
						<th style="background-color: #eeeeee; text-align: center;"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${productList != null && productList.size() > 0}">
						<!-- 1.order 메뉴목록이 있으면 -->
						<c:forEach var="list" items="${productList}" varStatus="status">
							<!-- 행 시작  -->
							
							<tr>
								<td style="vertical-align: middle; width: 40%; height: 100%"><img src="../images/${list.product_image }" style="max-width: 30%; margin: 0px auto;" alt="${list.product_image }" onclick="location.href='showProductDetail.mgr?product_no=${list.product_no}';"></td>
								<td style="vertical-align: middle;">${list.product_no}</td>
								<td style="vertical-align: middle;">${list.category_code }</td>
								<td style="vertical-align: middle;">${list.product_amount }</td>
								<td style="vertical-align: middle;"><input type="button" value="제품상세" onclick="location.href='showProductDetail.mgr?product_no=${list.product_no}';"></td>
							</tr>
							<!-- 행 끝 -->
						</c:forEach>
					</c:if>
					<c:if test="${productList == null}">
						<!-- 2.order 메뉴목록이 없으면 -->
						<td colspan="4">상품 목록을 불러오지 못했습니다.</td>
					</c:if>
				</tbody>
			</table>

			<a href="showProductList.mgr" class="btn btn-success btn-arraw-left">이전</a>

			<a href="showProductList.mgr" class="btn btn-success btn-arraw-left">다음</a>
			
		</div>

	</div>

</body>
</html>