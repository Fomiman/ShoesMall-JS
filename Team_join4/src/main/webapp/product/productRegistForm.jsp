<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->

<title>Insert title here</title>
<style type="text/css">
   #registForm{
      width: 500px;
      height: 550px;
      margin:auto; 
   }   
   h2{
      text-align: center;
   }
   table{
      margin:auto;
      width: 450px;
      }
   .td_left{
      width: 150px;
      background:gray;
   }
   .td_right{
      width: 300px;
      background:black;
   }
   #commandCell{
      text-align: center;
      
   }
</style>
</head>
<body>
<%@ include file="../head_nav.jsp" %>

<section id = "registForm">
   <header>
      <h2>신발정보등록</h2>
   </header>
      <form action="productRegist.shoes" method="post" name = "writeForm" enctype="multipart/form-data"><!--파일 넣을땐 post  -->
      
   <table>
   <tr>
      <td colspan="2">
         <a href="productList.shoes">목록보기</a>
      </td>
    
   </tr>
   
   <tr>
      <th class = "td_left">
         <label for = "product_no">제품번호 : </label>
      </th>
      <td class = "td_right">
      <!--장바구니에서 품종(kind)으로 구분하여 사용하기 위해  -->
         <input type = "text" name = "product_no" id ="product_no" required="required"/>
      </td>
   </tr>
   
   <tr>
      <th class = "td_left">
         <label for = "category_code">카테고리: </label>
      </th>
      <td class = "td_right">
         <input type = "text" name = "category_code" id ="category_code" required="required"/>
      </td>
   </tr>
   
   <tr>
      <th class = "td_left">
         <label for = "product_name">신발이름 : </label>
      </th>
      <td class = "td_right">
         <input type = "text" name = "product_name" id ="product_name" required="required"/>
      </td>
   </tr>
   <tr>
      <th class = "td_left">
         <label for = "product_size">신발사이즈 : </label>
      </th>
      <td class = "td_right">
         <input type = "text" name = "product_size" id ="product_size"/>
      </td>
   </tr>
   <tr>
      <th class = "td_left">
         <label for = "product_amount">재고수량: </label>
      </th>
      <td class = "td_right">
         <input type = "text" name = "product_amount" id ="product_amount"/>
      </td>
   </tr>
   
   <tr>
      <th class = "td_left">
         <label for = "product_decs">설명 : </label>
      </th>
      <td class = "td_right">
         <textarea name="product_decs" id="product_decs" rows="13" cols="40" wrap="off"></textarea><!--  wrap="off"(자동줄바꿈안한다) -->
      </td>
   </tr>
   <tr>
      <th class = "td_left">
         <label for = "product_image">상품이미지 : </label>
      </th>
      <td class = "td_right">
         <input type = "file" name = "product_image" id ="product_image" required="required"/>
      </td>
   </tr>
   <tr>
      <td colspan="2" id = "commandCell"> 
         <input type = "submit" value = "신발상품등록"/>      
         <input type = "reset" value = "다시작성"/>      
         <input type = "button" value = "신발목록보기" onclick="window.location.href='productList.shoes'"/>      
      </td>
   </tr>   
   </table>
   </form>
   
</section>
<%@ include file="../footer.jsp" %>
   
   

</body>
</html>