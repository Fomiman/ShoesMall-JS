<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/productView.css">
<title>상품정보 조회</title>
</head>
<body>


    <section id = "listForm">
				<div class="product col-md-4">
						<img id="item-display" src="images/${productView.product_image}"/></img>
					</div>
					
					<div class="service1-items col-sm-2 col-md-2 ">
						<a id="item-1" class="service1-item">
							<img src="images/${productView.product_image}"/></img>
						</a>
						<a id="item-2" class="service1-item">
							<img src="images/${productView.product_image}"/></img>
						</a>
						<a id="item-3" class="service1-item">
							<img src="images/${productView.product_image}"/></img>
						</a>
					</div>
		<section id = "content_right">
		<div class="product-title">${productView.product_name}</div>
					<div class="product-desc"><b>제품번호 : </b> ${productView.product_no}</div>
					<div class="product-desc"><b>상품명 : </b> ${productView.product_name}</div>
					<div class="product-desc"><b>수량 : </b> 
					<c:if test="${productView.product_amount ne 0}">${productView.product_amount}</c:if>
					<c:if test="${productView.product_amount eq 0}">[품절]</c:if>
					</div>
					<hr>
					<div class="product-price"><b>가격 : </b> ${productView.product_price}원</div>
					<div class="product-stock"><b>사이즈 : </b>${productView.product_size}</div>
					<div class="product-desc"><b>제품 설명 : </b> ${productView.product_decs}</div>
					<hr>
					<div style="clear:both"></div>
		<nav id = "commandList">
			<button type="button" class="btn btn-default"><a href="productList.shoes">쇼핑계속하기</a></button>
			<!--이때, 해당 개를 구분할 수 있도록 id값을 파라미터로 전송해야 한다.  -->
			<c:if test="${productView.product_amount ne 0}">
			<button type="button" class="btn btn-default"><a href="productCartAdd.shoes?product_no=${productView.product_no}">장바구니에담기</a></button>
			</c:if>
			<c:if test="${productView.product_amount eq 0}">
			<button type="button" class="btn btn-default">[품절]</button>
			</c:if>
			
		</nav>
		
		</section>
		
</section>
<br><br>
 
</body>
</html>