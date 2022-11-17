<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.*,vo.ProductTBL"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<title>상품 리스트 </title>

<link rel="stylesheet" href="css/productPage.css">
</head>
<body>
<% 
int productPageNum = (int)request.getAttribute("productPageNum"); 
int MaxProductPageNum = (int)request.getAttribute("MaxProductPageNum"); 
String orderbySelect = (String)request.getAttribute("orderbySelect");
%>

 <section id="listForm">
 	<form action="productList.shoes" name="f" method="post">
	 	<div class="orderbyDIV">
	 		<select name="orderbySelect" id="orderbySelect" class="orderbySelect">
				<option value="default" ${orderbySelect eq "default" ? "selected" : ""}>정렬◈</option>
	 			<option value="new1" ${orderbySelect eq "new1" ? "selected" : ""}>최신순▼</option>
	 			<option value="new2" ${orderbySelect eq "new2" ? "selected" : ""}>최신순▲</option>
	 			<option value="price1" ${orderbySelect eq "price1" ? "selected" : ""}>가격순▼</option>
	 			<option value="price2" ${orderbySelect eq "price2" ? "selected" : ""}>가격순▲</option>
	 			<option value="name1" ${orderbySelect eq "name1" ? "selected" : ""}>이름순▼</option>
	 			<option value="name2" ${orderbySelect eq "name2" ? "selected" : ""}>이름순▲</option>
	 			<option value="size1" ${orderbySelect eq "name1" ? "selected" : ""}>사이즈순▼</option>
	 			<option value="size2" ${orderbySelect eq "name2" ? "selected" : ""}>사이즈순▲</option>
	 		</select>
	 		<input type="submit" name="orderbyBTN" class="orderbyBTN" value="정렬하기" />
	 	</div>
 	</form>
	<c:if test ="${productList != null }">
		<table class="productListTBL">
			<tr>
				<c:forEach var="productTBL"  items="${productList}" varStatus="i">
					<td class="productListTD">
					<div class="carbox">
						<a href="productView.shoes?product_no=${productTBL.product_no}">
						<img src="images/${productTBL.product_image }" id="productImage" >
						</a><br>
						상품명 : ${productTBL.product_name}<br/>
						사이즈 : ${productTBL.product_size}<br/>
						가격 : ${productTBL.product_price}원<br/>
						<c:if test="${productTBL.product_amount ne 0 }">
							재고 : ${productTBL.product_amount }개<br/>
						</c:if>
						<c:if test="${productTBL.product_amount eq 0 }">
							[품절]<br/>
						</c:if>
						</div>
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

			<div class="pageDIV">
				<ul class="pageUL" >
					<%if(productPageNum ==1 ) { %>
					<li class="pageUL_LI">
						<a href="#" class="btn btn-success" onclick="firstPage();">이전</a>
					</li>
					<% }else if(productPageNum!=1) { %>
					<li class="pageUL_LI">
						<a href="productList.shoes?productPageNum=${productPageNum-1 }&orderbySelect=${orderbySelect}" class="btn btn-success">이전</a>
					</li>
					<%} %>
					<c:forEach var="i" begin="1" end="${MaxProductPageNum }" step="1">
					<li class="pageUL_LI"><a href="productList.shoes?productPageNum=${i}&orderbySelect=${orderbySelect}">${i }</a> </li>
					</c:forEach>
					<%if(productPageNum<MaxProductPageNum){%>
					<li class="pageUL_LI">
						<a href="productList.shoes?productPageNum=${productPageNum+1 }&orderbySelect=${orderbySelect}" class="btn btn-success">다음</a>
					</li>
					<%}else if(productPageNum == MaxProductPageNum){%>
					<li class="pageUL_LI">
						<a href="#" class="btn btn-success" onclick="lastPage();">다음</a>
					</li>
					<%} %>
				</ul>
			</div>
</section> 

<script>//첫페이지, 마지막페이지 표시용
	function firstPage() {alert("첫 페이지입니다.");}
	function lastPage() {alert("마지막 페이지입니다.");}
</script>

</body>
</html>
