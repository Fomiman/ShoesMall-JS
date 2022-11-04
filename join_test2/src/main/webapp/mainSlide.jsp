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
	    			<img src="images/1111.jpg" height="600" width="1200"  style="max-height: 600px;">
	    		</div>
	    		<div class="item">
	    			<img src="images/2222.jpg" height="600" width="1200" style="max-height: 600px;">
	    		</div>
	    		<div class="item">
	    			<img src="images/3333.jpg" height="600" width="1200" style="max-height: 600px;">
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