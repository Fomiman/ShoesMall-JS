<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@page import="com.sun.org.apache.bcel.internal.generic.Select"%> --%>
       <%@page import="java.util.*"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.CartTBL" %>
<%@page import="vo.ProductTBL" %>
    <link rel="stylesheet" href="./css/bootstrap.css"/>
 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
<style type="text/css">
#listForm {
   width: 1200px;
   margin: auto;
   
}

h3 {
   text-align: left;
}

table {
   width: 1000px;
   margin: auto;
  
}
.table2{
 width: 1000px;
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
#todayImageList{
   text-align: center;
}
#productImage{
   width:100px;
   height:150px;
   border:none;
}
#cartImage{
   width:100px;
   height:100px;
   border:none;
}
#select{
	text-align: right;
}
#commandList{
	text-align: center;
}
.row {
background-color: #EAEAEA;
text-align : center;
}



</style>

</head>
<body>


<section id="listForm">

<c:if test="${sessionScope.productList != null && sessionScope.productList.size() > 0}">
   <h3>${sessionScope.member_id }님의 주문내역</h3>
   
<form method="post" action="#" name="f">

 <table>
        <tr class = "tr_top">
        	<td>
        		<!--전체 체크 박스 : 체크하면 모두 체크, 해지하면 모두 해지   -->
        		<input type="checkbox" name="allCheck" id ="allCheck"  onclick="checkAll(this.form)"/> 
        	</td>
             <td>번호</td><!-- 제품번호 추가해서 -->
             <td>상품 이미지</td>
             <td>상품명</td>
             <td>가격</td>
             <td>수량</td>
         </tr>

        <c:forEach var="product" items="${sessionScope.productList}" varStatus = "i">
        
        <tr>
        	<td>
        		<input type="checkbox" id="name" name="name" value="${product.product_name }"/>
        	</td>
             <td>
             
          	   ${i.index+1}<!-- 번호값계산 -->
            </td>
             <td>
            	 <img src = "images/${product.product_image }" id ="cartImage"/>
            </td>
             <td>
            	 ${product.product_name }
            </td>
             <td>
           	  ${product.product_price}원
            </td>
             <td>
            	 <br>
            	 ${product.product_amount } <!--현재 수량  -->
            	 <br>
         </tr>
       
        </c:forEach>
        <tr>
              <td colspan="7" style="text-align:right;">
           <h4> 총 금액 : ${sessionScope.totalMoney}원</h4>
         </td>
      </tr>
      </table>
     <%--  <button type="submit" class="btn btn-default" formaction="productCartOrder.shoes?totalmoney = ${totalMoney }">구매하기</button> --%>
	</form>
	
 </c:if>
 

			<hr class="one">

						<!-- 배송정보 -->
						<div class="orderArea">
							<div class="title">
								<h3>배송 정보</h3>
							
							</div>
							
			<c:forEach var="memberTBL" items="${memberList }" > 
							<!-- 2. 배송정보 -->
							<div class="table2">
								<table border="1">
									<colgroup>
										<col style="width: 139px;">
										<col style="width: auto;">
									</colgroup>
									<tbody class="">
										<tr>
											<th>주문자 아이디</th>
											<td> ${memberTBL.member_id }</td>
										</tr>

										<tr>
											<th>받으시는 분</th>
											<td>${memberTBL.member_name }</td>
										</tr>

										<tr>
											<th>주소 </th>
											<td><input type="text" name="address" placeholder="" size="6" maxlength="6"
												readonly="1" value="" >
												<a href="#none">우편번호</a> <br>
												<input type="text" name="address" laceholder="" size="40" readonly="1" value="" >
												<span  style="font-size: 12px;">기본주소</span> <br>
												<input type="text" name="address" placeholder="" size="40" value="" > 
												<span style="font-size: 12px;">나머지주소</span> 
												<span style="font-size: 12px;">(선택입력가능)</span></td>
										</tr>

										<tr>
											<th >휴대전화 
											<span> </span>
											</th>
											<td> ${memberTBL.member_phone}</td>
										</tr>

									</tbody>

									<!-- 이메일부분 -->
									<tbody>
										<tr>
											<th>이메일 </th>
											<td>${ memberTBL.member_email }
												<p class="gBlank5" style="font-size: 12px;">
													이메일을 통해 주문처리과정을 보내드립니다. <br> 이메일 주소란에는 반드시 수신가능한
													이메일주소를 입력해 주세요.
												</p></td>
										</tr>
									</tbody>

									<!-- 배송관련 정보 -->
									<tbody>
										<tr >
											<th>배송메시지 <span></span>
											</th>
											<td><textarea  name="omessage" maxlength="255" cols="70"> </textarea></td>
										</tr>
									</tbody>
								</table>
							</div>
							
							<br> <br> <br>  
					</c:forEach> 
 	</div>
 <br>
 
   <nav id="commandList">
   	<button type="button" class="btn btn-default">	<a href="#">주문하기</a></button>
   </nav>
<br>

</body>
</html>