<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >  <!-- 반응형 웹에 사용하는 메타태그 -->

<title>상품정보 조회</title>
<style type="text/css">
	#listForm{
		width:750px;
		margin:auto;
		margin-bottom: 20px;
	}
	h2{
		text-align:center;
	}
	img{
		width: 280px;
		height: 280px;
		border: none;
	}
	#content_main{
		height:300px;
	}
	#content_left{
		width: 300px;
		float:left;
	}
	#content_right{
		width: 340px;
		float:left;
	}
	#commandList{
		text-align: center;
	}
	#desc{
		height:170px;
		background: #F2F2F2;
	}
</style>
</head>
<body>

<section id = "listForm">
<h2>${productView.product_name}</h2><!--request 안에드가잇는 객체  -->

	<section id="content_main">
		<section id = "content_left">
			<img src="images/${productView.product_image}"/>
		</section>
		<section id = "content_right">
			<b>제품번호 : </b> ${productView.product_no}<br>
			<b>상품명 : </b> ${productView.product_name}<br>
			<b>남은갯수 : </b> ${productView.product_amount}<br>
			<b>가격 : </b> ${productView.product_price}원<br>
			<b>사이즈 : </b>${productView.product_size}<br><br>
			
			<p id="desc">
			<b>내용 : </b> ${productView.product_decs}<br>
			</p>
		</section>
		
		</section>
		<div style="clear:both"></div>
		<nav id = "commandList">
			<button type="button" class="btn btn-default"><a href="productList.shoes">쇼핑계속하기</a></button>
			<!--이때, 해당 개를 구분할 수 있도록 id값을 파라미터로 전송해야 한다.  -->
			<button type="button" class="btn btn-default"><a href="productCartAdd.shoes?product_no=${productView.product_no}">장바구니에담기</a></button>
		</nav>
	
</section>
   
 
</body>
</html>