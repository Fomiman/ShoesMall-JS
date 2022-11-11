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

<style type="text/css">
 .noneBorderInput {
  border: none;
  background: transparent;
  text-align: center;
 }
</style>
</head>

<body>

		<div class="row">
		<form action="#" name="f" method="post">
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
					<c:if test="${detailList != null}">
					<c:forEach var="detail" items="${detailList }" begin="0" end="0" varStatus="status">
						<tr>
							<td style="width: 20%;">주문번호</td>
							<td colspan="2">${detail.order_id}</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td colspan="2">${detail.member_id }</td>
						</tr>
						<tr>
							<td>주소</td>
							<td colspan="2">${detail.address }</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td colspan="2">${detail.member_phone }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td colspan="2">${detail.member_email }</td>
						</tr>
						<tr>
							<td>주문처리 상태</td>
							<td colspan="2">
							<c:choose>
								<c:when test="${detail.order_status eq 0 }">[처리대기]</c:when>
								<c:when test="${detail.order_status eq 1 }">[승인]</c:when>
								<c:when test="${detail.order_status eq 2 }">[취소]</c:when>
								<c:otherwise>[주문 상태 오류 : DB에서 확인 바람]</c:otherwise>
							</c:choose>
							<input type="hidden" name="order_status" value="${detail.order_status }"/>
							</td>
						</tr>
						<!-- <tr><td colspan="3"></td></tr> -->
					</c:forEach>
						<!-- 여러상품 한번에 주문할때 여기 부분 반복으로 나타내기 -->
					<c:forEach var="detail" items="${detailList }" varStatus="status">
					<tr><th colspan="3" style="background-color: #eeeeee; text-align: center;">
					------------------주문 제품정보------------------</th></tr>
						<tr>
							<td>제품번호</td>
							<td colspan="2">
							<input type="text" name="product_no" value="${detail.product_no }" class="noneBorderInput" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>주문수량</td>
							<td colspan="2">
							<input type="text" name="order_amount" value="${detail.order_amount }" class="noneBorderInput" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>가격</td>
							<td colspan="2">${detail.order_price }</td>
						</tr>
						
					</c:forEach>	
						
					</c:if>
					
					<c:if test="${detailList == null}">
					<tr>
						<td colspan="3">주문 정보를 불러오지 못했습니다.</td>
					</tr>
					</c:if>
				</tbody>
			</table>
			<c:forEach var="detail" items="${detailList }" begin="0" end="0" varStatus="status">
            <input type="submit" formaction="updateOrder.mgr?order_id=${detail.order_id }" 
            value="주문승인" class="btn btn-primary"/>
            <!-- 주문취소 시 현재 주문처리 상태에 따라 재고 변동이 다르기 때문에 order_status 값을 포함하여 넘긴다. -->
            <input type="submit" formaction="cancelOrder.mgr?order_id=${detail.order_id }" 
            value="주문취소" class="btn btn-primary"/>
			</c:forEach>
			<a href="orderManagement.mgr" class="btn btn-primary">목록보기</a>
			</form>
		</div>
</body>
</html>