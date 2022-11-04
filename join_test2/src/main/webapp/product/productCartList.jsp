<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
       <%@page import="java.util.*"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>

<%@page import="vo.CartTBL" %>
<%@page import="vo.ProductTBL" %>

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

h2 {
   text-align: center;
}

table {
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
#upImage{
	width: 15px;
}
#downImage{
	width: 15px;
}

</style>
<script>
	function checkAll(theForm){
		if(theForm.remove.length == undefined){ 
			theForm.remove.checked = theForm.allCheck.checked; 
		}else{
			for(var i=0;i<theForm.remove.length;i++){
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}
	
	function checkQtyUp(product_no){ 
			location.href="productCartQtyUp.shoes?product_no="+ encodeURIComponent(product_no);
	}
	function checkQtyDown(product_no,product_amount){
		if(product_amount != 1){//현재 수량이 1이 아니면 (즉 2이상이면)
			location.href="productCartQtyDown.shoes?product_no="+ encodeURIComponent(product_no);
		}
	}
</script>
</head>
<body>
<c:if test="${startMoney != null }">
	<c:set var="startMoney" value="${startMoney}"></c:set>
</c:if>

<c:if test="${endMoney !=null }">
	<c:set var="endMoney" value="${endMoney}"></c:set>
</c:if>

<section id="listForm">

<c:if test="${cartList !=null && cartList.size()>0 }">
   <h2>장바구니 목록</h2>
   
<form method="post" action="#" name="f">

 <table>
    	<tr id="select">
    		<td colspan="7">
    		<select id = "startMoney" name="startMoney">
    			<option>=최하=</option>
    			<c:choose>
    				<c:when test="${startMoney==50000 }">
    					<option selected="selected">10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${startMoney==60000 }">
    					<option>10000</option>
    					<option selected="selected">20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${startMoney==70000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option selected="selected">30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${startMoney==80000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option selected="selected">40000</option>
    				</c:when>
    				<c:otherwise>
    					<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
    					<option>40000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		
    		<select id = "endMoney" name="endMoney">
    			<option>=최고=</option>
    			<c:choose>
    				<c:when test="${endMoney==50000 }">
    				<option selected="selected">10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${endMoney==60000 }">
    				<option>10000</option>
    					<option selected="selected">20000</option>
    					<option>30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${endMoney==70000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option selected="selected">30000</option>
	    				<option>40000</option>
    				</c:when>
    				<c:when test="${endMoney==80000 }">
    					<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
	    				<option selected="selected">40000</option>
    				</c:when>
    				<c:otherwise>
    						<option>10000</option>
    					<option>20000</option>
    					<option>30000</option>
    					<option>40000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<!--[검색]버튼을 클릭하면 '최하가격과~최고가격으로 장바구니 항목을 이 가격으로 다시 검색하는 요청'  -->
    		<input type="submit" value="검색" formaction="productCartSearch.shoes"/>
    		</td>
    	</tr>
    	<!-- 가격별 검색부분 처리(끝)----------------------------------- -->
    	
    	
        <tr class = "tr_top">
        	<td>
        		<!--전체 체크 박스 : 체크하면 모두 체크, 해지하면 모두 해지   -->
        		<input type="checkbox" name="allCheck" id ="allCheck"  onclick="checkAll(this.form)"/> 
        	</td>
             <td>번호</td><!-- 제품번호 추가해서 -->
             <td>상품 이미지</td>
             <td>제품번호</td>
             <td>상품명</td>
             <td>가격</td>
             <td>수량</td>
             <td>제품삭제</td>
         </tr>

        <c:forEach var="cartTBL" items="${cartList }" varStatus="i">
        
        <tr>
        	<td>
        		<input type="checkbox" id="remove" name="remove" value="${cartTBL.product_name }"/>
        	</td>
             <td>
             
          	   ${i.index+1}<!-- 번호값계산 -->
            </td>
             <td>
            	 <img src = "images/${cartTBL.product_image }" id ="cartImage"/>
            </td>
            <td>
            	 ${cartTBL.product_no }
            </td>
             <td>
            	 ${cartTBL.product_name }
            </td>
             <td>
           	  ${cartTBL.product_price}원
            </td>
             <td>
             	<!--▲ 클릭시 : 장바구니 항목의 수량 증가 요청 (이때, kind값을 파라미터로 전송)  -->
            	 <a href="javascript:checkQtyUp('${cartTBL.product_no}')"> <!-- 문자는 '' 항상 신경 -->
            		 <img src="images/up.jpg" id = "upImage" border="0"/>
            	 </a>
            	 <br>
            	 
            	 ${cartTBL.product_amount } <!--현재 수량  -->
            	 <br>
            	 
            	 <!--▼ 클릭시 : 장바구니 항목의 수량 감소 요청 (이때, 'kind값'과 '현재수량'을 파라미터로 전송) 
            	  '현재수량'전송이유? 수량이 최소 2이상인 것만 감소가 가능하므로...-->
            	 <a href="javascript:checkQtyDown('${cartTBL.product_no}',${cartTBL.product_amount})"> <!-- 숫자는 ''안써도됨 -->
            	 <img src="images/down.jpg" id = "downImage" border=0/>
             </a>
           
      
         <td colspan="5" style="text-align:center;">
         	<input class="btn btn-default" type="submit" value="삭제" formaction="productCartRemove.shoes"/>
         </td>
      
         </tr>
       
        </c:forEach>
        <br>
        <tr>
              <td colspan="7" style="text-align:right;">
           <h4> 총 금액 : ${totalMoney}원</h4>
         </td>
      </tr>
      </table>
     <%--  <button type="submit" class="btn btn-default" formaction="productCartOrder.shoes?totalmoney = ${totalMoney }">구매하기</button> --%>
	</form>
	
 </c:if>

<!-----------------------------------------------------------------------------------------  -->	
	<c:if test="${cartList == null }">
      <section class="div_empty">장바구니가 비어있습니다</section>
	</c:if>
<!------------------------------------------------------------------------------------------------  -->	
   <nav id="commandList">
   	<button type="button" class="btn btn-default">	<a href="productList.shoes">쇼핑 계속하기</a></button>
    <button type="button" class="btn btn-default"><a href ="productCartOrder.shoes?totalmoney = ${totalMoney }">구매하기</a></button>
   </nav>
</section>
<br>
</body>
</html>