<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.*,vo.ProductTBL"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<title>상품 리스트 </title>
<style type="text/css">
	#listForm{
		max-width:700px;
		max-height:500px;
		margin: 0px auto;
	}
	h2{
		text-align:center;
	}
	
	.productListTBL{
		margin: 0px auto;
		max-width:550px;
	}
	
	.productListTD {
		padding: 40px;
	}

	.div_empty{
		background-color:red;
		max-width: 100%;
		max-height: 100%;
		text-align: center;
	}

	#todayImageList{
		text-align: center;
	}
	#productImage{
		max-width: 150px;
		max-height: 150px;
		border: none;
	}
	#todayImage{
		width: 100px;
		height: 100px;
		border: none;
	}
	@media (max-width: 768px) {
		.productListTD {
			padding: 0px;
		}
		
		.container {
		height:auto;
		}
	}
</style>
<script src="../js/jquery.js"></script>
<script>
if(matchMedia("screen and (max-width: 767px)").matches){ 
	  //화면 크기가 767px이하일때
	  console.log("mobile");
	}
</script>
</head>
<body>
<div class="container" style="height: auto; max-width: 100%;">
 <section id="listForm">
	<c:if test ="${productList != null }">
		<table class="productListTBL">
			<tr>
				<c:forEach var="productTBL" items="${productList }" varStatus="i">
					<td class="productListTD">
						<%--  <c:if test="${fn:substring(productTBL.product_no, 0, 3+1) eq '1001' }">
							<% System.out.println("[DEBUG] if문 실행됨--check"); %>
							${productTBL.product_name}
						</c:if>  --%>
						<a href="productView.shoes?product_no=${productTBL.product_no}"><img src="images/${productTBL.product_image }" id="productImage" ></a><br>
						${productTBL.product_name}<br/>
						${productTBL.product_price}원<br/>
					</td>
					
					<c:if test="${((i.index+1) mod 3)==0}">
						</tr>
						<tr>
					</c:if>	
					
				</c:forEach>
			</tr>
		</table>
	</c:if>

<c:if test="${productList == null }"> 
		<div class="div_empty">신발이 없습니다.</div>
	</c:if>


</section> 
</div>
</body>
</html>