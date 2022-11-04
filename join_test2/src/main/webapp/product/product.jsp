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
		width:700px;
		height:500px;
		margin:auto;
	}
	h2{
		text-align:center;
	}
	
	table{
		margin:auto;
		width:550px;
	}

	.div_empty{
		background-color:red;
		width: 100%;
		height: 100%;
		text-align: center;
	}

	#todayImageList{
		text-align: center;
	}
	#productImage{
		width: 150px;
		height: 150px;
		border: none;
	}
	#todayImage{
		width: 100px;
		height: 100px;
		border: none;
	}
</style>
</head>
<body>
<%-- <section id="listForm">
	<c:if test ="${productList != null }">
		<table>
			<tr>
				<c:forEach var="productTBL" items="${productList }" varStatus="i">
					<td>
						<a href="productView.product?id=${productTBL.product_no}"><img src="images/${productTBL.product_image }" id="productImage" ></a>
						${productTBL.product_name}<br/>
						${productTBL.product_price}<br/>
					</td>
						<c:if test="${((i.index+1) mod 4)==0}">
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


</section> --%>
 <section id="listForm">
	<c:if test ="${productList != null }">
		<table>
			<tr>
				<c:forEach var="productTBL" items="${productList }" varStatus="i">
					<td>
						<%--  <c:if test="${fn:substring(productTBL.product_no, 0, 3+1) eq '1001' }">
							<% System.out.println("[DEBUG] if문 실행됨--check"); %>
							${productTBL.product_name}
						</c:if>  --%>
						<a href="productView.shoes?product_no=${productTBL.product_no}"><img src="images/${productTBL.product_image }" id="productImage" ></a>
						${productTBL.product_name}<br/>
						${productTBL.product_price}원<br/>
					</td>
					
					<c:if test="${((i.index+1) mod 4)==0}">
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
</body>
</html>