<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>

<%@page import="vo.CartTBL"%>
<%@page import="vo.ProductTBL"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width", initial-scale="1" >
<title>장바구니 목록</title>
<style type="text/css">
#listForm {
		max-width:95%;
		max-height:100%;
		margin: 0px auto;
}

h2 {
	text-align: center;
}

table {
	width: 90%;
	margin: auto;
}

.tr_top {
	background-color: #EAEAEA;
}

.div_empty {
	text-align: center;
	background-color:
}

.td_command {
	text-align: right;
}

#todayImageList {
	text-align: center;
}

#productImage {
	width: 100px;
	height: 150px;
	border: none;
}

#cartImage {
	width: 100px;
	height: 100px;
	border: none;
}

#select {
	text-align: right;
}

#commandList {
	text-align: center;
}

#upImage {
	width: 15px;
}

#downImage {
	width: 15px;
}
</style>
<script>
	function checkAll(theForm) {
		if (theForm.remove.length == undefined) {
			theForm.remove.checked = theForm.allCheck.checked;
		} else {
			for (var i = 0; i < theForm.remove.length; i++) {
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}

	function checkQtyUp(product_no) {
		location.href = "productCartQtyUp.shoes?product_no="
				+ encodeURIComponent(product_no);
	}
	function checkQtyDown(product_no, product_amount) {
		if (product_amount != 1) {//현재 수량이 1이 아니면 (즉 2이상이면)
			location.href = "productCartQtyDown.shoes?product_no="
					+ encodeURIComponent(product_no);
		}
	}
</script>
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">
							<div class="row">
								<div class="col-xs-6">
									<h5>
										<span class="glyphicon glyphicon-shopping-cart"></span>
										Shopping Cart
									</h5>
								</div>

							</div>
						</div>
					</div>

				</div>
				
<!-- *********************************************************************** -->
	<c:if test="${startMoney != null }">
		<c:set var="startMoney" value="${startMoney}"></c:set>
	</c:if>

	<c:if test="${endMoney !=null }">
		<c:set var="endMoney" value="${endMoney}"></c:set>
	</c:if>

	<section id="listForm">

		
			<!-- <h2>장바구니 목록</h2> -->

			<form method="post" action="#" name="f">

				<table>
					<tr id="select">
						<td colspan="8">
						<select id="startMoney" name="startMoney">
								<option value="0">=최하=</option>
								<option value="40000">40000</option>
								<option value="50000">50000</option>
								<option value="60000">60000</option>
								<option value="70000">70000</option>
								<option value="80000">80000</option>
								<option value="90000">90000</option>
						</select> 
						<select id="endMoney" name="endMoney">
								<option value="999999">=최고=</option>
								<option value="40000">40000</option>
								<option value="50000">50000</option>
								<option value="60000">60000</option>
								<option value="70000">70000</option>
								<option value="80000">80000</option>
								<option value="90000">90000</option>
						</select> <!--[검색]버튼을 클릭하면 '최하가격과~최고가격으로 장바구니 항목을 이 가격으로 다시 검색하는 요청'  --> 
						<input type="submit" value="검색" formaction="productCartSearch.shoes" />
						</td>
					</tr>
					<!-- 가격별 검색부분 처리(끝)----------------------------------- -->


					<tr class="tr_top">
						<td>
							<!--전체 체크 박스 : 체크하면 모두 체크, 해지하면 모두 해지   --> <input
							type="checkbox" name="allCheck" id="allCheck"
							onclick="checkAll(this.form)" />
						</td>
						<td>번호</td>
						<!-- 제품번호 추가해서 -->
						<td>상품 이미지</td>
						<td>제품번호</td>
						<td>상품명</td>
						<td>가격</td>
						<td>수량</td>
						<td>제품삭제</td>
					</tr>
				<c:if test="${cartList !=null && cartList.size()>0 }">
					<c:forEach var="cartTBL" items="${cartList }" varStatus="i">

						<tr>
							<td><input type="checkbox" id="remove" name="remove" value="${cartTBL.product_name }" /></td>
							<td>${i.index+1}<!-- 번호값계산 --> </td>
							<td><img src="images/${cartTBL.product_image }" id="cartImage" /></td>
							<td>${cartTBL.product_no }</td>
							<td>${cartTBL.product_name }</td>
							<td>${cartTBL.product_price}원</td>
							<td>
								<!--▲ 클릭시 : 장바구니 항목의 수량 증가 요청 (이때, kind값을 파라미터로 전송)  --> 
								<a href="javascript:checkQtyUp('${cartTBL.product_no}')"> <!-- 문자는 '' 항상 신경 -->
									<img src="images/up.jpg" id="upImage" border="0" /> 
								</a> <br> 
								${cartTBL.product_amount } <!--현재 수량  --> <br> 
								<!--▼ 클릭시 : 장바구니 항목의 수량 감소 요청 (이때, 'kind값'과 '현재수량'을 파라미터로 전송) '현재수량'전송이유? 수량이 최소 2이상인 것만 감소가 가능하므로...--> 
								<a href="javascript:checkQtyDown('${cartTBL.product_no}',${cartTBL.product_amount})"> <!-- 숫자는 ''안써도됨 --> 
									<img src="images/down.jpg" id="downImage" border=0 />
								</a>
							<td colspan="5" style="text-align: center;">
								<input class="btn btn-default" type="submit" value="삭제" formaction="productCartRemove.shoes" />
							</td>
						</tr>

					</c:forEach>
					</c:if>
					<%-- <tr>
						<td colspan="8" style="text-align: right;">
							<h4>총 금액 : ${totalMoney}원</h4>
						</td>
					</tr>
					</c:if>
					<!--------------------- 장바구니에 담긴 것 없을때 ------------------------------------------  -->
					<c:if test="${cartList == null }">
						<tr>
							<td colspan="8">
								<section class="div_empty">장바구니가 비어있습니다</section>
							</td>
						</tr>
					</c:if> --%>
				</table>
				<!-- **************************************** -->
				<div class="panel-footer">
						<div class="row text-center">
							<div class="col-xs-9">
								<h4 class="text-right">
									총 금액 : <strong>${totalMoney}원</strong>
								</h4>
							</div>
							<nav id="commandList">
								<input type="submit" class="btn btn-default" value="쇼핑 계속하기"
									formaction="productList.shoes"> 
									<input type="submit" class="btn btn-default" value="구매하기"
									formaction="productCartOrder.shoes?totalMoney=${totalMoney}">
							</nav>
						</div>
					</div>
				<!-- **************************************** -->
				<!-- 하단 버튼  -->
				<%-- <nav id="commandList">
					<input type="submit" class="btn btn-default" value="쇼핑 계속하기"
						formaction="productList.shoes"> 
					<input type="submit" class="btn btn-default" value="구매하기"
						formaction="productCartOrder.shoes?totalMoney=${totalMoney}">
				</nav> --%>
			</form>


		
		<!------------------------------------------------------------------------------------------------  -->
	</section>
	<br>
	
	
		</div>
		</div>
	</div>
</body>
</html>