<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<!-- 반응형 웹에 사용하는 메타태그 -->
<title>주문 상세보기</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">주문상세
							보기</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${oderDetail != null}">
						<tr>
							<td style="width: 20%;">주문번호</td>
							<td colspan="2">${oderDetail.post_subject}</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td colspan="2">${oderDetail.post_date }</td>
						</tr>
						<tr>
							<td>주소</td>
							<td colspan="2">${oderDetail.member_id }</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td colspan="2">${oderDetail.member_id }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td colspan="2">${oderDetail.member_id }</td>
						</tr>
						
						<!-- 여러상품 한번에 주문할때 여기 부분 반복으로 나타내기 -->
					<c:forEach var="detail" items="${oderDetail }" varStatus="status">
						<tr>
							<td>제품번호</td>
							<td colspan="2">${detail.member_id }</td>
						</tr>
						<tr>
							<td>주문수량</td>
							<td colspan="2" style="min-height: 200px; text-align: left;">
								<!-- 특수문자를 제대로 출력하기위해 & 악성스크립트를 방지하기위해 -->
								${detail.post_text }
							</td>
						</tr>
						<tr>
							<td>가격</td>
							<td colspan="2" style="min-height: 200px; text-align: left;">
								<!-- 특수문자를 제대로 출력하기위해 & 악성스크립트를 방지하기위해 -->
								${detail.post_text }
							</td>
						</tr>
					</c:forEach>	
						
					</c:if>
					
					<c:if test="${oderDetail == null}">
						<td colspan="3">주문 정보를 불러오지 못했습니다.</td>
					</c:if>
				</tbody>
			</table>
			<%-- <a href="update.jsp?bbsID=<%= %>" class="btn btn-primary">주문승인</a>
            <a href="deleteAction.jsp?bbsID=<%= %>" class="btn btn-primary">주문취소</a> --%>

			<a href="userBoard.usr" class="btn btn-primary">목록</a>
		</div>
	</div>
</body>
</html>
</body>
</html>