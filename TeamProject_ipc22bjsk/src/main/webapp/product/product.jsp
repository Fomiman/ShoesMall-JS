<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.*,vo.ProductTBL"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<title>상품 리스트 </title>
<style type="text/css">
	#listForm{
		max-width:95%;
		max-height:100%;
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

	#productImage{
		max-width: 150px;
		max-height: 150px;
		border: none;
	}
	@media (max-width: 768px) {
		.productListTD {
			padding: 0px;
		}
		
	}
</style>
</head>
<body>
<% 
int productPageNum = (int)request.getAttribute("productPageNum"); 
int MaxProductPageNum = (int)request.getAttribute("MaxProductPageNum"); 
%>

<div class="row" style="margin-bottom: 20px">
 <section id="listForm">
	<c:if test ="${productList != null }">
		<table class="productListTBL">
			<tr>
				<c:forEach var="productTBL" items="${productList }" varStatus="i">
					<td class="productListTD">
						<a href="productView.shoes?product_no=${productTBL.product_no}">
						<img src="images/${productTBL.product_image }" id="productImage" >
						</a><br>
						${productTBL.product_name}<br/>
						${productTBL.product_price}원<br/>
					</td>
					<input type="hidden" id="width-var" value="">
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

	<% if(productPageNum!=1) { %>
			<a href="productList.shoes?productPageNum=${productPageNum-1 }" class="btn btn-success btn-arraw-left">이전</a>
			<%} 
			if(productPageNum<MaxProductPageNum){%>
			<a href="productList.shoes?productPageNum=${productPageNum+1 }" class="btn btn-success btn-arraw-left">다음</a>
			<%} %>
</section> 
</div>
</body>
</html>
