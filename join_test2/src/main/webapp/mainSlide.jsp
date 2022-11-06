<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
    		<ol class="carousel-indicators">
	    		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	    		<li data-target="#myCarousel" data-slide-to="1"></li>
	    		<li data-target="#myCarousel" data-slide-to="2"></li>
    		</ol>
    		<div class="carousel-inner">
	    		<div class="item active">
	    			<img src="images/1111.jpg" class="slideImg" style="width: 1200px; max-height: 600px;">
	    		</div>
	    		<div class="item">
	    			<a href="productList.shoes"><img src="images/2222.jpg" class="slideImg" style="width: 1200px; max-height: 600px;"></a>
	    		</div>
	    		<div class="item">
	    			<a href="productList.shoes"><img src="images/3333.jpg" class="slideImg" style="width: 1200px; max-height: 600px;"></a>
	    		</div>
    		</div>
    		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
    			<span class="glyphicon glyphicon-chevron-left"></span>
    		</a>
    		<a class="right carousel-control" href="#myCarousel" data-slide="next">
    			<span class="glyphicon glyphicon-chevron-right"></span>
    		</a>
    	</div>
</body>
</html>